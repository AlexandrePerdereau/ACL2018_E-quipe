package element;

public abstract class MonstreMateriel extends MonstreGenerique {
	
	protected long timermonstretouche;
	
	

	public long getTimermonstretouche() {
		return timermonstretouche;
	}

	public void setTimermonstretouche(long timermonstretouche) {
		this.timermonstretouche = timermonstretouche;
	}

	public MonstreMateriel(int x, int y, int rayon, int facteurdevitesse, int directionX, int directionY, int pv) {
		super(x, y, rayon, facteurdevitesse, directionX, directionY, pv);
		// TODO Auto-generated constructor stub
	}

	public MonstreMateriel(int x, int y, int rayon, int facteurdevitesse, int pv) {
		super(x, y, rayon, facteurdevitesse, pv);
		// TODO Auto-generated constructor stub
	}

}
