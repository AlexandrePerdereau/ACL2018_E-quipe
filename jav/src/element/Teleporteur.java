package element;

public class Teleporteur extends Element_marchable{
	private Teleporteur Tp;
	
	

	private Teleporteur getTp() {
		return Tp;
	}

	private void setTp(Teleporteur tp) {
		Tp = tp;
	}

	private Teleporteur(int x, int y, int LongX, int LongY) {
		super(x, y, LongX, LongY);
		
	}
	
	private void liertp(Teleporteur tp2){
		tp2.setTp(this);
		this.setTp(tp2);
	}
	
	public static Teleporteur[] creationTP(int x1, int y1, int x2, int y2, int LongX, int LongY){
		/*creer 2 tp imbrique
		 * (je suppose leurs taille egal)
		 * */
		Teleporteur tp1 = new Teleporteur(x1,y1,LongX,LongY);
		Teleporteur tp2 = new Teleporteur(x2,y2,LongX,LongY);
		tp1.liertp(tp2);
		Teleporteur[] TP ={tp1,tp2};
		return TP;

	}
	
	public void teleportation(Heros h){
		h.setX(Tp.getX()+Tp.getLongX()/2);
		h.setY(Tp.getY()+Tp.getLongY()/2);

	}
	
	

}
