package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;

public class HomeToolBar {
	
	public ToolBar constructToolBar() {
		Label project = new Label("ASSIGNMENT TRACKER");
		Button sort = new Button("sort by dates");
		
		ToolBar toolbar = new ToolBar(project, sort);
		
		return toolbar;
	}
	
	public HBox constructTopBar() {
		HBox hb = new HBox(); 
		
		hb.setPadding(new Insets(20,20,20,20));		
		
		hb.setStyle("-fx-background-color: #89cff0;");
		
		Label title = new Label("Assignment Tracker");
			
		hb.getChildren().add(title);
		
		hb.setAlignment(Pos.CENTER);
		
		return hb;
	}

}

