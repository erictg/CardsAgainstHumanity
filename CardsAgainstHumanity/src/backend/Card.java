package backend;

public class Card {

	private String text;
	private int holderID;
	
	public Card(String text){
		this.text = text;
		holderID = -1;
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
}
