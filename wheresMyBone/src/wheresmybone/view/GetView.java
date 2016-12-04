/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheresmybone.view;

import java.io.Serializable;

/**
 *
 * @author tCalder
 */
public class GetView {
    
    public static View getSceneView(String mapSymbol) {
        switch(mapSymbol){
            case "PK":
                return new ParkView();
            case "VH":
                return new VacantHouseSceneView();
            case "PS":
                return new PoliceStationView();
            case "AH":
                return new AnimalHospitalView();
            case "PD":
                return new PoundView();
            case "BK":
                return new BakeryView();
            case "RS":
                return new RestaurantView();
            case "DI":
                return new DriveInView() {};
            case "PN":
                return new PondView();
            case "AL":
                return new AlleyView();
            case "CH":
                return new CareHomeView();
            case "NH":
                return new NeighborsHouseView();
            case "YH":
                return new EnterYourHouseView();
            case "DH":
                return new DeVilsHouseView();
            case "GH":
                return new GroceryWarehouseView();
            case "ZO":
                return new ZooView();
            case "EL":
                return new ElephantsView();
            case "TG":
                return new TigersView();
            case "GR":
                return new GorillasView();
            case "GF":
                return new EnterGiraffeView();
            case "SE":
                return new SchoolEntranceView();
            case "SC":
                return new SchoolCafeteriaView();
            case "SP":
                return new SchoolPlaygroundView();
            case "SL":
                return new SchoolParkingLotView();
            case "FM":
                return new FishmongerView();
            default: return null;
        }
    }
    
    
}
