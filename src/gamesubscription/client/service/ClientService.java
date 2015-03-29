package gamesubscription.client.service;

import gamesubscription.client.pojo.ClientJersey;
import gamesubscription.client.pojo.ClientPOJO;
import gamesubscription.client.pojo.Clients;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

public class ClientService {

	
	public List<ClientPOJO> findByGameAndSubscription ( long game, long subscription )
	{
		List<ClientPOJO> clients = new ArrayList<ClientPOJO>();
		
		ClientJersey clientJersey = ClientJersey.getInstance();
		
		String idgame = String.valueOf(game);
		String idsubscription = String.valueOf(subscription);
		
		Clients clie = clientJersey.getService().path("games").path(idgame).path("subscriptions").path(idsubscription).path("clients").accept(MediaType.APPLICATION_XML).get(Clients.class);
	
		if ( clie != null )
		{
			clients = clie.getClients();
		}
		
		return clients;
	}
}
