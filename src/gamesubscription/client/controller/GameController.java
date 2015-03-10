package gamesubscription.client.controller;

import gamesubscription.client.pojo.GamePOJO;
import gamesubscription.client.service.GameService;

import java.util.List;
import java.util.Observer;

import javax.xml.bind.JAXBException;

import org.apache.ws.axis2.xsd.Game;

public class GameController {

	private GameService service;

	public GameController(GameService gameService) {
		service = gameService;
	}

	public void addObserver(Observer o) {
		service.addObserver(o);
	}

	public void deleteObserver(Observer o) {
		service.deleteObserver(o);
	}
	
	public long insertGame(Game game) {
		return service.insertGame(game);
	}
	
	public List<GamePOJO> processXMLFile ( String path )
	{
		return service.processXMLFile(path);
	}
}
