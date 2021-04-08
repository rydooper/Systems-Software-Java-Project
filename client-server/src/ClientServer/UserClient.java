package ClientServer;

import java.net.*;
import java.io.*;
//UNFINISHED - Currently just connects and does nothing else
public class UserClient implements Runnable {
    
	static boolean validLogin;
	static String[] fieldData;
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

			String menuOption = "";
			while(true){
				try{
					Thread.sleep(100);
					if(mainMenuUI.buttonPressed){
						outToServer.writeUTF(mainMenuUI.dataRequest);
						menuOption = mainMenuUI.dataRequest;
						mainMenuUI.buttonPressed = false;
					}
					else{}

					if(!menuOption.isEmpty()){
						switch(menuOption){
							case "FIELD DATA":
								String fieldDataString = inFromServer.readUTF();
								fieldData = fieldDataString.split(",");
								break;
						}
					}
					
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
