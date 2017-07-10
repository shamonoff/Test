package devguide.examples.appmodules.applicationModule;

import devguide.examples.appmodules.common.StoreFrontService;

import oracle.jbo.JboException;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class StoreFrontServiceAMTest {
    private StoreFrontService _amImpl;


    public StoreFrontServiceAMTest() {
        _amImpl = (StoreFrontService)Configuration.createRootApplicationModule("devguide.examples.appmodules.StoreFrontService","StoreFrontServiceLocal");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFindOrderTotal() {
        String total = _amImpl.findOrderTotal(1011);
        assertEquals("OrderTotal should be 99.99", "99.99", total);
    }

    @Test
    public void testFindOrderCustomer() {
        String custName = _amImpl.findOrderCustomer(1011);
        assertEquals("CustomerName should be JohnChen", "John Chen", custName);
    }

    @Test
    public void testUpdateOrderStatus() {
        _amImpl.updateOrderStatus(1011,"CANCEL");
        String total = _amImpl.findOrderTotal(1011);
        assertEquals("OrderTotal should be 99.99", "99.99", total);
    }

    @Test
    public void testCreateProductWithNull() {
        long id = 0;
        try {
          id = _amImpl.createProduct(null, "NEW", "CLASS1");
        }
        catch (JboException ex) {
        assertEquals("Exception should be JBO-27014", ex.getErrorCode(), "27014");
        }
    }
    
    @Test
    public void testCreateProduct() {
        long id = 0;
        id = _amImpl.createProduct("Canon PowerShot G9", "NEW", "CLASS1");
        assertTrue("ProductId should be greater than 100", id > 100);
//        assertEquals("ProductId should be greater than 100", "100", id);
    }
}
