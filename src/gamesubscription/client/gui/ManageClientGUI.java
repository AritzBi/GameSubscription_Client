package gamesubscription.client.gui;

import gamesubscription.client.controller.ManageClientGUIController;
import gamesubscription.client.pojo.GamePOJO;
import gamesubscription.client.pojo.SubscriptionPOJO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManageClientGUI extends JFrame {

	private static final long serialVersionUID = -1486649379710690407L;
	
	private JPanel jPanel1;
	private JCheckBox checkActiva;
	private JLabel labelPrice;
	private JLabel labelDescription;
	private JLabel labelName;
	private JTextField cajaTelefono;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel labelId;
	private JTextField cajaPromocion;
	private JLabel jLabel9;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel2;
	private JButton botonCerrar;
	private JButton botonGuardar;
	private JButton botonNueva;
	private JButton botonEditar;
	private JButton botonDeleteSubscription;
	private JTable tablaLineas;
	private JScrollPane jScrollPane1;
	private JLabel jLabel8;
	private JTextField cajaDatos;
	private JTextField cajaVoz;
	private JTextField cajaAntiguedad;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JLabel jLabel1;
	
	private GamePOJO gamePOJO;
	private SubscriptionPOJO subscriptionPOJO;
	private ManageSubscriptionGUI manageSubscriptionGUI;
	private ManageClientGUIController controller;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ManageClientGUI inst = new ManageClientGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManageClientGUI ( )
	{
		super();
		initGUI();
	}
	
	public ManageClientGUI( GamePOJO gamePOJO, SubscriptionPOJO subscriptionPOJO, ManageClientGUIController controller ) {
		super();
		this.gamePOJO = gamePOJO;
		this.subscriptionPOJO = subscriptionPOJO;
		this.controller = controller;
		initGUI();
	}
	
	public void setManageSubscriptionGUI(ManageSubscriptionGUI manageSubscriptionGUI) {
		this.manageSubscriptionGUI = manageSubscriptionGUI;
		this.manageSubscriptionGUI.setVisible(false);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Manage Clients");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 116);
				jPanel1.setFont(new java.awt.Font("Dialog",1,10));
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Suscription Data", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Id:");
					jLabel1.setBounds(11, 22, 62, 16);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Name:");
					jLabel2.setBounds(11, 44, 62, 16);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("Description:");
					jLabel6.setBounds(11, 66, 62, 16);
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7);
					jLabel7.setText("Price:");
					jLabel7.setBounds(11, 89, 62, 16);
				}
				{
					labelId = new JLabel();
					jPanel1.add(labelId);
					labelId.setText( subscriptionPOJO != null ? String.valueOf(subscriptionPOJO.getId()) : "xxxxxxxxx" );
					labelId.setBounds(80, 22, 263, 16);
					labelId.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelName = new JLabel();
					jPanel1.add(labelName);
					labelName.setText(subscriptionPOJO != null ? subscriptionPOJO.getName() : "xxxxxxxxx" );
					labelName.setBounds(80, 44, 263, 16);
					labelName.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelDescription = new JLabel();
					jPanel1.add(labelDescription);
					labelDescription.setText(subscriptionPOJO != null ? subscriptionPOJO.getDescription() : "xxxxxxxxx" );
					labelDescription.setBounds(80, 66, 263, 16);
					labelDescription.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelPrice = new JLabel();
					jPanel1.add(labelPrice);
					labelPrice.setText(subscriptionPOJO != null ? String.valueOf(subscriptionPOJO.getPrice()) : "xxxxxxxxx" );
					labelPrice.setBounds(80, 89, 263, 16);
					labelPrice.setFont(new java.awt.Font("Segoe UI",1,12));
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setFont(new java.awt.Font("Dialog",0,8));
				jPanel2.setBounds(13, 140, 360, 145);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Subscribed clients", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 336, 84);
					{
						TableModel jTable1Model = 
							new DefaultTableModel(
									new String[] { "Teléfono", "Antiguedad", "Activa", "Promoción" }, 2);
						tablaLineas = new JTable();
						jScrollPane1.setViewportView(tablaLineas);
						tablaLineas.setModel(jTable1Model);
					}
				}
				{
					botonDeleteSubscription = new JButton();
					jPanel2.add(botonDeleteSubscription);
					botonDeleteSubscription.setText("Delete Subscription");
					botonDeleteSubscription.setBounds(194, 113, 150, 23);
					botonDeleteSubscription.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonDeleteSubscription();
						}
					});
				}
				{
					botonEditar = new JButton();
					jPanel2.add(botonEditar);
					botonEditar.setText("Edit");
					botonEditar.setBounds(119, 113, 70, 23);
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
				jPanel3.setFont(new java.awt.Font("Dialog",0,8));
				jPanel3.setBounds(13, 297, 359, 173);
				jPanel3.setLayout(null);
				jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Edition", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabel3 = new JLabel();
					jPanel3.add(jLabel3);
					jLabel3.setText("Telefono:");
					jLabel3.setBounds(10, 24, 64, 16);
				}
				{
					cajaTelefono = new JTextField();
					jPanel3.add(cajaTelefono);
					cajaTelefono.setBounds(86, 21, 87, 23);
				}
				{
					cajaAntiguedad = new JTextField();
					jPanel3.add(cajaAntiguedad);
					cajaAntiguedad.setBounds(86, 50, 87, 23);
				}
				{
					jLabel5 = new JLabel();
					jPanel3.add(jLabel5);
					jLabel5.setText("Antiguedad:");
					jLabel5.setBounds(10, 53, 71, 16);
				}
				{
					jLabel4 = new JLabel();
					jPanel3.add(jLabel4);
					jLabel4.setText("Tarifa voz:");
					jLabel4.setBounds(10, 81, 71, 16);
				}
				{
					cajaVoz = new JTextField();
					jPanel3.add(cajaVoz);
					cajaVoz.setBounds(85, 78, 263, 23);
				}
				{
					cajaDatos = new JTextField();
					jPanel3.add(cajaDatos);
					cajaDatos.setBounds(85, 107, 263, 23);
				}
				{
					jLabel8 = new JLabel();
					jPanel3.add(jLabel8);
					jLabel8.setText("Tarifa datos:");
					jLabel8.setBounds(10, 110, 71, 16);
				}
				{
					botonNueva = new JButton();
					jPanel3.add(botonNueva);
					botonNueva.setText("New");
					botonNueva.setBounds(183, 21, 78, 23);
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
					botonGuardar.setBounds(266, 21, 82, 23);
					botonGuardar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonGuardar();
						}
					});
				}
				{
					jLabel9 = new JLabel();
					jPanel3.add(jLabel9);
					jLabel9.setText("Promoción:");
					jLabel9.setBounds(10, 138, 71, 16);
				}
				{
					cajaPromocion = new JTextField();
					jPanel3.add(cajaPromocion);
					cajaPromocion.setBounds(87, 135, 261, 23);
				}
				{
					checkActiva = new JCheckBox();
					jPanel3.add(checkActiva);
					checkActiva.setText("Activa ");
					checkActiva.setBounds(197, 51, 69, 20);
				}
			}
			{
				botonCerrar = new JButton();
				getContentPane().add(botonCerrar);
				botonCerrar.setText("Close");
				botonCerrar.setBounds(295, 476, 78, 23);
				botonCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						botonCerrar();
					}
				});
			}
			pack();
			this.setSize(400, 544);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void botonEditar(){
		
	}
	private void botonDeleteSubscription(){
		
	}
	private void botonNueva(){
		
	}
	private void botonGuardar(){
		
	}
	private void botonCerrar(){
		
	}
	
}
