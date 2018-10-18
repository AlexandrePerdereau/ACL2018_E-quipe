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
		System.out.println("clefpress");
		 {
		        if(e.getKeyCode()==KeyEvent.VK_Q || e.getKeyCode()==KeyEvent.VK_LEFT)
		            perso.setX(perso.getX()-5);
		       
		        if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT)
		        	perso.setX(perso.getX()+5);
		       
		        if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN)
		        	perso.setY(perso.getY()+5);
		       
		        if(e.getKeyCode()==KeyEvent.VK_Z || e.getKeyCode()==KeyEvent.VK_UP)
		        	perso.setY(perso.getY()-5);
		        
		        repaint();
		     }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clefrelach");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("cleftap");
		
	}

}
