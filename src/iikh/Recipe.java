/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

import java.util.ArrayList;

/**
 *
 * @author aries
 */
public class Recipe {
	String recipeName;
	ArrayList<String> ingredients;
	ArrayList<String> method;

	public void saveToDB() {
		DataBase dB = new DataBase();
		dB.addRecipe(recipeName, ingredients, method);
	}

	public void editRecipe(String newRecipeName, ArrayList<String> newIngredients, ArrayList<String> newMethod) {
		DataBase dB = new DataBase();
		dB.editRecipe(recipeName, newRecipeName, newIngredients, newMethod);
	}

	public void removeRecipe() {
		DataBase dB = new DataBase();
		dB.removeRecipe(recipeName);
	}
	
}
