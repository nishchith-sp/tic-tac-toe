import com.nishchith.tictactoe.Strategies.playing.DefaultPlayingStrategy;
import com.nishchith.tictactoe.models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.List;

public class TicTacToeTest {

    private Game game;

    @Before
    public void setUp() {
        this.game = createGame();
    }

    private Game createGame() {

        HumanPlayer human = HumanPlayer
                .builder()
                .symbol(Symbol.O)
                .user(new User("Uname","uname@email.com","Photo"))
                .build();

        BotPlayer bot = BotPlayer
                .builder()
                .symbol(Symbol.X)
                .playingStrategy(new DefaultPlayingStrategy())
                .build();

        Game game = Game.getBuilder()
                .withSize(3)
                .withPlayer(human)
                .withPlayer(bot)
                .build();

        return game;
    }

    @Test
    public void testBoard(){

    }

    @Test
    public void testDimensions() {

        List<List<BoardCell>> cells = game.getBoard().getCells();
        assertEquals("If board is created, number of rows should be equal to input", 3, cells.size());

        List<BoardCell> firstRow = cells.get(0);
        assertEquals("If board is created, number of columns should be equal to input", 3, firstRow.size());

    }
}
