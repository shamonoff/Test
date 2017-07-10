package devguide.advanced.inheritance.client;

import devguide.advanced.inheritance.queries.common.PersonList;
import devguide.advanced.inheritance.queries.common.PersonListRow;

import oracle.jbo.client.Configuration;
import oracle.jbo.*;

  public class TestEntityPolymorphism {
  public static void main(String[] args) {
    String        amDef = "devguide.advanced.inheritance.PersonModule";
    String        config = "PersonModuleLocal";
    ApplicationModule am =
    Configuration.createRootApplicationModule(amDef,config);
    // Show entity polymorphism by invoking the same method on each type of person
    
    PersonList personlist = (PersonList)am.findViewObject("PersonList");
        personlist.executeQuery();
        while (personlist.hasNext()) {
          PersonListRow person = (PersonListRow)personlist.next();
          System.out.print(person.getEmail()+"->");
          person.performPersonFunction();
        }
    // Show creating new rows with appropriate entity subtypes
    PersonListRow newPerson = (PersonListRow)personlist.createRow();
    PersonListRow newStaff  = personlist.createStaffRow();
    PersonListRow newSupplier = personlist.createSupplierRow();
    newPerson.performPersonFunction();
    newStaff.performPersonFunction();
    newSupplier.performPersonFunction();
    
    Configuration.releaseRootApplicationModule(am,true);
  }
}
