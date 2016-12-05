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
 *
 * @author Sexy Mario
 */
public class SchoolParkingLotView extends View {
    //private String promptMessage;{
//}

    public SchoolParkingLotView() {
        super("\n*********************************************************"
                + "\n                 School Parking Lot   "
                + "\n********************************************************"
                + "\n"
                + "\nJust to the north of the playground and building is a large"
                + "\nparking lot.  It’s where the teachers park.  Oddly, the"
                + "\ngate on this side is unattended.  The gate on the street"
                + "\nside, however, has a parking guard.  Mr. Sneed is a nice"
                + "\nman.  He’s tall and broad with black hair, graying a little"
                + "\nat the temples.  His dark eyes are rather mysterious, but "
                + "\nthe ladies in town talk about him a lot!"
                + "\n"
                + "\nYou approach the guard booth carefully.  He looks down at"
                + "\nyou when you sit."
                + "\n"
                + "\nHey, there!  Where’d you come from?”\n" 
                + "\nOver there, you nod."
                + "\n“So, see anything interesting?”" 
                + "\n“Not really.”" 
                + "\n“Man, I wish you had something to eat in that backpack of yours!”"
                + "\nMr. Sneed chuckles. Of course, I don't eat dog food"
                + "\nAs you listen to the man, you notice a piece of paper"
                + "\nup against the fence"
                + "\n********************************************************"
                + "\nS - Search Your Backpack"
                + "\nG - Get Paper"
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
            case "G":
                this.getPaper();
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
        String itemName = "meal";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            this.console.println("\n“You carefully deliver the donuts to Mr."
                                + "\nSneed. What's this? he asks taking the bag"
                                + "\nfrom your teeth. "
                                + "\nTo Derrick, From: Elaina"
                                + "\nhe reads the writing on the bag. He chuckles."
                                + "\nThat sweetheart! She sends me donuts at"
                                + "\nleast once a week. Mmm-mmm. What a treat!"
                                + "\nHe reaches into the bag and pulls out a"
                                + "\nchocolate donut with whit icing. Here, he"
                                + "\nsays splitting it in two. He bites into one"
                                + "\nside and hands the other side to you."
                                + "\nYou deserve a delivery fee."
                                + "\nYou eat the donut gratefully"
                                + "\nThanks, Mr. Sneed. Have you seen DeVil?"
                                + "\nYou ask hopefully. DeVil, Isn't that the"
                                + "\nmean black and white one?"
                                + "\nYes, sir."
                                + "\nI haven't seen him. But I understand that"
                                + "\ncute Dr. Mice at the Animal Hospital was"
                                + "\ntreating a mean black and white cat."
                                + "\nGot her all scratched up, too."
                                + "\nMaybe you should try her."

                    + "\n****************************************************"
                    + "\nG - Get the paper"
                    + "\nX - Leave the Area"
                    + "\n****************************************************");

        } else {
            this.console.println("\nI'm sorry, Mr. Sneed. I don't have any"
                    + "\ngoodies for people."
                    + "\nAh, well. I can wait until lunch. I'm gaining to"
                    + "\nmany pounds anyway. He laughs patting his stomach"
                    + "\nUm, sir? have you seen DeVil?"
                    + "\nDevil, isn't that the mean black and white one?"
                    + "\nNope. Haven't seen him today. Sorry"
                    + "\n****************************************************"
                    + "\nWhere To Now?  "
                    + "\n****************************************************");
        }
    }

    private void getPaper() {
        Item newItem = new Item("paper", "School Entrance", "Brad");
        StartProgramView.player.addToBackpack(newItem);
        this.console.println("You look at the paper on the fence. Hmm."
                + "\nFunny handwriting. Wait. That says Brad on the top."
                + "\nBrad is one of the kids in your neighborhood."
                + "\nHe might need this. Better hang on to it.");
    }
    
}
