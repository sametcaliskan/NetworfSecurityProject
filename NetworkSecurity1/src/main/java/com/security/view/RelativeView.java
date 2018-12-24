package com.security.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class RelativeView {

	private JFrame frame;
	private JTextField textRelativeName;
	private JTextField textRelativeSurname;
	private JTextField textPatientSurname;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelativeView window = new RelativeView();
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
	public RelativeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 942, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRelativeName = new JLabel("Name");
		lblRelativeName.setBounds(28, 56, 69, 20);
		frame.getContentPane().add(lblRelativeName);
		
		textRelativeName = new JTextField();
		textRelativeName.setColumns(10);
		textRelativeName.setBounds(83, 53, 146, 26);
		frame.getContentPane().add(textRelativeName);
		
		JLabel lblRelativeSurname = new JLabel("Surname");
		lblRelativeSurname.setBounds(15, 99, 69, 20);
		frame.getContentPane().add(lblRelativeSurname);
		
		textRelativeSurname = new JTextField();
		textRelativeSurname.setColumns(10);
		textRelativeSurname.setBounds(83, 96, 146, 26);
		frame.getContentPane().add(textRelativeSurname);
		
		JLabel lblPatientDoctor = new JLabel("Patient's Doctors\r\n");
		lblPatientDoctor.setBounds(355, 154, 120, 20);
		frame.getContentPane().add(lblPatientDoctor);
		
		JList listPatientDoctor = new JList();
		listPatientDoctor.setBounds(513, 153, 146, 26);
		frame.getContentPane().add(listPatientDoctor);
		
		JLabel lblPatientNurses = new JLabel("Patient's Nurses");
		lblPatientNurses.setBounds(355, 208, 120, 20);
		frame.getContentPane().add(lblPatientNurses);
		
		JList listPatientNurses = new JList();
		listPatientNurses.setBounds(513, 207, 146, 26);
		frame.getContentPane().add(listPatientNurses);
		
		textPatientSurname = new JTextField();
		textPatientSurname.setColumns(10);
		textPatientSurname.setBounds(513, 96, 146, 26);
		frame.getContentPane().add(textPatientSurname);
		
		JLabel lblPatientsSurname = new JLabel("Patient's Surname");
		lblPatientsSurname.setBounds(355, 99, 146, 20);
		frame.getContentPane().add(lblPatientsSurname);
		
		JLabel lblPatientsName = new JLabel("Patient's Name");
		lblPatientsName.setBounds(355, 53, 159, 20);
		frame.getContentPane().add(lblPatientsName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(513, 53, 146, 26);
		frame.getContentPane().add(textField_3);
	}

}
