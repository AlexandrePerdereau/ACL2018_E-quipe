package aetoile;

public class Noeud implements Comparable<Object>{
    int x , y ; // position du noeud en pixel
    int cout; //cout pour aller du depart vers le noeud
    int heuristique;  // cout + distance au noeud d'arrive
	
    public Noeud(int x, int y, int cout, int heuristique) {
		
		this.x = x;
		this.y = y;
		this.cout = cout;
		this.heuristique = heuristique;
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

	
	
    
}
