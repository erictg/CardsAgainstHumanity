package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeWindow implements ActionListener{
	
	GUI gui;
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//northPanel
	JPanel northPanel = new JPanel();
	JLabel title = new JLabel("Home");
	
	//centerPanel 
	JPanel centerPanel = new JPanel(new GridLayout(4,1,5,5));
	JButton hostButton = new JButton("Host");
	JButton joinButton = new JButton("Join");
	JButton optionButton = new JButton("Options");
	JButton homeButton = new JButton("Home");
	
	Color greenBackground = new Color (52,229,76);
	Color greenButton = new Color (5,210,32);
	public HomeWindow(GUI gui){
		this.gui = gui;
		assemble();
	}
	
	public void assemble(){
		//north
		mainPanel.add(BorderLayout.NORTH,northPanel);
		northPanel.add(title);
		//center
		mainPanel.add(BorderLayout.CENTER,centerPanel);
		mainPanel.setBackground(greenBackground);
		centerPanel.add(hostButton);
		centerPanel.setOpaque(false);
		hostButton.setBackground(greenButton);
		hostButton.addActionListener(this);
		centerPanel.add(joinButton);
		//joinButton.setBackground(greenButton);
		joinButton.addActionListener(this);
		centerPanel.add(optionButton);
		optionButton.setBackground(greenButton);
		optionButton.addActionListener(this);
		title.setBackground(greenButton);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == hostButton){
			gui.switchScreens(GUI.SCREENS_HOST);
		}
		if(e.getSource()== joinButton){
			gui.switchScreens(GUI.SCREENS_JOIN);
		}
		if(e.getSource()== optionButton){
			gui.switchScreens(GUI.SCREENS_OPTIONS);
		}
		if(e.getSource() == homeButton){
			gui.switchScreens(GUI.SCREENS_HOME);
		}
	}
	public JPanel getHomeWindow(){
		setColors();
		return mainPanel;
	}
	public void setColors(){
		northPanel.setBackground(Color.ORANGE);
		mainPanel.setBackground(greenBackground);
		centerPanel.add(hostButton);
		centerPanel.setOpaque(true);
		centerPanel.setBackground(Color.ORANGE);
		hostButton.setBackground(greenButton);
		this.joinButton.setBackground(greenButton);
		title.setBackground(greenButton);
		System.out.println("bleh");
	}
	
	
}
