package oracle.fodemo.common;

import javax.annotation.Resource;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ServiceInterceptor {
    public ServiceInterceptor() {
        super();
    }
    @Resource
    private javax.ejb.SessionContext ctx;

    @AroundInvoke
    public Object preInoke(InvocationContext ic) throws Exception {

        return ic.proceed();
    }

}
