package gamesubscription.client.gui;

import gamesubscription.client.controller.ManageSubscriptionGameGUIController;
import gamesubscription.client.controller.ManageSubscriptionGUIController;
import gamesubscription.client.pojo.GamePOJO;
import gamesubscription.client.pojo.SubscriptionPOJO;

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

public class ManageSubscriptionGUI extends JFrame 
{

	private static final long serialVersionUID = -6185731246475153843L;
	private JPanel jPanel1;
	private JLabel labelDescription;
	private JLabel labelName;
	private JTextField cajaId;
	
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel labelId;
	private JLabel jLabel6;
	private JLabel jLabel2;
	
	private JButton botonCerrar;
	private JButton botonGuardar;
	private JButton botonNueva;
	private JButton botonEditar;
	private JButton botonBorrar;
	private JButton botonClientes;
	
	private JTable tablaSubscriptions;
	
	private JLabel labelType;
	private JLabel labelAge;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JScrollPane jScrollPane1;
	private JLabel jLabel8;
	private JTextField cajaPrice;
	private JTextField cajaDescription;
	private JTextField cajaName;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JLabel jLabel1;
	
	private ManageGameGUI manageGameGUI;
	private ManageSubscriptionGUIController controller;
	private ManageSubscriptionGameGUIController clientController;
	
	private GamePOJO gamePOJO;
	private DefaultTableModel model;
	
	private List<SubscriptionPOJO> subscriptions;
	
