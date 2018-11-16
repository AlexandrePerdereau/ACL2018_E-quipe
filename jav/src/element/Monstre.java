package element;

public class Monstre extends Personnage {
	private int[] point; // point de depart
	private int[] distance; //distance a parcourir dans chaque direction, peut etre negatif


	public Monstre(int rayon ,int facteurdevitesse , int[] point, int []distance) {
		super(point[0], point[1], rayon , facteurdevitesse);
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



}
