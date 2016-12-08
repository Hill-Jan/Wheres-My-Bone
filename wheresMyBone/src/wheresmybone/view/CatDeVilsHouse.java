/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.model.Backpack;
import wheresmybone.model.Item;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Game;

/**
 *changes to commit
 * @author Jan
 */
public class CatDeVilsHouse extends View {
     private String promptMessage;{
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
                    +"\nS - Search your Backpack      X – Leave the area"
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
            case "G":
                this.getCatBell();
                break;
            default:
            ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
            break;
        }
       return false;

}

        public void searchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "collar";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
               this.console.println("You take the collar out of your backpack and "
               + "\nleave it on the back stoop.  DeVil’s owners usually come in "
               + "\nthe back door from the garage.  They’ll see the collar there. "
               + "\nAfter you leave the collar, you turn around and notice a cat "
               + "\nbell on the ground.  Hmmm.  Maybe that will help."
               + "\n"
               + "\nWhat do you do?"
               +"\n********************************************************"  
               +"\n G - Get the Bell             X - Leave the area"
               +"\n*********************************************************");
        }
        else {
            this.console.println("Nothing in here will help you out.");
        }
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
    }
 
        private void getCatBell() {
        Item catbell = new Item("cat bell", "DeVil's House", "The Alley");
        StartProgramView.player.addToBackpack(catbell);
        this.console.println("\n*You quickly snatch up cat bell and put it in your"
                + "\nbackpack.  Never know where this will come in handy.");
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();

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
