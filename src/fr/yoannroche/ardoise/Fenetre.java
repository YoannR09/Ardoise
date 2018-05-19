package fr.yoannroche.ardoise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Fenetre extends JFrame {

	private JPanel container = new JPanel ();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu fichier = new JMenu("Fichier"),
			edition = new JMenu("Edition"),
			taille = new JMenu("Taille"),
			couleur = new JMenu("Couleur du pointer"),
			forme = new JMenu("Forme du pinceau");
	private Panneau drawPanel = new Panneau ();
	private ColorListener cListener = new ColorListener();
	private FormeListener fListener = new FormeListener();
	private SizeListener sListener = new SizeListener();
	private TailleListener tListener = new TailleListener ();


	JMenuItem effacer = new JMenuItem ("Effacer"),
			quitter = new JMenuItem ("Quitter"),
			rond = new JMenuItem ("Rond"),
			carre = new JMenuItem ("Carré"),
			noir = new JMenuItem ("Noir"),
			jaune = new JMenuItem ("Jaune"),
			bleu = new JMenuItem ("Bleu"),
			gomm = new JMenuItem("Gomme"),
			rouge = new JMenuItem ("Rouge"),
	        big = new JMenuItem ("Enorme"),
	        up = new JMenuItem ("Grand"),
	        norm = new JMenuItem ("Normal"),
	        small = new JMenuItem ("Petit");
	        
	        
	        

	JToolBar toolBar = new JToolBar();

	JButton carre2 = new JButton(new ImageIcon("src/fr/yoannroche/ardoise/carre.png"));
	JButton rond2 = new JButton(new ImageIcon("src/fr/yoannroche/ardoise/rond.png"));
	JButton yellow = new JButton(new ImageIcon("src/fr/yoannroche/ardoise/yellow.png"));
	JButton red = new JButton(new ImageIcon("src/fr/yoannroche/ardoise/red.png"));
	JButton black = new JButton(new ImageIcon("src/fr/yoannroche/ardoise/black.png"));
	JButton blue = new JButton(new ImageIcon("src/fr/yoannroche/ardoise/blue.png"));
	JButton gomme = new JButton (new ImageIcon("src/fr/yoannroche/ardoise/gomme.png"));
	JButton bigsize = new JButton (new ImageIcon("src/fr/yoannroche/ardoise/bigsize.png"));
	JButton upsize = new JButton (new ImageIcon("src/fr/yoannroche/ardoise/upsize.png"));
	JButton normsize = new JButton (new ImageIcon("src/fr/yoannroche/ardoise/normsize.png"));
	JButton littlesize = new JButton (new ImageIcon("src/fr/yoannroche/ardoise/littlesize.png"));
	
	




	public Fenetre () {

		this.setTitle("Ardoise");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());


		this.initToolBar();
		this.initMenu();

		this.getContentPane().add(drawPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	private void initToolBar(){

		JPanel pan = new JPanel();
		
		toolBar.addSeparator();

		toolBar.setBackground(Color.orange);
		toolBar.setBorder(BorderFactory.createLineBorder(Color.black));



		toolBar.add(carre2);
		carre2.setBackground(Color.getHSBColor(155,50,50));
		carre2.addActionListener(fListener);

		toolBar.add(rond2);
		rond2.setBackground(Color.getHSBColor(155,50,50));
		rond2.addActionListener(fListener);

		toolBar.addSeparator();
		toolBar.addSeparator();


		toolBar.add(black);
		black.setBackground(Color.getHSBColor(155,50,50));
		black.addActionListener(cListener);

		toolBar.add(yellow);
		yellow.setBackground(Color.getHSBColor(155,50,50));
		yellow.addActionListener(cListener);

		toolBar.add(red);
		red.setBackground(Color.getHSBColor(155,50,50));
		red.addActionListener(cListener);

		toolBar.add(blue);
		blue.setBackground(Color.getHSBColor(155,50,50));
		blue.addActionListener(cListener);



		toolBar.addSeparator();
		toolBar.addSeparator();

		toolBar.add(gomme);
		gomme.addActionListener(cListener);
		gomme.setBackground(Color.getHSBColor(155,50,50));
		
		toolBar.addSeparator();
		toolBar.addSeparator();
		
		toolBar.add(littlesize);
		toolBar.add(normsize);
		toolBar.add(upsize);
		toolBar.add(bigsize);
		
		littlesize.addActionListener(sListener);
		littlesize.setBackground(Color.getHSBColor(155,50,50));
		normsize.addActionListener(sListener);
		normsize.setBackground(Color.getHSBColor(155,50,50));
		upsize.addActionListener(sListener);
		upsize.setBackground(Color.getHSBColor(155,50,50));
		bigsize.addActionListener(sListener);
		bigsize.setBackground(Color.getHSBColor(155,50,50));
		
		toolBar.addSeparator();

		this.getContentPane().add(toolBar, BorderLayout.NORTH);
	}

	private void initMenu() {


		fichier.setForeground(Color.orange);
		fichier.add(effacer);
		fichier.add(quitter);
		effacer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.dessin();
			}      
		});

		edition.setForeground(Color.orange);
		edition.setBackground(Color.DARK_GRAY);
		edition.add(forme);
		edition.add(couleur);
		edition.addSeparator();
		edition.add(gomm);
		
		taille.setForeground(Color.orange);
		taille.add(small);
		small.setAccelerator(KeyStroke.getKeyStroke('/'));
		small.addActionListener(tListener);
		taille.add(norm);
		norm.addActionListener(tListener);
		norm.setAccelerator(KeyStroke.getKeyStroke('-'));
		taille.add(up);
		up.addActionListener(tListener);
		up.setAccelerator(KeyStroke.getKeyStroke('+'));
		taille.add(big);
		big.addActionListener(tListener);
		big.setAccelerator(KeyStroke.getKeyStroke('*'));
		
		

		gomm.addActionListener(cListener);
		gomm.setAccelerator(KeyStroke.getKeyStroke('D'));

		forme.add(rond);
		forme.add(carre);
		rond.addActionListener(fListener);
		rond.setAccelerator(KeyStroke.getKeyStroke('R'));
		carre.addActionListener(fListener);
		carre.setAccelerator(KeyStroke.getKeyStroke('C'));

		couleur.add(noir);
		couleur.add(jaune);
		couleur.add(rouge);
		couleur.add(bleu);
		noir.addActionListener(cListener);
		noir.setAccelerator(KeyStroke.getKeyStroke('1'));
		jaune.addActionListener(cListener);
		jaune.setAccelerator(KeyStroke.getKeyStroke('2'));
		rouge.addActionListener(cListener);
		rouge.setAccelerator(KeyStroke.getKeyStroke('3'));
		bleu.addActionListener(cListener);
		bleu.setAccelerator(KeyStroke.getKeyStroke('4'));

       
		menuBar.add(fichier);
		menuBar.add(edition);
		menuBar.add(taille);
		menuBar.setBackground(Color.DARK_GRAY);

		this.setJMenuBar(menuBar);
	}

	class FormeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==carre2) drawPanel.setPointerType("SQUARE");
			if(e.getSource()==rond2) drawPanel.setPointerType("CIRCLE");


			if(e.getSource()==rond)drawPanel.setPointerType("CIRCLE");
			if(e.getSource()==carre) drawPanel.setPointerType("SQUARE");      

		}    
	}


	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==yellow)drawPanel.setPointerColor(Color.yellow);
			if(e.getSource()==jaune)drawPanel.setPointerColor(Color.yellow);
			if(e.getSource()==red)drawPanel.setPointerColor(Color.red);
			if(e.getSource()==rouge)drawPanel.setPointerColor(Color.red);
			if(e.getSource()==black)drawPanel.setPointerColor(Color.black);
			if(e.getSource()==gomme)drawPanel.setPointerColor(Color.white);
			if(e.getSource()==bleu)drawPanel.setPointerColor(Color.blue);
			if(e.getSource()==blue)drawPanel.setPointerColor(Color.blue);
			if(e.getSource()==gomm)drawPanel.setPointerColor(Color.white);
		}
	}

		class SizeListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bigsize)drawPanel.setPointerSize(50);
				if(e.getSource()==upsize)drawPanel.setPointerSize(30);
				if(e.getSource()==normsize)drawPanel.setPointerSize(10);
				if(e.getSource()==littlesize)drawPanel.setPointerSize(3);
			}
		}
		
		class TailleListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==big)drawPanel.setPointerSize(50);
				if(e.getSource()==up)drawPanel.setPointerSize(30);
				if(e.getSource()==norm)drawPanel.setPointerSize(10);
				if(e.getSource()==small)drawPanel.setPointerSize(3);
			}
		}









	}    






