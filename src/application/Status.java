package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Status {
	
	private static BorderPane todo;
	private static BorderPane doing;
	private static BorderPane done;

	public HBox constructStatus() {
	   
	    todo = createTaskColumn("ToDo");
	    doing = createTaskColumn("Doing");
	    done = createTaskColumn("Done");
        
        HBox hbox = new HBox(todo, doing, done);
        hbox.setAlignment(Pos.CENTER);

		return hbox;
	}
	
	public BorderPane createTaskColumn(String title) {
		BorderPane base = new BorderPane();
		base.setId(title);
		
		HBox topLabel = new HBox(); 
		Label lb = new Label(title);
		lb.setFont(new Font("Arial", 15));
		
		
		topLabel.getChildren().addAll(lb);
		topLabel.setAlignment(Pos.CENTER);
		topLabel.setSpacing(10);
		topLabel.setPadding(new Insets(5,20,0,20));
		
		String colLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: solid;\n";
		
		HBox botLabel = new HBox();
		Button add = new Button("Add"); 

		
		TaskWindow t = new TaskWindow();
		EventHandler addHandler = t.addTaskClicked(base.getId());
	
		add.setOnAction(addHandler); 
		
		Button delete = new Button("Delete");
		
		delete.setOnAction(e -> deleteButtonClicked(base.getId()));
		
		Button sort = new Button("Sort");
		
		sort.setOnAction(e -> sortButtonClicked(base.getId()));
		
		botLabel.setAlignment(Pos.CENTER);
		
		add.setMaxWidth(Double.MAX_VALUE);
		delete.setMaxWidth(Double.MAX_VALUE);
		
		botLabel.setSpacing(10);
		botLabel.getChildren().addAll(add,delete, sort);
		
		// list 
		TaskList tl = new TaskList();
		ListView<Task> lvList = tl.constructList();
	
		base.setTop(topLabel);
		base.setCenter(lvList);
		base.setBottom(botLabel);
		
		base.setStyle(colLayout);
		
		return base;
		
	}
	
	public static BorderPane getBorderPane(String id) {
		if(id == "ToDo") {
			return todo;
		} else if (id == "Doing") {
			return doing;
		} else {
			return done;
		}
	}

	public void deleteButtonClicked(String id) {
		BorderPane bp = getBorderPane(id);
		ListView<Task> lvList = (ListView<Task>) bp.getChildren().get(1);
		
		// get id of selected item to delete 
		int selectedID = lvList.getSelectionModel().getSelectedIndex();
		
		// remove the item from the correct list 
		lvList.getItems().remove(selectedID);
		
	}
	

	public void sortButtonClicked(String id) {
		BorderPane bp = getBorderPane(id);
		ListView<Task> lvList = (ListView<Task>) bp.getChildren().get(1);
		lvList.getItems().sort(new SortbyDate());
	}
	
}






















