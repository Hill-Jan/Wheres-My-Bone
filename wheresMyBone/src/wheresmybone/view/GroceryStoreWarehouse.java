/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Item;
/**
 * changes to commit
 * @author Jan
 */
public class GroceryStoreWarehouse extends View {
     //private String promptMessage;{
    
public GroceryStoreWarehouse(){
            super ("\n*********************************************************"
                    +"\n        GROCERY STORE WAREHOUSE   "
                    +"\n********************************************************"
                    +"\n"
                    +"\nAnother location in the industrial section of town is the "
                    +"\nGrocery Store Warehouse.  They have all kinds of huge boxes"
                    +"\ninside with loud metal beasts that move the boxes around on"
                    +"\nbig wooden boards.  This place is usually busy all day and "
                    +"\nall night.   As you peer into the open warehouse door, you "
                    +"\ndon’t see anywhere that DeVil would go.  It was too busy, too"
                    +"\nnoisy, and overcrowded even for that cat."
                    +"\n"
                    +"\nOne of the workers races past you with a trash bag.  A business"
                    +"\ncard falls out of it onto the ground next to you.  Roger "
                    +"\nCleary, Furnace Repair and Replacement.  888-555-1212.   Could "
                    +"\nthat be of help?"
                    +"\n"
                    +"\n********************************************************"
                    +"\n"
                    +"\nWhat do you do?"
                    +"\n"
                    +"\n********************************************************"
                    +"\n"
                    +"\nG – Get the card      X – Leave the room fast"
                    +"\n********************************************************");
        this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
                    }

@Override
public boolean doAction (String value){
        value = value.toUpperCase();

        switch(value){
            case "G":
                this.getcard();
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

    private void getcard() {
        Item card = new Item("Business Card", "Warehouse", "Smiths");
        StartProgramView.player.addToBackpack(card);
        this.console.println("\n*You pick up the card and put it in your backpack."
                + "\n"
                + "\nWhere to now?");
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
    }

    private double timeLeft() {
        double travelTime = 25;
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