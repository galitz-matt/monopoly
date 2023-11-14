package org.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameBoard {
    private static GameBoard instance;
    private final List<Tile> board;

    private GameBoard() {
        board = createBoard(new JSONReader());
    }

    public static GameBoard getInstance() {
        if (instance == null) {
            instance = new GameBoard();
        }
        return instance;
    }

    public Tile getTileAtPosition(int position) {
        return board.get(position);
    }

    private List<Tile> createBoard(JSONReader jsonReader) {
        var tileIDs = jsonReader.getOrderedIDs();
        var tiles = jsonReader.getAllTiles();
        return tileIDs.stream()
                .map(tiles::get)
                .toList();
    }

    public int findDistanceBetweenTiles(Tile tile1, Tile tile2) {
        var rawDistance = Math.abs(tile1.getPosition() - tile2.getPosition());
        return Math.min(rawDistance, 40 - rawDistance);
    }
}
