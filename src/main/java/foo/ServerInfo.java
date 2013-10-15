package foo;

import org.apache.catalina.connector.Connector;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.tomee.loader.TomcatHelper;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.management.ManagementFactory;

@XmlRootElement
public class ServerInfo {
    private String name;
    private String status;
    private String tomeeHome;
    private String tomeeBase;
    private String version;
    private String ports = "";
    private long uptime;

    public ServerInfo() {
    }

    public ServerInfo(final String name, final String status, final String tomeeHome, final String tomeeBase,
                      final String version, final long uptime, final String ports) {
        this.name = name;
        this.status = status;
        this.tomeeHome = tomeeHome;
        this.tomeeBase = tomeeBase;
        this.version = version;
        this.uptime = uptime;
        this.ports = ports;
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
        return DurationFormatUtils.formatDurationHMS(uptime);
    }

    public String getPorts() {
        return ports;
    }
}
