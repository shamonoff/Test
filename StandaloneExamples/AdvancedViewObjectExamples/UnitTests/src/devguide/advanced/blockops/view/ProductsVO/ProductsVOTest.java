package devguide.advanced.blockops.view.ProductsVO;

import devguide.advanced.blockops.applicationModule.AppModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductsVOTest {
    private AppModuleAMFixture fixture1 = AppModuleAMFixture.getInstance();

    public ProductsVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("Products");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
