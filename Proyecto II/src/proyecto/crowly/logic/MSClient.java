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
	private ArrayList<Body> Bodys; //Arraylist of the bodies
	private ArrayList<VideoResponse> PendingVideos; //arraylist of the video response
	
	public MSClient()
	{
		Bodys = new ArrayList<Body>();
		PendingVideos = new ArrayList<VideoResponse>();
	}
	
	public ArrayList<Body> getBodys() //get all the bodies 
	{
		return Bodys;
	}

	public ArrayList<VideoResponse> getPendingVideos() 
	{
		return PendingVideos;
	}
	
	public void processVideo(String pURLVideo) //processed videos
	{
		String payload = POST_BODY.replace("@@URL@@", pURLVideo);
		VideoResponse videoResp = HttpRequestor.post(MCS_URL, payload, MCS_IDKEY);
		videoResp.setVideoUrl(pURLVideo);
		if (videoResp!=null)
		{
			PendingVideos.add(videoResp); //add the videoResp to the Pending videos
		}
	}
	
	public void processAnswerVideo(VideoResponse pVideoResponse) throws ParseException //process the answer video
	{
		HttpRequestor.get(pVideoResponse, MCS_IDKEY);
		loadBodys(pVideoResponse);
	}
		
	private void loadBodys(VideoResponse pVideoResponse) throws ParseException //load the bodies
	{
		//the Json is processed here
		SimpleDateFormat Formatter = new SimpleDateFormat("HH:mm:ss");
		JsonParse JsonParse = new JsonParse();

		String Json = pVideoResponse.getContent();
		JSONObject AnswerObject =  JsonParse.parseJson(Json);
		String Result = (String) AnswerObject.get(PROCESSING_RESULT);
		JSONObject ProcessResult = JsonParse.parseJson(Result);
		ArrayList<JSONObject> Framents = JsonParse.getValue(ProcessResult, FRAGMENTS) ;//  getValue(IConstants.LIST_OF_JSON_KEYS[0]);
		int counterFrament = 0;
		while(Framents.size() != counterFrament)
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
						this.Bodys.add(body);
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