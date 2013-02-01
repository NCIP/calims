/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The caLIMS2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This caLIMS2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the caLIMS2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the caLIMS2 Software; (ii) distribute and 
 * have distributed to and by third parties the caLIMS2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.nih.nci.calims2.business.generic;

import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import gov.nih.nci.calims2.business.util.validation.ConstraintViolationImpl;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.Validator;
import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * This class implements the GenericService interface and represents a set of methods for operating on GenericBeans.
 * 
 * @author connollym@moxieinformatics.com
 * @param <T> GenericService
 */
public class GenericServiceImpl<T extends EntityWithId> implements GenericService<T> {
  
  private String allowedQueryNamePrefix;
  private CRUDEventListener<T> crudEventListener;
  private GenericDao genericDao;
  private Validator<T> validator;

  /**
   * {@inheritDoc}
   */
  public T createDefault(Class<T> clazz) {
    try {
      T entity = clazz.newInstance();
      entity = crudEventListener.afterCreateDefault(entity);
      return entity;
    } catch (InstantiationException e) {
      throw new InternalError("Cannot happen.");
    } catch (IllegalAccessException e) {
      throw new InternalError("Cannot happen.");
    }
  }

  /**
   * {@inheritDoc}
   */
  public T create(T entity) throws ValidationException {
    validator.validate(entity, ValidationOperation.CREATE);
    T savedEntity = genericDao.create(crudEventListener.beforeCreate(entity));
    crudEventListener.afterCreate(entity, savedEntity);
    return savedEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T copy(T entity) {
    return crudEventListener.beforeCopy(entity);
  }

  /**
   * {@inheritDoc}
   */

  @SuppressWarnings("unchecked")
  public T update(T entity) throws ValidationException {
    validator.validate(entity, ValidationOperation.UPDATE);
    T existingEntity = genericDao.findById((Class<T>) entity.getClass(), entity.getId());
    if (existingEntity == null) {
      ConstraintViolation<T> violation = new ConstraintViolationImpl(entity.getClass(), GenericViolation.ORIGINAL_NOT_FOUND);
      throw new ValidationException(violation);
    }
    T updatedEntity = genericDao.update(crudEventListener.beforeUpdate(entity, existingEntity));
    crudEventListener.afterUpdate(updatedEntity);
    return updatedEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T delete(Class<T> clazz, Long id) throws ValidationException {
    T existingEntity = genericDao.findById(clazz, id);
    if (existingEntity == null) {
      ConstraintViolation<T> violation = new ConstraintViolationImpl<T>(clazz, GenericViolation.ORIGINAL_NOT_FOUND);
      throw new ValidationException(violation);
    }
    validator.validate(existingEntity, ValidationOperation.DELETE);
    crudEventListener.beforeDelete(existingEntity);
    genericDao.delete(existingEntity);
    crudEventListener.afterDelete(existingEntity);
    return existingEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T findById(Class<T> clazz, Long id) {
    return genericDao.findById(clazz, id);
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findAll(Class<T> clazz, String orderByClause) {
    return genericDao.findAll(clazz, orderByClause);
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    checkQueryName(queryName);
    return (T) genericDao.findEntityByNamedQuery(queryName, parameterValues);
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    checkQueryName(queryName);
    return genericDao.findByNamedQuery(queryName, parameterValues);
  }

  /**
   * Checks if a queryName is allowed.
   * 
   * @param queryName The queryName to check.
   */
  private void checkQueryName(String queryName) {
    if (queryName == null || !queryName.startsWith(allowedQueryNamePrefix)) {
      throw new IllegalArgumentException("Query not allowed in this service");
    }
  }

  /**
   * @param allowedQueryNamePrefix the allowedQueryNamePrefix to set
   */
  public void setAllowedQueryNamePrefix(String allowedQueryNamePrefix) {
    this.allowedQueryNamePrefix = allowedQueryNamePrefix;
  }

  /**
   * @param crudEventListener the crudEventListener to set
   */
  public void setCrudEventListener(CRUDEventListener<T> crudEventListener) {
    this.crudEventListener = crudEventListener;
  }

  /**
   * @return the genericDao
   */
  protected GenericDao getGenericDao() {
    return genericDao;
  }

  /**
   * @param genericDao the genericDao to set
   */
  public void setGenericDao(GenericDao genericDao) {
    this.genericDao = genericDao;
  }

  /**
   * @param validator the validator to set
   */
  public void setValidator(Validator<T> validator) {
    this.validator = validator;
  }
}