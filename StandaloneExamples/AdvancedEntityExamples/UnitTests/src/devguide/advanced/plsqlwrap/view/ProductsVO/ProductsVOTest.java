package devguide.advanced.plsqlwrap.view.ProductsVO;

import devguide.advanced.inheritance.PersonsImpl;
import devguide.advanced.plsqlwrap.ProductsImpl;
import devguide.advanced.plsqlwrap.applicationModule.ProductsModuleAMFixture;

import oracle.jbo.ViewObject;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductsVOTest {
    private ProductsModuleAMFixture fixture1 = ProductsModuleAMFixture.getInstance();

    public ProductsVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = fixture1.getApplicationModule().findViewObject("ProductsVO");
        assertNotNull(view);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
}
