/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.util.ArrayList;
import wheresmybone.control.GameControl;
import wheresmybone.model.Item;
import static wheresmybone.view.MapSymbolSceneName.viewMap;

/**
 *
 * @author Jan
 */
public class SchoolEntrance extends View{
     //private String promptMessage;{
//}
public SchoolEntrance() {
            super ("\n*********************************************************"
                    +"\n    School Entrance  VIEW   "
                    +"\n********************************************************"
                    +"\n"
                    +"\nYou come around the corner to the school entrance."
                    +"\nThere are several children nearby playing."
                    +"\nYou notice Brad, a lanky 10-year-old from your neighborhood,"
                    +"\nfrantically searching for something.  What should you do?"
                    +"\n********************************************************"
                    +"\nChoose a menu option:"
                    +"\nT - Talk to Brad."
                    +"\nX - Get out Fast!"
                    +"\n********************************************************");
                    }

@Override
public boolean doAction (String value){
        value = value.toUpperCase();

        switch(value){
            case "T":
                this.talkToBrad();
                break;
            
            case "S":
                this.searchYourBackpack();
                return true;
                
            default:
            System.out.println("\n*** Invalid selection *** Try again");
            break;
        }
       return false;

}

    private void talkToBrad() {
        this.promptMessage = "\n***Brad tells you he lost his English paper.  If he"
                           +"\ndoesn't turn it in on time, he'll get a zero; and he."
                           +"\nworked on it all night!"
                           +"\n"
                           +"\nYou remember you put a paper in your backpack when"
                           +"\n you were in the school parking lot."
                           +"\n****************************************************"
                           +"\nWhat Will You do?"
                           +"\n"
                           +"\nS - Search your Backpack"
                           +"\nX - Leave the area"
                           +"\n****************************************************";
    }


    public void searchYourBackpack() {
        
       ArrayList<Item> backpack = new ArrayList<>();
       backpack = GameControl.createItemList();
        
        String itemName = "paper";
        int index = -1;
        for (int i=0; i<backpack.size(); i++) {
            if (backpack.get(i).getName().equals(itemName)) {
                index = i;
            }
        }
        /*TEST MATRIX
        ***************************************
        Location of item in ArrayList Backpack
        ***************************************
                  |  VALID    |  INVALID      |
        ***************************************
        INPUT     | Paper     |  Paper        |
        ***************************************
        OUTPUT    |  13       |     -1        |
        ***************************************
           Error  |           | Must not have |
                                  it yet      |
        ***************************************
        */
        
        /* ALGORITHM for displaying location of item
           Process the search above to locate the item within the inventory arrayList
                        located in the Game Control Layer.
           Use the index variable to display the location of the item in 
                        the inventory (in this case: paper)
           Display the location of the item on the screen.
        */
        
        if(index != -1){
            System.out.println("\nThe Paper is at index " + index + " in the Backpack ArrayList.");
            System.out.println("\nYou give Brad the paper.  He's so excited "
            + "\nhe gives you a hug.  You ask if he's seen DeVil with"
            + "\n a bone."
            +"\n"
            +"\n\"I saw him going through the playground earlier, but"
            +"\nhe didn't have a bone.  Good luck!\""
            +"\n****************************************************"
            +"\nWhere To Now?  Enter a new location."
            +"\n****************************************************");                       
        viewMap();
        MapView mapView = new MapView();
        mapView.display();
        viewMap();
        }
        else {
            System.out.println("\nYou must not have picked it up."
                +"\n****************************************************"
                +"\nWhere To Now?  Enter a new location."
                +"\n****************************************************");
        viewMap();
        MapView mapView = new MapView();
        mapView.display();
        viewMap();
        }
    }
}





