package com.nishchith.tictactoe.models;

import com.nishchith.tictactoe.Strategies.playing.PlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotPlayer extends Player{

    private GameLevel level;
    private PlayingStrategy playingStrategy;
    @Override
    public BoardCell makeMove(Board board) {
        BoardCell move = playingStrategy.makeMove(board);
        move.setSymbol(getSymbol());

        return move;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        BotPlayer player;

        private Builder(){
            this.player = new BotPlayer();
        }

        public Builder playingStrategy(PlayingStrategy playingStrategy){
            this.player.playingStrategy = playingStrategy;
            return this;
        }

        public Builder symbol(Symbol symbol){
            this.player.setSymbol(symbol);
            return this;
        }

        public Builder level(GameLevel level){
            this.player.setLevel(level);
            return this;
        }

        public BotPlayer build(){
            return this.player;
        }

    }
}
