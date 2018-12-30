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

public class AddRelative extends JFrame {

	private JPanel contentPane;
	private JTextField txtRelativeName;
	private JTextField txtRelativeSurname;
	private JTextField txtRelativeBirthdate;
	private JLabel lblRelativeInformation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRelative frame = new AddRelative();
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
	public AddRelative() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelativeName = new JLabel("Name");
		lblRelativeName.setBounds(283, 189, 69, 20);
		contentPane.add(lblRelativeName);
		
		JLabel lblRelativeSurname = new JLabel("Surname");
		lblRelativeSurname.setBounds(283, 225, 69, 20);
		contentPane.add(lblRelativeSurname);
		
		txtRelativeName = new JTextField();
		txtRelativeName.setColumns(10);
		txtRelativeName.setBounds(385, 186, 146, 26);
		contentPane.add(txtRelativeName);
		
		txtRelativeSurname = new JTextField();
		txtRelativeSurname.setColumns(10);
		txtRelativeSurname.setBounds(385, 222, 146, 26);
		contentPane.add(txtRelativeSurname);
		
		JLabel lblRelativeBirthdate = new JLabel("Birthdate");
		lblRelativeBirthdate.setBounds(283, 273, 69, 20);
		contentPane.add(lblRelativeBirthdate);
		
		txtRelativeBirthdate = new JTextField();
		txtRelativeBirthdate.setColumns(10);
		txtRelativeBirthdate.setBounds(385, 270, 146, 26);
		contentPane.add(txtRelativeBirthdate);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(791, 431, 115, 29);
		contentPane.add(btnNewButton);
		
		lblRelativeInformation = new JLabel("Relative Information");
		lblRelativeInformation.setBounds(346, 117, 146, 20);
		contentPane.add(lblRelativeInformation);
	}

}
