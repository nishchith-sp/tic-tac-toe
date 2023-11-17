package com.nishchith.tictactoe.gameexceptions;

public class GameOverException extends RuntimeException {
    public GameOverException() {
        super("Game is already over.");
    }
}
