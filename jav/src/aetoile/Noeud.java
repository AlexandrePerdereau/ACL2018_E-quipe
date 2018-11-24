package aetoile;

import java.util.LinkedList;

import element.Heros;

public class Noeud implements Comparable<Object>{
	int x , y ; // position du noeud en pixel
	int cout; //cout pour aller du depart vers le noeud
	int heuristique;  // cout + distance au noeud d'arrive
	Noeud precedent; 

	public Noeud(int x, int y, int pas, Heros cible,Noeud precedent) {

		this.x = x;
		this.y = y;
		if (precedent!=null){
			this.cout = precedent.cout+pas*pas;}
		else cout=0;

		this.heuristique = cout + cible.distanceaucarre(x, y);
		this.precedent=precedent;
	}

	public Noeud(Noeud n){ // utilisation dans actualise()
		x=n.x; y = n.y;
		cout=n.cout;
		heuristique=n.heuristique;
		precedent=n.precedent;
	}

	public int compareTo(Object autrenoeud){

		if (this.heuristique < ((Noeud)autrenoeud).heuristique)
			return 1 ;
		else if (this.heuristique == ((Noeud)autrenoeud).heuristique) return 0;
		return -1;
	}

	public String toString(){
		return x+" , "+y+" , "+cout+" , "+heuristique; //pour voir
	}

	@Override
	public boolean equals(Object noeud){
		return ((Noeud)noeud).x == x && ((Noeud)noeud).y == y;
	}

	public boolean rentredanslaliste(LinkedList<Noeud> closedlist){
		/*retourne true si la liste ne contient pas le noeud
		 * avec les meme coord mais avec heuristique plus faible
		 * 
		 * */
		Noeud asupprimer = null;
		for (Noeud n:closedlist){
			if (n.getX()==this.x && n.getY()==this.y)
				if (this.heuristique>=n.getHeuristique())
					return false;
				else{ 
					asupprimer=n;
					break;
				}
		}
		if (asupprimer!=null)
		{
			closedlist.remove(asupprimer);
		}



		return true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}



	public Noeud getPrecedent() {
		return precedent;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getHeuristique() {
		return heuristique;
	}

	public void setHeuristique(int heuristique) {
		this.heuristique = heuristique;
	}




}
