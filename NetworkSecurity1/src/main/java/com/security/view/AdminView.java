package com.security.view;



import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import com.security.controller.Controller;
import com.security.model.Doctor;
import com.security.model.Patient;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class AdminView extends JFrame{

	@SuppressWarnings("unused")
	private String[] args;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel LoginSystem;
	@SuppressWarnings("unused")
	private JTextField txtRole;
	private JButton btnLogin;
	private JButton btnExit;
	private JRadioButton rdbtnDoctor;
	private JRadioButton rdbtnPatient;
	private JRadioButton rdbtnNurse;
	private JRadioButton rdbtnRelative;
	private Controller securityController; 

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */

	public AdminView(String title) {
		super();
		setTitle(title);

	}
	public void run() {
		securityController=Controller.getController();
		initialize();
	}
	public void setArgs(String[] args) {
		this.args = args;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 812, 444);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(61, 63, 109, 36);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(61, 115, 109, 36);
		getContentPane().add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(218, 66, 146, 31);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(218, 118, 140, 31);
		getContentPane().add(txtPassword);

		LoginSystem = new JLabel(" LOGIN SYSTEM");
		LoginSystem.setBounds(307, 16, 160, 34);
		getContentPane().add(LoginSystem);

		btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(100, 305, 115, 29);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginButtonAction(arg0);
			}
		});

		btnExit = new JButton("EXIT");
		btnExit.setBounds(549, 305, 115, 29);
		getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(44, 266, 696, 7);
		getContentPane().add(separator);

		rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setBounds(172, 183, 89, 29);
		getContentPane().add(rdbtnDoctor);

		rdbtnNurse = new JRadioButton("Nurse");
		rdbtnNurse.setBounds(268, 183, 84, 29);
		getContentPane().add(rdbtnNurse);

		rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setBounds(359, 183, 95, 29);
		getContentPane().add(rdbtnPatient);

		rdbtnRelative = new JRadioButton("Relative");
		rdbtnRelative.setBounds(454, 183, 155, 29);
		getContentPane().add(rdbtnRelative);




	}
	@SuppressWarnings("unused")
	public void loginButtonAction(ActionEvent arg0) {
		try {
			char[] pass=txtPassword.getPassword();
			String username =txtUsername.getText();
			String password=new String(pass);
			if(rdbtnDoctor.isSelected()) {
				if(securityController.validateLogin(username,password,rdbtnDoctor.getText())) {
					Doctor doctor=securityController.getDoctorByUsername(username);
					DoctorView doctorScreen=new DoctorView(doctor);
					this.setVisible(false);
				}
			}
			else if(rdbtnPatient.isSelected()) {
				if(securityController.validateLogin(username,password,"Patient")) {
					Patient patient=new Patient("samet", "caliskan","20.10.2015","grip");
					PatientView patientScreen=new PatientView( patient );
					this.setVisible(false);
					patientScreen.setVisible(true);
				}
			}
			else if(rdbtnNurse.isSelected()) {
				if(securityController.validateLogin(username,password,rdbtnNurse.getText())) {
					
				}
			}else if(rdbtnRelative.isSelected()) {
				if(securityController.validateLogin(username,password,rdbtnRelative.getText())) {
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
