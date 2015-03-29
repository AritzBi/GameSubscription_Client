package gamesubscription.client.controller;

import java.util.List;

import gamesubscription.client.pojo.ClientPOJO;
import gamesubscription.client.service.ClientService;

public class ManageClientGUIController {

	private ClientService service;
	
	public ManageClientGUIController ( ClientService service )
	{
		this.service = service;
	}
	
	public List<ClientPOJO> findByGameAndSubscription ( long game, long subscription )
	{
		return service.findByGameAndSubscription(game, subscription);
	}
}
