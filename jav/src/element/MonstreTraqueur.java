package element;

import java.util.LinkedList;

import aetoile.*;
import generation_lab.Lecture_lab;
//je me suis inspirer du pseudo code fournit par wikipedia
public class MonstreTraqueur extends Personnage{
	LinkedList<Noeud> lNoeud = new LinkedList<Noeud>();

	public MonstreTraqueur(int x, int y, int rayon, int facteurdevitesse, int pv ,Lecture_lab Ll) {
		super(x, y, rayon, facteurdevitesse, pv);
		// TODO Auto-generated constructor stub
	}
	
	private void Aetoile(Noeud depart, Noeud arrivee){
		
		ListePriorite openList = new ListePriorite();
		openList.add(depart);
		while (!openList.isvide()){
			Noeud n = openList.depile();
			if (n.equals(arrivee)){
				//ce sera la fin
			}
			
			
		}
	}
	
	

}
