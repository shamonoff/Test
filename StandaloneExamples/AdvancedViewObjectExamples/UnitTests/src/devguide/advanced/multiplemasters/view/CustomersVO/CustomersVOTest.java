package devguide.advanced.multiplemasters.view.CustomersVO;

import devguide.advanced.multiplemasters.applicationModule.AppModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class CustomersVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public CustomersVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Customers");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
