/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;


import wheresmybone.model.Npc.Npcs;


/**
 *
 * @author Dan
 */
public class NpcSort extends View {
    
public NpcSort (){
     super("\n*****************************************************************"
         + "\nTo see what location the Npc is at type the name from the list"
         + "\nabove."
         + "\n"
         + "\n    Or choose (H) to return to Help Menu      "
         + "\n"
         + "\n*****************************************************************"
    ); 
     
     /*TEST MATRIX
        *****************************************************************
        |Location and Name of chosen Npc                                |
        *****************************************************************
        |          |  VALID                               |  INVALID    |
        *****************************************************************
        | INPUT    | PARK                                 |      Parks  |
        *****************************************************************
        | OUTPUT   |   Tommy is at 0 which is at the park |     false   |
        *****************************************************************
        |   Error  |              | Please choose                       | 
        |          |              | a valid name                        |
        *****************************************************************
        */
        

        /* ALGORITHM for displaying location of NPC
           Receive user input of valid location name and then
            process the below for statement to locate the npc within the Npc[] npc
           array, utilizing the SceneType enum, located in the MapControl Layer.
           Use the ordinal() function to find the location of the scene in 
                        the map and the .getNpcLocation() function to find the
                        sceneName.
           Display the name of the Npc and corresponding scene or get an error if the 
           scene name is not typed correctly.
        */   
     
     
     Npcs[] npcs = Npcs.values();

        for (Npcs npcLocation : npcs) {
            this.console.println(npcLocation.getNpcLocation());
        }
    }

@Override
public boolean doAction(String value){
 
    value = value.toUpperCase();
    for (Npcs npc : Npcs.values()){
        if (npc.getNpcLocation().equals(value)){
            this.console.println(npc.toString() + " is at " + npc.ordinal() + " which is the " + npc.getNpcLocation());
         return true;   
        }
        if (value.toUpperCase().equals("X")) // user wants to quit
                   break; //exit the game
        }
    
        ErrorView.display(this.getClass().getName(),"\nPlease enter a valid Scene Location");
        return false;
}


}
