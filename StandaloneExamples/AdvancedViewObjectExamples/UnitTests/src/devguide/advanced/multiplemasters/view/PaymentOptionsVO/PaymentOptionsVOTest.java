package devguide.advanced.multiplemasters.view.PaymentOptionsVO;

import devguide.advanced.multiplemasters.applicationModule.AppModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class PaymentOptionsVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public PaymentOptionsVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("PaymentOptions");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
