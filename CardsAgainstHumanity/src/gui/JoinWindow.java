package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JoinWindow extends JPanel implements ActionListener{
	
		GUI gui;
		
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
		
		Color greenButton = new Color (5,210,32);
		
		public JoinWindow(GUI gui) {
			super(new BorderLayout());
			this.gui = gui;
			assemble();
		}
		
		public void assemble(){
			//north
			add(BorderLayout.NORTH,northPanel);
			northPanel.add(title);
			//center
			add(BorderLayout.CENTER,centerPanel);
			centerPanel.add(servers);
			//east
			add(BorderLayout.EAST,eastPanel);
			eastPanel.add(joinButton);
			joinButton.addActionListener(this);
			joinButton.setBackground(greenButton);
			centerPanel.add(homeButton);
			homeButton.setBackground(greenButton);
			homeButton.addActionListener(this);
			
			centerPanel.setOpaque(false);
			setOpaque(false);
			eastPanel.setOpaque(false);
			northPanel.setOpaque(false);
			
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
		
	}


