package gamesubscription.client.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subscription")
@XmlAccessorType (XmlAccessType.FIELD)
public class SubscriptionGamePOJO {

	private Date fechaSuscripcion;
	
	private ClientPOJO cliente;
	
	private static int POSITION_FECHA_SUS = 5;

	public Date getFechaSuscripcion() {
		return fechaSuscripcion;
	}

	public void setFechaSuscripcion(Date fechaSuscripcion) {
		this.fechaSuscripcion = fechaSuscripcion;
	}

	public ClientPOJO getCliente() {
		return cliente;
	}

	public void setCliente(ClientPOJO cliente) {
		this.cliente = cliente;
	}
	
	public Object[] getObjectArray()
	{
		Object[] clientArray = cliente.getObjectArray();
		clientArray[POSITION_FECHA_SUS] = fechaSuscripcion;
		return clientArray;
	}
	
}
