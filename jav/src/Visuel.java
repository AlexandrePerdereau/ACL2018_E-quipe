
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Visuel extends JFrame {

	private JPanel contentPane;
	deplacement.Heros perso = new deplacement.Heros(10,10,10);
	ArrayList<Mur> batiment = new ArrayList<Mur>();
	boolean partieencours = false ;
	
	

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
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dessin panel = new Dessin();
		
		JButton btnCommencerLeNiveau = new JButton("Commencer le niveau");
		btnCommencerLeNiveau.setBounds(298, 13, 157, 54);
		contentPane.add(btnCommencerLeNiveau);
		btnCommencerLeNiveau.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Rectangle borders = new Rectangle(contentPane.getBounds());
				Dessin panel=new Dessin();
				panel.setBounds(100, 100,borders.width-200, borders.height-200);
				contentPane.add(panel);
				panel.repaint();
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
	      System.out.println("�v�nement d�clench� sur : " + e.getItem());
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
	
}
