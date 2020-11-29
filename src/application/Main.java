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
		  
		  BorderPane root = new BorderPane();
		  
		  HomeToolBar htb = new HomeToolBar();
		  HBox hb = htb.constructTopBar();
		  
		  Status s = new Status();
		  HBox statusBox = s.constructStatus();
		  
		  root.setTop(hb);
		  root.setCenter(statusBox);
		  //BorderPane.setAlignment(hb, Pos.CENTER);
		  BorderPane.setAlignment(statusBox, Pos.CENTER);
		  
		  Scene homepage = new Scene(root,600,600);
		  
		  // homepage is the first scene 
		  primaryStage.setScene(homepage);
		  
		  primaryStage.show();
		  
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
  public static void main(String[] args) {
		launch(args);
	}
}
