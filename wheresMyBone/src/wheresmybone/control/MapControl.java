/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import wheresmybone.model.Map;
import wheresmybone.model.Scene;
//import wheresmybone.model.Scene.SceneType;

/**
 *
 * @author Jan
 */
public class MapControl {

    public static Map createMap() {
        Map map = new Map(5,5);
        
        Scene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    
    public static void movePlayerToStartingLocation(Map map) {
   // movePlayer(map, 2, 2);
        movePlayer(map, 2, 2);
}

public static void movePlayer(Map map, int row, int column) {
   map.setCurrentLocation(map.getLocations()[row][column]);
   map.getCurrentLocation().setVisited(true);
   map.setCurrentRow(row);
   map.setCurrentColumn(column);
}
 

public enum SceneType {
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

 }
    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene park = new Scene();
        park.setSceneName("The Park");
        park.setSceneDescript(
            "Trees, pond, swings");
        park.setMapSymbol("PK");
        //park.setBlocked(false);
        park.setTravelTime(20);
        scenes[SceneType.park.ordinal()] = park;
        
        Scene vacanthouse = new Scene();
        vacanthouse.setSceneName("The Vacant House");
        vacanthouse.setSceneDescript(
            "e plurubus enum");
        vacanthouse.setMapSymbol("VH");
        //obligatory.setBlocked(false);
        vacanthouse.setTravelTime(20);
        scenes[SceneType.vacanthouse.ordinal()] = vacanthouse;
        
        Scene police = new Scene();
        police.setSceneName("Police");
        police.setSceneDescript(
            "e plurubus enum");
        police.setMapSymbol("PS");
        //obligatory.setBlocked(false);
        police.setTravelTime(15);
        scenes[SceneType.police.ordinal()] = police;
        
        Scene animalhospital = new Scene();
        animalhospital.setSceneName("Animal Hospital");
        animalhospital.setSceneDescript(
            "e plurubus enum");
        animalhospital.setMapSymbol("AH");
        //obligatory.setBlocked(false);
        animalhospital.setTravelTime(25);
        scenes[SceneType.animalhospital.ordinal()] = animalhospital;
        
        Scene pound = new Scene();
        pound.setSceneName("The Pound");
        pound.setSceneDescript(
            "e plurubus enum");
        pound.setMapSymbol("PD");
        //obligatory.setBlocked(false);
        pound.setTravelTime(30);
        scenes[SceneType.pound.ordinal()] = pound;
        
        Scene bakery = new Scene();
        bakery.setSceneName("The Bakeryk");
        bakery.setSceneDescript(
            "e plurubus enum");
        bakery.setMapSymbol("TB");
        //obligatory.setBlocked(false);
        bakery.setTravelTime(25);
        scenes[SceneType.bakery.ordinal()] = bakery;
        
        Scene restaurant = new Scene();
        restaurant.setSceneName("The Restaurant");
        restaurant.setSceneDescript(
            "e plurubus enum");
        restaurant.setMapSymbol("TR");
        //obligatory.setBlocked(false);
        restaurant.setTravelTime(15);
        scenes[SceneType.restaurant.ordinal()] = restaurant;
        
        Scene drivein = new Scene();
        drivein.setSceneName("The Drive-In");
        drivein.setSceneDescript(
            "e plurubus enum");
        drivein.setMapSymbol("DI");
        //obligatory.setBlocked(false);
        drivein.setTravelTime(25);
        scenes[SceneType.drivein.ordinal()] = drivein;
        
        Scene pond = new Scene();
        pond.setSceneName("The Pond");
        pond.setSceneDescript(
            "e plurubus enum");
        pond.setMapSymbol("TP");
        //obligatory.setBlocked(false);
        pond.setTravelTime(15);
        scenes[SceneType.pond.ordinal()] = pond;
        
        Scene alley = new Scene();
        alley.setSceneName("The Alley");
        alley.setSceneDescript(
            "e plurubus enum");
        alley.setMapSymbol("TA");
        //obligatory.setBlocked(false);
        alley.setTravelTime(25);
        scenes[SceneType.alley.ordinal()] = alley;
        
        Scene carehome = new Scene();
        carehome.setSceneName("The Nursing Home");
        carehome.setSceneDescript(
            "e plurubus enum");
        carehome.setMapSymbol("NH");
        //obligatory.setBlocked(false);
        carehome.setTravelTime(20);
        scenes[SceneType.carehome.ordinal()] = carehome;
        
        Scene neighborshouse = new Scene();
        neighborshouse.setSceneName("The Smith's House");
        neighborshouse.setSceneDescript(
            "e plurubus enum");
        neighborshouse.setMapSymbol("NH");
        //obligatory.setBlocked(false);
        neighborshouse.setTravelTime(5);
        scenes[SceneType.neighborshouse.ordinal()] = neighborshouse;
        
        Scene yourhouse = new Scene();
        yourhouse.setSceneName("Your House");
        yourhouse.setSceneDescript(
            "Your bone is missing.");
        yourhouse.setMapSymbol("YH");
        //obligatory.setBlocked(false);
        yourhouse.setTravelTime(0);
        scenes[SceneType.yourhouse.ordinal()] = yourhouse;
        
        Scene devilshouse = new Scene();
        devilshouse.setSceneName("DeVil's House");
        devilshouse.setSceneDescript(
            "e plurubus enum");
        devilshouse.setMapSymbol("DH");
        //obligatory.setBlocked(false);
        devilshouse.setTravelTime(5);
        scenes[SceneType.devilshouse.ordinal()] = devilshouse;
        
        Scene grocerywarehouse = new Scene();
        grocerywarehouse.setSceneName("The Grocery Store Warehouse");
        grocerywarehouse.setSceneDescript(
            "e plurubus enum");
        grocerywarehouse.setMapSymbol("GW");
        //obligatory.setBlocked(false);
        grocerywarehouse.setTravelTime(25);
        scenes[SceneType.grocerywarehouse.ordinal()] = grocerywarehouse;
        
        Scene zoo = new Scene();
        zoo.setSceneName("The Zoo Entrance");
        zoo.setSceneDescript(
            "e plurubus enum");
        zoo.setMapSymbol("ZO");
        //obligatory.setBlocked(false);
        zoo.setTravelTime(20);
        scenes[SceneType.zoo.ordinal()] = zoo;
        
        Scene elephants = new Scene();
        elephants.setSceneName("The Elephant Enclosure");
        elephants.setSceneDescript(
            "e plurubus enum");
        elephants.setMapSymbol("ZE");
        //obligatory.setBlocked(false);
        elephants.setTravelTime(30);
        scenes[SceneType.elephants.ordinal()] = elephants;
        
        Scene tigers = new Scene();
        tigers.setSceneName("The Tiger Enclosure");
        tigers.setSceneDescript(
            "e plurubus enum");
        tigers.setMapSymbol("ZT");
        //obligatory.setBlocked(false);
        tigers.setTravelTime(25);
        scenes[SceneType.tigers.ordinal()] = tigers;
        
        Scene kangaroos = new Scene();
        kangaroos.setSceneName("The Kangaroo Enclosure");
        kangaroos.setSceneDescript(
            "e plurubus enum");
        kangaroos.setMapSymbol("ZK");
        //obligatory.setBlocked(false);
        kangaroos.setTravelTime(35);
        scenes[SceneType.kangaroos.ordinal()] = kangaroos;
        
        Scene giraffes = new Scene();
        giraffes.setSceneName("The Giraffe Enclosure");
        giraffes.setSceneDescript(
            "e plurubus enum");
        giraffes.setMapSymbol("ZG");
        //obligatory.setBlocked(false);
        giraffes.setTravelTime(40);
        scenes[SceneType.giraffes.ordinal()] = giraffes;
        
        Scene schoolentrance = new Scene();
        schoolentrance.setSceneName("The School Entrance");
        schoolentrance.setSceneDescript(
            "e plurubus enum");
        schoolentrance.setMapSymbol("SE");
        //obligatory.setBlocked(false);
        schoolentrance.setTravelTime(20);
        scenes[SceneType.schoolentrance.ordinal()] = schoolentrance;
        
        Scene schoolcafeteria = new Scene();
        schoolcafeteria.setSceneName("The School cafeteria");        
        schoolcafeteria.setSceneDescript(
            "e plurubus enum");
        schoolcafeteria.setMapSymbol("SC");
        //obligatory.setBlocked(false);
        schoolcafeteria.setTravelTime(25);
        scenes[SceneType.schoolcafeteria.ordinal()] = schoolcafeteria;
        
        Scene schoolplayground = new Scene();
        schoolplayground.setSceneName("The School Playground");        
        schoolplayground.setSceneDescript(
            "e plurubus enum");
        schoolplayground.setMapSymbol("SP");
        //obligatory.setBlocked(false);
        schoolplayground.setTravelTime(25);
        scenes[SceneType.schoolplayground.ordinal()] = schoolplayground;
        
        Scene schoolparkinglot = new Scene();
        schoolparkinglot.setSceneName("The School Parking Lot");
        schoolparkinglot.setSceneDescript(
            "e plurubus enum");
        schoolparkinglot.setMapSymbol("SP");
        //obligatory.setBlocked(false);
        schoolparkinglot.setTravelTime(20);
        scenes[SceneType.schoolparkinglot.ordinal()] = schoolparkinglot;
        
        Scene fishmonger = new Scene();
        fishmonger.setSceneName("The Fishmonger Stand");
        fishmonger.setSceneDescript(
            "e plurubus enum");
        fishmonger.setMapSymbol("FM");
        //obligatory.setBlocked(false);
        fishmonger.setTravelTime(35);
        scenes[SceneType.fishmonger.ordinal()] = fishmonger;
        
       
        
        return scenes;
    }
    
    
}
