package devguide.advanced.baseproject.extsub.view.ProductsByNameVO;

import devguide.advanced.baseproject.extsub.applicationModule.ProductsModuleAMFixture;

import devguide.advanced.baseproject.extsub.common.Products;
import devguide.advanced.baseproject.extsub.common.ProductsByName;
import devguide.advanced.baseproject.extsub.common.ProductsByNameRow;
import devguide.advanced.baseproject.extsub.common.ProductsRow;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductsByNameVOTest {
    private ApplicationModule am;

    public ProductsByNameVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = am.findViewObject("ProductsByName");
        assertNotNull(view);
    }
    
    @Test
    public void testProductsMethod(){
        Products view = (Products)am.findViewObject("ProductsByName");
        ProductsByName productsByName = (ProductsByName)view;
        productsByName.settheProductName("Ipod");
        ProductsRow product = (ProductsRow)view.first();
        String productId = product.getAttribute("ProductId").toString();
        assertEquals("ProductId should be 15", "15", productId);
        ProductsByNameRow productByName = (ProductsByNameRow)product;
        productByName.someExtraFeature("Test");    
        product.setProductName("Q");
        String productName = product.getAttribute("ProductName").toString();
        String extraAttr = product.getStructureDef().getAttributeDef(3).getName();
        assertEquals("ProductName should be Q", "Q", productName);      
        assertEquals("Additional attribute should be present", "SomeExtraAttr", extraAttr);      
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
