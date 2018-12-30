package com.security.view;


import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientViewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPatientBirthdate;
	private JTextField txtPatientSurname;
	private JTextField txtPatientName;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientViewFrame frame = new PatientViewFrame();
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
	public PatientViewFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Patient Information");
		label.setBounds(35, 102, 194, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(15, 155, 69, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Surname");
		label_2.setBounds(15, 194, 69, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Birthdate");
		label_3.setBounds(15, 230, 69, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Diseases");
		label_4.setBounds(15, 280, 69, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Add new relative");
		label_5.setBounds(47, 365, 146, 20);
		contentPane.add(label_5);
		
		JButton button = new JButton("ADD");
		button.setBounds(197, 361, 115, 29);
		contentPane.add(button);
		
		ScrollPane pane=new ScrollPane();
		pane.setBounds(84, 279, 146, 59);
		DefaultTableModel listDiseases = new DefaultTableModel();
		
	//	contentPane.add(listDiseases);
		
		txtPatientBirthdate = new JTextField();
		txtPatientBirthdate.setColumns(10);
		txtPatientBirthdate.setBounds(83, 227, 146, 26);
		contentPane.add(txtPatientBirthdate);
		
		txtPatientSurname = new JTextField();
		txtPatientSurname.setColumns(10);
		txtPatientSurname.setBounds(83, 191, 146, 26);
		contentPane.add(txtPatientSurname);
		
		txtPatientName = new JTextField();
		txtPatientName.setColumns(10);
		txtPatientName.setBounds(83, 152, 146, 26);
		contentPane.add(txtPatientName);
		
		JLabel label_6 = new JLabel("Patient's Doctors\r\n");
		label_6.setBounds(432, 102, 120, 20);
		contentPane.add(label_6);
		
		JList listPatientsDoctor = new JList();
		listPatientsDoctor.setBounds(580, 101, 146, 59);
		contentPane.add(listPatientsDoctor);
		
		JLabel label_7 = new JLabel("Patient's Nurses");
		label_7.setBounds(432, 197, 120, 20);
		contentPane.add(label_7);
		
		JList listPatientNurses = new JList();
		listPatientNurses.setBounds(580, 193, 146, 59);
		contentPane.add(listPatientNurses);
		DefaultListModel model = new DefaultListModel();
	//	for(int i=0;i<items.length;i++) {
		//	model.add(i,items[i]);
		//}
		listPatientNurses.setModel(model);
		
		JLabel label_8 = new JLabel("Patient's Relative");
		label_8.setBounds(432, 280, 120, 20);
		contentPane.add(label_8);
		
		JList listPatientRelative = new JList();
		listPatientRelative.setBounds(580, 279, 146, 59);
		contentPane.add(listPatientRelative);
		
		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(755, 384, 115, 29);
		contentPane.add(button_1);
	}

}
