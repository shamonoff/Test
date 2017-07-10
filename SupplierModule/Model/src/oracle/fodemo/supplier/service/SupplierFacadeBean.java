package oracle.fodemo.supplier.service;

import java.sql.Timestamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;

import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import oracle.fodemo.supplier.model.AddressUsage;
import oracle.fodemo.supplier.model.Addresses;
import oracle.fodemo.supplier.model.CountryCode;
import oracle.fodemo.supplier.model.CountryCodePK;
import oracle.fodemo.supplier.model.LookupCode;
import oracle.fodemo.supplier.model.OrderItem;
import oracle.fodemo.supplier.model.OrderItemPK;
import oracle.fodemo.supplier.model.Person;
import oracle.fodemo.supplier.model.Product;
import oracle.fodemo.supplier.model.ProductCategory;
import oracle.fodemo.supplier.model.ProductImage;
import oracle.fodemo.supplier.model.ProductTranslation;
import oracle.fodemo.supplier.model.ProductTranslationPK;
import oracle.fodemo.supplier.model.Supplier;
import oracle.fodemo.supplier.model.WarehouseStockLevel;
import oracle.fodemo.supplier.model.WarehouseStockLevelPK;

@Stateless(name = "SupplierFacade",
           mappedName = "SupplierModule_2.0-Model-SupplierFacade")
