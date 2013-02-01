/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2-private02
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2-private02 Software License (the License) is between NCI and You. You (or 
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
 * its rights in the calims2-private02 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2-private02 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2-private02 Software and any 
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
package gov.nih.nci.calims2.ui.inventory.container;

import java.io.Serializable;
import java.util.List;

import gov.nih.nci.calims2.business.inventory.container.CopySpecification;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.inventory.Container;

/**
 * @author viseem
 * 
 */
public class ContainerCopyForm implements Serializable {
  
  private static final long serialVersionUID = -1997869230880211686L;
  
  private List<String> basename;
  private String coordinateX;
  private String coordinateY;
  private String currentView;
  private String displayName;
  private Long id;
  private Long locationId;
  private Location location;
  private Long parentContainerId;
  private Container parentContainer;
  
  /**
   * Gets the copy specification object from the form. The coordinate object is not filled.
   * @return the copy specification object from the form.
   */
  public CopySpecification getSpecification() {
    CopySpecification specification = new CopySpecification();
    specification.setBaseNames(basename);
    if (locationId != null && locationId > 0) {
      specification.setLocationId(locationId);
    }
    if (parentContainerId != null && parentContainerId > 0) {
      specification.setParentContainerId(parentContainerId);
    }
    specification.setTemplateId(id);
    return specification;
  }

  /**
   * @return the basename
   */
  public List<String> getBasename() {
    return basename;
  }

  /**
   * @param basename the basename to set
   */
  public void setBasename(List<String> basename) {
    this.basename = basename;
  }

  /**
   * @return the coordinateX
   */
  public String getCoordinateX() {
    return coordinateX;
  }

  /**
   * @param coordinateX the coordinateX to set
   */
  public void setCoordinateX(String coordinateX) {
    this.coordinateX = coordinateX;
  }

  /**
   * @return the coordinateY
   */
  public String getCoordinateY() {
    return coordinateY;
  }

  /**
   * @param coordinateY the coordinateY to set
   */
  public void setCoordinateY(String coordinateY) {
    this.coordinateY = coordinateY;
  }

  /**
   * @param currentView the currentView to set
   */
  public void setCurrentView(String currentView) {
    this.currentView = currentView;
  }

  /**
   * @return the currentView
   */
  public String getCurrentView() {
    return currentView;
  }

  /**
   * @return the displayName
   */
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
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the locationId
   */
  public Long getLocationId() {
    return locationId;
  }

  /**
   * @param locationId the locationId to set
   */
  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  /**
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * @return the parentContainerId
   */
  public Long getParentContainerId() {
    return parentContainerId;
  }

  /**
   * @param parentContainerId the parentContainerId to set
   */
  public void setParentContainerId(Long parentContainerId) {
    this.parentContainerId = parentContainerId;
  }

  /**
   * @return the parentContainer
   */
  public Container getParentContainer() {
    return parentContainer;
  }

  /**
   * @param parentContainer the parentContainer to set
   */
  public void setParentContainer(Container parentContainer) {
    this.parentContainer = parentContainer;
  }
}
