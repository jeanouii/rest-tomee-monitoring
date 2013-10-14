package foo;

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
public class ServerServiceSimpleTest {
    private static final String BASE_URL = "http://localhost:4204/foo";


    @Module
    @Classes(ServerService.class)
    public WebApp archive() {
        return new WebApp()
                .contextRoot("foo");
    }

    @Test
    public void restart() {
        String responseCode = WebClient.create(BASE_URL).path("/server/restart").get(String.class);
    }

}
