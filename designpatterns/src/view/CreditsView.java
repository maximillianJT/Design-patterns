package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class CreditsView {
	
	private static final int HEIGHT = 768;
    private static final int WIDTH = 1024;
    private AnchorPane creditPane;
    private Scene creditScene;
    private Stage creditStage;
    private Stage viewStage;
    
    MainView view = new MainView();
    Controller controller = new Controller();



    // constructor 
    public CreditsView() {

        creditPane = new AnchorPane();
        creditScene = new Scene(creditPane,WIDTH,HEIGHT);
        creditStage = new Stage();
        creditStage.setScene(creditScene);

    // createBackground();
        createLabel();
        createButton();
    }
    
    // Create buttons for stage
    public void createButton() {
        createBackButton();
    }

    // get method to return stage 
    public Stage getCreditsStage() {
        return creditStage;
    }

    // Creates label for credits stage
    public void createLabel(){
          Label title = new Label("Game by max");
          Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 70);
          
          title.setFont(font);
          title.setTextFill(Color.BROWN);
          title.setTranslateX(350);
          title.setTranslateY(100);
          Label controls = new Label("Use WASD to control the frog! Find the correct habitat for it ");
          controls.setTranslateX(400);
          controls.setTranslateY(200);
          
          controls.setTextFill(Color.BROWN);
          creditPane.getChildren().add(title);
          creditPane.getChildren().add(controls);
    }
    
    // Creates background for credits stage
    private void createBackground() {
    	        
    }
    
    // creates a back button to return home after the credits have been viewed

    private void createBackButton() {
        Button backButton = new Button("Back home");
        addButton(backButton);

        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                viewStage = view.getMainStage();               
                controller.setStage(creditStage,viewStage);
            }
        });
    }

    // adds button to the credits pane to return back to the main menu
    public void addButton(Button button) {
        creditPane.getChildren().add(button);
    }

}
