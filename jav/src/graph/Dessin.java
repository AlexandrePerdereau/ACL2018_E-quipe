package graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import element.Monstre;
import element.Mur;

public class Dessin extends JPanel implements KeyListener {
	
	private ArrayList<Mur> lMur=new ArrayList<Mur>();
	protected element.Heros perso;
	private ArrayList<Monstre> lMonstre = new ArrayList<Monstre>();

	
	public Dessin(generation_lab.Lecture_lab lab){
		setFocusable(true);
		setBackground(Color.WHITE);
		this.lMur = lab.getListMur();
		this.perso = lab.getHeros();
		this.lMonstre = lab.getListMonstre();
	}
	
	public Dessin(ArrayList<Mur> lMur,	element.Heros perso){
		setFocusable(true);
		setBackground(Color.WHITE);
		this.lMur=lMur;
		this.perso=perso;
	}
	
	public Dessin(element.Heros perso){
		//sa c'est le dessin sans donnee
		setFocusable(true);
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
		g.setColor(Color.MAGENTA);
		for (Monstre monstre : lMonstre){
			g.fillOval(monstre.getX(), monstre.getY(), monstre.getRayon(), monstre.getRayon());;
		}
		g.setColor(Color.BLUE);
		g.fillOval(perso.getX(), perso.getY(), perso.getRayon(), perso.getRayon());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clefpress");
		 
		        if(e.getKeyCode()==KeyEvent.VK_Q || e.getKeyCode()==KeyEvent.VK_LEFT)
		            perso.setDirectionX(-1);;
		       
		        if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT)
		        	perso.setDirectionX(1);
		       
		        if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN)
		        	perso.setDirectionY(1);
		       
		        if(e.getKeyCode()==KeyEvent.VK_Z || e.getKeyCode()==KeyEvent.VK_UP)
		        	perso.setDirectionY(-1);
		        
			       perso.setX(perso.getX()+perso.getDirectionX()*perso.getFacteurdevitesse());
			       perso.setY(perso.getY()+perso.getDirectionY()*perso.getFacteurdevitesse());
			       this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clefrelach");
    	perso.setDirectionX(0);
    	perso.setDirectionX(0);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("cleftap");
		
	}

}
