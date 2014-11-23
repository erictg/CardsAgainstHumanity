package backend;

import java.util.*;
import java.io.*;
public class Deck {

	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck(String deckName){
		try {
			readInDeck(deckName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readInDeck(String deckName) throws IOException, FileNotFoundException{
		BufferedReader rd = new BufferedReader(new FileReader("src//decks//" + deckName + ".cah"));
		while(rd.readLine() != null){
			cards.add(new Card(rd.readLine()));
		}
		rd.close();
		
	}
	
}
