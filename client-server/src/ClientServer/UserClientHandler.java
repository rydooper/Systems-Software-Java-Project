package ClientServer;

import java.net.*;
import java.io.*;

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
    
	public boolean VerifyUserLogin(String loginData) throws IOException
	{
		String file_nameUser="usernames.txt";
        String file_namePass="passwords.txt";

		readFile file = new readFile(file_nameUser);
        String[] aryLines = file.openFile(); 

		String[] loginDetails = loginData.split(",");		
		String username = loginDetails[0];
		String password = loginDetails[1];
		
		int i=0;
            
		//loops for length of aryLines
		while (i < aryLines.length) {
			//checks if aryLines[i] is equal to user's username input
			if (aryLines[i].equals(username)){
				
				//only checks password at same index (i) if username exists
				readPasswordFile passfile = new readPasswordFile(file_namePass);
				String[] passLines = passfile.openFile();
				if(passLines[i].equals(password)) {
					return true;
					//foundUser and foundPass used later
				}
			}
			i++;
		}
		return false;		
	}
	
    @Override
    public void run(){
        try{
			while(true){
				String inText = inFromClient.readUTF();
            	System.out.println("Server receives message: " + inText);
				String[] receivedData = inText.split(",");
				String identifier = receivedData[0];

				System.out.println(identifier);
				if(identifier.equals("LOGIN")){

					String loginData = receivedData[1] +","+ receivedData[2]; 
					boolean validLogin = VerifyUserLogin(loginData);

					if(validLogin){
						outToClient.writeBoolean(true);
					}
					else{
						outToClient.writeBoolean(false);
					}
				}

				else if(identifier.equals("FIELD DATA")){
					outToClient.writeUTF(Server.GenerateFieldData());
				}

				else if(identifier.equals("WEATHER STATION")){
					outToClient.writeInt(Server.wsClients.size());
				}
			}

        } 
		catch(IOException e){
	    	System.out.println("UserHandler IOError: " + e.getMessage());
		}
    }
}
