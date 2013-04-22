/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor.form;

/**
 * @author viseem
 *
 */
public class SingleSelectField extends BaseField {
  
  private static final long serialVersionUID = 8182086844912713073L;
  
  private String collectionType = "ENTITIES";
  private String optionCreatorCallback;
  private String options;
  private String properties;
  private String selected;
  private boolean useDataStore;

  /**
   * @return the collectionType
   */
  public String getCollectionType() {
    return collectionType;
  }

  /**
   * @param collectionType the collectionType to set
   */
  public void setCollectionType(String collectionType) {
    this.collectionType = collectionType;
  }

  /**
   * @return the optionCreatorCallback
   */
  public String getOptionCreatorCallback() {
    return optionCreatorCallback;
  }

  /**
   * @param optionCreatorCallback the optionCreatorCallback to set
   */
  public void setOptionCreatorCallback(String optionCreatorCallback) {
    this.optionCreatorCallback = optionCreatorCallback;
  }

  /**
   * @return the options
   */
  public String getOptions() {
    return options;
  }

  /**
   * @param options the options to set
   */
  public void setOptions(String options) {
    this.options = options;
  }

  /**
   * @return the properties
   */
  public String getProperties() {
    return properties;
  }

  /**
   * @param properties the properties to set
   */
  public void setProperties(String properties) {
    this.properties = properties;
  }

  /**
   * @return the selected
   */
  public String getSelected() {
    return selected;
  }

  /**
   * @param selected the selected to set
   */
  public void setSelected(String selected) {
    this.selected = selected;
  }

  /**
   * @return the useDataStore
   */
  public boolean getUseDataStore() {
    return useDataStore;
  }

  /**
   * @param useDataStore the useDataStore to set
   */
  public void setUseDataStore(boolean useDataStore) {
    this.useDataStore = useDataStore;
  }

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.SINGLE_SELECT;
  }
  
  /**
   * {@inheritDoc}
   */
  public SingleSelectField clone() {
    return (SingleSelectField) super.clone();
  }
}
