package graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import element.Fantome_Patrouilleur;
import element.Fantome_Traqueur;
import element.Heros;
import element.Magique;
import element.Monstre;
import element.MonstreTraqueur;
import element.Mur;
import element.Teleporteur;
import element.Tresor;

public class Dessin extends JPanel implements KeyListener, Runnable {

	private ArrayList<Mur> lMur=new ArrayList<Mur>();
	protected element.Heros perso;
	private ArrayList<Monstre> lMonstre = new ArrayList<Monstre>();
	private ArrayList<Long> timermonstretouche = new ArrayList<Long>();
	private BufferedImage coeurimage;
	private ImageIcon image;

	private Tresor arivee;
	private ArrayList<Magique> lMagique = new ArrayList<Magique>();
	private ArrayList<Magique> lMagiqueUsed = new ArrayList<Magique>();
	private ArrayList<Fantome_Patrouilleur> listFantomePatrouilleur = new ArrayList<Fantome_Patrouilleur>();
	private long temps=0;
	private ArrayList<Fantome_Traqueur> lFTraqueur = new ArrayList<Fantome_Traqueur>();
	private int pixelX=400 , pixelY=400 ; //tailleDessin 400 400 par defaut

	private ArrayList<Teleporteur[]> lTp = new ArrayList<Teleporteur[]>();



	private ArrayList<MonstreTraqueur> lMTraqueur = new ArrayList<MonstreTraqueur>();

