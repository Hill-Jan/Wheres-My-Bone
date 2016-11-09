/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;


/**
 *
 * Jan Hill
 */
public class ActionsMenuView extends View {
      private String promptMessage;{
        
}
  
        public ActionsMenuView() {
                 super ("\n"
                      + "\n -------------------------------------------------"
                      + "\n    Actions Menu                                     "
                      + "\n -------------------------------------------------"
                      + "\nS - Search (Let's the player search the area.)"
                      + "\nD - Dig. (Player can dig around the area for items.)"
                      + "\nT - Talk (Allows the player to talk to the person in the area.)"
                      + "\nP - Pick up an Item"
                      + "\nB - Put Item in Backpack"
                      + "\nR - Drop the Item"
                      + "\nI - Inventory (Displays what is in your Backpack)"
                      + "\nG - Give an Item from your Backpack to the Character in the Area."
                      + "\nN - Go to a New location."
                      + "\nQ - Quit Actions Menu"
                      + "\n --------------------------------------------------");
            
            this.promptMessage = "\nChoose a Menu Option: ";
                    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); //convert value to upper case
        
        switch (value) {
            case "S": //How to Move
                this.actionSearch();
                break;
            case "D": //about Clues
                this.actionDig();
                break;
            case "T": //about Objects
                this.actionTalk();
                break;
            case "P": //about bad guys
                this.actionPickUp();
                break;
            case "B": //how to save/load game
                this.actionBackpack();
                break;
             case "R": //how to save/load game
                this.actionDrop();
                break;               
            case "I": //how to save/load game
                this.actionInventory();
                break;
            case "G": //how to save/load game
                this.actionGiveItem();
                break;          
            case "N": //how to save/load game
                this.actionMapLocation();
                break;    
            case "Q": //quit Actions Menu
                this.quitActions();
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

    private void actionSearch() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will call another function to give"
                          +"\n more detailed information about the area."
                          +"\n-------------------------------------------------"
        );
    }

    private void actionDig() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will call another function to give"
                          +"\n more detailed information about the area."
                          +"\n-------------------------------------------------"
        );
    }

    private void actionTalk() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will call another function to give"
                          +"\n more detailed information from the npc in the area."
                          +"\n-------------------------------------------------"
        );
    }

    private void actionPickUp() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will allow the player to pick up"
                          +"\n an item in the area."
                          +"\n-------------------------------------------------"
        );
    }

    private void actionBackpack() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will allow the player to put an"
                          +"\n item into Inventory in the Backpack."
                          +"\n-------------------------------------------------"
        );
    }
    
    private void actionDrop() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will allow the player to drop"
                          +"\n an item in the area."
                          +"\n-------------------------------------------------"
        );
    }
    
     private void actionInventory() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will allow the player to see what"
                          +"\n items are in his/her backpack."
                          +"\n-------------------------------------------------"
        );
    }   
    
     private void actionGiveItem() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will allow the player to give"
                          +"\n an item to an npc in the area."
                          +"\n-------------------------------------------------"
        );
    }   
 
    private void actionMapLocation() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will allow the player to move"
                          +"\n to another Map Location."
                          +"\n-------------------------------------------------"
        );
    }   
    private void quitActions() {
        //Create MainMenuView object
        return;
    }

    
}
