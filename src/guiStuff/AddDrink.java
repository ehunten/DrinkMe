package guiStuff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AddDrink extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtamounttype;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			txtName = new JTextField();
			txtName.setText("Name");
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.insets = new Insets(0, 0, 5, 5);
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.gridx = 6;
			gbc_txtName.gridy = 1;
			contentPanel.add(txtName, gbc_txtName);
			txtName.setColumns(10);
		}
		{
			txtamounttype = new JTextField();
			txtamounttype.setText("(amount,type)");
			GridBagConstraints gbc_txtamounttype = new GridBagConstraints();
			gbc_txtamounttype.insets = new Insets(0, 0, 0, 5);
			gbc_txtamounttype.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtamounttype.gridx = 6;
			gbc_txtamounttype.gridy = 2;
			contentPanel.add(txtamounttype, gbc_txtamounttype);
			txtamounttype.setColumns(10);
		}
		{
			JButton btnAddAlc = new JButton("Add Alc");
			GridBagConstraints gbc_btnAddAlc = new GridBagConstraints();
			gbc_btnAddAlc.gridx = 7;
			gbc_btnAddAlc.gridy = 2;
			contentPanel.add(btnAddAlc, gbc_btnAddAlc);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
