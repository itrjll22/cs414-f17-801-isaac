package edu.colostate.cs.cs414.project.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.colostate.cs.cs414.project.controllers.SecurityController;
import edu.colostate.cs.cs414.project.models.Response;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblPassword;
	private JLabel lblGymManager;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(126, 95, 162, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(154, 208, 117, 25);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
		       public void actionPerformed(ActionEvent ae){
		          
		    	   SecurityController sc = SecurityController.getInstance();
		    	   
		    	   Response response = sc.authenticate(textField.getText(), textField_1.getText());
		    	   
		    	   label.setText(response.StatusText);
		    	   
		       }
		      });
		
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 171, 162, 25);
		frame.getContentPane().add(textField_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(172, 75, 82, 15);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(158, 148, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		lblGymManager = new JLabel("Gym Manager !");
		lblGymManager.setBounds(157, 12, 131, 15);
		frame.getContentPane().add(lblGymManager);
		
		label = new JLabel("", SwingConstants.CENTER);
		label.setBounds(94, 257, 239, 15);
		frame.getContentPane().add(label);
	}
}
