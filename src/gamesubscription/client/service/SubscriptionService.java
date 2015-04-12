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
			if ( subs != null && subs.getSubscriptions().size() > 0 )
			{
				subscriptions = subs.getSubscriptions();
			}
		}
		
		return subscriptions;
	}
	
	public boolean insertSubscription ( long idGame, SubscriptionPOJO subscription )
	{
		boolean success = false;
		ClientResponse response = ClientJersey.getInstance().getService().path("games").path(String.valueOf(idGame)).path("subscriptions").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, subscription);
		if ( response != null && response.getStatus() == 201 ) //201 --> Created resource
		{
			success = true;
		}
		else //Si no es codigo 201...
		{
			if ( response != null )
			{
				System.out.println("subscriptions.{" + subscription.getDescription() + "}.INSERT.status: " + response.getStatus());
				System.out.println("subscriptions.{" + subscription.getDescription() + "}.INSERT.entity: " + response.getEntity(String.class));
			}
		}
		return success;
	}
	
	public boolean modifySubscription ( SubscriptionPOJO subscription )
	{
		boolean success = false;
	
		ClientResponse response = ClientJersey.getInstance().getService().path("subscriptions").path(String.valueOf(subscription.getId())).type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, subscription);
		if ( response.getStatus() == 204 )
		{
			success = true;
		}
		else
		{
			System.out.println("subscriptions.{" + subscription.getId() + "}.UPDATE.status: " + response.getStatus());
			System.out.println("subscriptions.{" + subscription.getId() + "}.UPDATE.entity: " + response.getEntity(String.class));
		}
		return success;
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