	@Override
	public void run(){
		System.out.println("Execution");
		Aetoile Ae = new Aetoile(lMTraqueur);
		Thread threadetoile = new Thread(Ae);
		threadetoile.start();
		while (Visuel.partieencours){


			if (arivee.pietinee(perso))
				Visuel.partieencours=false;
			for (Magique m:lMagique){
				if (m.pietinee(perso)){
					m.appeffect(perso);
					if (m.getEffect().equals("tuerUnMonstre")){
						if (lMonstre!=null && lMonstre.size()!=0)lMonstre.remove(0);
					}
					lMagiqueUsed.add(m);
				}
			}
			int X = perso.getX() , Y = perso.getY() , attX = perso.getAttaqueX() , attY = perso.getAttaqueY();
			int rayon = perso.getRayon();
			int dirX = perso.getDirectionX(), dirY = perso.getDirectionY();
			int pas = perso.getFacteurdevitesse();

			if  (perso.peutAvancer( lMur )){
				perso.setX(X+dirX*pas);
				perso.setY(Y+dirY*pas);
			}
			for (Magique m :lMagiqueUsed)lMagique.remove(m);

			ArrayList<Teleporteur[]> paireasupprimer = new ArrayList<Teleporteur[]>();
			for (Teleporteur[] paireTP : lTp)
				for(int i =0;i<=1;i++)
					if (paireTP[i].pietinee(perso)){
						paireTP[i].teleportation(perso);
						paireasupprimer.add(paireTP);
						break;
					}
			lTp.removeAll(paireasupprimer);




			ArrayList<Integer> monstresupprim = new ArrayList<Integer>();

			for (int i=0;i<lMonstre.size();i++){
				Monstre m = lMonstre.get(i);
				int mRayon = m.getRayon();
				if (perso.distanceaucarre(m)<(rayon+mRayon)*(rayon+mRayon)){
					perso.setPointdevie(0);
					Visuel.partieencours=false;
					break;
				}
				long t = System.currentTimeMillis();

				//ici on fera bouger les monstres patrouilleurs...s ils survivent
				if (t-timermonstretouche.get(i)>100 && (attX!=0 || attY!=0) && perso.monstredroite2points(m) < m.getRayon()){
					m.perdPV(1);
					perso.perdPV(1);
					timermonstretouche.set(i, t);
				}
				if(m.getPointdevie()<=0)monstresupprim.add(i);
				else{
					int mVitesse = m.getFacteurdevitesse();
					int newX=m.getX()+m.getDirectionX()*mVitesse;
					int newY=m.getY()+m.getDirectionY()*mVitesse;
					if (m.peutAvancer(lMur)
							&& Math.abs(newX-m.getPoint()[0])<=Math.abs(m.getDistance()[0])
							&& Math.abs(newY-m.getPoint()[1])<=Math.abs(m.getDistance()[1])){
						m.setX(newX);
						m.setY(newY);

					}
					else{
						m.setDirectionX(-1*m.getDirectionX());
						m.setDirectionY(-1*m.getDirectionY());
					}
				}

			}

			for (Fantome_Patrouilleur m:listFantomePatrouilleur){
				int mRayon = m.getRayon();
				if (perso.distanceaucarre(m)<(rayon+mRayon)*(rayon+mRayon)){
					perso.setPointdevie(0);
					Visuel.partieencours=false;
					break;
				}
				int mVitesse = m.getFacteurdevitesse();
				int newX=m.getX()+m.getDirectionX()*mVitesse;
				int newY=m.getY()+m.getDirectionY()*mVitesse;
				if (Math.abs(newX-m.getPoint()[0])<=Math.abs(m.getDistance()[0])
						&& Math.abs(newY-m.getPoint()[1])<=Math.abs(m.getDistance()[1])){
					m.setX(newX);
					m.setY(newY);

				}
				else{
					m.setDirectionX(-1*m.getDirectionX());
					m.setDirectionY(-1*m.getDirectionY());
				}



			}

			for (Fantome_Traqueur ft:lFTraqueur){
				ft.pos(perso);
				int ftRayon = ft.getRayon();
				if (perso.distanceaucarre(ft)<(rayon+ftRayon)*(rayon+ftRayon)){
					perso.setPointdevie(0);
					Visuel.partieencours=false;
					break;
				}
			}
			for (int i : monstresupprim){
				lMonstre.remove(i);
				timermonstretouche.remove(i);
			}

			for (MonstreTraqueur mT:lMTraqueur){

				mT.bouge();
				int mTRayon = mT.getRayon();
				if (perso.distanceaucarre(mT)<(rayon+mTRayon)*(rayon+mTRayon)){
					perso.setPointdevie(0);
					Visuel.partieencours=false;
					break;
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

	public Dessin(generation_lab.Lecture_lab lab,int visuelX, int visuelY){ //ViseulX,VisuelY=taillevisuel
		//On prend les info du lab, extraites elels meme du fichier auparavant
		setBackground(Color.WHITE);
		this.pixelX=lab.getPixelX();
		this.pixelY=lab.getPixelY();
		this.lMur = lab.getListMur();
		this.perso = lab.getHeros();
		this.lMonstre = lab.getListMonstre();
		for (Monstre m:lMonstre)timermonstretouche.add((long)0);

		this.lMagique=lab.getlMagique();
		this.arivee=lab.getArrivee();
		this.listFantomePatrouilleur=lab.getListFantomePatrouilleur();
		this.lFTraqueur=lab.getlFTraqueur();
		this.lTp=lab.getlTp();

		this.setBounds((visuelX-pixelX)/2, (visuelY-pixelY)/2, pixelX, pixelY);
		ArrayList<Integer[]> argmonstretraqueur =lab.getlArgMonstreTraqueur();
		for (Integer[] args:argmonstretraqueur){
			this.lMTraqueur.add(new MonstreTraqueur(args[0],args[1],args[2],args[3],args[4],this));
		}


		try {
			coeurimage=ImageIO.read(new File("Pointdevie.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		if(perso.getPointdevie()==0){
			g.setColor(Color.red);g.drawString("DEFAITE", pixelX/2, pixelY/2);
			Visuel.partieencours=false;
		}

		else if (!Visuel.partieencours) {
			g.setColor(Color.blue);

			g.drawString("VICTOIRE", pixelX/2, pixelY/2);


		}
		else{
			setBackground(Color.WHITE);

			long t = System.currentTimeMillis();


			g.setColor(Color.BLACK);

			int X = perso.getX() , Y = perso.getY() , attX = perso.getAttaqueX() , attY = perso.getAttaqueY();
			int portee=perso.getPortee();
			int rayon = perso.getRayon();
			if (t-temps<=100){
				if (attX!=0 && attY!=0)
					g.drawLine(X, Y, X+ (int)(((double)(attX*portee))/1.4142),Y+(int)(((double)(attY*portee))/1.4142));
				else
					g.drawLine(X, Y, X+attX*portee,Y+attY*portee);

			}

			for (Mur m : lMur){
				g.fillRect(m.getPosx(), m.getPosy(), m.getLongx(), m.getLongy());
			}
			for (Monstre monstre : lMonstre){
				g.setColor(Color.RED);

				g.fillOval(monstre.getX()-monstre.getRayon(), monstre.getY()-monstre.getRayon(), 2*monstre.getRayon(), 2*monstre.getRayon());
				g.setColor(Color.WHITE);
				g.drawString(""+monstre.getPointdevie(), monstre.getX(), monstre.getY());
			}

			for (MonstreTraqueur mT : lMTraqueur){
				g.setColor(Color.RED);

				int R = mT.getRayon();
				g.fillOval(mT.getX()-R, mT.getY()-R, 2*R, 2*R);
				g.setColor(Color.WHITE);
				g.drawString(""+mT.getPointdevie(), mT.getX(), mT.getY());
			}

			g.setColor(Color.GRAY);
			for (Monstre monstre : listFantomePatrouilleur){
				g.fillOval(monstre.getX()-monstre.getRayon(), monstre.getY()-monstre.getRayon(), 2*monstre.getRayon(), 2*monstre.getRayon());;
			}
			for (Fantome_Traqueur ft : this.lFTraqueur)
				g.fillOval(ft.getX()-ft.getRayon(), ft.getY()-ft.getRayon(), 2*ft.getRayon(), 2*ft.getRayon());


			g.setColor(Color.BLUE);
			g.fillOval(X-rayon, Y-rayon, 2*rayon, 2*rayon);

			g.setColor(Color.YELLOW);
			g.fillRect(arivee.getX(), arivee.getY(), arivee.getLongX(), arivee.getLongY());

			g.setColor(Color.GREEN);
			for(Magique m:lMagique){
				String effet = m.getEffect();
				String[] effect = effet.split("E");
				if (effect[0].equals("piege"))
					g.setColor(Color.RED);

				g.fillRect(m.getX(), m.getY(), m.getLongX(), m.getLongY());
				g.drawString(effect[0], m.getX(), m.getY());
				g.setColor(Color.GREEN);

			}
			g.setColor(Color.CYAN);
			for (Teleporteur[] paireTP : lTp){
				g.fillRect(paireTP[0].getX(), paireTP[0].getY(), paireTP[0].getLongX(), paireTP[0].getLongY());
				g.fillRect(paireTP[1].getX(), paireTP[1].getY(), paireTP[1].getLongX(), paireTP[1].getLongY());



			}
			for (int i=0;i<perso.getPointdevie();i++){

				g.drawImage(coeurimage, 15*i, 0, null);

			}
		}


	}

	@Override
	public void keyPressed(KeyEvent e) { //lorsque une touche est presse on ...
		// TODO Auto-generated method stub
		System.out.println("clefpress");
		//...selon les touches appuyes, on indique une direction;

		//Avantage majeur : permet deplacement diagonal
		//et en + , plus pratique pour eventuel deplacement tout les 10 ms ( pas reussi pour l'instant)
		if(e.getKeyCode()==KeyEvent.VK_Q)
			perso.setDirectionX(-1);

		if(e.getKeyCode()==KeyEvent.VK_D)
			perso.setDirectionX(1);

		if(e.getKeyCode()==KeyEvent.VK_S)
			perso.setDirectionY(1);

		if(e.getKeyCode()==KeyEvent.VK_Z)
			perso.setDirectionY(-1);

		if (e.getKeyCode()==KeyEvent.VK_LEFT){perso.setAttaqueX(-1);temps=System.currentTimeMillis();}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){perso.setAttaqueX(1);temps=System.currentTimeMillis();}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){perso.setAttaqueY(1);temps=System.currentTimeMillis();}
		if(e.getKeyCode()==KeyEvent.VK_UP){perso.setAttaqueY(-1);temps=System.currentTimeMillis();}
	}

	@Override
	public void keyReleased(KeyEvent e) { // lorsque on relache la touche , faut pas continuer a avancer
		// TODO Auto-generated method stub
		System.out.println("clefrelach");
		if(e.getKeyCode()==KeyEvent.VK_Q || e.getKeyCode()==KeyEvent.VK_D)
			perso.setDirectionX(0);

		if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_Z)
			perso.setDirectionY(0);

		if (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT)
			perso.setAttaqueX(0);

		if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_UP)
			perso.setAttaqueY(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("cleftap");



	}

	public int getPixelX() {
		return pixelX;
	}

	public void setPixelX(int pixelX) {
		this.pixelX = pixelX;
	}

	public int getPixelY() {
		return pixelY;
	}

	public void setPixelY(int pixelY) {
		this.pixelY = pixelY;
	}

	public ArrayList<Mur> getlMur() {
		return lMur;
	}

	public void setlMur(ArrayList<Mur> lMur) {
		this.lMur = lMur;
	}

	public Heros getPerso(){
		return perso;
	}





}
