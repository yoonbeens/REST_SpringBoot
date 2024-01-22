package interface_practice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterApp {
	
	public static void main(String[] args) throws IOException {
		
		Writer fileWriter = new FileWriter("testFile.txt");
		
		fileWriter.write("test input data 1");
		fileWriter.close();
		
		
	}
	
	

}
