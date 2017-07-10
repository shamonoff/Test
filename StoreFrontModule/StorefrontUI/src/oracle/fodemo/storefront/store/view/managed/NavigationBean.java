package oracle.fodemo.storefront.store.view.managed;

import oracle.adf.controller.ControllerContext;


/**
 * Helper Bean to help navigation around the taskflow when normal taskflow
 * processing can't be used.
 */
public class NavigationBean {
    
    public NavigationBean() {
    }


    /**
     * Does nothing.  But it's bean, so we have to have a 'set' method.
     */
    public void setCreateAccountURL() {
    }

    /**
     * Gets the taskflow url to create a new account.
     * @return the URL
     */
    public String getCreateAccountURL() {
        return getCorrectURL("register");
    }


    /**
     * Does nothing.  But it's bean, so we have to have a 'set' method.
     */
    public void setHomeURL() {
    }

    /**
     * Gets the URL to go to the application home page.
     * @return the url.
     */
    public String getHomeURL() {
        return getCorrectURL("home");
    }

    /**
     * works out what the url is to navigate to a view activity in 
     * the unbounded flow.
     * @param view the name of the view activity.
     * @return the url
     */
    private String getCorrectURL(String view) {
        String url = 
            "/" + ControllerContext.getInstance().getGlobalViewActivityURL(view);

        return url;
    }
}
