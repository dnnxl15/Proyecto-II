package proyecto.crowly.logic;

import proyecto.crowly.interfaces.*;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpRequestor implements IConstants
{
	public static VideoResponse post(String pUrl, String pPayload, String pMSKey) //post of the VideoResponse
	{
		VideoResponse Result = null;
		HttpClient Httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder Builder = new URIBuilder(pUrl);
            URI Uri = Builder.build();
            HttpPost Request = new HttpPost(Uri);
            Request.setHeader(CONTENT_TYPE, JSON_APPLICATION);
            Request.setHeader(SUBSCRIPTION_KEY, pMSKey);

            // Request body
            StringEntity ReqEntity = new StringEntity(pPayload);
            Request.setEntity(ReqEntity);

            HttpResponse Response = Httpclient.execute(Request);
            HttpEntity Entity = Response.getEntity();
                                                
            if (Entity != null) 
            {
                String location = Response.getHeaders(LOCATION_RESULT_URL_KEY).length>0?Response.getHeaders(LOCATION_RESULT_URL_KEY)[0].getValue() : "";
                String key = Response.getHeaders(LOCATION_RESULT_URL_KEY).length>0?Response.getHeaders(LOCATION_RESULT_ACCESS_KEY)[0].getValue() : "";            	
                Result = new VideoResponse(location, key, EntityUtils.toString(Entity));
            }
        }
        catch (Exception e)
        {
        }
        return Result;
	}
	
	public static VideoResponse get(VideoResponse pVideoResponse, String pMSKey) //get the video response
	{
		HttpClient Httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder Builder = new URIBuilder(pVideoResponse.getVideoResponseURL());

            URI Uri = Builder.build();
            HttpGet Request = new HttpGet(Uri);
            Request.setHeader(CONTENT_TYPE, JSON_APPLICATION);
            Request.setHeader(SUBSCRIPTION_KEY, pMSKey);

            HttpResponse Response = Httpclient.execute(Request);
            HttpEntity Entity = Response.getEntity();
                                                
            if (Entity != null) 
            {
                pVideoResponse.setContent(EntityUtils.toString(Entity));
            }
        }
        catch (Exception e)
        {
        }
        return pVideoResponse;
	}
}
