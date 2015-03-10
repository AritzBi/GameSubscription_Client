package gamesubscription.client.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "games")
@XmlAccessorType(XmlAccessType.FIELD)
public class Games {

	@XmlElement(name = "game")
	private List<GamePOJO> games = null;

	public List<GamePOJO> getGames() {
		return games;
	}

	public void setGames(List<GamePOJO> games) {
		this.games = games;
	}

}
