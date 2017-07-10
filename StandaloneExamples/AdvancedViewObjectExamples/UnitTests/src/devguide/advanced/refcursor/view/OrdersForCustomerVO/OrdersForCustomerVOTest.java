package devguide.advanced.refcursor.view.OrdersForCustomerVO;

import devguide.advanced.refcursor.applicationModule.OrdersModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class OrdersForCustomerVOTest {
    private OrdersModuleAMFixture fixture1 = OrdersModuleAMFixture.getInstance();

    public OrdersForCustomerVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("OrdersForCustomer");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
