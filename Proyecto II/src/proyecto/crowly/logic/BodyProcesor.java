package proyecto.crowly.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BodyProcesor 
{
	private ArrayList<VideoContein> ListOfVideoContein; //ListOfVideoContein an arraylist type
	private ArrayList<Body> ListOfBody; //ListOfBody an arrayList of the body
		
	public BodyProcesor() //process the body
	{
		setListOfVideoContein(new ArrayList<VideoContein>());
		ListOfBody  = new ArrayList<Body>();
	} 
	
	public void analyzeBodys(ArrayList<Body> pListOfBody) //analyze the body
	{
		ArrayList<Date> ListDate = getDatesFromBody(pListOfBody);
		for (int i = 0; i < ListDate.size(); i++) //analyze while the i < of the size of the ListDate
		{
			ArrayList<Body> ListBodyByHour =  getBodyByDate(pListOfBody, ListDate.get(i));
			processBody(ListBodyByHour);
		}		
	}
	
	public void processBody(ArrayList<Body> pListOfBody) //process the bodies
	{
		ArrayList<Double> ListOfAxis = new ArrayList<Double>();
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
	
	public ArrayList<Date> getDatesFromBody(ArrayList<Body> pListBody) //get the date of each bosy
	{
		ArrayList<Long> DateMiliseconds = new ArrayList<Long>();
		ArrayList<Date> ListDate = new ArrayList<Date>();
		for (int i =0; i < pListBody.size(); i++)
		{
			long MiliHours = pListBody.get(i).getTime().getTime();
			boolean ConteinTheHour = DateMiliseconds.contains(MiliHours);
			if(ConteinTheHour == false)
			{
				DateMiliseconds.add(MiliHours);
				ListDate.add(pListBody.get(i).getTime());
			}
		}
		return ListDate;
	}
	
	public ArrayList<Body> getBodyByDate(ArrayList<Body> pListBody, Date pDate) //get the body by having the date
	{
		ArrayList<Body> ListBody = new ArrayList<Body>();
		for (int i =0; i < pListBody.size(); i++)
		{
			long MiliHours = pListBody.get(i).getTime().getTime();
			long MiliHoursDate = pDate.getTime();
			if(MiliHours == MiliHoursDate)
			{
				ListBody.add(pListBody.get(i));
			}
		}
		return ListBody;
		
	}
	
	public void generateVideoContein() //generate the contein of the video
	{
		ArrayList<Long> ListOfDate = new ArrayList<Long>();
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
	
	private int countBody(Date pDate) //count all the body that pass
	{
		SimpleDateFormat Formatter = new SimpleDateFormat("HH:mm:ss"); //fomat to take the date
		int Counter = 0;
		for (int i = 0; i<ListOfBody.size(); i++)
		{
			Date Hour = ListOfBody.get(i).getTime(); //get the time in Hour
			String HourDate = Formatter.format(Hour).toString(); //convert to string the hour
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
