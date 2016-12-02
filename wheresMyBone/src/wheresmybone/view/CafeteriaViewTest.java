/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.model.Backpack;
import wheresmybone.model.Item;

/**
 *
 * @author Jan
 */
public class CafeteriaViewTest extends View{
     private String promptMessage;{
}
public CafeteriaViewTest() {
            super ("\n*********************************************************"
                    +"\n    CAFETERIA  VIEW   "
                    +"\n********************************************************"
                    +"\n"
                    +"\nYou round the school building to the south.  There’s an"
                    +"\nopen air cafeteria here.  Part of the room is outside. "
                    +"\nThere’s a cashier getting things ready nearby.  It looks"
                    +"\nas if some children have already been here.  As you nose "
                    +"\naround the room, you find a couple bags of peanuts on the"
                    +"\nfloor beneath a table.  You look up and see that the "
                    +"\ncashier is still busy."
                    +"\n"
                    +"\n********************************************************"
                    +"\n"
                    +"\nWhat do you do?"
                    +"\n"
                    +"\n********************************************************"
                    +"\n"
                    +"\nG – Get the peanuts      X – Leave the room fast"
                    +"\n********************************************************");
                    }

@Override
public boolean doAction (String value){
        value = value.toUpperCase();

        switch(value){
            case "G":
                this.getPeanuts();
                break;
            
            case"X":
                this.console.println("\n***this calls the map function***");
                break;
            default:
            ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
            break;
        }
       return false;

}

    private void getPeanuts() {
        Item peanuts = new Item("peanuts", "School Cafeteria", "salty peanuts");
        StartProgramView.player.addToBackpack(peanuts);
        this.console.println("\n*You quickly snatch up the peanuts and run from the room "
                           + "\nbefore anyone can catch you there.  You know they’d chase "
                           +"\nyou out of the building.  Stopping at the edge of the yard,"
                           +"\nyou quickly put the peanuts in your backpack.");
    }


}

