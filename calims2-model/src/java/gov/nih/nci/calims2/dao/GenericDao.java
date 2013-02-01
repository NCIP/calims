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
package gov.nih.nci.calims2.dao;

import java.util.List;
import java.util.Map;


/**
 * @author viseem@moxieinformatics.com
 */
public interface GenericDao {
  
  /**
   * save a new instance of the persistent class handled by the DAO.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param entity the object to save.
   * @return the newly saved object.
   */
  <T> T create(T entity);

  /**
   * update a previously saved instance of the persistent class handled by the DAO.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param entity the object to update. this should be an instance of the persistent class handled by the DAO.
   * @return the updated object.
   */
  <T> T update(T entity);

  /**
   * Deletes the given entity.
   * 
   * @param <T> The type of the persistent object to delete.
   * @param entity the entity to delete.
   * @return the deleted object.
   */
  <T> T delete(T entity);

  /**
   * Returns an instance of the persistence class managed by the DAO, given its id, without locking it.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param clazz The actual class of the persistent object to retrieve.
   * @param id of the instance we are looking for.
   * @return the instance with that id or null if not found.
   */
  <T> T findById(Class<T> clazz, Long id);
  
  /**
   * Retrieves all the objects of a given persistent class, ordered according to the given orderByClause.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param clazz The actual class of the persistent objects to retrieve.
   * @param orderByClause The optional order by clause for ordering the result.
   * @return All the objects of the given class ordered by the given orderByClause
   */
  <T> List<T> findAll(Class<T> clazz, String orderByClause);
  
  /**
   * Retrieves an object using a named query.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param queryName The name of the query
   * @param parameterValues The map of parameter values. Keys are the parameter names
   * @return The List of objects found
   */
  <T> T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues);
  
  /**
   * Retrieves a collection of objects using a named query.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param queryName The name of the query
   * @param parameterValues The map of parameter values. Keys are the parameter names
   * @return The List of objects found
   */
  <T> List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues);
  
  /**
   * Retrieves a collection of objects using a given HQL query.
   * @param <T> The type of the persistent object to retrieve.
   * @param query The HQL query to execute
   * @param parameterValues The map of parameter values. Keys are the parameter names
   * @return The List of objects found
   */
  <T> List<T> findByHQLQuery(String query, Map<String, Object> parameterValues);
  
  /**
   * Gets the next value of the given sequence.
   * @param sequenceName The name of the sequence
   * @return The next value of the sequence
   */
  long getNextValue(String sequenceName); 
}
