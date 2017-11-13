package edu.colostate.cs.cs414.project.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.colostate.cs.cs414.project.controllers.SecurityController;
import edu.colostate.cs.cs414.project.controllers.SystemGeneralController;
import edu.colostate.cs.cs414.project.controllers.UserController;
import edu.colostate.cs.cs414.project.controllers.WorkoutController;
import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.Enum_Role;
import edu.colostate.cs.cs414.project.models.EquipmentItem;
import edu.colostate.cs.cs414.project.models.Exercise;
import edu.colostate.cs.cs414.project.models.ExerciseSet;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Response;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserSecurityContext;
import edu.colostate.cs.cs414.project.models.WorkoutRoutine;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextArea;

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
	private JLabel lblQualifications;
	private JTextField textField_15;
	private JButton btnCreate;
	private JLabel lblUsername_1;
	private JTextField textField_14;
	private JTextField textField_16;
	private JLabel lblPassword_1;
	private JLabel lblNewLabel_1;
	private JPanel panelRegisterCustomer;
	private JTextField textField_17;
	private JLabel label_1;
	private JLabel lblRegisterCustomer;
	private JLabel label_3;
	private JTextField textField_18;
	private JLabel label_4;
	private JTextField textField_19;
	private JLabel label_5;
	private JTextField textField_20;
	private JLabel label_6;
	private JTextField textField_21;
	private JLabel label_7;
	private JTextField textField_22;
	private JLabel label_8;
	private JTextField textField_23;
	private JLabel label_9;
	private JTextField textField_24;
	private JLabel label_10;
	private JTextField textField_25;
	private JLabel label_11;
	private JTextField textField_26;
	private JLabel label_13;
	private JLabel label_15;
	private JTextField textField_28;
	private JPasswordField passwordField;
	private JLabel label_16;
	private JLabel lbl_HireCustomerStatus;
	private JButton button;
	private JTextField textField_27;
	private JLabel label_2;
	private JLabel label_12;
	private JScrollPane scrollPane_1;
	private JSeparator separator_2;
	private JTextField textField_13;
	private JLabel lblAddNew_1;
	private JLabel lblOr_1;
	private JPanel panelEquipmentInventory;
	private JTextField textField_29;
	private JLabel lblName;
	private JLabel lblEquipmentInventory;
	private JLabel lblQuantity;
	private JTextField textField_30;
	private JLabel lbl_picture;

	//ArrayList<JPanel> panels = new ArrayList<JPanel>();
	
	final JFileChooser fc = new JFileChooser();
	private JButton btnSaveEquipmentItem;
	private JLabel label_14;
	private JPanel panelSelectTrainer;
	private JLabel lblPleaseSelectA;
	private JScrollPane scrollPane_2;
	private JList list_2;
	private JButton btnNewButton_5;
	private JTextField tbHiddenTrainerGUID;
	private JButton btnModifyTrainer;
	
	private Trainer selectedTrainer;
	private Customer selectedCustomer;
	private EquipmentItem selectedEquipmentItem;
	private Exercise selectedExercise;
	private WorkoutRoutine selectedWorkoutRoutine;
	
	//private Customer searchedCustomer; 
	
	private JPanel panelSelectCustomer;
	private JLabel lblPleaseSelectA_1;
	private JScrollPane scrollPane_3;
	private JButton button_1;
	private JList list_3;
	private JButton btnSaveChanges;
	private JTextField tbHiddenCustomerGUID;
	private JPanel panelSelectEquipmentItem;
	private JLabel lblPleaseSelectAn;
	private JScrollPane scrollPane_4;
	private JButton button_2;
	private JTextField tbHiddenEquipmentItemGUID;
	private JButton btnCreateExercise;
	private JButton btnModifyExercise;
	private JButton button_3;
	private JPanel panelCreateExercise;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JPanel panelSelectExercise;
	private JLabel lblPleaseSelectAn_1;
	private JScrollPane scrollPane_7;
	private JButton button_4;
	private JList list_7;
	private JPanel panelWorkoutRoutine;
	private JScrollPane scrollPane_8;
	private JLabel lblWorkoutRoutine;
	private JButton btnCreateWorkoutRoutine;
	private JTextField textField_35;
	private JPanel panelSelectWorkoutRoutine;
	private JScrollPane scrollPane_9;
	private JLabel lblPleaseSelectA_2;
	private JButton button_5;
	private JList list_9;
	private JPanel panelAssignWorkouts;
	private JLabel lblPleaseSelect;
	private JScrollPane scrollPane_10;
	private JButton btnAssign;
	private JLabel lblPleaseSelect_1;
	private JLabel lblAssignWorkouts;
	private JLabel lblAssignStatus;
	private JButton btnSearchCustomers;
	private JButton btnSearchWorkoutroutines;
	private JPanel panelSearchCustomers;
	private JLabel lblSearchForA;
	private JScrollPane scrollPane_12;
	private JButton btnView;
	private JTextField textField_36;
	private JList list_12;
	private JPanel panelSearchWorkoutRoutines;
	private JLabel lblSearchForA_1;
	private JScrollPane scrollPane_14;
	private JLabel label_18;
	private JTextField textField_37;
	private JScrollPane scrollPane_15;
	private JLabel lblAssignedToCustomers;
	private JButton button_6;
	private JList list_14;
	private JList list_15;
	
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
	    	
	    	if (c instanceof Container){
	    		
	    		for(Component inner : ((Container) c).getComponents()){
	    	
			    	if (inner instanceof JTextField)
		            {
		                JTextField j = (JTextField)inner;
		                j.setText("");
		                //System.out.println("Cleared Text for: " + j.getName());
		            }
			    	
			    	else if (inner instanceof JPasswordField)
		            {
			    		JPasswordField j = (JPasswordField)inner;
		                j.setText("");
		            }
	    		}
	    	}
	    }
	}
	
    public ImageIcon ResizeImage(String ImagePath, JLabel label)
    {
    	//return new ImageIcon(ImagePath);
    	
        ImageIcon MyImage = new ImageIcon(ImagePath);
       return resizeImageIcon(MyImage, label);
    }
    
    public ImageIcon resizeImageIcon(ImageIcon MyImage, JLabel label){
    	
    	 Image img = MyImage.getImage();
         Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
         ImageIcon image = new ImageIcon(newImg);
         return image;
    	
    }
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 694);
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
		
		panelRegisterCustomer = new JPanel();
		panelRegisterCustomer.setLayout(null);
		frame.getContentPane().add(panelRegisterCustomer, "name_1767959145970");
		

		panelHireTrainer = new JPanel();
		frame.getContentPane().add(panelHireTrainer, "name_3228290166164");
		panelHireTrainer.setLayout(null);
		
		JList list = new JList();
		list.setBounds(202, 400, 219, -35);
		panelRegisterCustomer.add(list);
		

		JList list_1 = new JList();
		list_1.setBounds(202, 400, 219, -35);
		panelHireTrainer.add(list_1);
		
		DefaultListModel<HealthInsuranceProvider> healthInsuranceProviders = new DefaultListModel<HealthInsuranceProvider>();
		
		DefaultListModel<Trainer> trainers = new DefaultListModel<Trainer>();
		
		DefaultListModel<Customer> customers = new DefaultListModel<Customer>();
		
		DefaultListModel<EquipmentItem> equipmentItems = new DefaultListModel<EquipmentItem>();
		
		DefaultListModel<ExerciseSet> exerciseSets = new DefaultListModel<ExerciseSet>();
		
		DefaultListModel<Exercise> exercises = new DefaultListModel<Exercise>();
		
		DefaultListModel<WorkoutRoutine> workoutRoutines = new DefaultListModel<WorkoutRoutine>();
		
		JButton btnHireTrainer = new JButton("Hire Trainer");
		btnHireTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCreate.setVisible(true);
				btnModifyTrainer.setVisible(false);
				
				textField_11.setEnabled(true);
				
				healthInsuranceProviders.clear();
				
				for(HealthInsuranceProvider provider : SystemGeneralController.getInstance().getHealthInsuranceProviders()){
					healthInsuranceProviders.addElement(provider);
				}
				
				
				 list_1.setModel(healthInsuranceProviders);     
				 scrollPane_1.getViewport().removeAll();
				 scrollPane_1.setViewportView(list_1);
				
				setComponentVisibility(frame, JPanel.class, false);
				
				panelHireTrainer.setVisible(true);
				
				
			}
		});
		btnHireTrainer.setBounds(141, 56, 199, 25);
		panelManagerDashboard.add(btnHireTrainer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 369, 256, 59);
		panelRegisterCustomer.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("Register Customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				button.setVisible(true);
				btnSaveChanges.setVisible(false);
				
				healthInsuranceProviders.clear();
			
				for(HealthInsuranceProvider provider : SystemGeneralController.getInstance().getHealthInsuranceProviders()){
					healthInsuranceProviders.addElement(provider);
				}
				
				 list.setModel(healthInsuranceProviders);     
				 scrollPane.getViewport().removeAll();
				 scrollPane.setViewportView(list);
				 
				 
				setComponentVisibility(frame, JPanel.class, false);
				
				panelRegisterCustomer.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(141, 150, 199, 25);
		panelManagerDashboard.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Modify Trainer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				trainers.clear();
				
				for(Trainer trainer : UserController.getInstance().getTrainers()){
					trainers.addElement(trainer);
				}
				
				
				 list_2.setModel(trainers);     
				 scrollPane_2.getViewport().removeAll();
				 scrollPane_2.setViewportView(list_2);
				
				 setComponentVisibility(frame, JPanel.class, false);
					
				panelSelectTrainer.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(141, 93, 199, 25);
		panelManagerDashboard.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Modify Customer");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				customers.clear();
				
				for(Customer customer : UserController.getInstance().getCustomers()){
					customers.addElement(customer);
				}
				
				
				 list_3.setModel(customers);     
				 scrollPane_3.getViewport().removeAll();
				 scrollPane_3.setViewportView(list_3);
				
				 setComponentVisibility(frame, JPanel.class, false);
					
				panelSelectCustomer.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(141, 189, 199, 25);
		panelManagerDashboard.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("New Equipment Inventory");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label_14.setText("");
				
				setComponentVisibility(frame, JPanel.class, false);
				
				panelEquipmentInventory.setVisible(true);
				
				
			}
		});
		btnNewButton_4.setBounds(141, 249, 261, 25);
		panelManagerDashboard.add(btnNewButton_4);
		
		
		
		
		
		
		
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
		
		
		
		
		
		
		
		panelSelectExercise = new JPanel();
		panelSelectExercise.setLayout(null);
		frame.getContentPane().add(panelSelectExercise, "name_5515521602152");
		
		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(49, 83, 412, 303);
		panelSelectExercise.add(scrollPane_7);
		
		list_7 = new JList();
		scrollPane_7.setViewportView(list_7);
		
		
		btnModifyExercise = new JButton("Modify Exercise");
		btnModifyExercise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkoutController workoutController = new WorkoutController();
				
				exercises.clear();
				
				for(Exercise exercise: workoutController.getExercises()){
					exercises.addElement(exercise);
				}
				
				 list_7.setModel(exercises);     
				 scrollPane_7.getViewport().removeAll();
				 scrollPane_7.setViewportView(list_7);
				
				 setComponentVisibility(frame, JPanel.class, false);
		        	
		        	panelSelectExercise.setVisible(true);
			}
		});
		btnModifyExercise.setBounds(98, 139, 296, 25);
		panelTrainerDashboard.add(btnModifyExercise);
		
		
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
		lblWorkHours.setBounds(12, 486, 167, 15);
		panelHireTrainer.add(lblWorkHours);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(187, 484, 256, 19);
		panelHireTrainer.add(textField_12);
		
		lblQualifications = new JLabel("Qualifications:");
		lblQualifications.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQualifications.setBounds(76, 515, 103, 15);
		panelHireTrainer.add(lblQualifications);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(187, 513, 256, 19);
		panelHireTrainer.add(textField_15);
		
		lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername_1.setBounds(12, 544, 167, 15);
		panelHireTrainer.add(lblUsername_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(187, 542, 256, 19);
		panelHireTrainer.add(textField_14);
		
		textField_16 = new JPasswordField();
		textField_16.setColumns(10);
		textField_16.setBounds(187, 571, 256, 19);
		panelHireTrainer.add(textField_16);
		
		lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1.setBounds(76, 573, 103, 15);
		panelHireTrainer.add(lblPassword_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 639, 333, 15);
		panelHireTrainer.add(lblNewLabel);
		

		btnCreate = new JButton("Hire");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HealthInsuranceProvider selectedProvider = (HealthInsuranceProvider) list_1.getSelectedValue();
				
				Response response = null;
				
				if(selectedProvider != null){
				
					response = UserController.getInstance()
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
									selectedProvider,
									textField_12.getText(),
									textField_15.getText(),
									textField_14.getText(),
									textField_16.getText()
									));
				}else{
					response = UserController.getInstance()
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
				}
				
				
				
				
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
		btnCreate.setBounds(187, 602, 117, 25);
		panelHireTrainer.add(btnCreate);
		
		label_2 = new JLabel("Health Ins. Provider:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(2, 352, 167, 15);
		panelHireTrainer.add(label_2);
		
		label_12 = new JLabel("select:");
		label_12.setBounds(109, 376, 70, 19);
		panelHireTrainer.add(label_12);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(187, 354, 256, 59);
		panelHireTrainer.add(scrollPane_1);
		
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(47, 469, 396, 5);
		panelHireTrainer.add(separator_2);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(186, 438, 256, 19);
		panelHireTrainer.add(textField_13);
		
		lblAddNew_1 = new JLabel("add new:");
		lblAddNew_1.setBounds(108, 439, 70, 15);
		panelHireTrainer.add(lblAddNew_1);
		
		lblOr_1 = new JLabel("OR");
		lblOr_1.setBounds(296, 414, 35, 15);
		panelHireTrainer.add(lblOr_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(47, 335, 396, 5);
		panelHireTrainer.add(separator_3);
		
		tbHiddenTrainerGUID = new JTextField();
		tbHiddenTrainerGUID.setBounds(47, 621, 4, 19);
		panelHireTrainer.add(tbHiddenTrainerGUID);
		tbHiddenTrainerGUID.setColumns(10);
		tbHiddenTrainerGUID.setVisible(false);
		
		btnModifyTrainer = new JButton("Save Changes");
		btnModifyTrainer.setBounds(187, 602, 167, 25);
		panelHireTrainer.add(btnModifyTrainer);
		
		btnModifyTrainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				textField_2.getText(),
				textField_3.getText(),
				textField_4.getText(),
				textField_6.getText(),
				textField_5.getText(),
				textField_7.getText(),
				textField_9.getText(),
				textField_8.getText(),
				textField_10.getText(),
				textField_11.getText(),
				selectedProvider,
				textField_12.getText(),
				textField_15.getText(),
				textField_14.getText(),
				textField_16.getText()
				*/
				
				selectedTrainer.getUserInformation().setFirstName(textField_2.getText());
				selectedTrainer.getUserInformation().setLastName(textField_3.getText());
				selectedTrainer.getUserInformation().getAddress().setAddressLine1(textField_4.getText());
				selectedTrainer.getUserInformation().getAddress().setAddressLine2(textField_6.getText());
				selectedTrainer.getUserInformation().getAddress().setCity(textField_5.getText());
				selectedTrainer.getUserInformation().getAddress().setState(textField_7.getText());
				selectedTrainer.getUserInformation().getAddress().setZip(textField_9.getText());
				selectedTrainer.getUserInformation().getPhone().setNumber(textField_8.getText());
				selectedTrainer.getUserInformation().getEmail().setEmail(textField_10.getText());
				
				HealthInsuranceProvider selectedProvider = (HealthInsuranceProvider) list_1.getSelectedValue();
				
				if(selectedProvider != null){
					selectedTrainer.getUserInformation().setHealthInsuranceProvider(selectedProvider);
				}else{
					selectedTrainer.getUserInformation().setHealthInsuranceProvider(new HealthInsuranceProvider(textField_13.getText()));
				}
				
				selectedTrainer.setWorkHours(textField_12.getText());
				selectedTrainer.setQualifications(textField_15.getText());
				
				selectedTrainer.getUserAccount().setUsername(textField_14.getText());
				
				if(!textField_16.getText().isEmpty()){
					selectedTrainer.getUserAccount().setPassword(textField_16.getText());
				}
				/*textField_10.getText(),
				textField_11.getText(),
				selectedProvider,
				textField_12.getText(),
				textField_15.getText(),
				textField_14.getText(),
				textField_16.getText()
				*/
				
				Response response = UserController.getInstance()
						.hireTrainer(selectedTrainer);
			
				
			
			
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
		
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(187, 35, 256, 19);
		panelRegisterCustomer.add(textField_17);
		
		label_1 = new JLabel("First Name:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(76, 37, 103, 15);
		panelRegisterCustomer.add(label_1);
		
		lblRegisterCustomer = new JLabel("Register Customer");
		lblRegisterCustomer.setBounds(190, 12, 182, 15);
		panelRegisterCustomer.add(lblRegisterCustomer);
		
		label_3 = new JLabel("Last Name:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(76, 68, 103, 15);
		panelRegisterCustomer.add(label_3);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(187, 66, 256, 19);
		panelRegisterCustomer.add(textField_18);
		
		label_4 = new JLabel("Address 1:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(76, 99, 103, 15);
		panelRegisterCustomer.add(label_4);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(187, 97, 256, 19);
		panelRegisterCustomer.add(textField_19);
		
		label_5 = new JLabel("City:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(76, 157, 103, 15);
		panelRegisterCustomer.add(label_5);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(187, 124, 256, 19);
		panelRegisterCustomer.add(textField_20);
		
		label_6 = new JLabel("Address 2:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(76, 128, 103, 15);
		panelRegisterCustomer.add(label_6);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(187, 155, 256, 19);
		panelRegisterCustomer.add(textField_21);
		
		label_7 = new JLabel("State:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(76, 186, 103, 15);
		panelRegisterCustomer.add(label_7);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(187, 184, 256, 19);
		panelRegisterCustomer.add(textField_22);
		
		label_8 = new JLabel("Phone:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(76, 251, 103, 15);
		panelRegisterCustomer.add(label_8);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(187, 215, 256, 19);
		panelRegisterCustomer.add(textField_23);
		
		label_9 = new JLabel("Zip:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(76, 215, 103, 15);
		panelRegisterCustomer.add(label_9);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(187, 249, 256, 19);
		panelRegisterCustomer.add(textField_24);
		
		label_10 = new JLabel("Email:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(76, 280, 103, 15);
		panelRegisterCustomer.add(label_10);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(187, 278, 256, 19);
		panelRegisterCustomer.add(textField_25);
		
		label_11 = new JLabel("ID:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(76, 308, 103, 15);
		panelRegisterCustomer.add(label_11);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(187, 306, 256, 19);
		panelRegisterCustomer.add(textField_26);
		
		label_13 = new JLabel("Health Ins. Provider:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setBounds(12, 350, 167, 15);
		panelRegisterCustomer.add(label_13);
		
		label_15 = new JLabel("Username:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setBounds(12, 520, 167, 15);
		panelRegisterCustomer.add(label_15);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(187, 518, 256, 19);
		panelRegisterCustomer.add(textField_28);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(187, 547, 256, 19);
		panelRegisterCustomer.add(passwordField);
		
		label_16 = new JLabel("Password:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setBounds(76, 549, 103, 15);
		panelRegisterCustomer.add(label_16);
		
		lbl_HireCustomerStatus = new JLabel("");
		lbl_HireCustomerStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HireCustomerStatus.setBounds(94, 639, 333, 15);
		panelRegisterCustomer.add(lbl_HireCustomerStatus);
		
		JCheckBox chckbxActive = new JCheckBox("Active");
		chckbxActive.setSelected(true);
		chckbxActive.setBounds(187, 487, 129, 23);
		panelRegisterCustomer.add(chckbxActive);
		
		
		button = new JButton("Hire");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HealthInsuranceProvider selectedProvider = (HealthInsuranceProvider) list.getSelectedValue();
				
				Response response = null;
				
				if(selectedProvider != null){
				
					response = UserController.getInstance()
							.registerCustomer(new Customer(textField_17.getText(),
									textField_18.getText(),
									textField_19.getText(),
									textField_20.getText(),
									textField_21.getText(),
									textField_22.getText(),
									textField_23.getText(),
									textField_24.getText(),
									textField_25.getText(),
									textField_26.getText(),
									selectedProvider,
									chckbxActive.isSelected(),
									textField_28.getText(),
									passwordField.getText()
									));
				}else{
					response = UserController.getInstance()
							.registerCustomer(new Customer(textField_17.getText(),
									textField_18.getText(),
									textField_19.getText(),
									textField_20.getText(),
									textField_21.getText(),
									textField_22.getText(),
									textField_23.getText(),
									textField_24.getText(),
									textField_25.getText(),
									textField_26.getText(),
									textField_27.getText(),
									chckbxActive.isSelected(),
									textField_28.getText(),
									passwordField.getText()
									));
				}
				
				if(response.isSuccess)
				{
					clearAllTextBoxes(frame);
					
					lbl_HireCustomerStatus.setText(response.StatusText);
					
					final Timer timer = new Timer(1000, null);
			        timer.addActionListener((al) -> {
			            
			        	setComponentVisibility(frame, JPanel.class, false);
			        	
			        	panelManagerDashboard.setVisible(true);
			        	
			        	timer.stop();
			        	
			        });
			        timer.start();
				}else{
					lbl_HireCustomerStatus.setText(response.StatusText);
				}
				
			}
		});
		button.setBounds(187, 602, 117, 25);
		panelRegisterCustomer.add(button);
		
		textField_27 = new JTextField();
		textField_27.setBounds(187, 460, 256, 19);
		panelRegisterCustomer.add(textField_27);
		textField_27.setColumns(10);
		
		JLabel lblSelect = new JLabel("select:");
		lblSelect.setBounds(119, 374, 70, 15);
		panelRegisterCustomer.add(lblSelect);
		
		JLabel lblAddNew = new JLabel("add new:");
		lblAddNew.setBounds(119, 462, 70, 15);
		panelRegisterCustomer.add(lblAddNew);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(47, 335, 396, 5);
		panelRegisterCustomer.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(47, 484, 396, 5);
		panelRegisterCustomer.add(separator_1);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBounds(289, 440, 28, 15);
		panelRegisterCustomer.add(lblOr);
		
		btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedCustomer.getUserInformation().setFirstName(textField_17.getText());
				selectedCustomer.getUserInformation().setLastName(textField_18.getText());
				selectedCustomer.getUserInformation().getAddress().setAddressLine1(textField_19.getText());
				selectedCustomer.getUserInformation().getAddress().setAddressLine2(textField_20.getText());
				selectedCustomer.getUserInformation().getAddress().setCity(textField_21.getText());
				selectedCustomer.getUserInformation().getAddress().setState(textField_22.getText());
				selectedCustomer.getUserInformation().getAddress().setZip(textField_23.getText());
				selectedCustomer.getUserInformation().getPhone().setNumber(textField_24.getText());
				selectedCustomer.getUserInformation().getEmail().setEmail(textField_25.getText());
				
				HealthInsuranceProvider selectedProvider = (HealthInsuranceProvider) list.getSelectedValue();
				
				if(selectedProvider != null){
					selectedCustomer.getUserInformation().setHealthInsuranceProvider(selectedProvider);
				}else{
					selectedCustomer.getUserInformation().setHealthInsuranceProvider(new HealthInsuranceProvider(textField_27.getText()));
				}
				
				selectedCustomer.setActive(chckbxActive.isSelected());
				
				selectedCustomer.getUserAccount().setUsername(textField_28.getText());
				
				if(!passwordField.getText().isEmpty()){
					selectedCustomer.getUserAccount().setPassword(passwordField.getText());
				}
				/*textField_10.getText(),
				textField_11.getText(),
				selectedProvider,
				textField_12.getText(),
				textField_15.getText(),
				textField_14.getText(),
				textField_16.getText()
				*/
				
				Response response = UserController.getInstance()
						.registerCustomer(selectedCustomer);
			
				
			
			
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
		btnSaveChanges.setBounds(187, 602, 143, 25);
		panelRegisterCustomer.add(btnSaveChanges);
		
		tbHiddenCustomerGUID = new JTextField();
		tbHiddenCustomerGUID.setBounds(47, 592, 4, 19);
		panelRegisterCustomer.add(tbHiddenCustomerGUID);
		tbHiddenCustomerGUID.setColumns(10);
		tbHiddenCustomerGUID.setVisible(false);
		
		panelEquipmentInventory = new JPanel();
		panelEquipmentInventory.setLayout(null);
		frame.getContentPane().add(panelEquipmentInventory, "name_17612827201978");
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(187, 35, 256, 19);
		panelEquipmentInventory.add(textField_29);
		
		lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(76, 37, 103, 15);
		panelEquipmentInventory.add(lblName);
		
		lblEquipmentInventory = new JLabel("Equipment Inventory");
		lblEquipmentInventory.setBounds(190, 12, 220, 15);
		panelEquipmentInventory.add(lblEquipmentInventory);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantity.setBounds(76, 68, 103, 15);
		panelEquipmentInventory.add(lblQuantity);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(187, 66, 256, 19);
		panelEquipmentInventory.add(textField_30);
		
		lbl_picture = new JLabel("");
		lbl_picture.setBounds(57, 134, 415, 357);
		panelEquipmentInventory.add(lbl_picture);
		
		JButton btnAddPicture = new JButton("Select Picture");
		btnAddPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int returnVal = fc.showOpenDialog(frame);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            
		            String path = file.getAbsolutePath();
		            lbl_picture.setIcon(ResizeImage(path, lbl_picture));
		            

		        } else {

		        }
				
				
			}
		});
		btnAddPicture.setBounds(187, 97, 134, 25);
		panelEquipmentInventory.add(btnAddPicture);
		
		btnSaveEquipmentItem = new JButton("Save Equipment Item");
		btnSaveEquipmentItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					EquipmentItem equipmentItem = new EquipmentItem(
							textField_29.getText(),
							Integer.parseInt(textField_30.getText()),
							fc.getSelectedFile()
							);
					
					WorkoutController workoutController = new WorkoutController();
					
					Response response = workoutController.addEquipmentItem(equipmentItem);
					

					if(response.isSuccess)
					{
						clearAllTextBoxes(frame);
						
						label_14.setText(response.StatusText);
						
						final Timer timer = new Timer(1000, null);
				        timer.addActionListener((al) -> {
				            
				        	setComponentVisibility(frame, JPanel.class, false);
				        	
				        	panelManagerDashboard.setVisible(true);
				        	
				        	timer.stop();
				        	
				        });
				        timer.start();
					}else{
						label_14.setText(response.StatusText);
					}
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		btnSaveEquipmentItem.setBounds(160, 549, 197, 25);
		panelEquipmentInventory.add(btnSaveEquipmentItem);
		
		label_14 = new JLabel("");
		label_14.setBounds(88, 586, 354, 15);
		panelEquipmentInventory.add(label_14);
		
		JButton btnSaveEquipmentItemChanges = new JButton("Save Changes");
		btnSaveEquipmentItemChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedEquipmentItem.setName(textField_29.getText());
				selectedEquipmentItem.setQuantity(Integer.parseInt(textField_30.getText()));
				
				if(fc.getSelectedFile() != null){
					selectedEquipmentItem.setImageFile(fc.getSelectedFile());
				}
				
				
				
				WorkoutController workoutController = new WorkoutController();
				
				Response response = workoutController.addEquipmentItem(selectedEquipmentItem);
				

				if(response.isSuccess)
				{
					clearAllTextBoxes(frame);
					
					label_14.setText(response.StatusText);
					
					final Timer timer = new Timer(1000, null);
			        timer.addActionListener((al) -> {
			            
			        	setComponentVisibility(frame, JPanel.class, false);
			        	
			        	panelManagerDashboard.setVisible(true);
			        	
			        	timer.stop();
			        	
			        });
			        timer.start();
				}else{
					label_14.setText(response.StatusText);
				}
				
			}
		});
		btnSaveEquipmentItemChanges.setBounds(160, 549, 197, 25);
		panelEquipmentInventory.add(btnSaveEquipmentItemChanges);
		
		tbHiddenEquipmentItemGUID = new JTextField();
		tbHiddenEquipmentItemGUID.setBounds(26, 522, 16, 19);
		panelEquipmentInventory.add(tbHiddenEquipmentItemGUID);
		tbHiddenEquipmentItemGUID.setColumns(10);
		tbHiddenEquipmentItemGUID.setVisible(false);
		
		panelSelectTrainer = new JPanel();
		frame.getContentPane().add(panelSelectTrainer, "name_22839733580412");
		panelSelectTrainer.setLayout(null);
		
		lblPleaseSelectA = new JLabel("Please Select a Trainer");
		lblPleaseSelectA.setBounds(170, 5, 164, 15);
		panelSelectTrainer.add(lblPleaseSelectA);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(49, 83, 412, 303);
		panelSelectTrainer.add(scrollPane_2);
		
		list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
		
		btnNewButton_5 = new JButton("Modify");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				healthInsuranceProviders.clear();
				
				for(HealthInsuranceProvider provider : SystemGeneralController.getInstance().getHealthInsuranceProviders()){
					healthInsuranceProviders.addElement(provider);
				
				}
				
				 list_1.setModel(healthInsuranceProviders);     
				 scrollPane_1.getViewport().removeAll();
				 scrollPane_1.setViewportView(list_1);
				
				 
				selectedTrainer = (Trainer) list_2.getSelectedValue();
				
				tbHiddenTrainerGUID.setText(selectedTrainer.getId());
				
				btnCreate.setVisible(false);
				btnModifyTrainer.setVisible(true);
				//btnCreate.setText("Save changes.");
				
				
				textField_2.setText(selectedTrainer.getUserInformation().getFirstName());
				textField_3.setText(selectedTrainer.getUserInformation().getLastName());
				
				textField_4.setText(selectedTrainer.getUserInformation().getAddress().getAddressLine1());
				textField_6.setText(selectedTrainer.getUserInformation().getAddress().getAddressLine2());
				textField_5.setText(selectedTrainer.getUserInformation().getAddress().getCity());
				textField_7.setText(selectedTrainer.getUserInformation().getAddress().getState());
				textField_9.setText(selectedTrainer.getUserInformation().getAddress().getZip());
				
				textField_8.setText(selectedTrainer.getUserInformation().getPhone().getNumber());
				textField_10.setText(selectedTrainer.getUserInformation().getEmail().getEmail());
				textField_11.setText(selectedTrainer.getId());
				textField_11.setEnabled(false);
				
				list_1.setSelectedIndex(healthInsuranceProviders.indexOf(selectedTrainer.getUserInformation().getHealthInsuranceProvider()));
				
				textField_12.setText(selectedTrainer.getWorkHours());
				textField_15.setText(selectedTrainer.getQualifications());
				textField_14.setText(selectedTrainer.getUserAccount().getUsername());
				
				setComponentVisibility(frame, JPanel.class, false);
				
				panelHireTrainer.setVisible(true);
				
			}
		});
		btnNewButton_5.setBounds(170, 398, 177, 25);
		panelSelectTrainer.add(btnNewButton_5);
		
		panelSelectCustomer = new JPanel();
		panelSelectCustomer.setLayout(null);
		frame.getContentPane().add(panelSelectCustomer, "name_36366460619016");
		
		lblPleaseSelectA_1 = new JLabel("Please Select a Customer");
		lblPleaseSelectA_1.setBounds(170, 5, 244, 15);
		panelSelectCustomer.add(lblPleaseSelectA_1);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(49, 83, 412, 303);
		panelSelectCustomer.add(scrollPane_3);
		
		list_3 = new JList();
		scrollPane_3.setViewportView(list_3);
		
		button_1 = new JButton("Modify");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				healthInsuranceProviders.clear();
				
				for(HealthInsuranceProvider provider : SystemGeneralController.getInstance().getHealthInsuranceProviders()){
					healthInsuranceProviders.addElement(provider);
				
				}
				
				 list.setModel(healthInsuranceProviders);     
				 scrollPane.getViewport().removeAll();
				 scrollPane.setViewportView(list);
				
				 
				selectedCustomer = (Customer) list_3.getSelectedValue();
				
				tbHiddenCustomerGUID.setText(selectedCustomer.getId());
				
				button.setVisible(false);
				btnSaveChanges.setVisible(true);
				//btnCreate.setText("Save changes.");
				
				
				textField_17.setText(selectedCustomer.getUserInformation().getFirstName());
				textField_18.setText(selectedCustomer.getUserInformation().getLastName());
				
				textField_19.setText(selectedCustomer.getUserInformation().getAddress().getAddressLine1());
				textField_20.setText(selectedCustomer.getUserInformation().getAddress().getAddressLine2());
				textField_21.setText(selectedCustomer.getUserInformation().getAddress().getCity());
				textField_22.setText(selectedCustomer.getUserInformation().getAddress().getState());
				textField_23.setText(selectedCustomer.getUserInformation().getAddress().getZip());
				
				textField_24.setText(selectedCustomer.getUserInformation().getPhone().getNumber());
				textField_25.setText(selectedCustomer.getUserInformation().getEmail().getEmail());
				textField_26.setText(selectedCustomer.getId());
				textField_26.setEnabled(false);
				
				list.setSelectedIndex(healthInsuranceProviders.indexOf(selectedCustomer.getUserInformation().getHealthInsuranceProvider()));
				
				chckbxActive.setSelected(selectedCustomer.isActive());
				
				textField_28.setText(selectedCustomer.getUserAccount().getUsername());
				
				setComponentVisibility(frame, JPanel.class, false);
				
				panelRegisterCustomer.setVisible(true);
				
				
				
			}
		});
		button_1.setBounds(170, 398, 177, 25);
		panelSelectCustomer.add(button_1);
		

		panelSelectEquipmentItem = new JPanel();
		panelSelectEquipmentItem.setLayout(null);
		frame.getContentPane().add(panelSelectEquipmentItem, "name_1164882857818");
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(49, 83, 412, 303);
		panelSelectEquipmentItem.add(scrollPane_4);
		
		JList list_4 = new JList();
		scrollPane_4.setViewportView(list_4);
		
		
		
		lblPleaseSelectAn = new JLabel("Please Select an Equipment Item");
		lblPleaseSelectAn.setBounds(170, 5, 244, 15);
		panelSelectEquipmentItem.add(lblPleaseSelectAn);
		
		
		
		button_2 = new JButton("Modify");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label_14.setText("");
				
				selectedEquipmentItem = (EquipmentItem) list_4.getSelectedValue();
				
				tbHiddenEquipmentItemGUID.setText(selectedEquipmentItem.getId());
				
				btnSaveEquipmentItem.setVisible(false);
				btnSaveEquipmentItemChanges.setVisible(true);
				
				textField_29.setText(selectedEquipmentItem.getName());
				textField_30.setText(String.valueOf(selectedEquipmentItem.getQuantity()));
				
				lbl_picture.setIcon(resizeImageIcon(selectedEquipmentItem.getImageIcon(), lbl_picture));
				
				setComponentVisibility(frame, JPanel.class, false);
				
				panelEquipmentInventory.setVisible(true);
				
				
				
				
			}
		});
		button_2.setBounds(170, 398, 177, 25);
		panelSelectEquipmentItem.add(button_2);
		
		
		
		btnModifyEquipmentInventory = new JButton("Modify Equipment Inventory");
		btnModifyEquipmentInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkoutController workoutController = new WorkoutController();
				
				equipmentItems.clear();
				
				for(EquipmentItem equipmentItem: workoutController.getEquipmentItems()){
					equipmentItems.addElement(equipmentItem);
				}
				
				
				 list_4.setModel(equipmentItems);     
				 scrollPane_4.getViewport().removeAll();
				 scrollPane_4.setViewportView(list_4);
				
				 setComponentVisibility(frame, JPanel.class, false);
					
				panelSelectEquipmentItem.setVisible(true);
				
			}
		});
		btnModifyEquipmentInventory.setBounds(141, 290, 261, 25);
		panelManagerDashboard.add(btnModifyEquipmentInventory);
		
		panelCreateExercise = new JPanel();
		frame.getContentPane().add(panelCreateExercise, "name_7335866307318");
		panelCreateExercise.setLayout(null);
		
		JLabel lblCreateExercise = new JLabel("Create Exercise");
		lblCreateExercise.setBounds(175, 23, 144, 15);
		panelCreateExercise.add(lblCreateExercise);
		
		textField_31 = new JTextField();
		textField_31.setBounds(185, 50, 187, 19);
		panelCreateExercise.add(textField_31);
		textField_31.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(112, 52, 70, 15);
		panelCreateExercise.add(lblNewLabel_2);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(195, 81, 200, 214);
		panelCreateExercise.add(scrollPane_5);
		
		JList list_5 = new JList();
		scrollPane_5.setRowHeaderView(list_5);
		
		JLabel lblExercises = new JLabel("Select Equipment:");
		lblExercises.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExercises.setBounds(42, 79, 150, 15);
		panelCreateExercise.add(lblExercises);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuration.setBounds(60, 311, 122, 15);
		panelCreateExercise.add(lblDuration);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(185, 309, 187, 19);
		panelCreateExercise.add(textField_32);
		
		JLabel lblNumberOfSets = new JLabel("Set Name:");
		lblNumberOfSets.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfSets.setBounds(38, 492, 144, 15);
		panelCreateExercise.add(lblNumberOfSets);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(185, 490, 187, 19);
		panelCreateExercise.add(textField_33);
		
		JLabel lblRepsPerSet = new JLabel("Repititions per Set:");
		lblRepsPerSet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepsPerSet.setBounds(38, 521, 144, 15);
		panelCreateExercise.add(lblRepsPerSet);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(185, 519, 187, 19);
		panelCreateExercise.add(textField_34);
		
		
		
		
		
		JLabel lblExerciseStatus = new JLabel("");
		lblExerciseStatus.setBounds(97, 625, 339, 15);
		panelCreateExercise.add(lblExerciseStatus);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(42, 366, 437, 105);
		panelCreateExercise.add(scrollPane_6);
		
		JList list_6 = new JList();
		scrollPane_6.setViewportView(list_6);
		
		JButton btnSaveChanges_1 = new JButton("Save Changes");
		btnSaveChanges_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkoutController wc = new WorkoutController();

				List<EquipmentItem> selectedEquipmentItems =  list_5.getSelectedValuesList();
				List<ExerciseSet> selectedExerciseSets =  list_6.getSelectedValuesList();
				
				selectedExercise.setName(textField_31.getText());
				selectedExercise.setDuration(textField_32.getText());
				selectedExercise.setEquipmentItems(new HashSet<EquipmentItem>(selectedEquipmentItems));
				selectedExercise.setExerciseSets(new HashSet<ExerciseSet>(selectedExerciseSets));
				
				Response response = null;
				
				response = wc.addExercise(selectedExercise);
				
				if(response.isSuccess)
				{
					clearAllTextBoxes(frame);
					
					lblExerciseStatus.setText(response.StatusText);
					
					final Timer timer = new Timer(1000, null);
			        timer.addActionListener((al) -> {
			            
			        	setComponentVisibility(frame, JPanel.class, false);
			        	
			        	panelTrainerDashboard.setVisible(true);
			        	
			        	timer.stop();
			        	
			        });
			        timer.start();
				}else{
					lblExerciseStatus.setText(response.StatusText);
				}
				
				
			}
		});
		btnSaveChanges_1.setBounds(165, 565, 200, 25);
		panelCreateExercise.add(btnSaveChanges_1);
		
		JButton btnNewButton_7 = new JButton("Create Exercise");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkoutController wc = new WorkoutController();

				List<EquipmentItem> selectedEquipmentItems =  list_5.getSelectedValuesList();
				List<ExerciseSet> selectedExerciseSets =  list_6.getSelectedValuesList();
				
				Response response = null;
				
				response = wc.addExercise(new Exercise(textField_31.getText(), textField_32.getText(),
						new HashSet<EquipmentItem>(selectedEquipmentItems), new HashSet<ExerciseSet>(selectedExerciseSets)));
				
				if(response.isSuccess)
				{
					clearAllTextBoxes(frame);
					
					lblExerciseStatus.setText(response.StatusText);
					
					final Timer timer = new Timer(1000, null);
			        timer.addActionListener((al) -> {
			            
			        	setComponentVisibility(frame, JPanel.class, false);
			        	
			        	panelTrainerDashboard.setVisible(true);
			        	
			        	timer.stop();
			        	
			        });
			        timer.start();
				}else{
					lblExerciseStatus.setText(response.StatusText);
				}
				
			}
		});
		btnNewButton_7.setBounds(165, 565, 200, 25);
		panelCreateExercise.add(btnNewButton_7);
		
		
		
		JLabel lblSet = new JLabel("Select Sets");
		lblSet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSet.setBounds(167, 342, 122, 19);
		panelCreateExercise.add(lblSet);
		
		JButton btnNewButton_8 = new JButton("Add Set");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExerciseSet exerciseSet = new ExerciseSet(textField_33.getText(), 
						Integer.parseInt(textField_34.getText()));
				
				WorkoutController wc = new WorkoutController();
				
				Response response = wc.addExerciseSet(exerciseSet);
				
				if(response.isSuccess)
				{
					exerciseSets.clear();
					
					for(ExerciseSet es: wc.getExerciseSets()){
						exerciseSets.addElement(es);
					}
					
					textField_33.setText("");
					textField_34.setText("");
					
				}else{
					lblExerciseStatus.setText(response.StatusText);
				}
				
			}
		});
		btnNewButton_8.setBounds(384, 498, 95, 25);
		panelCreateExercise.add(btnNewButton_8);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(39, 334, 419, 15);
		panelCreateExercise.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(48, 548, 419, 15);
		panelCreateExercise.add(separator_5);

		btnCreateExercise = new JButton("Create Exercise");
		btnCreateExercise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblExerciseStatus.setText("");
				
				btnNewButton_7.setVisible(true);
				btnSaveChanges_1.setVisible(false);
				
				WorkoutController workoutController = new WorkoutController();
				
				equipmentItems.clear();
				
				for(EquipmentItem equipmentItem: workoutController.getEquipmentItems()){
					equipmentItems.addElement(equipmentItem);
				}
				
				exerciseSets.clear();
				
				for(ExerciseSet exerciseSet: workoutController.getExerciseSets()){
					exerciseSets.addElement(exerciseSet);
				}
				
				 list_5.setModel(equipmentItems);     
				 scrollPane_5.getViewport().removeAll();
				 scrollPane_5.setViewportView(list_5);
				 
				 list_5.setSelectionMode(
		                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				 
				 list_6.setModel(exerciseSets);     
				 scrollPane_6.getViewport().removeAll();
				 scrollPane_6.setViewportView(list_6);
				
				 list_6.setSelectionMode(
		                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				 
				setComponentVisibility(frame, JPanel.class, false);
				
				panelCreateExercise.setVisible(true);
				
			}
		});
		btnCreateExercise.setBounds(98, 102, 296, 25);
		panelTrainerDashboard.add(btnCreateExercise);
		
		
		
		lblPleaseSelectAn_1 = new JLabel("Please Select an Exercise");
		lblPleaseSelectAn_1.setBounds(140, 12, 238, 15);
		panelSelectExercise.add(lblPleaseSelectAn_1);
		
		
		
		button_4 = new JButton("Modify");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedExercise = (Exercise) list_7.getSelectedValue();

				lblExerciseStatus.setText("");
				
				btnNewButton_7.setVisible(false);
				btnSaveChanges_1.setVisible(true);
				
				WorkoutController workoutController = new WorkoutController();
				
				equipmentItems.clear();
				
				for(EquipmentItem equipmentItem: workoutController.getEquipmentItems()){
					equipmentItems.addElement(equipmentItem);
				}
				
				exerciseSets.clear();
				
				for(ExerciseSet exerciseSet: workoutController.getExerciseSets()){
					exerciseSets.addElement(exerciseSet);
				}
				
				 list_5.setModel(equipmentItems);     
				 scrollPane_5.getViewport().removeAll();
				 scrollPane_5.setViewportView(list_5);
				 
				 list_5.setSelectionMode(
		                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				 
				 list_6.setModel(exerciseSets);     
				 scrollPane_6.getViewport().removeAll();
				 scrollPane_6.setViewportView(list_6);
				
				 list_6.setSelectionMode(
		                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				 
				 List<Integer> indices = new ArrayList<Integer>();
				 
				 for(EquipmentItem ei : selectedExercise.getEquipmentItems()){
					 indices.add(equipmentItems.indexOf(ei));
				 }
				 
				 int[] array = indices.stream().mapToInt(i->i).toArray();
				 list_5.setSelectedIndices(array);
				 
				 indices.clear();
				 
				 for(ExerciseSet es : selectedExercise.getExerciseSets()){
					 indices.add(exerciseSets.indexOf(es));
				 }
				 
				 int[] array2 = indices.stream().mapToInt(i->i).toArray();
				 list_6.setSelectedIndices(array2);
				 
				 textField_31.setText(selectedExercise.getName());
				 textField_32.setText(selectedExercise.getDuration());
				 
				setComponentVisibility(frame, JPanel.class, false);
				
				panelCreateExercise.setVisible(true);
				
			}
		});
		button_4.setBounds(170, 398, 177, 25);
		panelSelectExercise.add(button_4);
		
		panelWorkoutRoutine = new JPanel();
		panelWorkoutRoutine.setLayout(null);
		frame.getContentPane().add(panelWorkoutRoutine, "name_13835899612978");
		
		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(53, 112, 412, 303);
		panelWorkoutRoutine.add(scrollPane_8);
		
		JList list_8 = new JList();
		scrollPane_8.setViewportView(list_8);
		
		lblWorkoutRoutine = new JLabel("Workout Routine");
		lblWorkoutRoutine.setBounds(191, 12, 141, 15);
		panelWorkoutRoutine.add(lblWorkoutRoutine);
		
		
		
		textField_35 = new JTextField();
		textField_35.setBounds(151, 52, 270, 19);
		panelWorkoutRoutine.add(textField_35);
		textField_35.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(72, 52, 70, 15);
		panelWorkoutRoutine.add(lblNewLabel_3);
		
		JLabel lblExercies = new JLabel("Exercises");
		lblExercies.setBounds(53, 97, 70, 15);
		panelWorkoutRoutine.add(lblExercies);
		

		JLabel lblWorkoutRoutineStatus = new JLabel("");
		lblWorkoutRoutineStatus.setBounds(53, 530, 412, 15);
		panelWorkoutRoutine.add(lblWorkoutRoutineStatus);
		
		JButton btnSaveChanges_2 = new JButton("Save Changes");
		btnSaveChanges_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkoutController wc = new WorkoutController();

				
				List<Exercise> selectedExercises =  list_8.getSelectedValuesList();
				
				selectedWorkoutRoutine.setName(textField_35.getText());
				
				selectedWorkoutRoutine.setExercises(new HashSet<Exercise>(selectedExercises));
				
				Response response = null;
				
				response = wc.addWorkoutRoutine(selectedWorkoutRoutine);
				
				if(response.isSuccess)
				{
					clearAllTextBoxes(frame);
					
					lblWorkoutRoutineStatus.setText(response.StatusText);
					
					final Timer timer = new Timer(1000, null);
			        timer.addActionListener((al) -> {
			            
			        	setComponentVisibility(frame, JPanel.class, false);
			        	
			        	panelTrainerDashboard.setVisible(true);
			        	
			        	timer.stop();
			        	
			        });
			        timer.start();
				}else{
					lblWorkoutRoutineStatus.setText(response.StatusText);
				}
				
				
			}
		});
		btnSaveChanges_2.setBounds(123, 441, 233, 25);
		panelWorkoutRoutine.add(btnSaveChanges_2);
		
		
		JButton btnNewButton_6 = new JButton("Create Workout Routine");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnCreateWorkoutRoutine.setVisible(true);
				btnSaveChanges_2.setVisible(false);
				
				textField_35.setText("");
				
				WorkoutController workoutController = new WorkoutController();
				
				exercises.clear();
				
				for(Exercise exercise: workoutController.getExercises()){
					exercises.addElement(exercise);
				}
				
				 list_8.setModel(exercises);     
				 scrollPane_8.getViewport().removeAll();
				 scrollPane_8.setViewportView(list_8);
				
				 setComponentVisibility(frame, JPanel.class, false);
		        	
		        panelWorkoutRoutine.setVisible(true);
				
				
			}
		});
		btnNewButton_6.setBounds(98, 199, 296, 25);
		panelTrainerDashboard.add(btnNewButton_6);
		
		btnCreateWorkoutRoutine = new JButton("Create Workout Routine");
		btnCreateWorkoutRoutine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				WorkoutController wc = new WorkoutController();

				List<Exercise> selectedExercises =  list_8.getSelectedValuesList();
				
				Response response = null;
				
				response = wc.addWorkoutRoutine(new WorkoutRoutine(textField_35.getText(), new HashSet<Exercise>(selectedExercises)));
				
				if(response.isSuccess)
				{
					clearAllTextBoxes(frame);
					
					lblWorkoutRoutineStatus.setText(response.StatusText);
					
					final Timer timer = new Timer(1000, null);
			        timer.addActionListener((al) -> {
			            
			        	setComponentVisibility(frame, JPanel.class, false);
			        	
			        	panelTrainerDashboard.setVisible(true);
			        	
			        	timer.stop();
			        	
			        });
			        timer.start();
				}else{
					lblWorkoutRoutineStatus.setText(response.StatusText);
				}
				
			}
		});
		btnCreateWorkoutRoutine.setBounds(123, 441, 233, 25);
		panelWorkoutRoutine.add(btnCreateWorkoutRoutine);
		
		panelSelectWorkoutRoutine = new JPanel();
		panelSelectWorkoutRoutine.setLayout(null);
		frame.getContentPane().add(panelSelectWorkoutRoutine, "name_15445555665689");
		
		scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(49, 83, 412, 303);
		panelSelectWorkoutRoutine.add(scrollPane_9);
		
		list_9 = new JList();
		scrollPane_9.setViewportView(list_9);
		
		lblPleaseSelectA_2 = new JLabel("Please Select a Workout Routine");
		lblPleaseSelectA_2.setBounds(140, 12, 238, 15);
		panelSelectWorkoutRoutine.add(lblPleaseSelectA_2);
		
		button_5 = new JButton("Modify");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedWorkoutRoutine = (WorkoutRoutine) list_9.getSelectedValue();

				lblWorkoutRoutineStatus.setText("");
				
				btnCreateWorkoutRoutine.setVisible(false);
				btnSaveChanges_2.setVisible(true);
				
				WorkoutController workoutController = new WorkoutController();
				
				exercises.clear();
				
				for(Exercise exercise: workoutController.getExercises()){
					exercises.addElement(exercise);
				}
				
				 list_8.setModel(exercises);     
				 scrollPane_8.getViewport().removeAll();
				 scrollPane_8.setViewportView(list_8);
				
				 list_8.setSelectionMode(
		                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				 
				 List<Integer> indices = new ArrayList<Integer>();
				 
				 for(Exercise ex : selectedWorkoutRoutine.getExercises()){
					 indices.add(exercises.indexOf(ex));
				 }
				 
				 int[] array = indices.stream().mapToInt(i->i).toArray();
				 list_8.setSelectedIndices(array);
				 
				 
				 textField_35.setText(selectedWorkoutRoutine.getName());
				 
				setComponentVisibility(frame, JPanel.class, false);
				
				panelWorkoutRoutine.setVisible(true);
				
				
			}
		});
		button_5.setBounds(170, 398, 177, 25);
		panelSelectWorkoutRoutine.add(button_5);
		
		JButton btnModifyWorkoutRoutine = new JButton("Modify Workout Routine");
		btnModifyWorkoutRoutine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				WorkoutController workoutController = new WorkoutController();
				
				workoutRoutines.clear();
				
				for(WorkoutRoutine workoutRoutine: workoutController.getWorkoutRoutines()){
					workoutRoutines.addElement(workoutRoutine);
				}
				
				 list_9.setModel(workoutRoutines);     
				 scrollPane_9.getViewport().removeAll();
				 scrollPane_9.setViewportView(list_9);
				
				 setComponentVisibility(frame, JPanel.class, false);
		        	
		        panelSelectWorkoutRoutine.setVisible(true);
			
			}
		});
		btnModifyWorkoutRoutine.setBounds(98, 232, 296, 25);
		panelTrainerDashboard.add(btnModifyWorkoutRoutine);
		
		panelAssignWorkouts = new JPanel();
		panelAssignWorkouts.setLayout(null);
		frame.getContentPane().add(panelAssignWorkouts, "name_16550629449094");
		
		lblPleaseSelect = new JLabel("1. Please Select a Customer");
		lblPleaseSelect.setBounds(49, 56, 244, 15);
		panelAssignWorkouts.add(lblPleaseSelect);
		
		scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(49, 83, 412, 195);
		panelAssignWorkouts.add(scrollPane_10);
		
		JList list_10 = new JList();
		scrollPane_10.setViewportView(list_10);
		
		
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(49, 312, 412, 195);
		panelAssignWorkouts.add(scrollPane_11);
		
		JList list_11 = new JList();
		scrollPane_11.setViewportView(list_11);
		
		lblPleaseSelect_1 = new JLabel("2. Please Select Workout Routines");
		lblPleaseSelect_1.setBounds(49, 285, 380, 15);
		panelAssignWorkouts.add(lblPleaseSelect_1);
		
		lblAssignWorkouts = new JLabel("Assign Workouts");
		lblAssignWorkouts.setBounds(185, 12, 244, 15);
		panelAssignWorkouts.add(lblAssignWorkouts);
		
		JButton btnAssignWorkoutRoutine = new JButton("Assign Workout Routine");
		btnAssignWorkoutRoutine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				customers.clear();
				workoutRoutines.clear();
				
				lblAssignStatus.setText("");
				
				for(Customer customer : UserController.getInstance().getCustomers()){
					customers.addElement(customer);
				}
				
				
				 list_10.setModel(customers);     
				 scrollPane_10.getViewport().removeAll();
				 scrollPane_10.setViewportView(list_10);
				
				 setComponentVisibility(frame, JPanel.class, false);
					
				panelAssignWorkouts.setVisible(true);
			
			}
		});
		btnAssignWorkoutRoutine.setBounds(98, 294, 296, 25);
		panelTrainerDashboard.add(btnAssignWorkoutRoutine);
		
		btnSearchCustomers = new JButton("Search Customers");
		btnSearchCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setComponentVisibility(frame, JPanel.class, false);
	        	
	        	panelSearchCustomers.setVisible(true);
				
			}
		});
		btnSearchCustomers.setBounds(98, 361, 296, 25);
		panelTrainerDashboard.add(btnSearchCustomers);
		
		btnSearchWorkoutroutines = new JButton("Search Workout Routines");
		btnSearchWorkoutroutines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setComponentVisibility(frame, JPanel.class, false);
	        	
	        	panelSearchWorkoutRoutines.setVisible(true);
			}
		});
		btnSearchWorkoutroutines.setBounds(98, 398, 296, 25);
		panelTrainerDashboard.add(btnSearchWorkoutroutines);
		
		list_10.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				selectedCustomer = (Customer)list_10.getSelectedValue();
				
				if(selectedCustomer != null){
				
					WorkoutController workoutController = new WorkoutController();
					
					workoutRoutines.clear();
					
					for(WorkoutRoutine workoutRoutine: workoutController.getWorkoutRoutines()){
						workoutRoutines.addElement(workoutRoutine);
					}
					
					 list_11.setModel(workoutRoutines);     
					 scrollPane_11.getViewport().removeAll();
					 scrollPane_11.setViewportView(list_11);
					 
					 list_11.setSelectionMode(
			                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
					
					 List<Integer> indices = new ArrayList<Integer>();
					 
					 for(WorkoutRoutine wr : selectedCustomer.getWorkoutRoutines()){
						 indices.add(workoutRoutines.indexOf(wr));
					 }
					 
					 int[] array = indices.stream().mapToInt(i->i).toArray();
					 list_11.setSelectedIndices(array);
				 
				}
				
			}

           
        });
		
		lblAssignStatus = new JLabel("");
		lblAssignStatus.setBounds(49, 600, 394, 15);
		panelAssignWorkouts.add(lblAssignStatus);
		
		btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedCustomer = (Customer)list_10.getSelectedValue();
				
				
				
				WorkoutController wc = new WorkoutController();

				List<WorkoutRoutine> selectedWorkoutRoutines =  list_11.getSelectedValuesList();
				
				Response response = null;
				
				response = wc.assignWorkoutRoutines(selectedCustomer, new HashSet<WorkoutRoutine>(selectedWorkoutRoutines));
				
				if(response.isSuccess)
				{
					clearAllTextBoxes(frame);
					
					lblAssignStatus.setText(response.StatusText);
					
					final Timer timer = new Timer(1000, null);
			        timer.addActionListener((al) -> {
			            
			        	setComponentVisibility(frame, JPanel.class, false);
			        	
			        	panelTrainerDashboard.setVisible(true);
			        	
			        	timer.stop();
			        	
			        });
			        timer.start();
				}else{
					lblAssignStatus.setText(response.StatusText);
				}
				
				
			}
		});
		btnAssign.setBounds(170, 545, 177, 25);
		panelAssignWorkouts.add(btnAssign);
		
		panelSearchCustomers = new JPanel();
		panelSearchCustomers.setLayout(null);
		frame.getContentPane().add(panelSearchCustomers, "name_21807554285630");
		
		lblSearchForA = new JLabel("Search for a Customer");
		lblSearchForA.setBounds(170, 5, 244, 15);
		panelSearchCustomers.add(lblSearchForA);
		
		scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(49, 83, 412, 303);
		panelSearchCustomers.add(scrollPane_12);
		
		list_12 = new JList();
		scrollPane_12.setViewportView(list_12);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Search:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(34, 48, 70, 15);
		panelSearchCustomers.add(lblNewLabel_4);
		
		textField_36 = new JTextField();
		textField_36.setBounds(105, 46, 356, 19);
		panelSearchCustomers.add(textField_36);
		textField_36.setColumns(10);
		
		JScrollPane scrollPane_13 = new JScrollPane();
		scrollPane_13.setBounds(49, 463, 412, 147);
		panelSearchCustomers.add(scrollPane_13);
		
		JList list_13 = new JList();
		scrollPane_13.setViewportView(list_13);
		
		JLabel lblNewLabel_5 = new JLabel("Assigned Workouts");
		lblNewLabel_5.setBounds(170, 436, 244, 15);
		panelSearchCustomers.add(lblNewLabel_5);
		
		textField_36.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			   
				  
				
				  
			  }
			  public void removeUpdate(DocumentEvent e) {
			    
				  String searchTerm = textField_36.getText();
				  
				  	WorkoutController wc = new WorkoutController();
				  
					customers.clear();
					
					for(Customer customer : wc.seachCustomers(searchTerm)){
						customers.addElement(customer);
					}
					
					
					 list_12.setModel(customers);     
					 scrollPane_12.getViewport().removeAll();
					 scrollPane_12.setViewportView(list_12);
				  
			  }
			  public void insertUpdate(DocumentEvent e) {
			    
					String searchTerm = textField_36.getText();
					  
				  	WorkoutController wc = new WorkoutController();
				  
					customers.clear();
					
					for(Customer customer : wc.seachCustomers(searchTerm)){
						customers.addElement(customer);
					}
					
					
					 list_12.setModel(customers);     
					 scrollPane_12.getViewport().removeAll();
					 scrollPane_12.setViewportView(list_12);
				  
			  }
			  
			  

			});
		
		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Customer searchedCustomer = (Customer)list_12.getSelectedValue();
				
				workoutRoutines.clear();
				
				for(WorkoutRoutine workoutRoutine : searchedCustomer.getWorkoutRoutines()){
					workoutRoutines.addElement(workoutRoutine);
				}
				
				
				 list_13.setModel(workoutRoutines);     
				 scrollPane_13.getViewport().removeAll();
				 scrollPane_13.setViewportView(list_13);
				 
			}
		});
		btnView.setBounds(170, 398, 177, 25);
		panelSearchCustomers.add(btnView);
		
		panelSearchWorkoutRoutines = new JPanel();
		panelSearchWorkoutRoutines.setLayout(null);
		frame.getContentPane().add(panelSearchWorkoutRoutines, "name_26379538324514");
		
		lblSearchForA_1 = new JLabel("Search for a Workout Routine");
		lblSearchForA_1.setBounds(170, 5, 244, 15);
		panelSearchWorkoutRoutines.add(lblSearchForA_1);
		
		scrollPane_14 = new JScrollPane();
		scrollPane_14.setBounds(49, 83, 412, 303);
		panelSearchWorkoutRoutines.add(scrollPane_14);
		
		list_14 = new JList();
		scrollPane_14.setViewportView(list_14);
		
		label_18 = new JLabel("Search:");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setBounds(34, 48, 70, 15);
		panelSearchWorkoutRoutines.add(label_18);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(105, 46, 356, 19);
		panelSearchWorkoutRoutines.add(textField_37);
		
		scrollPane_15 = new JScrollPane();
		scrollPane_15.setBounds(49, 463, 412, 147);
		panelSearchWorkoutRoutines.add(scrollPane_15);
		
		list_15 = new JList();
		scrollPane_15.setViewportView(list_15);
		
		lblAssignedToCustomers = new JLabel("Assigned To Customers");
		lblAssignedToCustomers.setBounds(170, 436, 244, 15);
		panelSearchWorkoutRoutines.add(lblAssignedToCustomers);
		
		button_6 = new JButton("View");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkoutRoutine workoutRoutine = (WorkoutRoutine)list_14.getSelectedValue();
				
				WorkoutController wc = new WorkoutController();
				
				customers.clear();
				
				for(Customer customer : wc.getCustomersAssignedWorkoutRoutine(workoutRoutine)){
					customers.addElement(customer);
				}
				
				
				 list_15.setModel(customers);     
				 scrollPane_15.getViewport().removeAll();
				 scrollPane_15.setViewportView(list_15);
				
			}
		});
		button_6.setBounds(170, 398, 177, 25);
		panelSearchWorkoutRoutines.add(button_6);
		
		textField_37.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			   
				  
				
				  
			  }
			  public void removeUpdate(DocumentEvent e) {
			    
				  String searchTerm = textField_37.getText();
				  
				  	WorkoutController wc = new WorkoutController();
				  
					workoutRoutines.clear();
					
					for(WorkoutRoutine workoutRoutine : wc.searchWorkoutRoutines(searchTerm)){
						workoutRoutines.addElement(workoutRoutine);
					}
					
					
					 list_14.setModel(workoutRoutines);     
					 scrollPane_14.getViewport().removeAll();
					 scrollPane_14.setViewportView(list_14);
				  
			  }
			  public void insertUpdate(DocumentEvent e) {
			    
				  String searchTerm = textField_37.getText();
				  
				  	WorkoutController wc = new WorkoutController();
				  
					workoutRoutines.clear();
					
					for(WorkoutRoutine workoutRoutine : wc.searchWorkoutRoutines(searchTerm)){
						workoutRoutines.addElement(workoutRoutine);
					}
					
					
					 list_14.setModel(workoutRoutines);     
					 scrollPane_14.getViewport().removeAll();
					 scrollPane_14.setViewportView(list_14);
				  
			  }
			  
			  

			});
		
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
