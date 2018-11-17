package element;

import java.util.ArrayList;

public class Heros extends Personnage {
	private int attaqueX=0, attaqueY=0 ,portee=10;
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
	public Heros (int x, int y , int rayon, int facteurdevitesse, int portee ,int pv){
		super(x,y,rayon,facteurdevitesse,pv);
		this.portee=portee;
	}
	
	private static double distancedroite(double xd1,double yd1,double xd2,double yd2,double x,double y) {


		double A = ( yd2-yd1 ) / ( xd2 - xd1) ;//A coeff directeur
		//yd2=Axd2+k
		double k = yd2-A*xd2;



		return Math.abs((-y+A*x+k)/Math.sqrt(1+A*A)); //on retourne la distance de (x,d) a la droite passant par (xd1,yd1) et (xd2,yd2)
	}
	
	public int getPortee() {
		return portee;
	}
	public void setPortee(int portee) {
		this.portee = portee;
	}
	public int monstredroite2points(Monstre m){
		int gx = this.getX();
		int gy = this.getY();
		if (this.distanceaucarre(m)>portee*portee)return m.distanceaucarre(gx+attaqueX*portee,gy+attaqueY*portee) ;
		
		return (int) distancedroite((double)gx,(double)gy,(double)(gx+attaqueX*portee),(double)(gy+attaqueY*portee),(double)m.getX(),(double)m.getY());
	}
	
	
}
