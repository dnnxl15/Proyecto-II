package proyecto.crowly.logic;

import java.util.ArrayList;

import proyecto.crowly.interfaces.*;

public class VideoProcesor implements IConstants
{
	private MSClient MsClient; //the MsClient of the type MSCliente
	private ArrayList<Body> Bodys; //arraylist of the bodies
	
	public VideoProcesor()
	{
		MsClient = new MSClient();
	}
	
	public ArrayList<Body> getBodys() //grt the bodies
	{
		return this.Bodys;
	}
	
	public void analyzeVideos() //analyze the videos
	{
		try 
		{
			for(String UrlVideo : LIST_OF_VIDEOS) //analyze each video
			{
				MsClient.processVideo(UrlVideo);
				Thread.sleep(WAIT_BETWEEN_CALLS); //the thread sleep between calls
			}
			
			Thread.sleep(WAIT_BETWEEN_CALLS); //the thread sleep between calls
			
			for(VideoResponse Video : MsClient.getPendingVideos())  //analyze the pending videos
			{
				MsClient.processAnswerVideo(Video);
				Thread.sleep(WAIT_BETWEEN_CALLS); //the thread sleep between calls
			}
			
			Bodys = MsClient.getBodys(); //get the bodies
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
