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
 * @author Hill-Jan
 */
public class Map implements Serializable{
  
  private int rowCount;
  private int columnCount;
  private double travelTime;
  
  public int getRowCount()
  {
    return this.rowCount;
  }
  
    /**
     *
     * @param rowCount
     */
    public void setRowCount(int rowCount)
  {
    this.rowCount = rowCount;
  }
  
  public int getColumnCount()
  {
    return this.columnCount;
  }
  
  public void setColumnCount(int columnCount)
  {
    this.columnCount = columnCount;
  }
  
  public double getTravelTime()
  {
    return this.travelTime;
  }
  
  public void setTravelTime(double travelTime)
  {
    this.travelTime = travelTime;
  }
  
  @Override
  public int hashCode()
  {
    int hash = 3;
    hash = 59 * hash + Objects.hashCode(this.rowCount);
    hash = 59 * hash + this.columnCount;
    hash = 59 * hash + (int)(Double.doubleToLongBits(this.travelTime) ^ Double.doubleToLongBits(this.travelTime) >>> 32);
    return hash;
  }
  
  @Override
  public String toString()
  {
    return "Map{rowCount=" + this.rowCount + ", columnCount=" + this.columnCount + ", travelTime=" + this.travelTime + '}';
  }
  
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Map other = (Map)obj;
    if (this.columnCount != other.columnCount) {
      return false;
    }
    if (Double.doubleToLongBits(this.travelTime) != Double.doubleToLongBits(other.travelTime)) {
      return false;
    }
    return Objects.equals(this.rowCount, other.rowCount);
  }
  
  public void setSceneName(String school_cafeteria)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public void setSceneDescript(String you_are_in_the_school_cafeteria)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public void setNpcDescription(String brad_a_tall_blonde_boy)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}

