package main;
import backend.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@SuppressWarnings("unused")
		//GUI g = new GUI();
		Deck d = null;
		try {
		d = XMLcontrol.deserializeDeck();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d.getDeckName() + " " + d.getTypeID());
		
		
	}

}
