package com.nishchith.tictactoe.models;

import com.nishchith.tictactoe.Strategies.winning.ColumnWinningStrategy;
import com.nishchith.tictactoe.Strategies.winning.DiagonalWinningStrategy;
import com.nishchith.tictactoe.Strategies.winning.RowWinningStrategy;
import com.nishchith.tictactoe.Strategies.winning.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {

    private Board board;
    private GameStatus gameStatus;
    private List<Player> players = new ArrayList<>();
    private List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(),new ColumnWinningStrategy(),new DiagonalWinningStrategy());
    private int nextPlayerIndex = 0;
    private Player winner;

    public static Builder getBuilder() {
        return new Builder();
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public void start() {
        // Assign a random value to the nextPlayerIndex
        // Random value -> 0 or 1
        // 0.5 * 2 = 1.0 = 1
        // 0.1 * 2 = 0.2 = 0
        // 0.8 * 2 = 1.6 = 1
        nextPlayerIndex = (int) (Math.random() * players.size());

        // Set the status to IN_PROGRESS
        gameStatus = GameStatus.IN_PROGRESS;
    }

    public void makeMove() {

        BoardCell move = getNextMove();

        // Update the board
        board.update(move);

        // Check if the game is over
        if (checkWinner(move.getSymbol())) {
            gameStatus = GameStatus.FINISHED;
            winner = getNextPlayer();
            return;
        }

        // Check if the game is draw
        if (checkDraw()) {
            gameStatus = GameStatus.DRAW;
            return;
        }

        // Update the next player index
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

    }

    private BoardCell getNextMove() {
        // Get the next player
        Player nextPlayer = getNextPlayer();

        // Get the move from the player. You can use Scanner to get the input from the user
        BoardCell move = nextPlayer.makeMove(board);

        // Validate if the cell is not empty
        // If not, throw a custom exception
        validateMove(move);

        return move;

    }

    private void validateMove(BoardCell move) {
        if (move == null) {
            throw new RuntimeException("");
        }

        if (!board.isEmpty(move.getRow(), move.getColumn())) {
            throw new RuntimeException("");
        }
    }

    private boolean checkWinner(Symbol currentSymbol) {
        // Check rows
        for (WinningStrategy strategy:winningStrategies){
            if(strategy.checkWinner(board,currentSymbol)){
                return true;
            }
        }

        return false;
    }



    private boolean checkDraw() {
        return false;
    }

    public static class Builder {
        private Game game;

        private Builder() {
            this.game = new Game();
        }

        public Builder withSize(int size) {
            Board board = new Board(size);
            this.game.setBoard(board);
            return this;
        }

        public Builder withPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }

        private boolean validate() {
            List<Player> players = game.getPlayers();
            return players.size() <= 2;
        }

        public Game build() {

            boolean isValid = validate();
            if (!isValid) {
                throw new RuntimeException("Game is not valid");
            }

            return this.game;
        }

    }
}
