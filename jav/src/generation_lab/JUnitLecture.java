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

	Lecture_lab lec; 
	Heros h;
	Tresor arrivee;
	Mur md;
	Mur mf;
	Heros h2;
	Tresor arrivee2;
	 
	
	int nouv = 100;

	@Before
	public  void SetUp() throws IOException {
		
		lec = new Lecture_lab("fichierTest.txt");
		h = new Heros(201, 201, 4, 20);
		arrivee = new Tresor(200,300,20,20);
		md = new Mur(205,200,1,1);
		mf = new Mur(200,205,1,1);
		h2 = new Heros(250,250,10,10);
		arrivee2 = new Tresor(400,400,10,10);
	} 
	// Tests de lecture de fichier 
	@Test
	public void testLectureLabMurDebut(){
		assertEquals(lec.getListMur().get(0), md);
	}
	@Test
	public void testLectureLabMurFin(){
		assertEquals(lec.getListMur().get((lec.getListMur().size())), mf);
	}
	@Test
	public void testLectureLabHeros() {
		assertEquals(lec.getHeros(), h);
	}
	//Nous ne voulons qu'un héros par niveau, si il y en a plusieurs par fichiers,
	//nous prenons le premier uniquement
	@Test
	public void testLectureLabHerosMultiples() {   
		assertNotEquals(lec.getHeros(), h2);	  
	}
	
	//De même pour Tresor, il n'y en a qu'un seul
	@Test 
	public void testLectureLabTresor() {
		assertEquals(lec.getArrivee(), arrivee);
	}
	
	@Test 
	public void testLectureLabTresorsMultiples() {
		assertNotEquals(lec.getArrivee(), arrivee2);
	}
	// Tests de collisions pour les quatres directions possibles
	@Test
	public void testPeutAvancerDroite() {
		h.setDirectionX(1);
		assertEquals(h.peutAvancer(lec.getListMur()),false);
		 
	}
	@Test
	public void testPeutAvancerGauche() {
		h.setDirectionX(-1);
		assertEquals(h.peutAvancer(lec.getListMur()),false);
		 
	}
	
	@Test
	public void testPeutAvancerHaut() {
		h.setDirectionY(1);
		assertEquals(h.peutAvancer(lec.getListMur()),false);
		 
	}
	@Test
	public void testPeutAvancerBas() {
		h.setDirectionY(-1);
		assertEquals(h.peutAvancer(lec.getListMur()),false);
		 
	}
	
	
	
	
	

}
