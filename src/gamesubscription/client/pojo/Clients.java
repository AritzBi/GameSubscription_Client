package gamesubscription.client.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clients {

	@XmlElement(name = "client")
	private List<ClientPOJO> clients = null;
	
	public Clients ()
	{
		clients = new ArrayList<ClientPOJO>();
	}

	public List<ClientPOJO> getClients() {
		return clients;
	}

	public void setClients(List<ClientPOJO> clients) {
		this.clients = clients;
	}
}
