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
public class ConfirmBox {
	static boolean answer;

	public static boolean display(String title, String message) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(300);

		Label label = new Label(message);
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");

		yesButton.setOnAction(e -> {
			answer = true;
			stage.close();
		});

		noButton.setOnAction(e -> {
			answer = false;
			stage.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);

		Scene scene = new Scene(layout, 200, 200);
		stage.setScene(scene);
		stage.showAndWait();

		return answer;
		
	}
	
}
