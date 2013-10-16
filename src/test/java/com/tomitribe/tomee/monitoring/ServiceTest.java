package com.tomitribe.tomee.monitoring;

import com.tomitribe.tomee.monitoring.ServerInfo;
import org.apache.cxf.jaxrs.client.WebClient;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.archive.importer.MavenImporter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

@RunWith(Arquillian.class)
public class ServiceTest {
    @ArquillianResource
    private URL BASE_URL;

    @Deployment(testable = false)
    public static WebArchive war() {
        return ShrinkWrap.create(MavenImporter.class)
                .loadPomFromFile("pom.xml").importBuildOutput().as(WebArchive.class);
    }


    @Test
    @RunAsClient
    public void restart() {
        String responseCode = WebClient.create(BASE_URL.toExternalForm()).path("/server/restart").get(String.class);
        Assert.assertEquals("Not yet implemented", responseCode);
    }

    @Test
    @RunAsClient
    public void info() {
        ServerInfo info = WebClient.create(BASE_URL.toExternalForm()).path("/server/info")
                .get(ServerInfo.class);
        Assert.assertNotNull(info);
    }

    @Test
    @RunAsClient
    public void activeTransactions () {
        Long nb = WebClient.create(BASE_URL.toExternalForm()).path("/transaction/active").get(Long.class);
        Assert.assertEquals(new Long(1), nb); // the one started for the rest method invocation
    }

    @Test
    @RunAsClient
    public void committedTransactions () {
        // 5 because of the sample rest declared in the POM (quick and dirty)
        // must be fixed
        Long nb = WebClient.create(BASE_URL.toExternalForm()).path("/transaction/committed").get(Long.class);
        Assert.assertEquals(new Long(5), nb);
    }

    @Test
    @RunAsClient
    public void rollbackedTransactions () {
        Long nb = WebClient.create(BASE_URL.toExternalForm()).path("/transaction/rollbacked").get(Long.class);
        Assert.assertEquals(new Long(0), nb);
    }
}
