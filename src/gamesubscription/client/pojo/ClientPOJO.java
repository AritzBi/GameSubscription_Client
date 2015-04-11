package gamesubscription.client.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
@XmlAccessorType (XmlAccessType.FIELD)
public class ClientPOJO {
	
	private long id;
	private String dni;
	private String name;
	private String surname;
	private String address;
	private String phone;
	
	private static int POSITION_DNI = 0;
	private static int POSITION_NAME = 1;
	private static int POSITION_SURNAME = 2;
	private static int POSITION_ADDRESS = 3;
	private static int POSITION_PHONE = 4;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Object[] getObjectArray ()
	{
		Object [] objeto = new Object[6];
		objeto[POSITION_DNI] = dni;
		objeto[POSITION_NAME] = name;
		objeto[POSITION_SURNAME] = surname;
		objeto[POSITION_ADDRESS] = address;
		objeto[POSITION_PHONE] = phone;
		
		return objeto;
	}
	
	public String toString()
	{
		return dni;
	}
}
