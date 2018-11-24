package aetoile;

import java.util.ArrayList;
import java.util.Collections;

public class ListePriorite {
	public ArrayList<Noeud>  list ;

	public ListePriorite() {
		
		this.list = new ArrayList<Noeud>();
	}
	
	public void add(Noeud n){
		list.add(n);
		Collections.sort(list);
	}
	
	public boolean isvide(){
		return list.isEmpty();
	}
	
	public Noeud depile(){
		Noeud n = list.get(0);
		list.remove(0);
		return n;
		
	}
	

}
