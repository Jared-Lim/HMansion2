package base;

import java.sql.Connection;
import java.sql.SQLException;

public class ATest {
	public static void main(String[] args) {
		Database db = new Database();
		try(Connection conn = db.connectDB("heretic.db")){
			db.makeSkillsTable(conn);
			db.parseSkillsFolder(conn);
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
