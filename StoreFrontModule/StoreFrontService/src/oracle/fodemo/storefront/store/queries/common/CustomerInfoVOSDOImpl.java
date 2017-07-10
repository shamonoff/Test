package oracle.fodemo.storefront.store.queries.common;

import org.eclipse.persistence.sdo.SDODataObject;

public class CustomerInfoVOSDOImpl extends SDODataObject implements CustomerInfoVOSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 6;

   public CustomerInfoVOSDOImpl() {}

    /**
     * @return
     */
    public java.math.BigDecimal getPersonId() {
      return getBigDecimal(START_PROPERTY_INDEX + 0);
   }

    /**
     * @param value
     */
    public void setPersonId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

    /**
     * @return
     */
    public java.lang.String getFirstName() {
      return getString(START_PROPERTY_INDEX + 1);
   }

    /**
     * @param value
     */
    public void setFirstName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

    /**
     * @return
     */
    public java.lang.String getLastName() {
      return getString(START_PROPERTY_INDEX + 2);
   }

    /**
     * @param value
     */
    public void setLastName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

    /**
     * @return
     */
    public java.lang.String getConfirmedEmail() {
      return getString(START_PROPERTY_INDEX + 3);
   }

    /**
     * @param value
     */
    public void setConfirmedEmail(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

    /**
     * @return
     */
    public java.lang.String getMobilePhoneNumber() {
      return getString(START_PROPERTY_INDEX + 4);
   }

    /**
     * @param value
     */
    public void setMobilePhoneNumber(java.lang.String value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

    /**
     * @return
     */
    public java.math.BigDecimal getMembershipId() {
      return getBigDecimal(START_PROPERTY_INDEX + 5);
   }

    /**
     * @param value
     */
    public void setMembershipId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

    /**
     * @return
     */
    public java.lang.String getMembershipTypeCode() {
      return getString(START_PROPERTY_INDEX + 6);
   }

    /**
     * @param value
     */
    public void setMembershipTypeCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }


}

