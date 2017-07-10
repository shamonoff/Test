package devguide.advanced.multiplemasters.view.PaymentOptions1VO;

import devguide.advanced.multiplemasters.applicationModule.AppModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class PaymentOptions1VOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public PaymentOptions1VOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("PaymentOptions1");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
