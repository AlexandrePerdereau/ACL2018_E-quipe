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
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import element.Mur;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Visuel extends JFrame {

	private JPanel contentPane;
	element.Heros perso = new element.Heros(10, 10, 10);
	ArrayList<Mur> batiment = new ArrayList<Mur>();
	boolean partieencours = false ;
	Dessin panel = new Dessin(perso);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
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
		
		this.addKeyListener(new LabyKeyListener());
		
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
				
				Rectangle borders = new Rectangle(contentPane.getBounds());
				
				panel.setBounds(100, 100,borders.width-200, borders.height-200);
				contentPane.add(panel);
				panel.repaint();
				System.out.println("test2");
				
				
			}
		});
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 29, 127, 22);
		contentPane.add(comboBox);
		comboBox.addItem("niveau 1");
		comboBox.addItemListener(new combo());
		
		
	}
	class combo implements ItemListener{
	    public void itemStateChanged(ItemEvent e) {
	      System.out.println("événement déclenché sur : " + e.getItem());
	    }               
	  }
	
	public void anim(){
		while (partieencours){
			
			this.repaint();
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public class LabyKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			System.out.println("test1");
			// TODO Auto-generated method stub
		
			if (event.getKeyCode()==KeyEvent.VK_RIGHT){perso.setX(perso.getX()+10);panel.repaint();System.out.println("test");}
			if (event.getKeyCode()==KeyEvent.VK_LEFT);
			if (event.getKeyCode()==KeyEvent.VK_UP);
			if (event.getKeyCode()==KeyEvent.VK_DOWN);}
		

		@Override
		public void keyReleased(KeyEvent event) {
			// TODO Auto-generated method stub
			if (event. getKeyCode()==KeyEvent.VK_RIGHT){perso.setX(perso.getX()+10);panel.repaint();System.out.println("test");}
		}

		@Override
		public void keyTyped(KeyEvent event) {
			// TODO Auto-generated method stub
			
		}

	}

	
}
