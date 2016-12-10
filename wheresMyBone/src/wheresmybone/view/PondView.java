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
 *
 * @author Jan
 */
public class PondView extends View {
    //private String promptMessage;{
//}
GameMenuView gameMenu = new GameMenuView();
InputView input = new InputView();
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
                + "\nR - Return to Game Menu"
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
                this.drinkWater();
                break;
            case "R":
                gameMenu.display();
            case "P":
                this.playWithRufus();
                break;

            default:
                ErrorView.display(this.getClass().getName(),
                        "\n*** Invalid selection *** Try again");
                break;
        }
        gameMenu.display();
        return true;

    }


    private void drinkWater() {
        input.pondDrinkWater();
        /*Item pebble = new Item("Pebble", "Pond", "Tommyr");
        StartProgramView.player.addToBackpack(pebble);
        this.console.println(" You decline Rufus’ suggestion and take another "
                        + "\ndrink.  As you look into the water you notice a large"
                        + "\n pebble on the bottom.  It’s a beautiful white stone "
                        + "\nwith orange and black stripes running through it."
                        + "\nLiking the way it looks, you put it in your backpack.");
        return;*/
    }

    private void playWithRufus(){
        //add time counter;
        
        input.pondPlayWithRufus();
        /*this.console.println("You and Rufus have a great time bouncing around the"
                        +"\nwater.  He’s great fun to play with.  You lose track of"
                        + "\ntime while you’re playing, eventually joined by a couple"
                        + "\nof other friends.  By the time you realize it, you’ve "
                        + "\nlost 40 minutes playing.  Quickly you tell Rufus you "
                        + "\nneed to leave and head off to your next location.");
        double travelTime = 40;
        GameControl calcTimeLeft = new GameControl();
        double timeLeft = 0;
        
        try {
            timeLeft = calcTimeLeft.calcTimeLeft(travelTime);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        this.console.println("\nYou're down to only " + timeLeft + " minutes"
                            +"\nremaining! Better get a move on it.");
        return;*/
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

