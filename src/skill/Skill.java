package skill;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

public class Skill {
	private String nameJP;		//japanese name for mapping
	private String nameEN;		//english name
	private String attribute;	//element of skill
	private int cost;			//how much MP skill costs
	private String power;		//how much DAMAGE skill deals
	private String hits;		//how many hits dealt
	private String kuli;		//actually means crit rate
	private String hit;			//actually means accuracy
	private String target;		//what skill targets
	private int strengthen;		//how many times skill can be EMPOWERED
	private String effect;		//description of skill
	
	public Skill(String filelocation){
		Gson gson = new Gson();
		try(Reader reader = new FileReader(filelocation)){
			Skill skill = gson.fromJson(reader, Skill.class);
			this.nameJP=skill.nameJP;
			this.nameEN=skill.nameEN;
			this.attribute=skill.attribute;
			this.cost=skill.cost;
			this.power=skill.power;
			this.hits=skill.hits;
			this.kuli=skill.kuli;
			this.hit=skill.hit;
			this.target=skill.target;
			this.strengthen=skill.strengthen;
			this.effect=skill.effect;
			skill = null;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public String toString(){
		return 	"nameJP:  	"+nameJP+"\n"+
				"nameEN: 	"+nameEN+"\n"+
				"attr:     	"+attribute+"\n"+
				"cost:    	"+cost+"\n"+
				"power:	  	"+power+"\n"+
				"hits:	  	"+hits+"\n"+
				"kuli:	  	"+kuli+"\n"+
				"hit:	  	"+hit+"\n"+
				"targ:  	"+target+"\n"+
				"str:	  	"+strengthen+"\n"+
				"effect:\n	"+effect;
	}
	
	public String getNJP(){return nameJP;}
	public String getNEN(){return nameEN;}
	public String getATT(){return attribute;}
	public int getCST(){return cost;}
	public String getPWR(){return power;}
	public String getHTS(){return hits;}
	public String getCRI(){return kuli;}
	public String getACC(){return hit;}
	public String getTAR(){return target;}
	public int getSTR(){return strengthen;}
	public String getEFF(){return effect;}
}
