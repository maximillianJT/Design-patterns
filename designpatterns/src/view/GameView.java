package view;


	
	import java.util.ArrayList;

import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
	import javafx.scene.Group;
	import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.canvas.Canvas;
	import javafx.scene.canvas.GraphicsContext;
	import javafx.scene.image.Image;
    import javafx.scene.input.KeyCode;
    import javafx.scene.input.KeyEvent;
	import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.Background;
	import javafx.scene.layout.BackgroundImage;
	import javafx.scene.layout.BackgroundPosition;
	import javafx.scene.layout.BackgroundRepeat;
	import javafx.scene.layout.Pane;
	import javafx.scene.paint.Color;
	
    
    import javafx.stage.Stage;
    import model.Animal;
   
    import model.Habitat;


		public class GameView{

			private Pane gamePane;
			
			private Scene gameScene;
			private Stage gameStage;
			private Stage menuStage;
			Canvas canvas;
			GraphicsContext gameObj;
			private boolean intersects; 
			private static final int GAME_WIDTH = 1024;
			private static final int GAME_HEIGHT = 768;
			
		    
		    private AnimationTimer at; //animation timer to refresh the stage 
		    public double x;
		    public double y;
		    public Image img;
		    public int index = 1;
		    protected double dx = 1.0D, dy = 1.0D;
		    protected double width = 100.0D;
		    protected double height = 100.0D;
		    Animal frog; 
		    Habitat pond;
		    
		    
		    
			public GameView() {
				
				createStage();
				checkCol(frog,pond);
				System.out.println(intersects);
				
			}
			
            //get game stage 
			public Stage getGameStage() {
				return gameStage;
			}
			// creates stage with Scene, Canvas , Pane includes the animation timer for movement of frames
			public void createStage() {
				 
				
				gamePane = new Pane();
				gameScene = new Scene(gamePane);
				gameStage = new Stage();
				gameStage.setResizable(false);
				gameStage.setScene(gameScene);
				
				canvas = new Canvas(1024,768);
				gamePane.getChildren().add(canvas);
				gameObj = canvas.getGraphicsContext2D();
				
				gameObj.setFill(Color.WHITE);
				gameObj.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
				
				frog = new Animal(gameObj,10,10);
				pond = new Habitat(gameObj,100,100);
				
				
				
				AnimationTimer at = new AnimationTimer() {

					@Override
					public void handle(long now) {
						gameObj.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
						frog.move();
						pond.move();
						
						
						
					}
					
				};
				
				//event handler which uses keyboard events. uses methods of the Animal class to move
				// the frog based on key events
				EventHandler<KeyEvent> keyboardHandler = new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent event) {
						if(event.getCode()==KeyCode.S)
							frog.moveDown();
							System.out.println(event.getCode());
					    if(event.getCode()==KeyCode.A)
					    	frog.moveLeft();
					    if(event.getCode()==KeyCode.W) 
					    	frog.moveUp();
					    if(event.getCode()==KeyCode.D)
					        frog.moveRight();
					   
						
					}
					
				}; 
				     // enables the event handler on the gameScene 
				    gameScene.setOnKeyPressed(keyboardHandler);
				    at.start();
					//move();
		
				
			}
			
			public boolean checkCol(Animal animal, Habitat habitat) {
				
				
				if (animal.getFrogX()== habitat.getX()) {
					
					
					intersects = true; 
	            
					}
				else {
					intersects = false;
				}
				
				return intersects;
				
			}
			
			
			
			
			
		
			//create background
			public void createBackground() {
				Image backgroundImage = new Image("model/resources/grass.png", 1024 ,768,false,true);
				BackgroundImage homeBackground = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null );
				gamePane.setBackground(new Background(homeBackground));
			}
			
			
			
			// ------------------------------OLD CODE trial and error------------------------
			
		//	public void move() {
			//    frog.x += dx;
		//	    if (frog.x > 800.0D - width)
		//	     frog.dx = -dx; 
		//	    if (frog.x < 0.0D)
		//	      dx = - dx; 
		//	    frog.y += dy;
		//	    if (frog.y > 600.0D - height)
		//	      dy = - dy; 
		//	    if (frog.y < 0.0D)
		//	      dy = - dy; 
		//	    gameObj.drawImage(frog.img, 20,20,width,height);
			    
			    
		//	  }
			
			
			
			
			// Create view Stage and pane 
			//public Parent createGameView() {
				
			   // gamePane = new AnchorPane();
		      //  Circle circle = new Circle(25,25,25,Color.RED);
		       // canvas = new Canvas(500,500);
		      //  gameObj = canvas.getGraphicsContext2D();
		        
		      //  Image img = new Image(getClass().getResourceAsStream("data/fieldcartoon.jpg"));
		        
		       
		     //   circle.setTranslateX(50);
		    //    circle.setTranslateY(50);
		     //   Group group = new Group();
		        
		     //   gameObj.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		     //   gameObj.setFill(Color.WHITESMOKE);
		        
		      //  var root = new Pane (gameObj);
		     //   root.setPrefSize(1024,768);
		     //   root.setBackground(new Background(homeBackground));
		      //  root.getChildren().add(canvas);
		      //  root.getChildren().forEach(this::makeDraggable);
		        
		   
		        
		       // return root;
		        
		        
			//}
			
			
			//enables dragging of nodes in root
			
		//	public void makeDraggable(Node node) {
			//	node.setOnMousePressed(e -> {
					//
			//		startX = e.getSceneX() - node.getTranslateX();
			//		startY = e.getSceneY() - node.getTranslateY();
			//	});
				
			//	node.setOnMouseDragged(e -> {
									//	node.setTranslateX(e.getSceneX() - startX);
			//		node.setTranslateY(e.getSceneY() - startY);
			//	});
		//	}
			
			
				
			// animation timer
				 
				
				
				
			//handle
			//	EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {

			//		@Override
			//		public void handle(KeyEvent event) {
				//		// TODO Auto-generated method stub
						
				//	}
					
		
		// Create view Stage and pane 
		//public Parent createGameView() {
			
		   // gamePane = new AnchorPane();
	      //  Circle circle = new Circle(25,25,25,Color.RED);
	       // canvas = new Canvas(500,500);
	      //  gameObj = canvas.getGraphicsContext2D();
	        
	      //  Image img = new Image(getClass().getResourceAsStream("data/fieldcartoon.jpg"));
	        
	       
	     //   circle.setTranslateX(50);
	    //    circle.setTranslateY(50);
	     //   Group group = new Group();
	        
	     //   gameObj.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	     //   gameObj.setFill(Color.WHITESMOKE);
	        
	      //  var root = new Pane (gameObj);
	     //   root.setPrefSize(1024,768);
	     //   root.setBackground(new Background(homeBackground));
	      //  root.getChildren().add(canvas);
	      //  root.getChildren().forEach(this::makeDraggable);
	        
	   
	        
	       // return root;
	        
	        
		//}
		
		
		
		 //add button
	//	public void addButton(Button button) {
	////		gamePane.getChildren().add(button);
	//	}
		
		//enables dragging of nodes in root
		
//		public void makeDraggable(Node node) {
//			node.setOnMousePressed(e -> {
//				//
//				startX = e.getSceneX() - node.getTranslateX();
//				startY = e.getSceneY() - node.getTranslateY();
//			});
			
//			node.setOnMouseDragged(e -> {
				//
//				node.setTranslateX(e.getSceneX() - startX);
//				node.setTranslateY(e.getSceneY() - startY);
//			});
//		}
		
		
			
		// animation timer
			 
			
			
			
		//handle
		//	EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {

		//		@Override
		//		public void handle(KeyEvent event) {
			//		// TODO Auto-generated method stub
					
			//	}
				

}
