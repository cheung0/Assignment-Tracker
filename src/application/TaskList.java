
package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;

public class TaskList {
	
	ListView<String> lvList;
	ObservableList<String> items;
	
	public ListView constructList() {
		lvList = new ListView<String>();
		items = FXCollections.observableArrayList();
		lvList.setItems(items);
		lvList.setMaxHeight(Control.USE_PREF_SIZE);
		
		return lvList;
	}

}
