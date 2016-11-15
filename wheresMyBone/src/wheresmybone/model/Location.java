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
  
  private Scene scene;
  
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
  
    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.row);
        hash = 37 * hash + this.column;
        hash = 37 * hash + Objects.hashCode(this.visited);
        hash = 37 * hash + Objects.hashCode(this.scene);
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
        final Location other = (Location) obj;
        if (this.column != other.column) {
            return false;
        }
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        return true;
    }
  
  
 

}

