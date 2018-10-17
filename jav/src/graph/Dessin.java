package graph;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import element.Mur;

public class Dessin extends JPanel {
	
	private ArrayList<Mur> lMur=new ArrayList<Mur>();
	private element.Heros perso;
	
	public Dessin(ArrayList<Mur> lMur,	element.Heros perso){
		setBackground(Color.WHITE);
		this.lMur=lMur;
		this.perso=perso;
	}
	
	public Dessin(element.Heros perso){
		//sa c'est le dessin sans donnee
		setBackground(Color.WHITE);
		Mur m = new Mur(100,100,10,50);
		this.lMur.add(m);
		this.perso = perso;
	}
	
	public void paintComponent(Graphics g)  {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		
		g.setColor(Color.RED);
		for (Mur m : lMur){
			g.fillRect(m.getPosx(), m.getPosy(), m.getLongx(), m.getLongy());
		}
		g.fillOval(perso.getX(), perso.getY(), perso.getRayon(), perso.getRayon());
	}

}
