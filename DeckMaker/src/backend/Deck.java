package backend;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Deck {

	private int typeID;
	private String deckName;
	private ArrayList<String> cards = new ArrayList<String>();
	
	public static final int BLACK_CARD = 0;
	public static final int WHITE_CARD = 0;
	
	public Deck(){
		typeID = 0;
		deckName = "";
		//addCard("default");
	}
	public Deck(int typeID, String deckName){
		this.typeID = typeID;
		this.deckName = deckName;
	}
	
	public Deck(int typeID, String deckName, ArrayList<String> cards){
		this.typeID = typeID;
		this.deckName = deckName;
		this.cards = cards;
	}

	public void addCard(String s){
		cards.add(s);
	}
	
	public void removeCard(String s){
		cards.remove(s);
	}
	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}

	public ArrayList<String> getCards() {
		return cards;
	}

	public void setCards(ArrayList<String> cards) {
		this.cards = cards;
	}
}
