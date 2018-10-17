

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lecture_lab {
	protected static String nom;
	protected static int posx;
	protected static int posy;
	protected static int longx;
	protected static int longy;
	protected static int rayon;
	
	
	public static void main(String[] arg) throws IOException {
		
		String fichier = "test-lect.txt";
		Fichier f = new Fichier();

		f.ouvrir(fichier, "R");
		String[] champ = new String[10];
		String line = "";
		
		while((line= f.lire()).length() >= 2) {
			
			//chaine = f.lire();
			
			champ = line.split(",");
			if (champ != null) {
				nom = champ[0];
				
				if (nom == "Mur") {
					Mur mur = new Mur(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]), Integer.parseInt(champ[4]));
				}
				if (nom == "Heros") {
					deplacement.Heros heros = new deplacement.Heros(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]));
				}

		
			System.out.println(champ[0] + "," + champ[1] + "," + champ[2] + "," + champ[3]);
			}

		}
		f.fermer();
	}

	

}
