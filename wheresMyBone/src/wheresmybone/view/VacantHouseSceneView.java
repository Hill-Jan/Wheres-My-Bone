/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.exceptions.CalculationControlException;
import wheresmybone.model.Game;
import wheresmybone.model.Map;
import static wheresmybone.view.MapSymbolSceneName.viewMap;

/**
 *
 * @author tCalder
 */
public class VacantHouseSceneView extends View {
      private String promptMessage;{
        
}
public VacantHouseSceneView() {
            super("\n"
                + "\n---------------------------------------------"
                + "\nVacant House"
                + "\n---------------------------------------------"
                + "\nYou come upon the old house that's up for"
                + "\nsale. It's beat up with windows broken, but"
                + "\nthat won't stop Cat DeVil. In the kitchen you"
                + "\nfind a box. Looking inside the box may give"
                + "\na clue, but first you must decide if the box"
                + "\nis even big enough for DeVil to hide in."
                + "\n---------------------------------------------"
                + "\n"
                + "\nChoose a Menu Option: "
                + "\n"
                + "\nE - Enter the Vacant House"
                + "\nM - Make another move"
                + "\nX - Exit to Game Menu"
                + "\n----------------------------------------------"
                + "\n");
    }

@Override
public boolean doAction (String value){
    value = value.toUpperCase(); //convert value to upper case
    
    switch (value) {
        case "E": 
            // Enter the Vacant House
            this.enterVacantHouse();
            break;
        case "M": // Make another move
            this.displayGoToNewLocation();
            break;
        default:
            System.out.println("\n*** Invalid selection *** Try again");
            break;
        }
       return false;
       
    }

    private void enterVacantHouse() {
        VacantHouseView vacantHouseView = new VacantHouseView();
        vacantHouseView.displayVacantHouseView();
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
        map.getCurrentLocation().getScene().getView().display();
   
}
}