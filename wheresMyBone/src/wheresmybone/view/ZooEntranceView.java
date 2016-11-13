/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

/**
 *
 * @author Sexy Mario
 */
public class ZooEntranceView extends View{
        private String promptMessage;{
    
}

public ZooEntranceView() {
            super("\n"
                + "\n---------------------------------------------"
                + "\nZoo Entrance"
                + "\n---------------------------------------------"
                + "\nYou You suddenly come to a stop in front of the"
                + "\nZoo. You remember your realize the local snitch"
                + "\nM'Linzi the gorilla might have heard something"
                + "\nabout the bone. What do you want to do?"
                + "\n---------------------------------------------"
                + "\n"
                + "\nChoose a Menu Option: "
                + "\n"
                + "\nE - Enter the Gorilla enclosure"
                + "\nC - Sniff around for another lead"
                + "\nX - Exit the Zoo Entrance"
                + "\n----------------------------------------------"
                + "\n");
}

@Override
public boolean doAction (String value) {
    value = value.toUpperCase();
    
    switch (value) {
        case "E": 
            this.enterGorillaEnclosure();
            break;
        case "C": 
            this.sniffForClue();
            break;
        default:
            System.out.println("\n*** Invalid selection *** Try again");
            break;
    }
        return false;
        
}

private void enterGorillaEnclosure() {
    System.out.println("\n*** Calling the enterGorillaEnclosure() function");
}

private void sniffForClue(){
    System.out.println("\n***Calling the sniffForClue() function");
}

}
