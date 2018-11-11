package element;

public class Monstre extends Personnage {
	 private int[] point; // point de depart
	 private int[] distance; //distance a parcourir dans chaque direction, peut etre negatif
	
	 
	public Monstre(int x, int y, int rayon ,int facteurdevitesse ,boolean b, int[] point, int []distance) {
		super(x, y, rayon , facteurdevitesse);
		this.point=point;
		this.distance=distance;
	}

}
