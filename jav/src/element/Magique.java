package element;

public class Magique extends Element_marchable{
String effect;
	public Magique(int x, int y, int LongX,int LongY,String s) {
		super(x, y, LongX, LongY);
		this.effect=s;
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
