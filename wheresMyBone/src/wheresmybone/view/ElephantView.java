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
public class ElephantView extends View {
    //private String promptMessage;{
//}
GameMenuView gameMenu = new GameMenuView();
    public ElephantView() {
        super("\n*********************************************************"
                + "\n    ELEPHANT ENCLOSURE   "
                + "\n********************************************************"
                + "\n"
                + "\nTwo big gray African elephants were eating on an island surrounded"
                + "\nby a large, deep, waterless moat.  It kept them in their enclosure."
                + "\nThe moat was surrounded by a chain-link fence.  In the back was a stone"
                + "\nwall with a door.  A bridge connects the door to the island so the "
                + "\nelephants can get fed, bathed, and given attention by their keepers."
                + "\n"
                + "\nCarefully you move around the enclosure to the back door.  A keeper "
                + "\ncomes out of the enclosure with a bucket and a rake.  As he moves "
                + "\npast you slide into the enclosure.   You move over the bridge to the"
                + "\nelephants."
                + "\n"
                + "\n“Um, excuse me?” you interrupt the eating elephants."
                + "\n"
                + "\n“Hmm?” one of them acknowledges you.  “What are you doing here?”"
                + "\n"
                + "\n“I’m looking for a cat.”"
                + "\n"
                + "\nThe two elephants laugh.  “There’s no cats here,” the other laughed.  “You want some hay?”"
                + "\n"
                + "\n“You got any peanuts?” the first one asked. \"I'm tired of hay.\""
                + "\n"
                + "\nWhat should you do?"
                + "\n"
                + "\n********************************************************"
                + "\nChoose a menu option:"
                + "\nS - Search Your Backpack."
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
        return true;

    }


    public void searchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "peanuts";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            // this.console.println("\nThe Paper is at index " + index + " in the Backpack ArrayList.");
            this.console.println("\n“Yea, I’ve got peanuts.  Would you like some?” you offer."
                    + "\n"
                    + "\n“Peanuts?” the two elephants looked at you excitedly."
                    + "\n"
                    + "\nYou open the bags and pour them in front of the elephants.  The "
                    + "\nelephants eagerly eat up the peanuts."
                    + "\n"
                    + "\n“Have you seen a cat?”"
                    + "\n"
                    + "\n“What kind of cat?” one of the elephants asks." 
                    + "\n"
                    + "\n“Black and white, medium hair, carrying a bone?”"
                    + "\n"
                    + "\n“Oh, yea!  That one!  He was heading towards the monkeys, but"
                    + "\nI didn’t see a bone.”"
                    + "\n"
                    + "\n“Thanks.”"
                    + "\n"
                    + "\n****************************************************"
                    + "\nWhere To Now?"
                    + "\n****************************************************");

        } else {
            this.console.println("\n“Gee, guys.  I’m sorry.  I don’t.”"
                    + "\n"
                    + "\n“Come back when you’ve got peanuts,” the first elephant replied."
                    + "\n"
                    + "\n“Have you seen DeVil?”"
                    + "\n"
                    + "\n“Peanuts,” the second elephant said returning to his hay."
                    + "\n"
                    + "\n“Hey!”   The Zookeeper comes running across the bridge.  “What"
                    + "\ndo you think you’re doing in here!  Get out!  Out, out, out!” "
                    + "\nhe yells at you swinging a broom."
                    + "\n"
                    + "\nWithout waiting, you run across the bridge and out the back door."
                    + "\n"
                    + "\n****************************************************");
        }
    }

    public double timeLeft() {
        double travelTime = 30;
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