package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class HomeToolBar {
	
	public HBox constructTopBar() {
		HBox hb = new HBox(); 
		
		hb.setPadding(new Insets(20,20,10,20));		
		
		hb.setStyle("-fx-background-color: #89cff0;");
		
		Label title = new Label("Assignment Tracker");
		title.setFont(new Font("Arial", 20));
		
			
		hb.getChildren().add(title);
		
		hb.setAlignment(Pos.CENTER);
		
		return hb;
	}

}

