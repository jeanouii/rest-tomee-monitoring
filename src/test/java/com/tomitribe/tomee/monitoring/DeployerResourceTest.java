package com.tomitribe.tomee.monitoring;

import com.tomitribe.tomee.monitoring.server.ServerResource;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ApplicationComposer.class)
@EnableServices("jax-rs")
public class DeployerResourceTest {
    private static final String BASE_URL = "http://localhost:4204/foo";


    @Module
    @Classes(ServerResource.class)
    public WebApp archive() {
        return new WebApp()
                .contextRoot("foo");
    }

    @Test
    public void restart() {
        String responseCode = WebClient.create(BASE_URL).path("/server/restart").get(String.class);
    }

}
