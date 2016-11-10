/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.view.GameMenuView;

/**
 *
 * @author Jan
 */
public class MainMenuView extends View {
      private String promptMessage;{
        
}
    // private String menu; ??
        public MainMenuView () {
              super   ( "\n"
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
                System.out.println("\n*** Invalid selection *** Choose a Menu Option");
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
        System.out.println("*** loadSavedGame() function called ***");
    }

    private void saveGame() {
        System.out.println("*** saveGame() function called ***");
    }

    private void displayHelpMenu() {
        
        //Create displayHelpMenu object
        HelpMenuView helpMenuView = new HelpMenuView();
                
         // Display the help menu view
        helpMenuView.display();
        
      
        
    }
    }