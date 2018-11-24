package element;

import java.util.ArrayList;
import java.util.LinkedList;

import aetoile.*;
import generation_lab.Lecture_lab;
import graph.Dessin;
//je me suis inspirer du pseudo code fournit par wikipedia
public class MonstreTraqueur extends Personnage{
	ArrayList<Integer[]> chemin = new ArrayList<Integer[]>(); //le chemin des points
	int pixelX , pixelY ; //taille de la map
	ArrayList<Mur> lMur;
	Heros cible;
	long temps;
	
	


	public long getTemps() {
		return temps;
	}

	public void setTemps(long temps) {
		this.temps = temps;
	}

	public MonstreTraqueur(int x, int y, int rayon, int facteurdevitesse, int pv ,Dessin dess) {
		super(x, y, rayon, facteurdevitesse, pv);
		pixelX=dess.getPixelX();
		pixelY=dess.getPixelY();
		lMur = dess.getlMur();
		cible = dess.getPerso();

	}

	public void actualise(){
		System.out.println("actualisation ou initialisation de notre chemin");
		Noeud n = Aetoile();
		System.out.println("n");
		Noeud p = n.getPrecedent();
		while (p!=null){
			System.out.println("parcours");
			Integer[] pointsuivant ={n.getX(),n.getY()}; 
			chemin.add(0,pointsuivant);
			n=p;
			p=n.getPrecedent();
		}

	}



	public void bouge(){
		try{
			Integer[] i = this.chemin.get(0);
			this.setX(i[0]);
			this.setY(i[1]);
			chemin.remove(0);
		}
		catch(Exception e){
			System.out.println("il faut actualiser plus vite");
		}

	}



	private Noeud Aetoile(){
		Noeud depart = new Noeud(x,y,facteurdevitesse,cible,null);
		ListePriorite openList = new ListePriorite();
		openList.add(depart);
		Noeud n = depart;
		LinkedList<Noeud> closedList = new LinkedList<Noeud>();
		double contactcarre = Math.pow(this.getRayon()+cible.getRayon(),2);
		System.out.println("cc"+contactcarre);
		while (Math.pow(n.getX()-cible.getX(),2)+Math.pow(n.getY()-cible.getY(),2)>2*contactcarre){
			n=openList.depile();
			System.out.println(n);
			ajoutAdjacent(n,openList,closedList);
		}
		temps=System.currentTimeMillis();
		return n;
	}

	private void ajoutAdjacent(Noeud n,ListePriorite openList,LinkedList<Noeud> closedList){
		int x = n.getX() , y = n.getY();
		for (int i=-1; i<=1; i++){
			int xi = x+i*facteurdevitesse;
			for (int j=-1; j<=1; j++){
				int yj = y+j*facteurdevitesse;
				if (!((xi<0)  || (xi>=pixelX)))

					if (!((yj<0)  || (yj>=pixelY)))
						if (!(i==0 && j==0))
							if (Mur.esthorsmur(xi,yj,this.getRayon(),lMur)){

								Noeud nouv = new Noeud(xi,yj,facteurdevitesse,cible,n);
								if (nouv.rentredanslaliste(closedList) && nouv.rentredanslaliste(openList)){
									openList.add(nouv);
								}
							}
			}
			
			if (n.rentredanslaliste(closedList)){
			
			closedList.add(n);}
		}



	}
}