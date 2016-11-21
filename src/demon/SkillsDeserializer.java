package demon;

import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.*;

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