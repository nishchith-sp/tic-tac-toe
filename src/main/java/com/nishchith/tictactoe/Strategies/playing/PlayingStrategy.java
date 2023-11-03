package com.nishchith.tictactoe.Strategies.playing;

import com.nishchith.tictactoe.models.Board;
import com.nishchith.tictactoe.models.BoardCell;

public interface PlayingStrategy {
    BoardCell makeMove(Board board);
}
