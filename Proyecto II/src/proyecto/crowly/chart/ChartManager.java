package proyecto.crowly.chart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proyecto.crowly.interfaces.IConstants;
import proyecto.crowly.library.*;
import proyecto.crowly.logic.*;

public abstract class ChartManager implements IConstants
{
	public List<List> generateGraphy(ArrayList<Body> pListBody)
	{
		return null;// se crea la lista[[],[]]
	}
	
	public String createGraphy(String pContent)
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
}
