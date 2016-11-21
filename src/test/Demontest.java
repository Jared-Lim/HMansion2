package test;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	    	System.exit(0);
	    }catch(IOException e){
	    	System.out.println(e.getMessage());
	    }
	}
}
