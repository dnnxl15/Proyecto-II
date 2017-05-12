package proyecto.crowly.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TextReader 
{
	public String readFile(String pFile)
	{
		String texto = "";
	    try
	    { 
	    	File Archivo = new File(pFile); // Crea el archivo.
	    	FileReader fr = new FileReader(Archivo); // Crea el file.
	    	BufferedReader bf = new BufferedReader(fr);  // Lo lee.
	   		String linea;
	   		String cadena = "";
	   		while ((linea = bf.readLine()) != null)
	   		{
    			cadena = cadena + linea;
    		}
	    	texto = cadena;
	   		bf.close();
	   	}
	   	catch(Exception e)
	   	{
    	}
	    return texto;
	}
	
	public String readHtml(String pFile) throws IOException
	{
		String cadena;
	    String lineas = "";
	    FileReader f = new FileReader("ejemplo.html");
	    BufferedReader b = new BufferedReader(f);
	    while((cadena = b.readLine())!=null) 
	    {
	    	System.out.println(cadena);
	        lineas = lineas + b.readLine();

	    }
	    b.close();
	    return lineas;
	}
	
	public void writeFileHtml(String pContent, String pFileName) throws IOException
	{
		FileWriter filewriter = null;
		PrintWriter printw = null;        
		 try
		 {
			 filewriter = new FileWriter(pFileName);//declarar el archivo
	         printw = new PrintWriter(filewriter);//declarar un impresor
		     printw.println(pContent);
		     printw.close();//cerramos el archivo
		 }
		 finally
		 {
			 
		 }
	}
	
	public static void main(String[] args)
	{
		/*
		TextReader n = new TextReader();
		String p = n.readFile("C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/BarChartHeader.txt");
		p = p.replace("@@DATA@@","hooooo");
		//p.replaceAll("@@DATA@@", "hello");
		System.out.println(n.readFile("C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/BarChartHeader.txt"));
		System.out.println(p);*/
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");

		
		String p = list.toString();
		System.out.println(p);

	}
}