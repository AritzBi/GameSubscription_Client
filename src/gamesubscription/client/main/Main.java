package gamesubscription.client.main;
import gamesubscription.client.controller.GameController;
import gamesubscription.client.gui.GameGUI;
import gamesubscription.client.service.GameService;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameService gameService = new GameService();
				GameController gameController = new GameController(gameService);
				GameGUI inst = new GameGUI(gameController);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
}
