package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static String db = "jdbc:sqlite:heretic2.db";
	private static String skillsFold = "res/skills/";
	private static String demonsFold = "res/demons/";
	
	public Connection connectDB(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(db);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	
}
