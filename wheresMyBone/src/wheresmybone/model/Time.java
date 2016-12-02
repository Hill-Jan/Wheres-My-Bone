/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;

import java.io.Serializable;

/**
 *
 * @author Daniel
 */
public class Time implements Serializable{
    
    private double totalTime;
    private double timeSubtracted;

    public Time() {
        totalTime = 0;
        timeSubtracted = 0;
    }
    
    

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getTimeSubtracted() {
        return timeSubtracted;
    }

    public void setTimeSubtracted(double timeSubtracted) {
        this.timeSubtracted = timeSubtracted;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.timeSubtracted) ^ (Double.doubleToLongBits(this.timeSubtracted) >>> 32));
        return hash;
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
        final Time other = (Time) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.timeSubtracted) != Double.doubleToLongBits(other.timeSubtracted)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Time{" + "totalTime=" + totalTime + ", timeSubtracted=" + timeSubtracted + '}';
    }
    
    
}
