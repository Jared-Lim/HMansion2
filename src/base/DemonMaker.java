package base;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demon.Demon;

public class DemonMaker extends Database {
	public DemonMaker(String dblocation) {
		super(dblocation);
	}
	
	public void makeDemonsTable(){
		String sql = "CREATE TABLE demons ("+
					"tribe STRING,"+
					"nameJP STRING UNIQUE,"+
					"nameEN STRING UNIQUE,"+
					"level INT,"+
					"hp INT,"+
					"mp INT,"+
					"str INT,"+
					"dex INT,"+
					"mag INT,"+
					"spd INT,"+
					"luk INT,"+
					"phy STRING,"+
					"gun STRING,"+
					"fir STRING,"+
					"ice STRING,"+
					"thu STRING,"+
					"sho STRING,"+
					"ban STRING,"+
					"cur STRING,"+
					"bin STRING,"+
					"sle STRING,"+
					"col STRING,"+
					"con STRING,"+
					"poi STRING,"+
					"skills STRING,"+
					"fusion STRING,"+
					"mutate STRING)";
		try(PreparedStatement pstate = super.getConn().prepareStatement(sql)){
			pstate.executeUpdate();
			System.out.println("Created demons table");
		}catch(SQLException e){
			System.out.println(e.getMessage());;
		}
	}
	public void parseDemonsFolder(){
		File directory = new File("res/demons/");
		String[] files = directory.list();
		for(String f:files){
			String demonDir = "res/demons/"+f;
			File innerDirectory = new File(demonDir);
			String[] innerFiles = innerDirectory.list();
			for(String g:innerFiles){
				Demon dmn = new Demon(demonDir+"/"+g);
				insertDemon(dmn);
				dmn = null;
			}
		}
	}
	public void insertDemon(Demon demon){
		String sql = "INSERT INTO demons "
				+ "(tribe,nameJP,nameEN,level,"+
				"hp,mp,str,dex,mag,spd,luk,"+
				"phy,gun,fir,ice,thu,"+
				"sho,ban,cur,bin,sle,col,con,poi,"+
				"skills,fusion,mutate)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pstate = super.getConn().prepareStatement(sql)){
			pstate.setString(1, demon.getTribe());
			pstate.setString(2, demon.getNameJP());
			pstate.setString(3, demon.getNameEN());
			pstate.setInt(4, demon.getLevel());
			pstate.setInt(5, demon.getStats().gethp());
			pstate.setInt(6, demon.getStats().getmp());
			pstate.setInt(7, demon.getStats().getstr());
			pstate.setInt(8, demon.getStats().getskl());
			pstate.setInt(9, demon.getStats().getmag());
			pstate.setInt(10, demon.getStats().getspd());
			pstate.setInt(11, demon.getStats().getluk());
			pstate.setString(12,demon.getAff().getphy());
			pstate.setString(13,demon.getAff().getgun());
			pstate.setString(14,demon.getAff().getfir());
			pstate.setString(15,demon.getAff().getice());
			pstate.setString(16,demon.getAff().getthu());
			pstate.setString(17,demon.getAff().getsho());
			pstate.setString(18,demon.getAff().getban());
			pstate.setString(19,demon.getAff().getcur());
			pstate.setString(20,demon.getAff().getbin());
			pstate.setString(21,demon.getAff().getsle());
			pstate.setString(23,demon.getAff().getcol());
			pstate.setString(22,demon.getAff().getcon());
			pstate.setString(24,demon.getAff().getpoi());
			pstate.setString(25, demon.getSkills().toString());
			pstate.setString(26, demon.getFusionSQL());
			pstate.setString(27, demon.getNameEN());
			pstate.executeUpdate();
			System.out.println("Inserted "+demon.getTribe()+" "+demon.getNameEN());
		}catch (SQLException e){
			System.out.println(e.getMessage()+" "+demon.getTribe()+" "+demon.getNameEN());
		}
	}
	public String translateDemon(String nameJP){
		String sql = "SELECT nameEN FROM translate WHERE nameJP = ?";
		try(PreparedStatement pstate = super.getConn().prepareStatement(sql)){
			pstate.setString(1, nameJP);
	    	ResultSet rset = pstate.executeQuery();
			return rset.getString("nameEN");
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return nameJP;
		}
	}	
}