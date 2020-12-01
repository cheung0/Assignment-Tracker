package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
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
			
			System.out.println(item.getName());
			System.out.println(item.getSubject());
			System.out.println(item.getDescription());
			
			Label task = new Label("Task: " + item.getName());
			Label subject = new Label("Subject:" + item.getSubject());
			Label description = new Label("Description: " +item.getDescription());
			LocalDate date = item.getDate();//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			Label formattedDate = new Label("Due: " + date.format(formatter));
			
			taskInfo.getChildren().addAll(task,subject,description,formattedDate);
			setGraphic(taskInfo);
		}
	
	}
}
