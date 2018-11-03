package element;

import java.util.ArrayList;
import element.Mur;

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

	public Personnage (int x, int y , int rayon , int facteurdevitesse){
		this.x=x;
		this.y=y;
		this.rayon=rayon;
		this.facteurdevitesse=facteurdevitesse;
	}

	public boolean peutAvancer( ArrayList<Mur> m ){ //return true si on peut passer dans la direction de X , false sinon
		for (Mur mur : m ){
			if (this.directionX==1){ 
				System.out.println("TESTBOUCLE");
				//geros le cas -> | |
				if (this.directionY==0 && this.y +this.rayon> mur.getPosy() && this.y -this.rayon<mur.getPosy()+mur.getLongy()){
					System.out.println("TESTCOMPA1");

					if (this.x+this.rayon<=mur.getPosx() && this.x+this.directionX*this.facteurdevitesse+this.rayon>mur.getPosx()){
						System.out.println("BLOCAGE1");return false;}
				}

				//maintenant geros le cas droite mais on va en bas
				if (this.directionY==1){
					if (this.y+this.rayon+this.facteurdevitesse>mur.getPosy() && this.y-this.rayon+this.facteurdevitesse<mur.getPosy()+mur.getLongy()){
						System.out.println("TESTCOMPA");

						if (this.x+this.rayon<=mur.getPosx() && this.x+this.directionX*this.facteurdevitesse+this.rayon>mur.getPosx()){
							System.out.println("BLOCAGE11");return false;}
				//maintenant droite et haut



					}
				}


			}
			if (this.directionX==-1){
				if (this.y+this.rayon>mur.getPosy() && this.y-this.rayon<mur.getPosy()+mur.getLongy()){
					if (this.x-this.rayon>=mur.getPosx()+mur.getLongx() && this.x-this.facteurdevitesse-this.rayon<mur.getPosx()+mur.getLongx()){
						System.out.println("BLOCAGE2");return false ;
					}
				}
			}


		}
		System.out.println("sa passe");
		return true;
	}
}
