package element;

import java.util.ArrayList;
import java.util.LinkedList;

import aetoile.*;
import generation_lab.Lecture_lab;
import graph.Dessin;
//je me suis inspirer du pseudo code fournit par wikipedia
public class MonstreTraqueur extends Personnage{
	ArrayList<Noeud> lNoeud = new ArrayList<Noeud>();
	int pixelX , pixelY ; //taille de la map
	ArrayList<Mur> lMur;
	Heros cible;
	

	public MonstreTraqueur(int x, int y, int rayon, int facteurdevitesse, int pv ,Dessin dess) {
		super(x, y, rayon, facteurdevitesse, pv);
		pixelX=dess.getPixelX();
		pixelY=dess.getPixelY();
		lMur = dess.getlMur();
		cible = dess.getPerso();

	}

	/*private void Aetoile(Noeud depart, Noeud arrivee){

		ListePriorite openList = new ListePriorite();
		openList.add(depart);
		while (!openList.isvide()){
			Noeud n = openList.depile();
			if (n.equals(arrivee)){
				//ce sera la fin
			}


		}
	}*/

	private void ajoutAdjacent(Noeud n,ListePriorite openList,LinkedList<Noeud> closeList){
		int x = n.getX() , y = n.getY();
		for (int i=-1; i<=1; i++){
			int xi = x+i*facteurdevitesse;
			if ((xi<0)  || (xi>=pixelX))
				break; //si en dehors de l'image abscisse , peut pas
			for (int j=-1; j<=1; j++){
				int yj = y+j*facteurdevitesse;

				if ((yj<0)  || (yj>=pixelY))
					break; //si en dehors de l'image ordonnee, peut pas
				if (i==0 && j==0)
					break; //point central , pas adj
				Noeud nouv = new Noeud(xi,yj,facteurdevitesse,cible,n);
			}
		}



	}
}