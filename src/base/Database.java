package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private Connection conn = null;
	
	public Database(String dblocation){
		try{
			this.conn = DriverManager.getConnection("jdbc:sqlite:"+dblocation);
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	public Connection getConn(){return conn;}

	public void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
