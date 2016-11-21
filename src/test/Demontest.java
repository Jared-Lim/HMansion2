package test;
import java.io.*;
import java.sql.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import base.*;
import demon.*;

public class Demontest {
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Skills.class, new SkillsDeserializer());
		Gson gson = builder.create();
	    
	    try(Reader reader = new FileReader("res/demons/amatsukami/amaterasu.json")){
	    	Demon dmn = gson.fromJson(reader, Demon.class);
	    	System.out.println(dmn.getNameEN());
	    	System.out.println(dmn.getSkills().toString());
	    	System.out.println(dmn.getFusion());
	    	System.out.println(dmn.getMutate());
	    	System.out.println(dmn.getStats().toString());
	    	
	    	
	    	
	    	String check = dmn.getSkills().getSkill(0).getName();
	    	System.out.println(check);
	    	
	    	
	    	Database db = new Database();
    		String sql = "SELECT nameEN FROM skills WHERE nameJP = ?";
	    	try(Connection conn = db.connectDB("heretic.db");
	    			PreparedStatement pstate = conn.prepareStatement(sql)){
	    		pstate.setString(1, check);
	    		ResultSet rset = pstate.executeQuery();
	    		System.out.println(rset.getString("nameEN"));
	    	}catch(Exception e ){
	    		System.out.println(e.getMessage());
	    	}
	    	
	    	System.exit(0);
	    }catch(IOException e){
	    	System.out.println(e.getMessage());
	    }
	}
}
