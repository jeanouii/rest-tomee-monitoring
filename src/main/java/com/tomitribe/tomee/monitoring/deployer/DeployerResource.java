package com.tomitribe.tomee.monitoring.deployer;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.management.MBeanServerConnection;
import javax.ws.rs.Path;
import java.util.Collection;
import java.util.Properties;

@Singleton
@Lock(LockType.READ)
@Path("/application")
public class DeployerResource {

    private static final String TRANSACTION_NAME = "openejb.management:j2eeType=TransactionManager";

    @Inject
    private MBeanServerConnection mBeanServerConnection;


    public Collection<Application> getDeployedApps() {

    }

    public Application deploy(final String location) {

    }

    public Application deploy(final Properties properties) {

    }

    public Application deploy(final String location, final Properties properties) {

    }

    public void undeploy(final String moduleId) {

    }

    public void reload(final String moduleId) {

    }

}
