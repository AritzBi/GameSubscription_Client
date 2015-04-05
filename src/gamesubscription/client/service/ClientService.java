package gamesubscription.client.service;

import gamesubscription.client.pojo.ClientJersey;
import gamesubscription.client.pojo.ClientPOJO;
import gamesubscription.client.pojo.Clients;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

public class ClientService {

	
	public List<ClientPOJO> findByGameAndSubscription ( long game, long subscription )
	{
		List<ClientPOJO> clients = new ArrayList<ClientPOJO>();
		
		ClientJersey clientJersey = ClientJersey.getInstance();
		
		String idgame = String.valueOf(game);
		String idsubscription = String.valueOf(subscription);
		
		Clients clie = null;
	
		try {
			clie = clientJersey.getService().path("games").path(idgame).path("subscriptions").path(idsubscription).path("clients").accept(MediaType.APPLICATION_XML).get(Clients.class);
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("clients.GET('application/xml').status: " + r.getStatus());
			System.out.println("clients.GET('application/xml').entity: " + r.getEntity(String.class));
		}
		
		if ( clie != null )
		{
			clients = clie.getClients();
		}
		
		return clients;
	}
	
	public boolean deleteSubscription ( long game, long subscription, String dniCliente )
	{
		boolean success = true;
		
		String idGame = String.valueOf(game);
		String idSubscription = String.valueOf(subscription);
		
		if ( idGame != null && idGame.isEmpty() && idSubscription != null && !idSubscription.isEmpty() )
		{
			try{
			ClientJersey.getInstance().getService().path("games").path(idGame).path("subscriptions").path(idSubscription).path("clients").path(dniCliente).delete();
			}
			catch (UniformInterfaceException e)
			{
				success = false;
				ClientResponse r = e.getResponse();
				System.out.println("clients.DELETE('application/xml').status: " + r.getStatus());
				System.out.println("clients.DELETE('application/xml').entity: " + r.getEntity(String.class));
			}
		}
		return success;
	}
}
