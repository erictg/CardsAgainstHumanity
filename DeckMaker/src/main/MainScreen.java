package main;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
public class MainScreen implements MouseListener{

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
			JButton newDeckButton = new JButton();
		JPanel loadDeckPanel = new JPanel();
			JList list; //lists all of the files in the folder
			String[] fileNames;
			File[] files;
	
	
	public MainScreen(GUI gui){
		this.gui = gui;
		
	}
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//north panel
}
