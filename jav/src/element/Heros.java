package element;

public class Heros extends Personnage {
	private int attaqueX=0, attaqueY=0;
	public int getAttaqueX() {
		return attaqueX;
	}
	public void setAttaqueX(int attaqueX) {
		this.attaqueX = attaqueX;
	}
	public int getAttaqueY() {
		return attaqueY;
	}
	public void setAttaqueY(int attaqueY) {
		this.attaqueY = attaqueY;
	}
	public Heros (int x, int y , int rayon, int facteurdevitesse){
		super(x,y,rayon,facteurdevitesse);
	}
}
