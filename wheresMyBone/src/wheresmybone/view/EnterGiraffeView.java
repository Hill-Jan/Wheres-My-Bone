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
public class EnterGiraffeView extends View {

    public EnterGiraffeView() {
         super("\n"
                + "\n---------------------------------------------"
                + "\nGiraffe Enclosure at the Zoo"
                + "\n---------------------------------------------"
                + "\nYou have arrived at a very large and deep\n" 
                + "\nenclosure in the zoo.  Tan and brown heads\n" 
                + "\nlook down at you from over the fence.\n"
                + "\n---------------------------------------------"
                + "\n"
                + "\nWhat do you want to do? "
                + "\n"
                + "\nE - Enter the Giraffe Enclosure"
                + "\nM - Make another move"
                + "\n----------------------------------------------"
                + "\n");
    }

    public EnterGiraffeView(String message) {
        super(message);
    }

    @Override
    public boolean doAction(String value) {
       value = value.toUpperCase(); //convert value to upper case
    
    switch (value) {
        case "E": 
       {
           try {
               // Enter the Vacant House
               this.enterGiraffesView();
           } catch (CalculationControlException ex) {
            System.out.println(ex.getMessage());
        } 
        finally {RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();}
       }
        
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

    private void enterGiraffesView() throws CalculationControlException {
        GiraffesView giraffesView = new GiraffesView();
        giraffesView.displayGiraffesView();
    }

    private void displayGoToNewLocation() {
       viewMap();
        MapView mapView = new MapView();
        mapView.display();
        enterScene();
        viewMap();
    }
    
    private void enterScene(){
        Game game = WheresMyBone.getCurrentGame();
        Map map = game.getMap();
        map.getCurrentLocation().getScene().getView().display();
    }
    
}