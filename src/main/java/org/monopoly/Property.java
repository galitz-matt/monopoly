package org.monopoly;

import java.util.List;

public class Property implements Tile {

    private final PropertyType propertyType;
    private final int price;
    private final List<Integer> rent;
    private final List<Integer> constructionPrices;
    private final int mortgageValue;

    private final int NO_MONOPOLY = 0;
    private final int WITH_MONOPOLY = 1;
    private final int WITH_HOTEL = 6;

    public Property(PropertyType propertyType, int price, List<Integer> rent, int mortgageValue) {
        this.propertyType = propertyType;
        this.price = price;
        this.rent = rent;
        this.mortgageValue = mortgageValue;
        this.constructionPrices = null;
    }

    public Property(PropertyType propertyType, int price, List<Integer> rent, List<Integer> constructionPrices, int mortgageValue) {
        this.propertyType = propertyType;
        this.price = price;
        this.rent = rent;
        this.constructionPrices = constructionPrices;
        this.mortgageValue = mortgageValue;
    }

    public void interact() {

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
