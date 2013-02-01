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
package gov.nih.nci.calims2.business.util.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.validation.ConstraintViolation;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class ValidationException extends Exception {
  
/**
 * 
 */
private static final long serialVersionUID = 1L;

private static final String DEFAULT_MESSAGE = "Validation Exception";
  
 
  
  @SuppressWarnings("unchecked")
  private Collection violations;
  /**
   * Constructs a new ValidationException with a default detail message.
   */
  public ValidationException() {
    
    this(DEFAULT_MESSAGE);
  }

  /**
   * Constructs a new ValidationException with the specified detail message.
   * @param message the detail message.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(String message) {
    this(message, null, (Collection<ConstraintViolation <T>>) null);
  }

  /**
   * Constructs a new ValidationException with a default detail message and the given list of violations.
   * @param violations the list of violations that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(Collection<ConstraintViolation <T>> violations) {
    this(DEFAULT_MESSAGE, null, violations);
  }
  
  /**
   * Constructs a new ValidationException with a default detail message and the given violation.
   * @param violation the violation that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(ConstraintViolation<T> violation) {
    this(DEFAULT_MESSAGE, null, violation);
  }

  /**
   * Constructs a new ValidationException with the specified detail message and the given list of violations.
   * @param message the detail message.
   * @param violation the violation that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(String message, ConstraintViolation<T> violation) {
    this(message, null, violation);
  }

  /**
   * Constructs a new ValidationException with the specified detail message, cause and
   * list of violations.
   * @param message the detail message.
   * @param cause the cause
   * @param violations the list of violations that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(String message, Throwable cause, Collection<ConstraintViolation<T>> violations) {
    super(message, cause);
    this.violations = violations;
  }
  
  /**
   * Constructs a new ValidationException with the specified detail message, cause and
   * list of violations.
   * @param message the detail message.
   * @param cause the cause
   * @param violation the violation that have been detected.
   * @param <T> Type of ValidatonException
   */
  @SuppressWarnings("unchecked")
  public <T>ValidationException(String message, Throwable cause, ConstraintViolation<T> violation) {
    super(message, cause);
    violations = new ArrayList<ConstraintViolation<T>>();
    violations.add(violation);
  }

  /**
   * @param message the detail message.
   * @param constraintViolations the violations that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(String message, Collection<ConstraintViolation<T>> constraintViolations) {
    this(message, null, constraintViolations);
  }

  /**
   * Gets the List of violations of this ValidationException.
   * @return the List of violations of this ValidationException.
   * @param <T> Type of ValidatonException
   */
  @SuppressWarnings("unchecked")
  public <T>Collection<ConstraintViolation<T>> getViolations() {
    if (violations == null) {
      return Collections.emptySet();
    }
    return violations;
  }
}
