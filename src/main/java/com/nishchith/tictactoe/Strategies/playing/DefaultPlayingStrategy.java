package com.nishchith.tictactoe.Strategies.playing;

import com.nishchith.tictactoe.models.Board;
import com.nishchith.tictactoe.models.BoardCell;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {

        // Get the available cells

        // Generate a random number with the size of the available cells

        // Return the random cell


        //Flatten all cells
        List<BoardCell> cells = flattenBoardCells(board);

        // Get empty cell
        List<BoardCell> emptyCells = cells.stream().filter(cell -> cell.getSymbol() != null).toList();

        if(emptyCells.isEmpty()){
            throw new RuntimeException("");
        }

        //Find first cell
        BoardCell cell = emptyCells.stream().findFirst().get();



        return cell;
    }

    private List<BoardCell> flattenBoardCells(Board board) {
        List<List<BoardCell>> cells = board.getCells();

        return cells.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

    }
}

