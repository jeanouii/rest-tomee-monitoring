package com.tomitribe.tomee.monitoring.server;

import org.apache.catalina.connector.Connector;
import org.apache.tomee.loader.TomcatHelper;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.lang.management.ManagementFactory;

@Singleton
@Lock(LockType.READ)
@Path("/server")
public class ServerResource {

    @GET
    @Path("/info")
    public Server getInfo() {
        String name = TomcatHelper.getServer().findServices()[0].getName();
        String status = TomcatHelper.getServer().getState().name();
        String tomeeHome = System.getProperty("openejb.home");
        String tomeeBase = System.getProperty("openejb.base");
        String version = org.apache.catalina.util.ServerInfo.getServerInfo();
        String ports = "";
        long uptime = System.currentTimeMillis() - ManagementFactory.getRuntimeMXBean().getStartTime();


        Connector[] connectors = TomcatHelper.getServer().findServices()[0].findConnectors();
        for (int i = 0; i < connectors.length; i++) {
            ports += connectors[i].getProtocol() + " -> " + connectors[i].getPort();
            if (i < connectors.length - 1) ports += ", ";
        }
        return new Server(name, status, tomeeHome, tomeeBase, version, uptime, ports);
    }


    @GET
    @Path("/restart")
    public String restart() {
        return "Not yet implemented";
    }

    @GET
    @Path("/start")
    public String start() {
        return "Not yet implemented";
    }

    @GET
    @Path("/stop")
    public String stop() {
        return "Not yet implemented";
    }

}
