/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.dojo;

/**
 * @author viseem
 *
 */
public enum DojoType {
  /** dojo.data.ItemFileReadStore. */
  DOJO_DATA_ITEM_FILE_READ_STORE("dojo.data.ItemFileReadStore"),
  /** dijit.form.Button. */
  DIJIT_FORM_BUTTON("dijit.form.Button"),
  
  /** dijit.form.CheckBox. */
  DIJIT_FORM_CHECKBOX("dijit.form.CheckBox"),
  
  /** dijit.form.Form. */
  DIJIT_FORM_FORM("dijit.form.Form"),
  
  /** dijit.form.DateTextBox. */
  DIJIT_FORM_DATE_TEXTBOX("dijit.form.DateTextBox"),
  
  /** dijit.form.FilteringSelect. */
  DIJIT_FORM_FILTERINGSELECT("dijit.form.FilteringSelect"),
  
  /** dijit.form.MultiSelect. */
  DIJIT_FORM_MULTISELECT("dijit.form.MultiSelect"),
  
  /** dijit.form.NumberTextBox. */
  DIJIT_FORM_NUMBER_TEXTBOX("dijit.form.NumberTextBox"),
  
  /** dijit.form.RadioButton. */
  DIJIT_FORM_RADIO_BUTTON("dijit.form.RadioButton"),
  
  /** dijit.form.Textarea. */
  DIJIT_FORM_TEXTAREA("dijit.form.Textarea"),
  
  /** dijit.form.TimeTextBox. */
  DIJIT_FORM_TIME_TEXTBOX("dijit.form.TimeTextBox"),
  
  /** dijit.form.ValidationTextBox. */
  DIJIT_FORM_VALIDATION_TEXTBOX("dijit.form.ValidationTextBox"),
  
  /** dijit.Menu. */
  DIJIT_MENU("dijit.Menu"),
  
  /** dijit.MenuBar. */
  DIJIT_MENUBAR("dijit.MenuBar"), 
  
  /** dijit.MenuBarItem. */
  DIJIT_MENUBARITEM("dijit.MenuBarItem"), 
  
  /** dijit.MenuItem. */
  DIJIT_MENUITEM("dijit.MenuItem"), 
  
  /** dijit.PopupMenuBarItem. */
  DIJIT_POPUP_MENUBARITEM("dijit.PopupMenuBarItem"), 
  
  /** dijit.PopupMenuItem. */
  DIJIT_POPUP_MENUITEM("dijit.PopupMenuItem");

  private String typeName;

  /**
   * Constructor.
   * 
   * @param typeName The type name to use as the dojoType attribute
   */
  DojoType(String typeName) {
    this.typeName = typeName;
  }

  /**
   * @return the typeName
   */
  public String getTypeName() {
    return typeName;
  }

}
