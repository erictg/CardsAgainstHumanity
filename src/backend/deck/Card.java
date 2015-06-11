package backend.deck;

/**
 * Created by Gretchen on 5/24/2015.
 */
public class Card {

    private String cardText;
    private CardType cardType;

    private String userID;
    private String creatorID;

    public Card(){
        cardText = "";
        cardType = CardType.Black;
        userID = "";
        creatorID = "";
    }

    public Card(String cardText, CardType cardType, String userID, String creatorID){
        this.cardText = cardText;
        this.cardType = cardType;
        this.userID = userID;
        this.creatorID = creatorID;
    }

    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    public String getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(String creatorID) {
        this.creatorID = creatorID;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
