package base;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import demon.Demon;

public class DemonTranslate extends Database{
	public DemonTranslate(String dblocation) {
		super(dblocation);
	}
	
	public void makeDemonsTranslateTable(){
		String sql = "CREATE TABLE translate ("+
					"nameJP STRING UNIQUE,"+
					"nameEN STRING UNIQUE)";
		try(PreparedStatement pstate = super.getConn().prepareStatement(sql)){
			pstate.executeUpdate();
			System.out.println("Created translate table");
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
	}
	public void parseDemonsFolderTranslate(){
		File directory = new File("res/demons/");
		String[] files = directory.list();
		for(String f:files){
			String demonDir = "res/demons/"+f;
			File innerDirectory = new File(demonDir);
			String[] innerFiles = innerDirectory.list();
			for(String g:innerFiles){
				Demon dmn = new Demon(demonDir+"/"+g);
				insertDemonTranslate(dmn);
				dmn = null;
			}
		}
	}
	public void insertDemonTranslate(Demon demon){
		String sql = "INSERT INTO translate (nameJP, nameEN) VALUES (?,?)";
		try(PreparedStatement pstate = super.getConn().prepareStatement(sql)){
			pstate.setString(1, demon.getNameJP());
			pstate.setString(2, demon.getNameEN());
			pstate.executeUpdate();
			System.out.println("Translated "+demon.getNameEN());
		}catch (SQLException e){
			System.out.println(e.getMessage()+" "+demon.getTribe()+" "+demon.getNameEN());
		}
	}
}