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
public class EnterGiraffeView extends View {
GameMenuView gameMenu = new GameMenuView();
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
                + "\nR - Return to Game Menu"
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
            // Enter the Vacant House
            this.enterGiraffesView();
            break;
        case "R":
            gameMenu.display();
        default:
            ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
            break;
        }
       return false;
    }

    private void enterGiraffesView(){
        GiraffesView giraffesView = new GiraffesView();
        giraffesView.displayGiraffesView();
    }
    
}