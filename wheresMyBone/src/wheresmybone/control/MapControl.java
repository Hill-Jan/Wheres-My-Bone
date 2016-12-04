/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.control;

import java.io.Serializable;
import wheresmybone.control.MapControl.SceneType;
import wheresmybone.exceptions.MapControlException;
import wheresmybone.model.Map;
import wheresmybone.model.Npc.Npcs;
import wheresmybone.model.Scene;
import wheresmybone.view.YourHouseView;

/**
 *
 * @author Jan
 */
public class MapControl {

    private String promptMessage;
    private String name;

    public static Map createMap() {
        Map map = new Map(5, 5);

        Scene[] scenes = createScenes();

        GameControl.assignScenesToLocations(map, scenes);

        return map;
    }

    public static void movePlayerToStartingLocation(Map map) {
        // movePlayer(map, 2, 2);
        movePlayer(map, 2, 2);
        YourHouseView yourHouseView = new YourHouseView();
        yourHouseView.displayYourHouseView();
    }

    public static void movePlayer(Map map, int row, int column) {
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);
        map.setCurrentRow(row);
        map.setCurrentColumn(column);
    }

    public enum SceneType {
        park("The Park", "PK"),
        vacanthouse("Vacant House", "VH"),
        police("Police Station", "PS"),
        animalhospital("Animal Hospital", "AH"),
        pound("The Pound", "PD"),
        bakery("The Bakery", "BK"),
        restaurant("A Restaurant", "RS"),
        drivein("The Drive-In", "DI"),
        pond("The pond", "PN"),
        alley("A back alley", "AL"),
        carehome("The Care Home", "CH"),
        neighborshouse("Your Neigbor's House", "NH"),
        yourhouse("Your House", "YH"),
        devilshouse("Cat DeVil's House", "DH"),
        grocerywarehouse("Grocery Warehouse", "GH"),
        zoo("The Local Zoo", "ZO"),
        elephants("Zoo: Elephants", "EL"),
        tigers("Zoo: Tigers", "TG"),
        gorillas("Zoo: Gorillas", "GR"),
        giraffes("Zoo: Giraffes", "GF"),
        schoolentrance("School Entrance", "SE"),
        schoolcafeteria("School: Cafeteria", "SC"),
        schoolplayground("School: Playground", "SP"),
        schoolparkinglot("School: Parking Lot", "SL"),
        fishmonger("The Fishmonger's Market", "FM");

        private final String sceneName;
        private final String mapSymbol;

        SceneType(String sceneName, String mapSymbol) {
            this.sceneName = sceneName;
            this.mapSymbol = mapSymbol;
        }

        public String getMapSymbol() {
            return this.mapSymbol;
        }

        public String getSceneName() {
            return this.sceneName;
        }
    }

    public static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];

        Scene park = new Scene();
        park.setSceneName("The Park");
        park.setSceneDescript(
                "Trees, pond, swings");
        park.setMapSymbol("PK");
        park.setTravelTime(20);
        park.setNpcDescription(Npcs.Tommy);
        scenes[SceneType.park.ordinal()] = park;

        Scene vacanthouse = new Scene();
        vacanthouse.setSceneName("The Vacant House");
        vacanthouse.setSceneDescript(
                "Vacant House");
        vacanthouse.setMapSymbol("VH");
        vacanthouse.setTravelTime(20);
        scenes[SceneType.vacanthouse.ordinal()] = vacanthouse;

        Scene police = new Scene();
        police.setSceneName("Police");
        police.setSceneDescript(
                "Police Station");
        police.setMapSymbol("PS");
        police.setTravelTime(15);
        scenes[SceneType.police.ordinal()] = police;

        Scene animalhospital = new Scene();
        animalhospital.setSceneName("Animal Hospital");
        animalhospital.setSceneDescript(
                "Animal Hospital");
        animalhospital.setMapSymbol("AH");
        animalhospital.setTravelTime(25);
        scenes[SceneType.animalhospital.ordinal()] = animalhospital;

        Scene pound = new Scene();
        pound.setSceneName("The Pound");
        pound.setSceneDescript(
                "Pound");
        pound.setMapSymbol("PD");
        pound.setTravelTime(30);
        scenes[SceneType.pound.ordinal()] = pound;

        Scene bakery = new Scene();
        bakery.setSceneName("The Bakery");
        bakery.setSceneDescript(
                "Bakery");
        bakery.setMapSymbol("BK");
        bakery.setTravelTime(25);
        scenes[SceneType.bakery.ordinal()] = bakery;

        Scene restaurant = new Scene();
        restaurant.setSceneName("The Restaurant");
        restaurant.setSceneDescript(
                "Restaraunt");
        restaurant.setMapSymbol("RS");
        restaurant.setTravelTime(15);
        scenes[SceneType.restaurant.ordinal()] = restaurant;

        Scene drivein = new Scene();
        drivein.setSceneName("The Drive-In");
        drivein.setSceneDescript(
                "Drive In");
        drivein.setMapSymbol("DI");
        drivein.setTravelTime(25);
        scenes[SceneType.drivein.ordinal()] = drivein;

        Scene pond = new Scene();
        pond.setSceneName("The Pond");
        pond.setSceneDescript(
                "The Pond");
        pond.setMapSymbol("PN");
        pond.setTravelTime(15);
        scenes[SceneType.pond.ordinal()] = pond;

        Scene alley = new Scene();
        alley.setSceneName("The Alley");
        alley.setSceneDescript(
                "Alley");
        alley.setMapSymbol("AL");
        alley.setTravelTime(25);
        scenes[SceneType.alley.ordinal()] = alley;

        Scene carehome = new Scene();
        carehome.setSceneName("The Nursing Home");
        carehome.setSceneDescript(
                "Care Home");
        carehome.setMapSymbol("CH");
        carehome.setTravelTime(20);
        scenes[SceneType.carehome.ordinal()] = carehome;

        Scene neighborshouse = new Scene();
        neighborshouse.setSceneName("The Smith's House");
        neighborshouse.setSceneDescript(
                "Neighbor House");
        neighborshouse.setMapSymbol("NH");
        neighborshouse.setTravelTime(5);
        scenes[SceneType.neighborshouse.ordinal()] = neighborshouse;

        Scene yourhouse = new Scene();
        yourhouse.setSceneName("Your House");
        yourhouse.setSceneDescript(
                "Your House");
        yourhouse.setMapSymbol("YH");
        yourhouse.setTravelTime(0);
        scenes[SceneType.yourhouse.ordinal()] = yourhouse;

        Scene devilshouse = new Scene();
        devilshouse.setSceneName("DeVil's House");
        devilshouse.setSceneDescript(
                "DeVil's House");
        devilshouse.setMapSymbol("DH");
        devilshouse.setTravelTime(5);
        scenes[SceneType.devilshouse.ordinal()] = devilshouse;

        Scene grocerywarehouse = new Scene();
        grocerywarehouse.setSceneName("The Grocery Store Warehouse");
        grocerywarehouse.setSceneDescript(
                "Grocery Warehouse");
        grocerywarehouse.setMapSymbol("GH");
        grocerywarehouse.setTravelTime(25);
        scenes[SceneType.grocerywarehouse.ordinal()] = grocerywarehouse;

        Scene zoo = new Scene();
        zoo.setSceneName("The Zoo Entrance");
        zoo.setSceneDescript(
                "Zoo");
        zoo.setMapSymbol("ZO");
        zoo.setTravelTime(20);
        scenes[SceneType.zoo.ordinal()] = zoo;

        Scene elephants = new Scene();
        elephants.setSceneName("The Elephant Enclosure");
        elephants.setSceneDescript(
                "Elephant");
        elephants.setMapSymbol("EL");
        elephants.setTravelTime(30);
        scenes[SceneType.elephants.ordinal()] = elephants;

        Scene tigers = new Scene();
        tigers.setSceneName("The Tiger Enclosure");
        tigers.setSceneDescript(
                "Tigers");
        tigers.setMapSymbol("TG");
        tigers.setTravelTime(25);
        scenes[SceneType.tigers.ordinal()] = tigers;

        Scene gorillas = new Scene();
        gorillas.setSceneName("The Gorilla Enclosure");
        gorillas.setSceneDescript(
                "Gorillas");
        gorillas.setMapSymbol("GR");
        gorillas.setTravelTime(35);
        scenes[SceneType.gorillas.ordinal()] = gorillas;

        Scene giraffes = new Scene();
        giraffes.setSceneName("The Giraffe Enclosure");
        giraffes.setSceneDescript(
                "Giraffes");
        giraffes.setMapSymbol("GF");
        giraffes.setTravelTime(40);
        scenes[SceneType.giraffes.ordinal()] = giraffes;

        Scene schoolentrance = new Scene();
        schoolentrance.setSceneName("The School Entrance");
        schoolentrance.setSceneDescript(
                "School Entrance");
        schoolentrance.setMapSymbol("SE");
        schoolentrance.setTravelTime(20);
        scenes[SceneType.schoolentrance.ordinal()] = schoolentrance;

        Scene schoolcafeteria = new Scene();
        schoolcafeteria.setSceneName("The School cafeteria");
        schoolcafeteria.setSceneDescript(
                "School Cafeteria");
        schoolcafeteria.setMapSymbol("SC");
        schoolcafeteria.setTravelTime(25);
        scenes[SceneType.schoolcafeteria.ordinal()] = schoolcafeteria;

        Scene schoolplayground = new Scene();
        schoolplayground.setSceneName("The School Playground");
        schoolplayground.setSceneDescript(
                "School Playground");
        schoolplayground.setMapSymbol("SP");
        schoolplayground.setTravelTime(25);
        scenes[SceneType.schoolplayground.ordinal()] = schoolplayground;

        Scene schoolparkinglot = new Scene();
        schoolparkinglot.setSceneName("The School Parking Lot");
        schoolparkinglot.setSceneDescript(
                "School Parking Lot");
        schoolparkinglot.setMapSymbol("SL");
        schoolparkinglot.setTravelTime(20);
        scenes[SceneType.schoolparkinglot.ordinal()] = schoolparkinglot;

        Scene fishmonger = new Scene();
        fishmonger.setSceneName("The Fishmonger Stand");
        fishmonger.setSceneDescript(
                "Fishmonger");
        fishmonger.setMapSymbol("FM");
        fishmonger.setTravelTime(35);
        scenes[SceneType.fishmonger.ordinal()] = fishmonger;

        return scenes;
    }

    public String doMapSymbolSceneName(String value) throws MapControlException {

        value = value.toUpperCase();
        for (SceneType st : SceneType.values()) {
            if (st.getMapSymbol().equals(value)) {
                return ("location is " + st.ordinal() + ". " + "Scene Name is " + st.getSceneName() + "\n");
                //return true;   
            }
            if (value.toUpperCase().equals("X")) // user wants to quit
            {
                return ""; //exit the game
            }
        }

        throw new MapControlException("\nPlease choose a valid Map Symbol\n");

        //return false;
    }
}
