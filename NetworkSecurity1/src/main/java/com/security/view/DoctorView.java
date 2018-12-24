package com.security.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class DoctorView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorView window = new DoctorView();
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
	public DoctorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 923, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdd_patient = new JButton("ADD");
		btnAdd_patient.setBounds(42, 69, 115, 29);
		frame.getContentPane().add(btnAdd_patient);
		
		JLabel lblAddPatient = new JLabel("Add Patient");
		lblAddPatient.setBounds(49, 33, 108, 20);
		frame.getContentPane().add(lblAddPatient);
		
		JButton btnAdd_nurse = new JButton("ADD");
		btnAdd_nurse.setBounds(42, 198, 115, 29);
		frame.getContentPane().add(btnAdd_nurse);
		
		JLabel lblAddNurse = new JLabel("Add Nurse");
		lblAddNurse.setBounds(49, 145, 98, 20);
		frame.getContentPane().add(lblAddNurse);
		
		JList PatientList = new JList();
		PatientList.setBounds(644, 26, 221, 277);
		
		
		JScrollPane scrollPanePatient = new JScrollPane();
		scrollPanePatient.setBounds(644, 26, 222, 277);
		frame.getContentPane().add(scrollPanePatient);
		
		scrollPanePatient.setViewportView(PatientList);
		
		JList NurseList = new JList();
		NurseList.setBounds(337, 32, 220, 275);
		
		
		JScrollPane scrollPaneNurse = new JScrollPane();
		scrollPaneNurse.setBounds(348, 26, 222, 277);
		frame.getContentPane().add(scrollPaneNurse);
		
		scrollPaneNurse.setViewportView(NurseList);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(751, 341, 115, 29);
		frame.getContentPane().add(btnExit);
	}
}
