package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Status {
	
	private static BorderPane todo;
	private static BorderPane doing;
	private static BorderPane done;
	
	private static final String TODOID = "To Do";
	private static final String DOINGID = "Doing";
	private static final String DONEID = "Done";

	// combines individual task columns into single HBox    
	public HBox constructStatus() {
	   
	    todo = createTaskColumn(TODOID);
	    doing = createTaskColumn(DOINGID);
	    done = createTaskColumn(DONEID);
        
        HBox hbox = new HBox(todo, doing, done);
        hbox.setAlignment(Pos.CENTER);

		return hbox;
	}
	
	// creates individuals task columns 
	public BorderPane createTaskColumn(String title) {
		
		BorderPane base = new BorderPane();
		
		// id used to determine which column to add/delete/sort task(s)
		base.setId(title);
		
		// creates and organizes heading 
		HBox topLabel = new HBox(); 
		Label lb = new Label(title);
		lb.setFont(Font.font("Arial", FontWeight.BOLD, 17));		
		
		topLabel.getChildren().add(lb);
		topLabel.setAlignment(Pos.CENTER);
		topLabel.setSpacing(10);
		topLabel.setPadding(new Insets(5,20,0,20));
		
		// creates and organizes buttons 
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
		
		// adding ListView to column 
		TaskList tl = new TaskList();
		ListView<Task> lvList = tl.constructList();
		
		base.setTop(topLabel); 
		base.setCenter(lvList); 
		base.setBottom(botLabel); 
		
		String colLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: solid;\n";
		
		base.setStyle(colLayout);
		
		return base;
		
	}
	
	// returns correct column based on id
	public static BorderPane getBorderPane(String id) {
		if(id == "To Do") {
			return todo;
		} else if (id == "Doing") {
			return doing;
		} else {
			return done;
		}
	}
	
	// removes a list item
	public void deleteButtonClicked(String id) {
		BorderPane bp = getBorderPane(id);
		ListView<Task> lvList = (ListView<Task>) bp.getChildren().get(1);
		
		// get id of selected item to delete 
		int selectedID = lvList.getSelectionModel().getSelectedIndex();
		
		// remove the item from the correct list 
		lvList.getItems().remove(selectedID);
		
	}
	
	// adds list item 
	public void sortButtonClicked(String id) {
		BorderPane bp = getBorderPane(id);
		ListView<Task> lvList = (ListView<Task>) bp.getChildren().get(1);
		lvList.getItems().sort(new SortbyDate());
	}
	
}






















