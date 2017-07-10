package devguide.advanced.inheritance.client;

import devguide.advanced.inheritance.queries.common.PersonListRow;

import devguide.advanced.inheritance.queries.common.StaffListRow;

import devguide.advanced.inheritance.queries.common.SupplierListRow;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
public class TestViewRowPolymorphism {
  public static void main(String[] args) {
    String amDef = "devguide.advanced.inheritance.PersonModule";
    String config = "PersonModuleLocal";
    ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
    ViewObject vo = am.findViewObject("PersonList");
    vo.executeQuery();
    while (vo.hasNext()) {
      PersonListRow person = (PersonListRow)vo.next();
      System.out.print(person.getEmail()+"->");
      if (person instanceof StaffListRow) {
        StaffListRow staff = (StaffListRow)person;
        staff.performStaffFunction();  
        System.out.println("Discount Status:"+staff.getDiscountEligible());
      }
      else if (person instanceof SupplierListRow) {
        SupplierListRow supplier = (SupplierListRow)person;
        supplier.performSupplierFunction();       
        System.out.println("Contract expires:"+supplier.getContractExpires());        
      }
      else {
        person.performPersonFunction();
      }
    }
    Configuration.releaseRootApplicationModule(am, true);
  }
}

