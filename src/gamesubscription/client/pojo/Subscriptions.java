package gamesubscription.client.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subscriptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subscriptions {

	@XmlElement(name = "subscription")
	private List<SubscriptionPOJO> subscriptions = null;
	
	public Subscriptions ( )
	{
		subscriptions = new ArrayList<SubscriptionPOJO>();
	}

	public List<SubscriptionPOJO> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<SubscriptionPOJO> subscriptions) {
		this.subscriptions = subscriptions;
	}
}
