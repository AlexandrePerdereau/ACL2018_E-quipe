package element;

public class Magique extends Zone{
private String effet;
	public Magique(int x, int y, int longX, int longY, String effect) {
		super(x, y, longX, longY);
		this.effet=effect;
		
	}
	public void setEffet(String type){
		this.effet = type;
	}
	
	public String getEffet(){
		return this.effet;
	}
	
	public void declenchement(String type, Heros Aventurier){
		if (this.pietinee(Aventurier)){
			String sort = this.getEffet();
			if (sort == "vitesse") changeVitesse(Aventurier);
			if (sort == "santé") HP(Aventurier);
			if (sort == "foudre") tuerMonstre();
			if (sort == "passe-muraille") traverseMurs(Aventurier);

		}
	}
	
	public void changeVitesse(Heros h) {
		h.setFacteurdevitesse(h.getFacteurdevitesse() * 2);
	}
	
	public void HP(Heros h) {
		// ajouter 1 point par exemple
	}
	
	public void tuerMonstre() {
		// parcourir une liste de monstres et en tuer un au hasard avec rand par exemple
	}
	
	public void traverseMurs(Heros h) {
		// creer un booleen gérant l'activation ou non de collisions ?
	}
	

}
