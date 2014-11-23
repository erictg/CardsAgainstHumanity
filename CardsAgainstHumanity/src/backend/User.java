package backend; 
import java.util.ArrayList;
public class User {

	private String name;
	private int points;
	private String ip;
	private int holderID;
	private boolean cardFuhrer;
	private boolean went;
	
	
	private ArrayList<Card> cards;
	
	public User(){
		name = "";
		points = 0;
		ip = "";
		holderID = -1;
		cardFuhrer = false;
		cards = new ArrayList<Card>();
	}
	
	public User(String name, String ip, int holderID, boolean cardFuhrer){
		this.name = name;
		points = 0;
		this.ip = ip;
		this.holderID = holderID;
		this.cardFuhrer = cardFuhrer;
		cards = new ArrayList<Card>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getHolderID() {
		return holderID;
	}

	public void setHolderID(int holderID) {
		this.holderID = holderID;
	}

	public boolean isCardFuhrer() {
		return cardFuhrer;
	}

	public void setCardFuhrer(boolean cardFuhrer) {
		this.cardFuhrer = cardFuhrer;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public void clearDeck(){
		cards.clear();
	}
	
	public void addCard(Card c){
		cards.add(c);
	}
	
	public Card removeCard(int cardID){

		for(int x = 0; x < cards.size(); x++){
			if(cards.get(x).getCardID() == cardID){
				return cards.remove(x);
			}
		}
		return null;
	}
	
	public int getDeckSize(){
		return cards.size();
	}
	
	public void setDeckMax(int maxSize){
		cards.ensureCapacity(maxSize);
	}

	
	public boolean hasWent() {
		return went;
	}

	public void setWent(boolean went) {
		this.went = went;
	}
}
