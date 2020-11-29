package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Status {
	
	// makes the horizontal box 
	// there are three v boxes, one for todo, one for doing, and one for done
	public HBox constructStatus(Stage primaryStage) {
		// leave the buttons alone
		Button addTask1 = new Button("+");
		Button addTask2 = new Button("+");
		Button addTask3 = new Button("+");
		
		// Define an event handler
		EventHandler handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(primaryStage);
                
                Task t = new Task(); 
                VBox taskPopUp = t.constructTask();
              
                Scene dialogScene = new Scene(taskPopUp, 400, 400);
                dialog.setScene(dialogScene);
                dialog.show();
            }
         };
		
		// makes another window popup after clicking the first plus button
	    addTask1.setOnAction(handler);
	   
	    addTask2.setOnAction(handler);
	    
	    addTask3.setOnAction(handler);
	    
	    VBox vbox1 = new VBox(10); // spacing = 8
	    vbox1.getChildren().addAll(new HBox(new Label("TODO"), addTask1), new Label("code todo list"), new Label("do history homework"));
	    
	    VBox vbox2 = new VBox(10); // spacing = 8
	    vbox2.getChildren().addAll(new HBox(new Label("DOING"), addTask2), new Label("code todo list"), new Label("do history homework"));

	    VBox vbox3 = new VBox(10); // spacing = 8
	    vbox3.getChildren().addAll(new HBox(new Label("DONE"), addTask3), new Label("code todo list"), new Label("do history homework"));
	    
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        Region region2 = new Region();
        HBox.setHgrow(region2, Priority.ALWAYS);

        HBox hbox = new HBox(vbox1, region1, vbox2, region2, vbox3);

		return hbox;
	}

}
