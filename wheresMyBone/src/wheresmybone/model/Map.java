/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;

import java.io.Serializable;
import java.util.Arrays;
import wheresmybone.view.ErrorView;

/**
 *
 * @author Hill-Jan
 */
public class Map implements Serializable{
  
  private int rowCount;
  private int columnCount;
  private int currentRow;
  private int currentColumn;
  private Location currentLocation;
  private Location[][] locations;
  
    public Map(){
        rowCount = 0;
        columnCount = 0;
        currentRow = 0;
        currentColumn = 0;
        currentLocation = new Location();
        
    }
    
    public Map(int rowCount, int columnCount) {
        
        if (rowCount < 1 || columnCount < 1) {
            ErrorView.display(this.getClass().getName(),"\nThe number of rows and colums must be > zero");
            return;
        }
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        
        this.locations = new Location[rowCount][columnCount];
        
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++){
                
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                
                locations[row][column] = location;
            }
            
        }
    }
  

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.rowCount;
        hash = 11 * hash + this.columnCount;
        hash = 11 * hash + Arrays.deepHashCode(this.locations);
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
        final Map other = (Map) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        return Arrays.deepEquals(this.locations, other.locations);
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", locations=" + locations + '}';
    }
  
  
  
  /*public void setSceneName(String school_cafeteria)
  {
    //this.console.println("call set scene name function");
  }
  
  public void setSceneDescript(String you_are_in_the_school_cafeteria)
  {
    //this.console.println("call set scene descript function");
  }
  
  public void setNpcDescription(String brad_a_tall_blonde_boy)
  {
    //this.console.println("call npc description function");
  }*/

    public Location[][] getLocations() {
        return this.locations;
    }
    public Location[][] setLocations() {
        return locations;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }
    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

}
