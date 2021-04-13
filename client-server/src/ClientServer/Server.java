package ClientServer;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

	//Array lists to store current connections
    public static List<Integer> openPorts = new ArrayList<>(); 
    public static ArrayList<WeatherStationHandler> wsClients = new ArrayList<>();
    private static ArrayList<UserClientHandler> userClients = new ArrayList<>();
	
	public static HashMap<Integer, String> WSDataMap = new HashMap<>();
    static boolean wsDataRequest = false; 
    
    public static void main(String[] args) throws IOException{
        try{
            ServerSocket server = new ServerSocket(9090);
            while(true){
                Socket client = server.accept();
                System.out.println("Server recieves connection: " + client); 
				DataInputStream inFromClient = new DataInputStream(client.getInputStream());
				//The first communication from the client.
				//Identifies them as either a Weather Station or a User (Farmer client)
				String identifier = inFromClient.readUTF();
		
				if (identifier.equals("WS")){
					openPorts.add(client.getPort());
					//Creates handler for client, assigns it to a thread and then runs the thread
					WeatherStationHandler wsHandler = new WeatherStationHandler(client);
					Thread wsThread = new Thread(wsHandler);
					wsClients.add(wsHandler);
					wsThread.start();
				}
				//Same as above
				else if (identifier.equals("USR")){
					openPorts.add(client.getPort());
					UserClientHandler userHandler = new UserClientHandler(client);
					Thread userThread = new Thread(userHandler);
					userClients.add(userHandler);
					userThread.start();
				}
            }  
        }
        catch(IOException error){
            System.out.println("SERVER-ERROR: " + error.getMessage());
        }
    }     

	public static String GenerateFieldData(){
		Random RandGen = new Random(); 
		//www.w3schools.com/java/java_hashmap.asp
		String[] Crops = {"Wheat", "Corn", "Carrots", "Potatoes", "Barley"};
		HashMap<String, String[]> CropsData = new HashMap<>();
		CropsData.put("Wheat", new String[] {"Autumn", "Summer"});
		CropsData.put("Corn", new String[] {"Late Spring", "Late Autumn"});
		CropsData.put("Carrots", new String[] {"Spring", "Summer"});
		CropsData.put("Potatoes", new String[] {"Spring", "Autumn"});
		CropsData.put("Barley", new String[] {"Spring", "Winter"});

		int area = RandGen.nextInt(10)+1;
		String randCrop = Crops[(RandGen.nextInt(Crops.length))];
		String sowSeason = CropsData.get(randCrop)[0];
		String harvestSeason = CropsData.get(randCrop)[1];

		String data = randCrop + "," + sowSeason + "," + harvestSeason + "," + area;
		return data;
	}

	//issue stemps from around here
	public static String FetchWSData(int key){
		System.out.println("Fetch output: "+WSDataMap.get(key));
		return WSDataMap.get(key);
	}
}

