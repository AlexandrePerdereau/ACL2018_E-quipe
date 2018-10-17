package generation_lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lecture_lab {
	public static void main(String[] arg) throws IOException {
		String fichier = "test-lect.txt";
		Fichier f = new Fichier();

		f.ouvrir(fichier, "R");
		String[] champ = new String[3];
		String chaine = "";
		String line = "";
		while((line= f.lire()).length() >= 2) {
			
			//chaine = f.lire();
			
			champ = line.split(",");
			if (champ != null) {

		
			System.out.println(champ[0] + "," + champ[1] + "," + champ[2] + "," + champ[3]);
			}

		}
		f.fermer();
	}

	/*
	 * try { lecteur = new BufferedReader(new FileReader(fichier));
	 * 
	 * }catch( FileNotFoundException e)
	 * 
	 * { e.printStackTrace(); }
	 * 
	 * try { while((line=lecteur.readLine()) != null){
	 * 
	 * 
	 * } } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } {
	 * 
	 * }
	 */

}
