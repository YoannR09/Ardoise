package fr.yoannroche.ardoise;

import java.awt.Color;

import javax.swing.JPanel;

public class Point{

	private Color couleur = Color.black;
	
	private String type = "Rond";
	
	private int size = 10;
	private int posX = -10, oldX = -10;
	private int posY = -10, oldY = -10;



public Point() {}

public Point(String type , int size , int posX , int posY , Color couleur) {
	
	this.type = type ;
	this.size = size ;
	this.posX = posX;
	this.posY = posY;
	this.couleur = couleur ;
}
	

public String getType() {
	return type ;
}
public void setType (String type) {
	this.type = type ;
}
public int getSize () {
	return size ;
}
public void setSize(int size) {
	this.size = size ;
}
public int getPosX () {
	return posX ;
}
public void setPosX (int posX) {
	this.posX = posX ;
}
public int getPosY () {
	return posY ;
}
public void setPosy (int posY) {
	this.posY = posY ;
}
public Color getColor() {
	return couleur ;
}
public void setColor (Color couleur) {
	this.couleur = couleur;
}
	
	
}






