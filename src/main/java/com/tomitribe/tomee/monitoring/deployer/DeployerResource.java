package com.tomitribe.tomee.monitoring.deployer;

import org.apache.openejb.assembler.Deployer;
import org.apache.openejb.assembler.DeployerEjb;
import org.apache.openejb.core.LocalInitialContextFactory;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.management.MBeanServerConnection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Path;
import java.util.Collection;
import java.util.Properties;

@Singleton
@Lock(LockType.READ)
@Path("/deployer")
public class DeployerResource {

    // The JMXDeployer facade does not provide all features. Lets use the internal API instead for the moment
    private static final String TRANSACTION_NAME = "openejb.user.mbeans:application=openejb,group=org.apache.openejb.assembler.monitoring,name=JMXDeployer";


    public Collection<Application> getDeployedApps() {
        return null;
    }

    public Application deploy(final String location) {
        return null;

    }

    public Application deploy(final Properties properties) {
        return null;

    }

    public Application deploy(final String location, final Properties properties) {
        return null;

    }

    public void undeploy(final String moduleId) {

    }

    public void reload(final String moduleId) {

    }

    // Using internal Deployer instance instead of the JMXDeployer facade.
    private static Deployer deployer() throws NamingException {
        final Properties p = new Properties();
        p.setProperty(Context.INITIAL_CONTEXT_FACTORY, LocalInitialContextFactory.class.getName());

        final ClassLoader oldCl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(DeployerEjb.class.getClassLoader());
        try {
            return (Deployer) new InitialContext(p).lookup("openejb/DeployerBusinessRemote");
        } finally {
            Thread.currentThread().setContextClassLoader(oldCl);
        }
    }

}
