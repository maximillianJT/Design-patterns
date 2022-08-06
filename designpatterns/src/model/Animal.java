package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Animal extends GameObject{
	public double dx; 
	public double dy;
	public double width =100,height =100;

	
	// inherits the gameObject class
	public Animal(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		img = new Image (Animal.class.getResource("/model/resources/frog.png").toExternalForm());
		
	    update(); 
		
	
	}
	// redraws the gc 
	public void move() {
		gc.drawImage(img, x, y, width,height);
		//update();
	}
	// moves the GraphicsContext up 
	public void moveUp() {
		this.y = this.y - 5;
		System.out.println(dy);
		
	}
	// moves the GraphicsContext Down
	public void moveDown() {
		this.y = this.y + 5;
		System.out.println(dy);
		
	}
	// moves the GraphicsContext left
	public void moveLeft() {
		x = x - 5;
	}
	// moves the GraphicsContext right
	public void moveRight() {
		x = x + 5;
	}
	
	public double getFrogX() {
		return this.dx;
	}
	
	public double getFrogY() {
		return this.dy;
	}
	


}
