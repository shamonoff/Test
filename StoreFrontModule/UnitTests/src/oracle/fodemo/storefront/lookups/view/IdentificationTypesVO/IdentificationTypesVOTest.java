package oracle.fodemo.storefront.lookups.view.IdentificationTypesVO;

import oracle.fodemo.storefront.lookups.applicationModule.JUnitFixtureLoginInfoProvider;
import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class IdentificationTypesVOTest {
    JUnitFixtureLoginInfoProvider infoProvider = new JUnitFixtureLoginInfoProvider("ngreenbe", "welcome1");
    private ApplicationModule _am =  Configuration.createRootApplicationModule("oracle.fodemo.storefront.lookups.LookupServiceAM","LookupServiceAMLocal", infoProvider);

    public IdentificationTypesVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = _am.findViewObject("IdentificationTypes");
        assertNotNull(view);
    }
    
    @Test
    public void testViewCriteria() {
        ViewObject view = _am.findViewObject("IdentificationTypes");
        Row[] allRows = view.getAllRowsInRange();
        for (Row row : allRows) {
            String lookupTypeAttr = row.getAttribute("Type").toString();
            assertEquals("LookupType should be ID_TYPE_CODE", "ID_TYPE_CODE", lookupTypeAttr);
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
