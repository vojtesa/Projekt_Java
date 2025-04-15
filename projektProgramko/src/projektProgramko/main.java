package projektProgramko;

import java.util.Scanner;

import javax.swing.JEditorPane;

public class main {
	public static void main(String[] args) {
		boolean programBezi = true;
		Scanner sc = new Scanner(System.in);
		
		int volba;
		
		while(programBezi) {
					//vycisteni vstupu
			System.out.println("1...Pridat studenta");
			System.out.println("2...Nastavit studentovi znamku");
			System.out.println("3...Vypis informaci o studentovi");
			System.out.println("4...Vyhodit studenta");
			System.out.println("5...Vypsat studenty serazene podle prijmeni");
			System.out.println("6...Vypsat prumer studentu");
			System.out.println("7...Vypsat pocet studentu ve skupinach");
			System.out.println("8...Spustit dovednost");
			System.out.println("9...Ulozit studenta do textoveho souboru");
			System.out.println("10...Nacist a vypsat studenta z textoveho souboru");
			
			try {
				volba = sc.nextInt();
				sc.nextLine();
			}
			catch(Exception e) {
				System.out.println("Nezadali jste CISLO pro vyber z menu");
				sc.nextLine();
				continue;
			}

			switch(volba) {
				case 1: //pridani studenta
					
					System.out.println("Zadejte: JMENO, PRIJMENI a ROK NAROZENI:");
						String jmeno;
						String prijmeni;
						Integer rokNarozeni;
						Integer skupina;
						
					try {
						jmeno = Vyjimky.pouzePismena(sc.next());
						prijmeni = Vyjimky.pouzePismena(sc.next());
						rokNarozeni = sc.nextInt(); sc.nextLine();
						System.out.println("Zadejte skupinu Telekomunikace/Kyberbezpecnost(Type in 1/2): ");
						skupina = sc.nextInt();
					}
					catch(Exception e) {
						System.out.println("Chyba vstupu");
						continue;
					}
					
					if (skupina == 1) {
						Student novyStudent = new Telekomunikace(jmeno, prijmeni, rokNarozeni);
						Databaze.addStudent(novyStudent);
						novyStudent.setSkupina("1 - Telekomunikace"); 
					}
					else if (skupina == 2) {
						Student novyStudent = new Kyberbezpecnost(jmeno, prijmeni, rokNarozeni);
						Databaze.addStudent(novyStudent);
						novyStudent.setSkupina("2 - Kyberbezpecnost"); 
					}
					else {
						System.out.println("Zadali jste cislo mimo rozsah");
					}
					break;
					
				case 2: //nastaveni znamky studentovi 
					System.out.println("Zadejte ID studenta, kteremu chcete nastavit znamku: ");
					Integer IDtoSetGrade;
					try {
						if (Vyjimky.doesStudentExist(IDtoSetGrade = sc.nextInt()) != 1) {
							break;
						}
					}
					catch(Exception e) {
						System.out.println("Chybny vstup pro ID");
						break;
					}
					System.out.println("Zadejte znamku: ");
					Double grade;
					try {
						grade = sc.nextDouble(); sc.nextLine();
						Student setPrumerStudent = Databaze.databaze.get(IDtoSetGrade);						
						setPrumerStudent.setZnamka(grade);											
					}
					catch(Exception e) {
						System.out.println("Znamka byla zadana ve spatnem formatu");
						sc.nextLine();
					}				
					break;	
					
					
				case 3: //vypis info o studentovi
					
					System.out.println("Zadejte ID studenta: ");
					Integer inputID = sc.nextInt(); sc.nextLine();
										
					if(Vyjimky.doesStudentExist(inputID) == 1){
						System.out.println(Funkce.vypisInfoOStudentovi(inputID));						
					}
					break;
					
				case 4: //vyhozeni studenta
					
					System.out.println("Zadejte ID studenta, ktereho chcete vyloucit: ");
					Integer IDtoDismiss = sc.nextInt(); sc.nextLine();

					if (Vyjimky.doesStudentExist(IDtoDismiss) != 1) {
						break;
					}
					Databaze.databaze.remove(IDtoDismiss);
					break;
					
				case 5: //vypis vsech studentu podle skupiny a prijmeni
					System.out.println("Zadejte skupinu, kterou chcete vypsat Komunikace/Kyberbezpecnost/Vsechny(Type in 1/2/3): ");
					try{
						Integer skupinaProVypis = sc.nextInt(); sc.nextLine();
						Funkce.vypisStudentu(skupinaProVypis);
						
						}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 6:	//vypis prumeru vsech studentu podle skupiny
					System.out.println("Zadejte skupinu, ktere chcete vypsat prumer Komunikace/Kyberbezpecnost/Vsech(Type in 1/2/3): ");
					try {
						Integer skupinaProPrumer = sc.nextInt(); sc.nextLine();
						Funkce.vypisPrumeruStudentu(skupinaProPrumer);
					}
					catch(Exception e) {
						System.out.println("Spatny vstup");
					}
					break;
				case 7:	//vypis poctu studentu ve skupinach
					Funkce.pocetStudentuVeSkupine();
					
					break;
					
				case 8: //dovednost studenta
					System.out.println("Zadejte ID studenta, jehoz dovednost chcete spustit: ");
					try{
						Integer ID = sc.nextInt(); sc.nextLine();
						Databaze.databaze.get(ID).dovednost();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 9:		//ulozeni studenta do souboru
					System.out.println("Zadejte ID studenta, ktereho chcete ulozit do souboru: ");
					try {
						Integer vstup = sc.nextInt();
						if(Vyjimky.doesStudentExist(vstup) == 1) {
							Funkce.ulozeniStudentaDoSouboru((vstup));
							break;
						}
						
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				
				case 10:	//nacteni studenta do souboru
					System.out.println("Zadejte ID studenta, ktereho chcete nacist ze souboru: ");
					try{
						Integer ID = sc.nextInt(); sc.nextLine();
						System.out.println(Funkce.nacteniStudentaZeSouboru(ID));
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
					
				default:
					System.out.println("Nezadali jste platne cislo v rozsahu pro vyber z menu");
					}
			}
				
		}
		
			
		
	}


