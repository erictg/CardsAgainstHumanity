package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class HostWindow extends JPanel implements ActionListener{
	GUI gui;
	
	//northPanel
	
	//centerPanel 
	JPanel centerPanel = new JPanel(new GridLayout(6,2,5,5));
	JTextArea name = new JTextArea(1,15);
	JLabel nameLabel = new JLabel("Server Name:");
	JTextArea password = new JTextArea(1,15);
	JLabel passwordLabel = new JLabel("Password:");
	JTextArea players = new JTextArea(1,15);
	JLabel playersLabel = new JLabel("Max Players:");
	JButton lanOnline = new JButton("online");
	JLabel lanOnlineLabel = new JLabel("Online/Lan:");
	JTextArea port = new JTextArea(1,15);
	JLabel portLabel = new JLabel("Port:");
	JButton start = new JButton("Start!");
	JButton homeButton = new JButton("Home");
	Color greenButton = new Color (5,210,32);
	
	
	public HostWindow(GUI gui){
		super(new BorderLayout());
		this.gui = gui;
		assemble();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == start){
			//////make server here
			//Host();
			
			gui.switchScreens(GUI.SCREENS_GAME);
		}
		if(e.getSource()==lanOnline){
			if(lanOnline.getText()=="Lan"){
				lanOnline.setText("Online");
			}else
				lanOnline.setText("Lan");
		}
		if(e.getSource() == homeButton){
			gui.switchScreens(GUI.SCREENS_HOME);
		}
	}
	
	public void assemble(){
		
		//center
		add(BorderLayout.CENTER,centerPanel);
		centerPanel.add(nameLabel);
		centerPanel.add(name);
		centerPanel.add(passwordLabel);
		centerPanel.add(password);
		centerPanel.add(playersLabel);
		centerPanel.add(players);
		centerPanel.add(lanOnlineLabel);
		centerPanel.add(lanOnline);
		lanOnline.setBackground(greenButton);
		lanOnline.addActionListener(this);
		centerPanel.add(portLabel);
		centerPanel.add(port);
		centerPanel.add(start);
		start.setBackground(greenButton);
		start.addActionListener(this);
		centerPanel.add(homeButton);
		homeButton.setBackground(greenButton);
		homeButton.addActionListener(this);
		centerPanel.setOpaque(false);
		setOpaque(false);
	}

}
