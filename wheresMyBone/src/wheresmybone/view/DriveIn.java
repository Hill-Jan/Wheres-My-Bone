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
public abstract class DriveIn extends View {
    //private String promptMessage;{
//}

    public DriveIn() {
        super("\n*********************************************************"
                + "\n                 THE DRIVE-IN MOVIE THEATER   "
                + "\n********************************************************"
                + "\n"
                + "\nThe Drive-In Movie Theater is brand new in town, but it’s "
                + "\nyoung owner, Miss Cocoa, made it to look like something out"
                + "\nof the 1950s.  Amazingly, it’s filled with people every Friday"
                + "\nand Saturday night.  The cars park and watch movies on a big "
                + "\nscreen while speakers play the sound in their cars."
                + "\n" 
                + "\nToday, Miss Cocoa and a few others are picking up litter "
                + "\nfrom the Drive-In Lot.  She sees you coming through the lot"
                + "\nand waves.  “Hey, there, " + StartProgramView.player.getName() +"!” "
                + "\n"
                + "\n“Hi, Miss Cocoa!”"
                + "\n“Here.  I’ve got something for you,” she smiled.  She reached "
                + "\ninto her apron pocket and pulled out a dog treat.  Your eyes"
                + "\nlight up and you sit up for it.  She laughs as she gives you"
                + "\nthe bone.  “You always make my day!”"
                + "\n"
                + "\n“Thanks,” you say finishing off the bone.  “Have you seen DeVil?”"
                + "\n“DeVil?  Oh, yea!  He’s that mean gray and white cat, isn’t he?”"
                + "\n“Yes.  I think he stole my bone.”"
                + "\n“No, I haven’t seen him, but I’ll keep an eye out for you. "
                + "\n”Have you checked over at the Bakery?  Maybe Miss Jones has "
                + "\nseen him, and I’ll bet she’s got sweeter treats than I do!”"
                +"\n“Thanks.”"
                + "\n********************************************************"
                + "\nX - Where To Now?"
                + "\n********************************************************");
    }

    
}