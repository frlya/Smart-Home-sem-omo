package cz.fel.cvut.omo.fraloilyMaksidan.reports.reportTransactions;

import cz.fel.cvut.omo.fraloilyMaksidan.activities.ConsumingActivity;

/**
 * Used in reports to transfer information from an entity.
 */
public class ConsumptionTransaction {
    private final ConsumingActivity activity;
    private int electricity;
    private int gas;
    private int water;

    public ConsumptionTransaction(ConsumingActivity activity, int electricity, int gas, int water) {
        this.activity = activity;
        this.electricity = electricity;
        this.gas = gas;
        this.water = water;
    }


    public ConsumingActivity getActivity() {
        return activity;
    }

    public int getElectricity() {
        return electricity;
    }

    public int getGas() {
        return gas;
    }

    public int getWater() {
        return water;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public void setWater(int water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "tr: [" + gas + " " + water + " " +electricity + "]";
    }
}
