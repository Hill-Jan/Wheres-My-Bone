package wheresmybone.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;
import static java.lang.System.console;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.model.Game;
import wheresmybone.model.Item;
import wheresmybone.model.Location;
import wheresmybone.model.Map;

/**
 *
 * @author tCalder
 */
public class GameMenuView extends View {

    private String promptMessage;
    //Console console;

    public GameMenuView() {
        super("\n"
                + "\n -------------------------------------------------"
                + "\n    Game Menu                                     "
                + "\n -------------------------------------------------"
                + "\nI - Show items in room"
                + "\nB - Show items in backpack"
                + "\nT - Check time"
                + "\nM - Show Map"
                + "\nS - Save Game"
                + "\nH - Help Menu"
                + "\nJ - Test Vacant House"
                + "\nG - Test Giraffe Enclosure"
                + "\nY - Test Your House"
                + "\nR - Test Room Menu View"
                + "\nV - Test VacantHouseSceneView"
                + "\nC - Test Cafeteria View Test"
                + "\nZ - Test Zoo Entrance View"
                + "\nX - Exit to Main Menu"
                + "\n --------------------------------------------------"
                + "\n"
                + "\nChoose a Menu Option: ");
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
            case "M": //Show Map
                this.viewMap();
                break;
            case "S": //Save Game
                this.saveGame();
                break;
            case "H": //Help Menu
                this.displayHelpMenu();
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
                this.displayRoomMenuView();
                break;
            case "V": //test VacantHouseSceneView
                this.displayVacantHouseSceneView();
                break;
            case "C": //test CafeteriaViewTestw
                this.displayCafeteriaViewTest();
                break;
            case "Z": //test ZooEntranceView
                this.displayZooEntranceView();
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
        StringBuilder line;

        Game game = WheresMyBone.getCurrentGame();
        ArrayList<Item> items = GameControl.createItemList();

        System.out.println("\n       LIST OF ITEMS IN BACKPACK");
        line = new StringBuilder("          ");
        line.insert(0, "Item");
        System.out.println(line.toString());

        //for each inventory item
        for (Item item : items) {
            line = new StringBuilder("                        ");
            line.insert(0, item.getName());

            System.out.println(line.toString());
        }
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

    private void displayVacantHouseSceneView() {
        //create displayVacantHouseSceneView object
        VacantHouseSceneView vacantHouseSceneView = new VacantHouseSceneView();
        //Display the vacant house scene view
        vacantHouseSceneView.display();
    }

    private void displayCafeteriaViewTest() {
        //Create displayRoomMenuView object
        CafeteriaViewTest cafeteriaViewTest = new CafeteriaViewTest();
        //Display the room menu view
        cafeteriaViewTest.display();
    }

    private void displayZooEntranceView() {
        //Create displayZooEntranceView object
        ZooEntranceView zooEntranceView = new ZooEntranceView();
        //Display the zoo entrance view
        zooEntranceView.display();
    }
//Displays the map
    public void viewMap() {
/*BEGIN
 get the 2-D locations array in the map in the current game
 PRINT the title
 PRINT the column numbers in the header
 FOR every row in map
 PRINT a row divider
 PRINT the row number on a new line
 FOR every column in row
 PRINT a column divider
 location = locations[row][column]
 IF location has been visited
 PRINT the mapSymbol in the scene in this location
 ELSE
 DISPLAY " ?? "
 ENDIF
 PRINT the ending column divider
 ENDFOR
 PRINT ending row divider
END*/
        //Console console = System.console();
        String leftIndicator;
        String rightIndicator;
        Game game = WheresMyBone.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        try {
            System.out.print("  |");
            for (int column = 0; column < locations[0].length; column++) {
                System.out.print("  " + column + " |"); // print col numbers to side of map
            }
            System.out.println();
            for (int row = 0; row < locations[0].length; row++) {
                System.out.print(row + " "); // print row numbers to side of map
                for (int column = 0; column < locations[row].length; column++) {
                    leftIndicator = " ";
                    rightIndicator = " ";
                    if (locations[row][column] == map.getCurrentLocation()) {
                        leftIndicator = "*"; // can be stars or whatever these are indicators showing visited
                        rightIndicator = "*"; // same as above
                    } else if (locations[row][column].isVisited()) {
                        leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                        rightIndicator = "<"; // same as above
                    }
                    System.out.print("|"); // start map with a |
                    if (locations[row][column].getSceneName() == null) {
                        System.out.print(leftIndicator + "??" + rightIndicator);
                    } else {
                        System.out.print(leftIndicator + locations[row][column].getSceneName().getMapSymbol() + rightIndicator);

                    }
                }
                System.out.println("|");
 
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
   System.out.println("Your current location is " + map.getCurrentLocation().getSceneName());
    }
}
