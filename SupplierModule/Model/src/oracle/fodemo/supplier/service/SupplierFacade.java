package oracle.fodemo.supplier.service;

import java.util.List;

import javax.ejb.Remote;

import oracle.fodemo.supplier.model.AddressUsage;
import oracle.fodemo.supplier.model.Addresses;
import oracle.fodemo.supplier.model.CountryCode;
import oracle.fodemo.supplier.model.LookupCode;
import oracle.fodemo.supplier.model.OrderItem;
import oracle.fodemo.supplier.model.Person;
import oracle.fodemo.supplier.model.Product;
import oracle.fodemo.supplier.model.ProductCategory;
import oracle.fodemo.supplier.model.ProductImage;
import oracle.fodemo.supplier.model.ProductTranslation;
import oracle.fodemo.supplier.model.Supplier;
import oracle.fodemo.supplier.model.WarehouseStockLevel;

@Remote
public interface SupplierFacade {

    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    Addresses persistAddresses(Addresses addresses);

    Addresses mergeAddresses(Addresses addresses);

    void removeAddresses(Addresses addresses);

    List<Addresses> getAddressesFindAll();

    ProductTranslation persistProductTranslation(ProductTranslation productTranslation);

    ProductTranslation mergeProductTranslation(ProductTranslation productTranslation);

    void removeProductTranslation(ProductTranslation productTranslation);

    List<ProductTranslation> getProductTranslationFindAll();

    AddressUsage persistAddressUsage(AddressUsage addressUsage);

    AddressUsage mergeAddressUsage(AddressUsage addressUsage);

    void removeAddressUsage(AddressUsage addressUsage);

    List<AddressUsage> getAddressUsageFindAll();

    WarehouseStockLevel persistWarehouseStockLevel(WarehouseStockLevel warehouseStockLevel);

    WarehouseStockLevel mergeWarehouseStockLevel(WarehouseStockLevel warehouseStockLevel);

    void removeWarehouseStockLevel(WarehouseStockLevel warehouseStockLevel);

    List<WarehouseStockLevel> getWarehouseStockLevelFindAll();

    OrderItem persistOrderItem(OrderItem orderItem);

    OrderItem mergeOrderItem(OrderItem orderItem);

    void removeOrderItem(OrderItem orderItem);

    List<OrderItem> getOrderItemFindAll();

    Person persistPerson(Person person);

    Person mergePerson(Person person);

    void removePerson(Person person);

    List<Person> getPersonFindAll();

    ProductCategory persistProductCategory(ProductCategory productCategory);

    ProductCategory mergeProductCategory(ProductCategory productCategory);

    void removeProductCategory(ProductCategory productCategory);

    List<ProductCategory> getProductCategoryFindAll();

    Product persistProduct(Product product);

    Product mergeProduct(Product product);

    void removeProduct(Product product);

    List<Product> getProductFindAll();

    Supplier persistSupplier(Supplier supplier);

    Supplier mergeSupplier(Supplier supplier);

    void removeSupplier(Supplier supplier);

    List<Supplier> getSupplierFindAll();

    ProductImage persistProductImage(ProductImage productImage);

    ProductImage mergeProductImage(ProductImage productImage);

    void removeProductImage(ProductImage productImage);

    List<ProductImage> getProductImageFindAll();

    CountryCode persistCountryCode(CountryCode countryCode);

    CountryCode mergeCountryCode(CountryCode countryCode);

    void removeCountryCode(CountryCode countryCode);

    Product findProductById(Long productId);
        
    List<CountryCode> getCountryCodeFindAll();

    Supplier getSupplier();

    Person getPerson();

    Addresses getAddresses();

    Product getProduct();

    void saveSupplierDetails(Supplier supplier, Person person);


}
