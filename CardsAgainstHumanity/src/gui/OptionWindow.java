package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionWindow implements ActionListener{
	GUI gui;
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//northPanel
	JPanel northPanel = new JPanel();
	JLabel title = new JLabel("Options");
	
	//centerPanel 
	JPanel centerPanel = new JPanel(new GridLayout(3,1,5,5));
	JButton optionsButton = new JButton("opt");
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
			optionsButton.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == optionsButton){
				//stuff
			}
		}
		public JPanel getOptionWindow(){
			return mainPanel;
		}
}



