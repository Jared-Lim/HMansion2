package demon;

public class Stats {
	private int hp;
	private int mp;
	private int strength;
	private int skill;
	private int magic;
	private int speed;
	private int luck;
	
	@Override
	public String toString(){
		String output = String.format(
				  "| hp  | mp  | str | skl | mag | spd | lck |\n"
				+ "-------------------------------------------\n"
				+ "| %3d | %3d | %3d | %3d | %3d | %3d | %3d |", 
				hp, mp, strength, skill, magic, speed, luck);
		return output;
	}

	public int gethp(){return hp;}
	public int getmp(){return mp;}
	public int getstr(){return strength;}
	public int getskl(){return skill;}
	public int getmag(){return magic;}
	public int getspd(){return speed;}
	public int getluk(){return luck;}
}