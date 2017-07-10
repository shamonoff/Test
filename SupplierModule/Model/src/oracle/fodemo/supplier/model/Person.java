package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({
  @NamedQuery(name = "Person.findAll", query = "select o from Person o"),
  @NamedQuery(name = "Person.findByPrincipal", query = "select o from Person o where o.principalName = :principal")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "PERSONS")
public class Person implements Serializable, Auditable {
    @Column(name="APPROXIMATE_INCOME")
    private Long approximateIncome;
    @Column(name="CHILDREN_UNDER_18")
    private Long childrenUnder18;
    @Column(name="CONFIRMED_EMAIL", length = 25)
    private String confirmedEmail;
    @Column(name="CONTACTABLE_FLAG", nullable = false, length = 1)
    private String contactableFlag;
    @Column(name="CONTACT_BY_AFFILLIATES_FLAG", nullable = false, length = 1)
    private String contactByAffilliatesFlag;
    @Column(name="CONTACT_METHOD_CODE", length = 30)
    private String contactMethodCode;
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(name="CREDIT_LIMIT")
    private Double creditLimit;
    @Column(name="DATE_OF_BIRTH")
    private Timestamp dateOfBirth;
    @Column(nullable = false, length = 25)
    private String email;
    @Column(name="FIRST_NAME", length = 30)
    private String firstName;
    @Column(nullable = false, length = 1)
    private String gender;
    @Column(name="LAST_NAME", length = 30)
    private String lastName;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Column(name="MARITAL_STATUS_CODE", nullable = false, length = 30)
    private String maritalStatusCode;
    @Column(name="MEMBERSHIP_ID")
    private Long membershipId;
    @Column(name="MOBILE_PHONE_NUMBER", length = 20)
    private String mobilePhoneNumber;
    @Version
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Id
    @Column(name="PERSON_ID", nullable = false)
    @GeneratedValue(generator = "PersonSeq", 
                    strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PersonSeq", 
                       sequenceName = "PERSON_SEQ", 
                       allocationSize = 1)
    private Long personId;
    @Column(name="PERSON_TYPE_CODE", nullable = false, length = 30)
    private String personTypeCode;
    @Column(name="PHONE_NUMBER", length = 20)
    private String phoneNumber;
    @Column(name="PRINCIPAL_NAME", nullable = false, length = 60)
    private String principalName;
    @Column(name="PROVISIONED_FLAG", length = 1)
    private String provisionedFlag;
    @Column(name="REGISTERED_DATE")
    private Timestamp registeredDate;
    @Column(length = 12)
    private String title;
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    private List<AddressUsage> addressUsageList;
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "PRIMARY_ADDRESS_ID")
    private Addresses addresses;

    public Person() {
    }

    public Person(Long approximateIncome, Long childrenUnder18,
                  String confirmedEmail, String contactByAffilliatesFlag,
                  String contactMethodCode, String contactableFlag,
                  String createdBy, Timestamp creationDate, Double creditLimit,
                  Timestamp dateOfBirth, String email, String firstName,
                  String gender, String lastName, Timestamp lastUpdateDate,
                  String lastUpdatedBy, String maritalStatusCode,
                  Long membershipId, String mobilePhoneNumber,
                  Long objectVersionId, Long personId, String personTypeCode,
                  String phoneNumber, Addresses addresses,
                  String principalName, String provisionedFlag,
                  Timestamp registeredDate, Supplier supplier, String title) {
        this.approximateIncome = approximateIncome;
        this.childrenUnder18 = childrenUnder18;
        this.confirmedEmail = confirmedEmail;
        this.contactByAffilliatesFlag = contactByAffilliatesFlag;
        this.contactMethodCode = contactMethodCode;
        this.contactableFlag = contactableFlag;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.creditLimit = creditLimit;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.maritalStatusCode = maritalStatusCode;
        this.membershipId = membershipId;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.objectVersionId = objectVersionId;
        this.personId = personId;
        this.personTypeCode = personTypeCode;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
        this.principalName = principalName;
        this.provisionedFlag = provisionedFlag;
        this.registeredDate = registeredDate;
        this.supplier = supplier;
        this.title = title;
    }

    public Long getApproximateIncome() {
        return approximateIncome;
    }

    public void setApproximateIncome(Long approximateIncome) {
        this.approximateIncome = approximateIncome;
    }

    public Long getChildrenUnder18() {
        return childrenUnder18;
    }

    public void setChildrenUnder18(Long childrenUnder18) {
        this.childrenUnder18 = childrenUnder18;
    }

    public String getConfirmedEmail() {
        return confirmedEmail;
    }

    public void setConfirmedEmail(String confirmedEmail) {
        this.confirmedEmail = confirmedEmail;
    }

    public String getContactableFlag() {
        return contactableFlag;
    }

    public void setContactableFlag(String contactableFlag) {
        this.contactableFlag = contactableFlag;
    }

    public String getContactByAffilliatesFlag() {
        return contactByAffilliatesFlag;
    }

    public void setContactByAffilliatesFlag(String contactByAffilliatesFlag) {
        this.contactByAffilliatesFlag = contactByAffilliatesFlag;
    }

    public String getContactMethodCode() {
        return contactMethodCode;
    }

    public void setContactMethodCode(String contactMethodCode) {
        this.contactMethodCode = contactMethodCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Long getObjectVersionId() {
        return objectVersionId;
    }

    public void setObjectVersionId(Long objectVersionId) {
        this.objectVersionId = objectVersionId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonTypeCode() {
        return personTypeCode;
    }

    public void setPersonTypeCode(String personTypeCode) {
        this.personTypeCode = personTypeCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getProvisionedFlag() {
        return provisionedFlag;
    }

    public void setProvisionedFlag(String provisionedFlag) {
        this.provisionedFlag = provisionedFlag;
    }

    public Timestamp getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Timestamp registeredDate) {
        this.registeredDate = registeredDate;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<AddressUsage> getAddressUsageList() {
        return addressUsageList;
    }

    public void setAddressUsageList(List<AddressUsage> addressUsageList) {
        this.addressUsageList = addressUsageList;
    }

    public AddressUsage addAddressUsage(AddressUsage addressUsage) {
        getAddressUsageList().add(addressUsage);
        addressUsage.setPerson(this);
        return addressUsage;
    }

    public AddressUsage removeAddressUsage(AddressUsage addressUsage) {
        getAddressUsageList().remove(addressUsage);
        addressUsage.setPerson(null);
        return addressUsage;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }
}
