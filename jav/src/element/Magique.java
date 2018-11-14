package element;

public class Magique extends Element_marchable{
	private String effect;
	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public Magique(int x, int y, int LongX,int LongY, String s) {
		super(x, y, LongX, LongY);
		this.effect=s;
	}

	public void appeffect(Heros h){
		System.out.println("effetapp:"+effect);
		if (!effect.contains("E")){
			String[] s = this.effect.split("E"); // Sépare l'intitulé de l'effet de la valeur de son intensité : "{type d'effet} E {intensité de l'effet}"
			for (String so:s)System.out.println(so);

			if (s[0].equals("vitesse")){

				h.setFacteurdevitesse(h.getFacteurdevitesse()*Integer.parseInt(s[1]));
				System.out.println("vitesse*"+s[1]);
			}
		
			else if (s[0].equals("soin")){
				h.setPointdevie(h.getPointdevie() + Integer.parseInt(s[2]));
			}
		
			else if (s[0].equals("piege")){
				h.setPointdevie(h.getPointdevie() - Integer.parseInt(s[2]));
			}
		}

	}


}
