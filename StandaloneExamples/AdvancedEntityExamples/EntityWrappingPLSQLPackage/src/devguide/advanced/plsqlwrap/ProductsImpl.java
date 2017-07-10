package devguide.advanced.plsqlwrap;

import devguide.advanced.plsqlwrap.extension.PLSQLEntityImpl;

import java.sql.CallableStatement;

import java.sql.SQLException;

import oracle.jbo.AlreadyLockedException;
import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProductsImpl extends PLSQLEntityImpl {
    public static final int SUPPLIERID = 0;
    public static final int PRODUCTNAME = 1;
    public static final int LISTPRICE = 2;
    public static final int PRODUCTID = 3;
    public static final int MINPRICE = 4;
    public static final int SHIPPINGCLASSCODE = 5;
    private static EntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove).
     */
    public ProductsImpl() {
    }


    /**@return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("devguide.advanced.plsqlwrap.Products");
        }
        return mDefinitionObject;
    }


    /**Gets the attribute value for SupplierId, using the alias name SupplierId.
     */
    public Number getSupplierId() {
        return (Number)getAttributeInternal(SUPPLIERID);
    }

    /**Sets <code>value</code> as the attribute value for SupplierId.
     */
    public void setSupplierId(Number value) {
        setAttributeInternal(SUPPLIERID, value);
    }

    /**Gets the attribute value for ProductName, using the alias name ProductName.
     */
    public String getProductName() {
        return (String)getAttributeInternal(PRODUCTNAME);
    }

    /**Sets <code>value</code> as the attribute value for ProductName.
     */
    public void setProductName(String value) {
        setAttributeInternal(PRODUCTNAME, value);
    }

    /**Gets the attribute value for ListPrice, using the alias name ListPrice.
     */
    public Number getListPrice() {
        return (Number)getAttributeInternal(LISTPRICE);
    }

    /**Sets <code>value</code> as the attribute value for ListPrice.
     */
    public void setListPrice(Number value) {
        setAttributeInternal(LISTPRICE, value);
    }

    /**Gets the attribute value for ProductId, using the alias name ProductId.
     */
    public Number getProductId() {
        return (Number)getAttributeInternal(PRODUCTID);
    }

    /**Sets <code>value</code> as the attribute value for ProductId.
     */
    public void setProductId(Number value) {
        setAttributeInternal(PRODUCTID, value);
    }

    /**Gets the attribute value for MinPrice, using the alias name MinPrice.
     */
    public Number getMinPrice() {
        return (Number)getAttributeInternal(MINPRICE);
    }

    /**Sets <code>value</code> as the attribute value for MinPrice.
     */
    public void setMinPrice(Number value) {
        setAttributeInternal(MINPRICE, value);
    }

    /**Gets the attribute value for ShippingClassCode, using the alias name ShippingClassCode.
     */
    public String getShippingClassCode() {
        return (String)getAttributeInternal(SHIPPINGCLASSCODE);
    }

    /**Sets <code>value</code> as the attribute value for ShippingClassCode.
     */
    public void setShippingClassCode(String value) {
        setAttributeInternal(SHIPPINGCLASSCODE, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SUPPLIERID:
            return getSupplierId();
        case PRODUCTNAME:
            return getProductName();
        case LISTPRICE:
            return getListPrice();
        case PRODUCTID:
            return getProductId();
        case MINPRICE:
            return getMinPrice();
        case SHIPPINGCLASSCODE:
            return getShippingClassCode();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SUPPLIERID:
            setSupplierId((Number)value);
            return;
        case PRODUCTNAME:
            setProductName((String)value);
            return;
        case LISTPRICE:
            setListPrice((Number)value);
            return;
        case PRODUCTID:
            setProductId((Number)value);
            return;
        case MINPRICE:
            setMinPrice((Number)value);
            return;
        case SHIPPINGCLASSCODE:
            setShippingClassCode((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }


    @Override
    protected void callDeleteProcedure(TransactionEvent e) {
        callStoredProcedure("products_api.delete_product(?)",
        new Object[] { getProductId() });
    }

    @Override
    protected void callInsertProcedure(TransactionEvent e) {
        callStoredProcedure("products_api.insert_product(?,?,?,?,?,?)",
        new Object[] { getProductId(), getProductName(), getSupplierId(),
                       getListPrice(), getMinPrice(), getShippingClassCode() });
    }

    @Override
    protected void callUpdateProcedure(TransactionEvent e) {
        callStoredProcedure("products_api.update_product(?,?,?,?,?,?)",
                new Object[] { getProductId(), getProductName(), getSupplierId(),
                               getListPrice(), getMinPrice(), getShippingClassCode() });
    }

    @Override
    protected void callLockProcedureAndCheckForRowInconsistency() {
        String stmt = "begin products_api.lock_product(?,?,?,?,?,?);end;";
        CallableStatement st = 
            getDBTransaction().createCallableStatement(stmt, 0);
        try {
            st.registerOutParameter(2, VARCHAR2);
            st.registerOutParameter(3, NUMBER);
            st.registerOutParameter(4, NUMBER);
            st.registerOutParameter(5, NUMBER);
            st.registerOutParameter(6, VARCHAR2);
            st.setObject(1, getProductId());
            st.executeUpdate();
            String possiblyUpdatedName = st.getString(2);
            String possiblyUpdatedSupplierId = st.getString(3);
            String possiblyUpdatedListPrice = st.getString(4);
            String possiblyUpdatedMinPrice = st.getString(5);
            String possiblyUpdatedShipCode = st.getString(6);
            compareOldAttrTo(PRODUCTNAME, possiblyUpdatedName);
            compareOldAttrTo(SUPPLIERID, possiblyUpdatedSupplierId);
            compareOldAttrTo(LISTPRICE, possiblyUpdatedListPrice);
            compareOldAttrTo(MINPRICE, possiblyUpdatedMinPrice);
            compareOldAttrTo(SHIPPINGCLASSCODE, possiblyUpdatedShipCode);
        } catch (SQLException e) {
            if (Math.abs(e.getErrorCode()) == 54) {
                throw new AlreadyLockedException(e);
            } else {
                throw new JboException(e);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    protected void callSelectProcedure() {
        String stmt = "begin products_api.select_product(?,?,?,?,?,?);end;";
        // 1. Create a CallableStatement for the PLSQL block to invoke
        CallableStatement st = 
            getDBTransaction().createCallableStatement(stmt, 0);
        try {
            // 2. Register the OUT parameters and types
            st.registerOutParameter(2, VARCHAR2);
            st.registerOutParameter(3, NUMBER);
            st.registerOutParameter(4, NUMBER);
            st.registerOutParameter(5, NUMBER);
            st.registerOutParameter(6, VARCHAR2);

            // 3. Set the IN parameter value
            st.setObject(1, getProductId());
            // 4. Execute the statement
            st.executeUpdate();
            // 5. Retrieve the possibly updated column values
            String possiblyUpdatedName = st.getString(2);
            String possiblyUpdatedSupplierId = st.getString(3);
            String possiblyUpdatedListPrice = st.getString(4);
            String possiblyUpdatedMinPrice = st.getString(5);
            String possiblyUpdatedShipCode = st.getString(6);

            // 6. Populate the possibly updated attribute values in the row
            populateAttribute(PRODUCTNAME, possiblyUpdatedName, true, false, 
                              false);
            populateAttribute(SUPPLIERID, possiblyUpdatedSupplierId, true, 
                              false, false);
            populateAttribute(LISTPRICE, possiblyUpdatedListPrice, true, false, 
                              false);
            populateAttribute(MINPRICE, possiblyUpdatedMinPrice, true, false, 
                              false);
            populateAttribute(SHIPPINGCLASSCODE, possiblyUpdatedShipCode, true, 
                              false, false);
        } catch (SQLException e) {
            throw new JboException(e);
        } finally {
            if (st != null) {
                try {
                    // 7. Closing the statement
                    st.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    /**Creates a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number productId) {
        return new Key(new Object[]{productId});
    }
}
