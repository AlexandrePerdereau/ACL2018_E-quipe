package generation_lab;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import element.Heros;
import element.Mur;
import element.Tresor;
import generation_lab.Lecture_lab;

public class JUnitLecture {

	static Lecture_lab lecs; 
	static Heros h1;
	static Tresor arrivee;
	static Mur md;
	static Mur mf;
	static Heros h2;
	static Tresor arrivee2;
	 
	
	int nouv = 100;

	@BeforeClass
	public static void SetUpBeforeClass() throws IOException {
		
		lecs = new Lecture_lab("fichiertest.txt");
		h1 = new Heros(205, 205, 1, 50, 20,5);
		arrivee = new Tresor(200,300,20,20);
		md = new Mur(205,200,1,1);
		mf = new Mur(210,205,1,1);
		h2 = new Heros(250,250,10,10,20,5);
		arrivee2 = new Tresor(400,400,10,10);
	} 
	// Tests de lecture de fichier 
	
	@Test
	public void testLectureLabMurDebut(){
		assertEquals(lecs.getListMur().get(0).getPosx(), md.getPosx());
		assertEquals(lecs.getListMur().get(0).getPosy(), md.getPosy());
		assertEquals(lecs.getListMur().get(0).getLongx(), md.getLongx());
		assertEquals(lecs.getListMur().get(0).getLongy(), md.getLongy());
	}
	@Test
	public void testLectureLabMurFin(){
		Mur murf=lecs.getListMur().get((lecs.getListMur().size()-1));
		assertEquals(murf.getPosx(),mf.getPosx());
		assertEquals(murf.getPosy(),mf.getPosy());
		assertEquals(murf.getLongx(),mf.getLongx());
		assertEquals(murf.getLongy(),mf.getLongy());
		}
	@Test
	public void testLectureLabHeros() {
		Heros h=lecs.getHeros();
		assertEquals(h.getX(),h1.getX());
		assertEquals(h.getY(),h1.getY());
		assertEquals(h.getRayon(),h1.getRayon());
		assertEquals(h.getFacteurdevitesse(),h1.getFacteurdevitesse());
		assertEquals(h.getPortee(),h1.getPortee());
		assertEquals(h.getPointdevie(),h1.getPointdevie());
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
		Tresor arr=lecs.getArrivee();
		assertEquals(arr.getX(),arrivee.getX());
		assertEquals(arr.getY(),arrivee.getY());
		assertEquals(arr.getLongX(),arrivee.getLongX());
		assertEquals(arr.getLongY(),arrivee.getLongY());
	}
	
	@Test 
	public void testLectureLabTresorsMultiples() {
		assertNotEquals(lecs.getArrivee(), arrivee2);
	}
	// Tests de collisions pour les quatres directions possibles
	@Test
	public void testPeutAvancerDroite() {
		h1.setDirectionX(1);
		assertTrue(!h1.peutAvancer(lecs.getListMur()));
		 
	}
	@Test
	public void testPeutAvancerGauche() {
		h1.setDirectionX(-1);
		assertTrue(!h1.peutAvancer(lecs.getListMur()));
		 
	}
	
	@Test
	public void testPeutAvancerHaut() {
		h1.setDirectionY(1);
		assertTrue(!h1.peutAvancer(lecs.getListMur()));
		 
	}
	@Test
	public void testPeutAvancerBas() {
		h1.setDirectionY(-1);
		assertTrue(!h1.peutAvancer(lecs.getListMur()));
		 
	}
}