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
    private final int NO_MONOPOLY = 0;
    private final int WITH_MONOPOLY = 1;
    private final int WITH_HOTEL = 6;

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

    public int getRentList() {
        return rentList.get(NO_MONOPOLY);
    }

    public int getRentWithMonopoly() {
        return rentList.get(WITH_MONOPOLY);
    }

    public int getRentWithHouses(int numHouses) {
        if (numHouses < 0 || numHouses > 4) {
            var errorMessage = String.format("Invalid number of houses: %d", numHouses);
            throw new ArrayIndexOutOfBoundsException(errorMessage);
        }
        return rentList.get(WITH_MONOPOLY + numHouses);
    }

    public int getRentWithHotel() {
        return rentList.get(WITH_HOTEL);
    }
}
