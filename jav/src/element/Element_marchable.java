package element;

public abstract class Element_marchable {

	private int x;
	private int y;
	private int LongX;
	private int LongY;
	

	public int getLongX() {
		return LongX;
	}

	public void setLongX(int longX) {
		LongX = longX;
	}

	public int getLongY() {
		return LongY;
	}

	public void setLongY(int longY) {
		LongY = longY;
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

	

	

	public Element_marchable(int x, int y, int LongX , int LongY) {
		this.x = x;
		this.y = y;
		this.LongX=LongX;
		this.LongY=LongY;

		
	}

	public boolean pietinee(Heros Aventurier) {
		int distancec=0;
		distancec+=Math.pow(Aventurier.getX()-this.x-LongX/2,2);
		distancec+=Math.pow(Aventurier.getY()-this.y-LongY/2,2);
		return distancec<Aventurier.getRayon();
		
		
	}
}
