package devguide.advanced.xml.queries.view.OrdersViewVO;

import devguide.advanced.xml.queries.applicationModule.AppModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class OrdersViewVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public OrdersViewVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("OrdersView");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
