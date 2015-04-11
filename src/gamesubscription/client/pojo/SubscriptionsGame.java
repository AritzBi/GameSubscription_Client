package gamesubscription.client.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subscriptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscriptionsGame {

	@XmlElement(name = "subscription")
	private List<SubscriptionGamePOJO> subscriptions = null;

	public List<SubscriptionGamePOJO> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<SubscriptionGamePOJO> subscriptions) {
		this.subscriptions = subscriptions;
	}
}
