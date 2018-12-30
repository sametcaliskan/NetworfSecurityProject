package com.security.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.security.controller.Controller;
import com.security.model.Doctor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorView extends JFrame {

	private JPanel contentPane;
	private Doctor doctor;
	private JTable table;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTable table_1;
	private JTextField birthdayTextField;
	private JTextField diagnosticTextField;
	Controller securityController;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorView frame = new DoctorView();
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
	public DoctorView(Doctor doctor) {
		securityController=Controller.getController();
		this.doctor=doctor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(404, 54, 387, 129);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblPatientTable = new JLabel("Patient Table:");
		lblPatientTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPatientTable.setBounds(405, 18, 99, 25);
		contentPane.add(lblPatientTable);
		
		JLabel lblprofil = new JLabel("----Profil----");
		lblprofil.setFont(new Font("Calibri", Font.BOLD, 18));
		lblprofil.setBounds(287, 11, 107, 23);
		contentPane.add(lblprofil);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblName.setBounds(404, 205, 82, 25);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSurname.setBounds(404, 239, 82, 25);
		contentPane.add(lblSurname);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(484, 206, 284, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setBounds(484, 241, 284, 20);
		contentPane.add(surnameTextField);
		surnameTextField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(7, 54, 387, 129);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNurseTable = new JLabel("Nurse Table:");
		lblNurseTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNurseTable.setBounds(10, 19, 99, 23);
		contentPane.add(lblNurseTable);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblBirthday.setBounds(404, 275, 68, 23);
		contentPane.add(lblBirthday);
		
		JLabel lblDiagnostic = new JLabel("Diagnostic:");
		lblDiagnostic.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDiagnostic.setBounds(404, 309, 82, 21);
		contentPane.add(lblDiagnostic);
		
		birthdayTextField = new JTextField();
		birthdayTextField.setBounds(484, 276, 284, 20);
		contentPane.add(birthdayTextField);
		birthdayTextField.setColumns(10);
		
		diagnosticTextField = new JTextField();
		diagnosticTextField.setBounds(484, 309, 284, 43);
		contentPane.add(diagnosticTextField);
		diagnosticTextField.setColumns(10);
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPatientButtonAction(arg0);
			}

			
		});
		btnAddPatient.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAddPatient.setBounds(484, 371, 107, 23);
		contentPane.add(btnAddPatient);
		
		JButton btnG = new JButton("Give Autherization");
		btnG.setBounds(7, 206, 163, 23);
		contentPane.add(btnG);
	}
	
	private void addPatientButtonAction(ActionEvent arg0) {
		try {
		String name=nameTextField.getText();
		String surname=surnameTextField.getText();
		String birthday=birthdayTextField.getText();
		String diagnostic=diagnosticTextField.getText();
			securityController.addPatient(name,surname,birthday,diagnostic);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void init() {
		
	}

}
