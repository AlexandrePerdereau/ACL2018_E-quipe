package graph;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import element.Heros;
import element.Mur;
import generation_lab.Lecture_lab;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Visuel extends JFrame {

	private JPanel contentPane;
	static Lecture_lab lec;
	static  String combochoix = "niveau1";
	static boolean partieencours = false;


	Dessin panel;

	public static void main(String[] args) throws IOException {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Visuel frame = new Visuel();
System.out.println("frame creer");
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Visuel() {

		System.out.println("test");

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// On initialise la fenêtre

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 29, 127, 22);
		contentPane.add(comboBox);
		comboBox.addItem("niveau1");
		comboBox.addItem("niveau2");
		comboBox.addItem("niveau3");
		comboBox.addItem("niveau4");
		comboBox.addItemListener(new combo());
		
		//On ajoute le choix du niveau
		
		JButton btnCommencerLeNiveau = new JButton("Commencer le niveau");
		btnCommencerLeNiveau.setBounds(298, 13, 157, 54);
		contentPane.add(btnCommencerLeNiveau);
		btnCommencerLeNiveau.addActionListener(new java.awt.event.ActionListener() {
		//lorsque l'utilisateur clique sur le bouton : 

			public void actionPerformed(java.awt.event.ActionEvent e) { //alors
				if (partieencours) { panel.setVisible(false);partieencours = false ;}
				else{
					
				try {
					partieencours = true;
					String S= combochoix+".txt";
					lec = new Lecture_lab(S);
					
					//On extrait d'abord les informations du fichiers


					Rectangle borders = new Rectangle(contentPane.getBounds());
					panel = new Dessin(lec); // On utilise ses infos pour creer le dessin
					panel.setBounds(100, 100, borders.width - 200, borders.height - 200);
					contentPane.add(panel);
					panel.repaint();  //On affiche le dessin
					System.out.println("test2");
					
					System.out.println("focus "+panel.hasFocus());
					panel.grabFocus();	//le focus est necessaire pour que Dessin puisse entendre les touches
					System.out.println("focus "+panel.hasFocus());
					panel.addKeyListener(panel); 
					Thread thread = new Thread(panel);
					thread.start();
					
					
					//Analyse probleme jusque present : le repaint appelle pas le paintcomponent
					

				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

			}
		});

	


	}

	class combo implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			System.out.println("événement déclenché sur : " + e.getItem());
			Visuel.combochoix= (String) e.getItem();
		}  //lorsque on change de selection de niveau , on regarde le nouveau niveau, oblige d'initialiser au niveau 1 au debut de Visuel
	}

}
