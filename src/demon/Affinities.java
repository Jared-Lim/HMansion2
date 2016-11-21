package demon;

public class Affinities {
	private String physical;
	private String gun;
	private String fire;
	private String ice;
	private String thunder;
	private String shock;
	private String banish;
	private String curse;
	private String bind;
	private String sleep;
	private String cold;
	private String confusion;
	private String poison;
	
	@Override
	public String toString(){
		return 	"phys  : "+physical+"\n"+
				"gun   : "+gun+"\n"+
				"fire  : "+fire+"\n"+
				"ice   : "+ice+"\n"+
				"thun  : "+thunder+"\n"+
				"shock : "+shock+"\n"+
				"banish: "+banish+"\n"+
				"curse : "+curse+"\n"+
				"bind  : "+bind+"\n"+
				"sleep : "+sleep+"\n"+
				"cold  : "+cold+"\n"+
				"confus: "+confusion+"\n"+
				"poison: "+poison;
	}

	public String getphy(){return physical;}
	public String getgun(){return gun;}
	public String getfir(){return fire;}
	public String getice(){return ice;}
	public String getthu(){return thunder;}
	public String getsho(){return shock;}
	public String getban(){return banish;}
	public String getcur(){return curse;}
	public String getbin(){return bind;}
	public String getsle(){return sleep;}
	public String getcol(){return cold;}
	public String getcon(){return confusion;}
	public String getpoi(){return poison;}
}
