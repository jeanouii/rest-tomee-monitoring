package foo;

import org.apache.catalina.connector.Connector;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.tomee.loader.TomcatHelper;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.management.ManagementFactory;

/**
* Created with IntelliJ IDEA.
* User: jlmonteiro
* Date: 14/10/13
* Time: 23:20
* To change this template use File | Settings | File Templates.
*/
@XmlRootElement
public class ServerInfo {
    public String name = TomcatHelper.getServer().findServices()[0].getName();
    public String status = TomcatHelper.getServer().getState().name();
    public String tomeeHome = System.getProperty("openejb.home");
    public String tomeeBase = System.getProperty("openejb.base");
    public String version = org.apache.catalina.util.ServerInfo.getServerInfo();
    public String ports = "";

    public ServerInfo() {
        Connector[] connectors = TomcatHelper.getServer().findServices()[0].findConnectors();
        for (int i = 0; i < connectors.length; i++) {
            ports += connectors[i].getProtocol() + " -> " + connectors[i].getPort();
            if (i < connectors.length - 1) ports += ", ";
        }
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getTomeeHome() {
        return tomeeHome;
    }

    public String getTomeeBase() {
        return tomeeBase;
    }

    public String getVersion() {
        return version;
    }

    public String getUpTime() {
        long uptime = System.currentTimeMillis() - ManagementFactory.getRuntimeMXBean().getStartTime();
        return DurationFormatUtils.formatDurationHMS(uptime);
    }

    public String getPorts() {
        return ports;
    }
}
