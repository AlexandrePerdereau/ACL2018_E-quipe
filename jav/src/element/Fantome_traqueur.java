package element;

import java.util.ArrayList;

public class Fantome_traqueur extends Monstre{

	public Fantome_traqueur(int rayon, int facteurdevitesse, int[] point, int[] distance) {
		super(rayon, facteurdevitesse, point, distance);
		this.point=point;
		this.distance=distance;
		
	}
	

	public int[] getPoint() {
		return point;
	}

	public void setPoint(int[] point) {
		this.point = point;
	}


	public int[] getDistance() {
		return distance;
	}


	public void setDistance(int[] distance) {
		this.distance = distance;
	}
	
	@Override
	public boolean peutAvancer( ArrayList<Mur> m ) {
		return true;
	}
	//Détermine la direction du monstre, elle dépend de la position du héros.
	public void traque(Heros Aventurier){
		this.setDirectionX((Aventurier.getX()-this.getPoint()[0])/Math.abs((Aventurier.getX()-this.getPoint()[0])));
		this.setDirectionX((Aventurier.getY()-this.getPoint()[1])/Math.abs((Aventurier.getY()-this.getPoint()[1])));
	}

}
