package gamesubscription.client.gui;

import gamesubscription.client.controller.GameController;
import gamesubscription.client.pojo.GamePOJO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.ws.axis2.xsd.Game;

public class GameGUI extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	private JButton botonCargar;
	private JButton botonCerrar;
	private JButton botonEnviar;
	private JTable tablaTerminales;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
	private GameController controller;
	private Object[][] rows;
	private DefaultTableModel model;

	private static int POSITION_ID = 0;
	private static int POSITION_NAME = 1;
	private static int POSITION_AGE = 2;
	private static int POSITION_TYPE = 3;
	private static int POSITION_DESCRIPTION = 4;

	public GameGUI(GameController gameController) {
		super();
		rows = new Object[5][5];
		controller = gameController;
		controller.addObserver(this);
		initGUI();
	}

	private void rellenarTablaConGamesPOJO(List<GamePOJO> games) {
		int i = 0;
		rows = new Object[games.size()][5];
		for (GamePOJO gamePOJO : games) {
			rows[i][POSITION_NAME] = gamePOJO.getName();
			rows[i][POSITION_AGE] = gamePOJO.getAge();
			rows[i][POSITION_TYPE] = gamePOJO.getType();
			rows[i][POSITION_DESCRIPTION] = gamePOJO.getDescription();
			i++;
		}
	}

	private boolean volcadoDeTabla() {
		boolean resultado = true;

		Game game;
		for (int i = 0; i < rows.length; i++) {
			game = new Game();
			game.setName((String) rows[i][POSITION_NAME]);
			game.setAge((int) rows[i][POSITION_AGE]);
			game.setType((String) rows[i][POSITION_TYPE]);
			game.setDescription((String) rows[i][POSITION_DESCRIPTION]);
			long idGame = controller.insertGame(game);
			if (idGame != -1)
				rows[i][POSITION_ID] = idGame;
			else
				resultado = false;
		}
		return resultado;
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
						model = new DefaultTableModel(rows, new String[] {
								"Id", "Name", "Age", "Type", "Description" });

						tablaTerminales = new JTable();
						jScrollPane1.setViewportView(tablaTerminales);
						tablaTerminales.setModel(model);
						tablaTerminales.getColumnModel().getColumn(4)
								.setPreferredWidth(400);
					}
				}
				{
					botonEnviar = new JButton();
					jPanel2.add(botonEnviar);
					botonEnviar.setText("Send");
					botonEnviar.setBounds(320, 182, 76, 23);
					botonEnviar.addActionListener(new ActionListener() {
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
							botonCargar();
						}
					});
				}
			}
			{
				botonCerrar = new JButton();
				getContentPane().add(botonCerrar);
				botonCerrar.setText("Close");
				botonCerrar.setBounds(250, 250, 79, 23);
				botonCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						botonCerrar();
					}
				});
			}
			pack();
			this.setSize(660, 320);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void botonCargar() {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File fichero = jfc.getSelectedFile();
			List<GamePOJO> games = controller.processXMLFile(fichero
					.getAbsolutePath());
			if (games != null && games.size() > 0) {
				rellenarTablaConGamesPOJO(games);
				refrescarTabla();
			}
		}
	}

	private void botonEnviar() {

		if (volcadoDeTabla()) {
			JOptionPane.showMessageDialog(this, "Data loaded succesfully.");
		} else {
			JOptionPane.showMessageDialog(this, "Failed loading data...");
		}
		refrescarTabla();
	}

	private void refrescarTabla() {
		model.setRowCount(0);
		for (int i = 0; i < rows.length; i++) {
			model.addRow(rows[i]);
		}
		model.fireTableDataChanged();
	}

	private void botonCerrar() {
		System.exit(0);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	}
}
