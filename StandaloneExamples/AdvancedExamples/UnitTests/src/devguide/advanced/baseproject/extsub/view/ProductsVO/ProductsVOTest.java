package devguide.advanced.baseproject.extsub.view.ProductsVO;

import devguide.advanced.baseproject.extsub.applicationModule.ProductsModuleAMFixture;

import devguide.advanced.baseproject.extsub.common.Products;
import devguide.advanced.baseproject.extsub.common.ProductsRow;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductsVOTest {
    private ApplicationModule am;

    public ProductsVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = am.findViewObject("Products");
        assertNotNull(view);
    }
    
    @Test
    public void testProductsMethod(){
        Products view = (Products)am.findViewObject("Products");
        ProductsRow product = (ProductsRow)view.first();
        String productId = product.getAttribute("ProductId").toString();
        assertEquals("ProductId should be 1", "1", productId);
        product.setProductName("Q");
        String productName = product.getAttribute("ProductName").toString();
        assertEquals("ProductName should be Q", "Q", productName);
    }

    @Before
    public void setUp() {
        am = Configuration.createRootApplicationModule("devguide.advanced.baseproject.extsub.ProductsModule","ProductsModuleLocal");
    }

    @After
    public void tearDown() {
        Configuration.releaseRootApplicationModule(am, true);
    }
}
