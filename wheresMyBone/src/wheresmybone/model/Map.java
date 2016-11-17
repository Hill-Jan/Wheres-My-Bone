/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Hill-Jan
 */
public class Map implements Serializable{
  
  private int rowCount;
  private int columnCount;

  private Location[][] locations;

  /*Map(rows, columns)
BEGIN
IF rows < 1 OR columns < 1 THEN
DISPLAY “rows and columns must be > 0” RETURN
ENDIF
 Save the number of rows and columns
Create a 2-D array of Locations

 FOR every row in the array
FOR every column in the array
Create and initialize a new Location object
locations[row][column] = location
ENDFOR
END
  */
  
    public Map(){
    }
    
    public Map(int rowCount, int columnCount) {
        
        if (rowCount < 1 || columnCount < 1) {
            System.out.println("The number of rows and colums must be > zero");
            return;
        }
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        
        this.locations = new Location  [rowCount] [columnCount];
        
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
        if (!Arrays.deepEquals(this.locations, other.locations)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", locations=" + locations + '}';
    }
  
  
  
  public void setSceneName(String school_cafeteria)
  {
    System.out.println("call set scene name function");
  }
  
  public void setSceneDescript(String you_are_in_the_school_cafeteria)
  {
    System.out.println("call set scene descript function");
  }
  
  public void setNpcDescription(String brad_a_tall_blonde_boy)
  {
    System.out.println("call npc description function");
  }

    public Location[][] getLocations() {
        System.out.println("call get location function");
        
        return locations;
    }

    public Location getCurrentLocation() {
        System.out.println("Tells the current location");
      Location currentLocation = null;
        
        return currentLocation;
    }
    
}

