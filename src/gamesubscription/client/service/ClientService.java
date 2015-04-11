package gamesubscription.client.service;

import gamesubscription.client.pojo.ClientJersey;
import gamesubscription.client.pojo.ClientPOJO;
import gamesubscription.client.pojo.Clients;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;


public class ClientService {
	
	public boolean insertClient ( ClientPOJO client )
	{
		boolean success = false;
		try{
			ClientJersey.getInstance().getService().path("clients").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(client);
			success = true;
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("clients.{" + client.getDni() + "}.INSERT.status: " + r.getStatus());
			System.out.println("clients.{" + client.getDni() + "}.INSERT.entity: " + r.getEntity(String.class));
		}	
		return success;
	}
	
	public boolean modifyClient ( ClientPOJO client )
	{
		boolean success = false;
		try{
			ClientJersey.getInstance().getService().path("clients").path(String.valueOf(client.getId())).type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).put(client);
			success = true;
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("clients.{" + client.getId() + "}.UPDATE.status: " + r.getStatus());
			System.out.println("clients.{" + client.getId() + "}.UPDATE.entity: " + r.getEntity(String.class));
		}	
		return success;
	}
	
	public List<ClientPOJO> findAll() {
		List<ClientPOJO> ltClients = new ArrayList<ClientPOJO>();
		
		ClientJersey clientJersey = ClientJersey.getInstance();
		Clients clients = null;
		
		try {
			clients = clientJersey.getService().path("clients").accept(MediaType.APPLICATION_XML).get(Clients.class);
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("clients.GET('application/xml').status: " + r.getStatus());
			System.out.println("clients.GET('application/xml').entity: " + r.getEntity(String.class));
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
		if ( clients != null )
		{
			ltClients = clients.getClients();
		}
		return ltClients;
	}
}
