package com.security.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.security.controller.Controller;
import com.security.model.Doctor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DoctorView extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Doctor doctor;
	private JTable patientTable;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTable nurseTable;
	private JTextField birthdayTextField;
	private JTextField diagnosticTextField;
	Controller securityController;
	private Long selectedNurseId;
	private Long selectedPatientId;
	private JTextField doctorUsernameField;
	private JTextField doctorPasswordField;
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
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedPatientId=patientTableMouseClickedAction(arg0);
			}
		});
		scrollPane.setBounds(404, 54, 387, 129);
		contentPane.add(scrollPane);
		
		patientTable = new JTable();
		scrollPane.setViewportView(patientTable);
		loadPatientTableData();
		
		JLabel lblPatientTable = new JLabel("Patient Table:");
		lblPatientTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPatientTable.setBounds(405, 18, 99, 25);
		contentPane.add(lblPatientTable);
		
		JLabel lblprofil = new JLabel("Doctor Information");
		lblprofil.setFont(new Font("Calibri", Font.BOLD, 18));
		lblprofil.setBounds(17, 239, 153, 23);
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
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedNurseId=nurseTableMouseClickedAction(arg0);
			}
		});
		scrollPane_1.setBounds(7, 54, 387, 129);
		contentPane.add(scrollPane_1);
		
		nurseTable = new JTable();
		scrollPane_1.setViewportView(nurseTable);
		loadNurseTableData();
		
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
				loadPatientTableData();
			}

			
		});
		btnAddPatient.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAddPatient.setBounds(484, 371, 107, 26);
		contentPane.add(btnAddPatient);
		
		JButton btnG = new JButton("Give Authorization");
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giveAuthorizationButtonAction(arg0);
			}
		});
		btnG.setBounds(7, 206, 163, 23);
		contentPane.add(btnG);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsername.setBounds(7, 273, 73, 25);
		contentPane.add(lblUsername);
		
		doctorUsernameField = new JTextField();
		doctorUsernameField.setBounds(100, 273, 261, 20);
		contentPane.add(doctorUsernameField);
		doctorUsernameField.setColumns(10);
		doctorUsernameField.setText(doctor.getUserName());
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(7, 318, 73, 25);
		contentPane.add(lblPassword);
		
		doctorPasswordField = new JTextField();
		doctorPasswordField.setBounds(100, 320, 261, 20);
		contentPane.add(doctorPasswordField);
		doctorPasswordField.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateButtonAction(arg0);
			}

			
		});
		btnUpdate.setBounds(7, 371, 89, 26);
		contentPane.add(btnUpdate);
		
		JButton btnUpdateButton = new JButton("Update Patient");
		btnUpdateButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnUpdateButton.setBounds(601, 371, 129, 26);
		contentPane.add(btnUpdateButton);
	}
	
	private void loadNurseTableData() {
		DefaultTableModel nurseModel=new DefaultTableModel();
		nurseModel.addColumn("Id");
		nurseModel.addColumn("name");
		nurseModel.addColumn("surname");
		nurseTable.setModel(nurseModel);	
	}
	private void loadPatientTableData() {
		DefaultTableModel patientModel=new DefaultTableModel();
		patientModel.addColumn("Id");
		patientModel.addColumn("name");
		patientModel.addColumn("surname");
		patientModel.addColumn("birthday");
		patientModel.addColumn("diagnostic");
		patientTable.setModel(patientModel);	
	}
	private void updateButtonAction(ActionEvent arg0) {
		try {
		String newUsername=doctorUsernameField.getText();
		String newPassword=doctorPasswordField.getText();
		int result=JOptionPane.showConfirmDialog(null, "Are you sure?", "confirm",JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION) {
			securityController.updateDoctor(doctor.getId(),newUsername,newPassword);
		}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
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
	private void giveAuthorizationButtonAction(ActionEvent arg0) {
		try {
			securityController.giveAuthorizationToNurse(selectedNurseId, selectedPatientId);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			}
		
	}
	private Long nurseTableMouseClickedAction(MouseEvent arg0) {
			int selectedRow=nurseTable.getSelectedRow();
			Long id=Long.parseLong(nurseTable.getValueAt(selectedRow, 0).toString());
		return id;
	}
	private Long patientTableMouseClickedAction(MouseEvent arg0) {
		int selectedRow=patientTable.getSelectedRow();
		Long id=Long.parseLong(patientTable.getValueAt(selectedRow, 0).toString());
		nameTextField.setText(patientTable.getValueAt(selectedRow, 1).toString());
		surnameTextField.setText(patientTable.getValueAt(selectedRow, 2).toString());
		birthdayTextField.setText(patientTable.getValueAt(selectedRow, 3).toString());
		diagnosticTextField.setText(patientTable.getValueAt(selectedRow, 4).toString());
		return id;
	}
	public void init() {
		
	}
}
