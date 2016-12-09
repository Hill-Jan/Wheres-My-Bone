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
public class SchoolEntranceView extends View {
    //private String promptMessage;{
//}

    public SchoolEntranceView() {
        super("\n*********************************************************"
                + "\n    School Entrance  VIEW   "
                + "\n********************************************************"
                + "\n"
                + "\nYou come around the corner to the school entrance."
                + "\nThere are several children nearby playing."
                + "\nYou notice Brad, a lanky 10-year-old from your neighborhood,"
                + "\nfrantically searching for something.  "
                + "\n"
                + "\nWhat should you do?"
                + "\n"
                + "\n********************************************************"
                + "\nChoose a menu option:"
                + "\nT - Talk to Brad."
                + "\nX - Get out Fast!"
                + "\n********************************************************");
        this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "T":
                this.talkToBrad();
                break;

            case "S":
                this.searchYourBackpack();
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    private void talkToBrad() {
        this.promptMessage = ("\n“Hi, " + StartProgramView.player.getName() + ",” Brad says distractedly.  “I can’t play now.”"
                + "\n“What are you looking for?” you ask."
                + "\n“I lost my English paper.  It’s due today.  If I don’t turn it in"
                + "\n on time, I'll get a zero; and I worked on it all night!”"
                + "\n"
                + "\n"
                + "\nWhat will you do?"
                + "\n"
                + "\n***************************************************************"
                + "\nS - Search your Backpack                  X – Leave the Area;"
                + "\n****************************************************************");
    }

    public void searchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "Paper";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            // this.console.println("\nThe Paper is at index " + index + " in the Backpack ArrayList.");
            this.console.println("\nYou remember you put a paper in your backpack "
                    + "\nwhen you were in the school parking lot.  You give Brad the paper."
                    + "\n“Is this it?” you ask."
                    + "\n“What?  Oh, " + StartProgramView.player.getName() + "!  You’re the best!” "
                    + "\nHe's so excited he gives you a hug. "
                    + "\n“By the way,” you gargle out in the voracious hug.  “Have you seen "
                    + "\nDeVil carrying a bone?”"
                    + "\n\"I saw him going through the playground earlier, but he didn't have a bone."
                    + "\n  Good luck!\""
                    + "\n****************************************************"
                    + "\nWhere To Now?"
                    + "\n****************************************************");

        } else {
            this.console.println("\n\"Gee, I’m sorry, Brad.  Good luck finding it.  "
                    + "\nI’ll keep my eyes peeled.”"
                    + "\n\"Thanks, " + StartProgramView.player.getName() + ".”"
                    + "\n“You haven’t seen DeVil, have you?  He might have been carrying a bone?”"
                    + "\n“DeVil with a bone?  Don’t be silly!” Brad chuckles.  "
                    + "\n“Sorry, " + StartProgramView.player.getName() + ".  I need to find my paper before the bell rings.”"
                    + "\n****************************************************"
                    + "\nWhere To Now?  "
                    + "\n****************************************************");
        }
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
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
