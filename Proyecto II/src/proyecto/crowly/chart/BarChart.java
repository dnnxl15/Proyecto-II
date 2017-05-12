package proyecto.crowly.chart;

import proyecto.crowly.interfaces.IConstants;
import proyecto.crowly.logic.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BarChart extends ChartManager
{
	public BarChart(ArrayList<Body> pListBody)
	{
		
	}
	
	public List<List> generateGraphy(ArrayList<Body> pListBody)
	{
		return null;// se crea la lista[[],[]]
	}
	
	public String createGraphy(List<List> pContent)
	{
		TextReader n = new TextReader();
		String p = n.readFile(IConstants.LIST_OF_FILES_CHARTS[0]);//"C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/BarChartHeader.txt");
		
		p = p.replace(IConstants.IDENTIFIER,pContent);
		return p; // se crea el grafico
	}
	
	public void openBrowser(String pFile)
	{
		File archivo = new File(pFile);//"C:/Users/dnnxl/Documents/CodeHtml.html"); 
		Runtime runTime = Runtime.getRuntime(); 
		try 
		{
			Process p = runTime.exec(IConstants.GOOGLE_CHROME + archivo);
		} 
		catch (IOException e) 
		{
		}//"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe "+archivo); 
	}
	
	/*
	
	public void mostrar()
	{
		try{ //codigo que sirve
			File archivo = new File("C:/Users/dnnxl/Documents/CodeHtml.html"); 
			Runtime runTime = Runtime.getRuntime(); 
			Process p = runTime.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe "+archivo); 
			}catch(IOException e1){ 
			System.out.print(e1.toString()); 
			} 
		
		
		
		/*
		FileWriter html=null;
	    PrintWriter pw=null;
	    html=new FileWriter("BarChart.html");
        pw=new PrintWriter(leer("C:/Users/dnnxl/Documents/codigo.txt"));
        pw.println();
        html.close();*/
/*	}
	
	
	
	
	public String leer(String direccion){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		// Declaramos unas variables que necesitaremos luego
		
		// se utiliza un try/catch por el hecho de trabajar con buffers
		try {
			archivo = new File (direccion);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			String p; 
			while ((linea=br.readLine())!=null)
				p = p +linea;
			return p;}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(null!=fr){
					fr.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}*/
}
