package ui.deckMakerUI;
import backend.deck.Deck;
import ui.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckMakerMainMenu extends JPanel implements ActionListener {

    private Window window;

    JPanel northPanel = new JPanel();
        JPanel northLabelPanel = new JPanel();
            JLabel northLabel = new JLabel("DECK MAKER");

    JPanel centerGridBag = new JPanel(new GridBagLayout());
    JPanel centerPanel = new JPanel();  BoxLayout centerBox = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
        JPanel myDecksPanel = new JPanel();
            JButton myDecksButton = new JButton("MY DECKS");
        JPanel newDeckPanel = new JPanel();
            JButton newDeckButton = new JButton("NEW DECK");
        JPanel backButtonPanel = new JPanel();
            JButton backButton = new JButton("BACK");


    public DeckMakerMainMenu(Window window){
        super(new BorderLayout());
        this.window = window;
        construct();
    }

    private void construct(){
        northPanel.add(northLabelPanel.add(northLabel));
        myDecksPanel.add(myDecksButton);    myDecksButton.addActionListener(this);
        newDeckPanel.add(newDeckButton);    newDeckButton.addActionListener(this);
        backButtonPanel.add(backButton);    backButton.addActionListener(this);
        centerPanel.setLayout(centerBox);
        centerPanel.add(myDecksPanel);
        centerPanel.add(newDeckPanel);
        centerPanel.add(backButtonPanel);
        centerGridBag.add(centerPanel);
        add(centerGridBag, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            window.switchPanels(Window.MAIN_MENU);
        }
        if(e.getSource() == newDeckButton){

        }
    }
}
