/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;

/**
 *
 * @author Jan
 */
public class MainMenuView {
      private String promptMessage;{
      
        
}
    private String menu;
        public MainMenuView() {
            this.menu = "\n"
                      + "\n -------------------------------------------------"
                      + "\n    Main Menu                                     "
                      + "\n -------------------------------------------------"
                      + "\nN - Start New Game"
                      + "\nL - Load a Saved Game"
                      + "\nS - Save Game"
                      + "\nH - Get Help"
                      + "\nX - Exit Game"
                      + "\n --------------------------------------------------";
            
            this.promptMessage = "\nChoose a Menu Option: ";
                    }
                
    public void displayMainMenuView() {
        boolean done = false; //set flag to not done
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("X")) // user wants to quit
                   return; //exit the game
            //do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
        }
/*BEGIN
 do
 Prompt for and get the input value/s
 if (value == “Q”) then
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
            System.out.println("\n" + this.menu);
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

    private boolean doAction(String menuOption) {
        System.out.println("\n*** doAction() function called ***");
        return true;
    }
        
    }
   