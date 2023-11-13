import org.junit.jupiter.api.Test;
import org.monopoly.GameBoard;
import org.monopoly.JSONReader;

public class GameBoardTest {

    @Test
    public void getTileAtPositionTest() {
        var gb = GameBoard.getInstance();
        gb.createBoard(new JSONReader());
        for (int i = 0; i < 40; i++) {
            System.out.println(gb.getTileAtPosition(i).ID());
        }
    }
}
