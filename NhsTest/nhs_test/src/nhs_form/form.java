package nhs_form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import nhs_form.Reg_amount.Frequency;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class form {

	private JFrame frame;
	private JTextField field_name;
	private JTextField field_amount;
	private String name;
	private String amount;
	private Frequency frequency;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form window = new form();
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
	public form() {
		initialize();
	}
	
	//converts the dropdown index into an enum value, so that it can be used in the constructor
	public void setFrequency(int pFreq) {
		switch (pFreq) {
			case 0:
				this.frequency = Frequency.WEEK;
				break;
			case 1:
				this.frequency = Frequency.TWO_WEEK;
				break;
			case 2:
				this.frequency = Frequency.FOUR_WEEK;
				break;
			case 3:
				this.frequency = Frequency.MONTH;
				break;
			case 4:
				this.frequency = Frequency.QUARTER;
				break;
			case 5: 
				this.frequency = Frequency.YEAR;
				break;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//the array used to create the dropdown menu
		String[] freq_types = {
				"WEEK",
				"TWO_WEEK",
				"FOUR_WEEK",
				"MONTH",
				"QUARTER",
				"YEAR"
		};
		
		//the below code creates the form items, sometimes including event handlers for when they are interacted with
		frame = new JFrame();
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNhsForm = new JLabel("NHS Form");
		lblNhsForm.setBounds(212, 11, 71, 14);
		frame.getContentPane().add(lblNhsForm);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(41, 56, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(41, 104, 46, 14);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblFrequency = new JLabel("Frequency:");
		lblFrequency.setBounds(41, 152, 61, 14);
		frame.getContentPane().add(lblFrequency);
		
		field_name = new JTextField();
		field_name.setBounds(131, 53, 86, 20);
		frame.getContentPane().add(field_name);
		field_name.setColumns(10);
		
		field_amount = new JTextField();
		field_amount.setBounds(131, 101, 86, 20);
		frame.getContentPane().add(field_amount);
		field_amount.setColumns(10);
		
		JComboBox field_freq = new JComboBox(freq_types);
		field_freq.setModel(new DefaultComboBoxModel(freq_types));
		field_freq.setBounds(131, 149, 86, 20);
		frame.getContentPane().add(field_freq);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//the following code runs if the submit button is clicked
				name = field_name.getText();
				amount = field_amount.getText();
				//this value needs to be converted, which is better done in its own method
				setFrequency(field_freq.getSelectedIndex());
				
				Reg_amount r = new Reg_amount(name, amount, frequency);
			}
		});
		btnSubmit.setBounds(128, 227, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//resets the form values once the reset button is clicked
				field_name.setText(null);
				field_amount.setText(null);
				field_freq.setSelectedIndex(0);
			}
		});
		btnReset.setBounds(278, 227, 89, 23);
		frame.getContentPane().add(btnReset);
	}
}
