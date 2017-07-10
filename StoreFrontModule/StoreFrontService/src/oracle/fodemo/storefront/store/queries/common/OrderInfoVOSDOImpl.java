package oracle.fodemo.storefront.store.queries.common;

import org.eclipse.persistence.sdo.SDODataObject;

public class OrderInfoVOSDOImpl extends SDODataObject implements OrderInfoVOSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 32;

   public OrderInfoVOSDOImpl() {}

    /**
     * @return
     */
    public java.math.BigInteger getOrderId() {
      return getBigInteger(START_PROPERTY_INDEX + 0);
   }

    /**
     * @param value
     */
    public void setOrderId(java.math.BigInteger value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

    /**
     * @return
     */
    public java.sql.Timestamp getOrderDate() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 1);
   }

    /**
     * @param value
     */
    public void setOrderDate(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

    /**
     * @return
     */
    public java.sql.Timestamp getOrderShippedDate() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 2);
   }

    /**
     * @param value
     */
    public void setOrderShippedDate(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

    /**
     * @return
     */
    public java.lang.String getOrderStatusCode() {
      return getString(START_PROPERTY_INDEX + 3);
   }

    /**
     * @param value
     */
    public void setOrderStatusCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

    /**
     * @return
     */
    public java.math.BigDecimal getOrderTotal() {
      return getBigDecimal(START_PROPERTY_INDEX + 4);
   }

    /**
     * @param value
     */
    public void setOrderTotal(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getCustomerId() {
      return getLong(START_PROPERTY_INDEX + 5);
   }

    /**
     * @param value
     */
    public void setCustomerId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

    /**
     * @return
     */
    public java.lang.String getShipToName() {
      return getString(START_PROPERTY_INDEX + 6);
   }

    /**
     * @param value
     */
    public void setShipToName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

    /**
     * @return
     */
    public java.lang.String getShipToPhoneNumber() {
      return getString(START_PROPERTY_INDEX + 7);
   }

    /**
     * @param value
     */
    public void setShipToPhoneNumber(java.lang.String value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

    /**
     * @return
     */
    public java.math.BigInteger getAddressId() {
      return getBigInteger(START_PROPERTY_INDEX + 8);
   }

    /**
     * @param value
     */
    public void setAddressId(java.math.BigInteger value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }

    /**
     * @return
     */
    public java.lang.String getAddress1() {
      return getString(START_PROPERTY_INDEX + 9);
   }

    /**
     * @param value
     */
    public void setAddress1(java.lang.String value) {
      set(START_PROPERTY_INDEX + 9 , value);
   }

    /**
     * @return
     */
    public java.lang.String getAddress2() {
      return getString(START_PROPERTY_INDEX + 10);
   }

    /**
     * @param value
     */
    public void setAddress2(java.lang.String value) {
      set(START_PROPERTY_INDEX + 10 , value);
   }

    /**
     * @return
     */
    public java.lang.String getCity() {
      return getString(START_PROPERTY_INDEX + 11);
   }

    /**
     * @param value
     */
    public void setCity(java.lang.String value) {
      set(START_PROPERTY_INDEX + 11 , value);
   }

    /**
     * @return
     */
    public java.lang.String getPostalCode() {
      return getString(START_PROPERTY_INDEX + 12);
   }

    /**
     * @param value
     */
    public void setPostalCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 12 , value);
   }

    /**
     * @return
     */
    public java.lang.String getStateProvince() {
      return getString(START_PROPERTY_INDEX + 13);
   }

    /**
     * @param value
     */
    public void setStateProvince(java.lang.String value) {
      set(START_PROPERTY_INDEX + 13 , value);
   }

    /**
     * @return
     */
    public java.lang.String getCountryId() {
      return getString(START_PROPERTY_INDEX + 14);
   }

    /**
     * @param value
     */
    public void setCountryId(java.lang.String value) {
      set(START_PROPERTY_INDEX + 14 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getPaymentOptionId() {
      return getLong(START_PROPERTY_INDEX + 15);
   }

    /**
     * @param value
     */
    public void setPaymentOptionId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 15 , value);
   }

    /**
     * @return
     */
    public java.math.BigInteger getBillingAddressId() {
      return getBigInteger(START_PROPERTY_INDEX + 16);
   }

    /**
     * @param value
     */
    public void setBillingAddressId(java.math.BigInteger value) {
      set(START_PROPERTY_INDEX + 16 , value);
   }

    /**
     * @return
     */
    public java.math.BigInteger getAccountNumber() {
      return getBigInteger(START_PROPERTY_INDEX + 17);
   }

    /**
     * @param value
     */
    public void setAccountNumber(java.math.BigInteger value) {
      set(START_PROPERTY_INDEX + 17 , value);
   }

    /**
     * @return
     */
    public java.lang.String getCardTypeCode() {
      return getString(START_PROPERTY_INDEX + 18);
   }

    /**
     * @param value
     */
    public void setCardTypeCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 18 , value);
   }

    /**
     * @return
     */
    public java.sql.Timestamp getExpireDate() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 19);
   }

    /**
     * @param value
     */
    public void setExpireDate(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 19 , value);
   }

    /**
     * @return
     */
    public java.lang.Integer getCheckDigits() {
      return new Integer(getInt(START_PROPERTY_INDEX + 20));
   }

    /**
     * @param value
     */
    public void setCheckDigits(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 20 , value);
   }

    /**
     * @return
     */
    public java.lang.String getRoutingIdentifier() {
      return getString(START_PROPERTY_INDEX + 21);
   }

    /**
     * @param value
     */
    public void setRoutingIdentifier(java.lang.String value) {
      set(START_PROPERTY_INDEX + 21 , value);
   }

    /**
     * @return
     */
    public java.lang.String getInstitutionName() {
      return getString(START_PROPERTY_INDEX + 22);
   }

    /**
     * @param value
     */
    public void setInstitutionName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 22 , value);
   }

    /**
     * @return
     */
    public java.math.BigDecimal getShipToAddressId() {
      return getBigDecimal(START_PROPERTY_INDEX + 23);
   }

    /**
     * @param value
     */
    public void setShipToAddressId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 23 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getObjectVersionId() {
      return getLong(START_PROPERTY_INDEX + 24);
   }

    /**
     * @param value
     */
    public void setObjectVersionId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 24 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getShippingOptionId() {
      return getLong(START_PROPERTY_INDEX + 25);
   }

    /**
     * @param value
     */
    public void setShippingOptionId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 25 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getObjectVersionId1() {
      return getLong(START_PROPERTY_INDEX + 26);
   }

    /**
     * @param value
     */
    public void setObjectVersionId1(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 26 , value);
   }

    /**
     * @return
     */
    public java.lang.String getFreeShippingFlag() {
      return getString(START_PROPERTY_INDEX + 27);
   }

    /**
     * @param value
     */
    public void setFreeShippingFlag(java.lang.String value) {
      set(START_PROPERTY_INDEX + 27 , value);
   }

    /**
     * @return
     */
    public java.lang.Long getObjectVersionId2() {
      return getLong(START_PROPERTY_INDEX + 28);
   }

    /**
     * @param value
     */
    public void setObjectVersionId2(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 28 , value);
   }

    /**
     * @return
     */
    public java.lang.String getCustomerCollectFlag() {
      return getString(START_PROPERTY_INDEX + 29);
   }

    /**
     * @param value
     */
    public void setCustomerCollectFlag(java.lang.String value) {
      set(START_PROPERTY_INDEX + 29 , value);
   }

    /**
     * @return
     */
    public java.lang.String getGiftwrapFlag() {
      return getString(START_PROPERTY_INDEX + 30);
   }

    /**
     * @param value
     */
    public void setGiftwrapFlag(java.lang.String value) {
      set(START_PROPERTY_INDEX + 30 , value);
   }

    /**
     * @return
     */
    public java.math.BigInteger getPaymentOptionId1() {
      return getBigInteger(START_PROPERTY_INDEX + 31);
   }

    /**
     * @param value
     */
    public void setPaymentOptionId1(java.math.BigInteger value) {
      set(START_PROPERTY_INDEX + 31 , value);
   }

    /**
     * @return
     */
    public java.util.List getOrderItemsInfoVO() {
      return getList(START_PROPERTY_INDEX + 32);
   }

    /**
     * @param value
     */
    public void setOrderItemsInfoVO(java.util.List value) {
      set(START_PROPERTY_INDEX + 32 , value);
   }


}

