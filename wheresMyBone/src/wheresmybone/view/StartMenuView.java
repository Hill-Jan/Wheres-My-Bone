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
 * @author tCalder
 */
public class StartMenuView extends View{
    private String promptMessage;

public StartMenuView() {
        super("\n"
                + "\n -------------------------------------------------"
                + "\n    Start Menu                                     "
                + "\n -------------------------------------------------"
                + "\nN - Start New Game"
                + "\nL - Load a Saved Game"
                + "\nE - Exit"
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
            case "E":
                this.exitGame();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Choose a Menu Option");
                break;
        }
        return false;}

    private void startNewGame() {
        //create a new game
        GameControl.createNewGame(WheresMyBone.getPlayer());

        //display the game menu
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }

    private void loadSavedGame() {
       InputView input = new InputView();
        input.loadSavedGame();
    }

    private void exitGame() {
        System.exit(0);
    }
    
    
}
