package guiStuff;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseAdaptor;
import org.ingredients.*;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddDrink extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtamounttype;
	private JTextField txtamounttype_1;
	private JTextField txtSolidIngredient;
	private Recipe userInput;
	private JTextArea textArea;
	private String output;
	private JEditorPane editorPane;
	private JTextField txtHangoverPotential;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(DataBaseAdaptor db) {
		try {
			AddDrink dialog = new AddDrink(db);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public AddDrink(DataBaseAdaptor db) {
		setTitle("Add Drink");
		
		//initializing the user recipe
		userInput = new Recipe();
		
		setBounds(100, 100, 675, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			//had to refactor this to a field so i can access it in the action listners
			textArea = new JTextArea();
			textArea.setBounds(10, 36, 165, 281);
			textArea.setWrapStyleWord(true);
			contentPanel.add(textArea);
		}
		{
			txtName = new JTextField();
			txtName.setBounds(185, 38, 289, 20);
			txtName.setHorizontalAlignment(SwingConstants.LEFT);
			txtName.setText("Name");
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			txtamounttype = new JTextField();
			txtamounttype.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtamounttype.selectAll();
				}
			});
			txtamounttype.setBounds(185, 69, 289, 20);
			txtamounttype.setText("Amount,Name");
			contentPanel.add(txtamounttype);
			txtamounttype.setColumns(10);
		}
		{
			JButton btnAddAlc = new JButton("Add Alcohol");
			btnAddAlc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//check for proper formatting
					//add alc to recipe and dipslay
					Liquid curr = new Liquid();
					
					if(curr.formatGood(txtamounttype.getText()) == true){
						curr.parse(txtamounttype.getText());
						curr.setAlcohol(true);
						userInput.getLiquids().add(curr);
						output = output + curr.getAmount() + " " + curr.getName() + System.lineSeparator();
						textArea.setText(output);
						
					}
					else{
						JOptionPane.showMessageDialog(null, 
								"Please use correct formatting:", 
								"Amount (include units in amount), Name", 
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
			btnAddAlc.setBounds(484, 67, 114, 23);
			contentPanel.add(btnAddAlc);
		}
		{
			txtamounttype_1 = new JTextField();
			txtamounttype_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtamounttype_1.selectAll();
				}
			});
			txtamounttype_1.setBounds(185, 96, 289, 20);
			txtamounttype_1.setText("Amount,Name");
			contentPanel.add(txtamounttype_1);
			txtamounttype_1.setColumns(10);
		}
		{
			JButton btnAddLiquid = new JButton("Add Liquid");
			btnAddLiquid.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//check for proper formatting
					//add liquid to recipe and dipslay
					Liquid curr = new Liquid();
					
					if(curr.formatGood(txtamounttype_1.getText()) == true){
						curr.parse(txtamounttype_1.getText());
						curr.setAlcohol(false);
						userInput.getLiquids().add(curr);
						output = output + curr.getAmount() + " " + curr.getName() + System.lineSeparator();
						textArea.setText(output);
						
						//display recipe in box
					}
					else{
						JOptionPane.showMessageDialog(null, 
								"Please use correct formatting:", 
								"Amount (include units in amount), Name", 
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
			btnAddLiquid.setBounds(484, 95, 114, 23);
			contentPanel.add(btnAddLiquid);
		}
		{
			txtSolidIngredient = new JTextField();
			txtSolidIngredient.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtSolidIngredient.selectAll();
				}
			});
			txtSolidIngredient.setBounds(185, 126, 289, 20);
			txtSolidIngredient.setText("Amount,Name");
			contentPanel.add(txtSolidIngredient);
			txtSolidIngredient.setColumns(10);
		}
		{
			JButton btnAddSolid = new JButton("Add Solid");
			btnAddSolid.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//check for proper formatting
					//add solid to recipe and dipslay
					Solid curr = new Solid();
					
					if(curr.formatGood(txtSolidIngredient.getText()) == true){
						curr.parse(txtSolidIngredient.getText());
						userInput.getSolids().add(curr);
						output = output + curr.getAmount() + " " + curr.getName() + System.lineSeparator();
						textArea.setText(output);
						//display recipe in box
					}
					else{
						JOptionPane.showMessageDialog(null, 
								"Please use correct formatting:", 
								"Amount (include units in amount), Name", 
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
			btnAddSolid.setBounds(484, 123, 114, 23);
			contentPanel.add(btnAddSolid);
		}
		
		String [] glasses = { "Select Glass" , "Highball" , "Lowball", "Martini", "Margarita", "Shot" , "Daquiri" };
		JComboBox comboBox = new JComboBox(glasses);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Select Glass")){
					JOptionPane.showMessageDialog(null, 
							"Please Select a Glass Type",
							"Error",
							JOptionPane.PLAIN_MESSAGE);
				}
				else{
					userInput.getGlass().setShape(comboBox.getSelectedItem().toString());
					output = output + comboBox.getSelectedItem().toString() + " Glass Selected" + System.lineSeparator();
					textArea.setText(output);
				}
				
			}
		});

		comboBox.setBounds(185, 157, 289, 20);
		contentPanel.add(comboBox);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(185, 242, 289, 75);
		contentPanel.add(editorPane);
		
		JLabel lblPleaseEnterDirections = new JLabel("Please enter directions below:");
		lblPleaseEnterDirections.setForeground(new Color(255, 255, 255));
		lblPleaseEnterDirections.setBackground(new Color(0, 128, 0));
		lblPleaseEnterDirections.setOpaque(true);
		lblPleaseEnterDirections.setBounds(185, 217, 289, 14);
		contentPanel.add(lblPleaseEnterDirections);
		
		JButton btnDirectionsComplete = new JButton("Directions Complete");
		btnDirectionsComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String direct = "";
				direct = editorPane.getText();
				userInput.setDirectString(direct);
				if(direct.length() <=225){
					String bits[] = direct.split("\n");
					userInput.setDirections(bits);
					output = output + direct;
					textArea.setText(output);
				}
				else{
					JOptionPane.showMessageDialog(null, 
							"Directions must be less that 225 Characters, Try Again", 
							"Error",
							JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		btnDirectionsComplete.setBounds(484, 242, 165, 23);
		contentPanel.add(btnDirectionsComplete);
		
		JButton btnClearDirections = new JButton("Clear Directions");
		btnClearDirections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.setText("");
			}
		});
		btnClearDirections.setBounds(484, 281, 165, 23);
		contentPanel.add(btnClearDirections);
		{
			txtHangoverPotential = new JTextField();
			txtHangoverPotential.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtHangoverPotential.selectAll();
				}
			});
			txtHangoverPotential.setText("Hangover Potential");
			txtHangoverPotential.setBounds(185, 186, 289, 20);
			contentPanel.add(txtHangoverPotential);
			txtHangoverPotential.setColumns(10);
		}
		
		JButton btnAddName = new JButton("Add Name");
		btnAddName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				userInput.setName(name);
				output = name + System.lineSeparator();
				textArea.setText(output);
			}
		});
		btnAddName.setBounds(484, 37, 114, 23);
		contentPanel.add(btnAddName);
		{
			JButton btnAddHp = new JButton("Add HP");
			btnAddHp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String hp = txtHangoverPotential.getText();
					userInput.setHangoverPotential(hp);
					output = output +  hp + System.lineSeparator();
					textArea.setText(output);
				}
			});
			btnAddHp.setBounds(484, 185, 114, 23);
			contentPanel.add(btnAddHp);
		}
		
		JLabel lblAdddrinkbackground = new JLabel("");
		lblAdddrinkbackground.setIcon(new ImageIcon("src/AddDrinkBack.jpg"));
		lblAdddrinkbackground.setBounds(0, 0, 659, 328);
		contentPanel.add(lblAdddrinkbackground);
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(userInput.getName().isEmpty()){
							JOptionPane.showMessageDialog(null, 
									"Please enter a valid drink name", 
									"Error",
									JOptionPane.PLAIN_MESSAGE);
						}
						else{
							String[] temp = userInput.giveStrings();
							//adds in the new drink using the proper formatted strings
							db.addDrink(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5],temp[6]);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
