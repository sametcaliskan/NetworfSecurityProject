package com.security.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNurse extends JFrame {

	private JPanel contentPane;
	private JTextField txtNursesBirthdate;
	private JTextField txtNursesSurname;
	private JTextField txtNursesName;
	private JTextField txtPatientsName;
	private JTextField txtPatientSurname;
	private JTextField txtPatientBirthdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNurse frame = new AddNurse();
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
	public AddNurse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNursesName = new JLabel("Nurse's Name");
		lblNursesName.setBounds(43, 64, 141, 20);
		contentPane.add(lblNursesName);
		
		JLabel lblNursesSurname = new JLabel("Nurse's Surname");
		lblNursesSurname.setBounds(43, 107, 141, 20);
		contentPane.add(lblNursesSurname);
		
		JLabel lblNursesBirthdate = new JLabel("Nurse's Birthdate");
		lblNursesBirthdate.setBounds(43, 157, 141, 20);
		contentPane.add(lblNursesBirthdate);
		
		txtNursesBirthdate = new JTextField();
		txtNursesBirthdate.setColumns(10);
		txtNursesBirthdate.setBounds(209, 154, 146, 26);
		contentPane.add(txtNursesBirthdate);
		
		txtNursesSurname = new JTextField();
		txtNursesSurname.setColumns(10);
		txtNursesSurname.setBounds(209, 104, 146, 26);
		contentPane.add(txtNursesSurname);
		
		txtNursesName = new JTextField();
		txtNursesName.setColumns(10);
		txtNursesName.setBounds(209, 61, 146, 26);
		contentPane.add(txtNursesName);
		
		JLabel lblPatientsName = new JLabel("Patient's Name");
		lblPatientsName.setBounds(548, 61, 141, 20);
		contentPane.add(lblPatientsName);
		
		txtPatientsName = new JTextField();
		txtPatientsName.setColumns(10);
		txtPatientsName.setBounds(714, 58, 146, 26);
		contentPane.add(txtPatientsName);
		
		JLabel lblPatientsSurname = new JLabel("Patient's Surname");
		lblPatientsSurname.setBounds(548, 104, 141, 20);
		contentPane.add(lblPatientsSurname);
		
		txtPatientSurname = new JTextField();
		txtPatientSurname.setColumns(10);
		txtPatientSurname.setBounds(714, 101, 146, 26);
		contentPane.add(txtPatientSurname);
		
		JLabel lblPatientsBirthdate = new JLabel("Patient's Birthdate");
		lblPatientsBirthdate.setBounds(548, 154, 141, 20);
		contentPane.add(lblPatientsBirthdate);
		
		txtPatientBirthdate = new JTextField();
		txtPatientBirthdate.setColumns(10);
		txtPatientBirthdate.setBounds(714, 151, 146, 26);
		contentPane.add(txtPatientBirthdate);
		
		JButton btnAuthorized = new JButton("Authorized");
		btnAuthorized.setBounds(87, 376, 115, 29);
		contentPane.add(btnAuthorized);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(759, 376, 115, 29);
		contentPane.add(btnExit);
		
		JLabel lblEnterTheNurse = new JLabel("Enter the nurse information");
		lblEnterTheNurse.setBounds(43, 16, 243, 20);
		contentPane.add(lblEnterTheNurse);
	}

}
