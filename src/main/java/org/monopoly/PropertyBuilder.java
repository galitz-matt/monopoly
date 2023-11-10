package org.monopoly;

import java.util.List;

import static org.monopoly.PropertyType.*;

public class PropertyBuilder {

    private String id;
    private String name;
    private PropertyType propertyType;
    private int price;
    private List<Integer> rent;
    private int mortgageValue;
    private int buildingCost;

    public Property getProperty() {
        return new Property(id, name, propertyType, price, rent, mortgageValue, buildingCost);
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRent(List<Integer> rent) {
        this.rent = rent;
    }

    public void setMortgageValue(int mortgageValue) {
        this.mortgageValue = mortgageValue;
    }

    public void setBuildCost(int buildingCost) {
        this.buildingCost = buildingCost;
    }
}
