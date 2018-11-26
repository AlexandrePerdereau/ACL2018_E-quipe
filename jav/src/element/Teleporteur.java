package element;

public class Teleporteur extends Element_marchable{
	Heros hero;
	Teleporteur tpAutre;
	
	public Teleporteur(int x, int y,int LongX,int LongY) {
		super(x, y, LongX, LongY);
		
	}
	
	private Teleporteur(Teleporteur tp1,Teleporteur tp2) {
		this.LierTP(tp2);
	}
	
	
	
	public void LierTP(Teleporteur tp2) {
		if (this.pietinee(hero)) {
			hero.setX(tp2.getX());
			hero.setY(tp2.getY());
		}
	}

}
