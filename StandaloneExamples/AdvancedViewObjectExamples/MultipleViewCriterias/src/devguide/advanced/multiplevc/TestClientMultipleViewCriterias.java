package devguide.advanced.multiplevc;

import devguide.advanced.multiplevc.common.PersonsView;

import oracle.jbo.*;
import oracle.jbo.client.Configuration;

public class TestClientMultipleViewCriterias {
    public static void main(String[] args) {
        String amDef = "devguide.advanced.multiplevc.AppModule";
        String config = "AppModuleLocal";
        ApplicationModule am = 
            Configuration.createRootApplicationModule(amDef, config);
        PersonsView vo = (PersonsView)am.findViewObject("PersonsView");
        vo.showMaleCustomers();
        showResults(vo, "After applying view criterias for male customers");
        vo.applyViewCriteria(null);
        vo.showFemaleStaff();
        showResults(vo, "After applying view criterias for female staff");
        vo.showFemaleCustomers();
        showResults(vo, "After applying view criterias for female customers");
        vo.showAll();
        showResults(vo, "After clearing all view criterias");
        Configuration.releaseRootApplicationModule(am, true);
    }
    
        private static void showResults(ViewObject vo, String comment) {
          System.out.println("---"+comment+" ---");
          while (vo.hasNext()) {
            Row curUser = vo.next();
            System.out.println(curUser.getAttribute("FirstName") + " " + 
                               curUser.getAttribute("LastName") + " [" +
                               curUser.getAttribute("PersonTypeCode") + ", " +
                               curUser.getAttribute("Gender") + "]");
          }
        }
    }
