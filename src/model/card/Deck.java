package model.card;

import engine.GameManager;
import engine.board.BoardManager;
import model.card.standard.*;
import model.card.wild.Burner;
import model.card.wild.Saver;
import model.player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private static final String CARDS_FILE = "Cards.csv";
    private static ArrayList<Card> cardsPool = new ArrayList<>();
    private ArrayList<Card> cards;
    private GameManager gameManager;

    public Deck(ArrayList<Card> cards, GameManager gameManager) {
        this.cards = new ArrayList<>();
        if(cards != null) {
            this.cards.addAll(cards);
        }
        this.gameManager = gameManager;
        dealInitialCards();
    }

    public static void loadCardPool(BoardManager boardManager, GameManager gameManager) throws IOException {
        cardsPool = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(CARDS_FILE));
        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int code = Integer.parseInt(values[0]);
            int frequency = Integer.parseInt(values[1]);
            String name = values[2];
            String description = values[3];

            for (int i = 0; i < frequency; i++) {
                Card card;
                if (code == 14) {
                    card = new Burner(name, description, boardManager, gameManager);
                } else if (code == 15) {
                    card = new Saver(name, description, boardManager, gameManager);
                } else {
                    Suit suit = Suit.valueOf(values[5]);
                    if (code == 0) {
                        int rank = Integer.parseInt(values[4]);
                        card = new Standard(name, description, rank, suit, boardManager, gameManager);
                    } else {
                        switch (code) {
                            case 1:
                                card = new Ace(name, description, suit, boardManager, gameManager);
                                break;
                            case 13:
                                card = new King(name, description, suit, boardManager, gameManager);
                                break;
                            case 12:
                                card = new Queen(name, description, suit, boardManager, gameManager);
                                break;
                            case 11:
                                card = new Jack(name, description, suit, boardManager, gameManager);
                                break;
                            case 10:
                                card = new Ten(name, description, suit, boardManager, gameManager);
                                break;
                            case 7:
                                card = new Seven(name, description, suit, boardManager, gameManager);
                                break;
                            case 5:
                                card = new Five(name, description, suit, boardManager, gameManager);
                                break;
                            case 4:
                                card = new Four(name, description, suit, boardManager, gameManager);
                                break;
                            default:
                                continue;
                        }
                    }
                }
                cardsPool.add(card);
            }
        }
        br.close();
    }

    public static ArrayList<Card> drawCards() {
        Collections.shuffle(cardsPool);
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 4 && !cardsPool.isEmpty(); i++) {
            hand.add(cardsPool.remove(0));
        }
        return hand;
    }

    private void dealInitialCards() {
        if (gameManager == null) {
            return;
        }

        if (cards == null || cards.isEmpty()) {
            cards = drawCards(); // Draw new cards if cards list is empty
        }

        for (Player player : gameManager.getPlayers()) {
            ArrayList<Card> playerCards = drawCards();
            player.setHand(playerCards);
        }
    }



}