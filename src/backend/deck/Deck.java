package backend.deck;
import java.util.ArrayList;
public class Deck {

    private ArrayList<Card> blackCards;
    private ArrayList<Card> whiteCards;

    public Deck(){
        blackCards = new ArrayList<Card>();
        whiteCards = new ArrayList<Card>();
    }

    public void addCard(Card c){
        if(c.getCardType() == CardType.Black){
            blackCards.add(c);
        }else{
            whiteCards.add(c);
        }
    }

    public void deleteCard(Card c){
        if(c.getCardType() == CardType.Black){
            blackCards.remove(c);
        }else{
            whiteCards.remove(c);
        }
    }

}
