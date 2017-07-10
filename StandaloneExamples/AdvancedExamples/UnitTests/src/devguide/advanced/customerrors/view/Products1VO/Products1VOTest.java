package devguide.advanced.customerrors.view.Products1VO;

import devguide.advanced.customerrors.applicationModule.ProductModuleAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class Products1VOTest {
//    private ProductModuleAMFixture fixture1 = ProductModuleAMFixture.getInstance();
    private ApplicationModule am;

    public Products1VOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = am.findViewObject("Products1");
        assertNotNull(view);
    }
    
    @Test
    public void testCustomJBOMessage() {
        ViewObject view = am.findViewObject("Products1");
        try {
            Row productRow = view.first();
            productRow.setAttribute("ProductId", null);
            productRow.validate();            
        }
        catch (JboException ex) {
        assertEquals("Exception should be custom JBO-27014 message", ex.getMessage(), "JBO-27014: You must provide a value for ProductId");
        }        
    }
    
    @Test
    public void testCustomDBMessage() {
        ViewObject view = am.findViewObject("Products1");
        String origValue = view.first().getAttribute("ProductName").toString();
        try {
            view.first().setAttribute("ProductName", "Undefined");
            am.getTransaction().commit();
        }
        catch (JboException ex) {
        assertEquals("Exception should be JBO-27014", ex.getMessage(), "The name cannot begin with the letter u!");
        }        
        view.first().setAttribute("ProductName", origValue);
        am.getTransaction().commit();
    }


    @Before
    public void setUp() {
        am = Configuration.createRootApplicationModule("devguide.advanced.customerrors.ProductModule","ProductModuleLocal");
    }

    @After
    public void tearDown() {
        Configuration.releaseRootApplicationModule(am, true);
    }
}
