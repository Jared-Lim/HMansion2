package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.gson.Gson;

import skill.Skill;

public class Database {	
	public Connection connectDB(String db){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:"+db);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public void makeSkillsTable(Connection conn){
		String sql ="CREATE TABLE skills ("+
				"ID 	INT PRIMARY KEY NOT NULL,"+
				"nameJP STRING,"+
				"nameEN STRING,"+
				"attr 	STRING,"+
				"cost 	INT,"+
				"power 	STRING,"+
				"hits 	STRING,"+
				"kuli 	STRING,"+
				"hit 	STRING,"+
				"targ 	STRING,"+
				"str 	INT,"+
				"effect STRING)";
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.executeUpdate();
			System.out.println("Created skills table");
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
	}
	public void makeDemonsTable(Connection conn){
		
	}
	public void parseSkillsFolder(Connection conn){
		Gson gson = new Gson();
		File directory = new File("res/skills/");
		String[] files = directory.list();
		int count = 1;
		for(String f:files){
			String g ="res/skills/"+f;
			try(Reader reader = new FileReader(g)){
				Skill skill = gson.fromJson(reader, Skill.class);
				skill.setID(count);
				count++;
				insertSkill(conn,skill);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public void insertSkill(Connection conn,Skill skill){
		String sql = "INSERT INTO skills (ID,nameJP,nameEN,attr,cost,power,hits,kuli,hit,targ,str,effect) "+
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.setInt(1, skill.getID());
			pstate.setString(2, skill.getNJP());
			pstate.setString(3, skill.getNEN());
			pstate.setString(4, skill.getATT());
			pstate.setInt(5, skill.getCST());
			pstate.setString(6, skill.getPWR());
			pstate.setString(7, skill.getHTS());
			pstate.setString(8, skill.getCRI());
			pstate.setString(9, skill.getACC());
			pstate.setString(10, skill.getTAR());
			pstate.setInt(11, skill.getSTR());
			pstate.setString(12, skill.getEFF());
			pstate.executeUpdate();
			System.out.println("Inserted "+skill.getNEN());
		}catch(SQLException e){
			System.out.println(e.getMessage()+" -> "+skill.getNEN());;
		}
	}
}
