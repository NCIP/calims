/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
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
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
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
package gov.nih.nci.calims2.domain.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Helper class for manipulation of Entity with Id
 * 
 * @author viseem
 * 
 */
public class EntityWithIdHelper {

  /**
   * Creates an empty entity with the given id.
   * 
   * @param <T> The type of entity processed.
   * @param clazz The Class of entity to create
   * @param id The selected id to set on the new entity.
   * @return The new entity with the given id set or null if no id was given or if the id was not positive.
   */
  public static <T extends EntityWithId> T createEntity(Class<T> clazz, Long id) {
    if (id != null && id > 0) {
      try {
        T newEntity = clazz.newInstance();
        newEntity.setId(id);
        return newEntity;
      } catch (InstantiationException e) {
        throw new InternalError("Can not happen - EntityWithId classes are concrete classes");
      } catch (IllegalAccessException e) {
        throw new InternalError("Can not happen - EntityWithId classes have a public contructor");
      }
    }
    return null;
  }

  /**
   * Creates a set of empty entities with the given ids.
   * 
   * @param <T> The type of entity processed.
   * @param clazz The Class of entities to creates
   * @param ids The array of ids to set on the new entities.
   * @return The set of new entities with the given ids (Non positive ids are ignored).
   */
  public static <T extends EntityWithId> Set<T> createEntities(Class<T> clazz, Long[] ids) {
    Set<T> result = new HashSet<T>();
    if (ids != null) {
      for (Long id : ids) {
        if (id > 0) {
          result.add(EntityWithIdHelper.createEntity(clazz, id));
        }
      }
    }
    return result;
  }

  /**
   * Generates a List of Ids from a collection of entities.
   * 
   * @param <T> The type of entities in the collection
   * @param entities The collection of readable entities from which the ids are extracted
   * @return A List of the ids in the given collection in the same order as the given collection if ordering is relevant
   */
  public static <T extends EntityWithId> List<Long> toEntityIdsList(Collection<T> entities) {
    List<Long> ids = new ArrayList<Long>(entities.size());
    for (T e : entities) {
      ids.add(e.getId());
    }
    return ids;
  }

  /**
   * Generates a Set of Ids from a collection of entities.
   * 
   * @param <T> The type of entities in the collection
   * @param entities The collection of readable entities from which the ids are extracted
   * @return A Set of the ids in the given collection
   */
  public static <T extends EntityWithId> Set<Long> toEntityIdsSet(Collection<T> entities) {
    Set<Long> ids = new HashSet<Long>(entities.size());
    for (T e : entities) {
      ids.add(e.getId());
    }
    return ids;
  }

  /**
   * Generates an array of Ids from a collection of entities.
   * 
   * @param <T> The type of entities in the collection
   * @param entities The collection of readable entities from which the ids are extracted
   * @return An array of the ids in the given collection in the same order as the given collection if ordering is relevant
   */
  public static <T extends EntityWithId> Long[] toEntityIdsArray(Collection<T> entities) {
    Long[] ids = new Long[entities.size()];
    int i = 0;
    for (T e : entities) {
      ids[i++] = e.getId();
    }
    return ids;
  }
  
  /**
   * Converts a collection of entities to a map where the keys are the entity ids.
   * 
   * @param <T> The type of entities in the collection
   * @param entities The collection of readable entities from which the ids are extracted
   * @return A Map containing all the given entities and where the keys are the entity ids.
   */
  public static <T extends EntityWithId> Map<Long, T> toEntityMap(Collection<T> entities) {
    Map<Long, T> map = new HashMap<Long, T>();
    for (T entity : entities) {
      map.put(entity.getId(), entity);
    }
    return map;
  }

}
