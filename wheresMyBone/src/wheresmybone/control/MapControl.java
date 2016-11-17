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
        System.out.println("**called movePlayerToStartingLocation() function in MapControl**");
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
        park.setSceneDescript(
            "e plurubus enum");
        park.setMapSymbol("park");
        //park.setBlocked(false);
        park.setTravelTime(20);
        scenes[SceneType.park.ordinal()] = park;
        
        Scene vacanthouse = new Scene();
        vacanthouse.setSceneDescript(
            "e plurubus enum");
        vacanthouse.setMapSymbol("vacanthouse");
        //obligatory.setBlocked(false);
        vacanthouse.setTravelTime(20);
        scenes[SceneType.vacanthouse.ordinal()] = vacanthouse;
        
        Scene police = new Scene();
        police.setSceneDescript(
            "e plurubus enum");
        police.setMapSymbol("police");
        //obligatory.setBlocked(false);
        police.setTravelTime(15);
        scenes[SceneType.police.ordinal()] = police;
        
        Scene animalhospital = new Scene();
        animalhospital.setSceneDescript(
            "e plurubus enum");
        animalhospital.setMapSymbol("animalhospital");
        //obligatory.setBlocked(false);
        animalhospital.setTravelTime(25);
        scenes[SceneType.animalhospital.ordinal()] = animalhospital;
        
        Scene pound = new Scene();
        pound.setSceneDescript(
            "e plurubus enum");
        pound.setMapSymbol("pound");
        //obligatory.setBlocked(false);
        pound.setTravelTime(30);
        scenes[SceneType.pound.ordinal()] = pound;
        
        Scene bakery = new Scene();
        bakery.setSceneDescript(
            "e plurubus enum");
        bakery.setMapSymbol("bakery");
        //obligatory.setBlocked(false);
        bakery.setTravelTime(25);
        scenes[SceneType.bakery.ordinal()] = bakery;
        
        Scene restaurant = new Scene();
        restaurant.setSceneDescript(
            "e plurubus enum");
        restaurant.setMapSymbol("restaurant");
        //obligatory.setBlocked(false);
        restaurant.setTravelTime(15);
        scenes[SceneType.restaurant.ordinal()] = restaurant;
        
        Scene drivein = new Scene();
        drivein.setSceneDescript(
            "e plurubus enum");
        drivein.setMapSymbol("drivein");
        //obligatory.setBlocked(false);
        drivein.setTravelTime(25);
        scenes[SceneType.drivein.ordinal()] = drivein;
        
        Scene pond = new Scene();
        pond.setSceneDescript(
            "e plurubus enum");
        pond.setMapSymbol("pond");
        //obligatory.setBlocked(false);
        pond.setTravelTime(15);
        scenes[SceneType.pond.ordinal()] = pond;
        
        Scene alley = new Scene();
        alley.setSceneDescript(
            "e plurubus enum");
        alley.setMapSymbol("alley");
        //obligatory.setBlocked(false);
        alley.setTravelTime(25);
        scenes[SceneType.alley.ordinal()] = alley;
        
        Scene carehome = new Scene();
        carehome.setSceneDescript(
            "e plurubus enum");
        carehome.setMapSymbol("carehome");
        //obligatory.setBlocked(false);
        carehome.setTravelTime(20);
        scenes[SceneType.carehome.ordinal()] = carehome;
        
        Scene neighborshouse = new Scene();
        neighborshouse.setSceneDescript(
            "e plurubus enum");
        neighborshouse.setMapSymbol("neighborshouse");
        //obligatory.setBlocked(false);
        neighborshouse.setTravelTime(5);
        scenes[SceneType.neighborshouse.ordinal()] = neighborshouse;
        
        Scene yourhouse = new Scene();
        yourhouse.setSceneDescript(
            "e plurubus enum");
        yourhouse.setMapSymbol("yourhouse");
        //obligatory.setBlocked(false);
        yourhouse.setTravelTime(0);
        scenes[SceneType.yourhouse.ordinal()] = yourhouse;
        
        Scene devilshouse = new Scene();
        devilshouse.setSceneDescript(
            "e plurubus enum");
        devilshouse.setMapSymbol("deVilshouse");
        //obligatory.setBlocked(false);
        devilshouse.setTravelTime(5);
        scenes[SceneType.devilshouse.ordinal()] = devilshouse;
        
        Scene grocerywarehouse = new Scene();
        grocerywarehouse.setSceneDescript(
            "e plurubus enum");
        grocerywarehouse.setMapSymbol("grocerywarehouse");
        //obligatory.setBlocked(false);
        grocerywarehouse.setTravelTime(25);
        scenes[SceneType.grocerywarehouse.ordinal()] = grocerywarehouse;
        
        Scene zoo = new Scene();
        zoo.setSceneDescript(
            "e plurubus enum");
        zoo.setMapSymbol("zoo");
        //obligatory.setBlocked(false);
        zoo.setTravelTime(20);
        scenes[SceneType.zoo.ordinal()] = zoo;
        
        Scene elephants = new Scene();
        elephants.setSceneDescript(
            "e plurubus enum");
        elephants.setMapSymbol("elephants");
        //obligatory.setBlocked(false);
        elephants.setTravelTime(30);
        scenes[SceneType.elephants.ordinal()] = elephants;
        
        Scene tigers = new Scene();
        tigers.setSceneDescript(
            "e plurubus enum");
        tigers.setMapSymbol("tigers");
        //obligatory.setBlocked(false);
        tigers.setTravelTime(25);
        scenes[SceneType.tigers.ordinal()] = tigers;
        
        Scene kangaroos = new Scene();
        kangaroos.setSceneDescript(
            "e plurubus enum");
        kangaroos.setMapSymbol("kangaroos");
        //obligatory.setBlocked(false);
        kangaroos.setTravelTime(35);
        scenes[SceneType.kangaroos.ordinal()] = kangaroos;
        
        Scene giraffes = new Scene();
        giraffes.setSceneDescript(
            "e plurubus enum");
        giraffes.setMapSymbol("giraffes");
        //obligatory.setBlocked(false);
        giraffes.setTravelTime(40);
        scenes[SceneType.giraffes.ordinal()] = giraffes;
        
        Scene schoolentrance = new Scene();
        schoolentrance.setSceneDescript(
            "e plurubus enum");
        schoolentrance.setMapSymbol("schoolentrance");
        //obligatory.setBlocked(false);
        schoolentrance.setTravelTime(20);
        scenes[SceneType.schoolentrance.ordinal()] = schoolentrance;
        
        Scene schoolcafeteria = new Scene();
        schoolcafeteria.setSceneDescript(
            "e plurubus enum");
        schoolcafeteria.setMapSymbol("schoolcafeteria");
        //obligatory.setBlocked(false);
        schoolcafeteria.setTravelTime(25);
        scenes[SceneType.schoolcafeteria.ordinal()] = schoolcafeteria;
        
        Scene schoolplayground = new Scene();
        schoolplayground.setSceneDescript(
            "e plurubus enum");
        schoolplayground.setMapSymbol("schoolplayground");
        //obligatory.setBlocked(false);
        schoolplayground.setTravelTime(25);
        scenes[SceneType.schoolplayground.ordinal()] = schoolplayground;
        
        Scene schoolparkinglot = new Scene();
        schoolparkinglot.setSceneDescript(
            "e plurubus enum");
        schoolparkinglot.setMapSymbol("schoolparkinglot");
        //obligatory.setBlocked(false);
        schoolparkinglot.setTravelTime(20);
        scenes[SceneType.schoolparkinglot.ordinal()] = schoolparkinglot;
        
        Scene fishmonger = new Scene();
        fishmonger.setSceneDescript(
            "e plurubus enum");
        fishmonger.setMapSymbol("fishmonger");
        //obligatory.setBlocked(false);
        fishmonger.setTravelTime(35);
        scenes[SceneType.fishmonger.ordinal()] = fishmonger;
        
       
        
        return scenes;
    }
    
    
}
