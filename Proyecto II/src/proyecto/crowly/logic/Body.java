package proyecto.crowly.logic;

import java.util.Date;
import java.util.UUID;

public class Body 
{
	private int PosX;
	private int PosY;
	private Date Time;
	private UUID Id;
	
	public Body(int pX, int pY, Date videoTime)
	{
		Id = UUID.randomUUID();
		Time = videoTime;
		PosY = pY;
		PosX = pX;
	}

	public int getPosX() 
	{
		return PosX;
	}

	public void setPosX(int posX)
	{
		PosX = posX;
	}

	public int getPosY() 
	{
		return PosY;
	}

	public void setPosY(int posY) 
	{
		PosY = posY;
	}

	public Date getTime() 
	{
		return Time;
	}

	public void setTime(Date time) 
	{
		this.Time = time;
	}

	public UUID getId() 
	{
		return Id;
	}

	public void setId(UUID id) 
	{
		Id = id;
	}	
}
