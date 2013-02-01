<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script>

dojo.addOnLoad(function() {
    var telephoneNumbers = dijit.byId("value");
    
    // onChange of the categories
    dojo.connect(telephoneNumbers, "onChange", function(newValue) {
      var pattern = /^(\d{3})[-/ .]?(\d{3})[-/ .]?(\d{4})$/;
      if (pattern.test(newValue)) {
        var groups = newValue.match(pattern);
        var result = groups[1] + "-" + groups[2] + "-" + groups[3];
        var telephoneNumbers = dijit.byId("value");
        telephoneNumbers.setValue(result);
      } 
    });
  });
  
</ct:script>