package gamesubscription.client.controller;

import gamesubscription.client.pojo.GamePOJO;
import gamesubscription.client.service.GameService;

import java.util.List;

public class ManageGameGUIController {

	private GameService gameService;
	
	public ManageGameGUIController ( GameService gameService ) 
	{
		this.gameService = gameService;
	}
	
	public List<GamePOJO> findAll ()
	{
		return gameService.findAll();
	}
	
	public GamePOJO findById ( Long id )
	{
		return gameService.findById(id);
	}
}
