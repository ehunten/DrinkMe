package guiStuff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseAdaptor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RemoveDrink extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;

	/**
	 * Launch the application.
	 
	public static void main(DataBaseAdaptor db) {
		try {
			RemoveDrink dialog = new RemoveDrink(db);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	 * Create the dialog.
	 */
	public RemoveDrink(DataBaseAdaptor db) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPleaseEnterThe = new JLabel("Please Enter the Name of");
			lblPleaseEnterThe.setForeground(new Color(255, 0, 0));
			lblPleaseEnterThe.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 22));
			lblPleaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
			lblPleaseEnterThe.setBounds(10, 11, 414, 38);
			contentPanel.add(lblPleaseEnterThe);
		}
		{
			JLabel lblTheDrinkTo = new JLabel("the Drink to Be Removed");
			lblTheDrinkTo.setForeground(new Color(255, 0, 0));
			lblTheDrinkTo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTheDrinkTo.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 22));
			lblTheDrinkTo.setBounds(10, 48, 414, 22);
			contentPanel.add(lblTheDrinkTo);
		}
		{
			txtName = new JTextField();
			txtName.setText("Name");
			txtName.setBounds(146, 81, 149, 20);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			JLabel lblRemovebackground = new JLabel("");
			lblRemovebackground.setIcon(new ImageIcon("src/RemoveDrinkBack.jpg"));
			lblRemovebackground.setBounds(0, 0, 434, 228);
			contentPanel.add(lblRemovebackground);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//remove recpipe from database and exit
						String remove = txtName.getText();
						if(remove.equals("Name")){
							JOptionPane.showMessageDialog(null, 
									"Please Enter a Drink Name", 
									"Error",
									JOptionPane.PLAIN_MESSAGE);
						}
						else{
							//DataBaseAdaptor db = new DataBaseAdaptor();
							String[] temp = db.getDrinkByName(remove);
							if(temp[0] != null){
								db.dropDrink(remove);
								JOptionPane.showMessageDialog(null, 
										"The Drink "+ remove + "has been Removed.", 
										"Success",
										JOptionPane.PLAIN_MESSAGE);
								dispose();
							}
							else{
								JOptionPane.showMessageDialog(null, 
										"Drink Does Not Exsit, Please Try Again", 
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
