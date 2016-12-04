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
public class AnimalHospital extends View {
    //private String promptMessage;{
//}

    public AnimalHospital() {
        super("\n*********************************************************"
                + "\n             ANIMAL HOSPITAL   "
                + "\n********************************************************"
                + "\n"
                + "\nYou begin to pass the Animal Hospital.  As you get up close,"
		+ "\nyou notice that kind Dr. Mice is outside taking a break.  "
		+ "\nShe’s a sweet, young veterinarian with long brown hair.  She "
		+ "\nlooks a little undernourished, but seems to be ok.  You wander"
		+ "\nup to her on the bench outside the hospital."
		+ "\n"
		+ "\n“Hey, "+ StartProgramView.player.getName() +"!  How are you today?” she greets you with a "
		+ "\nsmile and a scratch."
		+ "\n“I don’t know.”"
		+ "\n“What’s wrong?”"
		+ "\n“I think DeVil took my bone.  Have you seen him?”"
		+ "\n“DeVil?  No, but I found his nametag.  Here.  You can return it "
		+ "\nif you find him.  Maybe Mr. Sam at the Shelter has seen him.  "
		+ "\nHe’s always watching out for that feline!”"
		+ "\n“Thanks.”"
                + "\n"
                + "\n********************************************************"
                + "\nG - Get nametag"
                + "\nX - Leave the Area!"
                + "\n********************************************************");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        switch (value) {
            case "G":
                this.getItem();
                break;

            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    private void getItem() {
        Item newItem = new Item("Nametag", "Animal Hospital", "collar");
        StartProgramView.player.addToBackpack(newItem);
    }
}
