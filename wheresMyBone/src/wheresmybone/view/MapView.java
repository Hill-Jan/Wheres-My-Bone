/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.control.MapControl;
import wheresmybone.model.Game;
import wheresmybone.model.Location;
import wheresmybone.model.Map;

/**
 *
 * @author Jan
 */
 public class MapView extends View {
//private final String map;
private String promptMessage;
public MapView() {
     super("\n"
     + "\n------------------------------------------"
     + "\n Enter your desired location "
     + "\n------------------------------------------");
}
  @Override
  public boolean doAction(String mapOption) {
     mapOption = mapOption.toUpperCase();
     Game game = WheresMyBone.getCurrentGame(); // retreive the game
     Map map = game.getMap(); // retreive the map from game
     Location[][] locations = map.getLocations(); // retreive the locations from map
     for (int row = 0; row < locations.length; row++) {
          for (int column = 0; column < locations[row].length; column++) {
               if (locations[row][column].getScene() != null) {               
                    if (mapOption.equals(locations[row][column].getScene().getMapSymbol())) {
                         MapControl.movePlayer(map, row, column);
                         return true;
                    }
                 }
            }
     }
     ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try Again later");
     return false;
   }
  
}

