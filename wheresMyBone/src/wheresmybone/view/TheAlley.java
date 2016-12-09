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
 * changes to commit
 * @author Jan
 */
public class TheAlley extends View {
    //private String promptMessage;{
//}
GameMenuView gameMenu = new GameMenuView();

    public TheAlley() {
        super("\n*********************************************************"
                + "\n   THE ALLEY  "
                + "\n********************************************************"
                + "\n"
                + "\nAt the far end of town is the industrial district.  There’s several"
                + "\nsmall areas here for things to hide.  One of them is a small, "
                + "\nnarrow alley between two very high buildings.  A few wooden boxes "
                + "\nare at the end of the alley.  Some cat toys lay around the ground."
                + "\n"
                + "\nSlowly you make your way towards the boxes as quietly as you can. "
                + "\nIs DeVil inside?  A noise behind you makes you turn around.  Three "
                + "\nlarge cats are walking threateningly down the alley towards you."
                + "\n"
                + "\n“Well, well, well.  Look what the birds dropped in,” says the large "
                + "\norange one, Tom, to the others."
                + "\n"
                + "\n“What you lookin’ for, mugzie?” Rex, a black cat, asks you."
                + "\n"
                + "\n“Have you seen DeVil?” you ask them, not really expecting an answer."
                + "\n"
                + "\n“Why you wanna know where DeVil is?  You owe him somethin’?” the female"
                + "\n calico asks."
                + "\n"
                + "\n“No.  I think he took something of mine,” you respond trying to be brave."
                + "\n"
                + "\n“Really?” Tom responds.  “What makes you think you’ll get it back?”"
                + "\n"
                + "\nThis isn’t going well.  “Have you seen DeVil?”"
                + "\n"
                +"\n“Maybe,” Kit, the calico, responds.  “Whatcha got to exchange?”"
                + "\n"
                + "\nWhat do you do?"
                + "\n"
                + "\n********************************************************"
                + "\nChoose a menu option:"
                + "\nS - Search your backpack"
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
            case "S":
                this.searchYourBackpack();
                return true;
            case "R":
                gameMenu.display();
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    public void searchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "Cat bell";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            // this.console.println("\nThe Paper is at index " + index + " in the Backpack ArrayList.");
            this.console.println("\nYou find the cat bell toy in your backpack."
                    + "\nYou toss the cat bell down the alley.  All three cats go racing after it!"
                    + "\n“You should try the old house on Main Street,” Kit calls over her shoulder."
                    + "\n“Hush!” Tom chastises her.  “You don’t tell on the boss!”"
                    + "\n"
                    + "\n****************************************************");

        } else {
            this.console.println("\nYou come up empty of anything that would interest the cats.  "
                    + "\nLooks like you’ll have to fight your way out."
                    + "\n"
                    + "\n****************************************************");
        }
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
