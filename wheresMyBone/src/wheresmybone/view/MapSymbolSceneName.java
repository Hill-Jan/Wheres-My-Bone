/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.control.MapControl;
import wheresmybone.control.MapControl.SceneType;
import wheresmybone.model.Game;
import wheresmybone.model.Location;
import wheresmybone.model.Map;

/**
 *
 * @author tCalder
 */
public class MapSymbolSceneName extends View {

public MapSymbolSceneName() {
    super ("\n*****************************************************************"
         + "\n    Find out where each Map Symbol will take you     "
         + "\n"
         + "\nTo see what location the map symbol will take you to, input the"
         + "\nmap symbol from the map above."
         + "\n"
         + "\n    Or choose (H) to return to Help Menu      "
         + "\n"
         + "\n*****************************************************************"
    ); 
    System.out.println("\n");
    viewMap();
    System.out.println("\n");
    
}
      
@Override
public boolean doAction(String value){
 
    value = value.toUpperCase();
    
    switch(value){
        case "PK":
            System.out.println("\n" + SceneType.park.getSceneName());
            break;
        case "VH":
            System.out.println("\n" + SceneType.vacanthouse.getSceneName());
            break;
        case "PS":
            System.out.println("\n" + SceneType.police.getSceneName());
            break;
        case "AH":
            System.out.println("\n" + SceneType.animalhospital.getSceneName());
            break;
        case "PD":
            System.out.println("\n" + SceneType.pound.getSceneName());
            break;
        case "BK":
            System.out.println("\n" + SceneType.bakery.getSceneName());
            break;
        case "RS":
            System.out.println("\n" + SceneType.restaurant.getSceneName());
            break;
        case "DI":
            System.out.println("\n" + SceneType.drivein.getSceneName());
            break;
        case "PN":
            System.out.println("\n" + SceneType.pond.getSceneName());
            break;
        case "AL":
            System.out.println("\n" + SceneType.alley.getSceneName());
            break;
        case "CH":
            System.out.println("\n" + SceneType.carehome.getSceneName());
            break;
        case "NH":
            System.out.println("\n" + SceneType.neighborshouse.getSceneName());
            break;
        case "YH":
            System.out.println("\n" + SceneType.yourhouse.getSceneName());
            break;
        case "DH":
            System.out.println("\n" + SceneType.devilshouse.getSceneName());
            break;
        case "GH":
            System.out.println("\n" + SceneType.grocerywarehouse.getSceneName());
            break;
        case "ZO":
            System.out.println("\n" + SceneType.zoo.getSceneName());
            break;
        case "EL":
            System.out.println("\n" + SceneType.elephants.getSceneName());
            break;
        case "TG":
            System.out.println("\n" + SceneType.tigers.getSceneName());
            break;
        case "KG":
            System.out.println("\n" + SceneType.kangaroos.getSceneName());
            break;
        case "GF":
            System.out.println("\n" + SceneType.giraffes.getSceneName());
            break;
        case "SE":
            System.out.println("\n" + SceneType.schoolentrance.getSceneName());
            break;
        case "SC":
            System.out.println("\n" + SceneType.schoolcafeteria.getSceneName());
            break;
        case "SP":
            System.out.println("\n" + SceneType.schoolplayground.getSceneName());
            break;
        case "SL":
            System.out.println("\n" + SceneType.schoolparkinglot.getSceneName());
            break;
        case "FM":
            System.out.println("\n" + SceneType.fishmonger.getSceneName());
            break;
        case "H":
           return true;
        default:
            System.out.println("\n*** Invalid selection *** Choose a Map Symbol");
            break;
    }
        return false;
}

public static void viewMap() {

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

}
}
