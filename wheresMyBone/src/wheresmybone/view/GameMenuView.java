package wheresmybone.view;

import java.util.ArrayList;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.control.MapControl.SceneType;
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
    private SceneType mapSymbol;

    public GameMenuView() {
        super("\n"
                + "\n -------------------------------------------------"
                + "\n    Game Menu                                     "
                + "\n -------------------------------------------------"
                + "\nI - Show items in room"
                + "\nB - Show items in backpack"
                + "\nN - Show NPC list"
                + "\nT - Check time"
                + "\nM - Show Map"
                + "\nG - Go To New Location"
                + "\nS - Save Game"
                + "\nH - Help Menu"
                + "\nL - Display Scene List"
                //+ "\nJ - Test Vacant House"
               // + "\nGE - Test Giraffe Enclosure"
                + "\nY - Test Your House"
                /*+ "\nR - Test Room Menu View"
                + "\nV - Test VacantHouseSceneView"*/
                + "\nC - Test Cafeteria View Test"
                /*+ "\nZ - Test Zoo Entrance View"*/
                //+ "\nE - Test School Entrance View"
                + "\nX - Exit Game Menu"
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
    public boolean doAction(String value)  {
        value = value.toUpperCase(); //convert value to upper case

        switch (value) {
            case "I": //Show items in room
                this.showRoomItems();
                break;
            case "B": //Show items in backpack
                this.showBackpackItems();
                break;
            case "N": //Show NPC list
                //this.showNpcList();
                this.showNpcSort();
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
            case "G":
                this.displayGoToNewLocation();
               break;
            case "L":
                this.displaySceneList();
                break;
            //case "J": //test vacant house
                //this.displayVacantHouseView();
                //break;
            //case "GE": 
                //test giraffe enclosure
              //  this.displayGiraffesView();
                //break;
            case "Y": 
                //test your house
                this.displayYourHouseView();
                break;
            /*case "R": //test room menu view
                this.displayRoomMenuView();
                break;
            case "V": //test VacantHouseSceneView
                this.displayVacantHouseSceneView();
                break;*/
            case "C": //test CafeteriaViewTestw
                this.displayCafeteriaViewTest();
                break;
            case "Z": //test ZooEntranceView
                this.displayZooEntranceView();
                break;
            //case "E"://test School entrance View
              //  this.displaySchoolEntranceView();
                //break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Choose a Menu Option");
                break;
        }
        return false;
    }

    private void showRoomItems() {
        this.console.println("*** showRoomItems() function called ***");
    }

    private void showBackpackItems() {
        StringBuilder line;

        Game game = WheresMyBone.getCurrentGame();
        ArrayList<Item> items = GameControl.createItemList();

        this.console.println("\n       LIST OF ITEMS IN BACKPACK");
        line = new StringBuilder("          ");
        line.insert(0, "Item");
        this.console.println(line.toString());

        for (Item item : items) {
            this.console.println(item.getName());
        }
    }

    private void checkTime() {
        this.console.println("*** checkTime() function called ***");
    }

    private void saveGame() {
        this.console.println("*** saveGame() function called ***");
    }

    private void displayHelpMenu() {
        //Create displayHelpMenu object
        HelpMenuView helpMenuView = new HelpMenuView();

        // Display the help menu view
        helpMenuView.display();
    }

    private void displayYourHouseView() {
        //Create displayYourHouseView object
        YourHouseView yourHouseView = new YourHouseView();
        //Display the your house view
        yourHouseView.displayYourHouseView();
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

        //Console console = System.console(); Displays Map
        String leftIndicator;
        String rightIndicator;
        Game game = WheresMyBone.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        try {
            this.console.print("  |");
            for (int column = 0; column < locations[0].length; column++) {
                this.console.print("  " + column + " |"); // print col numbers to side of map
            }
            this.console.println();
            for (int row = 0; row < locations[0].length; row++) {
                this.console.print(row + " "); // print row numbers to side of map
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
                    this.console.print("|"); // start map with a |
                    if (locations[row][column].getScene() == null) {
                        this.console.print(leftIndicator + "??" + rightIndicator);
                    } else {
                        this.console.print(leftIndicator + locations[row][column].getScene().getMapSymbol() + rightIndicator);

                    }
                }

                this.console.println("|");

            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"\nError");
        }
        this.console.println("Your current location is " + map.getCurrentLocation().getScene().getSceneName());
    }

    public void showNpcSort() {
      NpcSort npcSort = new NpcSort();
      npcSort.display();
        
    }

    private void displayGoToNewLocation() {
        viewMap();
        MapView mapView = new MapView();
        mapView.display();
        enterScene();
        viewMap();
        
    }
    
    private void enterScene(){
        Game game = WheresMyBone.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        //map.getCurrentLocation().getScene().getView().display();
        View currentView = GetView.getSceneView(map.getCurrentLocation().getScene().getMapSymbol());
        if (currentView != null)
            currentView.display();
    }

    private void displaySceneList() {
        SceneType[] scenes = SceneType.values();
        
        for (SceneType sceneNames : scenes) {
            this.console.println(sceneNames.getSceneName());
        }
    }

    }