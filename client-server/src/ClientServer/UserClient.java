package ClientServer;

import java.net.*;
import java.io.*;
//UNFINISHED - Currently just connects and does nothing else
public class UserClient implements Runnable {
    
	
    public UserClient(){
    }
    public synchronized void SendRecieve(){
        try{
			//Connects and sends identifier
            InetAddress address = InetAddress.getByName("localhost");
            Socket server = new Socket(address, 9090);
            DataOutputStream outToServer = new DataOutputStream(server.getOutputStream());
			DataInputStream inFromServer = new DataInputStream(server.getInputStream());
            outToServer.writeUTF("USR");
			outToServer.writeUTF(ClientLoginUI.loginData);
        }
        catch (IOException error){
            System.out.println("UserClient IOError: " + error.getMessage()); 
        }
    }
    @Override
    public void run(){
        try{
            SendRecieve();
            Thread.sleep(50);
        } 
        catch (InterruptedException e){
	    	System.out.println("UserClient Interrupted Exception: " + e.getMessage()); 
		}
    }
	
	/*
	public static void main(String[] args)
	{
		UserClient userclient = new UserClient();
		Thread userThread = new Thread(userclient);
		userThread.start();
	}*/
}
