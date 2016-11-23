/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import wheresmybone.WheresMyBone;
import wheresmybone.control.MapControl;
import wheresmybone.control.MapControl.SceneType;
import wheresmybone.model.Game;
import wheresmybone.model.Location;
import wheresmybone.model.Map;
import wheresmybone.model.Npc;
import static wheresmybone.view.MapSymbolSceneName.viewMap;


/**
 *
 * @author Dan
 */
public class NpcSort extends View {
    
public NpcSort (){
     super("\n*****************************************************************"
         + "\n    Look and see which Npc is at what location."
         + "\n"
         + "\nTo see what location the Npc is at type the map symbol from the"
         + "\nmap above."
         + "\n"
         + "\n    Or choose (H) to return to Help Menu      "
         + "\n"
         + "\n*****************************************************************"
    ); 
     System.out.println("\n");
     viewMap();
     System.out.println("\n");
    }

@Override
public boolean doAction(String value){
 
    value = value.toUpperCase();
    for (Npc st : Npc.values()){
        if (st.npcLocation().equals(value)){
            System.out.println( st.ordinal() + "is at " +  "+ st.getSceneName());
         return true;   
        }
        if (value.toUpperCase().equals("X")) // user wants to quit
                   break; //exit the game
        }
    
        System.out.println("Please choose a valid Map Symbol");
        viewMap();
        return false;
}

}
