package test;

import base.SkillsMaker;

public class ExtendTest {
	public static void main(String[] args) {
		SkillsMaker skm = new SkillsMaker("heretic.db");
		skm.makeSkillsTable();
		skm.parseSkillsFolder();
	}
}
