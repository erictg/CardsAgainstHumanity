package UI;

import javax.swing.*;

import UI.Login.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import backend.User;



public class Window extends JFrame {

    public static MongoDatabase database;
    public static User user;
    public static MongoClient mongoClient;
    public Window(){
        super("FUCKIN CARDS AGAINST HUMANITY");
        MongoClientURI connectionString = new MongoClientURI("mongodb://erictg97:sabrefan67@ds031932.mongolab.com:31932/colorsgame");
        mongoClient = new MongoClient(connectionString);
        database = mongoClient.getDatabase("colorsgame");


        user = new User("admin", "password");
        add(new LoginPanel(this));
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void run(){
        new Window();
    }

    public static final int LOGIN = 0;
    public static final int NEW_ACCOUNT = 1;
    public static final int MAIN_MENU = 2;

    public void switchPanels(int panel){
        getContentPane().removeAll();
        switch (panel){
            case LOGIN:
                getContentPane().add(new LoginPanel(this));
                break;

            case NEW_ACCOUNT:
                getContentPane().add(new NewAccountPanel(this));
                break;
            case MAIN_MENU:
                //getContentPane().add(new MainMenuPanel(this));
        }

        ((JPanel)getContentPane()).updateUI();
    }
}


