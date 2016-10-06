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
  
 public String getSceneName()
  {
    return this.sceneName;
  }
  
  public void setSceneName(String sceneName)
  {
    this.sceneName = sceneName;
  }
  
  public String getSceneDescript()
  {
    return this.sceneDescript;
  }
  
  public void setSceneDescript(String sceneDescript)
  {
    this.sceneDescript = sceneDescript;
  }
  
  public String getNpcDescription()
  {
    return this.npcDescription;
  }
  
  public void setNpcDescription(String npcDescription)
  {
    this.npcDescription = npcDescription;
  }
  
 @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.sceneName);
    hash = 67 * hash + Objects.hashCode(this.sceneDescript);
    hash = 67 * hash + Objects.hashCode(this.npcDescription);
    return hash;
  }
  
 @Override
  public String toString()
  {
    return "Scene{sceneName=" + this.sceneName + ", sceneDescript=" + this.sceneDescript + ", npcDescription=" + this.npcDescription + '}';
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
    Scene other = (Scene)obj;
    if (!Objects.equals(this.sceneName, other.sceneName)) {
      return false;
    }
    if (!Objects.equals(this.sceneDescript, other.sceneDescript)) {
      return false;
    }
    return Objects.equals(this.npcDescription, other.npcDescription);
  }   
}
