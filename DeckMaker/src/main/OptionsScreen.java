package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;

import javax.swing.*;

public class OptionsScreen implements ActionListener{

	GUI gui;
	
	//main
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//northPanel
	JPanel mainNorthPanel = new JPanel();
		JPanel northLabelHolder = new JPanel();
			JLabel northLabel = new JLabel("OPTIONS MENU");
			
	//centerPanel
	JPanel mainCenterPanel = new JPanel(new GridLayout(2,1,2,2));
		//change save location
		
		JPanel changeSaveLocation = new JPanel();BoxLayout b = new BoxLayout(changeSaveLocation, BoxLayout.X_AXIS);
			JPanel changeSaveLabelHolder = new JPanel();
				JLabel changeSaveLocationLabel = new JLabel("Save Location");
			JPanel saveLocationPanel = new JPanel();
				JTextArea saveLocationArea = new JTextArea(1,25);
			JPanel saveLocationButtonPanel = new JPanel();
				JButton saveLocationButton = new JButton("...");
		JPanel backButtonHolder = new JPanel();
			JButton backButton = new JButton("BACK");
	
	//south
	JPanel mainSouthPanel = new JPanel();
		JPanel mainSouthLabelHolder = new JPanel();
			JLabel mainSouthLabel = new JLabel(GUI.creators);
			
	public OptionsScreen(GUI gui){
		this.gui = gui;
		assemblePanel();
	}
	
	private void assemblePanel(){
		mainNorthPanel.add(northLabelHolder.add(northLabel));
		mainPanel.add(BorderLayout.NORTH, mainNorthPanel);
		
		changeSaveLabelHolder.add(changeSaveLocationLabel);
		saveLocationPanel.add(saveLocationArea);
		saveLocationButtonPanel.add(saveLocationButton); saveLocationButton.addActionListener(this);
		changeSaveLocation.setLayout(b);
		changeSaveLocation.add(changeSaveLabelHolder);
		changeSaveLocation.add(saveLocationPanel);
		saveLocationArea.setLineWrap(true);
		changeSaveLocation.add(saveLocationButtonPanel);
		String path = gui.getSaveLocation().getAbsolutePath();
		saveLocationArea.setText(path);
		backButtonHolder.add(backButton); backButton.addActionListener(this);
		mainCenterPanel.add(changeSaveLocation);
		mainCenterPanel.add(backButtonHolder);
		mainPanel.add(BorderLayout.CENTER, mainCenterPanel);
		
		mainSouthPanel.add(mainSouthLabelHolder.add(mainSouthLabel));
		mainPanel.add(BorderLayout.SOUTH, mainSouthPanel);
	}
	
	public JPanel getMainPanel(){
		return mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == backButton){
			gui.switchScreens(GUI.SCREENS_MAIN);
		}
		if(e.getSource() == saveLocationButton){
			JFileChooser file = new JFileChooser(gui.saveLocation);
			file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			file.showDialog(new JFrame(), "Select");
			
			if(file.getSelectedFile() != null){
				gui.setFileLocation(file.getSelectedFile());
				String path = gui.getSaveLocation().getAbsolutePath();
				saveLocationArea.setText(path);
			}else{
				System.out.println("canceled");
			}
			
		}
	}
	
	
		
		
}
