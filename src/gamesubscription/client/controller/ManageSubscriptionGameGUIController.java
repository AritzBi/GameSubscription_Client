package gamesubscription.client.controller;

import java.util.List;

import gamesubscription.client.pojo.ClientPOJO;
import gamesubscription.client.pojo.SubscriptionGamePOJO;
import gamesubscription.client.service.ClientService;
import gamesubscription.client.service.SubscriptionGameService;

public class ManageSubscriptionGameGUIController {

	private ClientService service;
	private SubscriptionGameService subscriptionGameService;
	
	public ManageSubscriptionGameGUIController ( ClientService service, SubscriptionGameService subscriptionGameService )
	{
		this.service = service;
		this.subscriptionGameService = subscriptionGameService;
	}
	
	public List<SubscriptionGamePOJO> findBySubscriptionId ( long subscription )
	{
		return subscriptionGameService.findBySubscriptionId(subscription);
	}
	
	public boolean deleteSubscription (  long subscription, long idCliente )
	{
		return subscriptionGameService.deleteSubscription(subscription, idCliente);
	}
	
	public boolean insertClient ( ClientPOJO clientPOJO )
	{
		return service.insertClient(clientPOJO);
	}
	
	public boolean updateClient ( ClientPOJO clientPOJO )
	{
		return service.modifyClient(clientPOJO);
	}
	
	public List<ClientPOJO> findAll ()
	{
		return service.findAll();
	}
	
	public boolean insertSubscription ( long idSubscription, long idClient )
	{
		return subscriptionGameService.insertSubscription(idSubscription, idClient);
	}

}
