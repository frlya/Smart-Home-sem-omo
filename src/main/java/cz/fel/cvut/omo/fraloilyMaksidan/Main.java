package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.Father;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.Grandad;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.CoffeeMaker;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.staff.RepairKit;
import cz.fel.cvut.omo.fraloilyMaksidan.house.House;
import cz.fel.cvut.omo.fraloilyMaksidan.house.HouseBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.house.Window;
import cz.fel.cvut.omo.fraloilyMaksidan.house.floor.FloorBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.house.room.RoomBuilder;
import cz.fel.cvut.omo.fraloilyMaksidan.senzors.SunSensor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
            Configure context of application:
            Weather events, report classes...
         */
        var context = Context.getInstance();
        context.setLightLevel(95);
        context.setHumidityLevel(95);

        /*
            New appliances is created as separate classes...
         */
        var coffee3000 = new CoffeeMaker();
        var repairKit = new RepairKit();
        /*
            List of activities is passed to the person...
         */
        var me = new Grandad("Ilya", List.of(
                coffee3000
        ));

        var otherMe = new Father("Dan", List.of(
                coffee3000, repairKit
        ));

        /*
            Builders are provided for structures of house: rooms, floors and co on...
         */
        var kitchen = new RoomBuilder()
                .setName("Kitchen")
                .setEntity(me)
                .setActivity(coffee3000)
                .setActivity(repairKit)
                .setEntity(otherMe)
                .getResult();

        var floor = new FloorBuilder()
                .setFloorNumber(1)
                .addRoom(kitchen)
                .initRooms()
                .getResult();

        var windowInTheKitchen = new Window();


        /*
            Sensors are EventManagers, that are responding to context changes.
            For example, we can subscribe window for changing light level.
            Based on light level window can change its internal state...
         */
        var sunSensor = new SunSensor("LightUp", "LightDown");
        sunSensor.subscribe("LightUp", windowInTheKitchen);
        sunSensor.subscribe("LightDown", windowInTheKitchen);

        var house = new HouseBuilder()
                .setAddress("Street Lane 69")
                .addFloor(floor)
                .initFloors()
                .addSensor(sunSensor)
                .getResult();

        /*
            World Class is a wrapper around house class to provide different simulations...
         */
        World w1 = new World(house);
        w1.startSimulation(30);

        /*
            Reports are used to deliver different info based on the demand;
         */
        var reports = context.getReports();
        System.out.println();
        reports.getActivityReporter().EntityToActivityMapping();
        System.out.println();
        reports.getEventReport().eventsBySource();
        System.out.println();
        reports.getHouseConfigurationReport().getConfiguration();
        System.out.println();
        reports.getConsumptionReport().getAllConsumptions();
        System.out.println();
    }
}
