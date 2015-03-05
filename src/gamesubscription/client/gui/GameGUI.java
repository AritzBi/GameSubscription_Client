package gamesubscription.client.gui;

import gamesubscription.client.controller.GameController;
import gamesubscription.client.service.GameService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.ws.axis2.xsd.Game;

public class GameGUI extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	private JButton botonCargar;
	private JButton botonCerrar;
	private JButton botonEditar;
	private JTable tablaTerminales;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
	private GameController controller;
	private Object[][] modeloDeDatos;

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

	public GameGUI(GameController gameController) {
		super();
		modeloDeDatos = new Object[10][5];
		rellenarModeloDeDatosDePrueba();
		controller = gameController;
		controller.addObserver(this);
		initGUI();
	}

	private void rellenarModeloDeDatosDePrueba() {
		for (int i = 0; i < 3; i++) {
			modeloDeDatos[i][0] = "1234";
			modeloDeDatos[i][1] = "Call of Duty";
			modeloDeDatos[i][2] = "16";
			modeloDeDatos[i][3] = "Accion";
			modeloDeDatos[i][4] = "Esto es una prueba de descripción del juego";
		}

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			this.setTitle("Register Games");
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setFont(new java.awt.Font("Dialog", 0, 8));
				jPanel2.setBounds(13, 12, 620, 214);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory
						.createTitledBorder(null, "Received Games",
								TitledBorder.LEADING,
								TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 10),
								new java.awt.Color(0, 0, 0)));
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 600, 152);
					{
						TableModel jTable1Model = new DefaultTableModel(
								modeloDeDatos, new String[] { "Id", "Name",
										"Age", "Type", "Description" });
						tablaTerminales = new JTable();
						jScrollPane1.setViewportView(tablaTerminales);
						tablaTerminales.setModel(jTable1Model);
						tablaTerminales.getColumnModel().getColumn(4)
								.setPreferredWidth(400);
					}
				}
				{
					botonEditar = new JButton();
					jPanel2.add(botonEditar);
					botonEditar.setText("Enviar");
					botonEditar.setBounds(320, 182, 76, 23);
					botonEditar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonEnviar();
						}
					});
				}
				{
					botonCargar = new JButton();
					jPanel2.add(botonCargar);
					botonCargar.setText("Load games...");
					botonCargar.setBounds(150, 182, 165, 23);
					botonCargar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out
									.println("botonCargar.actionPerformed, event="
											+ evt);
							botonCargar();
						}
					});
				}
			}
			{
				botonCerrar = new JButton();
				getContentPane().add(botonCerrar);
				botonCerrar.setText("Cerrar");
				botonCerrar.setBounds(250, 250, 79, 23);
				botonCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out
								.println("botonCerrar.actionPerformed, event="
										+ evt);
						// TODO add your code for botonCerrar.actionPerformed
						botonCerrar();
					}
				});
			}
			pack();
			this.setSize(660, 320);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void botonEditar() {

	}

	private void botonCargar() {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File fichero = jfc.getSelectedFile();
			System.out.println(fichero.getAbsolutePath());
		}
	}

	private void botonEnviar() {

		Game game;
		for (int i = 0; i < modeloDeDatos.length; i++) {
			game = new Game();
			game.setName((String) modeloDeDatos[i][1]);
			game.setAge( new Integer( (String) modeloDeDatos[i][2] ) );
			game.setType((String) modeloDeDatos[i][3]);
			game.setDescription((String) modeloDeDatos[i][4]);
			Long idGame = controller.insertGame(game);
			if (idGame != null) {
				modeloDeDatos[i][0] = idGame;
				System.out.println("Resultado" + idGame);
			}
		}
	}

	private void botonCerrar() {
		System.exit(0);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