	public ManageSubscriptionGUI( ManageGameGUI manageGameGUI , GamePOJO gamePOJO, ManageSubscriptionGUIController controller ) {
		super();
		this.manageGameGUI = manageGameGUI;
		this.manageGameGUI.setVisible(false);
		this.gamePOJO = gamePOJO;
		this.controller = controller;
		subscriptions = new ArrayList<SubscriptionPOJO>();
		initGUI();
		rellenarTablaDatosPrueba();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void setClientController(ManageSubscriptionGameGUIController clientController) {
		this.clientController = clientController;
	}

	private void rellenarTablaDatosPrueba() {
		subscriptions.clear();
		SubscriptionPOJO subscription = null;
		long id = 0L;
		for (int i = 0; i < 5; i++) {
			subscription = new SubscriptionPOJO();
			subscription.setId(id);
			subscription.setName("Premium");
			subscription.setDescription("30 days trial");
			subscription.setPrice(30.00);
			subscriptions.add(subscription);
		}
		refrescarTabla();
	}
	
	private void rellenarTablaConSubscripciones( List<SubscriptionPOJO> subscriptions ) {
		this.subscriptions.clear();
		this.subscriptions = subscriptions;
		refrescarTabla();
	}
	
	private void refrescarTabla() {
		model.setRowCount(0);
		for (int i = 0; i < subscriptions.size(); i++) {
			model.addRow(subscriptions.get(i).getObjectArray());
		}
		model.fireTableDataChanged();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Manage Subscriptions");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 116);
				jPanel1.setFont(new java.awt.Font("Dialog",1,10));
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Game Data", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Id:");
					jLabel1.setBounds(11, 22, 70, 16);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Name:");
					jLabel2.setBounds(11, 44, 70, 16);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("Description:");
					jLabel6.setBounds(11, 66, 70, 16);
				}
				{
					labelId = new JLabel();
					jPanel1.add(labelId);
					labelId.setText( String.valueOf(gamePOJO.getId()));
					labelId.setBounds(92, 22, 102, 16);
					labelId.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelName = new JLabel();
					jPanel1.add(labelName);
					labelName.setText(gamePOJO.getName());
					labelName.setBounds(92, 44, 102, 16);
					labelName.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelDescription = new JLabel();
					jPanel1.add(labelDescription);
					labelDescription.setText(gamePOJO.getDescription());
					labelDescription.setBounds(92, 66, 102, 16);
					labelDescription.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					jLabel10 = new JLabel();
					jPanel1.add(jLabel10);
					jLabel10.setText("Age:");
					jLabel10.setBounds(195, 22, 65, 16);
				}
				{
					jLabel11 = new JLabel();
					jPanel1.add(jLabel11);
					jLabel11.setText("Type:");
					jLabel11.setBounds(195, 44, 65, 16);
				}
				{
					labelAge = new JLabel();
					jPanel1.add(labelAge);
					labelAge.setText( String.valueOf(gamePOJO.getAge()));
					labelAge.setBounds(263, 22, 87, 16);
					labelAge.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelType = new JLabel();
					jPanel1.add(labelType);
					labelType.setText(gamePOJO.getType());
					labelType.setBounds(263, 44, 87, 16);
					labelType.setFont(new java.awt.Font("Segoe UI",1,12));
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setFont(new java.awt.Font("Dialog",0,8));
				jPanel2.setBounds(13, 140, 360, 145);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Subscriptions", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 336, 84);
					{
						model = 
							new DefaultTableModel(
									new String[] { "Id", "Name", "Description","Price" }, 2);
						tablaSubscriptions = new JTable();
						jScrollPane1.setViewportView(tablaSubscriptions);
						tablaSubscriptions.setModel(model);
					}
				}
				{
					botonBorrar = new JButton();
					jPanel2.add(botonBorrar);
					botonBorrar.setText("Delete");
					botonBorrar.setBounds(266, 113, 82, 23);
					botonBorrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonBorrar();
						}
					});
				}
				{
					botonEditar = new JButton();
					jPanel2.add(botonEditar);
					botonEditar.setText("Edit");
					botonEditar.setBounds(185, 113, 76, 23);
					botonEditar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonEditar();
						}
					});
				}
				{
					botonClientes = new JButton();
					jPanel2.add(botonClientes);
					botonClientes.setText("Clients");
					botonClientes.setBounds(105, 113, 76, 23);
					botonClientes.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonClientes();
						}
					});
				}
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
				jPanel3.setFont(new java.awt.Font("Dialog",0,8));
				jPanel3.setBounds(13, 297, 359, 145);
				jPanel3.setLayout(null);
				jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Edit", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabel3 = new JLabel();
					jPanel3.add(jLabel3);
					jLabel3.setText("Id:");
					jLabel3.setBounds(10, 24, 64, 16);
				}
				{
					cajaId = new JTextField();
					jPanel3.add(cajaId);
					cajaId.setBounds(86, 21, 83, 23);
				}
				{
					cajaName = new JTextField();
					jPanel3.add(cajaName);
					cajaName.setBounds(86, 50, 262, 23);
				}
				{
					jLabel5 = new JLabel();
					jPanel3.add(jLabel5);
					jLabel5.setText("Name:");
					jLabel5.setBounds(10, 53, 71, 16);
				}
				{
					jLabel4 = new JLabel();
					jPanel3.add(jLabel4);
					jLabel4.setText("Descript.:");
					jLabel4.setBounds(10, 81, 57, 16);
				}
				{
					cajaDescription = new JTextField();
					jPanel3.add(cajaDescription);
					cajaDescription.setBounds(86, 78, 262, 23);
				}
				{
					cajaPrice = new JTextField();
					jPanel3.add(cajaPrice);
					cajaPrice.setBounds(86, 107, 262, 23);
				}
				{
					jLabel8 = new JLabel();
					jPanel3.add(jLabel8);
					jLabel8.setText("Price:");
					jLabel8.setBounds(10, 110, 71, 16);
				}
				{
					botonNueva = new JButton();
					jPanel3.add(botonNueva);
					botonNueva.setText("New");
					botonNueva.setBounds(181, 21, 78, 23);
					botonNueva.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonNueva();
						}
					});
				}
				{
					botonGuardar = new JButton();
					jPanel3.add(botonGuardar);
					botonGuardar.setText("Save");
					botonGuardar.setBounds(264, 21, 84, 23);
					botonGuardar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonGuardar();
						}
					});
				}
			}
			{
				botonCerrar = new JButton();
				getContentPane().add(botonCerrar);
				botonCerrar.setText("Close");
				botonCerrar.setBounds(294, 450, 79, 23);
				botonCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						botonCerrar();
					}
				});
			}
			pack();
			this.setSize(400, 521);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void botonEditar(){
		int selectedRow = tablaSubscriptions.getSelectedRow();
		if ( selectedRow > -1 )
		{
			SubscriptionPOJO subscription = subscriptions.get(selectedRow);
			if ( subscription != null )
			{
				cajaId.setText(String.valueOf(subscription.getId()));
				cajaName.setText(subscription.getName());
				cajaDescription.setText(subscription.getDescription());
				cajaPrice.setText(String.valueOf(subscription.getPrice()));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "You need to select a subscription");
		}
		
		
	}
	private void botonBorrar(){
		SubscriptionPOJO subs = subscriptions.get( tablaSubscriptions.getSelectedRow() );
		if ( controller.deleteSubscription(subs.getId()) )
		{
			rellenarTablaConSubscripciones( controller.findByGameId(gamePOJO.getId()) );
		}	
	}
	private void botonNueva(){
		tablaSubscriptions.clearSelection();
		cajaId.setEnabled(false);
		cajaId.setEditable(true);
		cajaId.setText("");
		cajaDescription.setText("");
		cajaName.setText("");
		cajaPrice.setText("");

	}
	private void botonGuardar(){
		if ( cajaId.isEditable() )
		{
			SubscriptionPOJO subscription = getSubscriptionFromCells();
			if ( controller.insertSubscription(subscription) )
			{
				rellenarTablaConSubscripciones(controller.findByGameId(gamePOJO.getId() ) );
			}
		}
		else
		{
			SubscriptionPOJO subscription = getSubscriptionFromCells();
			if ( controller.updateSubscription(subscription) )
			{
				rellenarTablaConSubscripciones(controller.findByGameId(gamePOJO.getId() ));
			}
		}
	}
	
	private SubscriptionPOJO getSubscriptionFromCells ()
	{
		SubscriptionPOJO subscriptionPOJO = new SubscriptionPOJO();
		subscriptionPOJO.setPrice(Integer.valueOf(cajaPrice.getText()));
		subscriptionPOJO.setDescription(cajaDescription.getText());
		subscriptionPOJO.setId(Long.valueOf(cajaId.getText()));
		subscriptionPOJO.setName(cajaName.getText());
		
		return subscriptionPOJO;
	}
	
	private void botonCerrar(){
		setVisible(false);
		manageGameGUI.setVisible(true);
		dispose();
	}
	
	private void botonClientes()
	{
		int idSubscription = tablaSubscriptions.getSelectedRow();
		if ( idSubscription > -1 )
		{
			SubscriptionPOJO subscription = subscriptions.get(idSubscription);
			ManageSubscriptionGameGUI gui = new ManageSubscriptionGameGUI( gamePOJO, subscription, clientController );
			gui.setManageSubscriptionGUI(this);
			
		}
	}
}