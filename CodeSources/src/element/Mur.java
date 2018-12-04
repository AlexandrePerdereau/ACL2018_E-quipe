package element;

import java.util.ArrayList;

public class Mur {
	
	private int posx, posy, longx, longy;

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getLongx() {
		return longx;
	}

	public void setLongx(int longx) {
		this.longx = longx;
	}

	public int getLongy() {
		return longy;
	}

	public void setLongy(int longy) {
		this.longy = longy;
	}

	public Mur(int posx, int posy, int longx, int longy){
		this.posx = posx;
		this.posy = posy;
		this.longx = longx;
		this.longy = longy;
	}
	
	public static boolean esthorsmur(int X,int Y ,int rayon, ArrayList<Mur> lM){
		/*on va faire une approx comme quoi le monstre traqueur ne doit pas froler le mur
		 * trop compliquer sinon
		 * 
		 * 
		 * */
		for (Mur m : lM){
			if ((m.getPosx()<X+rayon && m.getPosx()+m.getLongx()>X-rayon)
				&& (m.getPosy()<Y+rayon && m.getPosy()+m.getLongy()>Y-rayon))
				return false;
		}
		
		return true;
	}
	
	
	
	
	

}