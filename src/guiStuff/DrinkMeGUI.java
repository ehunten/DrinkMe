package guiStuff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DataBaseAdaptor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Color;

public class DrinkMeGUI extends JFrame {
	
	//hannahs totally unrelated git notes
	//Git bash into Drink ME
	//git checkout hannahbranch
	
	//git fetch
	//git merge master
	// lots of work
	
	//git fetch
	//git merge origin/master
	//git add *
	//git commit -m "messsage contents"
	//git push --set-upstream origin hannah1

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinkMeGUI frame = new DrinkMeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DrinkMeGUI() throws SQLException {
		DataBaseAdaptor db = new DataBaseAdaptor();
		setTitle("Drink Me");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAddDrink = new JMenuItem("Add Drink");
		mntmAddDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDrink d = new AddDrink(db);
				d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				d.setVisible(true);
				//d.main(db);
			}
		});
		mnFile.add(mntmAddDrink);
		
		JMenuItem mntmRemoveDrink = new JMenuItem("Remove Drink");
		mntmRemoveDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveDrink r = new RemoveDrink(db);
				r.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				r.setVisible(true);
			}
		});
		mnFile.add(mntmRemoveDrink);
		
		JMenu mnSearch = new JMenu("Search");
		menuBar.add(mnSearch);
		
		JMenuItem mntmByIngredient = new JMenuItem("By Ingredient");
		mntmByIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ByIngred b = new ByIngred(db);
				b.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				b.setVisible(true);
			}
		});
		mnSearch.add(mntmByIngredient);
		
		JMenuItem mntmByName = new JMenuItem("By Name");
		mntmByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ByName n = new ByName(db);
				n.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				n.setVisible(true);
			}
		});
		mnSearch.add(mntmByName);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmViewAll = new JMenuItem("View All");
		mntmViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMultiple  v = new ViewMultiple(db);
				v.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				v.setVisible(true);
			}
		});
		mnView.add(mntmViewAll);
		
		JMenuItem mntmViewRandom = new JMenuItem("View Random");
		mntmViewRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "";
				//get a random name and pass to display drink
				//how to get random name from database?
				DisplayDrink w = new DisplayDrink(db,name);
				w.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				w.setVisible(true);
			}
		});
		mnView.add(mntmViewRandom);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseChooseAn = new JLabel("Please choose an Action from the Above Menus");
		lblPleaseChooseAn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseChooseAn.setBounds(5, 400, 574, 40);
		lblPleaseChooseAn.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPleaseChooseAn);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Drink Me Cocktail Picking System");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Rage Italic", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 28, 574, 32);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");	
		lblNewLabel_1.setIcon(new ImageIcon("src/mainBack.jpg"));

		lblNewLabel_1.setBounds(0, 11, 584, 429);
		contentPane.add(lblNewLabel_1);

	}
}
