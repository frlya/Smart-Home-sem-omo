package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances.consumptions;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.ConsumptionType;

public class ElectricityConsumption extends Consumption{
    public ElectricityConsumption(int perStep) {
        super(ConsumptionType.ELECTRICITY, perStep);
    }
}