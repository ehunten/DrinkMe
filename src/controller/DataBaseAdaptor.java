package controller;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAdaptor {

	Connection c = null;
	Statement stmt = null;
	
	public DataBaseAdaptor() throws SQLException {
//	public static void main( String args[] ) throws SQLException {
		//Connection c = null;
		//Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:final.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			/*stmt = c.createStatement();
			String sql = "CREATE TABLE drinks" 
					+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, " 
					+ "name varchar(50), "
					+ "alcohol varchar(255), " 
					+ "mixer varchar(255), " 
					+ "solid varchar(255), "
					+ "directions varchar(255))";
			stmt.executeUpdate(sql);
			stmt.close(); 	*/
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		//System.out.println("Table created successfully");
		

		
	     // stmt.close();
	      //c.close();
	}
	
	public static void main(String[] args) throws SQLException {
		DataBaseAdaptor db = new DataBaseAdaptor();
		db.getAllDrinks();
		System.out.println("----------------");
		db.addDrink("0", "0", "0", "0", "0", "0");
		db.getAllDrinks();
		System.out.println("----------------");
		db.dropDrink("0");
		db.getAllDrinks();
		System.out.println("done");
	}
	
	public void createBasicDrinkDB() {
		try {
			stmt = c.createStatement();
		//////CREATE TABLE
			String sql = "CREATE TABLE drinks" 
					+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, " 
					+ "name varchar(50), "
					+ "alcohol varchar(255), " 
					+ "mixer varchar(255), " 
					+ "solid varchar(255), "
					+ "glass vachar(255), "
					+ "directions varchar(255))";
			stmt.executeUpdate(sql);

			///////INSERT DRINKS
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions) "
					+ "VALUES "
					+ "('Whiskey Sour', '1.5oz whiskey', '1oz lemon juice, 2oz water',"
					+ "'1 cube sugar, 3-4 ice cubes', 'Lowball', 'Crush sugar cube with mortar, add lemon juice and then"
					+ "dilute with water. Shake with whiskey and pour over ice.')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions) "
					+ "VALUES "
					+ "('Long Island Iced Tea', '.5oz Vodka, .5oz Rum, .5oz Tequila, .5oz Gin, .5oz Triple Sec', '1oz lemon juice, splash of cola',"
					+ "'ice, lemon spiral', 'Highball', "
					+ "'Add all ingredients over ice, then stir gently, add lemon spiral and serve.')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions) "
					+ "VALUES "
					+ "('Margarita', '2oz tequila, 1oz triple sec', '2oz lime juice',"
					+ "'lime slice, salt', 'Margarita', 'Rub the rim of the glass with the lime, "
					+ "then rub the salt on the rim. Shake the other ingredients and pour " 
					+ "over ice, or blend.')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions) "
					+ "VALUES "
					+ "('Mojito', '1.5oz White Rum', '1oz lime juice, splash of soda water',"
					+ "'6 leaves mint, 2tsp sugar, ice', 'Highball', 'Muddle mint with sugar and lime juice, "
					+ "then add rum and top with soda water. " 
					+ "Pour over ice.')";
			stmt.executeUpdate(sql);
			/*
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions) "
					+ "VALUES "
					+ "('Martini', '2oz Gin, Dry Vermouth', 'none', "
					+ "'1 green olive, ice', 'Cocktail glass', " 
					+ "'Swirl a little bit of dry vermouth in the glass to coat it, then pour out excess."
					+ "Gently shake or stir gin with ice before straining into glass. Garnish with olive.')";
			stmt.executeUpdate(sql);
			*/
			stmt.close();
			c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getAllDrinks() {
		String drink = "";
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM drinks;" );
		      while ( rs.next() ) {
		         String  name = rs.getString("name");
			      System.out.println("Name = " + name);
			      drink = name;
		      }
		      rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return drink;
	}

	public String[] getDrinkByName(String name) {
		String drink[] = new String[5];
		String query = "SELECT * FROM drinks WHERE name = ?";

		try {
			PreparedStatement prep = c.prepareStatement(query);
			prep.setString(1, name);
			ResultSet rs = prep.executeQuery();
		    while (rs.next()) {
		        drink[0] = rs.getString("alcohol");
		        drink[1] = rs.getString("mixer");
		        drink[2] = rs.getString("solid");
		        drink[3] = rs.getString("glass");
		        drink[4] = rs.getString("directions");

		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return drink;
	}

	public ArrayList<String> getDrinkByAlcohol(String alc) {
		ArrayList<String> drinks = new ArrayList<String>();
		String alcohol = "%" + alc + "%";
		String query = "SELECT name FROM drinks WHERE alcohol LIKE ?";

		try {
			PreparedStatement prep = c.prepareStatement(query);
			prep.setString(1, alcohol);
			ResultSet rs = prep.executeQuery();
		    while (rs.next()) {
		    	String name = rs.getString("name");
		    	drinks.add(name);
		    }
		    prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drinks;
	}

	public ArrayList<String> getDrinkByMixer(String mix) {
		ArrayList<String> drinks = new ArrayList<String>();
		String mixer = "%" + mix + "%";
		String query = "SELECT name FROM drinks WHERE mixer LIKE ?";

		try {
			PreparedStatement prep = c.prepareStatement(query);
			prep.setString(1, mixer);
			ResultSet rs = prep.executeQuery();
		    while (rs.next()) {
		    	String name = rs.getString("name");
		    	drinks.add(name);
		    }
		    prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drinks;
	}

	public void addDrink(String name, String alcohol, String mixer, String solid, String glass, String directions) {
		try {
			PreparedStatement statement = c.prepareStatement(
					"INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions) "
					+ "VALUES "
					+ "(?,?,?,?,?,?)");
			statement.setString(1,name);
			statement.setString(2,alcohol);
			statement.setString(3,mixer);
			statement.setString(4,solid);
			statement.setString(5,glass);
			statement.setString(6,directions);
			statement.executeUpdate();
	        c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dropDrink(String name) {
		String query = "DELETE FROM drinks WHERE name=?";

		try {
			PreparedStatement prep = c.prepareStatement(query);
			prep.setString(1, name);
			prep.execute();
		    prep.close();
		    c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
