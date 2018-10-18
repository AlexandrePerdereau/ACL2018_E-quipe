package graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import element.Mur;

public class Dessin extends JPanel implements KeyListener {
	
	private ArrayList<Mur> lMur=new ArrayList<Mur>();
	private element.Heros perso;
	
	
	public Dessin(ArrayList<Mur> lMur,	element.Heros perso){
		setFocusable(true);
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("testestest");
		 {
		        if(e.getKeyCode()==KeyEvent.VK_Q)
		            perso.setX(perso.getX()-10);
		       
		        if(e.getKeyCode()==KeyEvent.VK_D)
		        	perso.setX(perso.getX()+10);
		       
		        if(e.getKeyCode()==KeyEvent.VK_S)
		        	perso.setY(perso.getY()+10);
		       
		        if(e.getKeyCode()==KeyEvent.VK_Z)
		        	perso.setY(perso.getY()-10);
		        
		        repaint();
		     }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("testestest");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("testestest");
		
	}

}
