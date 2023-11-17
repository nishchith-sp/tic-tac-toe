package com.nishchith.tictactoe;

import com.nishchith.tictactoe.Strategies.playing.RandomPlayingStrategy;
import com.nishchith.tictactoe.gameexceptions.GameOverException;
import com.nishchith.tictactoe.gameexceptions.InvalidGameException;
import com.nishchith.tictactoe.gameexceptions.InvalidMoveException;
import com.nishchith.tictactoe.models.*;

import java.util.Scanner;

public class Main {

    private static final int BOARD_SIZE = 3;

    public static void main(String[] args) {
        System.out.print("Hello and welcome to TicTacToe!");

        // Ask for user input - name, email and Symbol
        HumanPlayer human = getUserInput();

        // Create a game
        Game game = createGame(human);
        game.start();

        // Iteratively call make move
        // Until -> Game is WON or DRAWN

        while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
            try {
                Player player = game.getNextPlayer();
                System.out.println("Next player: " + player.getSymbol());

                game.makeMove();
                game.getBoard().printBoard();
            } catch (GameOverException | InvalidGameException | InvalidMoveException e) {
                game.getBoard().printBoard();
                System.out.println(e.getMessage());
            }
        }

        // Start playing
        //

        if (game.getGameStatus() == GameStatus.FINISHED) {
            System.out.println("***********************");
            System.out.println("*** Congratulations ***");
            System.out.println("Game won by player: " + game.getWinner().getSymbol());
            System.out.println("***********************");
        }

        if (game.getGameStatus() == GameStatus.DRAW) {
            System.out.println("***********************");
            System.out.println("*** Oh, Its a DRAW. ***");
            System.out.println("***********************");
        }
    }

    private static Game createGame(HumanPlayer humanPlayer) {
        // Task 1 - To take user input for the type of bot

        // Type of game: H vs H or H vs B
        // Task 2 - Ask user for the type of game
        return Game.getBuilder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(
                        BotPlayer.builder()
                                .symbol(decideBotSymbol(humanPlayer.getSymbol()))
                                .level(GameLevel.EASY)
                                .playingStrategy(new RandomPlayingStrategy())
                                .build()
                )
                .build();
    }

    // Get the list of all symbols
    // Filter out the user's symbol
    // Randomly select one from the list
    private static Symbol decideBotSymbol(Symbol symbol) {
        if (symbol == Symbol.O) {
            return Symbol.X;
        }

        return Symbol.O;
    }

    private static HumanPlayer getUserInput() {

        // Also ask the user for the type of bot

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");

        String name = scanner.nextLine();

        System.out.println("Enter email");
        String email = scanner.nextLine();

        System.out.println("Enter symbol (O or X):");
        Symbol symbol;
        try {
            symbol = Symbol.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        User user = new User(name, email, null);

        return HumanPlayer
                .builder()
                .symbol(symbol)
                .user(user)
                .build();

    }
}