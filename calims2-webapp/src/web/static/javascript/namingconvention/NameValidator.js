
var nameValidator = {
    // Pattern map for the various character sets specified in word
	// Tis needs to be updated in synch with the CharacterSet enumeration	
    patterns : { "ALL_LOWER_CASE" : "[a-z]*$" , "ALL_UPPER_CASE" : "[A-Z]*$" , "MIXED_CASE" : "[a-zA-Z]*$", "DIGITS" : "[0-9]*$"},
    
    // Gets the naming convention that applies to the laboratory with the given id.
    // namingConventionMap The map of naming convention objects
    // laboratoryId The id of the laboratory
    getNamingConvention : function(namingConventionMap, laboratoryId) {
      if (laboratoryId) {
        var result = namingConventionMap[laboratoryId];
        if (result) {
          return result;
        } else {
          return namingConventionMap["global"];
        }  
      } else {
        return namingConventionMap["global"];
      }
    },
    
    // test all the possible violations for the given input (min length, max length and character set)
    // input The input to test (the substring corresponding to the word)
    // word the word to test
    // return true if any violation is found
    testAll : function(input, word) {
      return this.testMinLength(input, word) || this.testMaxLength(input, word) || this.testCharset(input, word);
    },
    
    // test the character set violation
    // input The input to test (the substring corresponding to the word)
    // word the word to test
    // return true if a character set violation is found
    testCharset : function(input, word) {
      var pattern = "^";
      if (word.padCharacter && word.padCharacter.length > 0) {
        pattern += word.padCharacter + "*";
      }
      pattern += this.patterns[word.characterSet];
      var regexp = new RegExp(pattern);
      return !regexp.test(input);
    },
    
    // test the minimum length set violation
    // input The input to test (the substring corresponding to the word)
    // word the word to test
    // return true if a minimum length set violation is found
    testMinLength : function(input, word) {
      return word.minLength && input.length < word.minLength;
    },
    
    // test the maximum length set violation
    // input The input to test (the substring corresponding to the word)
    // word the word to test
    // return true if a maximum length set violation is found
    testMaxLength : function(input, word) {
      return word.maxLength && input.length > word.maxLength;
    },
    
    // Validates an input using the given naming convention.
    // namingConvention The naming convention to use
    // input the input to validate
    validate : function(namingConvention, input) {
      if (!input || (namingConvention.maxLength && input.length > namingConvention.maxLength)) {
        return false;
      }
      var words = namingConvention.words; 
      var toValidate = input;
      for (var i = 0; i < words.length; i++) {
        var word = words[i];
        var wordToValidate = null;
        if (word.delimiter) {
          var pos = toValidate.indexOf(word.delimiter);
          if (pos < 0) {
            return false;
          }
          wordToValidate = toValidate.substring(0, pos);
          toValidate = toValidate.substring(pos + word.delimiter.length);
        } else {
          wordToValidate = toValidate;
          toValidate = "";
        }
        if (this.testAll(wordToValidate, word)) {
          return false;
        }
      }
      return true;
    },
    // Validates an input using the given naming convention map.
    // namingConventionMap The map of naming convention objects
    // input the input to validate
    // laboratoryId the laboratory id
    validateInput : function(namingConventionMap, input, laboratoryId) {
      var result = true;
      if (laboratoryId && laboratoryId != "-1") {
        var namingConvention = this.getNamingConvention(namingConventionMap, laboratoryId);
        if (namingConvention) {
          result = this.validate(namingConvention, input);
        }
      } else {
        result = false;
      }
      return result;
    },  
    // Validates an input using the given naming convention map.
    // namingConventionMap The map of naming convention objects
    // inputId the id of the dijit widget containing the input to validate
    // labId the id of the dijit widget containing containing the laboratory id
    validateName : function(namingConventionMap, inputId, labId) {
      var input = dijit.byId(inputId).getValue();
      var laboratoryId = dijit.byId(labId).getValue();
      return this.validateInput(namingConventionMap, input, laboratoryId);
    }
  };  