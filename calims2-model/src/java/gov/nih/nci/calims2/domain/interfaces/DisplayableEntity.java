package gov.nih.nci.calims2.domain.interfaces;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;

/**
 * Default implementation of Displayable interface.
 * 
 * To be extended by all displayable persistent classes.
 * */
@MappedSuperclass
public class DisplayableEntity extends AuditableEntity implements Displayable {

  private static final long serialVersionUID = 9101908067896030882L;

  private String description;
  private String displayName;
  private String name;

  /**
   * @return the description
   */
  @Column(name = "DESCRIPTION", length = 500)
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the displayName
   */
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.interfaces.displayName}")
  @Column(name = "DISPLAYNAME", length = EntityWithId.COLUMNLENGTH, nullable = false)
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @param displayName the displayName to set
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   * @return the name
   */
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.interfaces.name}")
  @Column(name = "NAME", length = EntityWithId.COLUMNLENGTH, nullable = false)
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

}
