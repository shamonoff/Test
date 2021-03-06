package devguide.advanced.baseproject.extsub;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProductsBaseImpl extends EntityImpl {
    public static final int PRODUCTID = 0;
    public static final int PRODUCTNAME = 1;
    public static final int CHECKSUM = 2;
    private static EntityDefImpl mDefinitionObject;

    /**This is the default constructor (do not remove).
     */
    public ProductsBaseImpl() {
    }

    /**@return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("devguide.advanced.baseproject.extsub.ProductsBase");
        }
        return mDefinitionObject;
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

    /**Gets the attribute value for CheckSum, using the alias name CheckSum.
     */
    public String getCheckSum() {
        return "I am the Product Class";
    }

    /**Sets <code>value</code> as the attribute value for CheckSum.
     */
    public void setCheckSum(String value) {
        setAttributeInternal(CHECKSUM, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PRODUCTID:
            return getProductId();
        case PRODUCTNAME:
            return getProductName();
        case CHECKSUM:
            return getCheckSum();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PRODUCTID:
            setProductId((Number)value);
            return;
        case PRODUCTNAME:
            setProductName((String)value);
            return;
        case CHECKSUM:
            setCheckSum((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Creates a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number productId) {
        return new Key(new Object[]{productId});
    }
}
