package com.lynda.javatraining.characterstreams;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
	
		String fileName = "textfile.txt";
		String line = null;
		try {
			 FileReader fileReader = 
		                new FileReader(fileName);

		            // Always wrap FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);

		            while((line = bufferedReader.readLine()) != null) {
		           
		                System.out.println(line);
		            
		            } 
		            bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}