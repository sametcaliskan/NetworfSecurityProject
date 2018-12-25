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

public class DoctorViewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtDoctorName;
	private JTextField txtDoctorSurname;
	private JTextField txtDoctorBirthdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorViewFrame frame = new DoctorViewFrame();
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
	public DoctorViewFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Doctor Information");
		label.setBounds(15, 59, 167, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(15, 117, 69, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Surname");
		label_2.setBounds(15, 160, 69, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Birthdate");
		label_3.setBounds(15, 210, 69, 20);
		contentPane.add(label_3);
		
		txtDoctorName = new JTextField();
		txtDoctorName.setColumns(10);
		txtDoctorName.setBounds(99, 114, 146, 26);
		contentPane.add(txtDoctorName);
		
		txtDoctorSurname = new JTextField();
		txtDoctorSurname.setColumns(10);
		txtDoctorSurname.setBounds(99, 157, 146, 26);
		contentPane.add(txtDoctorSurname);
		
		txtDoctorBirthdate = new JTextField();
		txtDoctorBirthdate.setColumns(10);
		txtDoctorBirthdate.setBounds(99, 207, 146, 26);
		contentPane.add(txtDoctorBirthdate);
		
		JList listNurse = new JList();
		listNurse.setBounds(338, 43, 220, 275);
		contentPane.add(listNurse);
		
		JLabel label_4 = new JLabel("Nurse List");
		label_4.setBounds(389, 16, 125, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Patient List");
		label_5.setBounds(688, 16, 125, 20);
		contentPane.add(label_5);
		
		JList listPatient = new JList();
		listPatient.setBounds(634, 43, 220, 275);
		contentPane.add(listPatient);
		
		JLabel label_6 = new JLabel("Add Nurse");
		label_6.setBounds(347, 347, 98, 20);
		contentPane.add(label_6);
		
		JButton btnAddNurse = new JButton("ADD");
		btnAddNurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNurse addnurse= new AddNurse();
				addnurse.setVisible(true);
				
			}
		});
		btnAddNurse.setBounds(454, 343, 115, 29);
		contentPane.add(btnAddNurse);
		
		JLabel label_7 = new JLabel("Add Patient");
		label_7.setBounds(643, 347, 108, 20);
		contentPane.add(label_7);
		
		JButton btnAddPatient = new JButton("ADD");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPatient addpatient=new AddPatient();
				addpatient.setVisible(true);
			}
		});
		btnAddPatient.setBounds(751, 347, 115, 29);
		contentPane.add(btnAddPatient);
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_2.setBounds(529, 425, 115, 29);
		contentPane.add(button_2);
	}

}
