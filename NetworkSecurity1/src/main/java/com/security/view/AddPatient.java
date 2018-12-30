package com.security.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPatient extends JFrame {

	private JPanel contentPane;
	private JTextField txtPatientDiseasesDoctor;
	private JTextField txtPatientBirtdateDoctor;
	private JTextField txtPatientSurnameDoctor;
	private JTextField txtPatientNameDoctor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient frame = new AddPatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNewPatient = new JLabel("Add new patient");
		lblAddNewPatient.setBounds(64, 415, 146, 20);
		contentPane.add(lblAddNewPatient);
		
		JButton btnAddPatientDoctor = new JButton("ADD");
		btnAddPatientDoctor.setBounds(250, 411, 115, 29);
		contentPane.add(btnAddPatientDoctor);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(784, 399, 115, 29);
		contentPane.add(btnExit);
		
		txtPatientDiseasesDoctor = new JTextField();
		txtPatientDiseasesDoctor.setColumns(10);
		txtPatientDiseasesDoctor.setBounds(498, 76, 328, 155);
		contentPane.add(txtPatientDiseasesDoctor);
		
		JLabel lblPatienDiseasesDoctor = new JLabel("Diseases");
		lblPatienDiseasesDoctor.setBounds(514, 33, 69, 20);
		contentPane.add(lblPatienDiseasesDoctor);
		
		txtPatientBirtdateDoctor = new JTextField();
		txtPatientBirtdateDoctor.setColumns(10);
		txtPatientBirtdateDoctor.setBounds(132, 169, 146, 26);
		contentPane.add(txtPatientBirtdateDoctor);
		
		JLabel lblPatientBirthdateDoctor = new JLabel("Birthdate");
		lblPatientBirthdateDoctor.setBounds(64, 172, 69, 20);
		contentPane.add(lblPatientBirthdateDoctor);
		
		JLabel lblPatientSurnameDoctor = new JLabel("Surname");
		lblPatientSurnameDoctor.setBounds(64, 122, 69, 20);
		contentPane.add(lblPatientSurnameDoctor);
		
		txtPatientSurnameDoctor = new JTextField();
		txtPatientSurnameDoctor.setColumns(10);
		txtPatientSurnameDoctor.setBounds(132, 119, 146, 26);
		contentPane.add(txtPatientSurnameDoctor);
		
		JLabel lblPatientNameDoctor = new JLabel("Name");
		lblPatientNameDoctor.setBounds(77, 79, 69, 20);
		contentPane.add(lblPatientNameDoctor);
		
		txtPatientNameDoctor = new JTextField();
		txtPatientNameDoctor.setColumns(10);
		txtPatientNameDoctor.setBounds(132, 76, 146, 26);
		contentPane.add(txtPatientNameDoctor);
		
		JLabel lblEnterThePatient = new JLabel("Enter the patient information");
		lblEnterThePatient.setBounds(77, 33, 255, 20);
		contentPane.add(lblEnterThePatient);
	}
}
