package guiStuff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ingredients.Liquid;
import org.ingredients.Solid;

import controller.Recipe;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class AddDrink extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtamounttype;
	private JTextField txtamounttype_1;
	private JTextField txtSolidIngredient;
	private Recipe userInput;
	

	/**
	 * Launch the application.
	 */
	public static void main() {
		try {
			AddDrink dialog = new AddDrink();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddDrink() {
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 36, 116, 170);
			textArea.setWrapStyleWord(true);
			contentPanel.add(textArea);
		}
		{
			txtName = new JTextField();
			txtName.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//figure out how to detect an enter in the field
				}
			});
			txtName.setBounds(136, 38, 289, 20);
			txtName.setHorizontalAlignment(SwingConstants.LEFT);
			txtName.setText("Name");
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			txtamounttype = new JTextField();
			txtamounttype.setBounds(136, 68, 289, 20);
			txtamounttype.setText("Name,Color,Temperature,Amount");
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
						
						//display recipe in box
					}
					else{
						JOptionPane.showMessageDialog(null, 
								"Please use correct formatting:", 
								"Name,Color,Temp,Amount", 
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
			btnAddAlc.setBounds(435, 67, 89, 23);
			contentPanel.add(btnAddAlc);
		}
		{
			txtamounttype_1 = new JTextField();
			txtamounttype_1.setBounds(136, 96, 289, 20);
			txtamounttype_1.setText("Name,Color,Temperature,Amount");
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
						
						//display recipe in box
					}
					else{
						JOptionPane.showMessageDialog(null, 
								"Please use correct formatting:", 
								"Name,Color,Temp,Amount", 
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
			btnAddLiquid.setBounds(435, 95, 81, 23);
			contentPanel.add(btnAddLiquid);
		}
		{
			txtSolidIngredient = new JTextField();
			txtSolidIngredient.setBounds(136, 124, 289, 20);
			txtSolidIngredient.setText("Name,Amount,Optional(Y/N?)");
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
						
						//display recipe in box
					}
					else{
						JOptionPane.showMessageDialog(null, 
								"Please use correct formatting:", 
								"Name,Amount,Optional?(Y,N)", 
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
			btnAddSolid.setBounds(435, 123, 77, 23);
			contentPanel.add(btnAddSolid);
		}
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//add in complete new recipie and exit window
						dispose();
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
