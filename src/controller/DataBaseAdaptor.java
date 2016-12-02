package controller;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAdaptor {

	Connection c = null;
	Statement stmt = null;
	
	public DataBaseAdaptor() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:final.db");
			c.setAutoCommit(false);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}
	
	public static void main(String[] args) throws SQLException {
		DataBaseAdaptor db = new DataBaseAdaptor();
		//db.createBasicDrinkDB();

		db.getAllDrinks();
	}
	
	//Run this if you removed a bunch of drinks. This sets up the database
	public void createBasicDrinkDB() {
		try {
			stmt = c.createStatement();
		//////CREATE TABLE
			/* Only uncomment this if you deleted final.db and need to re-create the entire table
			String sql = "CREATE TABLE drinks" 
					+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, " 
					+ "name varchar(50), "
					+ "alcohol varchar(255), " 
					+ "mixer varchar(255), " 
					+ "solid varchar(255), "
					+ "glass vachar(255), "
					+ "directions varchar(255), "
					+ "hangoverPotential varchar(255))";
			stmt.executeUpdate(sql);
*/
			///////INSERT DRINKS
			String sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions, hangoverPotential) "
					+ "VALUES "
					+ "('Whiskey Sour', '1.5oz whiskey', '1oz lemon juice, 2oz water',"
					+ "'1 cube sugar, 3-4 ice cubes', 'Lowball', 'Crush sugar cube with mortar, add lemon juice and then"
					+ "dilute with water. Shake with whiskey and pour over ice.', 'Ya fine.')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions, hangoverPotential) "
					+ "VALUES "
					+ "('Long Island Iced Tea', '.5oz Vodka, .5oz Rum, .5oz Tequila, .5oz Gin, .5oz Triple Sec', '1oz lemon juice, splash of cola',"
					+ "'ice, lemon spiral', 'Highball', "
					+ "'Add all ingredients over ice, then stir gently, add lemon spiral and serve.', 'DANGER zone!')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions, hangoverPotential) "
					+ "VALUES "
					+ "('Margarita', '2oz tequila, 1oz triple sec', '2oz lime juice',"
					+ "'lime slice, salt', 'Margarita', 'Rub the rim of the glass with the lime, "
					+ "then rub the salt on the rim. Shake the other ingredients and pour " 
					+ "over ice, or blend.', 'Resaca verdad.')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions, hangoverPotential) "
					+ "VALUES "
					+ "('Mojito', '1.5oz White Rum', '1oz lime juice, splash of soda water',"
					+ "'6 leaves mint, 2tsp sugar, ice', 'Highball', 'Muddle mint with sugar and lime juice, "
					+ "then add rum and top with soda water. " 
					+ "Pour over ice.', 'I was hungover before it was cool.')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions, hangoverPotential) "
					+ "VALUES "
					+ "('Martini', '2oz Gin, Dry Vermouth', 'none', "
					+ "'1 green olive, ice', 'Cocktail glass', " 
					+ "'Swirl a little bit of dry vermouth in the glass to coat it, then pour out excess."
					+ "Gently shake or stir gin with ice before straining into glass. Garnish with olive.', "
					+ "'Who gets drunk on martinis? Come on.')";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> getAllDrinks() {
		ArrayList<String> drinkList = new ArrayList<String>();
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM drinks;" );
		      while ( rs.next() ) {
		         String name = rs.getString("name");
			      System.out.println("Name = " + name); //just for error checking, can be removed/commented
			      drinkList.add(name);
		      }
		      rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return drinkList;
	}

	//We can probably delete this if all it does is getAllDrinks without printing to the console?? That's just for error checking,
	//not for functionality -- also this won't add any drinks to the array list
	public ArrayList<String> getAllDrinksSupressed() {
		ArrayList<String> drinkList = null;
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM drinks;" );
		      while ( rs.next() ) {
		         String name = rs.getString("name");
			      //System.out.println("Name = " + name);
			      
		      }
		      rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return drinkList;
	}
	
	public String getRandomDrink() {
		String drink = "";
		String query = "SELECT name FROM drinks ORDER BY RAND() LIMIT 1";
		try {
			PreparedStatement prep = c.prepareStatement(query);
			ResultSet rs = prep.executeQuery();
		    while (rs.next()) {
		    	drink = rs.getString("name");
		    }
		    prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return drink;
	}
	
	public String[] getDrinkByName(String name) {
		String drink[] = new String[6];
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
		        drink[5] = rs.getString("hangoverPotential");

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

	public void addDrink(String name, String alcohol, String mixer, String solid, String glass, String directions, String hp) {
		try {
			PreparedStatement statement = c.prepareStatement(
					"INSERT INTO drinks" 
					+ "(name, alcohol, mixer, solid, glass, directions, hangoverPotential) "
					+ "VALUES "
					+ "(?,?,?,?,?,?,?)");
			statement.setString(1,name);
			statement.setString(2,alcohol);
			statement.setString(3,mixer);
			statement.setString(4,solid);
			statement.setString(5,glass);
			statement.setString(6,directions);
			statement.setString(6, hp);
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
