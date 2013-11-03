package com.tomitribe.tomee.monitoring.deployer;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Application {
    private String name;
    private String uri;

    public Application(String name, String uri) {
        this.uri = uri;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return "Application{" + "name=" + name + ", uri=" + uri + '}';
    }
}
