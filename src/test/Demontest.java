package test;
import base.Database;
import demon.*;

public class Demontest {
	public static void main(String[] args) {
		Demon dmn = new Demon("res/demons/amatsukami/amaterasu.json");
		System.out.println(dmn.getNameEN());
		Database db = new Database("heretic.db");
		for(String temp:dmn.getFusions()){
			System.out.println(db.translateDemon(temp));
		}
		System.out.println(dmn.getFusionSQL());
	}
}
