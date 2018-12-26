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

public class RelativeViewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtRelativeSurname;
	private JTextField txtRelativeName;
	private JTextField txtPatientsSurname;
	private JTextField txtPatientsName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelativeViewFrame frame = new RelativeViewFrame();
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
	public RelativeViewFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Name");
		label.setBounds(49, 68, 69, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Surname");
		label_1.setBounds(36, 111, 69, 20);
		contentPane.add(label_1);
		
		txtRelativeSurname = new JTextField();
		txtRelativeSurname.setColumns(10);
		txtRelativeSurname.setBounds(104, 108, 179, 26);
		contentPane.add(txtRelativeSurname);
		
		txtRelativeName = new JTextField();
		txtRelativeName.setColumns(10);
		txtRelativeName.setBounds(104, 65, 179, 26);
		contentPane.add(txtRelativeName);
		
		JLabel label_2 = new JLabel("Patient's Name");
		label_2.setBounds(376, 65, 159, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Patient's Surname");
		label_3.setBounds(376, 111, 146, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Patient's Doctors\r\n");
		label_4.setBounds(376, 166, 120, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Patient's Nurses");
		label_5.setBounds(376, 246, 120, 20);
		contentPane.add(label_5);
		
		JList listPatientsNurses = new JList();
		listPatientsNurses.setBounds(534, 245, 179, 48);
		contentPane.add(listPatientsNurses);
		
		JList listPatientsDoctor = new JList();
		listPatientsDoctor.setBounds(534, 165, 179, 48);
		contentPane.add(listPatientsDoctor);
		
		txtPatientsSurname = new JTextField();
		txtPatientsSurname.setColumns(10);
		txtPatientsSurname.setBounds(534, 108, 179, 26);
		contentPane.add(txtPatientsSurname);
		
		txtPatientsName = new JTextField();
		txtPatientsName.setColumns(10);
		txtPatientsName.setBounds(534, 65, 179, 26);
		contentPane.add(txtPatientsName);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(722, 423, 115, 29);
		contentPane.add(btnExit);
	}

}
