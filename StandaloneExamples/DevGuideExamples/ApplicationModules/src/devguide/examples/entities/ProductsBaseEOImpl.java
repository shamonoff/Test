package devguide.examples.entities;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jun 30 09:54:03 MDT 2008
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProductsBaseEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ProductId {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getProductId();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setProductId((DBSequence)value);
            }
        }
        ,
        SupplierId {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getSupplierId();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setSupplierId((Number)value);
            }
        }
        ,
        CategoryId {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getCategoryId();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setCategoryId((Number)value);
            }
        }
        ,
        ProductName {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getProductName();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setProductName((String)value);
            }
        }
        ,
        ProductStatus {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getProductStatus();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setProductStatus((String)value);
            }
        }
        ,
        CostPrice {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getCostPrice();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setCostPrice((Number)value);
            }
        }
        ,
        ListPrice {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getListPrice();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setListPrice((Number)value);
            }
        }
        ,
        MinPrice {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getMinPrice();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setMinPrice((Number)value);
            }
        }
        ,
        WarrantyPeriodMonths {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getWarrantyPeriodMonths();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setWarrantyPeriodMonths((Number)value);
            }
        }
        ,
        ShippingClassCode {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getShippingClassCode();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setShippingClassCode((String)value);
            }
        }
        ,
        ExternalUrl {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getExternalUrl();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setExternalUrl((String)value);
            }
        }
        ,
        AttributeCategory {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttributeCategory();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttributeCategory((String)value);
            }
        }
        ,
        Attribute1 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute1();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute1((String)value);
            }
        }
        ,
        Attribute2 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute2();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute2((String)value);
            }
        }
        ,
        Attribute3 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute3();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute3((String)value);
            }
        }
        ,
        Attribute4 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute4();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute4((String)value);
            }
        }
        ,
        Attribute5 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute5();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute5((String)value);
            }
        }
        ,
        Attribute6 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute6();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute6((String)value);
            }
        }
        ,
        Attribute7 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute7();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute7((String)value);
            }
        }
        ,
        Attribute8 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute8();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute8((String)value);
            }
        }
        ,
        Attribute9 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute9();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute9((String)value);
            }
        }
        ,
        Attribute10 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute10();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute10((String)value);
            }
        }
        ,
        Attribute11 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute11();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute11((String)value);
            }
        }
        ,
        Attribute12 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute12();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute12((String)value);
            }
        }
        ,
        Attribute13 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute13();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute13((String)value);
            }
        }
        ,
        Attribute14 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute14();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute14((String)value);
            }
        }
        ,
        Attribute15 {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getAttribute15();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setAttribute15((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setCreatedBy((String)value);
            }
        }
        ,
        CreationDate {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getCreationDate();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
            }
        }
        ,
        LastUpdatedBy {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
                obj.setLastUpdatedBy((String)value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
            }
        }
        ,
        ObjectVersionId {
            public Object get(ProductsBaseEOImpl obj) {
                return obj.getObjectVersionId();
            }

            public void put(ProductsBaseEOImpl obj, Object value) {
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(ProductsBaseEOImpl object);

        public abstract void put(ProductsBaseEOImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static int PRODUCTID = AttributesEnum.ProductId.index();
    public static int SUPPLIERID = AttributesEnum.SupplierId.index();
    public static int CATEGORYID = AttributesEnum.CategoryId.index();
    public static int PRODUCTNAME = AttributesEnum.ProductName.index();
    public static int PRODUCTSTATUS = AttributesEnum.ProductStatus.index();
    public static int COSTPRICE = AttributesEnum.CostPrice.index();
    public static int LISTPRICE = AttributesEnum.ListPrice.index();
    public static int MINPRICE = AttributesEnum.MinPrice.index();
    public static int WARRANTYPERIODMONTHS = AttributesEnum.WarrantyPeriodMonths.index();
    public static int SHIPPINGCLASSCODE = AttributesEnum.ShippingClassCode.index();
    public static int EXTERNALURL = AttributesEnum.ExternalUrl.index();
    public static int ATTRIBUTECATEGORY = AttributesEnum.AttributeCategory.index();
    public static int ATTRIBUTE1 = AttributesEnum.Attribute1.index();
    public static int ATTRIBUTE2 = AttributesEnum.Attribute2.index();
    public static int ATTRIBUTE3 = AttributesEnum.Attribute3.index();
    public static int ATTRIBUTE4 = AttributesEnum.Attribute4.index();
    public static int ATTRIBUTE5 = AttributesEnum.Attribute5.index();
    public static int ATTRIBUTE6 = AttributesEnum.Attribute6.index();
    public static int ATTRIBUTE7 = AttributesEnum.Attribute7.index();
    public static int ATTRIBUTE8 = AttributesEnum.Attribute8.index();
    public static int ATTRIBUTE9 = AttributesEnum.Attribute9.index();
    public static int ATTRIBUTE10 = AttributesEnum.Attribute10.index();
    public static int ATTRIBUTE11 = AttributesEnum.Attribute11.index();
    public static int ATTRIBUTE12 = AttributesEnum.Attribute12.index();
    public static int ATTRIBUTE13 = AttributesEnum.Attribute13.index();
    public static int ATTRIBUTE14 = AttributesEnum.Attribute14.index();
    public static int ATTRIBUTE15 = AttributesEnum.Attribute15.index();
    public static int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static int OBJECTVERSIONID = AttributesEnum.ObjectVersionId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ProductsBaseEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("devguide.examples.entities.ProductsBaseEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for ProductId, using the alias name ProductId.
     * @return the ProductId
     */
    public DBSequence getProductId() {
        return (DBSequence)getAttributeInternal(PRODUCTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProductId.
     * @param value value to set the ProductId
     */
    public void setProductId(DBSequence value) {
        setAttributeInternal(PRODUCTID, value);
    }

    /**
     * Gets the attribute value for SupplierId, using the alias name SupplierId.
     * @return the SupplierId
     */
    public Number getSupplierId() {
        return (Number)getAttributeInternal(SUPPLIERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SupplierId.
     * @param value value to set the SupplierId
     */
    public void setSupplierId(Number value) {
        setAttributeInternal(SUPPLIERID, value);
    }

    /**
     * Gets the attribute value for CategoryId, using the alias name CategoryId.
     * @return the CategoryId
     */
    public Number getCategoryId() {
        return (Number)getAttributeInternal(CATEGORYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CategoryId.
     * @param value value to set the CategoryId
     */
    public void setCategoryId(Number value) {
        setAttributeInternal(CATEGORYID, value);
    }

    /**
     * Gets the attribute value for ProductName, using the alias name ProductName.
     * @return the ProductName
     */
    public String getProductName() {
        return (String)getAttributeInternal(PRODUCTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProductName.
     * @param value value to set the ProductName
     */
    public void setProductName(String value) {
        setAttributeInternal(PRODUCTNAME, value);
    }

    /**
     * Gets the attribute value for ProductStatus, using the alias name ProductStatus.
     * @return the ProductStatus
     */
    public String getProductStatus() {
        return (String)getAttributeInternal(PRODUCTSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProductStatus.
     * @param value value to set the ProductStatus
     */
    public void setProductStatus(String value) {
        setAttributeInternal(PRODUCTSTATUS, value);
    }

    /**
     * Gets the attribute value for CostPrice, using the alias name CostPrice.
     * @return the CostPrice
     */
    public Number getCostPrice() {
        return (Number)getAttributeInternal(COSTPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CostPrice.
     * @param value value to set the CostPrice
     */
    public void setCostPrice(Number value) {
        setAttributeInternal(COSTPRICE, value);
    }

    /**
     * Gets the attribute value for ListPrice, using the alias name ListPrice.
     * @return the ListPrice
     */
    public Number getListPrice() {
        return (Number)getAttributeInternal(LISTPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ListPrice.
     * @param value value to set the ListPrice
     */
    public void setListPrice(Number value) {
        setAttributeInternal(LISTPRICE, value);
    }

    /**
     * Gets the attribute value for MinPrice, using the alias name MinPrice.
     * @return the MinPrice
     */
    public Number getMinPrice() {
        return (Number)getAttributeInternal(MINPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for MinPrice.
     * @param value value to set the MinPrice
     */
    public void setMinPrice(Number value) {
        setAttributeInternal(MINPRICE, value);
    }

    /**
     * Gets the attribute value for WarrantyPeriodMonths, using the alias name WarrantyPeriodMonths.
     * @return the WarrantyPeriodMonths
     */
    public Number getWarrantyPeriodMonths() {
        return (Number)getAttributeInternal(WARRANTYPERIODMONTHS);
    }

    /**
     * Sets <code>value</code> as the attribute value for WarrantyPeriodMonths.
     * @param value value to set the WarrantyPeriodMonths
     */
    public void setWarrantyPeriodMonths(Number value) {
        setAttributeInternal(WARRANTYPERIODMONTHS, value);
    }

    /**
     * Gets the attribute value for ShippingClassCode, using the alias name ShippingClassCode.
     * @return the ShippingClassCode
     */
    public String getShippingClassCode() {
        return (String)getAttributeInternal(SHIPPINGCLASSCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ShippingClassCode.
     * @param value value to set the ShippingClassCode
     */
    public void setShippingClassCode(String value) {
        setAttributeInternal(SHIPPINGCLASSCODE, value);
    }

    /**
     * Gets the attribute value for ExternalUrl, using the alias name ExternalUrl.
     * @return the ExternalUrl
     */
    public String getExternalUrl() {
        return (String)getAttributeInternal(EXTERNALURL);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExternalUrl.
     * @param value value to set the ExternalUrl
     */
    public void setExternalUrl(String value) {
        setAttributeInternal(EXTERNALURL, value);
    }

    /**
     * Gets the attribute value for AttributeCategory, using the alias name AttributeCategory.
     * @return the AttributeCategory
     */
    public String getAttributeCategory() {
        return (String)getAttributeInternal(ATTRIBUTECATEGORY);
    }

    /**
     * Sets <code>value</code> as the attribute value for AttributeCategory.
     * @param value value to set the AttributeCategory
     */
    public void setAttributeCategory(String value) {
        setAttributeInternal(ATTRIBUTECATEGORY, value);
    }

    /**
     * Gets the attribute value for Attribute1, using the alias name Attribute1.
     * @return the Attribute1
     */
    public String getAttribute1() {
        return (String)getAttributeInternal(ATTRIBUTE1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute1.
     * @param value value to set the Attribute1
     */
    public void setAttribute1(String value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**
     * Gets the attribute value for Attribute2, using the alias name Attribute2.
     * @return the Attribute2
     */
    public String getAttribute2() {
        return (String)getAttributeInternal(ATTRIBUTE2);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute2.
     * @param value value to set the Attribute2
     */
    public void setAttribute2(String value) {
        setAttributeInternal(ATTRIBUTE2, value);
    }

    /**
     * Gets the attribute value for Attribute3, using the alias name Attribute3.
     * @return the Attribute3
     */
    public String getAttribute3() {
        return (String)getAttributeInternal(ATTRIBUTE3);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute3.
     * @param value value to set the Attribute3
     */
    public void setAttribute3(String value) {
        setAttributeInternal(ATTRIBUTE3, value);
    }

    /**
     * Gets the attribute value for Attribute4, using the alias name Attribute4.
     * @return the Attribute4
     */
    public String getAttribute4() {
        return (String)getAttributeInternal(ATTRIBUTE4);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute4.
     * @param value value to set the Attribute4
     */
    public void setAttribute4(String value) {
        setAttributeInternal(ATTRIBUTE4, value);
    }

    /**
     * Gets the attribute value for Attribute5, using the alias name Attribute5.
     * @return the Attribute5
     */
    public String getAttribute5() {
        return (String)getAttributeInternal(ATTRIBUTE5);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute5.
     * @param value value to set the Attribute5
     */
    public void setAttribute5(String value) {
        setAttributeInternal(ATTRIBUTE5, value);
    }

    /**
     * Gets the attribute value for Attribute6, using the alias name Attribute6.
     * @return the Attribute6
     */
    public String getAttribute6() {
        return (String)getAttributeInternal(ATTRIBUTE6);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute6.
     * @param value value to set the Attribute6
     */
    public void setAttribute6(String value) {
        setAttributeInternal(ATTRIBUTE6, value);
    }

    /**
     * Gets the attribute value for Attribute7, using the alias name Attribute7.
     * @return the Attribute7
     */
    public String getAttribute7() {
        return (String)getAttributeInternal(ATTRIBUTE7);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute7.
     * @param value value to set the Attribute7
     */
    public void setAttribute7(String value) {
        setAttributeInternal(ATTRIBUTE7, value);
    }

    /**
     * Gets the attribute value for Attribute8, using the alias name Attribute8.
     * @return the Attribute8
     */
    public String getAttribute8() {
        return (String)getAttributeInternal(ATTRIBUTE8);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute8.
     * @param value value to set the Attribute8
     */
    public void setAttribute8(String value) {
        setAttributeInternal(ATTRIBUTE8, value);
    }

    /**
     * Gets the attribute value for Attribute9, using the alias name Attribute9.
     * @return the Attribute9
     */
    public String getAttribute9() {
        return (String)getAttributeInternal(ATTRIBUTE9);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute9.
     * @param value value to set the Attribute9
     */
    public void setAttribute9(String value) {
        setAttributeInternal(ATTRIBUTE9, value);
    }

    /**
     * Gets the attribute value for Attribute10, using the alias name Attribute10.
     * @return the Attribute10
     */
    public String getAttribute10() {
        return (String)getAttributeInternal(ATTRIBUTE10);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute10.
     * @param value value to set the Attribute10
     */
    public void setAttribute10(String value) {
        setAttributeInternal(ATTRIBUTE10, value);
    }

    /**
     * Gets the attribute value for Attribute11, using the alias name Attribute11.
     * @return the Attribute11
     */
    public String getAttribute11() {
        return (String)getAttributeInternal(ATTRIBUTE11);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute11.
     * @param value value to set the Attribute11
     */
    public void setAttribute11(String value) {
        setAttributeInternal(ATTRIBUTE11, value);
    }

    /**
     * Gets the attribute value for Attribute12, using the alias name Attribute12.
     * @return the Attribute12
     */
    public String getAttribute12() {
        return (String)getAttributeInternal(ATTRIBUTE12);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute12.
     * @param value value to set the Attribute12
     */
    public void setAttribute12(String value) {
        setAttributeInternal(ATTRIBUTE12, value);
    }

    /**
     * Gets the attribute value for Attribute13, using the alias name Attribute13.
     * @return the Attribute13
     */
    public String getAttribute13() {
        return (String)getAttributeInternal(ATTRIBUTE13);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute13.
     * @param value value to set the Attribute13
     */
    public void setAttribute13(String value) {
        setAttributeInternal(ATTRIBUTE13, value);
    }

    /**
     * Gets the attribute value for Attribute14, using the alias name Attribute14.
     * @return the Attribute14
     */
    public String getAttribute14() {
        return (String)getAttributeInternal(ATTRIBUTE14);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute14.
     * @param value value to set the Attribute14
     */
    public void setAttribute14(String value) {
        setAttributeInternal(ATTRIBUTE14, value);
    }

    /**
     * Gets the attribute value for Attribute15, using the alias name Attribute15.
     * @return the Attribute15
     */
    public String getAttribute15() {
        return (String)getAttributeInternal(ATTRIBUTE15);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute15.
     * @param value value to set the Attribute15
     */
    public void setAttribute15(String value) {
        setAttributeInternal(ATTRIBUTE15, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public String getCreatedBy() {
        return (String)getAttributeInternal(CREATEDBY);
    }


    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }


    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return (String)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(String value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }


    /**
     * Gets the attribute value for ObjectVersionId, using the alias name ObjectVersionId.
     * @return the ObjectVersionId
     */
    public Number getObjectVersionId() {
        return (Number)getAttributeInternal(OBJECTVERSIONID);
    }


    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @param productId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence productId) {
        return new Key(new Object[]{productId});
    }


}