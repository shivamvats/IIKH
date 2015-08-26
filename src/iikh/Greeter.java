/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
/**
 *
 * @author aries
 */
public class Greeter extends Application {
	
	Stage window;
	Scene scene1, scene2, scene3, sceneMenu;

	public void guiLaunch(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage)  throws Exception {
		window = primaryStage;
		primaryStage.setTitle("IIKH");
		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			confirmExit();
		});
		Label label1 = new Label("Welcome to IIKH");
		label1.setTextAlignment(TextAlignment.CENTER);

		Button button1 = new Button("Go to Menu");
		button1.setOnAction(e -> primaryStage.setScene(sceneMenu));

		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		layout1.setAlignment(Pos.CENTER);

		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(layout1);

		scene1 = new Scene(borderPane, 300,300);

		// Option menu
		
		Button buttonA = new Button("Add Recipes");
		Button buttonB = new Button("Browse Recipes");
		Button buttonC = new Button("Add Meals");
		Button buttonD = new Button("Browse Meals");
		Button buttonE = new Button("Exit");

		buttonA.setOnAction(e -> window.setScene(sceneAddRecipes()));
		//buttonB.setOnAction(e -> window.setScene(sceneBrowseRecipes()));
		//buttonC.setOnAction(e -> window.setScene(sceneAddMeals()));
		//buttonD.setOnAction(e -> window.setScene(sceneBrowseMeals()));
		buttonE.setOnAction(e -> window.close());
		
		VBox layoutMenu = new VBox();
		layoutMenu.setPadding(new Insets(20, 20, 20, 20));
		layoutMenu.getChildren().addAll(buttonA, buttonB, buttonC, buttonD, buttonE);
		sceneMenu = new Scene(layoutMenu, 300, 300);
		
		primaryStage.setScene(scene1);
		primaryStage.show();

	}

	 private String getChoice(ChoiceBox<String> choiceBox){
		String food = choiceBox.getValue();
		return food;
	    }
	 
	 private Scene sceneAddRecipes() {
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		
		DataBase dB = new DataBase();
		//getItems returns the ObservableList object which you can add items to
		ArrayList<String> ing = new ArrayList<String> ();
		ing.add("sfsd");
		ing.add("ssdfs");
		dB.addRecipe("ALOO", ing, ing);
		ArrayList<String> recipeNames = dB.getNames();

		
		choiceBox.getItems().addAll(recipeNames);

		//Set a default value
		choiceBox.setValue(recipeNames.get(0));

		Button button2 = new Button("Select recipe");
		button2.setOnAction(e -> getChoice(choiceBox));

		Button button3 = new Button("Go back to welcome Screen");
		button3.setOnAction(e -> window.setScene(scene1));
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		
		//Defining the Name text field
		
		final TextField name = new TextField();
		name.setPromptText("Enter recipe");
		name.setPrefColumnCount(10);
		name.getText();
		
		GridPane.setConstraints(name, 0, 0);
		grid.getChildren().add(name);
		
		//Defining the Comment text field
		final TextField comment = new TextField();
		comment.setPrefColumnCount(15);
		comment.setPromptText("Enter the Ingredients");
		GridPane.setConstraints(comment, 0, 2);
		grid.getChildren().add(comment);
		
		final TextField method = new TextField();
		method.setPrefColumnCount(15);
		method.setPromptText("Enter the method");
		GridPane.setConstraints(method, 0, 3);
		grid.getChildren().add(method);
		
		//Defining the Submit button
		Button submit = new Button("Submit");
		GridPane.setConstraints(submit, 0, 10);
		grid.getChildren().add(submit);
		
		//Defining the Clear button
		Button clear = new Button("Clear");
		GridPane.setConstraints(clear, 1, 10);
		grid.getChildren().add(clear);
		
		VBox layout3 = new VBox(10);
		layout3.setPadding(new Insets(20, 20, 20, 20));
		layout3.getChildren().addAll(choiceBox, button2, button3);
		scene3 = new Scene(grid, 300, 300);
		
		return scene3;
	 }
	private void confirmExit() {
		boolean answer = ConfirmBox.display("Exit", "Are you sure, you want to exit");
		if(answer)
			window.close();
	}
}
