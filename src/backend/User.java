package backend;

import java.util.Random;

/**
 * Created by Gretchen on 5/24/2015.
 */
public class User {

    private String username;
    private String password;
    private String id;

    public User(){
        username = "";
        password = "";
        generateID();
    }

    public User(String username, String password){
        setPassword(password);
        setUsername(username);
        generateID();
    }

    private void generateID(){
        Random r  = new Random(System.currentTimeMillis());
        r.nextInt(Integer.MAX_VALUE);
        id = Integer.toHexString(r.nextInt(Integer.MAX_VALUE));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
