package com.security.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class PatientView {

	private JFrame frame;
	private JTextField textPatientName;
	private JTextField textPatientSurname;
	private JTextField textPatientBirthdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientView window = new PatientView();
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
	public PatientView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 934, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(28, 35, 69, 20);
		frame.getContentPane().add(lblName);
		
		textPatientName = new JTextField();
		textPatientName.setBounds(83, 32, 146, 26);
		frame.getContentPane().add(textPatientName);
		textPatientName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(15, 78, 69, 20);
		frame.getContentPane().add(lblSurname);
		
		textPatientSurname = new JTextField();
		textPatientSurname.setBounds(83, 75, 146, 26);
		frame.getContentPane().add(textPatientSurname);
		textPatientSurname.setColumns(10);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setBounds(15, 128, 69, 20);
		frame.getContentPane().add(lblBirthdate);
		
		textPatientBirthdate = new JTextField();
		textPatientBirthdate.setBounds(83, 125, 146, 26);
		frame.getContentPane().add(textPatientBirthdate);
		textPatientBirthdate.setColumns(10);
		
		JLabel lblDiseases = new JLabel("Diseases");
		lblDiseases.setBounds(15, 177, 69, 20);
		frame.getContentPane().add(lblDiseases);
		
		JList listDiseases = new JList();
		listDiseases.setBounds(83, 167, 145, 32);
		frame.getContentPane().add(listDiseases);
		
		JLabel lblPatientsDoctot = new JLabel("Patient's Doctors\r\n");
		lblPatientsDoctot.setBounds(432, 35, 120, 20);
		frame.getContentPane().add(lblPatientsDoctot);
		
		JList listPatientDoctors = new JList();
		listPatientDoctors.setBounds(580, 34, 146, 26);
		frame.getContentPane().add(listPatientDoctors);
		
		JLabel lblPatientsNurses = new JLabel("Patient's Nurses");
		lblPatientsNurses.setBounds(432, 102, 120, 20);
		frame.getContentPane().add(lblPatientsNurses);
		
		JList listPatientNurses = new JList();
		listPatientNurses.setBounds(580, 101, 146, 26);
		frame.getContentPane().add(listPatientNurses);
		
		JLabel lblPatientsRelative = new JLabel("Patient's Relative");
		lblPatientsRelative.setBounds(432, 168, 120, 20);
		frame.getContentPane().add(lblPatientsRelative);
		
		JList listPatientRelative = new JList();
		listPatientRelative.setBounds(580, 176, 146, 26);
		frame.getContentPane().add(listPatientRelative);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(197, 308, 115, 29);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblAddNewRelative = new JLabel("Add new relative");
		lblAddNewRelative.setBounds(47, 312, 146, 20);
		frame.getContentPane().add(lblAddNewRelative);
	}
}
