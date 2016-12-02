/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;

/**
 *
 * @author Jan
 */
public class MainMenuView extends View {

    private String promptMessage;

    // private String menu; ??
    public MainMenuView() {
        super("\n"
                + "\n -------------------------------------------------"
                + "\n    Main Menu                                     "
                + "\n -------------------------------------------------"
                + "\nN - Start New Game"
                + "\nL - Load a Saved Game"
                + "\nS - Save Game"
                + "\nH - Get Help"
                + "\nX - Exit Game"
                + "\n --------------------------------------------------"
                + "\nChoose a Menu Option: ");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); //convert choice to upper case

        switch (value) {
            case "N": //create and start a new game
                this.startNewGame();
                break;
            case "L": //load a saved game
                this.loadSavedGame();
                break;
            case "S": //save game
                this.saveGame();
                break;
            case "H": //display help menu
                this.displayHelpMenu();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Choose a Menu Option");
                break;
        }
        return false;

    }

    /* startNewGame(): void
BEGIN
Create a new Game
Create a new Game Menu View
Display the Game Menu
END */
    private void startNewGame() {
        //create a new game
        GameControl.createNewGame(WheresMyBone.getPlayer());

        //display the game menu
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();

    }

    private void loadSavedGame() {
        this.console.println("\n\nEnter the file path for the file where the game is saved.\n");
        
        String filePath = this.getInput();
        
        try{
            // start a saved game
            GameControl.loadSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        //display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void saveGame() {
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

    private void displayHelpMenu() {

        //Create displayHelpMenu object
        HelpMenuView helpMenuView = new HelpMenuView();

        // Display the help menu view
        helpMenuView.display();

    }
}
