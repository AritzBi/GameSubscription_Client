package gamesubscription.client.main;
import gamesubscription.client.controller.ManageClientGUIController;
import gamesubscription.client.controller.ManageGameGUIController;
import gamesubscription.client.controller.ManageSubscriptionGUIController;
import gamesubscription.client.gui.ManageGameGUI;
import gamesubscription.client.service.ClientService;
import gamesubscription.client.service.GameService;
import gamesubscription.client.service.SubscriptionService;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameService gameService = new GameService();
				SubscriptionService subscriptionService = new SubscriptionService();
				ClientService clientService = new ClientService();
				
				ManageGameGUIController manageGameGUIController = new ManageGameGUIController(gameService);
				ManageSubscriptionGUIController manageSubscriptionGUIController = new ManageSubscriptionGUIController(subscriptionService);
				ManageClientGUIController manageClientGUIController = new ManageClientGUIController(clientService);
				
				ManageGameGUI manageGameGUI = new ManageGameGUI(manageGameGUIController);
				manageGameGUI.setSubscriptionController(manageSubscriptionGUIController);
				manageGameGUI.setClientController(manageClientGUIController);
				manageGameGUI.setLocationRelativeTo(null);
				manageGameGUI.setVisible(true);
				
			}
		});
	}
}
