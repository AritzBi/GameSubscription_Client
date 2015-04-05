package gamesubscription.client.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.ws.axis2.xsd.Game;

@XmlRootElement(name = "game")
@XmlAccessorType (XmlAccessType.FIELD)
public class GamePOJO {

	private long id;
	private String name;
	private int age;
	private String type;
	private String description;
	
	public static int POSITION_ID = 0;
	public static int POSITION_NAME = 1;
	public static int POSITION_AGE = 2;
	public static int POSITION_TYPE = 3;
	public static int POSITION_DESCRIPTION = 4;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString ()
	{
		return "Name: " + name + " Age: " + age + " Type: " + type + " Description: " + description;
	}
	public Object[] getObjectArray ()
	{
		Object [] objeto = new Object[5];
		objeto[POSITION_ID] = id;
		objeto[POSITION_NAME] = name;
		objeto[POSITION_AGE] = age;
		objeto[POSITION_DESCRIPTION] = description;
		objeto[POSITION_TYPE] = type;
		
		return objeto;
	}
	
	public Game getGame ()
	{
		Game game = new Game();
		game.setId((int)id);
		game.setAge(age);
		game.setDescription(description);
		game.setName(name);
		game.setType(type);
		
		return game;
	}
	
}
