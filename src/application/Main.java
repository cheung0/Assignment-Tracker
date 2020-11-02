package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
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
		  // Circle shape = constructCircle();
		  // shape.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> shape.setFill(Color.BLUE));
		  // shape.addEventHandler(MouseEvent.MOUSE_EXITED, e -> shape.setFill(Color.RED));
		  
		  
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
	
	
	private ToolBar constructToolBar() {
		Label project = new Label("ASSIGNMENT TRACKER");

		Button sort = new Button("sort by dates");
		
		ToolBar toolbar = new ToolBar(project, sort);
		
		return toolbar;
	}


	private HBox constructHBox(Stage primaryStage) {
		// leave the buttons alone, ask Michael 
		// because the buttons don't show up if it's just a single button
		Button addTask1 = new Button("+");
		Button addTask2 = new Button("+");
		Button addTask3 = new Button("+");
		
	    addTask1.setOnAction(
	        new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                VBox dialogVbox = new VBox(20);
	                dialogVbox.getChildren().add(new Label("This is a Dialog"));
	                Scene dialogScene = new Scene(dialogVbox, 300, 200);
	                dialog.setScene(dialogScene);
	                dialog.show();
	            }
	         });
	    
	    addTask2.setOnAction(
	        new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                VBox dialogVbox = new VBox(20);
	                dialogVbox.getChildren().add(new Label("This is a Dialog"));
	                Scene dialogScene = new Scene(dialogVbox, 300, 200);
	                dialog.setScene(dialogScene);
	                dialog.show();
	            }
	         });
	    
	    addTask3.setOnAction(
	        new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                VBox dialogVbox = new VBox(20);
	                dialogVbox.getChildren().add(new Label("This is a Dialog"));
	                Scene dialogScene = new Scene(dialogVbox, 300, 200);
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


	private Circle constructCircle() {
    Circle shape = new Circle();
    shape.setCenterX(200);
    shape.setCenterY(150);
    shape.setRadius(100);
    shape.setFill(Color.RED);
    shape.setCursor(Cursor.HAND);
    return shape;
  }
	
	
  public static void main(String[] args) {
		launch(args);
	}
}
