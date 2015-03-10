package gamesubscription.client.controller;

import gamesubscription.client.service.GameService;

import java.util.Observer;

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
}
