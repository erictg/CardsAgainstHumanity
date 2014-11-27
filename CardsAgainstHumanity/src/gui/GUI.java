package gui;

import java.awt.GridLayout;

import javax.swing.*;


public class GUI {

	//main panel for all GUI windows
	JFrame mainFrame = new JFrame("CARDS AGAINST HUMANITY");
	JPanel mainPanel = new JPanel();
	HomeWindow mainScreen;
	JoinWindow joinWindow;
	HostWindow hostWindow;
	OptionWindow optionsWindow;
	GameWindow gameWindow;
	//statics
	public static String creators = "CREATED BY ERIC SOLENDER, BRADLEY HENRY, AND ALEX HEPPNER";
	public static final int SCREENS_HOME = 0;
	public static final int SCREENS_JOIN = 1;
	public static final int SCREENS_HOST = 2;
	public static final int SCREENS_OPTIONS = 3;
	public static final int SCREENS_GAME = 4;
	public GUI(){
		mainFrame.add(mainPanel);
		
	}
	public void switchScreens(int screen){
		switch(screen){
		case SCREENS_HOME:
			//removes everything from the holder\
			mainPanel.removeAll();
			
			//instantiates main screen
			mainScreen = new HomeWindow(this);
			
			//adds main panel of main screen to holderPanel
			mainPanel.add(mainScreen.getHomeWindow());
			
			//updates the draw
			mainPanel.updateUI();
			
			System.out.println("changed to main panel");
			break;
		
		case SCREENS_JOIN:
			mainPanel.removeAll();
			joinWindow= new JoinWindow(this);
			mainPanel.add(joinWindow.getJoinWindow());
			mainPanel.updateUI();
			System.out.println("changed to join panel");
			break;
			
		case SCREENS_HOST:
			mainPanel.removeAll();
			hostWindow= new HostWindow(this);
			mainPanel.add(hostWindow.getHostWindow());
			mainPanel.updateUI();
			System.out.println("changed to host panel");
			break;
		
		/*case SCREENS_GAME:
			mainPanel.removeAll();
			gameWindow = new GameWindow(this);
			//mainPanel.add(gameWindow.getGameWindow());
			mainPanel.updateUI();
			System.out.println("changed to game panel");
			break;
			*/
		case SCREENS_OPTIONS:
			mainPanel.removeAll();
			optionsWindow = new OptionWindow(this);
			//mainPanel.add(optionsWindow.)
			mainPanel.updateUI();
			System.out.println("changed to game panel");
			break;
		
		default:
			System.out.println("INVALID NUMBER :" + screen + " GUI.switchScreens()");
			break;
		}
	}
	
}
