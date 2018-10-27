package element;

import java.util.ArrayList;

public abstract class Personnage {
	private int x;
	private int y;
	private int rayon;
	private int directionX;
	private int directionY;
	private int facteurdevitesse=5;

	public int getFacteurdevitesse() {
		return facteurdevitesse;
	}

	public void setFacteurdevitesse(int facteurdevitesse) {
		this.facteurdevitesse = facteurdevitesse;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

	public Personnage (int x, int y , int rayon){
		this.x=x;
		this.y=y;
		this.rayon=rayon;
	}
	
	public boolean peutAvancer( ArrayList<Mur> m ){
		for (Mur mur : m ){
			if (this.directionX==1){
				if (this.y +this.rayon> mur.getPosy() && this.y -this.rayon<mur.getPosy()+mur.getLongy()){
					if (this.x+this.rayon<=mur.getPosx() && this.x+this.rayon>mur.getPosx())
						return false;
				}
			}
		}
		return true;
	}
}
