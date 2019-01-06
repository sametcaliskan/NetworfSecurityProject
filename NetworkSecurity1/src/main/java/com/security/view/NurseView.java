package com.security.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.security.controller.Controller;
import com.security.model.Nurse;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class NurseView extends JFrame {

	private JPanel contentPane;
	private JTextField nurseUsernameTextField;
	private JTextField nursesDoctorTextField;
	private JTextField txtNurseName;
	private JTextField txtNurseSurname;
	private JTextField nursePasswordTextField;
	private JTable patientTable;
	private Nurse nurse;
	private Controller securityController;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseView frame = new NurseView();
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
	public NurseView(Nurse nurse) {
		this.nurse=nurse;
		securityController=Controller.getController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nurse Information");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(23, 61, 165, 20);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblName.setBounds(23, 92, 99, 26);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSurname.setBounds(23, 123, 104, 26);
		contentPane.add(lblSurname);
		
		JLabel lblNursesDoctor = new JLabel(" Nurse's Doctor:");
		lblNursesDoctor.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNursesDoctor.setBounds(23, 163, 141, 26);
		contentPane.add(lblNursesDoctor);
		
		JButton button = new JButton("Exit");
		button.setFont(new Font("Calibri", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(758, 419, 99, 26);
		contentPane.add(button);
		
		nurseUsernameTextField = new JTextField();
		nurseUsernameTextField.setColumns(10);
		nurseUsernameTextField.setBounds(136, 198, 146, 26);
		contentPane.add(nurseUsernameTextField);
		nurseUsernameTextField.setText(nurse.getUserName());
		
		nursesDoctorTextField = new JTextField();
		nursesDoctorTextField.setColumns(10);
		nursesDoctorTextField.setBounds(136, 162, 146, 26);
		contentPane.add(nursesDoctorTextField);
		String doctorName=nurse.getDoctor().getFirstName()+" "+nurse.getDoctor().getLastName();
		nursesDoctorTextField.setText(doctorName);
		nursesDoctorTextField.setEditable(false);
		
		txtNurseName = new JTextField();
		txtNurseName.setColumns(10);
		txtNurseName.setBounds(136, 92, 146, 26);
		contentPane.add(txtNurseName);
		txtNurseName.setText(nurse.getFirstName());
		txtNurseName.setEditable(false);
		
		txtNurseSurname = new JTextField();
		txtNurseSurname.setColumns(10);
		txtNurseSurname.setBounds(137, 126, 145, 26);
		contentPane.add(txtNurseSurname);
		txtNurseSurname.setText(nurse.getLastName());
		txtNurseSurname.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 204, 99, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPassword.setBounds(23, 234, 99, 26);
		contentPane.add(lblPassword);
		
		nursePasswordTextField = new JTextField();
		nursePasswordTextField.setBounds(136, 234, 146, 26);
		contentPane.add(nursePasswordTextField);
		nursePasswordTextField.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateButtonAction(arg0);
			}
		});
		btnUpdate.setBounds(23, 296, 99, 26);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 92, 429, 230);
		contentPane.add(scrollPane);
		
		patientTable = new JTable();
		scrollPane.setViewportView(patientTable);
		loadPatientTableData();
		
		JLabel lblPatientTable = new JLabel("Patient Table:");
		lblPatientTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblPatientTable.setBounds(413, 64, 99, 26);
		contentPane.add(lblPatientTable);
		
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
			String newUsername=nurseUsernameTextField.getText();
			String newPassword=nursePasswordTextField.getText();
			int result=JOptionPane.showConfirmDialog(null, "Are you sure?", "confirm",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_OPTION) {
				securityController.updateNurse(nurse.getId(),newUsername,newPassword);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
	}
}

