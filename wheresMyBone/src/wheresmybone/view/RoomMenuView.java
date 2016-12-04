/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

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
                + "\n(A) Actions - (M) Map - (X) Exit Room Menu"
                + "\n==================================================="
                + "\nChoose a Menu Option: ");
    }

    @Override
    public boolean doAction(String value) {
        //value = this.getInput();
        value = value.toUpperCase(); //convert value to upper case
        boolean valid = false;
        
        switch (value) {
            case "A": // View actions available to you
                this.actionsMenuView();
                break;
            case "M": // View the map
                this.viewMap();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
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

    void roomMenuView() {

    }
}
