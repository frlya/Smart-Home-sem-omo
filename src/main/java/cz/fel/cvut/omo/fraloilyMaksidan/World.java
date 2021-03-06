package cz.fel.cvut.omo.fraloilyMaksidan;

import cz.fel.cvut.omo.fraloilyMaksidan.house.House;

/**
 * Simulation driver and context changer.
 */
public class World {

    private House house;

    public World(House house) {
        this.house = house;
        Context.getReports().getHouseConfigurationReport().setHouse(house);
    }

    public void startSimulation(int hours) {
        for (int i = 0; i < hours; ++i) {
            ChangeContext();
            house.moveEntities();
            house.doActivities();
            house.appendConsumptionAndGetContextChange();
            house.activateSensors();
        }
    }

    private void ChangeContext() {
        Context.getCurrentStrategy().changeConditions();
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
