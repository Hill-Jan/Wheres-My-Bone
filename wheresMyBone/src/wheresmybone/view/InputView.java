/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import wheresmybone.WheresMyBone;
import wheresmybone.control.GameControl;
import wheresmybone.control.MapControl;
import wheresmybone.exceptions.GameControlException;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;

/**
 *
 * @author tCalder
 */
public class InputView {

    protected final BufferedReader keyboard = WheresMyBone.getInFile();
    protected final PrintWriter console = WheresMyBone.getOutFile();

    public InputView() {
    }
    GameMenuView gameMenu = new GameMenuView();

    public String getInput() {

        String value = null;
        boolean valid = false;

        try {
            value = this.keyboard.readLine();
            value = value.trim();//removes spaces at front and end

            if (value.length() < 1) {
                ErrorView.display(this.getClass().getName(), "\n Invalid value: value cannot be blank");
            }

        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "\nError reading input: " + ex.getMessage());
        }
        return value;

    }

    public void mapSymbolReport() {
        //prompt for and get the name of the file to save the game in
        this.console.println("\nEnter the file path for file where the report "
                + "is to be saved.");
        String filePath = this.getInput();

        try {
            // save the game to the speciried file
            saveMapSymbolReport(filePath);
            this.console.println("\n\nReport Saved Successfully!\n");
        } catch (Exception ex) {
            ErrorView.display("GameMenuView MapSymbolReport", ex.getMessage());
        }
    }

    public static void saveMapSymbolReport(String filePath)
            throws IOException {

        try (PrintWriter writer = new PrintWriter(filePath)) {
            //ObjectOutputStream output = new ObjectOutputStream(fops);
            writer.println("\n\n      Scenes & Symbols Report      ");
            writer.printf("%n%-25s%10s%10s", "Scene Name", "  Map Symbol  ", "  Map Location  ");
            writer.printf("%n%-25s%10s%10s", "----------", "------------  ", "  --------------");
            for (MapControl.SceneType st : MapControl.SceneType.values()) {
                writer.printf("%n%-25s%7s%15d", st.getSceneName(), st.getMapSymbol(), st.ordinal());
            }

        } catch (Exception e) {
            ErrorView.display("GameMenuView-saveMapSymbolReport-", e.getMessage());
        }

    }

    public void saveGame() {
        //prompt for and get the name of the file to save the game in
        this.console.println("\nEnter the file path for file where the game "
                + "is to be saved.");
        String filePath = this.getInput();

        try {
            // save the game to the speciried file
            GameControl.saveGame(WheresMyBone.getCurrentGame(), filePath);
            this.console.println("\nGame Saved Successfully!\n");
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    public void loadSavedGame() {
        this.console.println("\n\nEnter the file path for the file where the game is saved.\n");

        String filePath = this.getInput();

        try {
            // start a saved game
            GameControl.loadSavedGame(filePath);
            //display the game menu
            gameMenu.display();
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    public void schoolPlaygroundGetTheBall() {
        Item ball = new Item("Ball", "School Playground", "Gorillas");
        StartProgramView.player.addToBackpack(ball);
        this.console.println("You added the ball to your backpack.");
    }

    public void careHomeSearchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "Meal";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            this.console.println("\n“Yes, actually.  Mr. Stealletti sent you a meal"
                    + "\nfor your birthday.  Happy Birthday!” "
                    + "\n“Why, thank you!  Oh, he’s so sweet!  And it’s my favorite!”"
                    + "\n“You wouldn’t happened to have seen DeVil have you?”"
                    + "\n“DeVil.  DeVil,” the old woman murmured while she thought."
                    + "\n“Oh, yes!  He was nuzzling around the Gardenias in the garden "
                    + "\nthis morning.  Don’t know where he went after that.”"
                    + "\n"
                    + "\n“Thank you, Miss Ellie. I think I'll go search the garden.”"
                    + "\nover there."
                    + "\n"
                    + "\nAs you head over near the gardenias, your nose starts to twitch."
                    + "\nWhat's that you smell?");
            this.console.println("\nSearch the Garden?"
                    + "\n Y - Yes"
                    + "\n N - No");

            String choice = this.getInput();
            choice = choice.toUpperCase();

            switch (choice) {
                case "Y":
                    careHomeSearchTheGarden();
                    break;
                case "N":
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Choose a Menu Option");
                    break;
            }
        } else {
            this.console.println("\n“Gee, I’m sorry, Miss Ellie.  I don’t have anything for you to eat.”");
        }
    }

    public void careHomeSearchTheGarden() {
        Item bone = new Item("bone", "Garden", "me!");
        StartProgramView.player.addToBackpack(bone);
        this.console.println("You search through the gardens carefully.  Wait!"
                + "\nWhat's that?  It smells familiar.  There!  Under the "
                + "\nGardenias!  It's My Bone!");
        WinView.displayBanner();
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    }

    public String exitGame() {
        this.console.println("Exit without saving? All game progress will be lost."
                + "\nY for yes. S to save.");
        String value = this.getInput();
        value.toUpperCase();
        /*if (value == "Y"){
            System.exit(0);
        }
        if (value == "S"){
            saveGame();
        } 
        else this.console.println("You will be returned to the Main Menu.");*/
        return value;
    }

    public void deVilHouseSearchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "collar";
        Item item = backpack.GiveItem(itemName);

        if (item != null) {
            this.console.println("You take the collar out of your backpack and "
                    + "\nleave it on the back stoop.  DeVil’s owners usually come in "
                    + "\nthe back door from the garage.  They’ll see the collar there. "
                    + "\nAfter you leave the collar, you turn around and notice a cat "
                    + "\nbell on the ground.  Hmmm.  Maybe that will help."
                    + "\n"
                    + "\nWhat do you do?"
                    + "\n********************************************************"
                    + "\n G - Get the Bell             R - Return to Game Menu"
                    + "\n*********************************************************");

            String choice = this.getInput();
            choice = choice.toUpperCase();

            switch (choice) {
                case "G":
                    getCatBell();
                case "R":
                    gameMenu.display();
                default:
                    ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Choose a Menu Option");
                    break;
            }
        } else {
            this.console.println("Nothing in here will help you out.");
        }
    }

    public void getCatBell() {
        Item catbell = new Item("cat bell", "DeVil's House", "The Alley");
        StartProgramView.player.addToBackpack(catbell);
        this.console.println("\n*You quickly snatch up cat bell and put it in your"
                + "\nbackpack.  Never know where this will come in handy.");

    }

    public void pondPlayWithRufus() {
        //add time counter;
        this.console.println("You and Rufus have a great time bouncing around the"
                + "\nwater.  He’s great fun to play with.  You lose track of"
                + "\ntime while you’re playing, eventually joined by a couple"
                + "\nof other friends.  By the time you realize it, you’ve "
                + "\nlost 40 minutes playing.  Quickly you tell Rufus you "
                + "\nneed to leave and head off to your next location.");
        double travelTime = 40;
        GameControl calcTimeLeft = new GameControl();
        double timeLeft = 0;

        try {
            timeLeft = calcTimeLeft.calcTimeLeft(travelTime);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        this.console.println("\nYou're down to only " + timeLeft + " minutes"
                + "\nremaining! Better get a move on it."
                + "\nWhat Do You Do?"
                + "\nP – Play with Rufus some more...because you're a dog"
                + "\nW – Take a Drink of Water "
                + "\nR - Return to Game Menu"
                + "\n********************************************************");
        String choice = this.getInput();
        choice = choice.toUpperCase();

        switch (choice) {
            case "P":
                pondPlayWithRufus();
                break;
            case "W":
                pondDrinkWater();
            case "R":
                gameMenu.display();
        }
    }

    public void pondDrinkWater() {
        Item pebble = new Item("Pebble", "Pond", "Tommyr");
        StartProgramView.player.addToBackpack(pebble);
        this.console.println(" You decline Rufus’ suggestion and take another "
                + "\ndrink.  As you look into the water you notice a large"
                + "\n pebble on the bottom.  It’s a beautiful white stone "
                + "\nwith orange and black stripes running through it."
                + "\nLiking the way it looks, you put it in your backpack."
                + "\nWhat Do You Do Now?\n"
                + "\nP - Play with Rufus some more"
                + "\nW – Take another Drink of Water"
                + "\nR - Return to Game Menu"
                + "\n********************************************************\n");
        String choice = this.getInput();
        choice = choice.toUpperCase();

        switch (choice) {
            case "P":
                pondPlayWithRufus();
                break;
            case "W":
                pondDrinkWater();
            case "R":
                gameMenu.display();
        }
    }

    public void schoolTalkToBrad() {
        this.console.println("\n“Hi, " + StartProgramView.player.getName() + ",” Brad says distractedly.  “I can’t play now.”"
                + "\n“What are you looking for?” you ask."
                + "\n“I lost my English paper.  It’s due today.  If I don’t turn it in"
                + "\n on time, I'll get a zero; and I worked on it all night!”"
                + "\n"
                + "\n"
                + "\nWhat will you do?"
                + "\n"
                + "\n***************************************************************"
                + "\nS - Search your Backpack              R - Return to Game Menu"
                + "\n***************************************************************");
        String choice = this.getInput();
        choice = choice.toUpperCase();

        switch (choice) {
            case "S":
                schoolSearchYourBackpack();
                break;
            case "R":
                gameMenu.display();
        }

    }

    public void schoolSearchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "paper";
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
                    + "\nI saw him going through the playground earlier, but he didn't have a bone."
                    + "\n  Good luck!"
                    + "\n****************************************************");

        } else {
            this.console.println("\n\"Gee, I’m sorry, Brad.  Good luck finding it.  "
                    + "\nI’ll keep my eyes peeled.”"
                    + "\n\"Thanks, " + StartProgramView.player.getName() + ".”"
                    + "\n“You haven’t seen DeVil, have you?  He might have been carrying a bone?”"
                    + "\n“DeVil with a bone?  Don’t be silly!” Brad chuckles.  "
                    + "\n“Sorry, " + StartProgramView.player.getName() + ".  I need to find my paper before the bell rings.”"
                    + "\n****************************************************");
        }
    }

    public void parkingLotSearchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "donuts";
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
                    + "\n"
                    + "\n****************************************************"
                    + "\nG - Get the paper"
                    + "\nR - Return to Game Menu"
                    + "\n****************************************************");

            String choice = this.getInput();
            choice = choice.toUpperCase();

            switch (choice) {
                case "G":
                    parkingLotGetPaper();
                    break;
                case "R":
                    gameMenu.display();
            }

        } else {
            this.console.println("\nI'm sorry, Mr. Sneed. I don't have any"
                    + "\ngoodies for people."
                    + "\nAh, well. I can wait until lunch. I'm gaining to"
                    + "\nmany pounds anyway. He laughs patting his stomach"
                    + "\nUm, sir? have you seen DeVil?"
                    + "\nDevil, isn't that the mean black and white one?"
                    + "\nNope. Haven't seen him today. Sorry"
                    + "\n****************************************************");
        }
    }

    public void parkingLotGetPaper() {
        Item paper = new Item("paper", "School Entrance", "Brad");
        StartProgramView.player.addToBackpack(paper);
        this.console.println("You look at the paper on the fence. Hmm."
                + "\nFunny handwriting. Wait. That says Brad on the top."
                + "\nBrad is one of the kids in your neighborhood."
                + "\nHe might need this. Better hang on to it.");
    }

    public void parkFetch() {
        this.console.println("\nYou race after the stick with eager anticipation. "
				+ "\nYou love to play fetch!  Quickly to get the stick and bring it"
				+ "\nback to Tommy.  He happily throws it again and again.  After a"
				+ "\nwhile you see a cat come out of the trees.  Huh?  Oh, no! You"
				+ "\nneed to find DeVil and your bone!"
                                + "\n"
                                + "\n"
                                + "\nWhat will you do?"
                                + "\n"
                                + "\n***************************************************************"
                                + "\nF - Fetch the stick again...because you're a dog"
                                + "\nS - Search your Backpack"
                                + "\nR – Return to Game Menu"
                                + "\n****************************************************************");
       String choice = this.getInput();
       choice = choice.toUpperCase();
       
       switch(choice) {
           case "F":
               parkFetch();
            break;
           case "S":
               parkSearchYourBackpack();
               break;
           case "R":
               gameMenu.display();
       }
    }
    
    public void parkSearchYourBackpack() {
        Game game = WheresMyBone.getCurrentGame();
        Backpack backpack = game.getPlayer().getBackpack();
        String itemName = "pebble";
        Item item = backpack.GiveItem(itemName);

   
        if (item != null) {
            // this.console.println("\nThe Paper is at index " + index + " in the Backpack ArrayList.");
            this.console.println("\nYou find the pebble you found at the pond. "
                    + "\n“How's this one?” you ask."
                    + "\n“What?  Oh, " + StartProgramView.player.getName() + "!  This is awesome!” "
                    + "\n\"I've never seen one like it! "
                    + "\n“Have you seen DeVil with a bone?” you ask."
                    + "\n“DeVil?  Last time I saw DeVil he was running"
                    + "\nin front of Officer Pete.  That was down the street some.”"
                    + "\n  Good luck!"
                    + "\n"
                    + "\n****************************************************");

        } else {
            this.console.println("\n\"Gee, I’m sorry, Tommy.  I don't have a pebble."
                    + "\nI’ll keep my eyes peeled.”"
                    + "\n\"Thanks, " + StartProgramView.player.getName() + ".”"
                    + "\n“You haven’t seen DeVil, have you?”"
                    + "\n“Not today,” Tommy shrugs.  "
                    + "\n“Sorry, " + StartProgramView.player.getName() + ".\" "
                    + "\n"
                    + "\n****************************************************");
        }
    }
}
