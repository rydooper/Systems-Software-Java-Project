package ClientServer;

import java.net.*;
import java.io.*;

public class WeatherStationHandler implements Runnable {
    Socket client;
    DataOutputStream outToClient;
    DataInputStream inFromClient;
	static String wsData;
    public WeatherStationHandler(Socket _client) throws IOException{
		//Gets client socket and initializes data streams 
		System.out.println("WSHandler Active");
        client = _client;
        outToClient = new DataOutputStream(client.getOutputStream());
        inFromClient = new DataInputStream(client.getInputStream());
    }
    
    @Override
    public void run(){
		try{
			wsData = inFromClient.readUTF();
			System.out.println("WSH Data: "+wsData+ "|| wsClients size: " +Server.wsClients.size());
			Server.WSDataMap.put(Server.wsClients.size(), wsData); 
			/*
			while(true){
				if(Server.wsDataRequest){
					outToClient.writeBoolean(true);	
				}
				String inText = inFromClient.readUTF();
				wsData = inText;

			}   */ 
		} 
		catch(IOException e){
			System.out.println("WSHandler IOError: " + e.getMessage());
		}	
    }
}
