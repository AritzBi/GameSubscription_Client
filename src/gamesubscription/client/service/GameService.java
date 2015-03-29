package gamesubscription.client.service;

import gamesubscription.client.pojo.ClientJersey;
import gamesubscription.client.pojo.GamePOJO;
import gamesubscription.client.pojo.Games;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
	
	public List<GamePOJO> findAll() {
		List<GamePOJO> ltaGames = new ArrayList<GamePOJO>();
		
		ClientJersey clientJersey = ClientJersey.getInstance();
		Games games = clientJersey.getService().path("games").accept(MediaType.APPLICATION_XML).get(Games.class);
		
		if ( games != null )
		{
			ltaGames = games.getGames();
		}
		return ltaGames;
	}
	
	public GamePOJO findById ( Long id )
	{
		GamePOJO gamePOJO = null;
		
		ClientJersey clientJersey = ClientJersey.getInstance();
		
		if ( id != null )
		{
			String idstring = String.valueOf(id);
			gamePOJO = clientJersey.getService().path("games").path(idstring).accept(MediaType.APPLICATION_XML).get(GamePOJO.class);
		}
		
		return gamePOJO;
		
	}

	public List<GamePOJO> processXMLFile(String path) {
		List<GamePOJO> listaGames = new ArrayList<GamePOJO>();
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Games.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			Games games = (Games) unmarshaller.unmarshal(new FileInputStream(
					path));
			if (games != null) {
				listaGames = games.getGames();
			}
		} catch (FileNotFoundException e) {
			System.err.println("#FileNotFoundException " + e.getMessage());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return listaGames;
	}

}
