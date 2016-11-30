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
    private Double number;

    {
    }

    public RoomMenuView() {
        super("\n==================================================="
                + "\n(1) Actions - (2) Map - (3)Move locations - (X) Exit Room Menu"
                + "\n==================================================="
                + "\nChoose a Menu Option: ");
    }

    @Override
    public boolean doAction(String value) {
        //value = this.getInput();
        value = value.toUpperCase(); //convert value to upper case
        boolean valid = false;
        
        switch (value) {
            case "1": // View actions available to you
                this.actionsMenuView();
                break;
            case "2": // View the map
                this.viewMap();
                break;
            case "3": // Move to a different location
                this.moveLocation();
                break;
            //default:
              //  ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
                //break;
        }
        try{
            number = Double.parseDouble(value);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),"\nYou must enter a valid number."
                        + " Try again or enter X to exit Room Menu.");
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
        View currentView = GetView.getSceneView(map.getCurrentLocation().getScene().getMapSymbol());
        if (currentView != null)
            currentView.display();

    }

    void roomMenuView() {

    }
}
