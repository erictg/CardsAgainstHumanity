package backend;

import ui.Window;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.lang.reflect.Modifier;

public class MongoControl {

    public static void serializeUser(User user){
        MongoCollection<Document> collection = Window.database.getCollection("users");
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                .create();
        Document d = Document.parse(gson.toJson(user));
        collection.insertOne(d);
    }

    public static User login(String username, String password){
        MongoCollection<Document> collection = Window.database.getCollection("users");
        Document doc = collection.find(new Document("username", username)).first();
        if(doc != null){
            if(doc.getString("password").equals(password)){
                return new Gson().fromJson(doc.toJson(), User.class);
            }else{
                return null;
            }
        }
        return null;
    }

    public static boolean userExists(String username){
        MongoCollection<Document> collection = Window.database.getCollection("users");
        return collection.find(new Document("username", username)).first() == null;
    }
}