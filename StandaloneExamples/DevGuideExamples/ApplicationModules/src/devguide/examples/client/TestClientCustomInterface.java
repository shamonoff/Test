package devguide.examples.client;

import devguide.examples.appmodules.common.StoreFrontService;

import oracle.jbo.client.Configuration;
import oracle.jbo.*;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.*;

public class TestClientCustomInterface {
    public static void main(String[] args) {
        String amDef = "devguide.examples.appmodules.StoreFrontService";
        String config = "StoreFrontServiceLocal";
       
        /*
         * This is the correct way to use application custom methods
         * from the client, by using the application module's automatically-
         * maintained custom service interface.
         */
        StoreFrontService service = (StoreFrontService)Configuration.createRootApplicationModule(amDef,config);
        String total = service.findOrderTotal(1011);
        System.out.println("Total for Order # 1011 = " + total);
        String custName = service.findOrderCustomer(1011);
        System.out.println("Customer for Order # 1011 = " + custName);
         try {
           service.updateOrderStatus(1011,"CANCEL");
         }
         catch (JboException ex) {
           System.out.println("ERROR: "+ex.getMessage());
         }
         long id = 0;
         try {
           id = service.createProduct(null, "NEW", "CLASS1");
         }
         catch (JboException ex) {
           System.out.println("ERROR: "+ex.getMessage());
         }
         id = service.createProduct("Canon PowerShot G9", "NEW", "CLASS1");
         System.out.println("New product created successfully with id = "+id);
        Configuration.releaseRootApplicationModule(service,true);
        }
}
