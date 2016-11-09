/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.control.GameControl;
import wheresmybone.model.Player;

/**
 *
 * @author Dan
 */
public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView(){
        
        this.promptMessage = "\nPlease enter your name: ";
        // display the banner when view is created
        this.displayBanner();
        
    }

    private void displayBanner() {
        Welcome.displayBanner();
        System.out.println(
           /* This is for the beginning of the game.
          "\n******************************************************************"
        + "\n*                                                                *"
        + "\n* One day you wake up from a night of bad dreams. Cat DeVil, the *"
        + "\n* mean cat from next door, had been hissing and clawing at you   *"
        + "\n* all night.  Thirsty, you get up to get a drink of water. While *"
        + "\n* you’re at it you decide to take some time for a chew session on *"
        + "\n* your favorite bone. That’s when your real nightmare begins.     *"
        + "\n* The hole you dug for keeping that bone safe IS EMPTY!          *"
        + ""        
           */
                
         "\n*******************************************************************"
        +"\n*                                                                 *"
        +"\n* Welcome Detective Scrappy! You are the son of the famous        *"
        +"\n* Ruff McGruff crime dog who now works with the FBI.              *"
        +"\n* You are top dawg, police dog, of K9 city. Are you ready to take *"
        +"\n* a bite out of crime?                                            *"
        +"\n*                                                                 *"
        +"\n*******************************************************************"        
        );
    }
         /**
         * displays the start program view
         */
    public void displayStartProgramView() {
        /*displayView(): void
        BEGIN
        do
        Prompt for and get the input value
        if (value == “Q”) then
        return

        do requested action and display the next view
        while the view is not done
        END;
        */
       
        
        
        boolean done = false; //setflag to not done
        do {
            //primpt for and get players name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("X")) // user wants to exit
                return; //exit the game
            
            //do the requested action and display the next view
            done = this.doAction(playersName);
            
        } while (!done);
    }
        /*A template for getting user input:
        
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
        END 
        
        */
    private String getPlayersName() {
    
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid){
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            break;
        }
        
        return value;
    }
        /*doAction(playersName): boolean
        BEGIN
        if the length of the playersName < 2 then
        display “Invalid name: The name must be > 1 character”
        return false

        create Player with specified name
        if unsuccessful then
        display “Invalid name: The name is too short”
        return false
    
        display customized welcome message
        display mainMenuView
        return true
        END
*/
    private boolean doAction(String playersName) {
        if (playersName.length() < 2) {
            System.out.println("\nInvalid player's name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) { // if unsuccessful
            System.out.println("\n Error creating the player.");
            return false;
        }
        //display next view
        this.displayNextView(player);
               return true; //success !
    }

    private void displayNextView(Player player) {
        System.out.println("\n==============================================="
                           +"\n Welcome to the game, " + player.getName()
                           +"\n We hope you have a lot of fun!"
                           +"\n=============================================="
                           );
     
        //Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
         // Display the main menu view
        mainMenuView.display();
    }










}
