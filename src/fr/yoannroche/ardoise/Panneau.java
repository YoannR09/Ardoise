package fr.yoannroche.ardoise;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	private boolean dessiner = true ;
	private Color pointerColor = Color.black ;
	private String pointerType = "Rond";
	private int posX = -10, oldX = -10;
	private int posY = -10 , oldY = -10 ;
	private int pointerSize = 10 ;
	private ArrayList<Point> points = new ArrayList<Point>();
	
	 public Panneau(){

		    this.addMouseListener(new MouseAdapter(){
		      public void mousePressed(MouseEvent e){
		        points.add(new Point(pointerType, pointerSize,e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2),pointerColor));
		        repaint();
		      }
		    });

		    this.addMouseMotionListener(new MouseMotionListener(){
		      public void mouseDragged(MouseEvent e) {
		        //On récupère les coordonnées de la souris et on enlève la moitié de la taille du pointeur pour centrer le tracé
		        points.add(new Point(pointerType, pointerSize,e.getX() - (pointerSize / 2), e.getY() - (pointerSize / 2),pointerColor));
		        repaint();
		      }

		      public void mouseMoved(MouseEvent e) {}
		    });

		  }
	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0 , 0 , this.getWidth(), this.getHeight());
		if(this.dessiner) {
			this.dessiner= false ;
		}
		else {
			for(Point p : this.points)
			{
				 g.setColor(p.getColor());

			        if(p.getType().equals("SQUARE")){
			          g.fillRect(p.getPosX(), p.getPosY(), p.getSize(), p.getSize());
			        }
			        else{
			          g.fillOval(p.getPosX(), p.getPosY(), p.getSize(), p.getSize());
			        }
			       
			}
		}
	}

	public void setPointerSize(int size) {
		this.pointerSize = size;
	}

	public void setPointerColor(Color couleur) {
		this.pointerColor = couleur ;
		
		
	}
	public void dessin() {
		this.dessiner = true ;
		this.points = new ArrayList<Point>();
		repaint();
	}
	 public void setPointerType(String str){
		    this.pointerType = str;
		  }   
	
	
}