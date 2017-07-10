package devguide.examples.readonlyvo.view.AllPendingOrBackorderedOrdersVO;

import devguide.examples.readonlyvo.applicationModule.PersonServiceAMFixture;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class AllPendingOrBackorderedOrdersVOTest {
    private PersonServiceAMFixture fixture1 = PersonServiceAMFixture.getInstance();

    public AllPendingOrBackorderedOrdersVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("AllPendingOrBackorderedOrders");
        assertNotNull(view);
    }
    
    @Test
    public void testQuery(){
        ViewObject view = fixture1.getApplicationModule().findViewObject("AllPendingOrBackorderedOrders");
        view.setRangeSize(-1);
        Row[] pendingOrders = view.getAllRowsInRange();
        for(Row row: pendingOrders){
        String statusCode = (String)row.getAttribute("OrderStatusCode");
            assertNotSame("OrderStatusCode should not be COMPLETE", "COMPLETE", statusCode);
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
