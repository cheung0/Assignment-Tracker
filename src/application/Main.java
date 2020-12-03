package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
