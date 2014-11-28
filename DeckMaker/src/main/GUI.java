package main;

import javax.swing.*;

import backend.Deck;

import java.io.File;
import java.util.ArrayList;
public class GUI{

	//statics
	public static String creators = "CREATED BY ERIC SOLENDER, BRADLEY HENRY, AND ALEX HEPPNER";
	//main frame
	JFrame mainFrame = new JFrame("DeckMaker");
		//JPanel holderPanel = new JPanel();
		
	ArrayList<Deck> d = new ArrayList<Deck>();	
	MainScreen mainScreen;
	OptionsScreen optionsScreen;
	NewDeckScreen newDeckScreen;
	ManageDecks manageDecks;
	//save stuff
	//gets location of where the file is running from
	File saveLocation;
	
	Deck passer;
	boolean pass = false;
	
	public void setLoadDeckTrue(){
		pass = true;
	}
	public void setLoadDeckFalse(){
		pass = false;
	}
	
	public void setPasser(Deck passer){
		this.passer = passer;
	}
	public GUI(){
		//saveLocation = new File(System.getProperty("user.dir"));
		saveLocation = new File("C:\\Program Files (x86)\\Cards Against Humanity\\Decks");
		mainScreen = new MainScreen(this);
		mainFrame.getContentPane().add(mainScreen.getMainScreen());
		mainFrame.setLocationRelativeTo(null);
		changeScreenSize(400,250);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		decksFile();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
			mainFrame.getContentPane().removeAll();
			
			//instantiates main screen
			mainScreen = new MainScreen(this);
			
			//adds main panel of main screen to holderPanel
			mainFrame.getContentPane().add(mainScreen.getMainScreen());
			
			//updates the draw
			((JPanel) mainFrame.getContentPane()).updateUI();
			
			System.out.println("changed to main panel");
			break;
		
		case SCREENS_NEW_DECK:
			mainFrame.getContentPane().removeAll();
			if(pass && passer != null){
				newDeckScreen = new NewDeckScreen(this, passer);
			}else{
				newDeckScreen = new NewDeckScreen(this);
			}
			
			mainFrame.getContentPane().add(newDeckScreen.getMainPanel());
			((JPanel) mainFrame.getContentPane()).updateUI();
			System.out.println("changed to new deck panel");
			break;
			
		case SCREENS_MANAGE_DECKS:
			mainFrame.getContentPane().removeAll();
			manageDecks = new ManageDecks(this);
			mainFrame.getContentPane().add(manageDecks.getMainPanel());
			((JPanel) mainFrame.getContentPane()).updateUI();
			break;
		
		case SCREENS_CUSTOMIZE_DECK:
			break;
			
		case SCREENS_OPTIONS:
			mainFrame.getContentPane().removeAll();
			optionsScreen = new OptionsScreen(this);
			mainFrame.getContentPane().add(optionsScreen.getMainPanel());
			((JPanel) mainFrame.getContentPane()).updateUI();
			System.out.println("changed to options panel");
			break;
		
		default:
			System.out.println("INVALID NUMBER :" + screen + " GUI.switchScreens()");
			break;
		}
	}
	
	public void setFileLocation(String file){
		saveLocation = new File(file);
	}
	
	public void setFileLocation(File file){
		saveLocation = file;
	}
	
	public File getSaveLocation(){
		return saveLocation;
	}
	
	public void changeScreenSize(int x, int y){
		mainFrame.setSize(x,  y);
	}
	
	//make sure file is there
	public void decksFile(){
		File p = new File("C:\\Program Files (x86)\\Cards Against Humanity\\Decks");
		if(!java.nio.file.Files.exists(p.toPath())){
			System.out.println(p.mkdirs());
		}

	}
	
}
