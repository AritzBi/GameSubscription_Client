package gamesubscription.client.pojo;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "subscription")
@XmlAccessorType (XmlAccessType.FIELD)
public class SubscriptionGamePOJO {

	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date fechaSuscripcion;
	
	@XmlElement(name = "cliente")
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
		if ( fechaSuscripcion != null )
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaSuscripcion);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DATE);
			int year = cal.get(Calendar.YEAR);
			String fecha = day + "/" + month + "/" + year;
			clientArray[POSITION_FECHA_SUS] = fecha;
		}
		return clientArray;
	}
	
}
