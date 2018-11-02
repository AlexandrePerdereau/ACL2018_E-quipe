package generation_lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import element.Heros;
import element.Monstre;
import element.Mur;

public class Lecture_lab{
	


	protected ArrayList<Mur> listMur = new ArrayList<Mur>();
	protected Heros heros;
	protected String fichier;
	public ArrayList<Monstre> getListMonstre() {
		return listMonstre;
	}

	public void setListMonstre(ArrayList<Monstre> listMonstre) {
		this.listMonstre = listMonstre;
	}



	protected ArrayList<Monstre> listMonstre = new ArrayList<Monstre>();
	
	
	
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
					Heros hero = new Heros(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]),Integer.parseInt(champ[4]));
					heros = hero;
					
				}
				
				if (champ[0].equals("Monstre")) {
					ArrayList<Integer> carac = new ArrayList<Integer>();
					for (int i =6 ; i<champ.length;i++)carac.add(Integer.parseInt(champ[i]));
					int[] caracs = new int[carac.size()];
					for (int i=0;i<carac.size();i++)caracs[i]=carac.get(i);
					Monstre monstre = new Monstre(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]),Integer.parseInt(champ[4]),Boolean.getBoolean(champ[5]),caracs);
					listMonstre.add(monstre);
					System.out.println("testmonstre");
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
