
package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Cell;
import javafx.scene.control.Control;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
				return new TaskFormatCell();
			}
			
			// Drag & Drop 
			
//			ListCell<Task> cell = new ListCell<Task>() {
//				@Override
//				protected void updateItem(Task item, boolean empty) {
//				
//				}
//			};
//				
//				cell.setOnDragDetected((MouseEvent event) -> {
//					System.out.println("set on drag detected");
//					Dragboard db = cell.startDragAndDrop(TransferMode.MOVE);
//					
//					
//					ClipboardContent content  = new ClipboardContent();
//					//content.putString(cell.getItem());
//					db.setContent(content);
//					event.consume();
//					
//					// removes the item from source list 
//					selectedID = lvList.getSelectionModel().getSelectedIndex();
//					lvList.getItems().remove(selectedID);
//				});
//				
//				cell.setOnDragExited((DragEvent event) -> {
//					System.out.println("set on drag exited");
//				});
//				
//				cell.setOnDragOver((DragEvent event) -> {
//					Dragboard db = event.getDragboard();
//					if(db.hasString() ) {
//						event.acceptTransferModes(TransferMode.MOVE);
//					}
//					event.consume();
//				});
//				
//				cell.setOnDragDropped((DragEvent event) -> {
//					System.out.println("set on drag dropped");
//					Dragboard db = event.getDragboard();
//					boolean success = false;
//					if(db.hasString()) {
//						System.out.println("dropped " + db.getString());
//						
//						// adds item to list 
//						//lvList.getItems().add(db.getString());
//					
//						success = true;
//					}
//					event.setDropCompleted(success);
//					event.consume();
//				});
//				
//				return cell;
//			}
			
	});
		
		return lvList;
	}
}





















