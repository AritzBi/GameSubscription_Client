package gamesubscription.client.service;

import gamesubscription.client.pojo.ClientJersey;
import gamesubscription.client.pojo.SubscriptionPOJO;
import gamesubscription.client.pojo.Subscriptions;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

public class SubscriptionService {

	
	public List<SubscriptionPOJO> findByGameId ( Long id )
	{
		List<SubscriptionPOJO> subscriptions = new ArrayList<SubscriptionPOJO>();
		
		ClientJersey clientJersey = ClientJersey.getInstance();
		
		if ( id != null )
		{
			String idstring = String.valueOf(id);
			Subscriptions subs = clientJersey.getService().path("games").path(idstring).path("subscriptions").accept(MediaType.APPLICATION_XML).get(Subscriptions.class);
		
			if ( subs != null )
			{
				subscriptions = subs.getSubscriptions();
			}
		}
		
		return subscriptions;

	}
}
