package gamesubscription.client.pojo;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClientJersey {

	private static ClientJersey clientJersey;
	private Client client;
	private WebResource service;

	private ClientJersey() {
		ClientConfig config = new DefaultClientConfig();
		this.client = Client.create(config);
		this.service = client.resource(getBaseURI());
	}

	public static ClientJersey getInstance() {
		if (clientJersey == null) {
			clientJersey = new ClientJersey();
		}

		return clientJersey;
	}

	public Client getClient() {
		return client;
	}

	public WebResource getService() {
		return service;
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/rest").build();
	}
}
