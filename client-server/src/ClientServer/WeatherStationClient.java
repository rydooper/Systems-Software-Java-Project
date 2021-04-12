package ClientServer;

import java.net.*;
import java.io.*;
import java.util.Random;


public class WeatherStationClient implements Runnable {
    public WeatherStationClient(){}
    Random RandGen = new Random(); 
	String[] Crops = {"Wheat", "Corn", "Carrots", "Potatoes", "Barley"};
	
	//Generates random weather data
	public String GenerateData(){
		int humidity = RandGen.nextInt(71);
		int wind = RandGen.nextInt(61);
		int precip = RandGen.nextInt(101);
		String data = String.valueOf(humidity) + ", " + String.valueOf(wind) + ", " + String.valueOf(precip);
		return data;
	}
	
    public synchronized void Connect(){
        try{
			String data = GenerateData();
		    InetAddress address = InetAddress.getByName("localhost");
            Socket server = new Socket(address, 9090);
            DataOutputStream outToServer = new DataOutputStream(server.getOutputStream());
			DataInputStream inFromServer = new DataInputStream(server.getInputStream());
			//Sends identifier to server
            outToServer.writeUTF("WS");
			outToServer.writeUTF(data);
			while(true){
				if(inFromServer.readBoolean()){
					outToServer.writeUTF(GenerateData());
				}
				
			} 
        }
        catch(IOException e){
            System.out.println("WeatherStation IOException: " + e.getMessage());
        }
    }
    
    @Override
    public void run(){
        try{
	    	Connect();
            Thread.sleep(50);	
            
        }
        catch(InterruptedException e){
	   		System.out.println("WSClient Interrupted Excpetion: " + e.getMessage()); 
		}
    }
	public static void main(String[] args)
	{
		WeatherStationClient wsClient = new WeatherStationClient();
		Thread wsThread = new Thread(wsClient);
		wsThread.start();
	}
}