@Remote
@Local
public class SupplierFacadeBean implements SupplierFacade,
                                           SupplierFacadeLocal {

    @PersistenceContext(unitName = "Model")
    private EntityManager em;
    @Resource
    private SessionContext sessionContext;

    public SupplierFacadeBean() {
    }

    /**
     * Used by the query component
     * @param jpqlStmt
     * @param firstResult
     * @param maxResults
     * @return
     */
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {

        jpqlStmt = preProcessQuery(jpqlStmt);
        System.out.println("Query::" + jpqlStmt);
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    /**
     * This is a work around to append logged in users credential to the where
     * clause while searching products
     * @param jpqlStmt
     * @return
     */
    private String preProcessQuery(String jpqlStmt) {
        int index = jpqlStmt.indexOf(":loggedInSupplierId");
        if (index != -1) {
            Long id = getSupplierId(null);
            jpqlStmt =
                    jpqlStmt.replaceFirst(":loggedInSupplierId", id.toString());
        }
        return jpqlStmt;

    }

    /**
     * Gets the supplier id for the principal passed,
     * if principal is n ull returns current users supplier id
     * @param principal
     * @return
     */
    private Long getSupplierId(String principal) {
        if (principal == null) {
            principal = sessionContext.getCallerPrincipal().getName();
        }
        Long supplierId = -1L;
        try {
            Person person =
                (Person)em.createNamedQuery("Person.findByPrincipal").setParameter("principal",
                                                                                   principal).getSingleResult();
            Supplier supplier = person.getSupplier();
            supplierId = supplier.getSupplierId();
        } catch (javax.persistence.NoResultException eb) {
            System.err.println(eb.getMessage());
        }
        return supplierId;
    }

    public Addresses persistAddresses(Addresses addresses) {

        em.persist(addresses);
        return addresses;
    }

    public Addresses mergeAddresses(Addresses addresses) {

        return em.merge(addresses);
    }

    public void removeAddresses(Addresses addresses) {
        addresses = em.find(Addresses.class, addresses.getAddressId());
        em.remove(addresses);
    }

    /** <code>select o from Addresses o</code> */
    public List<Addresses> getAddressesFindAll() {
        return em.createNamedQuery("Addresses.findAll").getResultList();
    }

    public ProductTranslation persistProductTranslation(ProductTranslation productTranslation) {
        em.persist(productTranslation);
        return productTranslation;
    }

    public ProductTranslation mergeProductTranslation(ProductTranslation productTranslation) {
        return em.merge(productTranslation);
    }

    public void removeProductTranslation(ProductTranslation productTranslation) {
        productTranslation =
                em.find(ProductTranslation.class, new ProductTranslationPK(productTranslation.getLanguage(),
                                                                           productTranslation.getProductId()));
        em.remove(productTranslation);
    }

    /** <code>select o from ProductTranslation o</code> */
    public List<ProductTranslation> getProductTranslationFindAll() {
        return em.createNamedQuery("ProductTranslation.findAll").getResultList();
    }

    public AddressUsage persistAddressUsage(AddressUsage addressUsage) {

        em.persist(addressUsage);
        return addressUsage;
    }

    public AddressUsage mergeAddressUsage(AddressUsage addressUsage) {

        return em.merge(addressUsage);
    }

    public void removeAddressUsage(AddressUsage addressUsage) {
        addressUsage =
                em.find(AddressUsage.class, addressUsage.getAddressUsagesId());
        em.remove(addressUsage);
    }

    /** <code>select o from AddressUsage o</code> */
    public List<AddressUsage> getAddressUsageFindAll() {
        return em.createNamedQuery("AddressUsage.findAll").getResultList();
    }

    public WarehouseStockLevel persistWarehouseStockLevel(WarehouseStockLevel warehouseStockLevel) {
        em.persist(warehouseStockLevel);
        return warehouseStockLevel;
    }

    public WarehouseStockLevel mergeWarehouseStockLevel(WarehouseStockLevel warehouseStockLevel) {
        return em.merge(warehouseStockLevel);
    }

    public void removeWarehouseStockLevel(WarehouseStockLevel warehouseStockLevel) {
        warehouseStockLevel =
                em.find(WarehouseStockLevel.class, new WarehouseStockLevelPK(warehouseStockLevel.getProductId(),
                                                                             warehouseStockLevel.getWarehouseId()));
        em.remove(warehouseStockLevel);
    }

    /** <code>select o from WarehouseStockLevel o</code> */
    public List<WarehouseStockLevel> getWarehouseStockLevelFindAll() {
        return em.createNamedQuery("WarehouseStockLevel.findAll").getResultList();
    }

    public OrderItem persistOrderItem(OrderItem orderItem) {
        em.persist(orderItem);
        return orderItem;
    }

    public OrderItem mergeOrderItem(OrderItem orderItem) {
        return em.merge(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItem =
                em.find(OrderItem.class, new OrderItemPK(orderItem.getLineItemId(),
                                                         orderItem.getOrderId()));
        em.remove(orderItem);
    }

    /** <code>select o from OrderItem o</code> */
    public List<OrderItem> getOrderItemFindAll() {
        return em.createNamedQuery("OrderItem.findAll").getResultList();
    }

    public Person persistPerson(Person person) {

        em.persist(person);
        return person;
    }

    public Person mergePerson(Person person) {

        return em.merge(person);
    }

    public void removePerson(Person person) {
        person = em.find(Person.class, person.getPersonId());
        em.remove(person);
    }

    /** <code>select o from Person o</code> */
    public List<Person> getPersonFindAll() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    public ProductCategory persistProductCategory(ProductCategory productCategory) {
        em.persist(productCategory);
        return productCategory;
    }

    public ProductCategory mergeProductCategory(ProductCategory productCategory) {
        return em.merge(productCategory);
    }

    public void removeProductCategory(ProductCategory productCategory) {
        productCategory =
                em.find(ProductCategory.class, productCategory.getCategoryId());
        em.remove(productCategory);
    }

    /** <code>select o from ProductCategory o</code> */
    public List<ProductCategory> getProductCategoryFindAll() {
        return em.createNamedQuery("ProductCategory.findAll").getResultList();
    }

    public Product persistProduct(Product product) {
        em.persist(product);
        return product;
    }

    public Product mergeProduct(Product product) {
        return em.merge(product);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void removeProduct(Product product) {
        /** hack for removing images as declarative cascade fails*/
        executeUpdateForProduct("ProductImage.deleteByProduct",
                                product.getProductId());
        executeUpdateForProduct("ProductTranslation.deleteByProduct",
                                product.getProductId());

        product = em.find(Product.class, product.getProductId());
        em.remove(product);
    }

    private int executeUpdateForProduct(String queryName, Long prodIcd) {
        Query cascadeQuery =
            em.createNamedQuery(queryName).setParameter("productId", prodIcd);

        int i = cascadeQuery.executeUpdate();
        System.out.println("query " + queryName + " update cnt : " + i);
        return i;
    }

    /** <code>select o from Product o</code> */
    public List<Product> getProductFindAll() {
        return em.createNamedQuery("Product.findAll").getResultList();
    }

    public Supplier persistSupplier(Supplier supplier) {


        em.persist(supplier);
        return supplier;
    }

    public Supplier mergeSupplier(Supplier supplier) {

        return em.merge(supplier);
    }

    public void removeSupplier(Supplier supplier) {
        supplier = em.find(Supplier.class, supplier.getSupplierId());
        em.remove(supplier);
    }

    /** <code>select o from Supplier o</code> */
    public List<Supplier> getSupplierFindAll() {
        return em.createNamedQuery("Supplier.findAll").getResultList();
    }

    public ProductImage persistProductImage(ProductImage productImage) {
        em.persist(productImage);
        return productImage;
    }

    public ProductImage mergeProductImage(ProductImage productImage) {
        return em.merge(productImage);
    }

    public void removeProductImage(ProductImage productImage) {
        productImage =
                em.find(ProductImage.class, productImage.getProductImageId());
        em.remove(productImage);
    }

    /** <code>select o from ProductImage o</code> */
    public List<ProductImage> getProductImageFindAll() {
        return em.createNamedQuery("ProductImage.findAll").getResultList();
    }

    public CountryCode persistCountryCode(CountryCode countryCode) {
        em.persist(countryCode);
        return countryCode;
    }

    public CountryCode mergeCountryCode(CountryCode countryCode) {
        return em.merge(countryCode);
    }

    public void removeCountryCode(CountryCode countryCode) {
        countryCode =
                em.find(CountryCode.class, new CountryCodePK(countryCode.getIsoCountryCode(),
                                                             countryCode.getLanguage()));
        em.remove(countryCode);
    }

    public Product findProductById(Long productId) {
        return (Product)em.createNamedQuery("Product.findById").setParameter("id",
                                                                             productId).getSingleResult();
    }

    /** <code>select o from CountryCode o</code> */
    public List<CountryCode> getCountryCodeFindAll() {
        return em.createNamedQuery("CountryCode.findAll").getResultList();
    }

    /**
     * Gets the Supplier instance
     * @return Supplier
     */
    public Supplier getSupplier() {
        Supplier supplier = new Supplier();
        return supplier;
    }

    /**
     * Gets the Person instance
     * @return Person
     */
    public Person getPerson() {
        Person person = new Person();
        return person;
    }

    /**
     * Gets the Person instance
     * @return Person
     */
    public Addresses getAddresses() {
        Addresses addresses = new Addresses();
        return addresses;
    }

    /**
     * Accessor Method, to create Product
     * @return Product
     */
    public Product getProduct() {
        Product product = new Product();
        Long id = getSupplierId(null);
        Supplier supplier = new Supplier();
        supplier.setSupplierId(id);
        product.setSupplier(supplier);
        return product;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void saveSupplierDetails(Supplier supplier, Person person) {
        supplier.setSupplierStatus("INACTIVE");

        person.setPersonTypeCode("SHIP");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        person.setRegisteredDate(now);
        Addresses address = person.getAddresses();

        AddressUsage usage = new AddressUsage();
        usage.setAddresses(address);

        usage.setOwnerTypeCode("SHIP");
        usage.setPerson(person);
        usage.setUsageTypeCode("SH");
        usage.setExpiredFlag("N");

        person.setAddressUsageList(Arrays.asList(usage));

        person.setContactableFlag("N");
        person.setContactByAffilliatesFlag("N");
        person.setSupplier(supplier);
        persistSupplier(supplier);

        persistPerson(person);
    }
}
