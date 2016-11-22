package controller;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class DrinkMeGUI extends JFrame{

	//hannahs totally unrelated git notes
	//Git bash into Drink ME
	//git checkout -b hannah1
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
	
	
	//private University univ;
	private JMenuBar menuBar;		
	private JMenu searchMenu;		
	private JMenu fileMenu;
	private JMenu viewMenu;

	
	private JMenuItem fileAddDrink;
	private JMenuItem fileRemoveDrink;
	private JMenuItem searchIngredient;
	private JMenuItem searchName;
	private JMenuItem viewList;
	private JMenuItem viewRandom;
	
	
	public DrinkMeGUI(String windowTitle) 
	{
		super(windowTitle);

		
//		this.univ = new University();
//		this.univ = univ;

		setSize(700, 700);
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(new JLabel("<HTML><center>Welcome to the Drink Me Cocktail System." +
				"<BR>Choose an action from the above menus.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	
	public void buildGUI() 
	{
		menuBar = new JMenuBar();
     	
		// Employee Student Menu
		
		fileMenu = new JMenu("File");
		searchMenu = new JMenu("Search");
		viewMenu = new JMenu("View");

		
		fileAddDrink = new JMenuItem("Add Drink");
		fileRemoveDrink = new JMenuItem("Remove Drink");
		searchIngredient = new JMenuItem("by Ingredient");
		searchName = new JMenuItem("by Name");
		viewList = new JMenuItem("Full Drink List");
		viewRandom = new JMenuItem("Random Drink");
		
		
		fileAddDrink.addActionListener(new MenuListener());
		fileRemoveDrink.addActionListener(new MenuListener());
		searchIngredient.addActionListener(new MenuListener());
		searchName.addActionListener(new MenuListener());
		viewList.addActionListener(new MenuListener());
		viewRandom.addActionListener(new MenuListener());
		
	    fileMenu.add(fileAddDrink);
	    fileMenu.add(fileRemoveDrink);
	    searchMenu.add(searchIngredient);
	    searchMenu.add(searchName);
	    viewMenu.add(viewList);
	    viewMenu.add(viewRandom);

			
	    menuBar.add(fileMenu);
		menuBar.add(searchMenu);
		menuBar.add(viewMenu);
	
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(fileAddDrink))
			{
				handleFileAddDrink();	
			}
			else if(source.equals(fileRemoveDrink))
			{
				handleFileRemoveDrink();
			}
			else if(source.equals(searchIngredient)){
				handleSearchIngredient();
			}
			else if(source.equals(searchName)){
				handleSearchName();
			}
			else if(source.equals(viewList)){
				handleViewList();
			}
			else if(source.equals(viewRandom)){
				handleViewRandom();
			}

		}
		
		private void handleFileAddDrink(){
			
		}
		
		private void handleFileRemoveDrink(){
			
		}
		
		private void handleSearchIngredient(){
			
		}
		
		private void handleSearchName(){
			
		}
		
		private void handleViewList(){
			
		}
		
		private void handleViewRandom(){
			
		}

	}
		

}