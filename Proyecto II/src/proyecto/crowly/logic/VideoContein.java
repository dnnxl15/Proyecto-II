package proyecto.crowly.logic;

import java.util.Date;

public class VideoContein 
{
	private Date Hour; //variable of date type
	private int MountOfBody; //the mount of bodies
	
	public VideoContein(Date pHour, int pMountOfBody)
	{
		Hour = pHour;
		MountOfBody = pMountOfBody;
	}
	
/*~~~~~~~~~~~~~~~~~GETTERS & SETTERS~~~~~~~~~~~~~~~~~*/
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
