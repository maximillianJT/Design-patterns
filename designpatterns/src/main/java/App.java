package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MainView;



public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	try {
    		// gets instace of gameView object  and shows the stage
        MainView menuView = new MainView();
        primaryStage = menuView.getMainStage();
        primaryStage.show();

        
        
    } catch (Exception e ) {
    	e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        launch(args);
    }

}