package guiStuff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseAdaptor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JOptionPane;

import java.awt.Color;

public class ViewMultiple extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public ArrayList<String> names;

	/**
	 * Launch the application.
	 
	public static void main(DataBaseAdaptor db) {
		try {
			ViewMultiple dialog = new ViewMultiple(db);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	 * Create the dialog.
	 */
	public ViewMultiple(DataBaseAdaptor db,ArrayList<String> drinksWith) {
		setTitle("View");
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 0, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		
		//four collums and 6 rows availible. after 24 drinks throw error.
		int x = 0;
		int y = 0;
		
		
		JButton[] buttons = new JButton[24];
		if(drinksWith.size() == 0){
			
			names = db.getAllDrinks();
		}
		else{
			names = drinksWith;
			
		}
		
	
		if(names.size() > 24){
			JOptionPane.showMessageDialog(null, 
					"Exceeds Maximum number of recipes", 
					"please remove recipes", 
					JOptionPane.PLAIN_MESSAGE);
			dispose();
		}
		
		for(int i=0; i<names.size(); ++i){
			
			JButton btnDrink = new JButton(names.get(i));
			buttons[i] = btnDrink;
			//JButton btnDrink = new JButton(names.get(i));
			btnDrink.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int found = 0;
					Object src = e.getSource();
					for(int j=0; j<buttons.length; ++j){
						if(src == buttons[j]){
							found = j;
						}
					}
					DisplayDrink d = new DisplayDrink(db,names.get(found));
					//System.out.println(names.get(found));
					//yay button name is passed in correctly
					d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					d.setVisible(true);
				}
			});
			GridBagConstraints gbc_btnDrink = new GridBagConstraints();
			gbc_btnDrink.insets = new Insets(0, 0, 5, 5);
			gbc_btnDrink.gridx = x;
			gbc_btnDrink.gridy = y;
			contentPanel.add(btnDrink, gbc_btnDrink);
			if(y==6){
				y = -1;
				x = x+2;
			}
			y = y+1;
		
		}
		//contentPanel.pack();
		
		
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
