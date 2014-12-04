package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
;

public class OptionWindow implements ActionListener{
	GUI gui;
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//northPanel
	JPanel northPanel = new JPanel(new GridLayout(1,1,1,1));
	JLabel title = new JLabel("Options");
	
	//centerPanel 
	JPanel centerPanel = new JPanel(new GridLayout(2,1,5,5));
	JButton optionsButton = new JButton("opt");
	JButton homeButton = new JButton("Home");
	
	
	
	Color greenButton = new Color (5,210,32);
	
	public OptionWindow(GUI gui) {
	this.gui = gui;
	assemble();
	}
		public void assemble(){
			//north
			mainPanel.add(BorderLayout.NORTH,northPanel);
			northPanel.add(title);
			//center
			mainPanel.add(BorderLayout.CENTER,centerPanel);
			centerPanel.add(optionsButton);
			optionsButton.setBackground(greenButton);
			optionsButton.addActionListener(this);
			centerPanel.add(homeButton);
			homeButton.setBackground(greenButton);
			homeButton.addActionListener(this);
			
			centerPanel.setOpaque(false);
			mainPanel.setOpaque(false);
			northPanel.setOpaque(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == optionsButton){
				//stuff
			}if(e.getSource() == homeButton){
				gui.switchScreens(GUI.SCREENS_HOME);
			}
		}
		public JPanel getOptionWindow(){
			return mainPanel;
		}
}



