package org.monopoly;

import java.util.List;

public class Property {

    private final String id;
    private final String name;
    private final PropertyType propertyType;
    private final int price;
    private final List<Integer> rent;
    private final int mortgageValue;
    private final List<Integer> constructionPrices;

    private final int NO_MONOPOLY = 0;
    private final int WITH_MONOPOLY = 1;
    private final int WITH_HOTEL = 6;

    public Property(String id, String name, PropertyType propertyType, int price, List<Integer> rent, int mortgageValue) {
        this.id = id;
        this.name = name;
        this.propertyType = propertyType;
        this.price = price;
        this.rent = rent;
        this.mortgageValue = mortgageValue;
    }

    public Property(String id, String name, PropertyType propertyType, int price, List<Integer> rent, int mortgageValue, List<Integer> constructionPrices) {
        this.id = id;
        this.name = name;
        this.propertyType = propertyType;
        this.price = price;
        this.rent = rent;
        this.mortgageValue = mortgageValue;
        this.constructionPrices = constructionPrices;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public int getPrice() {
        return price;
    }

    public List<Integer> getConstructionPrices() {
        return constructionPrices;
    }

    public int getMortgageValue() {
        return mortgageValue;
    }

    public int getRent() {
        return rent.get(NO_MONOPOLY);
    }

    public int getRentWithMonopoly() {
        return rent.get(WITH_MONOPOLY);
    }

    public int getRentWithHouses(int numHouses) {
        if (numHouses < 0 || numHouses > 4) {
            var errorMessage = String.format("Invalid number of houses: %d", numHouses);
            throw new ArrayIndexOutOfBoundsException(errorMessage);
        }
        return rent.get(WITH_MONOPOLY + numHouses);
    }

    public int getRentWithHotel() {
        return rent.get(WITH_HOTEL);
    }
}
