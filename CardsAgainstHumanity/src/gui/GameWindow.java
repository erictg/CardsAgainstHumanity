package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class GameWindow implements ActionListener{
	
	

		GUI gui;
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel eastPanel = new JPanel();
		JLabel title = new JLabel("Game");
		//east panel
		JButton homeButton = new JButton("Home");
		
		public GameWindow(GUI gui) {
			this.gui = gui;
			assemble();
		}
		
		public void assemble(){
			//east
			mainPanel.add(BorderLayout.EAST,eastPanel);
			eastPanel.add(title);
			eastPanel.add(homeButton);
			homeButton.addActionListener(this);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == homeButton){
				gui.switchScreens(GUI.SCREENS_HOME);
			}
		}
		public JPanel getGameWindow(){
			return mainPanel;
		}

}


