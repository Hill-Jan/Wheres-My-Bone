/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import wheresmybone.model.Game;
import wheresmybone.model.Player;
import wheresmybone.view.StartProgramView;

/**
 *
 * @author Dan
 */
public class WheresMyBone {
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;
    
    public static void main(String[] args) {
        
        try{
            //open character stream files for end user input and output
            WheresMyBone.inFile = 
                    new BufferedReader(new InputStreamReader(System.in));
            
            WheresMyBone.outFile = new PrintWriter(System.out, true);
            
            //open log file
            String filePath = "log.txt";
            WheresMyBone.logFile = new PrintWriter(filePath);
        
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
        return;
    } catch (Throwable te) {
        System.out.println("Exception: " + te.toString() +
                           "\nCause: " + te.getCause() +
                           "\nMessage: " + te.getMessage());
        te.printStackTrace();
    }
        finally {
            try {
                if (WheresMyBone.inFile !=null)
                  WheresMyBone.inFile.close();
                
                if (WheresMyBone.outFile !=null)
                WheresMyBone.outFile.close();
                
                if (WheresMyBone.logFile != null)
                    WheresMyBone.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
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

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        WheresMyBone.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        WheresMyBone.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        WheresMyBone.logFile = logFile;
    }

}

