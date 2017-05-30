package proyecto.crowly.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BodyProcesor 
{
	private ArrayList<VideoContein> ListOfVideoContein; //ListOfVideoContein is an arrayList
	private ArrayList<Body> ListOfBody; //list of body is an arraylist of the bodies
	
	public BodyProcesor() //processe the videos
	{
		setListOfVideoContein(new ArrayList<VideoContein>());
		ListOfBody  = new ArrayList<Body>();
	} 
	
	public void analyzeBodys(ArrayList<Body> pListOfBody)
	{
		ArrayList<Double> ListOfAxis = new ArrayList<Double>(); //list of the axis where the body pass
		for (int i = 0; i < pListOfBody.size(); i++)
		{
			double AxiX = pListOfBody.get(i).getPositionX();
			boolean AxiXBoolean = ListOfAxis.contains(AxiX);
			if(AxiXBoolean == false)
			{
				ListOfAxis.add(AxiX);
				ListOfBody.add(pListOfBody.get(i));
			}
		}		
	}
	
	public void generateVideoContein() //generate the video contain
	{
		ArrayList<Long> ListOfDate = new ArrayList<Long>(); //list of date that the videos were recorded
		for (int i = 0; i < ListOfBody.size(); i++)
		{
			Date Hour = ListOfBody.get(i).getTime();
			
			if(ListOfDate.contains(Hour.getTime()))
			{
			}
			else
			{
				ListOfDate.add(Hour.getTime());
				int MountOfBody = countBody(Hour);
				VideoContein ConteinVideo = new VideoContein(Hour, MountOfBody);
				ListOfVideoContein.add(ConteinVideo);
			}
		}		
	}
	
	private int countBody(Date pDate) //function that count every body
	{
		SimpleDateFormat Formatter = new SimpleDateFormat("HH:mm:ss"); //the formatter to take the date
		int Counter = 0;
		for (int i = 0; i<ListOfBody.size(); i++)
		{
			Date Hour = ListOfBody.get(i).getTime();
			String HourDate = Formatter.format(Hour).toString();
			String ParameterHourDate = Formatter.format(pDate).toString();
			if(ParameterHourDate.equals(HourDate))
			{
				Counter++;
			}
		}
		return Counter;
	}

	public ArrayList<VideoContein> getListOfVideoContein() 
	{
		return ListOfVideoContein;
	}

	public void setListOfVideoContein(ArrayList<VideoContein> listOfVideoContein) 
	{
		ListOfVideoContein = listOfVideoContein;
	}
}
