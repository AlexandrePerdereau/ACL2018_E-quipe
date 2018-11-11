package element;

public abstract class Element_marchable {

	private int x;
	private int y;
	private int rayon;
	

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


	public Element_marchable(int x, int y, int rayon, boolean est_pietine) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		
	}

	public boolean pietine_par_heros(Heros h) {
		if (this.x == h.getX() && this.y == h.getY()) {
			return true;
		} else {
			return false;
		}
	}
}
