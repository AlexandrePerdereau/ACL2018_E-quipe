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
	boolean partieencours = false;


	Dessin panel;

	public static void main(String[] args) throws IOException {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Visuel frame = new Visuel();

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

		JButton btnCommencerLeNiveau = new JButton("Commencer le niveau");
		btnCommencerLeNiveau.setBounds(298, 13, 157, 54);
		contentPane.add(btnCommencerLeNiveau);
		btnCommencerLeNiveau.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					String S= combochoix+".txt";
					lec = new Lecture_lab(S);


					Rectangle borders = new Rectangle(contentPane.getBounds());
					panel = new Dessin(lec);
					panel.setBounds(100, 100, borders.width - 200, borders.height - 200);
					contentPane.add(panel);
					panel.repaint();
					System.out.println("test2");
					partieencours = true;
					
					System.out.println(panel.hasFocus());
					panel.grabFocus();
					System.out.println(panel.hasFocus());
					panel.addKeyListener(panel);
					Heros perso = panel.perso;
					

				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 29, 127, 22);
		contentPane.add(comboBox);
		comboBox.addItem("niveau1");
		comboBox.addItem("niveau2");
		comboBox.addItem("niveau3");
		comboBox.addItem("niveau4");
		comboBox.addItemListener(new combo());


	}

	class combo implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			System.out.println("événement déclenché sur : " + e.getItem());
			Visuel.combochoix= (String) e.getItem();
		}
	}

}
