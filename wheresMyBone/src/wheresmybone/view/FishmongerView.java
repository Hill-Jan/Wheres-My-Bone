package wheresmybone.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;

/**
 *
 * @author Sexy Mario
 */
public class FishmongerView extends View {

    private String promptMessage;
    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();

    public FishmongerView() {
        super("\n"
                + "\n---------------------------------------------"
                + "\nFishmonger"
                + "\n---------------------------------------------"
                + "\nThe jog to the Fishmonger stand is a long one. It's on the"
                + "\noutskirts of town near a fishing stream. Mr. Catch runs"
                + "\na clean business. Unfortunately, there's also lots of cats"
                + "\nthat hang around his stand. Many of them hiss and swipe"
                + "\nat you as you pass by."
                + "\n"
                + "\nyou eventually get to the stand iteslf. Mr. Catch has four"
                + "\ndifferent types of fish, cleaned and ready, on display"
                + "\ndisplay in the refrigerator section of the stand. The cats?"
                + "\nare meowing all around him looking for handouts. Mr.Catch"
                + "\nis ignoring them and cleaning another fish from his bucket"
                + "\n"
                + "\nUm, Mr Catch? you ask."
                + "\n"
                + "\nThe short man with the long beard and ponytail looks over"
                + "\nthe counter at you. Ah," + StartProgramView.player.getName() + "!"
                + "\nHow are you? What brings you out this way? I don't usually"
                + "\nsee you around here."
                + "\nUm, well, I was wondering if you saw DeVil today? you tell"
                + "\nhim carefully, well aware that some of the cats around"
                + "\nthe stands are DeVil's lackies."
                + "\nDevil? No, I haven't seen him today, but i'm sure he'll be"
                + "\nhere. He usually comes in the evening. Should I tell him"
                + "\nyou're looking for him?"
                + "\nPlease, you respond. I... have business with him"
                + "\nAlright, Mr. Catch laughs. What business you have with"
                + "\nthat cat is your own business. Hope you come out of it."
                + "\nHey, would you do me a favor?"
                + "\nSure, you reply."
                + "\nI need to get this bag of fish over to the zoo for the"
                + "\ntigers. Can you deliver it for me? My delivery guy is"
                + "\nout sick today and I don't dare leave the stand with all"
                + "\nthese cats around. They'll eat me out of all my profits!"
                + "\nYou chuckle as you tell Mr. Catch. Sure, no problem."
                + "What do you do?"
                + "\n*****************************************************************"
                + "\nG – Get the fish    X – Leave the area"
                + "\n******************************************************************");
        this.console.println("\n*******************************"
                           + "\nTime Left: " + timeLeft()
                           + "\n*******************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); 

        switch (value) {
            case "G":
                this.getFish();
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
        String itemName = "fish";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            this.console.println("\nYou chuckle as you tell Mr. Catch. Sure, no problem.");

        } else {
            this.console.println("\n“I'm sorry Mr. Catch I need to find my bone”");
        }
    }

    private void getFish() {
        Item newItem = new Item("fish", "Fishmonger", "Tigers");
        StartProgramView.player.addToBackpack(newItem);
        this.console.println("You chuckle as you tell Mr. Catch. Sure, no problem.");
        RoomMenuView roomMenuView = new RoomMenuView();
             roomMenuView.display();
                    
    }
    /*private void getFish() {
    this.console.println("\nYou take the fish and gently put it into your"
    + "\nbackpack. Knowing full well you don't want the tigers"
    + "\nblaming you for a bruised and mushy fish."
    + "\n"
    + "\nYou could go check out the alley and see if DeVil is there"
    + "\nbut you feel you should probably get this fish to the"
    + "\ntigers before it starts to turn bad."
    + "\nWhere to next?");
    this.console.println("\n*** puts the fish in your backpack");
    }*/

    private double timeLeft() {
       double travelTime = 35;
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
