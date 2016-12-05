package guiStuff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseAdaptor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ByIngred extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JRadioButton rdbtnAlcohol;
	private JRadioButton rdbtnMixer;

	/**
	 * Launch the application.

	public static void main(DataBaseAdaptor db) {
		try {
			ByIngred dialog = new ByIngred(db);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 * Create the dialog.
	 */
	public ByIngred(DataBaseAdaptor db) {
		setTitle("Search By Liqiud Type");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblChooseAnIngredient = new JLabel("Choose a liquid type");
			lblChooseAnIngredient.setHorizontalAlignment(SwingConstants.CENTER);
			lblChooseAnIngredient.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 25));
			lblChooseAnIngredient.setBounds(0, 11, 434, 35);
			contentPanel.add(lblChooseAnIngredient);
		}
		
		rdbtnAlcohol = new JRadioButton("Alcohol");
		rdbtnAlcohol.setBounds(148, 53, 65, 23);
		contentPanel.add(rdbtnAlcohol);
		
		rdbtnMixer = new JRadioButton("Mixer");
		rdbtnMixer.setBounds(225, 53, 58, 23);
		contentPanel.add(rdbtnMixer);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 21));
		lblEnterName.setBounds(0, 97, 434, 29);
		contentPanel.add(lblEnterName);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(177, 137, 86, 20);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		{
			JLabel lblByIngredient = new JLabel("");
			lblByIngredient.setIcon(new ImageIcon("src/color9.PNG"));
			lblByIngredient.setBounds(0, 0, 434, 228);
			contentPanel.add(lblByIngredient);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = txtName.getText();
						if(name.equals("Name")){
							JOptionPane.showMessageDialog(null, 
									"Please Enter a Drink Name", 
									"Error",
									JOptionPane.PLAIN_MESSAGE);
						}
						else{
							//DataBaseAdaptor db = new DataBaseAdaptor();
							if(rdbtnAlcohol.isSelected() == true){
								ArrayList<String> temp = db.getDrinkByAlcohol(name);
								if(temp.size() != 0){
									if(temp.size() == 1){
										DisplayDrink disp = new DisplayDrink(db,name);
										disp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
										disp.setVisible(true);
										dispose();
									}
									else{
										ViewMultiple view = new ViewMultiple(db,temp);
										view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
										view.setVisible(true);
										dispose();
									}
								}
								else{
									JOptionPane.showMessageDialog(null, 
											"No Drinks with that Alcohol found", 
											"Error",
											JOptionPane.PLAIN_MESSAGE);
								}
							}
							else if(rdbtnMixer.isSelected() == true){
								ArrayList<String> temp = db.getDrinkByMixer(name);
								if(temp.size() != 0){
									if(temp.size() == 1){
										DisplayDrink disp = new DisplayDrink(db,name);
										disp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
										disp.setVisible(true);
										dispose();
									}
									else{
										//display multiple drinks at once 
									}
								}
								else{
									JOptionPane.showMessageDialog(null, 
											"No Drinks with that Mixer found", 
											"Error",
											JOptionPane.PLAIN_MESSAGE);
								}
							}
							else{
								JOptionPane.showMessageDialog(null, 
										"Please select a Type of Liquid", 
										"Error",
										JOptionPane.PLAIN_MESSAGE);
							}
							
						}
						//dispose();

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
