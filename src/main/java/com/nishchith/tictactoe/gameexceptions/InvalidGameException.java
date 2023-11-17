package com.nishchith.tictactoe.gameexceptions;

public class InvalidGameException extends RuntimeException {
    public InvalidGameException() {
        super("Invalid Game. Game must have 2 players.");
    }
}
