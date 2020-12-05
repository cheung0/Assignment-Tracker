package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// specialized cell class for Task objects

public class TaskFormatCell extends ListCell<Task> {
	
	public TaskFormatCell() { }
	
	@Override protected void updateItem(Task item, boolean empty) {
		super.updateItem(item, empty);
		VBox taskInfo = new VBox();
		
		if(empty || item == null) {
			setGraphic(null);
			
		} else {
			
			// cell shows task name, description, and date 
			
			Label task = new Label(item.getName());
			task.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			
			Label description = new Label("Description: ");
			description.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			Label descriptionText = new Label(item.getDescription());
			
			LocalDate date = item.getDate(); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MM dd yyyy");
			String formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(date);
			Label dateLabel = new Label("Due: ");
			dateLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
			Label dateValue = new Label(formattedDate);
			
			HBox dates = new HBox(dateLabel, dateValue);
			
			taskInfo.getChildren().addAll(task,description, descriptionText, dates);
			setGraphic(taskInfo);
		}
	
	}
}
