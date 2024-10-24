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
public class CylinderTank extends SuperTank{
    /** Bezeichnung der Breite des Tank */
    Double width;
    /** Bezeichnung der Höhe des Tank */

    Double height;

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    /** Konstruktor von CylinderTank
     * @param maxTemperature
     * @param name
     * @param requiredEnergyPerDay
     * @param width
     * @param height
     * */
    public CylinderTank(Double maxTemperature, String name, Double requiredEnergyPerDay, Double width, Double height) {
        this.maxTemperature = maxTemperature;
        this.name = name;
        this.requiredEnergyPerDay = requiredEnergyPerDay;
        this.width = width;
        this.height = height;
        this.liter = volumeCalculator(width, height);
    }
    /** Methode zur Berechnung des Volumens
     * @param radius Radius des Tanks
     * @param height Höhe des Tanks
     * @return Volumen des Tanks
     * */
    @Override
    public double volumeCalculator(double radius, double height) {
        return (radius / 2 * (radius / 2)) * 3.14 * height;
    }
    public CylinderTank(){}
    @Override
    public String toString() {
        return "Tank{" +
                "name='" + name + '\'' + '\n'+
                "requiredEnergyPerDay=" + requiredEnergyPerDay + '\n'+
                "maxTemperature=" + maxTemperature + '\n'+
                "liter=" + liter + '\n'+
                "storedEnergy=" + calculateStoredEnergy() + '\n'+
                "daysOfHeating=" + calculateDaysOfHeating() + '\n'+
                "width=" + width + '\n'+
                "height=" + height + '\n'+
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
        properties.add(new Property("Width", width.toString()));
        properties.add(new Property("Height", height.toString()));
        return properties;
    }

    @Override
    public String getTitle() {
        return "Cylinder Tank";
    }
}