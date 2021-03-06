package devguide.examples.readonlyvo.queries;

import devguide.examples.readonlyvo.queries.common.PersonsRow;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PersonsRowImpl extends ViewRowImpl implements PersonsRow {
    public static final int PERSONID = 0;
    public static final int EMAIL = 1;
    public static final int FIRSTNAME = 2;
    public static final int LASTNAME = 3;
    public static final int PERSONTYPECODE = 4;
    public static final int PRIMARYADDRESSID = 5;
    public static final int SHORTNAME = 6;
    public static final int ORDERSSHIPPEDTOPURCHASER = 7;

    /**This is the default constructor (do not remove).
     */
    public PersonsRowImpl() {
    }

    /**Gets the attribute value for the calculated attribute PersonId.
     */
    public Number getPersonId() {
        return (Number) getAttributeInternal(PERSONID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute PersonId.
     */
    public void setPersonId(Number value) {
        setAttributeInternal(PERSONID, value);
    }

    /**Gets the attribute value for the calculated attribute Email.
     */
    public String getEmail() {
        return (String) getAttributeInternal(EMAIL);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Email.
     */
    public void setEmail(String value) {
        setAttributeInternal(EMAIL, value);
    }

    /**Gets the attribute value for the calculated attribute FirstName.
     */
    public String getFirstName() {
        return (String) getAttributeInternal(FIRSTNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute FirstName.
     */
    public void setFirstName(String value) {
        setAttributeInternal(FIRSTNAME, value);
    }

    /**Gets the attribute value for the calculated attribute LastName.
     */
    public String getLastName() {
        return (String) getAttributeInternal(LASTNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute LastName.
     */
    public void setLastName(String value) {
        setAttributeInternal(LASTNAME, value);
    }

    /**Gets the attribute value for the calculated attribute PersonTypeCode.
     */
    public String getPersonTypeCode() {
        return (String) getAttributeInternal(PERSONTYPECODE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute PersonTypeCode.
     */
    public void setPersonTypeCode(String value) {
        setAttributeInternal(PERSONTYPECODE, value);
    }

    /**Gets the attribute value for the calculated attribute PrimaryAddressId.
     */
    public Number getPrimaryAddressId() {
        return (Number) getAttributeInternal(PRIMARYADDRESSID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute PrimaryAddressId.
     */
    public void setPrimaryAddressId(Number value) {
        setAttributeInternal(PRIMARYADDRESSID, value);
    }

    /**Gets the attribute value for the calculated attribute ShortName.
     */
    public String getShortName() {
        return (String) getAttributeInternal(SHORTNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute ShortName.
     */
    public void setShortName(String value) {
        setAttributeInternal(SHORTNAME, value);
    }


    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PERSONID:
            return getPersonId();
        case EMAIL:
            return getEmail();
        case FIRSTNAME:
            return getFirstName();
        case LASTNAME:
            return getLastName();
        case PERSONTYPECODE:
            return getPersonTypeCode();
        case PRIMARYADDRESSID:
            return getPrimaryAddressId();
        case SHORTNAME:
            return getShortName();
        case ORDERSSHIPPEDTOPURCHASER:
            return getOrdersShippedToPurchaser();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PRIMARYADDRESSID:
            setPrimaryAddressId((Number)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }


    /**
     * Sample exportable method.
     */
    public void samplePersonsRowImplExportable() {
    }

    /**
     * Sample exportable method.
     */
    public void samplePersonsRowImplExportable2(String testParam1) {
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link OrdersShippedToPurchaser.
     */
    public RowIterator getOrdersShippedToPurchaser() {
        return (RowIterator)getAttributeInternal(ORDERSSHIPPEDTOPURCHASER);
    }
}
