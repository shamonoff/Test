package devguide.examples.readonlyvo.client;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClientViewCriteria {
    public static void main(String[] args) {
        String amDef = "devguide.examples.readonlyvo.PersonService";
        String config = "PersonServiceLocal";
        ApplicationModule am = 
            Configuration.createRootApplicationModule(amDef, config);
        ViewObject vo = am.findViewObject("PersonList");
        // 1. Create a view criteria rowset for this view object
        ViewCriteria vc = vo.createViewCriteria();
        // 2. Use the view criteria to create one or more view criteria rows
        ViewCriteriaRow vcr1 = vc.createViewCriteriaRow();
        ViewCriteriaRow vcr2 = vc.createViewCriteriaRow();
        // 3. Set attribute values to filter on in appropriate view criteria rows
        vcr1.setAttribute("PersonId","> 200");
        vcr1.setAttribute("Email","d%");
        vcr1.setAttribute("PersonTypeCode","STAFF");
        vcr2.setAttribute("PersonId","IN (204,206)");
        vcr2.setAttribute("LastName","Hemant");
        // 4. Add the view criteria rows to the view critera rowset
        vc.add(vcr1);
        vc.add(vcr2);
        // 5. Apply the view criteria to the view object
        vo.applyViewCriteria(vc);
        // 6. Execute the query
        vo.executeQuery();
        while (vo.hasNext()) {
        Row curPerson = vo.next();
        System.out.println(curPerson.getAttribute("PersonId") + " " +
        curPerson.getAttribute("Email"));
        }
        Configuration.releaseRootApplicationModule(am, true);
    }
}
