package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		  // create the nodes
		  BorderPane root = new BorderPane();
		  ToolBar toolbar = constructToolBar();
		  HBox hbox = constructHBox(primaryStage);
		  
		  root.setTop(toolbar);
		  root.setCenter(hbox);
		  BorderPane.setAlignment(toolbar, Pos.CENTER);
		  BorderPane.setAlignment(hbox, Pos.CENTER);
		  
		  Scene scene = new Scene(root,600,600);
		  primaryStage.setScene(scene);
		  primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// makes the tool bar
	private ToolBar constructToolBar() {
		Label project = new Label("ASSIGNMENT TRACKER");
		
		Button sort = new Button("sort by dates");
		
		ToolBar toolbar = new ToolBar(project, sort);
		
		return toolbar;
	}

	
	// makes the horizontal box 
	// there are three v boxes, one for todo, one for doing, and one for done
	private HBox constructHBox(Stage primaryStage) {
		// leave the buttons alone
		Button addTask1 = new Button("+");
		Button addTask2 = new Button("+");
		Button addTask3 = new Button("+");
		
		// makes another window popup after clicking the first plus button
	    // after clicking the "Add Task" button, the form's content will be added to the home page
	    addTask1.setOnAction(
	        new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                VBox dialogVbox = new VBox(40);
	              
	                Button button = new Button("Add Task");
	                VBox vBox = new VBox();
	                
	                vBox.setSpacing(10);
	                vBox.setPadding(new Insets(10,10,10,10));
	                vBox.getChildren().addAll(
	                        new Label("Your Task"),
	                        new TextField(),
	                        new Label("Your Due Date"),
	                        new TextField(),
	                        button);
	                dialogVbox.getChildren().addAll(vBox);

	                button.setOnAction(actionEvent-> {
	                    Stage stage = new Stage();
	                    StackPane stackPane = new StackPane();
	                    stage.setScene(new Scene(stackPane, 200,200));
	                    stage.show();
	                });
	                

	                Scene dialogScene = new Scene(dialogVbox, 400, 400);
	                dialog.setScene(dialogScene);
	                dialog.show();
	            }
	         });
	    
		// makes the add task form pop up after clicking the second plus button
	    // after clicking the "Add Task" button, the form's content will be added to the home page
	    addTask2.setOnAction(
	        new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                VBox dialogVbox = new VBox(40);
	              
	                Button button = new Button("Add Task");
	                VBox vBox = new VBox();
	                
	                vBox.setSpacing(10);
	                vBox.setPadding(new Insets(10,10,10,10));
	                vBox.getChildren().addAll(
	                        new Label("Your Task"),
	                        new TextField(),
	                        new Label("Your Due Date"),
	                        new TextField(),
	                        button);
	                dialogVbox.getChildren().addAll(vBox);

	                button.setOnAction(actionEvent-> {
	                    Stage stage = new Stage();
	                    StackPane stackPane = new StackPane();
	                    stage.setScene(new Scene(stackPane, 200,200));
	                    stage.show();
	                });
	                

	                Scene dialogScene = new Scene(dialogVbox, 400, 400);
	                dialog.setScene(dialogScene);
	                dialog.show();
	            }
	         });
	    
		// makes another window popup after clicking the third plus button
	    // after clicking the "Add Task" button, the form's content will be added to the home page
	    addTask3.setOnAction(
	        new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                VBox dialogVbox = new VBox(40);
	              
	                Button button = new Button("Add Task");
	                VBox vBox = new VBox();
	                
	                vBox.setSpacing(10);
	                vBox.setPadding(new Insets(10,10,10,10));
	                vBox.getChildren().addAll(
	                        new Label("Your Task"),
	                        new TextField(),
	                        new Label("Your Due Date"),
	                        new TextField(),
	                        button);
	                dialogVbox.getChildren().addAll(vBox);

	                button.setOnAction(actionEvent-> {
	                    Stage stage = new Stage();
	                    StackPane stackPane = new StackPane();
	                    stage.setScene(new Scene(stackPane, 200,200));
	                    stage.show();
	                });
	                

	                Scene dialogScene = new Scene(dialogVbox, 400, 400);
	                dialog.setScene(dialogScene);
	                dialog.show();
	            }
	         });
	    
	    VBox vbox1 = new VBox(10); // spacing = 8
	    vbox1.getChildren().addAll(new HBox(new Label("TODO     "), addTask1), new Label("code todo list"), new Label("do history homework"));
	    
	    VBox vbox2 = new VBox(10); // spacing = 8
	    vbox2.getChildren().addAll(new HBox(new Label("DOING     "), addTask2), new Label("code todo list"), new Label("do history homework"));

	    VBox vbox3 = new VBox(10); // spacing = 8
	    vbox3.getChildren().addAll(new HBox(new Label("DONE     "), addTask3), new Label("code todo list"), new Label("do history homework"));
	    
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        Region region2 = new Region();
        HBox.setHgrow(region2, Priority.ALWAYS);

        HBox hbox = new HBox(vbox1, region1, vbox2, region2, vbox3);

		return hbox;
	}
	
	
  public static void main(String[] args) {
		launch(args);
	}
}
