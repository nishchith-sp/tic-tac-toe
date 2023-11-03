package com.nishchith.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCell {
    int row;
    int column;
    Symbol symbol;

    public BoardCell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
