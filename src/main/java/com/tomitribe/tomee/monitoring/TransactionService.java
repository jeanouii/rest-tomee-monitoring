package com.tomitribe.tomee.monitoring;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.management.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;

@Singleton
@Lock(LockType.READ)
@Path("/transaction")
public class TransactionService {

    private static final String TRANSACTION_NAME = "openejb.management:j2eeType=TransactionManager";

    @Inject
    private MBeanServerConnection mBeanServerConnection;

    @GET
    @Path("active")
    public long getActive() {
        try {
            return (Long) mBeanServerConnection.getAttribute(new ObjectName(TRANSACTION_NAME), "active");
            
        } catch (Exception e) {
            return 0;
        }
    }

    @GET
    @Path("committed")
    public long getCommitted() {
        try {
            return (Long) mBeanServerConnection.getAttribute(new ObjectName(TRANSACTION_NAME), "commits");

        } catch (Exception e) {
            return 0;
        }
    }

    @GET
    @Path("rollbacked")
    public long getRollbacked() {
        try {
            return (Long) mBeanServerConnection.getAttribute(new ObjectName(TRANSACTION_NAME), "rollbacks");

        } catch (Exception e) {
            return 0;
        }
    }


}
