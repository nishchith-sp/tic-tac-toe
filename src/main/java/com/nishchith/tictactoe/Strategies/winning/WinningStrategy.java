package com.nishchith.tictactoe.Strategies.winning;

import com.nishchith.tictactoe.models.Board;
import com.nishchith.tictactoe.models.Symbol;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Symbol symbol);
}
