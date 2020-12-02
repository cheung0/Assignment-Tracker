package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TaskFormatCell extends ListCell<Task> {
	
	String task;
	String subject;
	String description;
	LocalDate date;
	
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MM dd yyyy");
			String formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(date);
			Label dateLabel = new Label("Due: " + formattedDate);
			
			taskInfo.getChildren().addAll(task,subject,description,dateLabel);
			setGraphic(taskInfo);
		}
	
	}
}
