package demon;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Demon {
	private String tribe;
	private String nameJP;
	private String nameEN;
	private int level;
	private Stats stats;
	private Affinities affinity;
	private Skills skills;
	private String[][] fusions=null;
	private Mutate mutate=null;
	
	public Demon(String fileLocation){
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Skills.class, new SkillsDeserializer());
		Gson gson = builder.create();
		
		try(Reader reader = new FileReader(fileLocation)){
			Demon dmn = gson.fromJson(reader, Demon.class);
			this.tribe = dmn.tribe;
			this.nameJP = dmn.nameJP;
			this.nameEN = dmn.nameEN;
			this.level = dmn.level;
			this.stats = dmn.stats;
			this.affinity = dmn.affinity;
			this.skills = dmn.skills;
			this.fusions = dmn.fusions;
			this.mutate = dmn.mutate;
	    }catch(IOException e){
	    	System.out.println(e.getMessage());
	    }
	}
	
	public String toString(){
		return    "--tribe: "+tribe+
				"\n--nameJP: "+nameJP+
				"\n--nameEn: "+nameEN+
				"\n--level: "+level+
				"\n--stats:\n"+
				"-------------------\n"+
				stats.toString()+
				"\n--affs:\n"+
				"-------------------\n"+
				affinity.toString()+
				"\n--skills:\n"+
				"-------------------\n"+
				skills.toString()+
				"\n--FUS: "+fusionCheck(fusions)+
				"\n--MUT: "+mutateCheck(mutate);
	}
	public String fusionCheck(String[][] fuse){
		if(fuse!=null){
			StringBuilder str = new StringBuilder();
			for(int i=0;i<fuse[0].length;i++){
				str.append(fuse[0][i]);
				if(i + 1 < fuse[0].length){
					str.append(", ");
				}
			}
			return str.toString();
		}
		else{return "-";}
	}
	public String mutateCheck(Mutate mutate){
		if(mutate!=null){
			return mutate.toString();
		}else{
			return "-";
		}
	}

	public String getTribe(){return tribe;}
	public String getNameJP(){return nameJP;}
	public String getNameEN(){return nameEN;}
	public int getLevel(){return level;}
	public Stats getStats(){return stats;}
	public Affinities getAff(){return affinity;}
	public Skills getSkills(){return skills;}
    public String getFusion(){return fusionCheck(fusions);}
    public String getMutate(){return mutateCheck(mutate);}
}