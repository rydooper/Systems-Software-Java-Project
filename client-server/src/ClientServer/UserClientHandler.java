package ClientServer;

import java.net.*;
import java.io.*;

public class UserClientHandler implements Runnable {
    Socket client;
    DataOutputStream outToClient;
    DataInputStream inFromClient;
	String thisUser;
	
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
						String[] loginDetails = loginData.split(",");		
						thisUser = loginDetails[0];
					}
					else{
						outToClient.writeBoolean(false);
					}
				}

				else if(identifier.equals("FIELD DATA")){
					outToClient.writeUTF(Server.GenerateFieldData());
				}

				else if(identifier.equals("WEATHER STATION SIZE")){
					outToClient.writeInt(Server.wsClients.size());
				}

				else if(identifier.equals("WEATHER STATION")){
					int WSKey = Integer.parseInt(receivedData[1]);

					outToClient.writeInt(WSKey);
					outToClient.writeUTF(Server.FetchWSData(WSKey));
				}
			
				else if(identifier.equals("ADMIN INFO")){
					boolean isAdmin = false;

					String admins_file = "admins.txt";
					readFile adminFile = new readFile(admins_file);

					try{
						String[] adminLines = adminFile.openFile();
						for(String admin : adminLines){
							if(admin.equals(thisUser)){
								isAdmin = true;
								outToClient.writeBoolean(isAdmin);
								break;
							}
						}
					}
					catch(IOException e){
						System.out.println(e.getMessage());
					}
					String listUsername_file = "usernames.txt";
					readFile usernameFile = new readFile(listUsername_file);

					try {
						String[] usernameLines = usernameFile.openFile();
						String allUsernameString = "";
						for (String username : usernameLines){
							allUsernameString += username + "\n";
						}
						outToClient.writeUTF(allUsernameString);
					} 
					catch (IOException e){
						System.out.println(e.getMessage());
					}
						
					
				}

			}

        } 
		catch(IOException e){
	    	System.out.println("UserHandler IOError: " + e.getMessage());
		}
    }
}
