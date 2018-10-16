import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Dessin extends JPanel {
	
	private ArrayList<Mur> lMur;
	private deplacement.Heros perso;
	
	public Dessin(ArrayList<Mur> lMur,
	deplacement.Heros perso){
		setBackground(Color.WHITE);
		this.lMur=lMur;
		this.perso=perso;
	}
	
	public void paintComponent(Graphics g)  {
		super.paintComponent(g);
		g.setColor(Color.RED);
		for (Mur m : lMur){
			g.drawRect(m.getPosx(), m.getPosy(), m.getLongx(), m.getLongy());
		}
	}

}
