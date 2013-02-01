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
package gov.nih.nci.calims2.business.report.query;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Conjunction;
import gov.nih.nci.calims2.domain.report.Disjunction;
import gov.nih.nci.calims2.domain.report.Negation;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Restriction;
import gov.nih.nci.calims2.domain.report.enumeration.Operator;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;

/**
 * @author viseem
 * 
 */
public class HQLQueryBuilder implements ClauseVisitor {

  private static final Map<Operator, String> OPERATOR_MAP = createOperatorMap();
  private static final Set<Operator> UNARY = createUnaryOperatorSet();

  private Query query;
  private EntityDescriptor descriptor;
  private StringBuilder builder = new StringBuilder();
  private Map<String, Object> parameterMap = new HashMap<String, Object>();

  private static Map<Operator, String> createOperatorMap() {
    Map<Operator, String> map = new HashMap<Operator, String>();
    map.put(Operator.LESS_THAN, " < ");
    map.put(Operator.GREATER_THAN, " > ");
    map.put(Operator.LESS_THAN_OR_EQUAL, " <= ");
    map.put(Operator.GREATER_THAN_OR_EQUAL, " >= ");
    map.put(Operator.EQUAL_TO, " = ");
    map.put(Operator.NOT_EQUAL_TO, " <> ");
    map.put(Operator.IS_NULL, " IS NULL");
    map.put(Operator.IS_NOT_NULL, " IS NOT NULL");
    map.put(Operator.IS_LIKE, " LIKE ");
    map.put(Operator.IS_NOT_LIKE, " NOT LIKE ");
    return map;
  }

  private static Set<Operator> createUnaryOperatorSet() {
    Set<Operator> operators = new HashSet<Operator>();
    operators.add(Operator.IS_NULL);
    operators.add(Operator.IS_NOT_NULL);
    return operators;
  }

  /**
   * Constructor.
   * 
   * @param query The query for which HQL will be constructed.
   * @param descriptor Indicates if the query main entity has 
   */
  
  // rome subclasses and add a descriptor to the constructor.
  public HQLQueryBuilder(Query query, EntityDescriptor descriptor) {
    this.query = query;
    this.descriptor = descriptor;
  }

  /**
   * {@inheritDoc}
   */
  public void visitClause(Clause clause) {
    // Nothing to do
  }

  /**
   * generates a composite clause.
   * 
   * @param subClauses Its sub clauses
   * @param connector The connector to use in the clause
   */
  public void visitCompositeClause(Collection<Clause> subClauses, String connector) {
    builder.append("(");
    boolean connect = false;
    for (Clause subClause : subClauses) {
      if (connect) {
        builder.append(connector);
      } else {
        connect = true;
      }
      subClause.accept(this);
    }
    builder.append(")");
  }

  /**
   * {@inheritDoc}
   */
  public void visitConjunction(Conjunction conjunction) {
    visitCompositeClause(conjunction.getClauseCollection(), " AND ");
  }

  /**
   * {@inheritDoc}
   */
  public void visitDisjunction(Disjunction disjunction) {
    visitCompositeClause(disjunction.getClauseCollection(), " OR ");
  }

  /**
   * {@inheritDoc}
   */
  public void visitNegation(Negation negation) {
    builder.append("NOT(");
    negation.getClause().accept(this);
    builder.append(")");
  }

  /**
   * {@inheritDoc}
   */

  public void visitRestriction(Restriction restriction) {
    builder.append(restriction.getPropertyName());
    builder.append(OPERATOR_MAP.get(restriction.getOperator()));
    if (!UNARY.contains(restriction.getOperator())) {
      PropertyDescriptor propertyDescriptor = descriptor.getPropertyDescriptor(restriction.getPropertyName());
      String type = propertyDescriptor.getType();
      String paramName = "param" + restriction.getId();
      builder.append(":");
      builder.append(paramName);
      builder.append(" ");
      if (type.equals("org.hibernate.type.EnumType")) {
        parameterMap.put(paramName, getParameterValueForEnum(restriction, propertyDescriptor));
      } else  {
           if  (type.equals("boolean")) {
             parameterMap.put(paramName, getParameterValueForBoolean(restriction));
          } else {
             parameterMap.put(paramName, restriction.getValue());
          }
       }
    }
  }
  
/**
 * 
 * @param restriction The Restriction.
 * @param propertyDescriptor The PropertyDescriptor
 * @return value The value of the restriction.
 */
  @SuppressWarnings("unchecked")
  public Object getParameterValueForEnum(Restriction restriction, PropertyDescriptor propertyDescriptor) {
    Object value;
    try {
        Class enumClazz = propertyDescriptor.getReturnedClass();
        value = Enum.valueOf(enumClazz, restriction.getValue().toUpperCase());
      return value;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * 
   * @param restriction The restriction.
   * @return value The value of the restriction.
   */

    public Object getParameterValueForBoolean(Restriction restriction) {
      Object value = Boolean.valueOf(restriction.getValue().toLowerCase());
      return value;
    }
  
  /**
   * Gets the HQL query corresponding to this builder Query.
   * 
   * @return the HQL query corresponding to this builder Query
   */
  public String getHQLQuery() {
    builder.append("from ");
    builder.append(query.getMainEntity());
    String alias = " alias" + query.hashCode();
    builder.append(alias);
    Clause rootClause = RootClauseSearch.getRootClause(query);
    boolean hasRootClause = rootClause != null;
    if (hasRootClause || descriptor.getSubClasses()) {
      builder.append(" where ");
    }
    if (descriptor.getSubClasses()) {
      builder.append(alias);
      builder.append(".class = ");
      builder.append(query.getMainEntity());
      builder.append(" ");
      if (hasRootClause) {
        builder.append("AND ");
      }
    }
    if (rootClause != null) {
      rootClause.accept(this);
    }
    return builder.toString();
  }

  /**
   * Gets the map of parameters for the generated query. This method must be called after getHQLQuery
   * 
   * @return The map of parameters for the generated query.
   */
  public Map<String, Object> getParameters() {
    return parameterMap;
  }

}
