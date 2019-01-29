package main.vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.interfaces.IUser;
import main.modelos.Users;
import javax.swing.JMenuItem;

public class Login implements ActionListener{
	
	private JFrame frame;
	private JDesktopPane desktop;
	private JInternalFrame if1;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JTextField txtLogin;
	private JButton btnSend;
	private JMenuBar menuBar;
	private JMenu mnProjects;
	private JMenu mnUsuarios;
	private JLabel lblUser;
	private JLabel lblNameUser;
	private JLabel lblError;
	private JButton btnExit;
	private JPasswordField passwordField;
	private IUser iuser;
	
	public Login(IUser iuser) {
		this.iuser = iuser;
		initialize();
	}

	private void initialize() {
		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblUser = new JLabel("Usuario:");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblUser.setVisible(false);
		
		lblNameUser = new JLabel();
		lblNameUser.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNameUser.setVisible(false);
		
		lblError = new JLabel("El Usuario y/o Contraseņa son incorrectos.");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		
		txtLogin = new JTextField(10);
		txtLogin.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(this);
		
		btnSend = new JButton("Enviar");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.addActionListener(this);
		
		btnExit = new JButton("SALIR");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setVisible(false);
		
		frame = new JFrame("Gestor de proyectos" + iuser.getTitleConnection());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 750, 715);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		desktop = new JDesktopPane();
		desktop.setBackground(Color.WHITE);
		if1 = new JInternalFrame("Login", true, true, true, true);
		if1.setSize(500, 330);
		if1.setLocation(-274, -184);
		desktop.add(if1);
		
		
		GroupLayout groupLayout = new GroupLayout(if1.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLogin)
								.addComponent(lblPassword))
							.addGap(86)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtLogin, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
					.addGap(87))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);

		if1.getContentPane().setLayout(groupLayout);
		if1.setVisible(true);
		GroupLayout groupLayout_1 = new GroupLayout(frame.getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap(278, Short.MAX_VALUE)
					.addComponent(lblUser)
					.addGap(18)
					.addComponent(lblNameUser, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnExit)
					.addGap(18))
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGap(38)
					.addComponent(desktop, GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
					.addGap(54))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExit)
						.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNameUser)
							.addComponent(lblUser)))
					.addComponent(lblError)
					.addGap(47)
					.addComponent(desktop, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
					.addGap(41))
		);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 684, 21);
		frame.setJMenuBar(menuBar);

		mnProjects = new JMenu("Proyectos");
		menuBar.add(mnProjects);
		
		JMenuItem mntmCrearProyecto = new JMenuItem("Crear Proyecto");
		mnProjects.add(mntmCrearProyecto);
		
		JMenuItem mntmMostrarProyectos = new JMenuItem("Mostrar Proyectos");
		mnProjects.add(mntmMostrarProyectos);

		mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmCrearUsuario = new JMenuItem("Crear Usuario");
		mntmCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearUsuario cu=new CrearUsuario(iuser);
				desktop.add(cu);
				desktop.setVisible(true);
			}
		});
		mnUsuarios.add(mntmCrearUsuario);
		
		JMenuItem mntmBuscarmodificarUsuario = new JMenuItem("Buscar/Modificar Usuario");
		mnUsuarios.add(mntmBuscarmodificarUsuario);
		
		menuBar.setVisible(false);
		frame.getContentPane().setLayout(groupLayout_1);
		frame.setVisible(true);
		
		Dimension desktopSize = desktop.getSize();
		Dimension jInternalFrameSize = if1.getSize();
		if1.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		
		mntmCrearProyecto.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaProyecto v = new VentanaProyecto();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Users user = iuser.getUserLogin(txtLogin.getText(), String.valueOf(passwordField.getPassword()));
		if(user != null) {
			try {
				lblError.setVisible(false);
				if1.setClosed(true);
				lblUser.setVisible(true);
				lblNameUser.setText(user.getNickname() + " (" + iuser.getUserLoggedPermission() + ")");
				lblNameUser.setVisible(true);
				btnExit.setVisible(true);
				menuBar.setVisible(true);
				CrearUsuario cu1 = new CrearUsuario(iuser);
				cu1.setSize(500,500);
				cu1.setLocation(100, 5);
				desktop.add(cu1);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		}else {
			lblError.setVisible(true);
			System.err.println("Usuario no encontrado");
		}
	}
}
