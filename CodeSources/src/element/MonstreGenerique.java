package element;

import graph.Visuel;

public abstract class MonstreGenerique extends Personnage{

	protected MonstreGenerique(int x, int y, int rayon, int facteurdevitesse, int directionX, int directionY, int pv) {
		super(x, y, rayon, facteurdevitesse, directionX, directionY, pv);
		// TODO Auto-generated constructor stub
	}
	

	public MonstreGenerique(int x, int y, int rayon, int facteurdevitesse, int pv) {
		super(x, y, rayon, facteurdevitesse, pv);
		// TODO Auto-generated constructor stub
	}


	public boolean Collision(Heros h){
		
		
		if (h.distanceaucarre(this)<(h.rayon+this.rayon)*(h.rayon+this.rayon)){
			h.setPointdevie(0);
			Visuel.partieencours=false;
			return true;
		}
		
		return false;
	}

}
