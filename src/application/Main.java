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
		  Status s = new Status();
		  HBox statusBox = s.constructStatus(primaryStage);
		  
		  root.setTop(toolbar);
		  root.setCenter(statusBox);
		  BorderPane.setAlignment(toolbar, Pos.CENTER);
		  BorderPane.setAlignment(statusBox, Pos.CENTER);
		  
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

	
  public static void main(String[] args) {
		launch(args);
	}
}
