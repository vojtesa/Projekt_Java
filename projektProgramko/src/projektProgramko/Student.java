package projektProgramko;

import java.util.ArrayList;
import java.util.List;

public abstract class Student {
	private String jmeno;
	private String prijmeni;
	private Integer rokNarozeni;
	private Integer ID;
	private String skupina;
	private List<Double> znamky = new ArrayList<Double>();
	
	public Student(String jmeno, String prijmeni, Integer rokNarozeni) {
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.rokNarozeni = rokNarozeni;
	}
	
	
	public void setZnamka(double znamka) {
		if(znamka >= 1 && znamka <= 5) {
			znamky.add(znamka);
		}
		else {
			System.out.println("Zadali jste cislo mimo rozsah 1 az 5");
		}
	} 
	
	public String vypisZnamek() {
		StringBuilder vystup = new StringBuilder();
		for (Double jednaZnamka:znamky) {
			vystup.append(jednaZnamka).append( ", ");
		}
		return vystup.toString();
	}
	
	public Double getPrumer() {
		Integer counter = 0;
		Double soucet = 0d;
		for(Double znamka:znamky) {
			soucet += znamka;
			counter++;
		}
		return (soucet/counter);
	}
	
	public boolean propusteniStudenta(Integer ID) {
		return false; // TODO
	}
	
	public abstract void dovednost();

	
	public void setID() {
		this.ID = Databaze.ID;
	}
	
	public Integer getID() {
		return ID;
	}
	
	public String getJmeno() {
		return jmeno;
	}
	public String getPrijmeni() {
		return prijmeni;
	}
	
	public Integer getRokNarozeni() {
		return rokNarozeni;
	}


	public String getSkupina() {
		return skupina;
	}


	public void setSkupina(String skupina) {
		this.skupina = skupina;
	}
	

}
