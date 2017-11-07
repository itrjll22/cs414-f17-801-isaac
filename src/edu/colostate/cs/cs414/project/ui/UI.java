package edu.colostate.cs.cs414.project.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import edu.colostate.cs.cs414.project.controllers.SecurityController;
import edu.colostate.cs.cs414.project.controllers.UserController;
import edu.colostate.cs.cs414.project.models.Enum_Role;
import edu.colostate.cs.cs414.project.models.Response;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserSecurityContext;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;

public class UI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblPassword;
	private JLabel lblGymManager;
	private JPanel panelLogin;
	private JPanel panelManagerDashboard;
	private final JLabel lblWelcomeManager = new JLabel("Welcome Manager");
	private JPanel panelTrainerDashboard;
	private JLabel lblWelcomeTrainer;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnModifyEquipmentInventory;
	private JPanel panelHireTrainer;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblAddress;
	private JTextField textField_4;
	private JLabel lblAddress_1;
	private JTextField textField_5;
	private JLabel lblAddress_2;
	private JTextField textField_6;
	private JLabel lblState;
	private JTextField textField_7;
	private JLabel lblPhone;
	private JTextField textField_8;
	private JLabel lblZip;
	private JTextField textField_9;
	private JLabel lblEmail;
	private JTextField textField_10;
	private JLabel lblId_1;
	private JTextField textField_11;
	private JLabel lblWorkHours;
	private JTextField textField_12;
	private JLabel lblId;
	private JTextField textField_13;
	private JLabel lblQualifications;
	private JTextField textField_15;
	private JButton btnCreate;
	private JLabel lblUsername_1;
	private JTextField textField_14;
	private JTextField textField_16;
	private JLabel lblPassword_1;
	private JLabel lblNewLabel_1;

	//ArrayList<JPanel> panels = new ArrayList<JPanel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//panels.add(panelLogin);
				
				
				try {
					UI window = new UI();
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
	public UI() {
		initialize();
	}

	static void hideAllPanels(){
		
	}
	
	static void setComponentVisibility(JFrame container,
	        Class<? extends Component> componentClass, boolean visible) {
	    for (Component c : container.getContentPane().getComponents()) {
	        if (componentClass.isAssignableFrom(c.getClass())) {
	            c.setVisible(visible);
	        } 
	    }
	}
	
	static void clearAllTextBoxes(JFrame container) {
	    for (Component c : container.getContentPane().getComponents()) {
	    	if (c instanceof JTextField)
            {
                JTextField j = (JTextField)c;
                j.setText("");
            }
	    	
	    	else if (c instanceof JPasswordField)
            {
	    		JPasswordField j = (JPasswordField)c;
                j.setText("");
            }
	    }
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "name_2065430093159");
		panelLogin.setLayout(null);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setBounds(176, 159, 82, 25);
		panelLogin.add(btnNewButton);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(134, 128, 217, 19);
		panelLogin.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(55, 72, 72, 15);
		panelLogin.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(134, 70, 217, 19);
		panelLogin.add(textField);
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(55, 130, 70, 15);
		panelLogin.add(lblPassword);
		
		lblGymManager = new JLabel("Gym Manager !");
		lblGymManager.setBounds(152, 27, 106, 15);
		panelLogin.add(lblGymManager);
		
		final JLabel label = new JLabel("");
		label.setBounds(92, 220, 283, 15);
		panelLogin.add(label);
		
		panelManagerDashboard = new JPanel();
		frame.getContentPane().add(panelManagerDashboard, "name_2565995603501");
		panelManagerDashboard.setLayout(null);
		lblWelcomeManager.setBounds(179, 12, 131, 15);
		panelManagerDashboard.add(lblWelcomeManager);
		
		JButton btnHireTrainer = new JButton("Hire Trainer");
		btnHireTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				setComponentVisibility(frame, JPanel.class, false);
				
				panelHireTrainer.setVisible(true);
				
				
			}
		});
		btnHireTrainer.setBounds(141, 56, 199, 25);
		panelManagerDashboard.add(btnHireTrainer);
		
		JButton btnNewButton_1 = new JButton("Register Customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			}
		});
		btnNewButton_1.setBounds(141, 150, 199, 25);
		panelManagerDashboard.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Modify Trainer");
		btnNewButton_2.setBounds(141, 93, 199, 25);
		panelManagerDashboard.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Modify Customer");
		btnNewButton_3.setBounds(141, 189, 199, 25);
		panelManagerDashboard.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("New Equipment Inventory");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(141, 249, 261, 25);
		panelManagerDashboard.add(btnNewButton_4);
		
		btnModifyEquipmentInventory = new JButton("Modify Equipment Inventory");
		btnModifyEquipmentInventory.setBounds(141, 290, 261, 25);
		panelManagerDashboard.add(btnModifyEquipmentInventory);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(66, 361, 392, 15);
		panelManagerDashboard.add(lblNewLabel_1);
		
		panelTrainerDashboard = new JPanel();
		frame.getContentPane().add(panelTrainerDashboard, "name_3189310019527");
		panelTrainerDashboard.setLayout(null);
		
		lblWelcomeTrainer = new JLabel("Welcome Trainer");
		lblWelcomeTrainer.setBounds(155, 40, 146, 15);
		panelTrainerDashboard.add(lblWelcomeTrainer);
		
		panelHireTrainer = new JPanel();
		frame.getContentPane().add(panelHireTrainer, "name_3228290166164");
		panelHireTrainer.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 35, 256, 19);
		panelHireTrainer.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(76, 37, 103, 15);
		panelHireTrainer.add(lblFirstName);
		
		JLabel lblHireTrainer = new JLabel("Hire Trainer");
		lblHireTrainer.setBounds(190, 12, 131, 15);
		panelHireTrainer.add(lblHireTrainer);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(76, 68, 103, 15);
		panelHireTrainer.add(lblLastName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(187, 66, 256, 19);
		panelHireTrainer.add(textField_3);
		
		lblAddress = new JLabel("Address 1:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(76, 99, 103, 15);
		panelHireTrainer.add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(187, 97, 256, 19);
		panelHireTrainer.add(textField_4);
		
		lblAddress_1 = new JLabel("City:");
		lblAddress_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress_1.setBounds(76, 157, 103, 15);
		panelHireTrainer.add(lblAddress_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(187, 155, 256, 19);
		panelHireTrainer.add(textField_5);
		
		lblAddress_2 = new JLabel("Address 2:");
		lblAddress_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress_2.setBounds(76, 128, 103, 15);
		panelHireTrainer.add(lblAddress_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(187, 126, 256, 19);
		panelHireTrainer.add(textField_6);
		
		lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setBounds(76, 186, 103, 15);
		panelHireTrainer.add(lblState);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(187, 184, 256, 19);
		panelHireTrainer.add(textField_7);
		
		lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(76, 251, 103, 15);
		panelHireTrainer.add(lblPhone);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(187, 249, 256, 19);
		panelHireTrainer.add(textField_8);
		
		lblZip = new JLabel("Zip:");
		lblZip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZip.setBounds(76, 215, 103, 15);
		panelHireTrainer.add(lblZip);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(187, 213, 256, 19);
		panelHireTrainer.add(textField_9);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(76, 280, 103, 15);
		panelHireTrainer.add(lblEmail);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(187, 278, 256, 19);
		panelHireTrainer.add(textField_10);
		
		lblId_1 = new JLabel("ID:");
		lblId_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_1.setBounds(76, 308, 103, 15);
		panelHireTrainer.add(lblId_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(187, 306, 256, 19);
		panelHireTrainer.add(textField_11);
		
		lblWorkHours = new JLabel("Work Hours:");
		lblWorkHours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWorkHours.setBounds(12, 361, 167, 15);
		panelHireTrainer.add(lblWorkHours);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(187, 359, 256, 19);
		panelHireTrainer.add(textField_12);
		
		lblId = new JLabel("Health Ins. Provider:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(12, 332, 167, 15);
		panelHireTrainer.add(lblId);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(187, 330, 256, 19);
		panelHireTrainer.add(textField_13);
		
		lblQualifications = new JLabel("Qualifications:");
		lblQualifications.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQualifications.setBounds(76, 390, 103, 15);
		panelHireTrainer.add(lblQualifications);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(187, 388, 256, 19);
		panelHireTrainer.add(textField_15);
		
		lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername_1.setBounds(12, 437, 167, 15);
		panelHireTrainer.add(lblUsername_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(187, 435, 256, 19);
		panelHireTrainer.add(textField_14);
		
		textField_16 = new JPasswordField();
		textField_16.setColumns(10);
		textField_16.setBounds(187, 464, 256, 19);
		panelHireTrainer.add(textField_16);
		
		lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1.setBounds(76, 466, 103, 15);
		panelHireTrainer.add(lblPassword_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 556, 333, 15);
		panelHireTrainer.add(lblNewLabel);
		
		btnCreate = new JButton("Hire");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Response response = UserController.getInstance()
						.hireTrainer(new Trainer(textField_2.getText(),
								textField_3.getText(),
								textField_4.getText(),
								textField_6.getText(),
								textField_5.getText(),
								textField_7.getText(),
								textField_9.getText(),
								textField_8.getText(),
								textField_10.getText(),
								textField_11.getText(),
								textField_13.getText(),
								textField_12.getText(),
								textField_15.getText(),
								textField_14.getText(),
								textField_16.getText()
								));
				
				if(response.isSuccess)
				{
					clearAllTextBoxes(frame);
					
					lblNewLabel_1.setText(response.StatusText);
					
					final Timer timer = new Timer(1000, null);
			        timer.addActionListener((al) -> {
			            
			        	setComponentVisibility(frame, JPanel.class, false);
			        	
			        	panelManagerDashboard.setVisible(true);
			        	
			        	timer.stop();
			        	
			        });
			        timer.start();
				}else{
					lblNewLabel.setText(response.StatusText);
				}
				
			}
		});
		btnCreate.setBounds(187, 519, 117, 25);
		panelHireTrainer.add(btnCreate);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
		       public void actionPerformed(ActionEvent ae){
		          
		    	   SecurityController sc = SecurityController.getInstance();
		    	   
		    	   Response response = sc.authenticate(textField.getText(), textField_1.getText());
		    	   
		    	   label.setText(response.StatusText);
		    	   
		    	   setComponentVisibility(frame, JPanel.class, false);
		    	   
		    	   if(response.isSuccess){
		    		   
		    		   UserSecurityContext usc = (UserSecurityContext) response.data;
		    		   
		    		   
		    		   
		    		   if(usc.hasRole(Enum_Role.Manager)){
		    			   panelManagerDashboard.setVisible(true);
		    		   }else if(usc.hasRole(Enum_Role.Trainer)){
		    			   panelTrainerDashboard.setVisible(true);
		    		   }else{
		    			   panelLogin.setVisible(false);
		    		   }
		    		   
		    	   }
		    	   
		    	   
		       }
		      });
	}
}
