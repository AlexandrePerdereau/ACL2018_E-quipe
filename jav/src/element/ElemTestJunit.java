package element;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import element.Monstre.*;

import generation_lab.Lecture_lab;

public class ElemTestJunit {
	static Lecture_lab lecs; 
	static Heros h1;
	static Magique spell1;
	static Magique spell2;
	static Monstre shreck1;
	static Monstre shreck2;
	static Magique spellPietine;
	static Teleporteur tp1;
	static Teleporteur tp2;
	static Heros hPietine;
	static Heros hTP;
	// J'ai un problème avec l'objet Teleporteur.
	
	
	@BeforeClass
	public static void SetUpBeforeClass() throws IOException {
		lecs = new Lecture_lab("TestElem.txt");
		h1 = new Heros(200,200,10,3,40,10);
		spell1= new Magique(100,100,10,10,"soinE1");
		spell2= new Magique(230,100,10,10,"piegeE1");
		hTP = new Heros(400,100,10,5,20,10);
		int[] point1= {300,300};
		int[] distance1= {0,-100};
		int[] point2= {200,250};
		int[] distance2= {0,-100};
		shreck1= new Monstre(10,2,point1,distance1,2) ;
		shreck2= new Monstre(10,2,point2,distance2,2);
		hPietine = new Heros(400,100,10,5,20,10);
		spellPietine = new Magique(400,100,10,10,"vitesse");
		tp1 = lecs.getlTp().get(0)[0];
		tp2 = lecs.getlTp().get(0)[1];
	}
	@Test
	public void testMagique1(){
		Magique mag1=lecs.getlMagique().get(0);
		assertEquals(mag1.getX(),spell1.getX());
		assertEquals(mag1.getY(),spell1.getY());
		assertEquals(mag1.getLongX(),spell1.getLongX());
		assertEquals(mag1.getLongY(),spell1.getLongY());
		assertTrue(mag1.getEffect().equals(spell1.getEffect()));
		}
	@Test
	public void testMagique2(){
		Magique mag2=lecs.getlMagique().get(lecs.getlMagique().size()-1);
		assertEquals(mag2.getX(),spell2.getX());
		assertEquals(mag2.getY(),spell2.getY());
		assertEquals(mag2.getLongX(),spell2.getLongX());
		assertEquals(mag2.getLongY(),spell2.getLongY());
		assertTrue(mag2.getEffect().equals(spell2.getEffect()));
		}
	@Test
	public void testMonstre1(){
		//Monstre(int rayon ,int facteurdevitesse , int[] point, int []distance,int pv)
		Monstre mon1=lecs.getListMonstre().get(0);
		assertEquals(mon1.getRayon(),shreck1.getRayon());
		assertEquals(mon1.getFacteurdevitesse(),shreck1.getFacteurdevitesse());
		assertEquals(mon1.getPoint()[0],shreck1.getPoint()[0]);
		assertEquals(mon1.getPoint()[1],shreck1.getPoint()[1]);
		assertEquals(mon1.getDistance()[0],shreck1.getDistance()[0]);
		assertEquals(mon1.getDistance()[1],shreck1.getDistance()[1]);
		assertEquals(mon1.getPointdevie(),shreck1.getPointdevie());
		}
	@Test
	public void testMonstre2(){
		//Monstre(int rayon ,int facteurdevitesse , int[] point, int []distance,int pv)
		Monstre mon2=lecs.getListMonstre().get(lecs.getListMonstre().size()-1);
		assertEquals(mon2.getRayon(),shreck2.getRayon());
		assertEquals(mon2.getFacteurdevitesse(),shreck2.getFacteurdevitesse());
		assertEquals(mon2.getPoint()[0],shreck2.getPoint()[0]);
		assertEquals(mon2.getPoint()[1],shreck2.getPoint()[1]);
		assertEquals(mon2.getDistance()[0],shreck2.getDistance()[0]);
		assertEquals(mon2.getDistance()[1],shreck2.getDistance()[1]);
		assertEquals(mon2.getPointdevie(),shreck2.getPointdevie());
		}
	@Test
	public void testPietinee() {
		assertTrue(spellPietine.pietinee(hPietine));
	}
	@Test
	public void testTP() {
		tp1.teleportation(hTP);
		assertTrue(tp2.pietinee(hTP));
	}
}