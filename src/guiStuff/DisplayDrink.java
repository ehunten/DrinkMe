package guiStuff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import controller.DataBaseAdaptor;
import java.awt.Font;
import java.awt.Color;

public class DisplayDrink extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.

	public static void main(DataBaseAdaptor db, String name) {
		try {
			DisplayDrink dialog = new DisplayDrink(db,name);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	 * Create the dialog.
	 */

	//public DisplayDrink() {
		//setTitle("Drink");
		
	public DisplayDrink(DataBaseAdaptor db, String name) {
		setTitle("Drink Me\r\n");

		setBounds(100, 100, 450, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String[] temp = db.getDrinkByName(name);
		JLabel label = new JLabel("");
		String Display;
		
		Display = "<html><div style = 'text-align: center;'>";
		
		if(temp[0] == null || temp[0].equals("")){
			Display = Display + "<b>Virgin " + name+"</b>";
		}else{
			Display = Display +"<b>"+name+"</b></div><br><b>Alcohol:</b> "+temp[0];
		}
		if(temp[1] == null || temp[1].equals("")){
			Display = Display + "<br><b>Mixer:</b> none";
		}else{
			Display = Display + "<br><b>Mixer:</b> "+temp[1];
		}
		if(temp[2] == null || temp[2].equals("")){
			Display = Display + "<br><b>Solids:</b> none";
		}else{
			Display = Display + "<br><b>Solids:</b> "+temp[2];
		}
		if(temp[3] == null || temp[3].equals("")){
			Display = Display + "<br><b>Glass:</b> Straight From the Bottle";
		}else{
			Display = Display + "<br><b>Glass:</b> "+ temp[3];
		}
				
		Display = Display +	"<br><br><div style = 'text-align: center;'><u><b>Directions</u></b>";
				
		if(temp[4] == null || temp[3].equals("")){
					Display = Display + "<br>No Directions Given</div>";
		}else{
					Display = Display +"<br>"+ temp[4] + "</div>";
		}
		if(temp[5] == null || temp[5].equals("")){
			Display = Display + "</html>";
		}else{
			Display = Display + "<br><b>Hangover?</b> "+ temp[5]+ "</html>";;
		}		
		
		if(temp[3].equals("Highball")){
			label.setIcon(new ImageIcon("src/High.jpg"));
		}else if (temp[3].equals("Martini") || temp[3].equals("Cocktail glass")){
			label.setIcon(new ImageIcon("src/Martini.jpg"));
		}else if (temp[3].equals("Margarita")){
			label.setIcon(new ImageIcon("src/mar.jpg"));
		}else if (temp[3].equals("Lowball")){
			label.setIcon(new ImageIcon("src/lowballer.jpg"));
		}else if (temp[3].equals("Shot")){
			label.setIcon(new ImageIcon("src/Shot.jpg"));
		}else if (temp[3].equals("Daquiri")){
			label.setIcon(new ImageIcon("src/Daiquiri.png"));
		}
		
		
		label.setBounds(31, 33, 156, 206);
		contentPanel.add(label);
		{
			JLabel lblNewLabel_1 = new JLabel(Display);
			lblNewLabel_1.setForeground(Color.BLUE);
			lblNewLabel_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
			lblNewLabel_1.setBounds(210, 0, 214, 275);
			contentPanel.add(lblNewLabel_1);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/Gray.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 297);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
