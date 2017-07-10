package devguide.examples.appmodules;

import devguide.examples.appmodules.common.StoreFrontService;

import devguide.examples.entities.OrdersEOImpl;

import devguide.examples.entities.PersonsEOImpl;

import devguide.examples.entities.ProductsBaseEOImpl;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------

 /**
  * This custom application module class illustrates the same
  * example methods as StoreFrontService2Impl.java, except that here
  * we're using the generic EntityImpl class for working with
  * Orders, Persons, and ProductsBase entity objects instead of
  * using the strongly-typed custom entity object classes.
  */

public class StoreFrontServiceImpl extends ApplicationModuleImpl implements StoreFrontService {
    /**This is the default constructor (do not remove).
     */
    public StoreFrontServiceImpl() {
    }
    
    private EntityImpl retrieveOrderById(long orderId) {
      String entityName = "devguide.examples.entities.OrdersEO";
      EntityDefImpl orderDef = EntityDefImpl.findDefObject(entityName);
      Key orderKey = new Key(new Object[]{orderId});
      return orderDef.findByPrimaryKey(getDBTransaction(),orderKey);
    }

    
    /*
     * Find an Order by Id
     */
    public String findOrderTotal(long orderId) {
      EntityImpl order = retrieveOrderById(orderId);
      if (order != null) {
        return (String)order.getAttribute("OrderTotal").toString();
      }
      return null;
    }
    
    /*
     * Access an associated Customer entity from the Order entity
     */  
    public String findOrderCustomer(long orderId) {
      EntityImpl order = retrieveOrderById(orderId);
      if (order != null) {
        EntityImpl cust  = (EntityImpl)order.getAttribute("PersonsEO");
        if (cust != null) {
          return cust.getAttribute("FirstName") + " " + cust.getAttribute("LastName");
        }
        else {
          return "Unassigned";
        }
      }
      else {
        return null;
      }
    }  
    
    /*
     * Update the status of an existing order
     */  
    public void updateOrderStatus(long orderId, String newStatus) {
      EntityImpl order = retrieveOrderById(orderId);
      if (order != null) {
        order.setAttribute("OrderStatusCode", newStatus);
        try {
          getDBTransaction().commit();
        }
        catch (JboException ex) {
          getDBTransaction().rollback();
          throw ex;
        }
      }
    }    
    /*
     * Create a new Product and Return its new id
     */
    public long createProduct(String name, String status, String shipCode) {
      String entityName = "devguide.examples.entities.ProductsBaseEO";
      EntityDefImpl productDef = EntityDefImpl.findDefObject(entityName);
      EntityImpl newProduct = productDef.createInstance2(getDBTransaction(),null);
      newProduct.setAttribute("ProductName",name);
      newProduct.setAttribute("ProductStatus",status);
      newProduct.setAttribute("ShippingClassCode", shipCode);
      newProduct.setAttribute("SupplierId", new Number(100));
      newProduct.setAttribute("ListPrice", new Number(499));
      newProduct.setAttribute("MinPrice", new Number(479));
      newProduct.setAttribute("CreatedBy", "Test Client");
      newProduct.setAttribute("LastUpdatedBy", "Test Client");
      newProduct.setAttribute("CategoryId", new Number(5));
      try {
        getDBTransaction().commit();
      }
      catch (JboException ex) {
        getDBTransaction().rollback();
        throw ex;
      }
      DBSequence newIdAssigned = (DBSequence)newProduct.getAttribute("ProductId");
      return newIdAssigned.getSequenceNumber().longValue();
    }
}
