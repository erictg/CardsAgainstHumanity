package main;

import javax.swing.*;

public class GUI{

	//statics
	public static String creators = "CREATED BY ERIC SOLENDER, BRADLEY HENRY, AND ALEX HEPPNER";
	//main frame
	JFrame mainFrame = new JFrame("DeckMaker");
	
	MainScreen mainScreen;
	public GUI(){
		mainScreen = new MainScreen(this);
		mainFrame.add(mainScreen.getMainScreen());
		mainFrame.setVisible(true);
	}
	
}
