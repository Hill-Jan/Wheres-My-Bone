/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone;

import wheresmybone.model.Player;

/**
 *
 * @author Sexy Mario
 */
public class WheresMyBone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Player userName = new Player();
        
        userName.setName("Chuck Whiffendiffer");
        userName.setGender("Male");
        
        String userInfo = userName.toString();
        System.out.println(userInfo);
        
    }
    
   
}
