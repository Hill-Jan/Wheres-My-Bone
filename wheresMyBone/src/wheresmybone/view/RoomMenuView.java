/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;


/**
 *
 * @author Dan
 */
public class RoomMenuView {
    private String promptMessage;{
}
    private String menu;
        public RoomMenuView() {
            this.menu = "\n==================================================="
                      + "\n(A)ctions - (M)ap - (G)ame Menu - (L)Move locations"
                      + "\n===================================================";
                    
                    
                    
                      


            this.promptMessage = "\nChoose a Menu Option: ";
}
public void displayRoomMenuView() {
        
        boolean done = false; //set flag to not done
        do {
            System.out.println("\n" + this.menu);
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit Actions Menu
                   return; //exit the menu
            //do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
        }

private String getMenuOption() {

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
        return value;       
    }

public boolean doAction (char choice){

    switch (choice) {
        case 'A': // View actions available to you
            this.actionsMenuView();
            break;
        case 'M': // View the map
            this.viewMap();
            break;
        case 'G': // View the game menu
            this.gameMenuView();
            break;
        case 'L': // Move to a different location
            this.moveLocation();
            break;
        default:
            System.out.println("\n*** Invalid selection *** Try again");
            break;
        }
       return false;
       
    }

private void actionsMenuView() {
          //Create MainMenuView object
        ActionsMenuView actionsMenuView = new ActionsMenuView();
                
         // Display the main menu view
        actionsMenuView.displayActionsMenuView();
}
private void viewMap() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function pull up map information"
                          +"\n-------------------------------------------------"
        );
    }

private void gameMenuView() {
        //Create MainMenuView object
        GameMenuView gameMenuView = new GameMenuView();
                
         // Display the main menu view
        gameMenuView.displaygameMenuView();
}


private void moveLocation() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will allow the user to move to"
                          +"\na different available location."
                          +"\n-------------------------------------------------"
        );
    }

    private boolean doAction(String menuOption) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
