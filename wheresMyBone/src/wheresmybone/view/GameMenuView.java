package wheresmybone.view;

import java.util.Scanner;

/**
 *
 * @author tCalder
 */
public class GameMenuView {
    private String promptMessage;{
}
    private String menu;
        public GameMenuView() {
            this.menu = "\n"
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
                      + "\n --------------------------------------------------";
            
            this.promptMessage = "\nChoose a Menu Option: ";
}

/*BEGIN
 Do
    Prompt for and get the input value/s
    if (value == “Q”) then
    exit the game menuu

    do the action and display the next view
 WHILE the view is not done */
        
    public void displayGameMenuView() {
        
        boolean done = false; //set flag to not done
        do {
            System.out.println("\n" + this.menu);
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit Game Menu
                return; //exit the menu
            //do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
        }

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
        return value;       
    }
/* doAction(choice): void
BEGIN
    convert choice to upper case
    SWITCH choice
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
    private boolean doAction(String choice) {
    choice = choice.toUpperCase(); //convert choice to upper case
        
        switch (choice) {
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
        helpMenuView.displayHelpMenuView();
    }

    private void displayMainMenu() {
        //Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
         // Display the main menu view
        mainMenuView.displayMainMenuView();
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
        roomMenuView.displayRoomMenuView();
    }

    }
