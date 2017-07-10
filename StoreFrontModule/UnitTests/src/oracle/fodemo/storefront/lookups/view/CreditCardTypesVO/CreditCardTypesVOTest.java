package oracle.fodemo.storefront.lookups.view.CreditCardTypesVO;

import oracle.fodemo.storefront.lookups.applicationModule.JUnitFixtureLoginInfoProvider;
import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class CreditCardTypesVOTest {
    JUnitFixtureLoginInfoProvider infoProvider = new JUnitFixtureLoginInfoProvider("ngreenbe", "welcome1");
    private ApplicationModule _am =  Configuration.createRootApplicationModule("oracle.fodemo.storefront.lookups.LookupServiceAM","LookupServiceAMLocal", infoProvider);

    public CreditCardTypesVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = _am.findViewObject("CreditCardTypes");
        assertNotNull(view);
    }
    
    @Test
    public void testViewCriteria() {
        ViewObject view = _am.findViewObject("CreditCardTypes");
        Row[] allRows = view.getAllRowsInRange();
        for (Row row : allRows) {
            String lookupTypeAttr = row.getAttribute("Type").toString();
            assertEquals("LookupType should be CARD_TYPE_CODE", "CARD_TYPE_CODE", lookupTypeAttr);
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        Configuration.releaseRootApplicationModule(_am, true);
    }
}
