package generation_lab;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import element.Heros;
import element.Mur;
import element.Tresor;
import generation_lab.Lecture_lab;

public class JUnitLecture {

	static Lecture_lab lecs; 
	static Heros h;
	static Tresor arrivee;
	static Mur md;
	static Mur mf;
	static Heros h2;
	static Tresor arrivee2;
	 
	
	int nouv = 100;

	@BeforeClass
	public static void SetUpBeforeClass() throws IOException {
		
		lecs = new Lecture_lab("fichiertest.txt");
		h = new Heros(201, 201, 4, 20, 10);
		arrivee = new Tresor(200,300,20,20);
		md = new Mur(205,200,1,1);
		mf = new Mur(200,205,1,1);
		h2 = new Heros(250,250,10,10,10);
		arrivee2 = new Tresor(400,400,10,10);
	} 
	// Tests de lecture de fichier 
	
	// EXEMPLE pour Tarek, je compare les 4 attributs du mur lu avec celui que j'ai défini : md : donc Posx, Posy, Longx, Longy
	@Test
	public void testLectureLabMurDebutPosx(){
		assertEquals(lecs.getListMur().get(0).getPosx(), md.getPosx());
	}
	@Test
	public void testLectureLabMurDebutPosy(){
		assertEquals(lecs.getListMur().get(0).getPosy(), md.getPosy());
	}
	@Test
	public void testLectureLabMurDebutLongx(){
		assertEquals(lecs.getListMur().get(0).getLongx(), md.getLongx());
	}
	@Test
	public void testLectureLabMurDebutLongy(){
		assertEquals(lecs.getListMur().get(0).getLongy(), md.getLongy());
	}
	@Test
	public void testLectureLabMurFin(){
		assertEquals(lecs.getListMur().get((lecs.getListMur().size()-1)), mf);
	}
	@Test
	public void testLectureLabHeros() {
		assertEquals(lecs.getHeros(), h);
	}
	//Nous ne voulons qu'un héros par niveau, si il y en a plusieurs par fichiers,
	//nous prenons le premier uniquement
	@Test
	public void testLectureLabHerosMultiples() {   
		assertNotEquals(lecs.getHeros(), h2);	  
	}
	
	//De même pour Tresor, il n'y en a qu'un seul
	@Test 
	public void testLectureLabTresor() {
		assertEquals(lecs.getArrivee(), arrivee);
	}
	
	@Test 
	public void testLectureLabTresorsMultiples() {
		assertNotEquals(lecs.getArrivee(), arrivee2);
	}
	// Tests de collisions pour les quatres directions possibles
	@Test
	public void testPeutAvancerDroite() {
		h.setDirectionX(1);
		assertEquals(h.peutAvancer(lecs.getListMur()),false);
		 
	}
	@Test
	public void testPeutAvancerGauche() {
		h.setDirectionX(-1);
		assertEquals(h.peutAvancer(lecs.getListMur()),false);
		 
	}
	
	@Test
	public void testPeutAvancerHaut() {
		h.setDirectionY(1);
		assertEquals(h.peutAvancer(lecs.getListMur()),false);
		 
	}
	@Test
	public void testPeutAvancerBas() {
		h.setDirectionY(-1);
		assertEquals(h.peutAvancer(lecs.getListMur()),false);
		 
	}
	
	
	
	
	

}
