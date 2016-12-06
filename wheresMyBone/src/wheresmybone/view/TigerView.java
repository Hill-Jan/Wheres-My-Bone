/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;

/**
 * changes to commit
 * @author Jan
 */
public class TigerView extends View {
    //private String promptMessage;{
//}

    public TigerView() {
        super("\n*********************************************************"
                + "\n             TIGER VIEW   "
                + "\n********************************************************"
                + "\n"
                + "\nThe tiger enclosure is large and roomy with rocks and grass."
                + "\nThere’s a small pond in the middle of it for the cats to wade"
                + "\nin.  Two tigers, Tarak and Tufan, are lazing around."
                + "\n"
                + "\n“Psst!  Hey, guys!” you call from the wall."
                + "\n"
                + "\n“Hey!” Tufan greets you,  “What’s up,"+ StartProgramView.player.getName() + "?”"
                +"\n"
                + "\n“Got any fish?  I need a snack,” Tarak says." 
                + "\nWhat do you do?"
                + "\n"
                + "\n********************************************************"
                + "\nChoose a menu option:"
                + "\nS - Search your Backpack"
                + "\nX - Leave the Area!"
                + "\n********************************************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "S":
                this.searchYourBackpack();
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    public void searchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "fish";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            // this.console.println("\nThe Paper is at index " + index + " in the Backpack ArrayList.");
            this.console.println("\n“Yea, I’ve got some fish.  It’s not much, though.”  You throw"
                    + "\nthe fish into the enclosure.  Both cats quickly pounce on one"
                    + "\nand devour it quickly."
                    + "\n"
                    + "\n“That was an awesome fish, pal!” Tarak compliments licking his lips."
                    + "\n"
                    + "\n“Absolutely,” Tufan agrees.  “So, what did you want?”"
                    + "\n"
                    + "\n“Have you seen DeVil?”"
                    + "\n"
                    + "\n“Hmmm,” the two cats look at each other."
                    + "\n“I think I saw him heading towards the big gray monsters over there.”"
                    + "\n"
                    + "\n“Thanks.”"
                    + "\n"
                    + "\n****************************************************"
                    + "\nWhere To Now?"
                    + "\n****************************************************");

        } else {
            this.console.println("\n“Sorry.  I don’t have any fish.  Have you seen DeVil?”"
                    + "\n“DeVil?” the cats ask each other.  “No, we haven’t seen him.  Does he taste good?”"
                    + "\n“I don’t think so.  Thanks.”"
                    + "\n"
                    + "\n****************************************************"
                    + "\nWhere To Now?  "
                    + "\n****************************************************");
        }
    }}