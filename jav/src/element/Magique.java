package element;

public class Magique extends Element_marchable{

	public Magique(int x, int y, int rayon, boolean est_pietine) {
		super(x, y, rayon, est_pietine);
		
	}
	
	public void changeVitesse(Heros h) {
		h.setFacteurdevitesse(h.getFacteurdevitesse() * 2);
	}
	
	public void HP(Heros h) {
		// ajouter 1 point par exemple
	}
	
	public void tuerMonstre(Monstre m) {
		// parcourir une liste de monstres et en tuer un au hasard avec rand par exemple
	}
	
	public void traverserMurs(Heros h) {
		// creer un booleen gérant l'activation ou non de collisions ?
	}
	

}
