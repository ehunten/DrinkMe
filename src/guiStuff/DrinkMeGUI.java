package guiStuff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrinkMeGUI extends JFrame {
	
	//hannahs totally unrelated git notes
	//Git bash into Drink ME
	//git checkout hannahbranch
	//git pull
	//git fetch
	//git merge master
	// lots of work
	//git pull
	//git fetch
	//git merge master
	//git add *
	//git commit -m "messsage contents"
	//git push set-upstream origin hannah1

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
	 */
	public DrinkMeGUI() {
		setTitle("Drink Me");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAddDrink = new JMenuItem("Add Drink");
		mntmAddDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDrink d = new AddDrink();
				d.main();
			}
		});
		mnFile.add(mntmAddDrink);
		
		JMenuItem mntmRemoveDrink = new JMenuItem("Remove Drink");
		mntmRemoveDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveDrink r = new RemoveDrink();
				r.main();
			}
		});
		mnFile.add(mntmRemoveDrink);
		
		JMenu mnSearch = new JMenu("Search");
		menuBar.add(mnSearch);
		
		JMenuItem mntmByIngredient = new JMenuItem("By Ingredient");
		mntmByIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ByIngred b = new ByIngred();
				b.main();
			}
		});
		mnSearch.add(mntmByIngredient);
		
		JMenuItem mntmByName = new JMenuItem("By Name");
		mntmByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ByName n = new ByName();
				n.main();
			}
		});
		mnSearch.add(mntmByName);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmViewAll = new JMenuItem("View All");
		mntmViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAll  v = new ViewAll();
				v.main();
			}
		});
		mnView.add(mntmViewAll);
		
		JMenuItem mntmViewRandom = new JMenuItem("View Random");
		mntmViewRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewRandom w = new ViewRandom();
				w.main();
			}
		});
		mnView.add(mntmViewRandom);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Drink Me Cocktail Picking System");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcomeToThe, BorderLayout.NORTH);
		
		JLabel lblPleaseChooseAn = new JLabel("Please choose an Action from the  Menus");
		lblPleaseChooseAn.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPleaseChooseAn, BorderLayout.CENTER);
	}
}
