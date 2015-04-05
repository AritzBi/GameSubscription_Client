package gamesubscription.client.service;

import gamesubscription.client.pojo.ClientJersey;
import gamesubscription.client.pojo.SubscriptionPOJO;
import gamesubscription.client.pojo.Subscriptions;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

public class SubscriptionService {

	
	public List<SubscriptionPOJO> findByGameId ( Long id )
	{
		List<SubscriptionPOJO> subscriptions = new ArrayList<SubscriptionPOJO>();
		
		ClientJersey clientJersey = ClientJersey.getInstance();
		
		if ( id != null )
		{
			String idstring = String.valueOf(id);
			Subscriptions subs = null;
			try {
				subs = clientJersey.getService().path("games").path(idstring).path("subscriptions").accept(MediaType.APPLICATION_XML).get(Subscriptions.class);
		
			}catch(UniformInterfaceException e){
				ClientResponse r = e.getResponse();
				System.out.println("subscriptions.GET('application/xml').status: " + r.getStatus());
				System.out.println("subscriptions.GET('application/xml').entity: " + r.getEntity(String.class));
			}
			if ( subs != null )
			{
				subscriptions = subs.getSubscriptions();
			}
		}
		
		return subscriptions;
	}
	
	public boolean deleteSubscription ( long id )
	{
		boolean success = false;
		try{
			ClientJersey.getInstance().getService().path("subscriptions").path(String.valueOf(id)).delete();
			success = true;
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("subscriptions.{" + id + "}.DEL.status: " + r.getStatus());
			System.out.println("subscriptions.{" + id + "}.DEL.entity: " + r.getEntity(String.class));
		}	
		return success;
	}

}
