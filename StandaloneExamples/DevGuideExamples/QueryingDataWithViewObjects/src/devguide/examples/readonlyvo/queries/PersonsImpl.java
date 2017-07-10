package devguide.examples.readonlyvo.queries;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PersonsImpl extends ViewObjectImpl {
    /**This is the default constructor (do not remove).
     */
    public PersonsImpl() {
    }
    
    /**Gets the bind variable value for TheName.
     */
    public String getTheName() {
        return (String)getNamedWhereClauseParam("TheName");
    }

    /**Sets <code>value</code> for bind variable TheName.
     */
    public void setTheName(String value) {
        setNamedWhereClauseParam("TheName", value);
    }

    /**Gets the bind variable value for HighUserId.
     */
    public Number getHighUserId() {
        return (Number)getNamedWhereClauseParam("HighUserId");
    }

    /**Sets <code>value</code> for bind variable HighUserId.
     */
    public void setHighUserId(Number value) {
        setNamedWhereClauseParam("HighUserId", value);
    }

    /**Gets the bind variable value for LowUserId.
     */
    public Number getLowUserId() {
        return (Number)getNamedWhereClauseParam("LowUserId");
    }

    /**Sets <code>value</code> for bind variable LowUserId.
     */
    public void setLowUserId(Number value) {
        setNamedWhereClauseParam("LowUserId", value);
    }
}