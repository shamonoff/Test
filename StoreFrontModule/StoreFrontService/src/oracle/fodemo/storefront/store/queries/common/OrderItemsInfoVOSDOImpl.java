package oracle.fodemo.storefront.store.queries.common;

import org.eclipse.persistence.sdo.SDODataObject;

public class OrderItemsInfoVOSDOImpl extends SDODataObject implements OrderItemsInfoVOSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 10;

   public OrderItemsInfoVOSDOImpl() {}

    /**
     * @return
     */
    public java.lang.Long getOrderId() {
      return getLong(START_PROPERTY_INDEX + 0);
   }

    /**
     * @param value
     */
    public void setOrderId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

    /**
     * @return
     */
    public java.math.BigInteger getLineItemId() {
      return getBigInteger(START_PROPERTY_INDEX + 1);
   }

    /**
     * @param value
     */
    public void setLineItemId(java.math.BigInteger value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getProductId() {
      return getLong(START_PROPERTY_INDEX + 2);
   }

    /**
     * @param value
     */
    public void setProductId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

    /**
     * @return
     */
    public java.lang.Integer getQuantity() {
      return new Integer(getInt(START_PROPERTY_INDEX + 3));
   }

    /**
     * @param value
     */
    public void setQuantity(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

    /**
     * @return
     */
    public java.math.BigDecimal getUnitPrice() {
      return getBigDecimal(START_PROPERTY_INDEX + 4);
   }

    /**
     * @param value
     */
    public void setUnitPrice(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

    /**
     * @return
     */
    public java.lang.String getProductName() {
      return getString(START_PROPERTY_INDEX + 5);
   }

    /**
     * @param value
     */
    public void setProductName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

    /**
     * @return
     */
    public java.lang.String getSupplierName() {
      return getString(START_PROPERTY_INDEX + 6);
   }

    /**
     * @param value
     */
    public void setSupplierName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getObjectVersionId() {
      return getLong(START_PROPERTY_INDEX + 7);
   }

    /**
     * @param value
     */
    public void setObjectVersionId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

    /**
     * @return
     */
    public java.math.BigInteger getProductId1() {
      return getBigInteger(START_PROPERTY_INDEX + 8);
   }

    /**
     * @param value
     */
    public void setProductId1(java.math.BigInteger value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getSupplierId() {
      return getLong(START_PROPERTY_INDEX + 9);
   }

    /**
     * @param value
     */
    public void setSupplierId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 9 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getObjectVersionId1() {
      return getLong(START_PROPERTY_INDEX + 10);
   }

    /**
     * @param value
     */
    public void setObjectVersionId1(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 10 , value);
   }


}

