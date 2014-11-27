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

import backend.*;
public class NewDeckScreen implements ActionListener{

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
	JPanel mainSouthPanel = new JPanel(new GridLayout(1,6,2,2));
		JButton edit = new JButton("EDIT");
		JButton add = new JButton("ADD");
		JButton delete = new JButton("DELETE");
		JButton save = new JButton("SAVE");
		JButton undo = new JButton("UNDO");
		JButton back = new JButton("BACK");
		
		
	//center
	JPanel mainCenterPanel = new JPanel();
			JScrollPane listScroller = new JScrollPane();
			JList<String> list = new JList<String>();
			DefaultListModel<String> listModel = new DefaultListModel<String>();
	public NewDeckScreen(GUI gui)
	{
		this.gui = gui;
		assemble();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
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
		mainSouthPanel.add(edit);	edit.addActionListener(this);
		mainSouthPanel.add(add);	add.addActionListener(this);
		mainSouthPanel.add(delete);	delete.addActionListener(this);
		mainSouthPanel.add(undo);	undo.addActionListener(this);
		mainSouthPanel.add(save);	save.addActionListener(this);
		mainSouthPanel.add(back);	back.addActionListener(this);
		
		mainPanel.add(BorderLayout.SOUTH, mainSouthPanel);
		
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//listModel.addElement("TEST");
		list.setModel(listModel);
		list.setVisibleRowCount(20);
		list.setFixedCellHeight(15);
		list.setFixedCellWidth(100);
		list.setBackground(Color.WHITE);
		listScroller.setPreferredSize(new Dimension(250, 80));
		listModel.ensureCapacity(54);
		mainCenterPanel.add(listScroller.add(list));
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
			
		}
		
		if(e.getSource() == edit){
			
		}
		
		if(e.getSource() == undo){
			
		}
	}

		
				
				
}
