/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.Scanner;
import wheresmybone.WheresMyBone;
import wheresmybone.model.Game;
import wheresmybone.model.Location;
import wheresmybone.model.Map;

/**
 *
 * @author Dan
 */
public class RoomMenuView extends View {

    private String promptMessage;

    {
    }

    public RoomMenuView() {
        super("\n==================================================="
                + "\n(1) Actions - (2) Map - (3) Exit Room - (4) Move locations"
                + "\n==================================================="
                + "\nChoose a Menu Option: ");
    }

    @Override
    public boolean doAction(String value) {
        value = this.getInput();
        value = value.toUpperCase(); //convert value to upper case

        switch (value) {
            case "1": // View actions available to you
                this.actionsMenuView();
                break;
            case "2": // View the map
                this.viewMap();
                break;
            case "4": // Move to a different location
                this.moveLocation();
                break;
            case "3": //exit menu
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
//Displays the map

    public void viewMap() {

        //Console console = System.console(); Displays Map
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
                    if (locations[row][column].getScene() == null) {
                        System.out.print(leftIndicator + "??" + rightIndicator);
                    } else {
                        System.out.print(leftIndicator + locations[row][column].getScene().getMapSymbol() + rightIndicator);

                    }
                }

                System.out.println("|");

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        System.out.println("Your current location is " + map.getCurrentLocation().getScene().getSceneName());
    }

    private void moveLocation() {
        viewMap();
        MapView mapView = new MapView();
        mapView.display();
        enterScene();
        viewMap();
    }

    private void enterScene() {
        Game game = WheresMyBone.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        map.getCurrentLocation().getScene().getView().display();

    }

    void roomMenuView() {

    }
}
