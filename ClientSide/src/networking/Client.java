package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Problem;
import model.Solution;
import config.ClientProperties;
import config.HandleProperties;


public class Client {
	private String serverAddress;
	private int port;
	
	public Client() {
		
		ClientProperties cp = new HandleProperties().readProperties();
		this.port = cp.getPort();
		this.serverAddress = cp.getServAddr();
	}

	
	public Solution getSolution(Problem problem) {		
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		
		
		try {
			socket = new Socket(serverAddress, port);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			out.writeObject(problem);			
			Solution solution = (Solution)in.readObject();
			return solution;	
								
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}			
		}	
		return null;
	}
}

