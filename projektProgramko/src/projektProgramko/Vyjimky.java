package projektProgramko;

import java.util.Scanner;

public class Vyjimky {
	Scanner sc = new Scanner(System.in);
	
	
	public static String pouzePismena(String vstup) {
		int pokusy = 0;
		Scanner sc = new Scanner(System.in);
		while(pokusy < 3) {
			
			if (vstup.matches("[a-zA-Za-žA-Ž]+")) {
				System.out.println("✓");
				return vstup;
				
			}
			else {
				System.out.println("Zadajte, prosim pouze pismena! Zbyvajici pokusy: " + (3 - pokusy));
				pokusy++;
				vstup = sc.next();
			
		}
		}
		return "Chyba vstupu";
	}
	
	public static int doesStudentExist(Integer ID) {
		Student ulozenaHodnotaStudenta = Databaze.databaze.get(ID);
		if (ulozenaHodnotaStudenta != null) {
			return 1; //student existuje
		}
		else if(((0 < ID && (ID < Databaze.ID) ) || (0 == ID && 0 < Databaze.ID))) {
			System.out.println("Student jiz byl vyloucen");
			return -1;//Student jiz byl vyloucen
		}
		else {
			System.out.println("Student neexistuje");
			return 0; //Student neexistuje
		}
	}
}
