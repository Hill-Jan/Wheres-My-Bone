/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

/**
 *
 * @author tCalder
 */
public class VacantHouseSceneView extends View {
      private String promptMessage;{
      
}
      GameMenuView gameMenu = new GameMenuView();
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
                + "\nR - Return to Game Menu"
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
        case "R":
            gameMenu.display();
        default:
            ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
            break;
        }
    gameMenu.display();
       return false;
       
    }

    private void enterVacantHouse() {
        VacantHouseView vacantHouseView = new VacantHouseView();
        vacantHouseView.displayVacantHouseView();
    }

}