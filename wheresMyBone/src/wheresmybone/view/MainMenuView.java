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
                      + "\n --------------------------------------------------");
            
            this.promptMessage = "\nChoose a Menu Option: ";
                    }
                
    /*public void displayMainMenuView() {
        
        boolean done = false; //set flag to not done
        do {
            System.out.println("\n" + this.menu);
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("X")) // user wants to quit
                   break; //exit the game
            //do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
        }
        
BEGIN
 do
 Prompt for and get the input value/s
 if (value == “Q”) then
 exit

 do the action and display the next view
 while the view is not done */
        

   /* private String getMenuOption() {

    getInput(): value
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
 RETURN value 
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

     doAction(choice): void
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