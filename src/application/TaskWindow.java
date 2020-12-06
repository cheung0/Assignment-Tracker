package application;

import java.time.LocalDate;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskWindow {
	
	// creates layout of task dialog 
	public VBox constructTask(String parentID) {
		VBox taskDialog = new VBox();
	 
        Button save = new Button("Save");
        VBox vBox = new VBox();
        
        Label taskLabel = new Label("Task:");
        TextField taskTextField = new TextField();
        Label descriptionLabel = new Label("Description: ");
        TextField descriptionTextField = new TextField();
        descriptionTextField.setPrefSize(50, 50);
        Label dueDateLabel = new Label("Due Date:");
        
        TilePane tilePane = new TilePane();
        DatePicker calendar = new DatePicker();
        
        tilePane.getChildren().add(calendar);
        
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                taskLabel, taskTextField, 
                descriptionLabel, descriptionTextField, dueDateLabel, tilePane, save);
        taskDialog.getChildren().add(vBox);
        
        // alert dialog show if fields are empty
        // otherwise task is added to correct list 
        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				Alert alert = new Alert(AlertType.WARNING);
				
				if(taskTextField.getText().isEmpty() || descriptionTextField.getText().isEmpty()
						|| calendar.getValue() == null) 
				{
					alert.setContentText("Please fill in empty field(s)");
					alert.show();
		
				} else {
					String task = taskTextField.getText();
					String description = descriptionTextField.getText();
					LocalDate date = calendar.getValue();
					
					Task newTask = new Task(task, description, date);
					
					// access list from column in which save was clicked 
					BorderPane bp = Status.getBorderPane(parentID);
					ListView<Task> lvList = (ListView<Task>) bp.getChildren().get(1);
					
					// add the task to the list
					lvList.getItems().add(newTask);
					
					// close window
					Stage curr = (Stage) save.getScene().getWindow();
					curr.close();
				}
			}
        	
        });
        
        return taskDialog;
	}


}
