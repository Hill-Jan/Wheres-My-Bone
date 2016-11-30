/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.Serializable;

/**
 *
 * @author tCalder
 */
public class GetView {
    
    public static View getSceneView(String mapSymbol) {
        switch(mapSymbol){
            case "VH":
                return new VacantHouseSceneView();
            case "GF":
                return new EnterGiraffeView();
            default: return null;
        }
    }
    
    
}
