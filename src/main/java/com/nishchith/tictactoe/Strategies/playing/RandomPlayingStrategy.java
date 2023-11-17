package com.nishchith.tictactoe.Strategies.playing;

import com.nishchith.tictactoe.gameexceptions.GameOverException;
import com.nishchith.tictactoe.models.Board;
import com.nishchith.tictactoe.models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {
        // Output -> A cell from the list of available cells

        // Get a list of empty cells
        List<BoardCell> emptyCells = board.getEmptyCells();

        if(emptyCells.isEmpty()){
            throw new GameOverException();
        }

        // Generate a random index for the cells
        int randomIndex = (int) (Math.random() * emptyCells.size());

        // Return the random cell
        BoardCell boardCell = emptyCells.get(randomIndex);
        return new BoardCell(boardCell.getRow(), boardCell.getColumn(),boardCell.getSymbol());
    }
}

