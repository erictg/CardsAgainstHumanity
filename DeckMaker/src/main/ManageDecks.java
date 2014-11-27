package main;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class ManageDecks implements ListSelectionListener, ActionListener {

	GUI gui;
	File[] files;
	String[] names;
	
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
		
	}
	
	public void assemble(){
		listModel.addElement("EXAMPLE NAME");
		
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
