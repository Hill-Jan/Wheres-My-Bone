/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.model.GameMenuView;

/**
 *
 * @author tCalder
 */
public class HelpMenuView {
      private String promptMessage;{
        
}
    private String menu;
        public HelpMenuView() {
            this.menu = "\n"
                      + "\n -------------------------------------------------"
                      + "\n    Help Menu                                     "
                      + "\n -------------------------------------------------"
                      + "\nP - How to Play"
                      + "\nM - How to Move"
                      + "\nC - Clues"
                      + "\nO - Objects"
                      + "\nH - How to Save/Load Game"
                      + "\nB - Bad Guys"
                      + "\nQ - Quit Help Menu"
                      + "\n --------------------------------------------------";
            
            this.promptMessage = "\nChoose a Menu Option: ";
                    }
                
    public void displayHelpMenuView() {
        System.out.println("\n" + this.menu);
        /*boolean done = false; //set flag to not done
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("X")) // user wants to quit Help Menu
                   return; //exit the menu
            //do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);*/
        }
/*BEGIN
 do
 Prompt for and get the input value/s
 if (value == “X”) then
 exit

 do the action and display the next view
 while the view is not done */

    private String getMenuOption() {

/*    getInput(): value
BEGIN
 WHILE a valid value has not been entered
 DISPLAY a message prompting the user to enter a value
 GET the value entered from keyboard
 Trim front and trailing blanks off of the value
 IF the length of the value is blank THEN
 DISPLAY “Invalid value: The value cannot be blank”
 CONTINUE
 ENDIF
 BREAK
 ENDWHILE
 RETURN value */
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();//removes spaces at front and end
            
            if (value.length() < 1) {
                System.out.println("\n Invalid value: value cannot be blank");
                continue;
            }
            break;
        }
        return value;       }

    /* doAction(choice): void
BEGIN
convert choice to upper case
SWITCH choice
“N”: Start a new game
“G”: Get and start a saved game
“H”: Display the help menu
“S”: Display the save game view
DEFAULT: DISPLAY “Invalid selection”
ENDSWITCH
RETURN false
END */
    
    private boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert choice to upper case
        
        switch (choice) {
            case "P": //How to Play
                this.howPlay();
                break;
            case "M": //How to Move
                this.howMove();
                break;
            case "C": //about Clues
                this.aboutClues();
                break;
            case "O": //about Objects
                this.aboutObjects();
                break;
            case "H": //how to save/load game
                this.howSave();
                break;
            case "B": //about bad guys
                this.aboutBadGuys();
                break;
            case "Q": //quit Help Menu
                this.quitHelp();
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

    private void howPlay() {
        System.out.println("\n*** howPlay() function called ***");
    }

    private void howMove() {
        System.out.println("\n*** howMove() function called ***");
    }

    private void aboutClues() {
        System.out.println("\n*** aboutclues() function called ***");
    }

    private void aboutObjects() {
        System.out.println("\n*** aboutObjects() function called ***");
    }

    private void howSave() {
        System.out.println("\n*** howSave() function called ***");
    }

    private void aboutBadGuys() {
        System.out.println("\n*** aboutBadGuys() function called ***");
    }

    private void quitHelp() {
        //Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
         // Display the main menu view
        mainMenuView.displayMainMenuView();
    }

    
}
