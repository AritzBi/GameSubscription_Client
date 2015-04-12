package gamesubscription.client.service;

import gamesubscription.client.pojo.ClientJersey;
import gamesubscription.client.pojo.SubscriptionGamePOJO;
import gamesubscription.client.pojo.SubscriptionsGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

public class SubscriptionGameService {

	public boolean deleteSubscription ( long idSubscription, long idClient )
	{
		boolean success = false;
		try{
			ClientJersey.getInstance().getService().path("subscriptions").path(String.valueOf(idSubscription)).path("clients").path(String.valueOf(idClient)).delete();
			success = true;
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("subscriptionsgames.{" + idSubscription + " client " + idClient + "}.DEL.status: " + r.getStatus());
			System.out.println("subscriptions.{" + idSubscription  + " client " + idClient + "}.DEL.entity: " + r.getEntity(String.class));
		}	
		return success;
	}
	
	public boolean insertSubscription ( long idSubscription, long idClient )
	{
		boolean success = false;
		try{
			ClientJersey.getInstance().getService().path("subscriptions").path(String.valueOf(idSubscription)).path("clients").path(String.valueOf(idClient)).post();
			success = true;
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("subscriptionsgames.{" + idSubscription + " client " + idClient + "}.INSERT.status: " + r.getStatus());
			System.out.println("subscriptions.{" + idSubscription  + " client " + idClient + "}.INSERT.entity: " + r.getEntity(String.class));
		}	
		return success;
	}
	
	public List<SubscriptionGamePOJO> findBySubscriptionId ( long subscription )
	{
		List<SubscriptionGamePOJO> subscriptionsGame = new ArrayList<SubscriptionGamePOJO>();
		
		ClientJersey clientJersey = ClientJersey.getInstance();
		
		String idsubscription = String.valueOf(subscription);
		
		SubscriptionsGame susGame = null;
	
		try {
			susGame = clientJersey.getService().path("subscriptions").path(idsubscription).path("clients").accept(MediaType.APPLICATION_XML).get(SubscriptionsGame.class);
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("clients.GET('application/xml').status: " + r.getStatus());
			System.out.println("clients.GET('application/xml').entity: " + r.getEntity(String.class));
		}
		
		if ( susGame != null && susGame.getSubscriptions().size() > 0 )
		{
			subscriptionsGame = susGame.getSubscriptions();
		}
		
		return subscriptionsGame;
	}
	
	public static List<SubscriptionGamePOJO> processXMLFile(String path) {
		List<SubscriptionGamePOJO> listaSubscriptionGamePOJOs = new ArrayList<SubscriptionGamePOJO>();
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SubscriptionsGame.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			SubscriptionsGame suscriptions = (SubscriptionsGame) unmarshaller.unmarshal(new FileInputStream(
					path));
			if (suscriptions != null) {
				listaSubscriptionGamePOJOs = suscriptions.getSubscriptions();
			}
		} catch (FileNotFoundException e) {
			System.err.println("#FileNotFoundException " + e.getMessage());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return listaSubscriptionGamePOJOs;
	}
	
}
