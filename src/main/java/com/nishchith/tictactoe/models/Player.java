package com.nishchith.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
abstract public class Player {

    private Symbol symbol;

    abstract public BoardCell makeMove(Board board);
}
