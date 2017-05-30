package proyecto.crowly.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextReader 
{
	private static TextReader Instance; //the instance of textReader

	private TextReader()
	{
	}
	
	public synchronized static TextReader getInstance() //Synchronize the textReader
	{
		if (Instance==null)
		{
			Instance = new TextReader();
		}
		return Instance;
	}
	
	
	public String readFile(String pFile) //read the file
	{
		String Text = "";
	    try
	    { 
	    	File TextFile = new File(pFile); //create a TextFile of File type
	    	FileReader ReaderText = new FileReader(TextFile); 
	    	BufferedReader ReaderBuffer = new BufferedReader(ReaderText);
	   		String Line;
	   		String Chain = "";
	   		while ((Line = ReaderBuffer.readLine()) != null) //read line by line
	   		{
	   			Chain = Chain + Line; //would storage the Line on the Chain variable
    		}
	    	Text = Chain; 
	    	ReaderBuffer.close();
	   	}
	   	catch(Exception e)
	   	{
    	}
	    return Text;
	}
	
	public void writeFile(String pContent, String pFileName) throws IOException
	{
		FileWriter WriterFile = null; //the WriterFile of the FileWriter equals to null
		PrintWriter WriterPrinter = null; //the WriterPrinter of the PrintWriter equals to null
		 try
		 {
			 WriterFile = new FileWriter(pFileName);
			 WriterPrinter = new PrintWriter(WriterFile);
			 WriterPrinter.println(pContent);
			 WriterPrinter.close();
		 }
		 finally
		 {
		 }
	}
}