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
public class GorillaView extends View {
    //private String promptMessage;{
//}
GameMenuView gameMenu = new GameMenuView();

    public GorillaView() {
        super("\n*********************************************************"
                + "\n       GORILLA ENCLOSURE "
                + "\n********************************************************"
                + "\n"
                + "\nM’Linzi the Gorilla sits in one corner of her enclosure trying hard"
                + "\nto ignore the young gorilla with her.  Ivan is just….too much of a "
                + "\nnuisance.  Slowly she peels a banana from a bunch nearby and peels it."
                + "\nShe slips the whole thing in her mouth at once and chews slowly.  Ivan"
                + "\ntries to get her to play, but she just pushes him off."
                + "\n"
                + "\n“Go play with something,” she says."
                + "\n"
                + "\n“With what?” Ivan asks excitedly looking around.  “Come play with me!”"
                + "\n"
                + "\n“Go away, kid!” M’Linzi gowled."
                + "\n"
                + "\n“Hi, M’Linzi,” you greet her from just outside the cage.  “What’s up?”"
                + "\n"
                + "\n“Got anything to get rid of this kid?” M’Linzi asked fertively.  “I "
                + "\nhaven’t been able to sleep for days!  Play, play, play!  That’s all he"
                + "\nwants to do!  Doesn’t even stop to eat!”"
                + "\n“Hmmm.  Let me check.”"
                + "\n"
                + "\nWhat should you do?"
                + "\n"
                + "\n********************************************************"
                + "\nChoose a menu option:"
                + "\nS - Search Your Backpack."
                + "\nR - Return to Game Menu."
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
        return true;

    }


    public void searchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "Ball";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            // this.console.println("\nThe Paper is at index " + index + " in the Backpack ArrayList.");
            this.console.println("\nYou search through your backpack and find the ball "
                    + "\nyou got in the playground.  Maybe that is something that will"
                    + "\nkeep Ivan occupied."
                    + "\n"
                    + "\n“How about this?” you ask showing M’Linzi the ball."
                    + "\n"
                    + "\n“It might work.”"
                    + "\n"
                    +"\nYou squeeze the ball through the bars for the gorilla.  She looks "
                    + "\nat the large red ball."
                    + "\n"
                    + "\n“Hey, Ivan!” she calls the child.  He turns to look at her.  “Here!”  "
                    + "\nWith a quick swing, she tosses the ball to Ivan.  Ivan catches it and"
                    + "\nbegins to bounce and play with it.  He bounces it off the bars and trees,"
                    + "\nthen catches it."
                    + "\n"
                    + "\n“Wow!  Fun!” Ivan calls back."
                    + "\n"
                    + "\n“Thank you so much!” M’Linzi sighs.  “What are you doing around here anyway?"
                    + "\nSurely, you didn’t come all this way to bring me a ball.”"
                    + "\n"
                    + "\n“No.  Actually, I’m looking for DeVil, a black and white cat.  I think he "
                    + "\ntook my bone.”"
                    + "\n"
                    + "\nM’Linzi thinks.  “Hmmm.  I think I saw him going towards the giraffes.  He had"
                    + "\nsomething in his mouth, but I don’t know what.”"
                    + "\n“Thanks, M’Linzi.”"
                    + "\n"
                    + "\n****************************************************");

        } else {
            this.console.println("\n“I’m sorry, M’Linzi.  I don’t.  I’ll keep my eyes peeled for something,"
                    + "\nthough.”"
                    + "\n"
                    + "\n“Thanks.”"
                    + "\n"
                    + "\n“You haven’t seen DeVil, have you?  A large, black and white cat?”"
                    + "\n“Not yet today.  He comes through here sooner or later, though.  I’ll watch "
                    + "\nfor him.”"
                    + "\n"
                    + "\n“Thanks.”"
                    + "\n"
                    + "\n****************************************************");
        }
    }

    private double timeLeft() {
        double travelTime = 0;
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
