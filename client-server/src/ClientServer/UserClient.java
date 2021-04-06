package ClientServer;

import java.net.*;
import java.io.*;
//UNFINISHED - Currently just connects and does nothing else
public class UserClient implements Runnable {
    
	static boolean validLogin;
	
    public UserClient(){
    }
    public synchronized void Connect(){
        try{
			//Connects and sends identifier
            InetAddress address = InetAddress.getByName("localhost");
            Socket server = new Socket(address, 9090);
            DataOutputStream outToServer = new DataOutputStream(server.getOutputStream());
			DataInputStream inFromServer = new DataInputStream(server.getInputStream());
            outToServer.writeUTF("USR");
			outToServer.writeUTF(ClientLoginUI.loginData);
			validLogin = inFromServer.readBoolean();
        }
        catch (IOException error){
            System.out.println("UserClient IOError: " + error.getMessage()); 
        }
    }
    @Override
    public void run(){
        try{
            Connect();
            Thread.sleep(50);
        } 
        catch (InterruptedException e){
	    	System.out.println("UserClient Interrupted Exception: " + e.getMessage()); 
		}
    }
	
}
