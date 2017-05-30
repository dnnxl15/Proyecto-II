package proyecto.crowly.logic;

import java.util.Date;
import java.util.UUID;

public class Body 
{
	private double PositionX; //position on the axis x
	private double PositionY; //position on the axis y
	private Date Time; //time of th Date type
	private UUID Id; //id
	
	public Body(double pX, double pY, Date pVideoTime)
	{
		Id = UUID.randomUUID();
		Time = pVideoTime;
		PositionY = pY;
		PositionX = pX;
	}

/*~~~~~~~~~~~~~~~~~GETTERS & SETTERS~~~~~~~~~~~~~~~~~*/	
	public double getPositionX() 
	{
		return PositionX;
	}

	public void setPositionX(int pPositionX)
	{
		PositionX = pPositionX;
	}

	public double getPositionY() 
	{
		return PositionY;
	}

	public void setPositionY(int pPositionY) 
	{
		PositionY = pPositionY;
	}

	public Date getTime() 
	{
		return Time;
	}

	public void setTime(Date pTime) 
	{
		this.Time = pTime;
	}

	public UUID getId() 
	{
		return Id;
	}

	public void setId(UUID pId) 
	{
		Id = pId;
	}	
}
