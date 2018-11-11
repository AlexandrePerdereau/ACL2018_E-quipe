package element;

public class Magique extends Element_marchable{
private String effect = "";
	public Magique(int x, int y, int rayon,String effect) {
		super(x, y, rayon);
		this.effect=effect;
		
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
