package graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import element.Monstre;
import element.Mur;

public class Dessin extends JPanel implements KeyListener, Runnable {

	private ArrayList<Mur> lMur=new ArrayList<Mur>();
	protected element.Heros perso;
	private ArrayList<Monstre> lMonstre = new ArrayList<Monstre>();

	  @Override
	  public void run(){
	    System.out.println("Execution");
	    while (Visuel.partieencours){
	    	for (Monstre m:lMonstre){
	    		//ici on fera bouger les monstres patrouilleurs
	    		int newX=m.getX()+m.getDirectionX()*m.getFacteurdevitesse();
	    		int newY=m.getY()+m.getDirectionY()*m.getFacteurdevitesse();
	    		if (m.peutAvancer(lMur)
	    				&& Math.abs(newX-m.getPoint()[0])<=Math.abs(m.getDistance()[0])
	    				&& Math.abs(newY-m.getPoint()[1])<=Math.abs(m.getDistance()[1])){
	    			m.setX(newX);
	    			m.setY(newY);
	    			System.out.println("TEST");
	    		}
	    		else{
	    			m.setDirectionX(-1*m.getDirectionX());
	    			m.setDirectionY(-1*m.getDirectionY());
	    		}
	    	}
	    	this.repaint();
	    	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  }

	public Dessin(generation_lab.Lecture_lab lab){
		//On prend les info du lab, extraites elels meme du fichier auparavant
		setBackground(Color.WHITE);
		this.lMur = lab.getListMur();
		this.perso = lab.getHeros();
		this.lMonstre = lab.getListMonstre();
	}

	public Dessin(ArrayList<Mur> lMur,	element.Heros perso){ //utile pour des tests,
		setFocusable(true);
		setBackground(Color.WHITE);
		this.lMur=lMur;
		this.perso=perso;
	}

	public Dessin(element.Heros perso){  //idem
		//sa c'est le dessin sans donnee
		setFocusable(true);
		setBackground(Color.WHITE);
		Mur m = new Mur(100,100,10,50);
		this.lMur.add(m);
		this.perso = perso;
	}

	public void paintComponent(Graphics g)  { //appele lors du repaint(), on dessine le panneau
		//System.out.println("repaint"); //vu la frequence , sa devient trop le flood sur la console
		super.paintComponent(g);
		setBackground(Color.WHITE);

		g.setColor(Color.BLACK);
		for (Mur m : lMur){
			g.fillRect(m.getPosx(), m.getPosy(), m.getLongx(), m.getLongy());
		}
		g.setColor(Color.RED);
		for (Monstre monstre : lMonstre){
			g.fillOval(monstre.getX()-monstre.getRayon(), monstre.getY()-monstre.getRayon(), 2*monstre.getRayon(), 2*monstre.getRayon());;
		}
		g.setColor(Color.BLUE);
		g.fillOval(perso.getX()-perso.getRayon(), perso.getY()-perso.getRayon(), 2*perso.getRayon(), 2*perso.getRayon());
	}

	@Override
	public void keyPressed(KeyEvent e) { //lorsque une touche est presse on ...
		// TODO Auto-generated method stub
		System.out.println("clefpress");
//...selon les touches appuyes, on indique une direction;
		
	//Avantage majeur : permet deplacement diagonal
		//et en + , plus pratique pour eventuel deplacement tout les 10 ms ( pas reussi pour l'instant)
		if(e.getKeyCode()==KeyEvent.VK_Q || e.getKeyCode()==KeyEvent.VK_LEFT)
			perso.setDirectionX(-1);;

			if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT)
				perso.setDirectionX(1);

			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN)
				perso.setDirectionY(1);

			if(e.getKeyCode()==KeyEvent.VK_Z || e.getKeyCode()==KeyEvent.VK_UP)
				perso.setDirectionY(-1);
			if  (perso.peutAvancer( lMur )){
			perso.setX(perso.getX()+perso.getDirectionX()*perso.getFacteurdevitesse());
			perso.setY(perso.getY()+perso.getDirectionY()*perso.getFacteurdevitesse());
			}

	}

	@Override
	public void keyReleased(KeyEvent e) { // lorsque on relache la touche , faut pas continuer a avancer
		// TODO Auto-generated method stub
		System.out.println("clefrelach");
		if(e.getKeyCode()==KeyEvent.VK_Q || e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D)
		perso.setDirectionX(0);
		
		if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_Z)
		perso.setDirectionY(0);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("cleftap");

	}

}
