package engine;

import engine.board.Board;
import model.Colour;
import model.card.Card;
import model.card.Deck;
import model.player.CPU;
import model.player.Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Game implements GameManager {
    private final Board board;
    private final ArrayList<Player> players;
    private Deck deck;
    private final ArrayList<Card> firePit;
    private int currentPlayerIndex;
    private int turn;

    public Game(String playerName) throws IOException {
        // Initialize colors randomly
        ArrayList<Colour> colours = new ArrayList<>();
        Collections.addAll(colours, Colour.values());
        Collections.shuffle(colours); // Randomly assign colors to players

        // Create game board with shuffled colors
        this.board = new Board(colours, this);

        // Load card deck
        Deck.loadCardPool(board, this);

        // Initialize players list
        this.players = new ArrayList<>();

        // Add human player with first color
        players.add(new Player(playerName, colours.get(0)));

        // Add 3 CPU players with remaining colors
        for (int i = 1; i < 4; i++) {
            players.add(new CPU("CPU " + i, colours.get(i), board));
        }

        // Draw 4 cards for each player
        for (Player player : players) {
            ArrayList<Card> hand = Deck.drawCards();
            player.getHand().addAll(hand);
        }


        // Initialize game state
        this.firePit = new ArrayList<>();  // Storage for burned cards
        this.currentPlayerIndex = 0;       // Human player goes first
        this.turn = 0;                     // Start at turn 0
    }

    //getFirePit() method
    public ArrayList<Card> getFirePit() {
        return firePit;
    }

    //getBoard() method
    public Board getBoard() {
        return board;
    }

    //getPlayers() method
    public ArrayList<Player> getPlayers() {
        return players;
    }
}