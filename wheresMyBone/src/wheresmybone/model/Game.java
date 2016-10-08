/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dan
 */
public class Game implements Serializable{
    
    private int startTime;
    private double bestTime;
    private String instructions;
    private String attribute;

    public Game() {
    }
        
    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.startTime;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.bestTime) ^ (Double.doubleToLongBits(this.bestTime) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.instructions);
        hash = 83 * hash + Objects.hashCode(this.attribute);
        return hash;
    }
 @Override
    public String toString() {
        return "Game{" + "startTime=" + startTime + ", bestTime=" + bestTime + ", instructions=" + instructions + ", attribute=" + attribute + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.startTime != other.startTime) {
            return false;
        }
        if (Double.doubleToLongBits(this.bestTime) != Double.doubleToLongBits(other.bestTime)) {
            return false;
        }
        if (!Objects.equals(this.instructions, other.instructions)) {
            return false;
        }
        if (!Objects.equals(this.attribute, other.attribute)) {
            return false;
        }
        return true;
    }

   

   
    
   
    
    
    
}
