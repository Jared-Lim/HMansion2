package test;
import demon.*;

public class Demontest {
	public static void main(String[] args) {
		Demon dmn = new Demon("res/demons/amatsukami/amaterasu.json");
		System.out.println(dmn.getNameEN());
		System.out.println(dmn.getFusionSQL());
		System.out.println(dmn.getStats().toString());
		System.out.println(dmn.getSkills());
		
		
		Demon dmn2 = new Demon("res/demons/herald/metatron.json");
		System.out.println(dmn2.getNameEN());
		System.out.println(dmn2.getFusionSQL());
		System.out.println(dmn2.getStats().toString());
		System.out.println(dmn2.getSkills());
	}
}
