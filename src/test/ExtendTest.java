package test;

import base.*;

public class ExtendTest {
	public static void main(String[] args) {
		String db = "heretic.db";
		SkillsMaker skm = new SkillsMaker(db);
		skm.makeSkillsTable();
		skm.parseSkillsFolder();
		skm.close();
		
		DemonTranslate dts = new DemonTranslate(db);
		dts.makeDemonsTranslateTable();
		dts.parseDemonsFolderTranslate();
		dts.close();
		
		DemonMaker dmk = new DemonMaker(db);
		dmk.makeDemonsTable();
		dmk.parseDemonsFolder();
		dmk.close();
	}
}
