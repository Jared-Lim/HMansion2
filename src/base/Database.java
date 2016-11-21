package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;

import demon.Demon;
import skill.Skill;

public class Database {
	private Connection conn = null;
	
	public Database(String dbloc){
		try{
			this.conn = DriverManager.getConnection("jdbc:sqlite:"+dbloc);
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

	public void makeSkillsTable(){
		String sql ="CREATE TABLE skills ("+
				"nameJP STRING UNIQUE,"+
				"nameEN STRING UNIQUE,"+
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
	public void makeDemonsTranslateTable(){
		String sql = "CREATE TABLE translate ("+
					"nameJP STRING UNIQUE,"+
					"nameEN STRING UNIQUE)";
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.executeUpdate();
			System.out.println("Created translate table");
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
	}
	public void parseSkillsFolder(){
		Gson gson = new Gson();
		File directory = new File("res/skills/");
		String[] files = directory.list();
		for(String f:files){
			String g ="res/skills/"+f;
			try(Reader reader = new FileReader(g)){
				Skill skill = gson.fromJson(reader, Skill.class);
				insertSkill(skill);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public void insertSkill(Skill skill){
		String sql = "INSERT INTO skills (nameJP,nameEN,attr,cost,power,hits,kuli,hit,targ,str,effect) "+
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.setString(1, skill.getNJP());
			pstate.setString(2, skill.getNEN());
			pstate.setString(3, skill.getATT());
			pstate.setInt(4, skill.getCST());
			pstate.setString(5, skill.getPWR());
			pstate.setString(6, skill.getHTS());
			pstate.setString(7, skill.getCRI());
			pstate.setString(8, skill.getACC());
			pstate.setString(9, skill.getTAR());
			pstate.setInt(10, skill.getSTR());
			pstate.setString(11, skill.getEFF());
			pstate.executeUpdate();
			System.out.println("Inserted "+skill.getNEN());
		}catch(SQLException e){
			System.out.println(e.getMessage()+" -> "+skill.getNEN());;
		}
	}
	public String translateSkill(String nameJP){
		String sql = "SELECT nameEN FROM skills WHERE nameJP = ?";
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.setString(1, nameJP);
	    	ResultSet rset = pstate.executeQuery();
			return rset.getString("nameEN");
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return nameJP;
		}
		
	}
	public void parseDemonsFolderTranslate(){
		Gson gson = new Gson();
		File directory = new File("res/demons/");
		String[] files = directory.list();
		for(String f:files){
			String g ="res/demons/"+f;
			System.out.println(g);
		}
	}
	public void insertDemonTranslate(Demon demon){
		String sql = "INSERT INTO translate (nameJP, nameEN) VALUES (?,?)";
		try(PreparedStatement pstate = conn.prepareStatement(sql)){
			pstate.setString(1, demon.getNameJP());
			pstate.setString(2, demon.getNameEN());
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
}
