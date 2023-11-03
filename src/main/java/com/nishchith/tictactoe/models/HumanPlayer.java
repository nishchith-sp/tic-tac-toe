package com.nishchith.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HumanPlayer extends Player {

    private User user;

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("Enter row and column");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new BoardCell(row, column, getSymbol());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        HumanPlayer player;

        private Builder() {
            this.player = new HumanPlayer();
        }

        public Builder user(User user) {
            this.player.user = user;
            return this;
        }

        public Builder symbol(Symbol symbol) {
            this.player.setSymbol(symbol);
            return this;
        }

        public HumanPlayer build() {
            return this.player;
        }


    }
}
