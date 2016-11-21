package demon;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import base.Database;

public class SkillsDeserializer implements JsonDeserializer<Skills>{

	@Override
	public Skills deserialize(JsonElement arg0, Type arg1, 
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject obj = arg0.getAsJsonObject();
		List<SingleSkill> SkillsList = new ArrayList<>();
		String sql = "SELECT nameEN FROM skills WHERE nameJP = ?";
		Database db = new Database();
		try(Connection conn = db.connectDB("heretic.db")){
			for(Map.Entry<String, JsonElement> entry : obj.entrySet()){
				SingleSkill skl = new SingleSkill();
				String nameJP = entry.getKey();
	    		try(PreparedStatement pstate = conn.prepareStatement(sql)){
					pstate.setString(1, nameJP);
			    	ResultSet rset = pstate.executeQuery();
					skl.setName(rset.getString("nameEN"));
	    		}catch(Exception e){
	    			System.out.println(e.getMessage());
					skl.setName(nameJP);
	    		}
				skl.setLevel(entry.getValue().getAsInt());
				SkillsList.add(skl);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		Skills skills = new Skills();
		skills.setSkills(SkillsList);
		return skills;
	}
	
}