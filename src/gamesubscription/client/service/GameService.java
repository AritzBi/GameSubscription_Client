package gamesubscription.client.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.GameServiceStub;
import org.apache.ws.axis2.InsertGame;
import org.apache.ws.axis2.InsertGameResponse;
import org.apache.ws.axis2.xsd.Game;

public class GameService {

	private List<Observer> observers;

	public GameService() {
		observers = new ArrayList<Observer>();
	}

	public void addObserver(Observer o) {
		if (o != null && !this.observers.contains(o)) {
			this.observers.add(o);
		}
	}

	public void deleteObserver(Observer o) {
		this.observers.remove(o);
	}

	public void notifyObservers(Object param) {
		for (Observer observer : this.observers) {
			if (observer != null) {
				observer.update(null, param);
			}
		}
	}

	public long insertGame(Game game) {
		long returnedValue = -1;
		try {
			GameServiceStub stub = new GameServiceStub(
					"http://52.16.130.245:8080/axis2/services/GameService");
			InsertGame insertGame = new InsertGame();
			insertGame.setGame(game);
			InsertGameResponse response = stub.insertGame(insertGame);
			returnedValue = response.get_return();
		} catch (AxisFault e) {
			System.out.println("#AxisFault (insertGame) " + e.getMessage());
		} catch (RemoteException e) {
			System.out.println("#RemoteException (insertGame) "
					+ e.getMessage());
		}
		return returnedValue;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setAge(10);
		game.setDescription("Pruebita");
		game.setId(1234);
		game.setName("Call of Duty");
		game.setType("Action");

		GameService gameService = new GameService();
		System.out.println(gameService.insertGame(game));
	}
}
