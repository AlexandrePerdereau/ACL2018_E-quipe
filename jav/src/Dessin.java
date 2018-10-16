import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Dessin extends JPanel {
	
	private ArrayList<Mur> lMur=new ArrayList<Mur>();
	private deplacement.Heros perso;
	
	public Dessin(ArrayList<Mur> lMur,	deplacement.Heros perso){
		setBackground(Color.WHITE);
		this.lMur=lMur;
		this.perso=perso;
	}
	
	public Dessin(){
		//sa c'est le dessin sans donnee
		setBackground(Color.WHITE);
		Mur m = new Mur(100,100,10,50);
		this.lMur.add(m);
	}
	
	public void paintComponent(Graphics g)  {
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		for (Mur m : lMur){
			g.fillRect(m.getPosx(), m.getPosy(), m.getLongx(), m.getLongy());
		}
	}

}
