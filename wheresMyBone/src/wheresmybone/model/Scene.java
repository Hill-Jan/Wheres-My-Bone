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
public class Scene implements Serializable{
    
 private String sceneName;
 private String sceneDescript;
 private String npcDescription;
 private Item item;
private double travelTime;
private String mapSymbol;

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public String getMapSymbol() {
        
        return this.mapSymbol;
    }
  
 /*public enum SceneType {
     park,
    vacanthouse,
    police,
    animalhospital,
    pound,
    bakery,
    restaurant,
    drivein,
    pond,
    alley,
    carehome,
    neighborshouse,
    yourhouse,
    devilshouse,
    grocerywarehouse,
    zoo,
    elephants,
    tigers,
    kangaroos,
    giraffes,
    schoolentrance,
    schoolcafeteria,
    schoolplayground,
    schoolparkinglot,
    fishmonger;

 }*/
 public String getSceneName()
  {
    return this.sceneName;
  }
  
  public void setSceneName(String sceneName)
  {
    
  }
  
  public String getSceneDescript()
  {
    return this.sceneDescript;
  }
  
  public void setSceneDescript(String sceneDescript)
  {
  }
  
  public String getNpcDescription()
  {
    return this.npcDescription;
  }
  
  public void setNpcDescription(String npcDescription)
  {
    
  }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        
    }
  public double getTravelTime()
  {
    return this.travelTime;
  }
  
  public void setTravelTime(double travelTime)
  {
   
  }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.sceneName);
        hash = 89 * hash + Objects.hashCode(this.sceneDescript);
        hash = 89 * hash + Objects.hashCode(this.npcDescription);
        hash = 89 * hash + Objects.hashCode(this.item);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.travelTime) ^ (Double.doubleToLongBits(this.travelTime) >>> 32));
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
        final Scene other = (Scene) obj;
        if (Double.doubleToLongBits(this.travelTime) != Double.doubleToLongBits(other.travelTime)) {
            return false;
        }
        if (!Objects.equals(this.sceneName, other.sceneName)) {
            return false;
        }
        if (!Objects.equals(this.sceneDescript, other.sceneDescript)) {
            return false;
        }
        if (!Objects.equals(this.npcDescription, other.npcDescription)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Scene{" + "sceneName=" + sceneName + ", sceneDescript=" + sceneDescript + ", npcDescription=" + npcDescription + ", item=" + item + ", travelTime=" + travelTime + '}';
    }

  
 
}
