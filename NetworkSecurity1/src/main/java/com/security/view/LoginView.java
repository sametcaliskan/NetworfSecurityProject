package com.security.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.security.controller.Controller;
import com.security.model.Doctor;
import com.security.model.Patient;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
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
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public LoginView(String title) {
		super();
		setTitle(title);
		securityController=Controller.getController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblWelcome.setBounds(197, 22, 163, 32);
		contentPane.add(lblWelcome);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsername.setBounds(91, 110, 79, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(91, 186, 79, 26);
		contentPane.add(lblPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(69, 331, 388, 14);
		contentPane.add(separator);
		
		rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setBounds(82, 270, 98, 23);
		contentPane.add(rdbtnDoctor);
		
		rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setBounds(180, 270, 90, 23);
		contentPane.add(rdbtnPatient);
		
		rdbtnNurse = new JRadioButton("Nurse");
		rdbtnNurse.setBounds(273, 270, 90, 23);
		contentPane.add(rdbtnNurse);
		
		rdbtnRelative = new JRadioButton("Relative");
		rdbtnRelative.setBounds(365, 270, 109, 23);
		contentPane.add(rdbtnRelative);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButtonAction(e);
			}
		});
		btnLogin.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnLogin.setBounds(91, 385, 89, 26);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnExit.setBounds(316, 385, 89, 26);
		contentPane.add(btnExit);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(184, 107, 152, 26);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(180, 183, 156, 26);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
	}

	private void loginButtonAction(ActionEvent e) {
		try {
			String username=usernameTextField.getText();
			String password=passwordTextField.getText();
			System.out.println(username+password);
			if(rdbtnDoctor.isSelected()) {
				if(securityController.validateLogin(username,password,rdbtnDoctor.getText())) {
					Doctor doctor=securityController.getDoctorByUsername(username);
					DoctorView doctorScreen=new DoctorView(doctor);
					this.setVisible(false);
					doctorScreen.setVisible(true);
				}
			}
			else if(rdbtnPatient.isSelected()) {
				if(/*securityController.validateLogin(username,password,"Patient")*/1==1) {
					//Patient patient=securityController.getPatientByUsername(username);
					System.out.println("here2");
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
		} catch (Exception m) {
			m.printStackTrace();
		}
	}
}
