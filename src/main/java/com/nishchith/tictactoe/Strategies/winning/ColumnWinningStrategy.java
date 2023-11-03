package com.nishchith.tictactoe.Strategies.winning;

import com.nishchith.tictactoe.models.Board;
import com.nishchith.tictactoe.models.BoardCell;
import com.nishchith.tictactoe.models.Symbol;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol symbol) {

        for(int i =0 ;i<board.getSize();++i){
            boolean winner = true;
            for(int j =0 ;j<board.getSize();++j){

                BoardCell cell = board.getCells().get(j).get(i);
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
