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
public class RoomMenuView extends View{
    private String promptMessage;{
}
        public RoomMenuView () {
                super ( "\n==================================================="
                      + "\n(A)ctions - (M)ap - (G)ame Menu - (L)Move locations"
                      + "\n===================================================");
                    
                    
                    
                      


            this.promptMessage = "\nChoose a Menu Option: ";
}
@Override
public boolean doAction (String value){
    value = value.toUpperCase(); //convert value to upper case
    
    switch (value) {
        case "A": // View actions available to you
            this.actionsMenuView();
            break;
        case "M": // View the map
            this.viewMap();
            break;
        case "G": // View the game menu
           /* this.gameMenuView();
            break;*/
            return true;
        case "L": // Move to a different location
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
        actionsMenuView.display();
}
private void viewMap() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function pull up map information"
                          +"\n-------------------------------------------------"
        );
    }

//private void gameMenuView() {
//        //Create MainMenuView object
//        GameMenuView gameMenuView = new GameMenuView();
//                
//         // Display the main menu view
//        gameMenuView.displayGameMenuView();
//}


private void moveLocation() {
        System.out.println("\n-------------------------------------------------"
                          +"\nThis function will allow the user to move to"
                          +"\na different available location."
                          +"\n-------------------------------------------------"
        );
    }

   

    void roomMenuView() {
       
    }
}
