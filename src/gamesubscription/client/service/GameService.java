package gamesubscription.client.service;

import gamesubscription.client.pojo.ClientJersey;
import gamesubscription.client.pojo.ClientPOJO;
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

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

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
		Games games = null;
		
		try {
			games = clientJersey.getService().path("games").accept(MediaType.APPLICATION_XML).get(Games.class);
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("games.GET('application/xml').status: " + r.getStatus());
			System.out.println("games.GET('application/xml').entity: " + r.getEntity(String.class));
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
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
		
		if ( id != null ) {
			String idstring = String.valueOf(id);
			try {
			gamePOJO = clientJersey.getService().path("games").path(idstring).accept(MediaType.APPLICATION_XML).get(GamePOJO.class);
			}catch(UniformInterfaceException e){
				ClientResponse r = e.getResponse();
				System.out.println("game " + id + ".GET('application/xml').status: " + r.getStatus());
			}
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
	
	public boolean updateGame ( GamePOJO gamePOJO )
	{
		boolean success = false;
		if ( gamePOJO != null )
		{
			try{
				ClientJersey.getInstance().getService().path("games").path(String.valueOf(gamePOJO.getId())).type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).put(gamePOJO);
				success = true;
			}catch(UniformInterfaceException e){
				ClientResponse r = e.getResponse();
				System.out.println("game " + gamePOJO.getId() + ".POST('application/xml').status: " + r.getStatus());
				System.out.println("game " + gamePOJO.getId() + ".POST('application/xml').entity: " + r.getEntity(String.class));
			}
		}
		return success;
	}
	
	public static void main ( String [] args )
	{
		ClientPOJO clientPOJO = new ClientPOJO();
		clientPOJO.setDni("45893970T");
		clientPOJO.setAddress("Mariano Ciriquiain");
		clientPOJO.setName("Aitor");
		clientPOJO.setSurname("Simon");
		clientPOJO.setPhone("944834560");
		
		ClientJersey.getInstance().getService().path("clients").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, clientPOJO);
	}

}
