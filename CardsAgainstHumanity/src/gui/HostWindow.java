package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HostWindow implements ActionListener{
	GUI gui;
	JPanel mainPanel = new JPanel(new BorderLayout());
	
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
		public HostWindow(GUI gui){
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
	}
	
	public void assemble(){
		
		//center
		mainPanel.add(BorderLayout.CENTER,centerPanel);
		mainPanel.add(nameLabel);
		mainPanel.add(name);
		mainPanel.add(passwordLabel);
		mainPanel.add(password);
		mainPanel.add(playersLabel);
		mainPanel.add(players);
		mainPanel.add(lanOnlineLabel);
		mainPanel.add(lanOnline);
		lanOnline.addActionListener(this);
		mainPanel.add(portLabel);
		mainPanel.add(port);
		mainPanel.add(start);
		start.addActionListener(this);
	}
	public JPanel getHostWindow(){
		return mainPanel;
	}

}
