package iikh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class DataBase {
    String recipeName;
    ArrayList<String> ingredients;
    ArrayList<String> recipe;
    
    private String parsetoString(String recipeName, ArrayList<String> ingredients, ArrayList<String> recipe){
        String out = recipeName + ",,";
        for(String x: ingredients)
            out += (x + "::");
        out += ",,";
        for(String x: recipe)
            out += (x + "::");
        return out;
    }
    public void addRecipe(String recipeName, ArrayList<String> ingredients, ArrayList<String> recipe){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recipe.txt", true)))) {
            out.println(parsetoString(recipeName, ingredients, recipe));  
        }catch (IOException e) {
            e.printStackTrace();
        }
    }  
    public ArrayList<String> getNames(){
        BufferedReader bReader = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            bReader = new BufferedReader(new FileReader("recipe.txt"));
            while ((line = bReader.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    public void getRecipe(String recipeName){
        BufferedReader bReader = null;
        this.recipeName = null;
        this.ingredients = null;
        this.recipe = null;
	try {
            String line;
            bReader = new BufferedReader(new FileReader("recipe.txt"));
            while ((line = bReader.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(recipeName)){
                    this.recipeName = recipeName;
                    this.ingredients = new ArrayList<String>(Arrays.asList(x[1].split("::")));
                    this.recipe = new ArrayList<String>(Arrays.asList(x[2].split("::")));
                }
            }
	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void editRecipe(String oldRecipeName, String newRecipeName, ArrayList<String> ingredients, ArrayList<String> recipe ){
        try {
            FileInputStream fstream = new FileInputStream("recipe.txt");
            BufferedReader bReader = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = bReader.readLine()) != null) {
                // Print the content on the console
              //  System.out.println(strLine);
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                    if (tokens[0].equals(oldRecipeName)) {  
                        System.out.print("here");
                        String newLine = parsetoString(newRecipeName, ingredients, recipe);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("recipe.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeRecipe(String RecipeName ){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("recipe.txt");
            BufferedReader bReader = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = bReader.readLine()) != null) {
                // Print the content on the console
              //  System.out.println(strLine);
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                    if (!tokens[0].equals(RecipeName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("recipe.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public ArrayList<String> getIndegrients(){
        return this.ingredients;
    }
    public ArrayList<String> getMethod(){
        return this.recipe;
    }
}
