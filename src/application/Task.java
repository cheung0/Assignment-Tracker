package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Task {
	
	public VBox constructTask() {
		VBox dialogVbox = new VBox(40);
        
        Button button = new Button("Add Task");
        VBox vBox = new VBox();
        
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                new Label("Your Task"),
                new TextField(),
                new Label("Your Due Date"),
                new TextField(),
                button);
        dialogVbox.getChildren().addAll(vBox);

        button.setOnAction(actionEvent-> {
            Stage stage = new Stage();
            StackPane stackPane = new StackPane();
            stage.setScene(new Scene(stackPane, 200,200));
            stage.show();
        });
        
        return dialogVbox;
	}

}
