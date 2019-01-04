package com.security.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.type.YesNoType;

import com.security.controller.Controller;
import com.security.model.Doctor;
import com.security.model.Patient;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class PatientView extends JFrame {
	private Patient patient;
	private Controller securityController;
	private JPanel contentPane;
	private JTable doctorTable;
	private JTable nurseTable;
	private JTable relativeTable;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField birthdayTextField;
	private JTextField diagnosticTextField;
	private JTextField patientusernameField;
	private JPasswordField patientPasswordField;
	private JTextField relativeNameTextField;
	private JTextField relativeSurnameTextField;

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
	public PatientView(Patient patient) {
		this.patient=patient;
		this.securityController=Controller.getController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(440, 49, 353, 97);
		contentPane.add(scrollPane);
		
		doctorTable = new JTable();
		scrollPane.setViewportView(doctorTable);
		loadDoctorTableData();
		
		JLabel lblDoctorList = new JLabel("Doctor Table:");
		lblDoctorList.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDoctorList.setBounds(347, 18, 103, 27);
		contentPane.add(lblDoctorList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(440, 175, 353, 97);
		contentPane.add(scrollPane_1);
		
		nurseTable = new JTable();
		scrollPane_1.setViewportView(nurseTable);
		loadNurseTableData();
		
		JLabel lblNurseList = new JLabel("Nurse Table:");
		lblNurseList.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNurseList.setBounds(440, 157, 88, 14);
		contentPane.add(lblNurseList);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(440, 308, 353, 97);
		contentPane.add(scrollPane_2);
		
		relativeTable = new JTable();
		scrollPane_2.setViewportView(relativeTable);
		loadRelativeTableData();
		
		JLabel lblDiases = new JLabel("Relative Table:");
		lblDiases.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDiases.setBounds(438, 283, 109, 19);
		contentPane.add(lblDiases);
		
		JButton btnAddRelative = new JButton("Add Relative");
		btnAddRelative.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnAddRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addRelativeButtonAction(arg0);
			}
		});
		btnAddRelative.setBounds(463, 494, 127, 26);
		contentPane.add(btnAddRelative);
		
		JButton btnNewButton = new JButton("Delete Relative");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteRelativeButtonAction(arg0);
			}
		});
		btnNewButton.setBounds(617, 494, 138, 26);
		contentPane.add(btnNewButton);
		
		JLabel lblyourProfil = new JLabel("----Profil----");
		lblyourProfil.setFont(new Font("Calibri", Font.BOLD, 18));
		lblyourProfil.setBounds(10, 11, 138, 14);
		contentPane.add(lblyourProfil);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblName.setBounds(10, 49, 68, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSurname.setBounds(10, 85, 88, 14);
		contentPane.add(lblSurname);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBirthday.setBounds(10, 123, 68, 23);
		contentPane.add(lblBirthday);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(95, 47, 243, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setText(patient.getFirstName());
		nameTextField.setEditable(false);
		
		
		surnameTextField = new JTextField();
		surnameTextField.setBounds(95, 85, 243, 20);
		contentPane.add(surnameTextField);
		surnameTextField.setColumns(10);
		surnameTextField.setText(patient.getLastName());
		surnameTextField.setEditable(false);
		
		birthdayTextField = new JTextField();
		birthdayTextField.setBounds(95, 125, 243, 20);
		contentPane.add(birthdayTextField);
		birthdayTextField.setColumns(10);
		birthdayTextField.setText(patient.getBirthdate());
		birthdayTextField.setEditable(false);
		
		JLabel lblDiagnostic = new JLabel("Diagnostic:");
		lblDiagnostic.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDiagnostic.setBounds(10, 163, 88, 23);
		contentPane.add(lblDiagnostic);
		
		diagnosticTextField = new JTextField();
		diagnosticTextField.setBounds(95, 161, 243, 54);
		contentPane.add(diagnosticTextField);
		diagnosticTextField.setColumns(10);
		diagnosticTextField.setText(patient.getDiagnostic());
		diagnosticTextField.setEditable(false);
		
		JButton btnAllDoctors = new JButton("All Doctors");
		btnAllDoctors.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAllDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allDoctorsButtonAction(arg0);
			}
		});
		btnAllDoctors.setBounds(440, 20, 89, 26);
		contentPane.add(btnAllDoctors);
		
		JButton btnYourDoctors = new JButton("Your Doctors");
		btnYourDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yourDoctorsButtonAction(e);
			}
		});
		btnYourDoctors.setBounds(539, 20, 103, 26);
		contentPane.add(btnYourDoctors);
		
		JButton btnGiveAuthorization = new JButton("Give Authorization");
		btnGiveAuthorization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giveAuthorizationToDoctorButton(e);
			}
		});
		btnGiveAuthorization.setBounds(652, 20, 141, 26);
		contentPane.add(btnGiveAuthorization);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsername.setBounds(10, 254, 82, 18);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(10, 291, 68, 17);
		contentPane.add(lblPassword);
		
		patientusernameField = new JTextField();
		patientusernameField.setBounds(95, 252, 115, 20);
		contentPane.add(patientusernameField);
		patientusernameField.setColumns(10);
		patientusernameField.setText(patient.getUserName());
		
		patientPasswordField = new JPasswordField();
		patientPasswordField.setBounds(95, 288, 115, 20);
		contentPane.add(patientPasswordField);
		patientPasswordField.setText("**");
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnUpdate.setBounds(10, 343, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblName_1.setBounds(440, 427, 46, 26);
		contentPane.add(lblName_1);
		
		relativeNameTextField = new JTextField();
		relativeNameTextField.setBounds(505, 424, 166, 26);
		contentPane.add(relativeNameTextField);
		relativeNameTextField.setColumns(10);
		
		JLabel lblSurname_1 = new JLabel("Surname:");
		lblSurname_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSurname_1.setBounds(440, 458, 68, 26);
		contentPane.add(lblSurname_1);
		
		relativeSurnameTextField = new JTextField();
		relativeSurnameTextField.setBounds(506, 461, 165, 26);
		contentPane.add(relativeSurnameTextField);
		relativeSurnameTextField.setColumns(10);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnExit.setBounds(9, 496, 89, 26);
		contentPane.add(btnExit);
		
	}

	private void loadNurseTableData() {
		DefaultTableModel nurseModel=new DefaultTableModel();
		nurseModel.addColumn("Id");
		nurseModel.addColumn("name");
		nurseModel.addColumn("surname");
		nurseTable.setModel(nurseModel);
		
	}

	private void loadRelativeTableData() {
		DefaultTableModel relativeModel=new DefaultTableModel();
		relativeModel.addColumn("Id");
		relativeModel.addColumn("name");
		relativeModel.addColumn("surname");
		relativeTable.setModel(relativeModel);
		
	}

	private void loadDoctorTableData() {
		DefaultTableModel doctorModel=new DefaultTableModel();
		doctorModel.addColumn("Id");
		doctorModel.addColumn("name");
		doctorModel.addColumn("surname");
		try {
			for(Doctor doctor:securityController.getPatientDoctors(patient.getId()) ) {
				doctorModel.addRow(new Object[] {
						doctor.getId(),
						doctor.getFirstName(),
						doctor.getLastName()
				});
			}
			doctorTable.setModel(doctorModel);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	

	private void allDoctorsButtonAction(ActionEvent arg0) {
		DefaultTableModel doctorModel=new DefaultTableModel();
		doctorModel.addColumn("Id");
		doctorModel.addColumn("name");
		doctorModel.addColumn("surname");
		
		for(Doctor doctor:securityController.getAllDoctors()) {
			doctorModel.addRow(new Object[] {
					doctor.getId(),
					doctor.getFirstName(),
					doctor.getLastName()
			});
		}
		doctorTable.setModel(doctorModel);
	}

	private void yourDoctorsButtonAction(ActionEvent e) {
		loadDoctorTableData();
	}

	private void giveAuthorizationToDoctorButton(ActionEvent e) {
		try {
		int result=JOptionPane.showConfirmDialog(null, "Are u sure?", "Confirm",JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION) {
		int selectedRow=doctorTable.getSelectedRow();
		Long doctorId=Long.parseLong(doctorTable.getValueAt(selectedRow, 0).toString());
		securityController.giveAuthorizationToDoctor(doctorId, patient.getId());
		}
		}catch (Exception m) {
			JOptionPane.showMessageDialog(null, m.getMessage());
		}
		}

	private void addRelativeButtonAction(ActionEvent arg0) {
		try {
			String name=relativeNameTextField.getText();
			String surname=relativeSurnameTextField.getText();
			if(patient.getRelative()==null) {
				securityController.addRelative(name,surname,patient.getId());
			}
			else {
				JOptionPane.showMessageDialog(null, "You already have a relative.Before you add new relative, delete the relative.");
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void deleteRelativeButtonAction(ActionEvent arg0) {
		try {
			int selectedRow=relativeTable.getSelectedRow();
			Long id=Long.parseLong(relativeTable.getValueAt(selectedRow, 0).toString());
			securityController.deleteRelative(id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	public void run() {
		
		
	}
}
