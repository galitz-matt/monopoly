package org.monopoly;

import java.util.List;

public class Property {
    private final String id;
    private final String name;
    private final PropertyType propertyType;
    private final int price;
    private final List<Integer> rentList;
    private final int mortgageValue;
    private final int buildingCost;
    private Player owner;

    public Property(String id, String name, PropertyType propertyType, int price,
                    List<Integer> rentList, int mortgageValue, int buildingCost) {
        this.id = id;
        this.name = name;
        this.propertyType = propertyType;
        this.price = price;
        this.rentList = rentList;
        this.mortgageValue = mortgageValue;
        this.buildingCost = buildingCost;
    }

    public String ID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public int getPrice() {
        return price;
    }

    public int getBuildingCost() {
        return buildingCost;
    }

    public int getMortgageValue() {
        return mortgageValue;
    }

    public List<Integer> getRentList() {
        return rentList;
    }

    public String getOwner() { return owner.getName();}

    public void setOwner(Player player) { owner = player; }
}
