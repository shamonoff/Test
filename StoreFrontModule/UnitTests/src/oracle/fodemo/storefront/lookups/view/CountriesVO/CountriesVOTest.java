package oracle.fodemo.storefront.lookups.view.CountriesVO;

import oracle.fodemo.storefront.lookups.applicationModule.JUnitFixtureLoginInfoProvider;
import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class CountriesVOTest {
    JUnitFixtureLoginInfoProvider infoProvider = new JUnitFixtureLoginInfoProvider("ngreenbe", "welcome1");
    private ApplicationModule _am =  Configuration.createRootApplicationModule("oracle.fodemo.storefront.lookups.LookupServiceAM","LookupServiceAMLocal", infoProvider);

    public CountriesVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = _am.findViewObject("Countries");
        assertNotNull(view);
    }

    @Test
    public void testQuery() {
        ViewObject view = _am.findViewObject("Countries");
        String country = view.first().getAttribute("Value").toString();
        assertEquals("Country should be AF", "AF", country);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        Configuration.releaseRootApplicationModule(_am, true);
    }
}
