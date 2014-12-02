package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JoinWindow implements ActionListener{
	
		GUI gui;
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		//northPanel
		JPanel northPanel = new JPanel();
		JLabel title = new JLabel("Join");
		
		//centerPanel 
		JPanel centerPanel = new JPanel(new GridLayout(2,1,10,10));
		JButton lanOnline = new JButton("lan");
		JList servers = new JList();
		
		
		//east panel
		JPanel eastPanel = new JPanel();
		JButton joinButton = new JButton("Join");
		JButton homeButton = new JButton("Home");
		
		public JoinWindow(GUI gui) {
			this.gui = gui;
			assemble();
		}
		
		public void assemble(){
			//north
			mainPanel.add(BorderLayout.NORTH,northPanel);
			northPanel.add(title);
			//center
			mainPanel.add(BorderLayout.CENTER,centerPanel);
			centerPanel.add(servers);
			//east
			mainPanel.add(BorderLayout.EAST,eastPanel);
			eastPanel.add(joinButton);
			centerPanel.add(homeButton);
			homeButton.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
			if(e.getSource() == joinButton){
				gui.switchScreens(GUI.SCREENS_GAME);
			}
			if(e.getSource() == homeButton){
				gui.switchScreens(GUI.SCREENS_HOME);
			}
		}
		public JPanel getJoinWindow(){
			return mainPanel;
		}
		
	}


