package com.security.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.security.controller.Controller;
import com.security.model.Relative;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RelativeView extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTable doctorTable;
	private JTable nurseTable;
	private Relative relative;
	private Controller securityController;
	private JTextField patientTextField;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelativeView frame = new RelativeView();
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
	public RelativeView(Relative relative) {
		this.relative=relative;
		securityController=Controller.getController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelativeInformation = new JLabel("Relative Information");
		lblRelativeInformation.setFont(new Font("Calibri", Font.BOLD, 16));
		lblRelativeInformation.setBounds(10, 30, 150, 26);
		contentPane.add(lblRelativeInformation);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblName.setBounds(10, 80, 65, 26);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSurname.setBounds(10, 119, 75, 26);
		contentPane.add(lblSurname);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUsername.setBounds(10, 197, 86, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(10, 236, 75, 26);
		contentPane.add(lblPassword);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(91, 83, 163, 26);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setText(relative.getFirstName());
		nameTextField.setEditable(false);
		
		surnameTextField = new JTextField();
		surnameTextField.setBounds(91, 122, 163, 26);
		contentPane.add(surnameTextField);
		surnameTextField.setColumns(10);
		surnameTextField.setText(relative.getLastName());
		surnameTextField.setEditable(false);
		
		usernameTextField = new JTextField();
		usernameTextField.setText("");
		usernameTextField.setBounds(91, 200, 163, 26);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		usernameTextField.setText(relative.getUserName());
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(91, 239, 163, 26);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		passwordTextField.setText(relative.getPassword());
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateButtonAction(arg0);
			}
		});
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnUpdate.setBounds(165, 289, 89, 26);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnExit.setBounds(10, 397, 89, 26);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(419, 83, 361, 140);
		contentPane.add(scrollPane);
		
		doctorTable = new JTable();
		scrollPane.setViewportView(doctorTable);
		loadDoctorTableData();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(419, 245, 366, 140);
		contentPane.add(scrollPane_1);
		
		nurseTable = new JTable();
		scrollPane_1.setViewportView(nurseTable);
		loadNurseTableData();
		
		JLabel lblDoctorTable = new JLabel("Doctor Table:");
		lblDoctorTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDoctorTable.setBounds(309, 86, 100, 26);
		contentPane.add(lblDoctorTable);
		
		JLabel lblNurseTable = new JLabel("Nurse Table:");
		lblNurseTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNurseTable.setBounds(309, 246, 100, 26);
		contentPane.add(lblNurseTable);
		
		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPatient.setBounds(10, 158, 65, 26);
		contentPane.add(lblPatient);
		
		patientTextField = new JTextField();
		patientTextField.setBounds(91, 161, 163, 26);
		contentPane.add(patientTextField);
		patientTextField.setColumns(10);
		String patient=relative.getPatient().getFirstName()+ " "+relative.getPatient().getLastName();
		patientTextField.setText(patient);
		patientTextField.setEditable(false);
	}

	private void loadNurseTableData() {
		DefaultTableModel nurseModel=new DefaultTableModel();
		nurseModel.addColumn("Id");
		nurseModel.addColumn("name");
		nurseModel.addColumn("surname");
		nurseTable.setModel(nurseModel);
	}

	private void loadDoctorTableData() {
		DefaultTableModel doctorModel=new DefaultTableModel();
		doctorModel.addColumn("Id");
		doctorModel.addColumn("name");
		doctorModel.addColumn("surname");
		doctorTable.setModel(doctorModel);
	}
	
	private void updateButtonAction(ActionEvent arg0) {
		try {
			String newUsername=usernameTextField.getText();
			String newPassword=passwordTextField.getText();
			int result=JOptionPane.showConfirmDialog(null, "Are you sure?", "confirm",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_OPTION) {
				securityController.updateRelative(relative.getId(),newUsername,newPassword);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
		
	}
}
