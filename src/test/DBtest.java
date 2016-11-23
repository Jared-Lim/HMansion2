package test;

import base.*;

public class DBtest {
	public static void main(String[] args) {
		Database db = new Database("heretic.db");
		db.makeDemonsTable();
		db.parseDemonsFolder();
		db.close();
	}
}
