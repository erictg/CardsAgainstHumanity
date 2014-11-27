package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Stack;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import backend.*;
public class NewDeckScreen implements ActionListener, ListSelectionListener{

	GUI gui;
	Deck d;
	Stack<String> deletedStrings = new Stack<String>();
	//mainPanel
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//northPanel
	JPanel mainNorthPanel = new JPanel();
		JPanel northLabelHolder = new JPanel();
			JLabel northLabel = new JLabel("CARDS AGAINST HUMANITY DECK MAKER");
			
	//east panel
	JPanel mainEastPanel = new JPanel(new GridLayout(2,1,2,2));
		//name stuff
		JPanel namePanel = new JPanel(new GridLayout(2,1,2,2));
			JPanel nameLabelPanel = new JPanel();
				JLabel nameLabel = new JLabel("NAME");
			JPanel nameAreaPanel = new JPanel();
				JTextArea nameArea = new JTextArea(1,20);
				
		//type
		JPanel typePanel = new JPanel(new GridLayout(2,1,2,2));
			JPanel typeLabelPanel = new JPanel();
				JLabel typeLabel = new JLabel("TYPE");
			JPanel typeDropDownHolder = new JPanel();
				String[] text = {"BLACK", "WHITE"};
				JComboBox<String> typeDrop = new JComboBox<String>(text);
				
	//south
	JPanel mainSouthPanel = new JPanel(new GridLayout(1,5,2,2));
		JButton add = new JButton("ADD");
		JButton delete = new JButton("DELETE");
		JButton save = new JButton("SAVE");
		JButton undo = new JButton("UNDO");
		JButton back = new JButton("BACK");
		
		
	//center
	JPanel mainCenterPanel = new JPanel();
			JList<String> list;
			DefaultListModel<String> listModel = new DefaultListModel<String>();
	public NewDeckScreen(GUI gui)
	{
		this.gui = gui;
		assemble();
		this.gui.changeScreenSize(400,250);
		d = new Deck();
	}
	
	public NewDeckScreen(GUI gui, Deck d){
		this(gui);
		this.d = d;
	}
				
	private void assemble(){
		//type sub panel
		typeLabelPanel.add(typeLabel);
		typeDropDownHolder.add(typeDrop);
		typePanel.add(typeLabelPanel);
		typePanel.add(typeDropDownHolder);
		
		//name sub panel
		nameLabelPanel.add(nameLabel);
		nameAreaPanel.add(nameArea);
		namePanel.add(nameLabelPanel);
		namePanel.add(nameAreaPanel);
		//east panel
		mainEastPanel.add(namePanel);
		mainEastPanel.add(typePanel);
		
		mainPanel.add(BorderLayout.EAST, mainEastPanel);
		//north
		mainNorthPanel.add(northLabelHolder.add(northLabel));
		mainPanel.add(BorderLayout.NORTH, mainNorthPanel);
		
		//south
		mainSouthPanel.add(add);	add.addActionListener(this);
		mainSouthPanel.add(delete);	delete.addActionListener(this);
		mainSouthPanel.add(undo);	undo.addActionListener(this);
		mainSouthPanel.add(save);	save.addActionListener(this);
		mainSouthPanel.add(back);	back.addActionListener(this);
		
		mainPanel.add(BorderLayout.SOUTH, mainSouthPanel);
		
		listModel.addElement("EXAMPLE RESPONSE");
		
		list = new JList<String>(listModel);
		list.setSelectedIndex(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(10);
		JScrollPane listScrollPane = new JScrollPane(list);
	
		mainCenterPanel.add(listScrollPane);
		mainPanel.add(BorderLayout.CENTER, mainCenterPanel);
		list.updateUI();
	}
	
	public JPanel getMainPanel(){
		return mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back){
			gui.switchScreens(GUI.SCREENS_MAIN);
		}
		
		if(e.getSource() == delete){
			 int index = list.getSelectedIndex();
			 deletedStrings.push(listModel.remove(index));
			 d.removeCard(deletedStrings.peek());
			 list.updateUI();
		}
		
		if(e.getSource() == add){
			String newCard = JOptionPane.showInputDialog("NEW CARD");
			if(!newCard.equals("")){
				listModel.addElement(newCard);
				d.addCard(newCard);
				list.updateUI();
			}
			
		}
		
		if(e.getSource() == save){
			if(!nameArea.getText().equals("")){
				d.setDeckName(nameArea.getText());
			}else{
				String deckName = JOptionPane.showInputDialog("ENTER A DECK NAME");
				nameArea.setText(deckName);
				d.setDeckName(deckName);
			}
			if(typeDrop.getSelectedIndex() == 0){
				d.setTypeID(Deck.BLACK_CARD);
			}else{
				d.setTypeID(Deck.WHITE_CARD);
			}
			
			try {
				XMLcontrol.serializeDeck(d, gui.getSaveLocation().getAbsolutePath());
			} catch (Exception e1) {
				System.out.println("serialization failed");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
				
		if(e.getSource() == undo){
			if(deletedStrings.size() != 0){
				String undoCard = deletedStrings.pop();
				listModel.addElement(undoCard);
				d.addCard(undoCard);
				list.updateUI();
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

		
				
				
}
