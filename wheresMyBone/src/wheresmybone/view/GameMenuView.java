package wheresmybone.view;

import java.util.Scanner;

/**
 *
 * @author tCalder
 */
public class GameMenuView extends View{
    private String promptMessage;{
}
  
        public GameMenuView() {
                 super ("\n"
                      + "\n -------------------------------------------------"
                      + "\n    Game Menu                                     "
                      + "\n -------------------------------------------------"
                      + "\nI - Show items in room"
                      + "\nB - Show items in backpack"
                      + "\nT - Check time"
                      + "\nS - Save Game"
                      + "\nH - Help Menu"
                      + "\nM - Main Menu"
                      + "\nQ - Quit Game Menu"
                      + "\nJ - Test Vacant House"
                      + "\nG - Test Giraffe Enclosure"
                      + "\nY - Test Your House"
                      + "\nR - Test Room Menu View"
                      + "\n --------------------------------------------------");
            
            this.promptMessage = "\nChoose a Menu Option: ";
}

/* doAction(value): void
BEGIN
    convert value to upper case
    SWITCH value
        “I" - Show items in room
        "B" - Show items in backpack
        "T" - Check time
        "S" - Save Game
        "H" - Help Menu
        "M" - Main Menu
        "Q" - Quit Game Menu
        END SWITCH
    RETURN false
END */
    @Override    
    public boolean doAction(String value) {
    value = value.toUpperCase(); //convert value to upper case
        
        switch (value) {
            case "I": //Show items in room
                this.showRoomItems();
                break;
            case "B": //Show items in backpack
                this.showBackpackItems();
                break;
            case "T": //Check Time
                this.checkTime();
                break;
            case "S": //Save Game
                this.saveGame();
                break;
            case "H": //Help Menu
                this.displayHelpMenu();
                break;
            case "M": //Main Menu
                this.displayMainMenu();
                break;
            case "J": //test vacant house
                this.displayVacantHouseView();
                break;
            case "G": //test giraffe enclosure
                this.displayGiraffesView();
                break;
            case "Y": //test your house
                this.displayYourHouseView();
                break;
            case "R": //test room menu view
                this.displayRoomMenuView ();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Choose a Menu Option");
                break;
        }
    return false;
    }

    private void showRoomItems() {
        System.out.println("*** showRoomItems() function called ***");
    }

    private void showBackpackItems() {
        System.out.println("*** showBackpackItems() function called ***");
    }

    private void checkTime() {
        System.out.println("*** checkTime() function called ***");
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

    private void displayMainMenu() {
        //Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
         // Display the main menu view
        mainMenuView.display();
    }

    private void displayVacantHouseView() {
        //Create displayVacantHouseView object
      VacantHouseView vacantHouseView = new VacantHouseView();
      
      //Display the vacant house view
      vacantHouseView.displayVacantHouseView();
    }
    
    private void displayGiraffesView() {
          //Create displayGiraffesView
        GiraffesView giraffesView = new GiraffesView();
          // Display Giraffes View
        giraffesView.displayGiraffesView();
            }
    private void displayYourHouseView() {
          //Create displayYourHouseView object
        YourHouseView yourHouseView = new YourHouseView();
          //Display the your house view
        yourHouseView.displayYourHouseView();
    }
    
    private void displayRoomMenuView() {
         //Create displayRoomMenuView object
        RoomMenuView roomMenuView = new RoomMenuView();
         //Display the room menu view
        roomMenuView.display();
    }

    }
