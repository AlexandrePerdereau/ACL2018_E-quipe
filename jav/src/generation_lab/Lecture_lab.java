package generation_lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import element.Fantome_Patrouilleur;
import element.Heros;
import element.Magique;
import element.Monstre;
import element.Mur;
import element.Tresor;

public class Lecture_lab{



	protected ArrayList<Mur> listMur = new ArrayList<Mur>();
	protected Heros heros;
	protected String fichier;
	protected Tresor arrivee;
	protected ArrayList<Magique> lMagique = new ArrayList<Magique>();

	public ArrayList<Monstre> getListMonstre() {
		return listMonstre;
	}

	public void setListMonstre(ArrayList<Monstre> listMonstre) {
		this.listMonstre = listMonstre;
	}



	protected ArrayList<Monstre> listMonstre = new ArrayList<Monstre>();
	protected ArrayList<Fantome_Patrouilleur> listFantomePatrouilleur = new ArrayList<Fantome_Patrouilleur>();



	public Lecture_lab(String fichier)  throws IOException {


		this.fichier = fichier;
		Fichier f = new Fichier();

		f.ouvrir(fichier, "R");
		String[] champ = new String[10];
		String line = f.lire();
		

		while(line!=null && line.length() >= 2) {

			//chaine = f.lire();
			System.out.println(line);
			champ = line.split(",");
			if (champ != null) {
				if (champ[0].equals("Tresor") && arrivee == null)arrivee = new Tresor(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]), Integer.parseInt(champ[4]));

				if (champ[0].equals("Magique")){Magique m = new Magique(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]),Integer.parseInt(champ[4]),champ[5]);System.out.println(champ[5]);
				lMagique.add(m);
				}

				if (champ[0].equals("Mur")) {
					Mur mur = new Mur(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]), Integer.parseInt(champ[4]));
					listMur.add(mur);

				}
				if (champ[0].equals("Heros") && heros == null) {
					Heros hero = new Heros(Integer.parseInt(champ[1]), Integer.parseInt(champ[2]), Integer.parseInt(champ[3]),Integer.parseInt(champ[4]),Integer.parseInt(champ[5]));
					heros = hero;

				}

				if (champ[0].equals("Monstre")) {
					ArrayList<Integer> pointA = new ArrayList<Integer>();
					for (int i =3 ; i<5;i++)pointA.add(Integer.parseInt(champ[i]));
					int[] point = new int[pointA.size()];
					for (int i=0;i<pointA.size();i++)point[i]=pointA.get(i);

					ArrayList<Integer> distaA = new ArrayList<Integer>();
					for (int i =5 ; i<7;i++)distaA.add(Integer.parseInt(champ[i]));
					int[] dista = new int[distaA.size()];


					for (int i=0;i<distaA.size();i++){dista[i]=distaA.get(i);System.out.println("a"+dista[i]);}

					Monstre monstre = new Monstre( Integer.parseInt(champ[1]),Integer.parseInt(champ[2]),point,dista);
					listMonstre.add(monstre);
					System.out.println("testmonstre");
				}
				if (champ[0].equals("Fantome patrouilleur")) {
					ArrayList<Integer> pointA = new ArrayList<Integer>();
					for (int i =3 ; i<5;i++)pointA.add(Integer.parseInt(champ[i]));
					int[] point = new int[pointA.size()];
					for (int i=0;i<pointA.size();i++)point[i]=pointA.get(i);

					ArrayList<Integer> distaA = new ArrayList<Integer>();
					for (int i =5 ; i<7;i++)distaA.add(Integer.parseInt(champ[i]));
					int[] dista = new int[distaA.size()];


					for (int i=0;i<distaA.size();i++){dista[i]=distaA.get(i);System.out.println("a"+dista[i]);}

					Fantome_Patrouilleur fantomePat = new Fantome_Patrouilleur( Integer.parseInt(champ[1]),Integer.parseInt(champ[2]),point,dista);
					listFantomePatrouilleur.add(fantomePat);
					System.out.println("testfantomepat");
				}



			}line = f.lire();
		}
		f.fermer();



	}

	public Tresor getArrivee() {
		return arrivee;
	}

	public void setArrivee(Tresor arrivee) {
		this.arrivee = arrivee;
	}

	public ArrayList<Magique> getlMagique() {
		return lMagique;
	}

	public void setlMagique(ArrayList<Magique> lMagique) {
		this.lMagique = lMagique;
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
