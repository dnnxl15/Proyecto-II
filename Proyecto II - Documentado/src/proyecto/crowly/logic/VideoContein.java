package proyecto.crowly.logic;

import java.util.Date;

public class VideoContein 
{
	private Date Hour; //the hour as a Date variable
	private int MountOfBody; //the quantity of bodies
	
	public VideoContein(Date pHour, int pMountOfBody)
	{ //inicialization of the variables
		Hour = pHour;
		MountOfBody = pMountOfBody;
	}

/*~~~~~~~~~~~~~~~~~~GETTERS & SETTERS~~~~~~~~~~~~~~~~~~*/
	public int getMountOfBody()
	{
		return MountOfBody;
	}
	
	public void setMountOfBody(int mountOfBody) 
	{
		MountOfBody = mountOfBody;
	}

	public Date getHour() 
	{
		return Hour;
	}

	public void setHour(Date hour) 
	{
		Hour = hour;
	}
}
