package proyecto.crowly.logic;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONObject;

import proyecto.crowly.interfaces.*;

public class MSClient implements IConstants
{
	private ArrayList<Body> Bodies; //arraylist of the bodies
	private ArrayList<VideoResponse> PendingVideos; //the pending video to be processed
	
	public MSClient()
	{ 
		Bodies = new ArrayList<Body>(); //create the arraylist
		PendingVideos = new ArrayList<VideoResponse>(); //create the arraylist
	}
	
	public ArrayList<Body> getBodies() 
	{
		return Bodies;
	}

	public ArrayList<VideoResponse> getPendingVideos() 
	{
		return PendingVideos;
	}
	
	public void processVideo(String pURLVideo) //processe the videos
	{
		String payload = POST_BODY.replace("@@URL@@", pURLVideo);
		VideoResponse videoResp = HttpRequestor.post(MCS_URL, payload, MCS_IDKEY); //do the http request
		videoResp.setVideoUrl(pURLVideo);
		if (videoResp!=null)
		{
			PendingVideos.add(videoResp);
		}
	}
	
	public void processAnswerVideo(VideoResponse pVideoResponse) throws ParseException //process the answer
	{
		HttpRequestor.get(pVideoResponse, MCS_IDKEY);
		loadBodys(pVideoResponse);
	}
		
	private void loadBodys(VideoResponse pVideoResponse) throws ParseException
	{
		// processe the Json and create the bodies that come in the Json and are added to the arraylist(Bodies) 
		SimpleDateFormat Formatter = new SimpleDateFormat("HH:mm:ss"); //take the date in that format
		JsonParse JsonParse = new JsonParse();

		String Json = pVideoResponse.getContent();
		JSONObject AnswerObject =  JsonParse.parseJson(Json);
		String Result = (String) AnswerObject.get(PROCESSING_RESULT);
		JSONObject ProcessResult = JsonParse.parseJson(Result);
		ArrayList<JSONObject> Framents = JsonParse.getValue(ProcessResult, FRAGMENTS) ;
		int counterFrament = 0;
		while(Framents.size() != counterFrament) //while counter be different from the size
		{
			ArrayList<ArrayList<JSONObject>> events = (ArrayList<ArrayList<JSONObject>>) Framents.get(counterFrament).get(EVENT);
			if (events != null)
			{
				int counterEvent = 0;
				while(events.size() > counterEvent)
				{
					ArrayList<JSONObject> event = events.get(counterEvent);
					if (event.size() == 0)
					{
						counterEvent++;
					}
					else
					{
						Date time = Formatter.parse(LIST_OF_HOURS_OF_THE_VIDEOS.get(pVideoResponse.getVideoUrl()));  // LIST_OF_HOURS_OF_THE_VIDEOS.get()
						JSONObject motionEvent = event.get(0);
						ArrayList<JSONObject> Motion = JsonParse.getValue(motionEvent,LOCATION);
						JSONObject Data = Motion.get(0);
						double x = (double) Data.get(AXIS_X);
						double y = (double) Data.get(AXIS_Y);
						counterEvent++;
						Body body = new Body(x,y,time);
						this.Bodys.add(body); //takes the body and is added
					}
				}
				counterFrament++;
			}
			else
			{
				counterFrament++;
			}
		}
	}
}