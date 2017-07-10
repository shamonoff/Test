package devguide.advanced.blockops.view.ProductsNoDeleteVO;

import devguide.advanced.blockops.applicationModule.AppModuleAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class ProductsNoDeleteVOTest {
    private ApplicationModule am;


    public ProductsNoDeleteVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = am.findViewObject("ProductsNoDelete");
        assertNotNull(view);
    }

    @Test
    public void testDeleteFails(){  
    ViewObject view = am.findViewObject("ProductsNoDelete");
        try{
        view.first().remove();
        }catch (JboException ex){
            assertEquals("Exception should be 'Insert not allowed in this view'", ex.getDetailMessage(), "Delete not allowed in this view");
        } 
        }
    
    @Test
    public void testUpdate(){  
    ViewObject view = am.findViewObject("ProductsNoDelete");
        view.first().setAttribute("ProductName", "TestDelete");
        assertEquals("view", view.first().getAttribute("ProductName"), "TestDelete");
    }

    @Before
    public void setUp() {
        am = Configuration.createRootApplicationModule("devguide.advanced.blockops.AppModule","AppModuleLocal");
    }

    @After
    public void tearDown() {
        Configuration.releaseRootApplicationModule(am, true);
    }
}
