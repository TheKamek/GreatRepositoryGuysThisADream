package ch.iet_gibb.heatcalculatorfx.model;

import ch.iet_gibb.heatcalculatorfx.Property.Property;

import java.util.ArrayList;
import java.util.List;

public abstract class SuperTank implements InterfaceTank {
    /** Bezeichnung des Namen des Tank */
    String name;
    /** Bezeichnung der Energie welche der Tank jeden Tag nutzt */
    Double requiredEnergyPerDay;
    /** Bezeichnung der Temperatur des Tanks */
    Double maxTemperature;
    /** Bezeichnung der Grösse des Tanks */
    Double liter;

    /**
     * @return Name des tankes
     */
    public String getName() {
        return name;
    }
    /**
     * @param name Name des tankes
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return Energie welche der Tank jeden Tag braucht
     */

    public Double getRequiredEnergyPerDay() {
        return requiredEnergyPerDay;
    }
    /**
     * @param requiredEnergyPerDay Energie welche der Tank jeden Tag braucht
     */

    public void setRequiredEnergyPerDay(Double requiredEnergyPerDay) {
        this.requiredEnergyPerDay = requiredEnergyPerDay;
    }
    /**
     * @return Maximale Temperatur des Tankes
     */

    public Double getMaxTemperature() {
        return maxTemperature;
    }
    /**
     * @param maxTemperature Maximale Temperatur des Tankes
     */
    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
    /**
     * @return Grösse des Tanks
     */
    public Double getLiter() {
        return liter;
    }
    /**
     * @param liter Grösse des Tanks
     */
    public void setLiter(Double liter) {
        this.liter = liter;
    }

    /** Methode zur Berechnung der gespeicherten Energie
     * @return gespeicherte Energie
     * */
    public double calculateStoredEnergy() {
        double specificHeatCapacityWater = 4.186;
        return liter * specificHeatCapacityWater * maxTemperature;
    }
    /** Methode zur Berechnung des Volumens
     * @return Volumen
     * */
    public abstract double volumeCalculator(double width, double height);

    /** Methode zur Berechnung der Heiztage
     * @return Heiztage
     * */
    public double calculateDaysOfHeating() {
        double storedEnergy = calculateStoredEnergy();
        return storedEnergy / requiredEnergyPerDay;
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
        properties.add(new Property("Name", name));
        properties.add(new Property("Required Energy Per Day", requiredEnergyPerDay.toString()));
        properties.add(new Property("Max Temperature", maxTemperature.toString()));
        properties.add(new Property("Liter", liter.toString()));
        properties.add(new Property("Stored Energy", String.valueOf(calculateStoredEnergy())));
        properties.add(new Property("Days of Heating", String.valueOf(calculateDaysOfHeating())));
        return properties;
    }
}
