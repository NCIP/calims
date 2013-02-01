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
package gov.nih.nci.calims2.ui.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author connollym
 * @param <T> The type of entity to process
 * 
 */
public class GenericServiceMockup<T extends EntityWithId> implements GenericService<T> {
  
  private boolean throwsExceptions;

  private Class<T> createDefaultClass;
  private T createDefaultResult;
  private T createResult;
  private T updateResult;
  private Class<T> deleteClass;
  private Long deleteId;
  private T deleteResult;
  private Class<T> findByIdClass;
  private Long findByIdId;
  private T findByIdResult;
  private Class<T> findAllClass;
  private String findAllOrderByClause;
  private List<T> findAllResult;
  
  
  private String findByQueryName;
  private Map<String, Object> findByQueryNameParameterValues;
  private List<T> findByQueryNameResult;
  
  private T relatedEntity;
  
  /**
   * {@inheritDoc}
   */
  public T createDefault(Class<T> clazz) {
    createDefaultClass = clazz;
    createDefaultResult = createEntityWithId(clazz);
    return createDefaultResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T copy(T entity)  {
    createResult = entity;
    return createResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T create(T entity) throws ValidationException {
    createResult = entity;
    if (throwsExceptions) {
      throw new ValidationException();
    }
    return createResult;
  }

  /**
   * {@inheritDoc}
   */
  public T update(T entity) throws ValidationException {
    updateResult = entity;
    if (throwsExceptions) {
      throw new ValidationException();
    }
    return updateResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T delete(Class<T> clazz, Long id) throws ValidationException {
    deleteClass = clazz;
    deleteId = id;
    if (throwsExceptions) {
      throw new ValidationException();
    }
    return deleteResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T findById(Class<T> clazz, Long id) {
    findByIdClass = clazz;
    findByIdId = id;
    findByIdResult = createEntityWithId(clazz);
    findByIdResult.setId(id);
    return findByIdResult;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findAll(Class<T> clazz, String orderBy) {
    findAllClass = clazz;
    findAllOrderByClause = orderBy;
    findAllResult = new ArrayList<T>();
    //findAllResult.add(createEntityWithId(clazz));
    return findAllResult;
  }

  /**
   * {@inheritDoc}
   */
  public T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    findByQueryName = queryName;
    findByQueryNameParameterValues = parameterValues;
    
    findByQueryNameResult = new ArrayList<T>();
    if (queryName.equals("gov.nih.nci.calims2.domain.administration.Organization.findByName")) {
      try {
        relatedEntity = (T) Organization.class.newInstance();
        findByQueryNameResult.add(relatedEntity);
      } catch (InstantiationException e) {
        throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
      } catch (IllegalAccessException e) {
        throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
      }
    }
    return findByQueryNameResult;
  }

  /**
   * @param throwsExceptions the throwsExceptions to set
   */
  public void setThrowsExceptions(boolean throwsExceptions) {
    this.throwsExceptions = throwsExceptions;
  }

  /**
   * @return the createDefaultClass
   */
  public Class<T> getCreateDefaultClass() {
    return createDefaultClass;
  }

  /**
   * @return the createDefaultResult
   */
  public T getCreateDefaultResult() {
    return createDefaultResult;
  }

  /**
   * @return the createResult
   */
  public T getCreateResult() {
    return createResult;
  }

  /**
   * @return the updateResult
   */
  public T getUpdateResult() {
    return updateResult;
  }
  
  /**
   * @return the deleteClass
   */
  public Class<T> getDeleteClass() {
    return deleteClass;
  }

  /**
   * @return the deleteId
   */
  public Long getDeleteId() {
    return deleteId;
  }
  
  /**
   * @return the deleteResult
   */
  public T getDeleteResult() {
    return deleteResult;
  }

  /**
   * @param deleteResult the deleteResult to set
   */
  public void setDeleteResult(T deleteResult) {
    this.deleteResult = deleteResult;
  }
  
  /**
   * @return the findByIdClass
   */
  public Class<T> getFindByIdClass() {
    return findByIdClass;
  }
  
  /**
   * @return the findByIdId
   */
  public Long getFindByIdId() {
    return findByIdId;
  }

  /**
   * @return the findByIdResult
   */
  public T getFindByIdResult() {
    return findByIdResult;
  }

  /**
   * @return the findAllClass
   */
  public Class<T> getFindAllClass() {
    return findAllClass;
  }

  /**
   * @return the findAllOrderByClause
   */
  public String getFindAllOrderByClause() {
    return findAllOrderByClause;
  }

  /**
   * @return the findAllResult
   */
  public List<T> getFindAllResult() {
    return findAllResult;
  }
  

  /**
   * @return the relatedEntity
   */
  public T getRelatedEntity() {
    return relatedEntity;
  }

  private T createEntityWithId(Class<T> clazz) {
    try {
      T result = clazz.newInstance();
      result.setId(1L);
      return result;
    } catch (InstantiationException e) {
      throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
    } catch (IllegalAccessException e) {
      throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
    }
  }

  /**
   * @return the findByQueryName
   */
  public String getFindByQueryName() {
    return findByQueryName;
  }

  /**
   * @return the findByQueryNameParameterValues
   */
  public Map<String, Object> getFindByQueryNameParameterValues() {
    return findByQueryNameParameterValues;
  }

  /**
   * @return the findByQueryNameResult
   */
  public List<T> getFindByQueryNameResult() {
    return findByQueryNameResult;
  }
  
}
