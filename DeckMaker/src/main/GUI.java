package main;

import javax.swing.*;

import java.io.File;
public class GUI{

	//statics
	public static String creators = "CREATED BY ERIC SOLENDER, BRADLEY HENRY, AND ALEX HEPPNER";
	//main frame
	JFrame mainFrame = new JFrame("DeckMaker");
		JPanel holderPanel = new JPanel();
		
		
	MainScreen mainScreen;
	OptionsScreen optionsScreen;
	
	//save stuff
	//gets location of where the file is running from
	File saveLocation = new File(System.getProperty("user.dir"));
	
	
	public GUI(){
		mainScreen = new MainScreen(this);
		holderPanel.add(mainScreen.getMainScreen());
		mainFrame.add(holderPanel);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//screen switching
	public static final int SCREENS_MAIN = 0;
	public static final int SCREENS_NEW_DECK = 1;
	public static final int SCREENS_MANAGE_DECKS = 2;
	public static final int SCREENS_CUSTOMIZE_DECK = 3;
	public static final int SCREENS_OPTIONS = 4;
	
	public void switchScreens(int screen){
		switch(screen){
		case SCREENS_MAIN:
			//removes everything from the holder\
			holderPanel.removeAll();
			
			//instantiates main screen
			mainScreen = new MainScreen(this);
			
			//adds main panel of main screen to holderPanel
			holderPanel.add(mainScreen.getMainScreen());
			
			//updates the draw
			holderPanel.updateUI();
			
			System.out.println("changed to main panel");
			break;
		
		case SCREENS_NEW_DECK:
			holderPanel.removeAll();
			holderPanel.add(new JLabel("the fucker worked"));
			holderPanel.updateUI();
			System.out.println("changed to new deck panel");
			break;
			
		case SCREENS_MANAGE_DECKS:
			break;
		
		case SCREENS_CUSTOMIZE_DECK:
			break;
			
		case SCREENS_OPTIONS:
			holderPanel.removeAll();
			optionsScreen = new OptionsScreen(this);
			holderPanel.add(optionsScreen.getMainPanel());
			holderPanel.updateUI();
			System.out.println("changed to options panel");
			break;
		
		default:
			System.out.println("INVALID NUMBER :" + screen + " GUI.switchScreens()");
			break;
		}
	}
	
	
}
