package com.security.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;

public class AdminView {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel LoginSystem;
	private JTextField txtRole;
	
	DoctorViewFrame doctorview=new DoctorViewFrame();
	NurseViewFrame nurseview=new NurseViewFrame();
	PatientViewFrame patientview=new PatientViewFrame();
	RelativeViewFrame relativeview=new RelativeViewFrame();
	

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 812, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(61, 63, 109, 36);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(61, 115, 109, 36);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(218, 66, 146, 31);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(218, 118, 140, 31);
		frame.getContentPane().add(txtPassword);
		
		LoginSystem = new JLabel(" LOGIN SYSTEM");
		LoginSystem.setBounds(307, 16, 160, 34);
		frame.getContentPane().add(LoginSystem);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password=txtPassword.getText();
				String username =txtUsername.getText();
				
				/*if (password.contains(" ")&& username.contains("")) {
					txtPassword.setText(null);
					txtUsername.setText(null);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Login","Login Error" , JOptionPane.ERROR_MESSAGE);
				}*/
				String role =txtRole.getText();
				
				
				if(role== "Doctor" || role== "DOCTOR") {
					doctorview.setVisible(true);
				
				}else if(role == " Nurse"  || role == " NURSE" ) {
					nurseview.setVisible(true);
					
					
				}else if(role == " Patient" || role == " PATIENT") {
					patientview.setVisible(true);
					
				}else if(role == " Relative" || role == " RELATIVE") {
					relativeview.setVisible(true);
					
				}else {
					
				}
				
			}
		});
		btnLogin.setBounds(100, 305, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		btnExit.setBounds(549, 305, 115, 29);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 266, 696, 7);
		frame.getContentPane().add(separator);
		
		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//doctorview.setVisible(true);
			}
		});
		rdbtnDoctor.setBounds(172, 183, 89, 29);
		frame.getContentPane().add(rdbtnDoctor);
		
		JRadioButton rdbtnNurse = new JRadioButton("Nurse");
		rdbtnNurse.setBounds(268, 183, 84, 29);
		frame.getContentPane().add(rdbtnNurse);
		
		JRadioButton rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setBounds(359, 183, 95, 29);
		frame.getContentPane().add(rdbtnPatient);
		
		JRadioButton rdbtnRelative = new JRadioButton("Relative");
		rdbtnRelative.setBounds(454, 183, 155, 29);
		frame.getContentPane().add(rdbtnRelative);
		
		JLabel lblEnterYourRole = new JLabel("Enter your role");
		lblEnterYourRole.setBounds(182, 230, 134, 20);
		frame.getContentPane().add(lblEnterYourRole);
		
		txtRole = new JTextField();
		txtRole.setColumns(10);
		txtRole.setBounds(308, 224, 146, 31);
		frame.getContentPane().add(txtRole);
	}
}
