/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wheresmybone.view;

import java.io.Serializable;
import wheresmybone.WheresMyBone;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;

/**
 *
 * @author Jan
 */
public class NeighborsHouseView extends View {
    //private String promptMessage;{
//}

    public NeighborsHouseView() {
        super("\n*********************************************************"
                + "\n                 YOUR NEIGHBORS' HOUSE   "
                + "\n********************************************************"
                + "\n"
                + "\nAs you’re passing through the neighborhood, you see Mr. & Mrs."
                + "\nSmith out in their driveway.  They’re pulling some bags from "
                + "\ntheir car."
                + "\n“If it isn’t one thing, it’s another!” Mr. Smith complained.  "
                + "\n“What do we do now?”"
                + "\n“You’ll have to call the repairman,” Mrs. Smith replied."
                + "\n“Which one?  Who repairs furnaces in this town?”"
                + "\n“Look it up in the phone book, dear,” Mrs. Smith sighed."
                + "\n"
                + "\n Do you know how to help the Smiths?"
                + "\n********************************************************"
                + "\nS - Search Your Backpack"
                + "\nX - Leave the Area!"
                + "\n********************************************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "S":
                this.searchYourBackpack();
                break;

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }
    public void searchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "paper";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            this.console.println("\nYou found the business card in your backpack."
                        + "\nQuickly you run over and give it to Mr. Smith."
                        + "\n“What’s this, (name)?” he asks looking at the card.  "
                        + "\nHis face lights up when he reads it.  “Thanks, pal!  "
                        + "\nYou’re a life saver!  Honey, look what (name) gave me!"
                        + "\nIt’s the business card for the Furnace Repair guy in town.”"
                        + "\n“Mr. Smith?”"
                        + "\n“Yes?”" 
                        + "\n“Have you seen DeVil?”"
                        + "\n“DeVil!  Last time I saw him he was heading towards the Zoo. "
                        + "\nI’d go the other way if I were you.”"
                        + "\n“Thanks!”"
                        + "\n****************************************************"
                        + "\nWhere To Now?"
                        + "\n****************************************************");

        }
        else {
	            this.console.println("\nYou don't have anything that can help Mr. Smith.”"
                    + "\n****************************************************"
                    + "\nWhere To Now?  "
                    + "\n****************************************************");
         
            }
    }

}
