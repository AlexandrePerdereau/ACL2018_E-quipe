package aetoile;

import java.util.ArrayList;

import element.MonstreTraqueur;
import generation_lab.Lecture_lab;

public class Grille {
	int n = 400;
	int[][] lPoint = new int[n][2]; // Matrice taille 2,n (ou plutot n,2 Non?)
	boolean[][] mAdjacence; // Matrice adjacence n,n
	// le nombre d'elements de la grille

	public Grille(MonstreTraqueur m, Lecture_lab lL) {
		/*
		 * on va creer une grille de segment m.facteurdevitesse qui va occuper le plus
		 * de place possible dans le labyrinth de taille pixelX,pixelY
		 */
		/*
		 * for (int i = 0; i < lL.getPixelX(); i = i + m.getFacteurdevitesse()) { for
		 * (int j = 0; j < lL.getPixelY(); j = j + m.getFacteurdevitesse()) {
		 * lPoint[(n/lL.getPixelY())*m.getFacteurdevitesse()*j +
		 * i*m.getFacteurdevitesse()][0] = n/(i*m.getFacteurdevitesse());
		 * lPoint[(n/lL.getPixelY())*m.getFacteurdevitesse()*j +
		 * i*m.getFacteurdevitesse()][1] = n%(i*m.getFacteurdevitesse()); } }
		 */

		for (int i = 0; i < n; i++) {

			lPoint[(i * m.getFacteurdevitesse())][0] = i*n%(lL.getPixelX()/m.getFacteurdevitesse());
			lPoint[(i * m.getFacteurdevitesse())][1] = i*n/(lL.getPixelX()/m.getFacteurdevitesse());

		}
	}

}
