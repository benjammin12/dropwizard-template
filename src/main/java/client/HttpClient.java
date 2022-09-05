package client;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;

public class HttpClient {
    private final String url;
    private final WebTarget webTarget;
   
    public HttpClient(String url) {
        this.url = url;
        Client client = ClientBuilder.newBuilder().connectTimeout(5, TimeUnit.SECONDS).withConfig(new ClientConfig()).build();
        this.webTarget = client.target(url);
    }

    public String getUrl() {
        return url;
    }

    public String getAllSteamGames() {
        Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
        return response.readEntity(String.class);
    }
}
