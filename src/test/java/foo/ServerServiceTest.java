package foo;

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
public class ServerServiceTest {
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

}
