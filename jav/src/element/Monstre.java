package element;

import java.util.ArrayList;

public class Monstre extends MonstreMateriel {
	protected int[] point; // point de depart
	protected int[] distance; //distance a parcourir dans chaque direction, peut etre negatif


	public Monstre(int rayon ,int facteurdevitesse , int[] point, int []distance,int pv) {
		super(point[0], point[1], rayon , facteurdevitesse,pv);
		this.point=point;
		this.distance=distance;
		if (distance[0]!=0)this.setDirectionX(distance[0]/Math.abs(distance[0]));
		if (distance[1]!=0)this.setDirectionY(distance[1]/Math.abs(distance[1]));

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
	public boolean bouge(ArrayList<Mur> lMur){
		
			
			int newX=x+directionX*facteurdevitesse;
			int newY=y+directionY*facteurdevitesse;
			if (this.peutAvancer(lMur)
					&& Math.abs(newX-point[0])<=Math.abs(distance[0])
					&& Math.abs(newY-point[1])<=Math.abs(distance[1])){
				x=newX;
				y=newY;

			}
			else{
				directionX=-1*directionX;
				directionY=-1*directionY;
			}
		
		return true;
		
			
	}


}
