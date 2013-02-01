dependencies = {
  layers: [
    {
      name: "../calims2/base.js",
      dependencies: [
       "dojo.data.ItemFileReadStore",
       "dojo.parser",              
       "dijit.dijit", 
       "dijit.form.Button",
       "dijit.form.CheckBox",
       "dijit.form.DateTextBox",
       "dijit.form.FilteringSelect",
       "dijit.form.Form",
       "dijit.form.MultiSelect",
       "dijit.form.NumberTextBox",
       "dijit.form.RadioButton",
       "dijit.form.Textarea",
       "dijit.form.TimeTextBox",
       "dijit.form.ValidationTextBox",
       "dijit.layout.ContentPane",
       "dijit.layout.LayoutContainer",
       "dijit.layout.TabContainer",
       "dijit.Menu",
       "dijit.MenuItem",
       "dijit.MenuBar",
       "dijit.MenuBarItem",
       "dijit.PopupMenuBarItem",
       "dijit.PopupMenuItem"
      ]
   },
   {
     name: "../calims2/listPage.js",
     layerDependencies: ["../calims2/base.js"],
     dependencies: [
      "dijit.Dialog", 
      "dojox.grid.DataGrid",
      "dojox.widget.PlaceholderMenuItem"
     ]
  },
  {
    name: "../calims2/inventory/layout/layout.js",
    layerDependencies: ["../calims2/base.js"],
    dependencies: [
     "dojo.dnd.Source",              
     "calims2.inventory.layout.ContainerGrid",              
     "calims2.inventory.layout.CoordinateHelper"
    ]
  },
  {
    name: "../calims2/inventory/specimen/specimen.js",
    layerDependencies: ["../calims2/base.js"],
    dependencies: [
     "calims2.inventory.specimen.SpecimenForm"              
    ]
  }
  ],
  prefixes: [
    [ "dijit", "../dijit" ],
    [ "dojox", "../dojox" ],
    [ "calims2", "../../modules/calims2" ]
  ]
}
