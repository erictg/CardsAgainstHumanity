package networking;
import java.net.*;
import java.io.*;
public class Client {

	//essential client shit
	Socket socket;
	InputStreamReader streamReader;
	BufferedReader reader;
	
	public Client(String ip, int port)throws IOException{
		//client instantiation
		socket = new Socket(ip, port);
		streamReader = new InputStreamReader(socket.getInputStream());
		reader = new BufferedReader(streamReader);
		
		
	}
}
