package element;

public class Piege extends Element_marchable{
	public Piege(int x, int y, int LongX,int LongY){
		super(x, y, LongX, LongY);
	}
	
	public static void seReferme(Heros Aventurier){
		Aventurier.setPointdevie(Aventurier.getPointdevie() - 1);
	}
}
