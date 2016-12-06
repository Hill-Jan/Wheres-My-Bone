/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.control.MapControl;

/**
 *
 * @author tCalder
 */
public class InputView {

    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();

    public InputView() {
    }
    
    public String getInput() {

        String value = null;
        boolean valid = false;

        try {
                value = this.keyboard.readLine();
                value = value.trim();//removes spaces at front and end

                if (value.length() < 1) {
                    ErrorView.display(this.getClass().getName(),"\n Invalid value: value cannot be blank");
                }
            
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(),"\nError reading input: " + ex.getMessage());
        }
        return value;

    }

    public void mapSymbolReport() {
        //prompt for and get the name of the file to save the game in
        this.console.println("\nEnter the file path for file where the report "
                + "is to be saved.");
        String filePath = this.getInput();

        try {
            // save the game to the speciried file
            saveMapSymbolReport(filePath);
            this.console.println("\n\nReport Saved Successfully!\n");
        } catch (Exception ex) {
            ErrorView.display("GameMenuView MapSymbolReport", ex.getMessage());
        }
    }
    
    public static void saveMapSymbolReport(String filePath)
            throws IOException {

        try (PrintWriter writer = new PrintWriter(filePath)) {
            //ObjectOutputStream output = new ObjectOutputStream(fops);
            writer.println("\n\n      Scenes & Symbols Report      ");
            writer.printf("%n%-25s%10s%10s", "Scene Name", "  Map Symbol  ", "  Map Location  ");
            writer.printf("%n%-25s%10s%10s", "----------", "------------  ", "  --------------");
            for (MapControl.SceneType st : MapControl.SceneType.values()) {
                writer.printf("%n%-25s%7s%15d", st.getSceneName(), st.getMapSymbol(), st.ordinal());
            }

        } catch (Exception e) {
            ErrorView.display("GameMenuView-saveMapSymbolReport-", e.getMessage());
        }

    }
    public void saveGame() {
        //prompt for and get the name of the file to save the game in
        this.console.println("\nEnter the file path for file where the game "
                            +"is to be saved.");
        String filePath = this.getInput();
        
        try {
         // save the game to the speciried file
         GameControl.saveGame(WheresMyBone.getCurrentGame(), filePath);
         this.console.println("\nGame Saved Successfully!\n");
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
    public void loadSavedGame() {
        this.console.println("\n\nEnter the file path for the file where the game is saved.\n");
        
        String filePath = this.getInput();
        
        try{
            // start a saved game
            GameControl.loadSavedGame(filePath);
            //display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

}