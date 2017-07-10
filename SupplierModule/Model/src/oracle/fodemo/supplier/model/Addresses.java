package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({
  @NamedQuery(name = "Addresses.findAll", query = "select o from Addresses o")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name="ADDRESSES")
public class Addresses implements Serializable, Auditable {
    @Column(nullable = false, length = 40)
    private String address1;
    @Column(length = 40)
    private String address2;
    @Id
    @Column(name="ADDRESS_ID", nullable = false)
    @GeneratedValue(generator = "AddressSeq", 
                    strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AddressSeq", 
                       sequenceName = "ADDRESS_SEQ", 
                       allocationSize = 1)
    private Long addressId;
    @Column(nullable = false, length = 40)
    private String city;
    @Column(name="COUNTRY_ID", nullable = false)
    private String countryId;
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    private Long latitude;
    private Long longitude;
    @Version
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Column(name="POSTAL_CODE", length = 12)
    private String postalCode;
    @Column(name="STATE_PROVINCE", nullable = false, length = 40)
    private String stateProvince;
    @OneToMany(mappedBy = "addresses")
    private List<AddressUsage> addressUsageList;
    @OneToMany(mappedBy = "addresses")
    private List<Person> personList;

    public Addresses() {
    }

    public Addresses(String address1, String address2, Long addressId,
                     String city, String countryId, String createdBy,
                     Timestamp creationDate, Timestamp lastUpdateDate,
                     String lastUpdatedBy, Long latitude, Long longitude,
                     Long objectVersionId, String postalCode,
                     String stateProvince) {
        this.address1 = address1;
        this.address2 = address2;
        this.addressId = addressId;
        this.city = city;
        this.countryId = countryId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.latitude = latitude;
        this.longitude = longitude;
        this.objectVersionId = objectVersionId;
        this.postalCode = postalCode;
        this.stateProvince = stateProvince;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
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

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getObjectVersionId() {
        return objectVersionId;
    }

    public void setObjectVersionId(Long objectVersionId) {
        this.objectVersionId = objectVersionId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public List<AddressUsage> getAddressUsageList() {
        return addressUsageList;
    }

    public void setAddressUsageList(List<AddressUsage> addressUsageList) {
        this.addressUsageList = addressUsageList;
    }

    public AddressUsage addAddressUsage(AddressUsage addressUsage) {
        getAddressUsageList().add(addressUsage);
        addressUsage.setAddresses(this);
        return addressUsage;
    }

    public AddressUsage removeAddressUsage(AddressUsage addressUsage) {
        getAddressUsageList().remove(addressUsage);
        addressUsage.setAddresses(null);
        return addressUsage;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person addPerson(Person person) {
        getPersonList().add(person);
        person.setAddresses(this);
        return person;
    }

    public Person removePerson(Person person) {
        getPersonList().remove(person);
        person.setAddresses(null);
        return person;
    }
}
