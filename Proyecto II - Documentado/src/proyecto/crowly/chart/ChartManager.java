package proyecto.crowly.chart;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import proyecto.crowly.library.*;

import proyecto.crowly.interfaces.IConstants;
import proyecto.crowly.logic.*;

public abstract class ChartManager implements IConstants
{
	protected String file; //file of String type
	protected TextReader objectReader; //objectReader of TextReader
	
	public ChartManager()
	{
		objectReader = TextReader.getInstance(); //get the instance
	}
	
	protected ArrayList<ArrayList> createGraphy(ArrayList<VideoContein> pListOfVideoContein) //create the Graphy
	{
		ArrayList<ArrayList> Statistics = new ArrayList<ArrayList>();
		ArrayList Header = new ArrayList();
		
		Header.add(TIME_HEADER);
		Header.add(PEOPLE_HEADER);
		Statistics.add(Header);
		
		SimpleDateFormat Formatter = new SimpleDateFormat("HH:mm:ss");
		for(int i = 0; i < pListOfVideoContein.size(); i++) 
		{
			Date Hour = pListOfVideoContein.get(i).getHour();
			int MountOfBody = pListOfVideoContein.get(i).getMountOfBody();
			ArrayList Data = new ArrayList();
			String HourString = Formatter.format(Hour);
			Data.add(SINGLE_QUOTE + HourString + SINGLE_QUOTE);
			Data.add(MountOfBody);
			Statistics.add(Data);
		}
		return Statistics;
	}
	
	public void openBrowser() //open the Browser
	{
		File archivo = new File(this.file); 
		Runtime runTime = Runtime.getRuntime(); 
		try 
		{
			Process p = runTime.exec(IConstants.GOOGLE_CHROME + archivo);
		} 
		catch (IOException e) 
		{
		} 
	}
	
	public GraphyType getType()
	{
		return null;
	}
	
	public void generateGraphy(ArrayList<VideoContein> pListOfVideoContein) 
	{		
	}
}