package backend;

public class Card {

	private String text;
	private int holderID;
	private int cardID;
	
	public Card(String text, int cardID){
		this.text = text;
		holderID = -1;
		this.cardID = cardID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getHolderID() {
		return holderID;
	}

	public void setHolderID(int holderID) {
		this.holderID = holderID;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}
}
