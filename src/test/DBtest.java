package test;

import java.sql.Connection;
import base.*;

public class DBtest {
	public static void main(String[] args) {
		Database db = new Database();
		try(Connection conn = db.connectDB("heretic.db")){
			System.out.println("Connected to database");
			db.makeSkillsTable(conn);
			db.parseSkillsFolder(conn);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
