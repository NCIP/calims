/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.namingconvention;

import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;

/**
 * @author viseem
 *
 */
public class NamingConventionHelperMockup implements NamingConventionHelper {
  
  private NamingConventionType typeParam;

  /**
   * {@inheritDoc}
   */
  public String getNamingConventions(NamingConventionType type) {
    typeParam = type;
    return "NamingConvention";
  }

  /**
   * @return the typeParam
   */
  public NamingConventionType getTypeParam() {
    return typeParam;
  }

}
