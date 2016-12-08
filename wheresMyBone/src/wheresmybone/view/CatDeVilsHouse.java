/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.model.Item;
import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;

/**
 *changes to commit
 * @author Jan
 */
public class CatDeVilsHouse extends View {
     private String promptMessage;
     InputView input = new InputView();
     GameMenuView gameMenu = new GameMenuView();
     {
}
public CatDeVilsHouse() {
            super ("\n*********************************************************"
                    +"\n                   DeVIL'S HOUSE   "
                    +"\n********************************************************"
                    +"\n"
                    +"\nDeVil’s house is a quaint yellow house with a large lawn and "
                    +"\nhigh bushes around the back yard.  At the moment, there doesn’t"
                    +"\nappear to be anyone there.  You go around the back and look in "
                    +"\nthe yard.  Nothing.  Looking in the windows, you still see nothing."
                    +"\n"
                    +"\nWhat do you do?"
                    +"\n********************************************************"
                    +"\nS - Search your Backpack      R - Return to Game Menu"
                    +"\n********************************************************");
            this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
                    }

@Override
public boolean doAction (String value){
        value = value.toUpperCase();

        switch(value){
            case "S":
                this.searchYourBackpack();
                break;
            case "R":
                gameMenu.display();
            default:
            ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
            break;
        }
       return true;

}

        public void searchYourBackpack() {
        input.deVilHouseSearchYourBackpack();
    }
 
    public double timeLeft() {
        double travelTime = 5;
        GameControl calcTimeLeft = new GameControl();
        double timeLeft = 0;
        try {
            timeLeft = calcTimeLeft.calcTimeLeft(travelTime);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
        return timeLeft;
    }    
        
}
