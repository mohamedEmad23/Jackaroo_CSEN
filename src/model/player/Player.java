package model.player;

import model.Colour;
import model.card.Card;
import java.util.ArrayList;

public class Player {
    private final String name;
    private final Colour colour;
    private final ArrayList<Card> hand = new ArrayList<>();
    private final ArrayList<Marble> marbles = new ArrayList<>();
    private Card selectedCard;
    private final ArrayList<Marble> selectedMarbles = new ArrayList<>();

    public Player(String name, Colour colour) {
        this.name = name;
        this.colour = colour;
        for (int i = 0; i < 4; i++) {
            marbles.add(new Marble(colour));
        }
    }

    // Getters
    public String getName() { return name; }
    public Colour getColour() { return colour; }
    public ArrayList<Card> getHand() { return hand; }

    public ArrayList<Card> setHand(ArrayList<Card> hand) {
        this.hand.clear();
        this.hand.addAll(hand);
        return this.hand;
    }

    public ArrayList<Marble> getMarbles() { return marbles; }
    public Card getSelectedCard() { return selectedCard; }

    //addCard() method
    public void addCard(Card card) {
        hand.add(card);
    }
}