package test;
import demon.*;

public class Demontest {
	public static void main(String[] args) {
		Demon dmn = new Demon("res/demons/amatsukami/amaterasu.json");
		System.out.println(dmn.getNameEN());
		System.out.println(dmn.getSkills());
	}
}
