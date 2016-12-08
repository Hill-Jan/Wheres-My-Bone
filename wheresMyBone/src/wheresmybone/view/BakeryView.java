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
public class BakeryView extends View {
    //private String promptMessage;{
//}

    public BakeryView() {
        super("\n*********************************************************"
                + "\n                 THE BAKERY   "
                + "\n********************************************************"
                + "\n"
                + "\nMrs Jones is a plump lady with a contagious laugh.  She’s"
                + "\nfriendly to everyone, and loves animals.  She greets you "
                + "\nwith a wide grin when you scratch at the back door to her "
                + "\nbakery."
                + "\n“" + StartProgramView.player.getName() + "!  So good to see "
                + "\nyou, my friend!  Would you like a treat?”  She disappears "
                + "\ninside for only a couple of seconds and comes back with a "
                + "\nsmall cupcake piled high with yellow buttercream icing.  "
                + "\n“Here ya go!”"
                + "\nYou catch the cupcake she tosses to you.  Ymm. Filled with "
                + "\nchocolate pudding, too!"
                + "\n“Gee, thanks, Mrs. Jones!” you say licking your lips.  “By "
                + "\nany chance, have you seen DeVil?”"
                + "\n“DeVil?  No.  He doesn’t come around here.  No palette for "
                + "\nsweets, that one.  But Mr. Sneed might have seen him.  He’s "
                + "\nthe guard at the Elementary School Parking Lot, you know.  Oh!"
                + "\nIf you’re going to see him, would you bring him these donuts, "
                + "\nplease?”"
                + "\n"
                + "\n********************************************************"
                + "\nG - Get Donuts"
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
            case "G":
                this.getDonuts();
                break;

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    private void getDonuts() {
        Item donuts = new Item("Donuts", "Animal Hospital", "collar");
        StartProgramView.player.addToBackpack(donuts);
        this.console.println("Sure.  I'd be glad to.");
        /*RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();*/
    }

    private double timeLeft() {
        double travelTime = 25;
        GameControl calcTimeLeft = new GameControl();
        double timeLeft = 0;
        try {
            timeLeft = calcTimeLeft.calcTimeLeft(travelTime);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        return timeLeft;
    }
}
