package oracle.fodemo.storefront.lookups.view.MaritalStatusTypesVO;

import oracle.fodemo.storefront.lookups.applicationModule.JUnitFixtureLoginInfoProvider;
import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class MaritalStatusTypesVOTest {
    JUnitFixtureLoginInfoProvider infoProvider = new JUnitFixtureLoginInfoProvider("ngreenbe", "welcome1");
    private ApplicationModule _am =  Configuration.createRootApplicationModule("oracle.fodemo.storefront.lookups.LookupServiceAM","LookupServiceAMLocal", infoProvider);

    public MaritalStatusTypesVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = _am.findViewObject("MaritalStatusTypes");
        assertNotNull(view);
    }
    
    @Test
    public void testViewCriteria() {
        ViewObject view = _am.findViewObject("MaritalStatusTypes");
        Row[] allRows = view.getAllRowsInRange();
        for (Row row : allRows) {
            String lookupTypeAttr = row.getAttribute("Type").toString();
            assertEquals("LookupType should be MARITAL_STATUS_CODE", "MARITAL_STATUS_CODE", lookupTypeAttr);
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
