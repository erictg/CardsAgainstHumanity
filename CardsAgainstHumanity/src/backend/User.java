package backend;

public class User {

	private String name;
	private int points;
	private String ip;
	private int holderID;
	private boolean cardFuhrer;
	
	public User(){
		name = "";
		points = 0;
		ip = "";
		holderID = -1;
		cardFuhrer = false;
	}
	
	public User(String name, String ip, int holderID, boolean cardFuhrer){
		this.name = name;
		points = 0;
		this.ip = ip;
		this.holderID = holderID;
		this.cardFuhrer = cardFuhrer;
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
}
