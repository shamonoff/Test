package devguide.advanced.multiplemasters.view.OrdersVO;

import devguide.advanced.multiplemasters.applicationModule.AppModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class OrdersVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public OrdersVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Orders");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
