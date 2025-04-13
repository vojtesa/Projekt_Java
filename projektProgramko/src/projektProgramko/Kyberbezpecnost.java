package projektProgramko;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Kyberbezpecnost extends Student{

	public Kyberbezpecnost(String jmeno, String prijmeni, Integer rokNarozeni) {
		super(jmeno, prijmeni, rokNarozeni);
	}

	@Override
	public void dovednost() {
		String jmeno = getJmeno() + getPrijmeni();
		String hashString = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte hash [] = md.digest(jmeno.getBytes());
			
			for(byte osmice:hash) {
				hashString += String.format("%02x", osmice);	//formatovaci retezec, jak ma byt kazdy byte formatovan
			}
			System.out.print("Jmeno a prijmeni do hashe s pouzitim SHA-256 (v hexadecimalni podobe): " + getJmeno() + " " + getPrijmeni() + 
		 			" -> " + hashString + "\t" + "\n\n");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
