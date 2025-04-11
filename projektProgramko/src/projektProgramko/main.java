package projektProgramko;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		boolean programBezi = true;
		Scanner sc = new Scanner(System.in);
		
		int volba;
		
		while(programBezi) {
			System.out.println("1...Pridat studenta");
			System.out.println("2...Nastavit studentovi znamku");
			System.out.println("3...Vypis informaci o studentovi");
			System.out.println("4...Vyhodit studenta");
			System.out.println("5...Vypsat studenty serazene podle prijmeni");
			System.out.println("6...Vypsat prumer studentu");
			System.out.println("7...Vypsat pocet studentu ve skupinach");
			
			try {
				volba = sc.nextInt();				
			}
			catch(Exception e) {
				System.out.println("Nezadali jste spravne cislo pro vyber z menu");
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
						rokNarozeni = sc.nextInt();
						System.out.println("Zadejte skupinu Komunikace/Kyberbezpecnost(Type in 1/2): ");
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
					
				case 2: //nastaveni prumeru studentovi 
					System.out.println("Zadejte ID studenta, kteremu chcete nastavit znamku: ");
					Integer IDtoSetGrade;
					try {
						IDtoSetGrade = sc.nextInt();	
					}
					catch(Exception e) {
						System.out.println("Chybny vstup pro ID");
						break;
					}
					System.out.println("Zadejte znamku: ");
					Double grade;
					try {
						grade = sc.nextDouble();
						Student setPrumerStudent = Databaze.databaze.get(IDtoSetGrade);						
						setPrumerStudent.setZnamka(grade);											
					}
					catch(Exception e) {
						Vyjimky.doesStudentExist(IDtoSetGrade);
					}				
					break;
					
				case 3: //vypis info o studentovi
					
					System.out.println("Zadejte ID studenta: ");
					Integer inputID = sc.nextInt();
					switch(Vyjimky.doesStudentExist(inputID)){
						case 1:
							Student vybranyStudentString = Databaze.databaze.get(inputID);
							System.out.println("\n" + "ID: " + vybranyStudentString.getID());
							System.out.println("Skupina: " + vybranyStudentString.getSkupina());
							System.out.println("Jmeno: " + vybranyStudentString.getJmeno());
							System.out.println("Prijmeni: " + vybranyStudentString.getPrijmeni());
							System.out.println("Rok narozeni: " + vybranyStudentString.getRokNarozeni());
							System.out.print("Znamky: ");
							vybranyStudentString.vypisZnamek();
							System.out.print("      Prumer: " + vybranyStudentString.getPrumer());
							System.out.println("\n\n");//odradkovani
							break;
						case -1:
							System.out.println("Student jiz byl vyloucen");
							break;
						case 0:
							System.out.println("Student neexistuje");
							break;
					}
					break;
					
				case 4: //vyhozeni studenta
					
					System.out.println("Zadejte ID studenta, ktereho chcete vyloucit: ");
					Integer IDtoDismiss = sc.nextInt();

					switch(Vyjimky.doesStudentExist(IDtoDismiss)){
						case 1:
							System.out.println("Student s ID " + IDtoDismiss + " byl uspesne vyloucen\n");
							break;
						case -1:
							System.out.println("Student nelze vyloucit - byl jiz byl vyloucen");
							break;
						case 0:
							System.out.println("Student nejde vyloucit - neexistuje");
							break;
						}
					Databaze.databaze.remove(IDtoDismiss);
					break;
					
				case 5: //vypis vsech studentu podle skupiny a prijmeni
					System.out.println("Zadejte skupinu, kterou chcete vypsat Komunikace/Kyberbezpecnost/Vsechny(Type in 1/2/3): ");
					try{
						Integer skupinaProVypis = sc.nextInt();
						Funkce.vypisStudentu(skupinaProVypis);
						
						}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 6:	//vypis prumeru vsech studentu podle skupiny
					System.out.println("Zadejte skupinu, ktere chcete vypsat prumer Komunikace/Kyberbezpecnost/Vsech(Type in 1/2/3): ");
					try {
						Integer skupinaProPrumer = sc.nextInt();
						Funkce.vypisPrumeruStudentu(skupinaProPrumer);
					}
					catch(Exception e) {
						System.out.println("Spatny vstup");
					}
					break;
				case 7:	//vypis poctu studentu ve skupinach
					Funkce.pocetStudentuVeSkupine();
					}
			}
				
		}
		
			
		
	}


