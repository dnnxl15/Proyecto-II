package proyecto.crowly.logic;

public class VideoResponse 
{
	private String VideoResponseURL; //response of the video URL
	private String VideoKey; //the key to do the response
	private String Content; //the content that the video would has
	private String VideoUrl; //the URL of the video
	private boolean Processed; //processe the video
	
	public VideoResponse(String pURL, String pKey, String pContent)
	{ //inicialization of the variables
		VideoResponseURL = pURL;
		VideoKey = pKey;
		Content = pContent;
		Processed = false;
	}

/*~~~~~~~~~~~~~~~~~~GETTERS & SETTERS~~~~~~~~~~~~~~~~~~*/
	public String getVideoResponseURL() 
	{
		return VideoResponseURL;
	}

	public void setVideoResponseURL(String videoResponseURL) 
	{
		VideoResponseURL = videoResponseURL;
	}
	
	public void setVideoUrl(String pVideoUrl)
	{
		VideoUrl = pVideoUrl;
	}
	
	public String getVideoUrl()
	{
		return VideoUrl;
	}

	public String getVideoKey() 
	{
		return VideoKey;
	}

	public void setVideoKey(String videoKey)
	{
		VideoKey = videoKey;
	}

	public boolean isProcessed() 
	{
		return Processed;
	}

	public void setPProcessed(boolean processed) 
	{
		Processed = processed;
	}

	public String getContent() 
	{
		return Content;
	}

	public void setContent(String content) 
	{
		Content = content;
	}
}