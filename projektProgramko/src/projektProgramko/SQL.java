package projektProgramko;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
	private Connection conn;
	private Statement stmt;
	public boolean Connect() {	//pripoji se na databazi a 
		conn = null;			//pokud databaze neexistuje, vytvori ji 
		try {					//podle struktury v souboru .sql
			conn = DriverManager.getConnection("jdbc:sqlite:databaze_studentu.db");
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public void Disconnect() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());				
			}
		}
	}
	
	
	
}
