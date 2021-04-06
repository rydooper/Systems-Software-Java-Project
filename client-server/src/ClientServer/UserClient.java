package ClientServer;

import java.net.*;
import java.io.*;
//UNFINISHED - Currently just connects and does nothing else
public class UserClient implements Runnable {
    
	static boolean validLogin;
	static String fieldData;
	InetAddress address;
    Socket server;
    DataOutputStream outToServer;
	DataInputStream inFromServer;

    public UserClient(){
    }
    public synchronized void Connect(){
        try{
			//Connects and sends identifier
            address = InetAddress.getByName("localhost");
            server = new Socket(address, 9090);
            outToServer = new DataOutputStream(server.getOutputStream());
			inFromServer = new DataInputStream(server.getInputStream());
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
			while(true){
				try{
					if(!mainMenuUI.dataRequest.isBlank()){
						outToServer.writeUTF(mainMenuUI.dataRequest);
						System.out.println("not blank");
					}
					else{System.out.println("blank");}
				}
				catch(IOException e)
				{
					System.out.println(e.getMessage());
				};
			}
        } 
        catch (InterruptedException e){
	    	System.out.println("UserClient Interrupted Exception: " + e.getMessage()); 
		}
    }
	
}
