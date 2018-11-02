package element;

public class Monstre extends Personnage {
	 private boolean estPatrouilleur;
	 private int[] caracs; // liste les caracs du monstre , pas la meme sens si patrouilleurs ou tete chercheuse
	//toutefois meme longueur ici plus pratique pour lecture_lab;
	 //dans le cas patrouilleur:
	 	//carac[0:1]=premier point
	 	//carac[2:3]=deuxieme point
	
	 
	public Monstre(int x, int y, int rayon ,int facteurdevitesse ,boolean b, int[] caracs) {
		super(x, y, rayon , facteurdevitesse);
		this.caracs=caracs;
		estPatrouilleur=b;
	}

}
