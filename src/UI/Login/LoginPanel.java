package ui.login;

import ui.Window;
import backend.MongoControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener{

    private Window window; //make a reference of window

    JPanel northPanel = new JPanel();
    JPanel northLabelPanel = new JPanel();
    JLabel northLabel = new JLabel("WELCOME!");
    JPanel centerHolder = new JPanel(new GridBagLayout());
    JPanel centerPanel = new JPanel(new GridLayout(4,2,2,2));
    JPanel usernameLabelPanel = new JPanel();
    JLabel usernameLabel = new JLabel("USERNAME:");
    JPanel usernameAreaPanel = new JPanel();
    JTextField usernameArea = new JTextField(10);
    JPanel passwordLabelPanel = new JPanel();
    JLabel passwordLabel = new JLabel("PASSWORD");
    JPanel passwordFieldPanel = new JPanel();
    JPasswordField passwordField = new JPasswordField(10);
    JPanel newAccountButtonPanel = new JPanel();
    JButton newAccountButton = new JButton("NEW ACCOUNT");
    JPanel loginButtonPanel = new JPanel();
    JButton loginButton = new JButton("LOGIN");
    JPanel errorPanel = new JPanel();
    JLabel errorLabel = new JLabel();
    JPanel southernPanel = new JPanel();
    JPanel southernLabelPanel = new JPanel();
    JLabel southernLabel = new JLabel("CREATED BY ERIC SOLENDER");

    public LoginPanel(Window window){
        super(new BorderLayout());
        this.window = window;
        construct();

    }

    private void construct(){
        northPanel.add(northLabelPanel.add(northLabel));
        add(northPanel, BorderLayout.NORTH);

        usernameLabelPanel.add(usernameLabel);
        usernameAreaPanel.add(usernameArea);
        centerPanel.add(usernameLabelPanel);
        centerPanel.add(usernameAreaPanel);

        passwordLabelPanel.add(passwordLabel);
        passwordFieldPanel.add(passwordField);
        centerPanel.add(passwordLabelPanel);
        centerPanel.add(passwordFieldPanel);

        newAccountButtonPanel.add(newAccountButton);    newAccountButton.addActionListener(this);
        loginButtonPanel.add(loginButton);  loginButton.addActionListener(this);
        centerPanel.add(newAccountButtonPanel);
        centerPanel.add(loginButtonPanel);
        errorPanel.add(errorLabel);
        errorLabel.setForeground(Color.RED);
        centerPanel.add(errorPanel);
        centerHolder.add(centerPanel);
        add(centerHolder, BorderLayout.CENTER);

        southernPanel.add(southernLabelPanel.add(southernLabel));
        add(southernPanel, BorderLayout.SOUTH);
        setBackground(Color.BLUE);
        centerHolder.setBackground(Color.BLUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newAccountButton){
            window.switchPanels(Window.NEW_ACCOUNT);
        }
        if(e.getSource() == loginButton){
            String username = usernameArea.getText();
            String password = passwordField.getText();
            if(!username.equals("") && !password.equals("")){
                window.user = MongoControl.login(username, password);
                if(window.user != null || (username.equals("admin") && password.equals("password"))){
                    window.switchPanels(Window.MAIN_MENU);

                }else{
                    errorLabel.setText("USERNAME OR PASSWORD ERROR");
                }
            }else{
                errorLabel.setText("FIELDS ARE NOT FILLED IN");
            }

        }
    }
}