package com.nishchith.tictactoe.Strategies.playing;

import com.nishchith.tictactoe.gameexceptions.GameOverException;
import com.nishchith.tictactoe.models.Board;
import com.nishchith.tictactoe.models.BoardCell;

import java.util.List;

public class DefaultPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {

        // Get the available cells
        List<BoardCell> emptyCells = board.getEmptyCells();

        if(emptyCells.isEmpty()){
            throw new GameOverException();
        }

        // Find first cell
        BoardCell boardCell = emptyCells.stream().findFirst().get();

        // Return the first cell
        return new BoardCell(boardCell.getRow(), boardCell.getColumn(),boardCell.getSymbol());
    }
}

