package com.nishchith.tictactoe.Strategies.winning;

import com.nishchith.tictactoe.models.Board;
import com.nishchith.tictactoe.models.BoardCell;
import com.nishchith.tictactoe.models.Symbol;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Symbol symbol) {

        // Left to right
        boolean winner = true;
        for (int i = 0; i < board.getSize(); ++i) {
            BoardCell cell = board.getCells().get(i).get(i);
            if (cell.getSymbol() != symbol) {
                winner = false;
                break;
            }

        }
        if (winner) return true;


        for (int i = 0; i < board.getSize(); ++i) {
            winner = true;
            for (int j = board.getSize()-1; j >=0 ; --j) {

                BoardCell cell = board.getCells().get(i).get(j);
                if (cell.getSymbol() != symbol) {
                    winner = false;
                    break;
                }
            }
            if (winner) return true;
        }

        return false;
    }
}
