package org.monopoly;

import java.util.List;

public class PropertyBuilder {

    private String id;
    private String name;
    private PropertyType propertyType;
    private int price;
    private List<Integer> rentList;
    private int mortgageValue;
    private int buildingCost;

    public Property build() {
        return new Property(id, name, propertyType, price, rentList, mortgageValue, buildingCost);
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

    public void setRentList(List<Integer> rentList) {
        this.rentList = rentList;
    }

    public void setMortgageValue(int mortgageValue) {
        this.mortgageValue = mortgageValue;
    }

    public void setBuildCost(int buildingCost) {
        this.buildingCost = buildingCost;
    }
}
