package com.tomitribe.tomee.monitoring.server;

import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Server {
    private String name;
    private String status;
    private String tomeeHome;
    private String tomeeBase;
    private String version;
    private String ports = "";
    private long uptime;

    public Server() {
    }

    public Server(final String name, final String status, final String tomeeHome, final String tomeeBase,
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTomeeHome(String tomeeHome) {
        this.tomeeHome = tomeeHome;
    }

    public void setTomeeBase(String tomeeBase) {
        this.tomeeBase = tomeeBase;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public void setUptime(long uptime) {
        this.uptime = uptime;
    }
}
