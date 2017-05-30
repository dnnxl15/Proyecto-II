package proyecto.crowly.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextReader 
{
	private static TextReader Instance; //instance

	private TextReader()
	{
	}
	
	public synchronized static TextReader getInstance() //synchronized the TextReader
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
	    	File TextFile = new File(pFile); //TextFile of the File type
	    	FileReader ReaderText = new FileReader(TextFile);  //ReaderText of the FileReader type
	    	BufferedReader ReaderBuffer = new BufferedReader(ReaderText); //ReaderBuffer of the BufferedReader type
	   		String Line;
	   		String Chain = "";
	   		while ((Line = ReaderBuffer.readLine()) != null) //read each line
	   		{
	   			Chain = Chain + Line;
    		}
	    	Text = Chain; //Text equal to CHain
	    	ReaderBuffer.close();
	   	}
	   	catch(Exception e)
	   	{
    	}
	    return Text;
	}
	
	public void writeFile(String pContent, String pFileName) throws IOException //write the file
	{
		FileWriter WriterFile = null; //WriterFile of FileWriter type
		PrintWriter WriterPrinter = null; //WeiterPrinter of PrintWriter type equals to null 
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