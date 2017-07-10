package oracle.fodemo.storefront.lookups.view.HelpTranslationsVO;

import oracle.fodemo.storefront.lookups.applicationModule.JUnitFixtureLoginInfoProvider;
import oracle.fodemo.storefront.lookups.applicationModule.LookupServiceAMFixture;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.client.Configuration;

import org.junit.*;
import static org.junit.Assert.*;

public class HelpTranslationsVOTest {
    JUnitFixtureLoginInfoProvider infoProvider = new JUnitFixtureLoginInfoProvider("ngreenbe", "welcome1");
    private ApplicationModule _am =  Configuration.createRootApplicationModule("oracle.fodemo.storefront.lookups.LookupServiceAM","LookupServiceAMLocal", infoProvider);

    public HelpTranslationsVOTest() {
    }

    @Test
    public void testAccess() {
        ViewObject view = _am.findViewObject("HelpTranslations");
        assertNotNull(view);
    }
    
    @Test
    public void testQuery() {
        ViewObject view = _am.findViewObject("HelpTranslations");
        view.setNamedWhereClauseParam("bv_HelpId", 102);
        ViewCriteriaManager vcm = view.getViewCriteriaManager();
        ViewCriteria criteria = vcm.getViewCriteria("HelpTranslationsVOCriteria");
        view.applyViewCriteria(criteria);
        String text = view.first().getAttribute("HelpText").toString();
        assertEquals("Text should start with", "Add a billing address", text.substring(0, 21));
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        Configuration.releaseRootApplicationModule(_am, true);
    }
}
