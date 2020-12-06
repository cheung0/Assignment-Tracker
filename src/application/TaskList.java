
package application;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.util.Callback;

public class TaskList {
	
	private ListView<Task> lvList;
	private ObservableList<Task> items;
	private ListView<Task> sourceList;
	private int selectedID;
	
	public ListView constructList() {
		lvList = new ListView<Task>();
		
		// sample tasks 
		LocalDate d1 = LocalDate.of(2020, 01, 01);
		LocalDate d2 = LocalDate.of(2020, 03, 01);
		LocalDate d3= LocalDate.of(2020, 02, 01);

		Task t1 = new Task("Task 1", "Lorem Ipsum" , d1);
		Task t2 = new Task("Task 2", "Lorem Ipsum", d2);
		Task t3 = new Task("Task 3", "Lorem Ipsum", d3);
		
		items = FXCollections.observableArrayList(t1,t2,t3);
		lvList.setItems(items);
		lvList.setMaxHeight(Control.USE_PREF_SIZE);
		lvList.setEditable(true);
	
		lvList.setCellFactory(new Callback<ListView<Task>, ListCell<Task>>() {
			// implemented cellFactory callback function to specialize Cell
						
			@Override 
			public ListCell<Task> call(ListView<Task> list) {
				
				TaskFormatCell taskCell = new TaskFormatCell();
				
				taskCell.setOnDragDetected((MouseEvent event) -> {
					Dragboard db = taskCell.startDragAndDrop(TransferMode.MOVE);
				
					String taskName = taskCell.getItem().getName();
					String descriptionName = taskCell.getItem().getDescription();
					LocalDate date = taskCell.getItem().getDate();
					
					Task.TASKCLIPBOARD = new Task(taskName, descriptionName,
							date);
					
					ClipboardContent content  = new ClipboardContent();
					content.putString("string");
					
					db.setContent(content);
					event.consume();
					
					// removes the item from source list 
					selectedID = lvList.getSelectionModel().getSelectedIndex();
					lvList.getItems().remove(selectedID);
				});
					
				taskCell.setOnDragExited((DragEvent event) -> {
					
				});
				
				taskCell.setOnDragOver((DragEvent event) -> {
					Dragboard db = event.getDragboard();
					if( db.hasString()) {
						event.acceptTransferModes(TransferMode.MOVE);
					}
					event.consume();
				});
					
				taskCell.setOnDragDropped((DragEvent event) -> {
					Dragboard db = event.getDragboard();
					
					boolean success = false;
					
					if(db.hasString()) {
						
						// adds item to list
						lvList.getItems().add(Task.TASKCLIPBOARD);
						
						success = true;
					}
					event.setDropCompleted(success);
					event.consume();
				});
					
				return taskCell;
				
				}
			
			});
			
		return lvList;
	}
}























