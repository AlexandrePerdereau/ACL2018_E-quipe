package element;

public class Magique extends Element_marchable{
	String effect;
	public Magique(int x, int y, int LongX,int LongY,String s) {
		super(x, y, LongX, LongY);
		this.effect=s;
	}

	public void appeffect(Heros h){
		System.out.println("effetapp:"+effect);

		String[] s = this.effect.split("E");
		for (String so:s)System.out.println(so);

		if (s[0].equals("vitesse")){

			h.setFacteurdevitesse(h.getFacteurdevitesse()*Integer.parseInt(s[1]));
			System.out.println("vitesse*"+s[1]);
		}
		
		else if (s[0].equals("soin")){
			
		}
		
		else if (s[0].equals("tuermonstre")){
			
		}
		



	}

	

	

}
