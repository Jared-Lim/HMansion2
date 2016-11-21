package demon;

public class SingleSkill {
	private String name;
	private int level;
	
	public void setName(String name){this.name = name;}
	public void setLevel(int level){this.level=level;}
	
	@Override
	public String toString(){
		return name+" ["+level+"]";
	}
}