package element;

public abstract class Element_marchable {

	private int x;
	private int y;
	private int longX;
	private int longY;
	

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

	public int getLongX() {
		return longX;
	}

	public void setLongX(int larg) {
		this.longX = larg;
	}
	
	public void setLongY(int haut) {
		this.longY = haut;
	}
	
	public int getLongY() {
		return longY;
	}

	public Element_marchable(int x, int y, int longX, int longY) {
		this.x = x;
		this.y = y;
		this.longX = longX;
		this.longY = longY;
		
	}

	public boolean pietinee(Heros Aventurier) {
		//On détermine si le centre de la zone est sous le héros en abscisse.
		boolean horizontal = (Aventurier.getX() + Aventurier.getRayon() >= (this.getX() + this.getLongX())/2) || (Aventurier.getX() - Aventurier.getRayon() <= (this.getX() + this.getLongX())/2);
		//On détermine si le centre de la zone est sous le héros en ordonnée.
		boolean vertical = (Aventurier.getY() + Aventurier.getRayon() >= (this.getY() + this.getLongY())/2) || (Aventurier.getY() - Aventurier.getRayon() <= (this.getY() + this.getLongY())/2);
		//Si les deux sont vrais, alors le héros marche sur le centre de la zone.		
		return (horizontal && vertical);
	}
}
