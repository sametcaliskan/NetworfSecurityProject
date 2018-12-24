package com.security.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NurseView {

	private JFrame frame;
	private JTextField textNurseSurname;
	private JTextField textNurseName;
	private JTextField textNurseDoctor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseView window = new NurseView();
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
	public NurseView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 943, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList listForPatients = new JList();
		listForPatients.setBounds(516, 31, 367, 324);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(516, 29, 367, 326);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(listForPatients);
		
		JLabel lblNurseName = new JLabel("Name");
		lblNurseName.setBounds(15, 50, 118, 20);
		frame.getContentPane().add(lblNurseName);
		
		JLabel lblNurseSurname = new JLabel("Surname");
		lblNurseSurname.setBounds(15, 93, 105, 20);
		frame.getContentPane().add(lblNurseSurname);
		
		textNurseSurname = new JTextField();
		textNurseSurname.setColumns(10);
		textNurseSurname.setBounds(119, 90, 146, 26);
		frame.getContentPane().add(textNurseSurname);
		
		textNurseName = new JTextField();
		textNurseName.setColumns(10);
		textNurseName.setBounds(119, 47, 146, 26);
		frame.getContentPane().add(textNurseName);
		
		JLabel lblPatientList = new JLabel("Patient List");
		lblPatientList.setBounds(530, 0, 146, 26);
		frame.getContentPane().add(lblPatientList);
		
		JLabel lblNursesDoctor = new JLabel(" Doctor");
		lblNursesDoctor.setBounds(15, 133, 105, 20);
		frame.getContentPane().add(lblNursesDoctor);
		
		textNurseDoctor = new JTextField();
		textNurseDoctor.setColumns(10);
		textNurseDoctor.setBounds(119, 130, 146, 26);
		frame.getContentPane().add(textNurseDoctor);
	}

}
