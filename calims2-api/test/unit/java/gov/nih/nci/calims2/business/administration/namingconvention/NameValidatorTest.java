/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.namingconvention;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;

/**
 * @author viseem
 *
 */
public class NameValidatorTest {
  
  private NameValidator validator;
  private GenericDaoMockup genericDao;
  
  /**
   * Test the getNamingConvention method for an empty naming convention result.
   */
  @Test
  public void testGetNamingConventionEmpty() {
    createValidator();
    genericDao.setResult(new ArrayList<NamingConvention>());
    NamingConvention result = validator.getNamingConvention(1L, NamingConventionType.EQUIPMENTNAME);
    assertNull("No naming convention should be returned", result);
    checkfindByNamedQueryCall();
  }
  
  /**
   * Test the getNamingConvention method for a single naming convention result.
   */
  @Test
  public void testGetNamingConventionSingle() {
    createValidator();
    List<NamingConvention> namingCoventions = new ArrayList<NamingConvention>();
    NamingConvention nc1 = new NamingConvention();
    namingCoventions.add(nc1);
    genericDao.setResult(namingCoventions);
    NamingConvention result = validator.getNamingConvention(1L, NamingConventionType.EQUIPMENTNAME);
    assertEquals("Wrong naming convention returned", nc1, result);
    checkfindByNamedQueryCall();
  }
  
  /**
   * Test the getNamingConvention method for a multiple naming convention result.
   */
  @Test
  public void testGetNamingConventionMultiple() {
    createValidator();
    List<NamingConvention> namingCoventions = new ArrayList<NamingConvention>();
    NamingConvention nc1 = new NamingConvention();
    namingCoventions.add(nc1);
    NamingConvention nc2 = new NamingConvention();
    Laboratory laboratory = new Laboratory();
    laboratory.setId(1L);
    nc2.setLaboratory(laboratory);
    namingCoventions.add(nc2);
    genericDao.setResult(namingCoventions);
    NamingConvention result = validator.getNamingConvention(1L, NamingConventionType.EQUIPMENTNAME);
    assertEquals("Wrong naming convention returned", nc2, result);
    checkfindByNamedQueryCall();
  }
  
  private void createValidator() {
    validator = new NameValidator();
    genericDao = new GenericDaoMockup();
    validator.setGenericDao(genericDao);
  }
  
  /**
   * Check the call to the findByNamedQuery.
   */
  private void checkfindByNamedQueryCall() {
    String queryName = NamingConvention.class.getName() + ".findByLaboratoryIdAndType";
    assertEquals("Wrong query name returned", queryName, genericDao.getQueryName());
    Map<String, Object> params = genericDao.getParameterValues();
    assertNotNull("No parameters passed to the query", params);
    assertEquals("Wrong number of parameters", 2, params.size());
    assertEquals("Wrong laboratoryId", new Long(1), params.get("laboratoryId"));
    assertEquals("Wrong Type", NamingConventionType.EQUIPMENTNAME, params.get("type"));
  }

}
