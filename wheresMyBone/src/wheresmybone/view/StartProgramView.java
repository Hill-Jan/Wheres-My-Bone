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
import wheresmybone.model.Player;

/**
 *
 * @author Dan
 */
public class StartProgramView {
    
    private String promptMessage;
    public static Player player;
    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();
    
    
    public StartProgramView(){
        
        this.promptMessage = "\nPlease enter your name: ";
        // display the banner when view is created
        this.displayBanner();
        
    }

    private void displayBanner() {
        Welcome.displayBanner();
        this.console.println(    
         "\n*******************************************************************"
        +"\n*                                                                 *"
        +"\n* Welcome, Detective! You are the child of the famous        *"
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

    private String getPlayersName() {
    
        String value = "";
        boolean valid = false;
        
    try {
        while (!valid){
            this.console.println("\n" + this.promptMessage);
            
                value = keyboard.readLine();
            
            value = value.trim();
            
            if (value.length() < 1) {
                ErrorView.display(this.getClass().getName(),"\nInvalid value: value cannot be blank");
                continue;
            }
            break;
        }
        } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"\nError reading input: " + ex.getMessage());
            }
        return value;
    }

    private boolean doAction(String playersName) {
        if (playersName.length() < 2) {
            ErrorView.display(this.getClass().getName(),"\nInvalid player's name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        
        // call createPlayer() control function
        player = GameControl.createPlayer(playersName);
        
        if (player == null) { // if unsuccessful
            ErrorView.display(this.getClass().getName(),"\n Error creating the player.");
            return false;
        }
        //display next view
        this.displayNextView(player);
               return true; //success !
    }

    private void displayNextView(Player player) {
        this.console.println("\n==============================================="
                           +"\n Welcome to the game, " + player.getName()
                           +"\n We hope you have a lot of fun!"
                           +"\n=============================================="
                           +"\n************************************************************"
                     + "\n                                                                 "
                     + "\nOne day you wake up from a night of bad dreams. Cat DeVil, the  "
                     + "\nmean cat from next door, had been hissing and clawing at you    "
                     + "\nall night.  Thirsty, you get up to get a drink of water. While  "
                     + "\nyou’re at it you decide to take some time for a chew session on  "
                     + "\nyour favorite bone. That’s when your real nightmare begins.      "
                     + "\nThe hole you dug for keeping that bone safe IS EMPTY!           "
                     + "\n"
                     + "\n******************************************************************"       
                     + "\n");
     
        //Create MainMenuView object
        StartMenuView startMenu = new StartMenuView();
        startMenu.display();
    }










}
