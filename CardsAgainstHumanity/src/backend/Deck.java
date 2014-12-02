package backend;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Deck {

	private int typeID;
	private String deckName;
	private ArrayList<String> cards = new ArrayList<String>();
	private File file;
	public static final int BLACK_CARD = 0;
	public static final int WHITE_CARD = 0;
	
	public Deck(){
		typeID = 0;
		deckName = "";
		setFile(null);
		//addCard("default");
	}
	public Deck(int typeID, String deckName, File f){
		this.typeID = typeID;
		this.deckName = deckName;
		setFile(f);
	}
	
	public Deck(int typeID, String deckName, File f, ArrayList<String> cards){
		this.typeID = typeID;
		this.deckName = deckName;
		this.cards = cards;
		setFile(f);
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
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
