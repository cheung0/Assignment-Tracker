package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

public class TaskFormatCell extends ListCell<Task> {
	
	public TaskFormatCell() { }
	
	@Override protected void updateItem(Task item, boolean empty) {
		super.updateItem(item, empty);
		VBox taskInfo = new VBox();
		
		if(empty || item == null) {
			setGraphic(null);
			System.out.println("Null Cell");
		} else {
			
			Label task = new Label("Task: " + item.getName());
			Label description = new Label("Description: " +item.getDescription());
			LocalDate date = item.getDate();//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MM dd yyyy");
			String formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(date);
			Label dateLabel = new Label("Due: " + formattedDate);
			
			taskInfo.getChildren().addAll(task,description,dateLabel);
			setGraphic(taskInfo);
		}
	
	}
}
