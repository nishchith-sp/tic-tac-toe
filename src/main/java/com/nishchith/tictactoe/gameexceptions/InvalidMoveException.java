package com.nishchith.tictactoe.gameexceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException() {
        super("Invalid move. Please enter a valid position.");
    }
}
