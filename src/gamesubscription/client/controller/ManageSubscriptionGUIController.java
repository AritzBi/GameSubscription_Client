package gamesubscription.client.controller;

import java.util.List;

import gamesubscription.client.pojo.SubscriptionPOJO;
import gamesubscription.client.service.SubscriptionService;

public class ManageSubscriptionGUIController {

	private SubscriptionService service;
	
	public ManageSubscriptionGUIController ( SubscriptionService service )
	{
		this.service = service;
	}
	
	public List<SubscriptionPOJO> findByGameId ( Long id )
	{
		return service.findByGameId(id);
	}
	
	public boolean deleteSubscription ( long id )
	{
		return service.deleteSubscription(id);
	}
	
	//TODO: utilizamos put?
	public boolean insertSubscription ( SubscriptionPOJO subscription )
	{
		return true;
	}
	
	//TODO: utilizamos post?
	public boolean updateSubscription ( SubscriptionPOJO subscription )
	{
		return true;
	}
}
