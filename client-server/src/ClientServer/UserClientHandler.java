package ClientServer;

import java.net.*;
import java.io.*;
//UNFINISHED
public class UserClientHandler implements Runnable {
    Socket client;
    DataOutputStream outToClient;
    DataInputStream inFromClient;
    
    public UserClientHandler(Socket _client) throws IOException{
		System.out.println("UserHandler Active");
        client = _client;
        outToClient = new DataOutputStream(client.getOutputStream());
        inFromClient = new DataInputStream(client.getInputStream());
    }
    
    @Override
    public void run(){
        try{
            String inText = inFromClient.readUTF();
            System.out.println("Server recieves message: " + inText);
        } 
		catch(IOException e){
	    	System.out.println("UserHandler IOError: " + e.getMessage());
		}
    }
}
