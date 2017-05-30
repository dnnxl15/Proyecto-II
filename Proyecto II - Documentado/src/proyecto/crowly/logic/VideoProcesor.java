package proyecto.crowly.logic;

import java.util.ArrayList;

import proyecto.crowly.interfaces.*;

public class VideoProcesor implements IConstants
{
	private MSClient MsClient; //the MsClient variable of the type MSClient
	private ArrayList<Body> Bodys; //arraylist of the bodies 
	
	public VideoProcesor() 
	{
		MsClient = new MSClient();
	}
	
	public ArrayList<Body> getBodys()
	{
		return this.Bodys;
	}
	
	public void analyzeVideos() //analyze the videos
	{
		try 
		{
			for(String UrlVideo : LIST_OF_VIDEOS) //for that analyze every video
			{
				MsClient.processVideo(UrlVideo);
				Thread.sleep(WAIT_BETWEEN_CALLS); //sleep the thread
			}
			
			Thread.sleep(60000); //sleep of 6 minutes
			
			for(VideoResponse Video : MsClient.getPendingVideos()) //have the pending videos 
			{
				MsClient.processAnswerVideo(Video);
				Thread.sleep(WAIT_BETWEEN_CALLS); //sleep the thread
			}
			
			Bodys = MsClient.getBodys(); //obtain the bodies
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
