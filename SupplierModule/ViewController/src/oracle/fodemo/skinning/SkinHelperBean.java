package oracle.fodemo.skinning;

import java.io.IOException;

import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.nav.RichCommandMenuItem;

import oracle.fodemo.supplier.view.utils.JSFUtils;


public class SkinHelperBean {


    private String _skinFamily = _RICH_DEMO_SKIN;

    static private final String _SKIN_TEST_DIRECTORY_INPUT =
        "/skinningKeys/input";
    static private final String _SKIN_TEST_DIRECTORY_SELECT =
        "/skinningKeys/select";
    static private final String _SKIN_TEST_DIRECTORY = "/skinningKeys";
    static private final String _TEST_SKIN_INPUT_SELECT =
        "demoComponentsInputSelect";
    static private final String _TEST_SKIN_INPUT_OTHER = "demoComponentsOther";
    static private final String _RICH_DEMO_SKIN = "fusion";

    public SkinHelperBean() {
    }

    public void skinMenuAction(ActionEvent ae) {
        RichCommandMenuItem menuItem = (RichCommandMenuItem)ae.getComponent();
        setSkinFamily(menuItem.getText());
        reloadThePage();
    }

    private void reloadThePage() {
        FacesContext fContext = FacesContext.getCurrentInstance();
        String viewId = fContext.getViewRoot().getViewId();
        String actionUrl =
            fContext.getApplication().getViewHandler().getActionURL(fContext,
                                                                    viewId);
        try {
            ExternalContext eContext = fContext.getExternalContext();
            String resourceUrl =
                actionUrl; //eContext.encodeResourceURL(actionUrl);
            // Use the action URL directly since the encoding a resource URL will NPE in isEmailablePage()
            eContext.redirect(resourceUrl);
        } catch (IOException ioe) {
            System.err.println("Problem trying to reload the page:");
            ioe.printStackTrace();
        }
    }

    public String getSkinFamily() {
        // If we're in the skin component tests, return the skinComponentTest skin.
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = context.getViewRoot();
        if ((viewRoot != null) &&
            (viewRoot.getViewId().indexOf(_SKIN_TEST_DIRECTORY) >= 0)) {
            String viewId = viewRoot.getViewId();

            if (viewId != null && viewId.indexOf(_SKIN_TEST_DIRECTORY) >= 0) {
                if ((viewId.indexOf(_SKIN_TEST_DIRECTORY_INPUT) >= 0) ||
                    (viewId.indexOf(_SKIN_TEST_DIRECTORY_SELECT) >= 0))
                    return _TEST_SKIN_INPUT_SELECT;
                else
                    return _TEST_SKIN_INPUT_OTHER;

            }

        }

        return _skinFamily;
    }

    public void setSkinFamily(String family) {
        _skinFamily = family;
    }

}
