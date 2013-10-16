package com.tomitribe.tomee.monitoring;

import org.apache.openejb.monitoring.LocalMBeanServer;

import javax.enterprise.inject.Produces;
import javax.management.MBeanServerConnection;

public class MBeanServerConnectionProvider {

    // Todo first shoot, to be refined if issues with the scoping
    // it's an interface so at least it is proxiable

    @Produces
    public MBeanServerConnection getMBeanServerConnection() {
        return LocalMBeanServer.get();
    }

}
