/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.ArrayList;
import wheresmybone.WheresMyBone;
import wheresmybone.model.Game;
import wheresmybone.model.Item;
import wheresmybone.model.Location;
import wheresmybone.model.Map;

/**
 *
 * Jan Hill
 */
public class ActionsMenuView extends View {

    private String promptMessage;

    {

    }

    public ActionsMenuView() {
        super("\n"
                + "\n -------------------------------------------------"
                + "\n    Actions Menu                                     "
                + "\n -------------------------------------------------"
                + "\nV - View Inventory"
                + "\nX - Exit Actions Menu"
                + "\n --------------------------------------------------"
                + "\nChoose a Menu Option: "
                + "\n");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); //convert value to upper case

        switch (value) {
            case "V":// View what's in your backpack
                this.actionViewInventory();
                break;
            case "N": //Go to a new Nocation
                this.actionMapLocation();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Choose a Menu Option");
                break;
        }
        return false;

    }

    private void actionViewInventory() {
        StringBuilder line;

        Game game = WheresMyBone.getCurrentGame();
        ArrayList<Item> items = StartProgramView.player.getBackpack().items;

        this.console.println("\n       LIST OF ITEMS IN BACKPACK");
        line = new StringBuilder("          ");
        line.insert(0, "Item");
        this.console.println(line.toString());

        for (Item item : items) {
            this.console.println(item.getName());
        }
    }

    private void actionMapLocation() {
        viewMap();
        MapView mapView = new MapView();
        mapView.display();
        enterScene();
        viewMap();
    }

    private void enterScene() {
        Game game = WheresMyBone.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        View currentView = GetView.getSceneView(map.getCurrentLocation().getScene().getMapSymbol());
        if (currentView != null) {
            currentView.display();
        }
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
            this.console.println(e.getMessage());
        }
    }
}
