package ch.iet_gibb.heatcalculatorfx.model;

import ch.iet_gibb.heatcalculatorfx.Property.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Software zur Berechnung von Wärmekanister
 * @author Ivo Kamek Krämer
 * @version 1.0.1
 * @since 15.08.2024
 */
public class UnknownTank extends SuperTank{


    /** Konstruktor von UnknownTank
     * @param maxTemperature
     * @param name
     * @param requiredEnergyPerDay
     * */
    public UnknownTank(Double liter, Double maxTemperature, String name, Double requiredEnergyPerDay) {
        this.maxTemperature = maxTemperature;
        this.name = name;
        this.requiredEnergyPerDay = requiredEnergyPerDay;
        this.liter = liter;
    }
    /** Konstruktor von UnknownTank ohne Parameter
     * */
    public UnknownTank() {
    }

    @Override
    public double volumeCalculator(double width, double height) {
        return this.liter;
    }

    /** Methode zur Ausgabe des Tanks
     * @return Ausgabe des Tanks
     * */
    @Override
    public String toString() {
        return "Tank{" +
                "name='" + name + '\'' + '\n'+
                "requiredEnergyPerDay=" + requiredEnergyPerDay + '\n'+
                "maxTemperature=" + maxTemperature + '\n'+
                "liter=" + liter + '\n'+
                "storedEnergy=" + calculateStoredEnergy() + '\n'+
                "daysOfHeating=" + calculateDaysOfHeating() + '\n'+
                '}';
    }
    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        properties.add(new Property("Name", name));
        properties.add(new Property("Required Energy Per Day", requiredEnergyPerDay.toString()));
        properties.add(new Property("Max Temperature", maxTemperature.toString()));
        properties.add(new Property("Liter", liter.toString()));
        properties.add(new Property("Stored Energy", String.valueOf(calculateStoredEnergy())));
        properties.add(new Property("Days of Heating", String.valueOf(calculateDaysOfHeating())));
        return properties;
    }

    @Override
    public String getTitle() {
        return "Unknown Tank";
    }
}