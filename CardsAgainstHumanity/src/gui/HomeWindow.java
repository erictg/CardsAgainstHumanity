package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeWindow implements ActionListener{
	
	GUI gui;
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//northPanel
	JPanel northPanel = new JPanel();
	JLabel title = new JLabel("If you dont know what to do then...wow you're dumb");
	
	//centerPanel 
	JPanel centerPanel = new JPanel(new GridLayout(3,1,5,5));
	JButton hostButton = new JButton();
	JButton joinButton = new JButton();
	JButton optionButton = new JButton();
	
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
		centerPanel.add(hostButton);
		hostButton.addActionListener(this);
		centerPanel.add(joinButton);
		joinButton.addActionListener(this);
		centerPanel.add(optionButton);
		optionButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == hostButton){
			gui.switchScreens(GUI.SCREENS_HOST);
		}
	}
	public JPanel getHomeWindow(){
		return mainPanel;
	}
	
	
	
}
