package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Habitat extends GameObject{
	
	public double width =100,height =100;
	
// habitat class which stores the pond game object
	public Habitat(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		img = new Image (Habitat.class.getResource("/model/resources/pond.png").toExternalForm());
		System.out.println("pond here");
		update();
	}
	
	
		public void move() {
			gc.drawImage(img, x, y);
			
		}
		
		public double getX() {
			return this.x;
		
		}
		
		public double getY() {
			return this.y;
		}
	}
	


