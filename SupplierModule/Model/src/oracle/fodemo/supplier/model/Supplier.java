package oracle.fodemo.supplier.model;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({
  @NamedQuery(name = "Supplier.findAll", query = "select o from Supplier o")
})
@EntityListeners({AuditableEntityListener.class})
@Table(name = "SUPPLIERS")
public class Supplier implements Serializable, Auditable {
    @Column(name="CREATED_BY", nullable = false, length = 60)
    private String createdBy;
    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate;
    private String email;
    @Column(name="LAST_UPDATED_BY", nullable = false, length = 60)
    private String lastUpdatedBy;
    @Column(name="LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;
    @Version
    @Column(name="OBJECT_VERSION_ID", nullable = false)
    private Long objectVersionId;
    @Column(name="PHONE_NUMBER", length = 20)
    private String phoneNumber;
    @Id
    @Column(name="SUPPLIER_ID", nullable = false)
    private Long supplierId;
    @Column(name="SUPPLIER_NAME", nullable = false, length = 120)
    private String supplierName;
    @Column(name="SUPPLIER_STATUS", nullable = false, length = 30)
    private String supplierStatus;
    @Column(name="UI_SKIN", length = 60)
    private String uiSkin;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "supplier")
    private List<Person> personList;
    @OneToMany(mappedBy = "supplier")
    private List<Product> productList;

    public Supplier() {
    }

    public Supplier(String createdBy, Timestamp creationDate, String email,
                    Timestamp lastUpdateDate, String lastUpdatedBy,
                    Long objectVersionId, String phoneNumber, Long supplierId,
                    String supplierName, String supplierStatus,
                    String uiSkin) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.email = email;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.objectVersionId = objectVersionId;
        this.phoneNumber = phoneNumber;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierStatus = supplierStatus;
        this.uiSkin = uiSkin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getObjectVersionId() {
        return objectVersionId;
    }

    public void setObjectVersionId(Long objectVersionId) {
        this.objectVersionId = objectVersionId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public String getUiSkin() {
        return uiSkin;
    }

    public void setUiSkin(String uiSkin) {
        this.uiSkin = uiSkin;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person addPerson(Person person) {
        getPersonList().add(person);
        person.setSupplier(this);
        return person;
    }

    public Person removePerson(Person person) {
        getPersonList().remove(person);
        person.setSupplier(null);
        return person;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product addProduct(Product product) {
        getProductList().add(product);
        product.setSupplier(this);
        return product;
    }

    public Product removeProduct(Product product) {
        getProductList().remove(product);
        product.setSupplier(null);
        return product;
    }
}
