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

import base.SkillsMaker;

public class SkillsDeserializer implements JsonDeserializer<Skills>{

	@Override
	public Skills deserialize(JsonElement arg0, Type arg1, 
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject obj = arg0.getAsJsonObject();
		List<SingleSkill> SkillsList = new ArrayList<>();
		SkillsMaker db = new SkillsMaker("heretic.db");
		for(Map.Entry<String, JsonElement> entry : obj.entrySet()){
			SingleSkill skl = new SingleSkill();
			String nameJP = entry.getKey();
	    	skl.setName(db.translateSkill(nameJP));
			skl.setLevel(entry.getValue().getAsInt());
			SkillsList.add(skl);
		}
		db.close();
		Skills skills = new Skills();
		skills.setSkills(SkillsList);
		return skills;
	}
	
}