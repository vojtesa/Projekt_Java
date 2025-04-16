package projektProgramko;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
	private static Connection conn;
	private static Statement stmt;
	public static boolean connect() {	//pripoji se na databazi a 
		conn = null;					//pokud databaze neexistuje, vytvori ji 
		try {							//podle struktury v souboru .sql
			conn = DriverManager.getConnection("jdbc:sqlite:databaze_studentu.db");
			vlozit_strukturu();
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	
	
	public static void disconnect() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());				
			}
		}
	}
	
	
	
	public static boolean vlozit_strukturu() {	//nacte do souboru .db soubory .sql, kde je predvytvorena struktura tabulek
		try {
			stmt = conn.createStatement();
			String[] sqlSoubory= { "src/projektProgramko/studenti.sql", 
					"src/projektProgramko/skupina.sql", 
					"src/projektProgramko/znamky.sql"};	//soubory sql, kde je struktura tabulek
			String strukturaJednohoSouboru = "";
			FileReader fr = null;
			BufferedReader in = null;
			try {
				for(String a:sqlSoubory) {	//nacteni obsahu ze souboru do strukturaVystup
					fr = new FileReader(a);
					in = new BufferedReader(fr);
					String obsah;
					while((obsah = in.readLine()) != null) {
						strukturaJednohoSouboru += obsah + "\n";					
					}
					stmt.executeUpdate(strukturaJednohoSouboru);
					strukturaJednohoSouboru = "";
				}
				 return true;
				
			} catch (Exception e) {
				System.out.println("Chyba pri nacitani souboru: " + e.getMessage());
				return false;
			}
			finally {
				try {
					fr.close();
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
	public static void naplneniSQLdatabaze() {
		for (int i = 0; i < Databaze.ID; i++) {
			
		}
		
		
	
	}
}
