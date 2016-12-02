package guiStuff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseAdaptor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ByName extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(DataBaseAdaptor db) {
		try {
			ByName dialog = new ByName(db);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ByName(DataBaseAdaptor db) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSearchByName = new JLabel("Search By Name:");
			lblSearchByName.setForeground(new Color(0, 255, 255));
			lblSearchByName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 25));
			lblSearchByName.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearchByName.setBounds(0, 11, 434, 35);
			contentPanel.add(lblSearchByName);
		}
		{
			txtName = new JTextField();
			txtName.setText("Name");
			txtName.setBounds(145, 72, 137, 20);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			JLabel lblSearchByName_1 = new JLabel("");
			lblSearchByName_1.setIcon(new ImageIcon("src/color7.PNG"));
			lblSearchByName_1.setBounds(0, 0, 434, 228);
			contentPanel.add(lblSearchByName_1);
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
							String[] temp = db.getDrinkByName(name);
							if(temp[0] != null){
								DisplayDrink disp = new DisplayDrink(db,name);
								disp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								disp.setVisible(true);
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
