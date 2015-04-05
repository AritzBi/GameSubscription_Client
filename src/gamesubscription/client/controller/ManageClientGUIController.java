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
	
	public boolean deleteSubscription (  long game, long subscription, String dniCliente )
	{
		return service.deleteSubscription(game, subscription, dniCliente);
	}
	
	//TODO: lo hacemos con el metodo PUT?
	public boolean insertClient ( ClientPOJO clientPOJO )
	{
		return true;
	}
	
	//TODO: lo hacemos con el metodo POST?
	public boolean updateClient ( ClientPOJO clientPOJO )
	{
		return true;
	}

}
