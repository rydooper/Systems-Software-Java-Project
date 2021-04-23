package ClientServer;

import java.net.*;
import java.io.*;
//UNFINISHED - Currently just connects and does nothing else
public class UserClient implements Runnable {
    
	static boolean validLogin;
	static String[] fieldData;
	static int numWeatherStations;
	static boolean isAdmin;
	static String allUsersString;
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
						String[] dataRequestParsed = mainMenuUI.dataRequest.split(",");
						menuOption = dataRequestParsed[0]; 
						mainMenuUI.buttonPressed = false;

						if(!menuOption.isEmpty()){
							switch(menuOption){
								case "FIELD DATA":
									String fieldDataString = inFromServer.readUTF();
									fieldData = fieldDataString.split(",");
									break;

								case "WEATHER STATION SIZE":
									numWeatherStations = inFromServer.readInt();
									System.out.println(numWeatherStations);
									break;

								case "WEATHER STATION":
									Integer key = inFromServer.readInt();
									String wsData = inFromServer.readUTF();
									StationDataDisplayUI.WSData.put(key,wsData.split(","));
									break;

								case "ADMIN INFO":
									isAdmin = inFromServer.readBoolean();
									allUsersString = inFromServer.readUTF();
									break;
							}
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
