/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClientServer;

import java.io.*;
import java.util.*;
/**
 *
 * @author ryder
 */

public class readFile {

    private String path;
    
    public readFile(String file_path) {
        path = file_path;
    }
    
    //generates file length
    int readLines() throws IOException {
        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);
        
        String aLine;
        int numLines =0;
        
        while ((aLine = bf.readLine()) != null) {
            numLines++;
        }
        bf.close();
        
        return numLines;
    }
    
    //generates array of file content
    public String[] openFile() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        
        int numLines = readLines();
        String[] textData = new String[numLines];
        
        int i;
        
        for(i=0; i < numLines; i++) {
            textData[i] = textReader.readLine();
        }
        
        textReader.close();
        return textData;
    } 
            
}