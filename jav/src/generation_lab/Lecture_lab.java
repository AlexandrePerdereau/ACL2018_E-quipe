package generation_lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import element.Heros;
import element.Mur;

public class Lecture_lab{
	


	protected ArrayList<Mur> listMur = new ArrayList<Mur>();
	protected Heros heros;
	protected String fichier;
	
	
	
	public Lecture_lab(String fichier)  throws IOException {
		
		
		this.fichier = fichier;
		Fichier f = new Fichier();

		f.ouvrir(fichier, "R");
		String[] champ = new String[10];
		String line = "";
		
		while((line= f.lire()).length() >= 2) {
			
			//chaine = f.lire();
			
			champ = line.split(",");
			if (champ != null) {
				System.out.println("testchamp");
				System.out.println(champ[0]);
				if (champ[0].equals("Mur")) {
					Mur mur = new Mur(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]), Integer.parseInt(champ[4]));
					listMur.add(mur);
					System.out.println("testmur");
				}
				if (champ[0].equals("Heros")) {
					Heros hero = new Heros(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]));
					heros = hero;
					
				}

		
			System.out.println(champ[0] + "," + champ[1] + "," + champ[2] + "," + champ[3]);

		}
	}
		f.fermer();
		
	
		
	}

	public ArrayList<Mur> getListMur() {
		return listMur;
	}



	public void setListMur(ArrayList<Mur> listMur) {
		this.listMur = listMur;
	}



	public Heros getHeros() {
		return heros;
	}



	public void setHeros(Heros heros) {
		this.heros = heros;
	}



}
