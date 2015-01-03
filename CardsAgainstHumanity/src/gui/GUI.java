package gui;

import java.awt.Color;

import javax.swing.*;


public class GUI extends JFrame{
	GUI gui;
	//main panel for all GUI windows\\
	Color greenBackground = new Color (52,229,76);
	Color greenButton = new Color (5,210,32);
	//statics
	public static String creators = "CREATED BY ERIC SOLENDER, BRADLEY HENRY, AND ALEX HEPPNER";
	public static final int SCREENS_HOME = 0;
	public static final int SCREENS_JOIN = 1;
	public static final int SCREENS_HOST = 2;
	public static final int SCREENS_OPTIONS = 3;
	public static final int SCREENS_GAME = 4;
	public GUI(){
		
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		System.out.println("work");
		setBackground(greenBackground);
		
		switchScreens(GUI.SCREENS_HOME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*try {
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
	*/
	}
	public void switchScreens(int screen){
		switch(screen){
		case SCREENS_HOME:
			//removes everything from the holder\
			getContentPane().removeAll();
			
			//adds main panel of main screen to JFrame
			getContentPane().add(new HomeWindow(this));
			
			//updates the draw
			((JPanel) getContentPane()).updateUI();
			
			System.out.println("changed to main panel");
			break;
		
		case SCREENS_JOIN:
			getContentPane().removeAll();
			getContentPane().add(new JoinWindow(this));
			((JPanel) getContentPane()).updateUI();
			System.out.println("changed to join panel");
			break;
			
		case SCREENS_HOST:
			getContentPane().removeAll();
			getContentPane().add(new HostWindow(this));
			((JPanel) getContentPane()).updateUI();
			System.out.println("changed to host panel");
			break;
		
		case SCREENS_GAME:
			getContentPane().removeAll();
			getContentPane().add(new GameWindow(this));
			((JPanel) getContentPane()).updateUI();
			System.out.println("changed to game panel");
			break;
			
		case SCREENS_OPTIONS:
			getContentPane().removeAll();
			getContentPane().add(new OptionWindow(this));
			((JPanel) getContentPane()).updateUI();
			System.out.println("changed to game panel");
			break;
		
		default:
			System.out.println("INVALID NUMBER :" + screen + " GUI.switchScreens()");
			break;
		}
	}
	
}
