package wheresmybone.view;

import java.util.ArrayList;
import java.util.Scanner;
import wheresmybone.WheresMyBone;
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

    {
    }

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
        ArrayList<Item> items = game.getItems();

        System.out.println("\n       LIST OF ITEMS IN BACKPACK");
        line = new StringBuilder("                            ");
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

          

    

    

        public void viewMap() {
            
        String leftIndicator;
        String rightIndicator;
        Game game = WheresMyBone.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        try {
        this.console.print(" |");    
        for( int column = 0; column < locations[0].length; column++){
        this.console.print(" " + column + " |"); // print col numbers to side of map
        }
        this.console.println();
        for( int row = 0; row < locations.length; row++){
        this.console.print(row + " "); // print row numbers to side of map
        for( int column = 0; column < locations[row].length; column++){
        leftIndicator = " ";
        rightIndicator = " ";
        if(locations[row][column] == map.getCurrentLocation()){
        leftIndicator = "*"; // can be stars or whatever these are indicators showing visited
        rightIndicator = "*"; // same as above
        }
        else if(locations[row][column].isVisited()){
        leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
        rightIndicator = "<"; // same as above
        }
        this.console.print("|"); // start map with a |
        if(locations[row][column].getScene() == null)
        this.console.print(leftIndicator + "??" + rightIndicator);
        else
        this.console.print(leftIndicator + locations[row][column].getScene().getMapSymbol() + rightIndicator);
        }
        this.console.println("|");
        }
        }catch (Exception e) {
        System.out.println("Error");
        }
        }
    }



