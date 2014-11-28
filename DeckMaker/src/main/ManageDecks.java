package main;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import backend.Deck;
import backend.XMLcontrol;
public class ManageDecks implements ListSelectionListener, ActionListener {

	GUI gui;
	ArrayList<Deck> decks;
	
	//mainPanel
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//north panel
	JPanel mainNorthPanel = new JPanel();
		JPanel northLabelHolder = new JPanel();
			JLabel northLabel = new JLabel("CARDS AGAINST HUMANITY DECK MAKER");
	
	//south panel
	JPanel mainSouthPanel = new JPanel(new GridLayout(1,3,2,2));
		JButton delete = new JButton("DELETE");
		JButton edit = new JButton("EDIT");
		JButton back = new JButton("BACK");
		
	//center
	JPanel mainCenterPanel = new JPanel();
		JList<String> list;
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
	public ManageDecks(GUI gui){
		this.gui = gui;
		assemble();
		decks = XMLcontrol.getDecks(gui.getSaveLocation());
		if(decks.size() != 0){
			for(Deck d : decks){
				listModel.addElement(d.getDeckName());
			}
		}else{
			System.out.println(decks.size());
		}
	
	}
	
	public void assemble(){
		
		
		list = new JList<String>(listModel);
		list.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(10);
		JScrollPane listScrollPane = new JScrollPane(list);
		mainCenterPanel.add(listScrollPane);
		mainPanel.add(BorderLayout.CENTER, mainCenterPanel);
		list.updateUI();
		
		mainNorthPanel.add(northLabelHolder.add(northLabel));
		mainPanel.add(BorderLayout.NORTH, mainNorthPanel);
		
		mainSouthPanel.add(delete);	delete.addActionListener(this);
		mainSouthPanel.add(edit);	edit.addActionListener(this);
		mainSouthPanel.add(back);	back.addActionListener(this);
		
		mainPanel.add(BorderLayout.SOUTH, mainSouthPanel);
	}

	public JPanel getMainPanel(){
		return mainPanel;
	}
	
	public void readInFiles(){
		
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == delete){
			int index = list.getSelectedIndex();
			try {
				Files.deleteIfExists(decks.get(index).getFile().toPath());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listModel.remove(index);
			decks.remove(index);
		}
		if(e.getSource() == back){
			gui.switchScreens(GUI.SCREENS_MAIN);
		}
		
		if(e.getSource() == edit){
			gui.setLoadDeckTrue();
			gui.setPasser(decks.get(list.getSelectedIndex()));
			gui.switchScreens(GUI.SCREENS_NEW_DECK);
			
		}
	}
}
