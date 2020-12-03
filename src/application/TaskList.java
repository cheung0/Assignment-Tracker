
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
	
	ListView<Task> lvList;
	ObservableList<Task> items;
	ListView<Task> sourceList;
	int selectedID;
	
	public ListView constructList() {
		lvList = new ListView<Task>();
		items = FXCollections.observableArrayList();
		lvList.setItems(items);
		lvList.setMaxHeight(Control.USE_PREF_SIZE);
		lvList.setEditable(true);
	
		lvList.setCellFactory(new Callback<ListView<Task>, ListCell<Task>>() {
			
			// can place nay Node in Cell graphic property 
			// will be bound to cells item property 
			// implement cellFactory callback function to specialize Cell
						
			@Override 
			public ListCell<Task> call(ListView<Task> list) {
				
				TaskFormatCell taskCell = new TaskFormatCell();
				
				taskCell.setOnDragDetected((MouseEvent event) -> {
					System.out.println("set on drag detected");
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
					System.out.println("set on drag exited");
					});
				
					taskCell.setOnDragOver((DragEvent event) -> {
					Dragboard db = event.getDragboard();
					if( db.hasString()) {
						System.out.println("set on drag over: " + db.hasString());
						event.acceptTransferModes(TransferMode.MOVE);
					}
					event.consume();
					});
					
					taskCell.setOnDragDropped((DragEvent event) -> {
					System.out.println("set on drag dropped");
					Dragboard db = event.getDragboard();
					
					boolean success = false;
					
					if(db.hasString()) {
						System.out.println("dropped " + db.getString());
						System.out.println("dropped " + Task.TASKCLIPBOARD.getName());
						
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























