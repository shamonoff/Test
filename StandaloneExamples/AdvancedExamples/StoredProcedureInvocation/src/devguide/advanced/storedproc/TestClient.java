package devguide.advanced.storedproc;

import devguide.advanced.storedproc.common.StoredProcTestModule;
import oracle.jbo.domain.Number;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.*;


public class TestClient {
    public static void main(String[] args) {
      String        amDef = "devguide.advanced.storedproc.StoredProcTestModule";
      String        config = "StoredProcTestModuleLocal";
      StoredProcTestModule svc = 
      (StoredProcTestModule)Configuration.createRootApplicationModule(amDef,config);
      svc.callProcWithNoArgs();
      Number n = new Number(101);
      Date   d = new Date(Date.getCurrentDate());
      String s = "Testing";
      svc.callProcWithThreeArgs(n,d,s);
      String result = svc.callFuncWithThreeArgs(n,d,s);
      System.out.println(result);
      DateAndStringBean b = svc.callProcWithOutArgs(n,s);
      System.out.println("Date returned is: "+b.getDateVal());
      System.out.println("String returned is: "+b.getStringVal());
      Configuration.releaseRootApplicationModule(svc,true);    
    }
    }
