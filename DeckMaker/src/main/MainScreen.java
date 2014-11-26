package main;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class MainScreen implements ActionListener{

	GUI gui;
	//main panel
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//northPanel
	JPanel northPanel = new JPanel();
		JPanel northLabelHolder = new JPanel();
			JLabel northLabel = new JLabel("CARDS AGAINST HUMANITY DECK MAKER");
	
	//Center
	JPanel mainCenterPanel = new JPanel(); BoxLayout b = new BoxLayout(mainCenterPanel, BoxLayout.Y_AXIS);
		JPanel newDeckPanel = new JPanel();
			JButton newDeckButton = new JButton("NEW DECK");
		JPanel manageDecksPanel = new JPanel();
			JButton manageDecksButton = new JButton("MANAGE DECKS");
		JPanel optionsPanel = new JPanel();
			JButton optionsButton = new JButton("OPTIONS");
			
	//south
	JPanel mainSouthPanel = new JPanel();
		JPanel mainSouthLabelPanel = new JPanel();
			JLabel mainSouthLabel = new JLabel(GUI.creators);
	
	public MainScreen(GUI gui){
		this.gui = gui;
		assemblePanel();
	}

	//panel assembly
	private void assemblePanel(){
		//northern shit
		northPanel.add(northLabelHolder.add(northLabel));
		mainPanel.add(BorderLayout.NORTH, northPanel);
		
		//center
		mainCenterPanel.setLayout(b);
		
		newDeckPanel.add(newDeckButton); newDeckButton.addActionListener(this);
		manageDecksPanel.add(manageDecksButton); manageDecksButton.addActionListener(this);
		optionsPanel.add(optionsButton); optionsButton.addActionListener(this);
		
		mainCenterPanel.add(newDeckPanel);
		mainCenterPanel.add(manageDecksPanel);
		mainCenterPanel.add(optionsPanel);
		
		mainPanel.add(BorderLayout.CENTER, mainCenterPanel);
		
		//south
		mainSouthPanel.add(mainSouthLabelPanel.add(mainSouthLabel));
		
		mainPanel.add(BorderLayout.SOUTH, mainSouthPanel);
		
	}
	
	public JPanel getMainScreen(){
		return mainPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newDeckButton){
			gui.switchScreens(GUI.SCREENS_NEW_DECK);
			System.out.println("new deck button clicked");
		}
		
		if(e.getSource() == manageDecksButton){
			gui.switchScreens(GUI.SCREENS_MANAGE_DECKS);
		}
		
		if(e.getSource() == optionsButton){
			gui.switchScreens(GUI.SCREENS_OPTIONS);
		}
	}
	
	
	
}
