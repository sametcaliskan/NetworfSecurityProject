package com.security.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NurseViewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNursesDoctor;
	private JTextField txtNurseBirthdate;
	private JTextField txtNurseName;
	private JTextField txtNurseSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseViewFrame frame = new NurseViewFrame();
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
	public NurseViewFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nurse Information");
		label.setBounds(26, 61, 164, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(0, 97, 141, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Surname");
		label_2.setBounds(0, 140, 141, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Birthdate");
		label_3.setBounds(0, 180, 141, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(" Nurse's Doctor");
		label_4.setBounds(0, 222, 141, 20);
		contentPane.add(label_4);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(26, 373, 115, 29);
		contentPane.add(button);
		
		txtNursesDoctor = new JTextField();
		txtNursesDoctor.setColumns(10);
		txtNursesDoctor.setBounds(157, 219, 146, 26);
		contentPane.add(txtNursesDoctor);
		
		txtNurseBirthdate = new JTextField();
		txtNurseBirthdate.setColumns(10);
		txtNurseBirthdate.setBounds(157, 177, 146, 26);
		contentPane.add(txtNurseBirthdate);
		
		txtNurseName = new JTextField();
		txtNurseName.setColumns(10);
		txtNurseName.setBounds(157, 94, 146, 26);
		contentPane.add(txtNurseName);
		
		txtNurseSurname = new JTextField();
		txtNurseSurname.setColumns(10);
		txtNurseSurname.setBounds(157, 137, 146, 26);
		contentPane.add(txtNurseSurname);
		
		JList listPatient = new JList();
		listPatient.setBounds(502, 77, 365, 324);
		contentPane.add(listPatient);
		
		JLabel label_5 = new JLabel("Patient List");
		label_5.setBounds(515, 47, 146, 26);
		contentPane.add(label_5);
	}

}
