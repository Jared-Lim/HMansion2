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

public class SkillsDeserializer implements JsonDeserializer<Skills>{

	@Override
	public Skills deserialize(JsonElement arg0, Type arg1, 
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject obj = arg0.getAsJsonObject();
		
		List<SingleSkill> SkillsList = new ArrayList<>();
		
		for(Map.Entry<String, JsonElement> entry : obj.entrySet()){
			SingleSkill skl = new SingleSkill();
			skl.setName(entry.getKey());
			skl.setLevel(entry.getValue().getAsInt());
			SkillsList.add(skl);
		}
		
		Skills skills = new Skills();
		skills.setSkills(SkillsList);
		
		return skills;
	}
	
}