package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Animal;

public class Controller {
	
	Stage currentStage;
    Stage setStage;
    



    //Method to show stage 
    //First parameter closes stage
    //Second parameter open/Sets stage

    public void setStage(Stage currentStage,Stage setStage) {
        this.currentStage = currentStage;
        this.currentStage.close();
        setStage.show();
    }

    //method to exit the current stage
    public void exitStage(Stage currentStage) {
        this.currentStage = currentStage;
        this.currentStage.close();
    }
    
}
