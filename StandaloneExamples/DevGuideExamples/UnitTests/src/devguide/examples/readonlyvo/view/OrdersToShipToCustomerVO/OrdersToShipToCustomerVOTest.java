package devguide.examples.readonlyvo.view.OrdersToShipToCustomerVO;

import devguide.examples.readonlyvo.applicationModule.PersonServiceAMFixture;

import devguide.examples.readonlyvo.queries.PersonsImpl;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class OrdersToShipToCustomerVOTest {
    private PersonServiceAMFixture fixture1 = PersonServiceAMFixture.getInstance();

    public OrdersToShipToCustomerVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("OrdersToShipToCustomer");
        assertNotNull(view);
    }
    
    @Test
    public void testQuery(){
        PersonsImpl view = (PersonsImpl)fixture1.getApplicationModule().findViewObject("PersonList");
        view.setTheName("Nancy");
        ViewObject detailView = fixture1.getApplicationModule().findViewObject("OrdersToShipToCustomer");
        oracle.jbo.domain.Number addressId = (oracle.jbo.domain.Number)detailView.first().getAttribute("ShipToAddressId");
        assertEquals("ShipToAddressId should be 97", "97", addressId.toString());
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
