package test;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import demon.*;

public class Demontest {
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Skills.class, new SkillsDeserializer());
		Gson gson = builder.create();
	    
	    try(Reader reader = new FileReader("res/demons/amatsukami/amaterasu.json")){
	    	Demon demoneeho = gson.fromJson(reader, Demon.class);
	    	System.out.println(demoneeho.getNameEN());
	    	System.out.println(demoneeho.getSkills().toString());
	    	System.out.println(demoneeho.getFusion());
	    	System.out.println(demoneeho.getMutate());
	    	System.out.println(demoneeho.getStats().toString());
	    	System.exit(0);
	    }catch(IOException e){
	    	System.out.println(e.getMessage());
	    }
	}
}
