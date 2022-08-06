package view;


import java.util.ArrayList;
import java.util.List;
import model.GameButtons;


import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// construtor for main view (menu)

public class MainView {
	
	private static final int HEIGHT = 768; //Height saved gloablly 
    private static final int WIDTH = 1024; // width saved globally 
    private AnchorPane mainPane;
    private Scene homeScene;
    Stage mainStage; // mainstage of this class
    Stage gameStage; // gameStage to be saved from another class
    Stage newViewStage; // new stage 
    Stage creditsStage; // credits stage to be saved
    Image backgroundImage; //background image
    
    private final static int MENU_BUTTONS_START_X = 384; //position x of arraylist of buttons 
    private final static int MENU_BUTTONS_START_Y = 200; // position y of arraylist of buttons

   

    //Array for buttons
    List<GameButtons> menuButtons;
    
    // instances of classes
    Controller controller = new Controller();
    GameView game = new GameView();
    
    // constuctor for mainView ( menu )
	public MainView() {
		    menuButtons = new ArrayList<>();
	        mainPane = new AnchorPane();
	        homeScene = new Scene(mainPane,WIDTH,HEIGHT);
	        mainStage = new Stage();
	        mainStage.setTitle("Game menu");
	        mainStage.setResizable(false);
	        mainStage.setScene(homeScene);
	        createButton();
	        createBackground();
	        createLabel();
	}
	
	// get method for stage
	public Stage getMainStage() {
		return mainStage;
	}
	
	
	// adds buttons to ArrayList, positions buttons,
    private void addMenuButton(GameButtons button) {
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100); 
        
        menuButtons.add(button);
        mainPane.getChildren().add(button);

    }
	
	//creates buttons
	public void createButton() {
        createStartButton();
        createCreditButton();
        createExitButton();
    }
	
	// creates Start button to run the game 
	// has a method and uses the controller to select scene
    public void createStartButton() {
        GameButtons startButton = new GameButtons("Start New Game");
        addMenuButton(startButton);
        

        startButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                gameStage = game.getGameStage();
                
                controller.setStage(mainStage,gameStage);
                
            }
        });
    }
    
    // open credits stage based on click
    // uses the controller to select the credits stage 
      public void createCreditButton() {

        GameButtons creditsButton = new GameButtons("Credits/Controls");
        addMenuButton(creditsButton);

        creditsButton.setOnAction(new EventHandler<ActionEvent>() {

           @Override
           public void handle(ActionEvent event) {
               CreditsView credView = new CreditsView();
               
               creditsStage  = credView.getCreditsStage();
               controller.setStage(mainStage,creditsStage);
           }

        });

       }
    
   // Exit button to exit application
      // uses the controller to exit the stage
     public void createExitButton() {

        GameButtons exitButton = new GameButtons("EXIT Game");
        addMenuButton(exitButton);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {

           @Override
           public void handle(ActionEvent event) {

               
               controller.exitStage(mainStage);
           }
        });

    }
     // create background for stage
     private void createBackground() {
    	
    	 
    	// try {
    	// backgroundImage = new Image("/designpatterns/src/model/resources/grass.jpg");
    	 
    	 //} catch (Exception e) {    		 
    	 //}
    	 
        // BackgroundImage homeBackground = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null );
        // mainPane.setBackground(new Background(homeBackground));
    	 
    	   // Image backgroundImage = new Image("/view/resources/grass.jpg", 1024 ,768,false,true);
			//BackgroundImage homeBackground = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null );
			//mainPane.setBackground(new Background(homeBackground));
    	 
    	    homeScene.setFill(Color.AQUA);
    	 
     }
     
     
       //Homepage title
       public void createLabel(){
           Label title = new Label("KS1 Science Game");
           Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 70);
           title.setFont(font);
           title.setTextFill(Color.GREEN);
           title.setTranslateX(150);
           title.setTranslateY(25);

           mainPane.getChildren().add(title);

     }
     
  
     
     
  }
