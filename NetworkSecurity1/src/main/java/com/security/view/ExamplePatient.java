package com.security.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.security.model.Patient;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class ExamplePatient extends JFrame {
	private Patient patient;
	private JPanel contentPane;
	private JTable doctorTable;
	private JTable nurseTable;
	private JTable relativeTable;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamplePatient frame = new ExamplePatient();
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
	public ExamplePatient(Patient patient) {
		this.patient=patient;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(440, 49, 353, 97);
		contentPane.add(scrollPane);
		
		doctorTable = new JTable();
		scrollPane.setViewportView(doctorTable);
	
		DefaultTableModel doctorModel=new DefaultTableModel();
		doctorModel.addColumn("Id");
		doctorModel.addColumn("name");
		doctorModel.addColumn("surname");
		doctorTable.setModel(doctorModel);
		
		JLabel lblDoctorList = new JLabel("Doctor List:");
		lblDoctorList.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDoctorList.setBounds(348, 50, 82, 14);
		contentPane.add(lblDoctorList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(440, 175, 353, 97);
		contentPane.add(scrollPane_1);
		
		nurseTable = new JTable();
		scrollPane_1.setViewportView(nurseTable);
		DefaultTableModel nurseModel=new DefaultTableModel();
		nurseModel.addColumn("Id");
		nurseModel.addColumn("name");
		nurseModel.addColumn("surname");
		
		nurseTable.setModel(nurseModel);
		
		JLabel lblNurseList = new JLabel("Nurse List:");
		lblNurseList.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNurseList.setBounds(352, 176, 78, 14);
		contentPane.add(lblNurseList);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(440, 314, 353, 97);
		contentPane.add(scrollPane_2);
		
		relativeTable = new JTable();
		scrollPane_2.setViewportView(relativeTable);
		DefaultTableModel relativeModel=new DefaultTableModel();
		nurseModel.addColumn("Id");
		nurseModel.addColumn("name");
		nurseModel.addColumn("surname");
		relativeTable.setModel(relativeModel);
		
		JLabel lblDiases = new JLabel("Relative:");
		lblDiases.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDiases.setBounds(352, 314, 78, 14);
		contentPane.add(lblDiases);
		
		JButton btnAddRelative = new JButton("Add");
		btnAddRelative.setBounds(352, 339, 68, 23);
		contentPane.add(btnAddRelative);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(352, 373, 68, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblyourProfil = new JLabel("----Your Profil----");
		lblyourProfil.setFont(new Font("Calibri", Font.BOLD, 18));
		lblyourProfil.setBounds(10, 11, 138, 14);
		contentPane.add(lblyourProfil);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblId.setBounds(10, 49, 115, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblName.setBounds(10, 90, 68, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSurname.setBounds(10, 131, 88, 14);
		contentPane.add(lblSurname);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBirthday.setBounds(10, 175, 68, 23);
		contentPane.add(lblBirthday);
		
		textField = new JTextField();
		textField.setBounds(95, 47, 242, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 88, 243, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 129, 243, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(95, 173, 243, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDiagnostic = new JLabel("Diagnostic:");
		lblDiagnostic.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDiagnostic.setBounds(10, 216, 88, 23);
		contentPane.add(lblDiagnostic);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 218, 243, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
	}

	public void run() {
		
		
	}
}
