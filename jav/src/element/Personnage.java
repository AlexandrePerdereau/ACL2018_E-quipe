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
		/* tres surement ameliorable : moyen de systematiser au lieu de cas par cas je pense*/
		for (Mur mur : m ){
			int X=mur.getPosx();
			int Y=mur.getPosy();
			int LX=mur.getLongx();
			int LY=mur.getLongy();

			//collision horizontale
			if (this.directionX==1){ //vers la droite


				if (this.y+this.rayon+this.directionY*this.facteurdevitesse>Y && this.y-this.rayon+this.directionY*this.facteurdevitesse<Y+LY){
					System.out.println("TESTCOMPA");

					if (this.x+this.rayon<=X && this.x+this.directionX*this.facteurdevitesse+this.rayon>X){
						System.out.println("BLOCAGE11");return false;}

				}


			}
			if (this.directionX==-1){ //vers la gauche

				
				
					if (this.y+this.rayon+this.directionY*this.facteurdevitesse>Y && this.y-this.rayon+this.directionY*this.facteurdevitesse<Y+LY){
						if (this.x-this.rayon>=X+LX && this.x-this.facteurdevitesse-this.rayon<X+LX){
							System.out.println("BLOCAGE21");return false ;
						}
					}
				
			}
			//collision verticale
			if (this.directionY==1){ // vers le bas

				if (this.x+this.rayon+this.directionX*this.facteurdevitesse>X && this.x-this.rayon+this.facteurdevitesse*this.directionX<X+LX){
					if (this.y+this.rayon<=Y && this.y+this.facteurdevitesse+this.rayon>Y){
						System.out.println("BLOCAGEV1");return false ;
					}

				}

			}

			if (this.directionY==-1){ //vers le haut
				if (this.x+this.rayon+this.directionX*this.facteurdevitesse>X && this.x-this.rayon+this.facteurdevitesse*this.directionX<X+LX){
					if (this.y-this.rayon>=Y+LY && this.y-this.facteurdevitesse-this.rayon<Y+LY){
						System.out.println("BLOCAGEV2");return false ;
					}

				}
			}

		}
		System.out.println("sa passe");
		return true;
	}
}
