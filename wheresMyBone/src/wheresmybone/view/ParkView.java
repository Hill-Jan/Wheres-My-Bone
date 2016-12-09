/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wheresmybone.view;

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
public class ParkView extends View {
    //private String promptMessage;{
//}
    GameMenuView gameMenu = new GameMenuView();
    InputView input = new InputView();

    public ParkView() {
            super("\n*********************************************************"
                + "\n    THE PARK   "
                + "\n********************************************************"
                + "\n"
                + "\nYou decide to check out the park.  As you follow the nice, "
				+ "\ntree-lined path, you hear the voices of the children playing."
				+ "\nThere’s an old couple sitting on a park bench feeding the "
				+ "\npidgeons.  A bit further down, you spot Tommy.  Tommy is a fun"
				+ "\n12-year-old with dark hair and kind green eyes.  Maybe he’s "
				+ "\nseen DeVil."
				+"\n"
				+"\nYou approach Tommy with a wag of your tail."
				+"\n“Hi, " + StartProgramView.player.getName()+ "!  How’s your day?” "
				+"\nhe asks with a pet on your head.  Ahhh!  “I was just looking for "
				+"\nnew pebbles for my collection. Hey look!”  Tommy pick up a "
				+"\ngood-sized stick from the ground.  “Wanna play fetch?”  He throws"
				+"\nthe stick.  “Go get it!"
                + "\n"
                + "\n********************************************************"
                + "\nChoose a menu option:"
                + "\nF - Fetch the Stick."
                + "\nS - Search your Backpack"
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
            case "F":
                this.fetchTheStick();
                break;
            case "S":
                this.searchYourBackpack();
                return true;
            case "R":
                gameMenu.display();
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        gameMenu.display();
        return false;

    }

    private void fetchTheStick() {
        input.parkFetch();
    }

    public void searchYourBackpack() {
        input.parkSearchYourBackpack();
    }

    private double timeLeft() {
        double travelTime = 20;
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
