package gamesubscription.client.gui;

import gamesubscription.client.controller.ManageSubscriptionGameGUIController;
import gamesubscription.client.pojo.ClientPOJO;
import gamesubscription.client.pojo.SubscriptionGamePOJO;
import gamesubscription.client.pojo.SubscriptionPOJO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class ManageSubscriptionGameGUI extends JFrame {

	private static final long serialVersionUID = -1486649379710690407L;
	
	private JPanel jPanel1;
	private JLabel labelPrice;
	private JLabel labelDescription;
	private JLabel labelName;
	private JTextField cajaDNI;
	private JComboBox<ClientPOJO> cajaClientes;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel labelId;
	private JTextField cajaTelephone;
	private JLabel jLabel9;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel2;
	
	private JButton botonCerrar;
	private JButton botonGuardar;
	private JButton botonCancel;
	private JButton botonNewSubscriptor;
	private JButton botonNewCliente;
	private JButton botonEditCliente;
	private JButton botonDeleteSubscription;
	
	private JTable tablaClientes;
	private JScrollPane jScrollPane1;
	private JLabel jLabel8;
	private JTextField cajaAddress;
	private JTextField cajaSurname;
	private JTextField cajaName;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JLabel jLabel1;
	
	private SubscriptionPOJO subscriptionPOJO;
	private ManageSubscriptionGUI manageSubscriptionGUI;
	private ManageSubscriptionGameGUIController controller;
	
	private DefaultTableModel model;
	private List<SubscriptionGamePOJO> subscriptionsGame;
	
	public ManageSubscriptionGameGUI ( )
	{
		super();
		initGUI();
	}
	
	public ManageSubscriptionGameGUI( SubscriptionPOJO subscriptionPOJO, ManageSubscriptionGameGUIController controller ) {
		super();
		this.subscriptionPOJO = subscriptionPOJO;
		this.controller = controller;
		this.setVisible(true);
		subscriptionsGame = new ArrayList<SubscriptionGamePOJO>();
		initGUI();
		if ( subscriptionPOJO != null )
		{
			rellenarTablaConClientes( controller.findBySubscriptionId(subscriptionPOJO.getId()));
		}
		this.setLocationRelativeTo(null);
		
	}
	
	public void setManageSubscriptionGUI(ManageSubscriptionGUI manageSubscriptionGUI) {
		this.manageSubscriptionGUI = manageSubscriptionGUI;
		this.manageSubscriptionGUI.setVisible(false);
	}
	
	/**private void rellenarTablaDatosPrueba() {
		subscriptionsGame.clear();
		SubscriptionGamePOJO subscription = null;
		ClientPOJO clientPOJO = null;
		for (int i = 0; i < 5; i++) {
			subscription = new SubscriptionGamePOJO();
			java.util.Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
			subscription.setFechaSuscripcion(date );
			clientPOJO = new ClientPOJO();
			clientPOJO.setAddress("Mariano Ciriquiain");
			clientPOJO.setDni("45893945E");
			clientPOJO.setName("Aitor");
			clientPOJO.setSurname("Simon");
			clientPOJO.setPhone("671150776");
			subscription.setCliente(clientPOJO);
			subscriptionsGame.add(subscription);
		}
		refrescarTabla();
	}**/
	
	private void rellenarTablaConClientes( List<SubscriptionGamePOJO> subscriptionsGame ) {
		this.subscriptionsGame.clear();
		this.subscriptionsGame = subscriptionsGame;
		refrescarTabla();
	}
	
	private void refrescarTabla() {
		model.setRowCount(0);
		for (int i = 0; i < subscriptionsGame.size(); i++) {
			model.addRow(subscriptionsGame.get(i).getObjectArray());
		}
		model.fireTableDataChanged();
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
					jLabel6.setText("Descript:");
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
				jPanel2.setBounds(13, 140, 360, 170);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Subscribed clients", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 336, 84);
					{
						model = 
							new DefaultTableModel(
									new String[] { "DNI", "Name", "Surname", "Address", "Telephone","Date" }, 2);
						tablaClientes = new JTable();
						jScrollPane1.setViewportView(tablaClientes);
						tablaClientes.setModel(model);
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
					botonEditCliente = new JButton();
					jPanel2.add(botonEditCliente);
					botonEditCliente.setText("Edit Client");
					botonEditCliente.setBounds(194, 140, 150, 23);
					botonEditCliente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonEditar();
						}
					});
				}
				{
					botonNewSubscriptor = new JButton();
					jPanel2.add(botonNewSubscriptor);
					botonNewSubscriptor.setText("New Subscription");
					botonNewSubscriptor.setBounds(50, 113, 140, 23);
					botonNewSubscriptor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonNewSubscriptor();
						}
					});
				}
				{
					botonNewCliente = new JButton();
					jPanel2.add(botonNewCliente);
					botonNewCliente.setText("New Client");
					botonNewCliente.setBounds(80, 140, 110, 23);
					botonNewCliente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonNewClient();
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
					jLabel3.setText("DNI:");
					jLabel3.setBounds(10, 24, 64, 16);
				}
				{
					cajaDNI = new JTextField();
					jPanel3.add(cajaDNI);
					cajaDNI.setBounds(86, 21, 87, 23);
				}
				{
					cajaClientes = new JComboBox<ClientPOJO>();
					cajaClientes.setVisible(false);
					jPanel3.add(cajaClientes);
					cajaClientes.setBounds(86, 21, 87, 23);
				}
				{
					cajaName = new JTextField();
					jPanel3.add(cajaName);
					cajaName.setBounds(86, 50, 87, 23);
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
					jLabel4.setText("Surname:");
					jLabel4.setBounds(10, 81, 71, 16);
				}
				{
					cajaSurname = new JTextField();
					jPanel3.add(cajaSurname);
					cajaSurname.setBounds(85, 78, 263, 23);
				}
				{
					cajaAddress = new JTextField();
					jPanel3.add(cajaAddress);
					cajaAddress.setBounds(85, 107, 263, 23);
				}
				{
					jLabel8 = new JLabel();
					jPanel3.add(jLabel8);
					jLabel8.setText("Address:");
					jLabel8.setBounds(10, 110, 71, 16);
				}
				{
					botonCancel = new JButton();
					jPanel3.add(botonCancel);
					botonCancel.setText("Cancel");
					botonCancel.setBounds(183, 21, 78, 23);
					botonCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonCancel();
						}
					});
					botonCancel.setVisible(false);
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
					botonGuardar.setVisible(false);
				}
				{
					jLabel9 = new JLabel();
					jPanel3.add(jLabel9);
					jLabel9.setText("Telephone:");
					jLabel9.setBounds(10, 138, 71, 16);
				}
				{
					cajaTelephone = new JTextField();
					jPanel3.add(cajaTelephone);
					cajaTelephone.setBounds(87, 135, 261, 23);
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
			e.printStackTrace();
		}
	}
	
	private void botonNewClient()
	{
		estadoInicialFields();
		mostrarBotoneraGuardarYCancelar();
	}
	private void botonEditar(){
		int row = tablaClientes.getSelectedRow();
		if ( row > -1 )
		{
			estadoEditarClienteFields();
			mostrarBotoneraGuardarYCancelar();
			ClientPOJO client = subscriptionsGame.get(row).getCliente();
			cajaDNI.setEditable(false);
			cajaDNI.setText(client.getDni());
			cajaAddress.setText(client.getAddress());
			cajaName.setText(client.getName());
			cajaSurname.setText(client.getSurname());
			cajaTelephone.setText(client.getPhone());
		}
		else
		{
			JOptionPane.showMessageDialog(this, "You must select a client");
		}
	}
	private void botonDeleteSubscription(){
		int row = tablaClientes.getSelectedRow();
		
		if ( row > -1 )
		{
			long idCliente = subscriptionsGame.get(row).getCliente().getId();
			long idSubscription = subscriptionPOJO.getId();
			
			if ( controller.deleteSubscription( idSubscription, idCliente) )
			{
				rellenarTablaConClientes ( controller.findBySubscriptionId(idSubscription) );
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "You must select a subscription");
		}
	}
	
	private void botonNewSubscriptor() {
		estadoNuevaSusFields();
		mostrarBotoneraGuardarYCancelar();
	}
	
	private void botonCancel(){
		estadoInicialFields();
		ocultarBotoneraGuardarYCancelar();
	}
	
	private void estadoInicialFields()
	{
		cajaDNI.setEnabled(true);
		cajaDNI.setVisible(true);
		cajaClientes.setVisible(false);
		cajaDNI.setEditable(true);
		tablaClientes.clearSelection();
		
		cajaDNI.setText("");
		cajaName.setText("");
		cajaName.setEditable(true);
		cajaName.setEnabled(true);
		cajaSurname.setText("");
		cajaSurname.setEditable(true);
		cajaSurname.setEnabled(true);
		cajaAddress.setText("");
		cajaAddress.setEditable(true);
		cajaAddress.setEnabled(true);
		cajaTelephone.setEnabled(true);
		cajaTelephone.setEditable(true);
		cajaTelephone.setText("");
	}
	
	private void estadoEditarClienteFields()
	{
		cajaDNI.setEditable(false);
	}
	
	private void estadoNuevaSusFields()
	{
		List<ClientPOJO> clientes = controller.findAll();
		if ( cajaClientes.getItemCount() > 0 )
		{
			cajaClientes.removeAllItems();
		}
		Set<String> dnisClientesConSuscripcion = getDNIClientesConSusbscripcion();
		for ( ClientPOJO cliente: clientes )
		{
			if ( !dnisClientesConSuscripcion.contains(cliente.getDni()) )
				cajaClientes.addItem(cliente);
		}
		
		cajaClientes.setVisible(true);
		cajaDNI.setVisible(false);
		
		cajaAddress.setEnabled(false);
		cajaName.setEnabled(false);
		cajaSurname.setEnabled(false);
		cajaTelephone.setEnabled(false);
	}
	
	private Set<String> getDNIClientesConSusbscripcion()
	{
		Set<String> dnis = new HashSet<String>();
		for ( SubscriptionGamePOJO sus : subscriptionsGame)
		{
			if ( sus.getCliente() != null)
			{
				dnis.add ( sus.getCliente().getDni() );
			}
		}
		return dnis;
	}
	
	private void mostrarBotoneraGuardarYCancelar()
	{
		botonCancel.setVisible(true);
		botonGuardar.setVisible(true);
	}
	
	private void ocultarBotoneraGuardarYCancelar()
	{
		botonCancel.setVisible(false);
		botonGuardar.setVisible(false);
	}
	
	private void botonGuardar(){
		if ( cajaDNI.isVisible() )
		{
				if ( cajaDNI.isEditable() )
				{
					controller.insertClient(getClientFromCells());
				}
				else
				{
					ClientPOJO clientToUpdate = getClientFromCells();
					clientToUpdate.setId(subscriptionsGame.get(tablaClientes.getSelectedRow()).getCliente().getId());
					if ( controller.updateClient(clientToUpdate) )
					{
						rellenarTablaConClientes( controller.findBySubscriptionId(subscriptionPOJO.getId()) );
					}
				}
		}
		else
		{
			long idCliente = ((ClientPOJO)cajaClientes.getSelectedItem()).getId();
			if ( controller.insertSubscription(subscriptionPOJO.getId(), idCliente) )
			{
				rellenarTablaConClientes( controller.findBySubscriptionId(subscriptionPOJO.getId()) );
			}
		}
		estadoInicialFields();
		ocultarBotoneraGuardarYCancelar();
	}
	
	private ClientPOJO getClientFromCells()
	{
		ClientPOJO clientPOJO = new ClientPOJO();
		if ( cajaDNI.getText() != null && !cajaDNI.getText().isEmpty())
		{
			clientPOJO.setDni(cajaDNI.getText());
		}
		if ( cajaAddress.getText() != null && !cajaAddress.getText().isEmpty())
		{
			clientPOJO.setAddress(cajaAddress.getText());
		}
		if ( cajaName.getText() != null && !cajaName.getText().isEmpty())
		{
			clientPOJO.setName(cajaName.getText());
		}
		if ( cajaTelephone.getText() != null && !cajaTelephone.getText().isEmpty())
		{
			clientPOJO.setPhone(cajaTelephone.getText());
		}
		if ( cajaSurname.getText() != null && !cajaSurname.getText().isEmpty())
		{
			clientPOJO.setSurname(cajaSurname.getText());
		}
		return clientPOJO;
	}
	private void botonCerrar(){
		this.dispose();
		manageSubscriptionGUI.setVisible(true);
	}
	
}
