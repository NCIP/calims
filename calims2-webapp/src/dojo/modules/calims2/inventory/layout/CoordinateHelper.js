dojo.provide("calims2.inventory.layout.CoordinateHelper");

dojo.declare(
  "calims2.inventory.layout.CoordinateHelper",
  null,
  {
    // Pattern map for the various label types specified in word
    // This needs to be updated in synch with the LayoutLabelType enumeration 
    patterns : { "ALL_LOWER_CASE" : "^[a-z]*$" , "ALL_UPPER_CASE" : "^[A-Z]*$" , "DIGITS" : "^[0-9]*$"},
    // Converts a given label into the corresponding integer coordinate according to the label type. 
    // The given label is assumed to be valid for the label type
    // labelType The type of label
    // value the value to convert
    // returns the integer coordinate corresponding to the given value
    getCoordinateValue : function(labelType, value) {
      var regexp = new RegExp("^\S*$");
      if (regexp.test(value)) {
        return 0;
      }
      switch (labelType) {
        case "DIGITS": {
          return parseInt(value, 10) - 1;
        }
        case "ALL_LOWER_CASE": {
          return this.convertString("a", value);
        }
        case "ALL_UPPER_CASE": {
          return this.convertString("A", value);
        }
      }
    },
    
    // Converts a given label into the corresponding integer coordinate for the alphabetic label types. 
    // firstCharacter the first character in the range
    // value the value to convert
    // returns the integer coordinate corresponding to the given value
    convertString : function(firstCharacter, value) {
      var firstCode = firstCharacter.charCodeAt(0);
      var result = 0;
      for (var i = 0; i < value.length; i++) {
        result = result * 26 + value.charCodeAt(i) - firstCode;
      }
      return result;
    },
    
    // Validates a given label
    // labelType The type of label
    // maximum The maximum number of values in the dimension
    // The label to validate
    // True if the given label is valid according to the label type and maximum.
    validateCoordinate : function(labelType, maximum, value) {
      var regexp = new RegExp(this.patterns[labelType]);
      if (regexp.test(value)) {
        var coordinate = this.getCoordinateValue(labelType, value);
        if (coordinate < maximum) {
          return true;
        }
      }
      return false;
    },
    
    // Convert the given coordinate into the corresponding label according to the label type and maximum 
    // labelType The type of label
    // maximum The maximum number of values in the dimension
    // value The coordinate to convert to a label
    getCoordinateString : function(labelType, maximum, value) {
      switch (labelType) {
        case "DIGITS": {
          var result = "" + (value + 1);
          while (result.length < 2) {
            result = "0" + result;
          }
          return result;
        }
        case "ALL_LOWER_CASE": {
          return this.convertValue("a", maximum, value);
        }
        case "ALL_UPPER_CASE": {
          return this.convertValue("A", maximum, value);
        }
      }
    },
    
    // firstCharacter the first character in the range
    // maximum The maximum number of values in the dimension
    // value the value to convert
    convertValue : function(firstCharacter, maximum, value) {
      var length = Math.floor(Math.log(maximum) / Math.log(26)) + 1;
      var result = "";
      if (value == 0) {
        for (var i = 0; i < length; i++) {
          result += firstCharacter;
        }  
        return result;
      }
      var firstCharacterCode = firstCharacter.charCodeAt(0);
      var remaining = value;
      while (remaining > 0) {
        result = String.fromCharCode(firstCharacterCode + remaining % 26) + result;
        remaining = Math.floor(remaining/26);
      }
      while (result.length < length) {
        result = firstCharacter + result;
      }
      return result;
    },
    // Gets the maximum possible suffix length for a layout
    getMaximumSuffixLength : function(layout) {
      return 1 + this.getMaximumLength(layout.labelX, parseInt(layout.x, 10)) + 
                 this.getMaximumLength(layout.labelY, parseInt(layout.y, 10));
    },
    // Gets the maximum length of a label
    // labelType The type of label
    // maximum The maximum number of values in the dimension
    getMaximumLength : function(labelType, maximum) {
      if (labelType == "DIGITS") {
        var length = Math.floor(Math.log(maximum) / Math.log(10)) + 1;
        return (length > 1) ? length : 2;
      }
      return Math.floor(Math.log(maximum) / Math.log(26)) + 1;
    }  
  }
  );