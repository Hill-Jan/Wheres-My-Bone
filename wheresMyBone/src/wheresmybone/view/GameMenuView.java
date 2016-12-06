package wheresmybone.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import wheresmybone.WheresMyBone;
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
                + "\nB - Show possible items for Backpack"
                + "\n and print repor to file"
                + "\nN - Show NPC list"
                + "\nT - Check time"
                + "\nM - Show Map"
                + "\nG - Go To New Location"
                + "\nH - Help Menu"
                + "\nL - Display Scene List"
                + "\nJ - Display Map Symbols as a Report"
                + "\nX - Exit Game Menu"
                + "\n --------------------------------------------------"
                + "\n"
                + "\nChoose a Menu Option: ");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); //convert value to upper case

        switch (value) {
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
            case "H": //Help Menu
                this.displayHelpMenu();
                break;
            case "G":
                this.displayGoToNewLocation();
                break;
            case "L":
                this.displaySceneList();
                break;
            case "J": //test vacant house
                this.mapSymbolReport();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Choose a Menu Option");
                break;
        }
        return false;
    }

    /* private void showRoomItems() {
        this.console.println("*** showRoomItems() function called ***");
    }*/
    private void showBackpackItems() {
        StringBuilder line;
        this.console.println("\nEnter the file path for file where the report "
                + "is to be saved.");
        String filePath = this.getInput();

        try {
            saveBackpackListReport(filePath);
        } catch (IOException e) {

        }

        ArrayList<Item> items = Item.createItemList();

        this.console.println("   LIST OF ITEMS IN BACKPACK");
        line = new StringBuilder("          ");
        line.insert(0, "Item");
        this.console.println(line.toString());

        for (Item item : items) {
            this.console.printf("%n%-15s%-25s%-16s", item.getName(), item.getStartScene(), item.getDescription());
        }
        this.console.println("  ");
        this.console.println("  ");
        this.console.println("Your Report Has Saved Successfully.");
    }

    public static void saveBackpackListReport(String filePath)
            throws IOException {

        ArrayList<Item> items = Item.createItemList();

        try (PrintWriter writer = new PrintWriter(filePath)) {

            writer.println("   LIST OF POSSIBLE BACKPACK ITEMS ");
            writer.println("-----------------------------------------------------");
            writer.printf("%n%-10s%-25s%-16s", "    ITEM", "    FROM WHERE", "    TO WHOM");
            writer.printf("%n%-13s%-25s%-16s", "-------------", "-----------------------------", "---------------");
            for (Item item : items) {
                writer.printf("%n%-15s%-25s%-16s", item.getName(), item.getStartScene(), item.getDescription());
            }
            writer.close();

        } catch (Exception ex) {
            ErrorView.display("GameMenuView BackpackListReport", ex.getMessage());
        }

    }

    private void checkTime() {
        double timeLeft = WheresMyBone.getCurrentGame().getTimeLeft();

        this.console.println("\nYou have " + timeLeft + " minutes remaining."
                + "\nDon't let your time run out!");
    }

    private void displayHelpMenu() {
        //Create displayHelpMenu object
        HelpMenuView helpMenuView = new HelpMenuView();

        // Display the help menu view
        helpMenuView.display();
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
            ErrorView.display(this.getClass().getName(), "\nError");
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

    private void enterScene() {
        Game game = WheresMyBone.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        //map.getCurrentLocation().getScene().getView().display();
        View currentView = GetView.getSceneView(map.getCurrentLocation().getScene().getMapSymbol());
        if (currentView != null) {
            currentView.display();
        }
    }

    private void displaySceneList() {
        SceneType[] scenes = SceneType.values();

        for (SceneType sceneNames : scenes) {
            this.console.println(sceneNames.getSceneName());
        }
    }

    private void mapSymbolReport() {
        InputView input = new InputView();
        input.mapSymbolReport();
    }
}
