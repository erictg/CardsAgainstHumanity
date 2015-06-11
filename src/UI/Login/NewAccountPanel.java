package ui.login;
import javax.swing.*;
import java.awt.*;
import ui.Window;
import backend.MongoControl;
import backend.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewAccountPanel extends JPanel implements ActionListener{

    private Window window;

    JPanel northPanel = new JPanel(new GridBagLayout());
    JLabel northLabel = new JLabel("NEW ACCOUNT");

    JPanel centerHolder = new JPanel(new GridBagLayout());
    JPanel mainCenterPanel = new JPanel(new GridLayout(5,2));
    JPanel userNameLabelPanel = new JPanel();
    JLabel userNameLabel = new JLabel("USERNAME:");
    JPanel userNameFieldPanel = new JPanel();
    JTextField usernameField = new JTextField(10);
    JPanel passwordLabelPanel = new JPanel();
    JLabel passwordLabel = new JLabel("PASSWORD");
    JPanel passwordFieldPanel = new JPanel();
    JPasswordField passwordField = new JPasswordField(10);
    JPanel confirmPasswordLabelPanel = new JPanel();
    JLabel confirmPasswordLabel = new JLabel("PASSWORD");
    JPanel confirmPasswordFieldPanel = new JPanel();
    JPasswordField confirmPasswordField = new JPasswordField(10);
    JPanel backButtonPanel = new JPanel();
    JButton backButton = new JButton("BACK");
    JPanel loginButtonPanel = new JPanel();
    JButton loginButton = new JButton("LOGIN");
    JPanel errorPanel = new JPanel();
    JLabel errorLabel = new JLabel();
    JPanel southPanel = new JPanel(new GridBagLayout());
    JLabel southLabel = new JLabel("Ironside Game Studios");

    public NewAccountPanel(Window window){
        super(new BorderLayout());
        this.window = window;
        construct();
    }

    private void construct(){
        northPanel.add(northLabel);
        add(northPanel, BorderLayout.NORTH);

        userNameLabelPanel.add(userNameLabel);
        userNameFieldPanel.add(usernameField);
        passwordLabelPanel.add(passwordLabel);
        passwordFieldPanel.add(passwordField);
        confirmPasswordLabelPanel.add(confirmPasswordLabel);
        confirmPasswordFieldPanel.add(confirmPasswordField);
        backButtonPanel.add(backButton);    backButton.addActionListener(this);
        loginButtonPanel.add(loginButton);  loginButton.addActionListener(this);

        mainCenterPanel.add(userNameLabelPanel);
        mainCenterPanel.add(userNameFieldPanel);
        mainCenterPanel.add(passwordLabelPanel);
        mainCenterPanel.add(passwordFieldPanel);
        mainCenterPanel.add(confirmPasswordLabelPanel);
        mainCenterPanel.add(confirmPasswordFieldPanel);
        mainCenterPanel.add(backButtonPanel);
        mainCenterPanel.add(loginButtonPanel);
        errorPanel.add(errorLabel);
        errorLabel.setForeground(Color.RED);
        mainCenterPanel.add(errorPanel);
        centerHolder.add(mainCenterPanel);
        add(centerHolder, BorderLayout.CENTER);

        southPanel.add(southLabel);
        add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            window.switchPanels(Window.LOGIN);
        }
        if(e.getSource() == loginButton){
            String username = usernameField.getText();
            String password = passwordField.getText();
            String cPassword = confirmPasswordField.getText();
            if(MongoControl.userExists(username)){
                if(cPassword.equals(password)){
                    MongoControl.serializeUser(new User(username, password));
                    window.user = new User(username, password);
                    window.switchPanels(Window.MAIN_MENU);
                }else{
                    errorLabel.setText("PASSWORDS DO NOT MATCH");
                }

            }else{
                errorLabel.setText("USER EXISTS");
            }
        }
    }
}