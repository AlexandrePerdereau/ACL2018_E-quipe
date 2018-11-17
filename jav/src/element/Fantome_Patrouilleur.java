package element;

import java.util.ArrayList;

public class Fantome_Patrouilleur extends Monstre{

	public Fantome_Patrouilleur(int rayon, int facteurdevitesse, int[] point, int[] distance) {
		super(rayon, facteurdevitesse, point, distance);
		this.point=point;
		this.distance=distance;
		if (distance[0]!=0)this.setDirectionX(distance[0]/Math.abs(distance[0]));
		if (distance[1]!=1)this.setDirectionY(distance[1]/Math.abs(distance[1]));
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
	

}
