/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone;

import wheresmybone.control.GameControl;
import wheresmybone.model.Backpack;
import wheresmybone.model.Game;
import wheresmybone.model.Item;
import wheresmybone.model.Location;
import wheresmybone.model.Map;
import wheresmybone.model.Npc;
import wheresmybone.model.Player;
import wheresmybone.model.Scene;
import wheresmybone.model.Time;
import wheresmybone.view.StartProgramView;
import wheresmybone.view.GameMenuView;
import wheresmybone.view.HelpMenuView;
import wheresmybone.view.MainMenuView;
import wheresmybone.view.VacantHouseView;
import wheresmybone.view.Welcome;

/**
 *
 * @author Dan
 */
public class WheresMyBone {
    
    public static void teamTest() {
    
    StartProgramView startProgramView = new StartProgramView();
    try {
    startProgramView.displayStartProgramView();
    } catch (Throwable te) {
        System.out.println(te.getMessage());
        te.printStackTrace();
        startProgramView.displayStartProgramView();
    }
    }
    public static void tifTest() {
      
    }
    
    public static void janTest() {
        
    }
    
    public static void danTest(){
        
    }
    private static Game currentGame = null;

        public static Game getCurrentGame() {
            return currentGame;
        }

        public static void setCurrentGame(Game currentGame) {
            WheresMyBone.currentGame = currentGame;
        }
        
    private static Player player = null;
    
        public static Player getPlayer() {
            return player;
        }

    public static void setPlayer(Player player) {
        WheresMyBone.player = player;
    }
    

    
    public static void main(String[] args) {
        teamTest();
        tifTest();
        janTest();
        danTest();
    }
    
   
}
