package application;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TaskWindow {
	
	TextField taskTextField;
	TextField subjectTextField;
	TextField descriptionTextField;
	
	DatePicker calendar;
	Button save;
	
	public VBox constructTask(String parentID) {
		VBox taskDialog = new VBox(40);
        
        save = new Button("Save");
        VBox vBox = new VBox();
        
        Label subjectLabel = new Label("Subject:");
        subjectTextField = new TextField();
        Label taskLabel = new Label("Task:");
        taskTextField = new TextField();
        Label descriptionLabel = new Label("Description: ");
        descriptionTextField = new TextField();
        Label dueDateLabel = new Label("Due Date:");
        
        TilePane tilePane = new TilePane();
        calendar = new DatePicker();
        
        tilePane.getChildren().add(calendar);
        
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                taskLabel, taskTextField, subjectLabel, subjectTextField, 
                descriptionLabel, descriptionTextField, dueDateLabel, tilePane, save);
        taskDialog.getChildren().add(vBox);
        
        save.setOnAction(e -> saveButtonClicked(parentID));
        
        return taskDialog;
	}
	
	public void saveButtonClicked(String parentID) {
	
		// gets text from input
		String task = taskTextField.getText();
		String subject = subjectTextField.getText();
		String description = descriptionTextField.getText();
		LocalDate date = calendar.getValue();
		
		System.out.println(task);
		System.out.println(description);
		System.out.println(date);

		
		Task newTask = new Task(task, subject, description, date);
		
		// access list from column in which save was clicked 
		BorderPane bp = Status.getBorderPane(parentID);
		ListView<Task> lvList = (ListView<Task>) bp.getChildren().get(1);
		
		// add the task to the list
		lvList.getItems().add(newTask);
		
		// close window
		Stage curr = (Stage) save.getScene().getWindow();
		curr.close();
		
		
	}

	public EventHandler addTaskClicked(String parentID) {
		
		Stage addTaskStage = new Stage(); 
		
		EventHandler handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(addTaskStage);
               
                VBox taskPopUp = constructTask(parentID);
              
                Scene dialogScene = new Scene(taskPopUp, 300, 350);
                dialog.setScene(dialogScene);
                dialog.show();
            }
         };
         
         return handler;
	}


}
