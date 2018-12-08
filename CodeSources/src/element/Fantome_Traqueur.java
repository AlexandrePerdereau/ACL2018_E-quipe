package element;

public class Fantome_Traqueur extends MonstreGenerique{

	public Fantome_Traqueur(int x, int y, int rayon, int facteurdevitesse) {
		super(x, y, rayon, facteurdevitesse, 1);
		// TODO Auto-generated constructor stub
	}


	public void bouge(Heros h){
		System.out.println(h.getX());		System.out.println(h.getY());

		int diffY = h.getY()-y ;
		int diffX = h.getX()-x;

		directionX = (int)Math.signum(diffX);
		directionY = (int)Math.signum(diffY);

		x=x+directionX*facteurdevitesse;
		y=y+directionY*facteurdevitesse;

	}

}
