package generation_lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import element.Heros;
import element.Mur;

public class Lecture_lab {
	
	protected static ArrayList<Mur> listMur = new ArrayList<Mur>();
	protected static Heros heros;
	
	
	
	public static void main(String[] arg) throws IOException {
		
		String fichier = "test-lect.txt";
		Fichier f = new Fichier();

		f.ouvrir(fichier, "R");
		String[] champ = new String[3];
		String line = "";
		
		while((line= f.lire()).length() >= 2) {
			
			//chaine = f.lire();
			
			champ = line.split(",");
			if (champ != null) {
				
				
				if (champ[0] == "Mur") {
					Mur mur = new Mur(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]), Integer.parseInt(champ[4]));
					listMur.add(mur);
				}
				if (champ[0]== "Heros") {
					Heros hero = new Heros(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]));
					heros = hero;
					
				}

		
			System.out.println(champ[0] + "," + champ[1] + "," + champ[2] + "," + champ[3]);
			}

		}
		f.fermer();
	}

	

}
