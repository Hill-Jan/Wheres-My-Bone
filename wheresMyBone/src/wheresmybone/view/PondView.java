/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wheresmybone.view;

import java.io.Serializable;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;

/**
 *
 * @author Jan
 */
public class PondView extends View {
    //private String promptMessage;{
//}

    public PondView() {
        super("\n*********************************************************"
                + "\n                 THE Pond   "
                + "\n********************************************************"
                + "\n"
                + "\nA large pond sits on one side of the city.  Many animals come"
                + "\nto drink or play in it.  Some of the citizens swim in it during"
                + "\nthe summer.  Since you’ve had such a hard day, you stop to take"
                + "\na drink.  Another dog from the town, Rufus, bounces past you in"
                + "\nthe shallow water with a laugh."
                + "\n“Ha, ha!  Come on, " + StartProgramView.player.getName() + "!  Let’s play!”"
                + "\n********************************************************"
                + "\nWhat Do You Do?"
                + "\nP – Play with Rufus"
                + "\nW – Take a Drink of Water "
                + "\nX - Leave the Area!"
                + "\n********************************************************");
        this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "W":
                this.getItem();
                break;
                
            case "P":
                this.playWithRufus();
                break;

            default:
                ErrorView.display(this.getClass().getName(),
                        "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }


    private void getItem() {
        Item newItem = new Item("Pebble", "Pond", "Tommyr");
        StartProgramView.player.addToBackpack(newItem);
        this.console.println(" You decline Rufus’ suggestion and take another "
                        + "\ndrink.  As you look into the water you notice a large"
                        + "\n pebble on the bottom.  It’s a beautiful white stone "
                        + "\nwith orange and black stripes running through it."
                        + "\nLiking the way it looks, you put it in your backpack.");
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
    }

    private void playWithRufus(){
        //add time counter;
        this.console.println("You and Rufus have a great time bouncing around the"
                        +"\nwater.  He’s great fun to play with.  You lose track of"
                        + "\ntime while you’re playing, eventually joined by a couple"
                        + "\nof other friends.  By the time you realize it, you’ve "
                        + "\nlost 40 minutes playing.  Quickly you tell Rufus you "
                        + "\nneed to leave and head off to your next location.");
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
    }

    private double timeLeft() {
        double travelTime = 15;
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

