package element;

import java.util.ArrayList;
import element.Mur;

public abstract class Personnage {
	protected int x;
	protected int y;
	protected int rayon;
	protected int directionX;
	protected int directionY;
	protected int facteurdevitesse=5;
	private int pointdevie=3;
	
	public void perdPV(int p){
		pointdevie-=1;
	}

	public int distanceaucarre(Personnage autre){
		return (x-autre.x)*(x-autre.x)+(y-autre.y)*(y-autre.y);
	}
	
	public int distanceaucarre(int Px, int Py){
		return (x-Px)*(x-Px)+(y-Py)*(y-Py);
	}
	
	public int getPointdevie() {
		return pointdevie;
	}

	public void setPointdevie(int pointdevie) {
		this.pointdevie = pointdevie;
	}

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

	protected Personnage (int x, int y , int rayon , int facteurdevitesse,int pv){
		this.x=x;
		this.y=y;
		this.rayon=rayon;
		this.facteurdevitesse=facteurdevitesse;
		this.pointdevie=pv;
	}
	
	protected Personnage (int x, int y , int rayon , int facteurdevitesse,int directionX,	int directionY,int pv){ //utliser par monstre nottament qui a une direction par defaut
		this.x=x;
		this.y=y;
		this.rayon=rayon;
		this.facteurdevitesse=facteurdevitesse;
		this.directionX=directionX; this.directionY=directionY;
		this.pointdevie=pv;
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
					

					if (this.x+this.rayon<=X && this.x+this.directionX*this.facteurdevitesse+this.rayon>X){
						return false;}

				}


			}
			if (this.directionX==-1){ //vers la gauche

				
				
					if (this.y+this.rayon+this.directionY*this.facteurdevitesse>Y && this.y-this.rayon+this.directionY*this.facteurdevitesse<Y+LY){
						if (this.x-this.rayon>=X+LX && this.x-this.facteurdevitesse-this.rayon<X+LX){
							return false ;
						}
					}
				
			}
			//collision verticale
			if (this.directionY==1){ // vers le bas

				if (this.x+this.rayon+this.directionX*this.facteurdevitesse>X && this.x-this.rayon+this.facteurdevitesse*this.directionX<X+LX){
					if (this.y+this.rayon<=Y && this.y+this.facteurdevitesse+this.rayon>Y){
						return false ;
					}

				}

			}

			if (this.directionY==-1){ //vers le haut
				if (this.x+this.rayon+this.directionX*this.facteurdevitesse>X && this.x-this.rayon+this.facteurdevitesse*this.directionX<X+LX){
					if (this.y-this.rayon>=Y+LY && this.y-this.facteurdevitesse-this.rayon<Y+LY){
						return false ;
					}

				}
			}

		}
		
		return true;
	}
	
	public boolean bouge(ArrayList<Mur> lMur){
		if  (this.peutAvancer( lMur )){
			this.setX(x+directionX*facteurdevitesse);
			this.setY(y+directionY*facteurdevitesse);
			return true;
		}
		return false;
	}
	
	
	
}
