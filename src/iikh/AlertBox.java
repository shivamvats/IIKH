/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author aries
 */
public class AlertBox {
	public static void display(String title, String message) {
		Stage alertWindow = new Stage();

		alertWindow.initModality(Modality.APPLICATION_MODAL);
		alertWindow.setTitle(title);
		alertWindow.setMinWidth(300);
		
		Label label = new Label(message);

		Button button = new Button("Close");
		button.setOnAction(e -> alertWindow.close());

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);

		
		Scene scene = new Scene(layout);
		alertWindow.setScene(scene);
		alertWindow.showAndWait();

	}	
}
