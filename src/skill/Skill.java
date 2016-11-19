package skill;

public class Skill {
	public String nameJP;
	public String nameEN;
	public String attribute;
	public int cost;
	public String power;
	public String hits;
	public String kuli;
	public String hit;
	public String target;
	public int strengthen;
	public String effect;
	
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
	
	public String check(){
		return nameEN+"-----"+nameJP;
	}
}