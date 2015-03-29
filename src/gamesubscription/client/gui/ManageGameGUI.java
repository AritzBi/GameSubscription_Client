package gamesubscription.client.gui;

import gamesubscription.client.controller.ManageClientGUIController;
import gamesubscription.client.controller.ManageGameGUIController;
import gamesubscription.client.controller.ManageSubscriptionGUIController;
import gamesubscription.client.pojo.GamePOJO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ManageGameGUI extends JFrame {

	private static final long serialVersionUID = -2483550212847466877L;

	private JPanel jPanel1;
	private JButton botonSearch;
	private JTextField cajaId;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton botonExit;
	private JButton botonSave;
	private JButton botonNew;
	private JButton botonEditar;
	private JButton botonLineas;
	private JTable tablaClientes;
	private JScrollPane jScrollPane1;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JTextField cajaDescription;
	private JTextField cajaType;
	private JTextField cajaAge;
	private JTextField cajaName;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JButton botonAll;
	private JTextField cajaIdBuscar;
	private JLabel jLabel1;

	private List<GamePOJO> games;
	private DefaultTableModel model;
	
	private ManageGameGUIController controller;
	private ManageSubscriptionGUIController subscriptionController;
	private ManageClientGUIController clientController;
	
	public ManageGameGUI(ManageGameGUIController controller) {
		super();
		this.controller = controller;
		initGUI();
		rellenarTablaDatosPrueba();
	}

	private void rellenarTablaDatosPrueba() {
		games = new ArrayList<GamePOJO>();
		GamePOJO gamePOJO = null;
		long id = 0L;
		for (int i = 0; i < 5; i++) {
			gamePOJO = new GamePOJO();
			gamePOJO.setId(id);
			gamePOJO.setName("Prueba");
			gamePOJO.setAge(18);
			gamePOJO.setType("Accion");
			gamePOJO.setDescription("Description");
			games.add(gamePOJO);
		}
		refrescarTabla();
	}

	private void rellenarTablaConGamesPOJO(List<GamePOJO> games) {
		this.games = games;
		refrescarTabla();
	}

	private void rellenarTablaConGamePOJO(GamePOJO game) {
		this.games = new ArrayList<GamePOJO>();
		this.games.add(game);
		refrescarTabla();
	}

	private void refrescarTabla() {
		model.setRowCount(0);
		for (int i = 0; i < games.size(); i++) {
			model.addRow(games.get(i).getObjectArray());
		}
		model.fireTableDataChanged();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Manage Games");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 56);
				jPanel1.setFont(new java.awt.Font("Dialog", 0, 8));
				jPanel1.setBorder(BorderFactory
						.createTitledBorder(null, "Search",
								TitledBorder.LEADING,
								TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 10),
								new java.awt.Color(0, 0, 0)));
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Id:");
					jLabel1.setBounds(11, 22, 23, 16);
				}
				{
					cajaIdBuscar = new JTextField();
					jPanel1.add(cajaIdBuscar);
					cajaIdBuscar.setBounds(46, 19, 141, 23);
				}
				{
					botonSearch = new JButton();
					jPanel1.add(botonSearch);
					botonSearch.setText("Search");
					botonSearch.setBounds(193, 19, 82, 23);
					botonSearch.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonBuscar();
						}
					});
				}
				{
					botonAll = new JButton();
					jPanel1.add(botonAll);
					botonAll.setText("All");
					botonAll.setBounds(280, 19, 70, 23);
					botonAll.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonTodos();
						}
					});
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setFont(new java.awt.Font("Dialog", 0, 8));
				jPanel2.setBounds(13, 78, 360, 145);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory
						.createTitledBorder(null, "Games",
								TitledBorder.LEADING,
								TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 10),
								new java.awt.Color(0, 0, 0)));
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 336, 84);
					{
						model = new DefaultTableModel(new String[] { "Id",
								"Name", "Age", "Type", "Description" }, 2);
						tablaClientes = new JTable();
						jScrollPane1.setViewportView(tablaClientes);
						tablaClientes.setModel(model);

					}
				}
				{
					botonLineas = new JButton();
					jPanel2.add(botonLineas);
					botonLineas.setText("Subscriptions");
					botonLineas.setBounds(230, 113, 118, 23);
					botonLineas.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonSubscripciones();
						}
					});
				}
				{
					botonEditar = new JButton();
					jPanel2.add(botonEditar);
					botonEditar.setText("Edit");
					botonEditar.setBounds(150, 113, 70, 23);
					botonEditar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonEditar();
						}
					});
				}
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
				jPanel3.setFont(new java.awt.Font("Dialog", 0, 8));
				jPanel3.setBounds(13, 235, 359, 163);
				jPanel3.setLayout(null);
				jPanel3.setBorder(BorderFactory
						.createTitledBorder(null, "Edit", TitledBorder.LEADING,
								TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 10),
								new java.awt.Color(0, 0, 0)));
				{
					jLabel3 = new JLabel();
					jPanel3.add(jLabel3);
					jLabel3.setText("Id:");
					jLabel3.setBounds(10, 24, 23, 16);
				}
				{
					cajaId = new JTextField();
					jPanel3.add(cajaId);
					cajaId.setBounds(74, 21, 95, 23);
				}
				{
					cajaName = new JTextField();
					jPanel3.add(cajaName);
					cajaName.setBounds(74, 50, 274, 23);
				}
				{
					jLabel5 = new JLabel();
					jPanel3.add(jLabel5);
					jLabel5.setText("Name:");
					jLabel5.setBounds(10, 53, 57, 16);
				}
				{
					jLabel4 = new JLabel();
					jPanel3.add(jLabel4);
					jLabel4.setText("Age:");
					jLabel4.setBounds(10, 81, 57, 16);
				}
				{
					cajaAge = new JTextField();
					jPanel3.add(cajaAge);
					cajaAge.setBounds(74, 78, 274, 23);
				}
				{
					cajaType = new JTextField();
					jPanel3.add(cajaType);
					cajaType.setBounds(74, 107, 274, 23);
				}
				{
					jLabel8 = new JLabel();
					jPanel3.add(jLabel8);
					jLabel8.setText("Type:");
					jLabel8.setBounds(10, 110, 37, 16);
				}
				{
					cajaDescription = new JTextField();
					jPanel3.add(cajaDescription);
					cajaDescription.setBounds(74, 137, 274, 23);
				}
				{
					jLabel9 = new JLabel();
					jPanel3.add(jLabel9);
					jLabel9.setText("Descript.:");
					jLabel9.setBounds(10, 140, 57, 16);
				}
				{
					botonNew = new JButton();
					jPanel3.add(botonNew);
					botonNew.setText("New");
					botonNew.setBounds(181, 21, 73, 23);
					botonNew.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonNuevo();
						}
					});
				}
				{
					botonSave = new JButton();
					jPanel3.add(botonSave);
					botonSave.setText("Save");
					botonSave.setBounds(259, 21, 89, 23);
					botonSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonGuardar();
						}
					});
				}
			}
			{
				botonExit = new JButton();
				getContentPane().add(botonExit);
				botonExit.setText("Exit");
				botonExit.setBounds(297, 404, 75, 23);
				botonExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						botonSalir();
					}
				});
			}
			pack();
			this.setSize(400, 472);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void botonBuscar() {
		String idBuscar = cajaIdBuscar.getText();
		if (idBuscar != null && !idBuscar.equals("")) {
			GamePOJO game = controller.findById(Long.valueOf(cajaIdBuscar
					.getText()));
			if (game != null) {
				rellenarTablaConGamePOJO(game);
			} else {
				JOptionPane.showMessageDialog(this, "No game found with id "
						+ cajaIdBuscar.getText());
			}

		}

	}

	private void botonTodos() {
		List<GamePOJO> games = controller.findAll();
		if (games.size() > 0) {
			rellenarTablaConGamesPOJO(games);
		} else {
			JOptionPane.showMessageDialog(this, "No game registered");
		}

	}

	private void botonEditar() {
		int fila = tablaClientes.getSelectedRow();
		if (fila >= 0) {
			GamePOJO gamePOJO = games.get(fila);
			cajaId.setText(String.valueOf(gamePOJO.getId()));
			cajaName.setText(gamePOJO.getName());
			cajaDescription.setText(gamePOJO.getDescription());
			cajaType.setText(gamePOJO.getType());
			cajaAge.setText(String.valueOf(gamePOJO.getAge()));
		} else {
			JOptionPane.showMessageDialog(null,
					"You must select a game to edit");
		}
	}

	private void botonSubscripciones() {
		int fila = tablaClientes.getSelectedRow();
		if (fila >= 0) {
			ManageSubscriptionGUI subsriptionsGUI = new ManageSubscriptionGUI(this, games.get(tablaClientes
					.getSelectedRow()), subscriptionController);
			subsriptionsGUI.setClientController(clientController);
		} else {
			JOptionPane.showMessageDialog(null, "You must select a game");
		}
	}

	private void botonNuevo() {

	}

	private void botonGuardar() {

	}

	private void botonSalir() {
		System.exit(0);
	}

	public void setSubscriptionController(
			ManageSubscriptionGUIController subscriptionController) {
		this.subscriptionController = subscriptionController;
	}

	public void setClientController(ManageClientGUIController clientController) {
		this.clientController = clientController;
	}

}
