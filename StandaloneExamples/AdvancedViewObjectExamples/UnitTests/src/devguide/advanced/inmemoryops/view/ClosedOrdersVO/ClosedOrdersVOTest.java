package devguide.advanced.inmemoryops.view.ClosedOrdersVO;

import devguide.advanced.inmemoryops.applicationModule.AppModuleAMFixture;

import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class ClosedOrdersVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public ClosedOrdersVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("ClosedOrders");
        assertNotNull(view);
    }
    
    @Test      
    public void testInMemorySort(){
        ViewObject view = fixture1.getApplicationModule().findViewObject("ClosedOrders");
//      view.executeQuery();
      String firstOrder = view.first().getAttribute("OrderId").toString();
      view.setSortBy("Customer desc");
      view.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
      view.executeQuery();
      String sortedOrder = view.first().getAttribute("OrderId").toString();
      assertTrue("OrderIds should not be equal", firstOrder != sortedOrder);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
