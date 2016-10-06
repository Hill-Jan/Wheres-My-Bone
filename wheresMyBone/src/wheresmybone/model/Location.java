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
public class Location implements Serializable{
    
  private String row;
  private int column;
  private String visited;
  private String npcName;
  private String scene;
  private double calculations;
  
  public String getRow()
  {
    return this.row;
  }
  
  public void setRow(String row)
  {
    this.row = row;
  }
  
  public int getColumn()
  {
    return this.column;
  }
  
  public void setColumn(int column)
  {
    this.column = column;
  }
  
  public String getVisited()
  {
    return this.visited;
  }
  
  public void setVisited(String visited)
  {
    this.visited = visited;
  }
  
  public String getNpcName()
  {
    return this.npcName;
  }
  
  public void setNpcName(String npcName)
  {
    this.npcName = npcName;
  }
  
  public String getScene()
  {
    return this.scene;
  }
  
  public void setScene(String scene)
  {
    this.scene = scene;
  }
  
  public double getCalculations()
  {
    return this.calculations;
  }
  
  public void setCalculations(double calculations)
  {
    this.calculations = calculations;
  }
  
  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.row);
    hash = 59 * hash + this.column;
    hash = 59 * hash + Objects.hashCode(this.visited);
    hash = 59 * hash + Objects.hashCode(this.npcName);
    hash = 59 * hash + Objects.hashCode(this.scene);
    hash = 59 * hash + (int)(Double.doubleToLongBits(this.calculations) ^ Double.doubleToLongBits(this.calculations) >>> 32);
    return hash;
  }
  
  @Override
  public String toString()
  {
    return "Location{row=" + this.row + ", column=" + this.column + ", visited=" + this.visited + ", npcName=" + this.npcName + ", scene=" + this.scene + ", calculations=" + this.calculations + '}';
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
    Location other = (Location)obj;
    if (this.column != other.column) {
      return false;
    }
    if (Double.doubleToLongBits(this.calculations) != Double.doubleToLongBits(other.calculations)) {
      return false;
    }
    if (!Objects.equals(this.row, other.row)) {
      return false;
    }
    if (!Objects.equals(this.visited, other.visited)) {
      return false;
    }
    if (!Objects.equals(this.npcName, other.npcName)) {
      return false;
    }
    return Objects.equals(this.scene, other.scene);
  }  

}

