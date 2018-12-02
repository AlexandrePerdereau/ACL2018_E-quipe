package element;

public class Fantome_Traqueur extends MonstreGenerique{

	public Fantome_Traqueur(int x, int y, int rayon, int facteurdevitesse) {
		super(x, y, rayon, facteurdevitesse, 1);
		// TODO Auto-generated constructor stub
	}

	
	public void bouge(Heros h){
		int diffY = h.getY()-this.getY() ;
		int diffX = h.getX()-this.getX();
		int v = this.getFacteurdevitesse();
		if (diffX==0)diffY=v;
		else if (diffY>diffX) {
			diffY=v*(diffY/diffX);
			diffX=v;
		}
		else{
			if (diffY==0)diffX=v;
			else{
				diffX=v*(diffX/diffY);
				diffY=v;}
		}
		this.setX(this.getX()-diffX);
		this.setY(this.getY()-diffY);

	}

}
