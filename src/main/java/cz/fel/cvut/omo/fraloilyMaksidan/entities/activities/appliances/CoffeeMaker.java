package cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions.ElectricityConsumption;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.activities.appliances.consumptions.WaterConsumption;
import cz.fel.cvut.omo.fraloilyMaksidan.entities.enums.Durability;

import java.util.List;

public class CoffeeMaker extends ApplianceActivity {

    public CoffeeMaker() {
        super("CoffeeMaker3000",
                2,
                Durability.NORMAL,
                List.of(new ElectricityConsumption(5), new WaterConsumption(2)),
                List.of(new ElectricityConsumption(1))
        );
    }
}
