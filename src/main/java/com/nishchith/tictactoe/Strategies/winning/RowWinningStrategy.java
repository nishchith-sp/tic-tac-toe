package com.nishchith.tictactoe.Strategies.winning;

import com.nishchith.tictactoe.models.Board;
import com.nishchith.tictactoe.models.BoardCell;
import com.nishchith.tictactoe.models.Symbol;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol symbol) {

        for(List<BoardCell> rows:board.getCells()){
            boolean winner = true;

            for(BoardCell cell:rows){

                if(cell.getSymbol() != symbol){
                    winner = false;
                    break;
                }
            }

            if(winner) return true;
        }

        return false;
    }
}
