package proyecto.crowly.logic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import proyecto.crowly.interfaces.*;
import javax.net.ssl.HttpsURLConnection;

public class HttpRequestor implements IConstants
{

	public static VideoResponse post(String pUrl, String pPayload, String pMSKey)
	{
		VideoResponse result = null;
		
		HttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder(pUrl);

            /*
            builder.setParameter("sensitivityLevel", "{string}");
            builder.setParameter("frameSamplingValue", "{number}");
            builder.setParameter("detectionZones", "{string}");
            builder.setParameter("detectLightChange", "{boolean}");
            builder.setParameter("mergeTimeThreshold", "{number}");
            */
            
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", pMSKey);

            // Request body
            StringEntity reqEntity = new StringEntity(pPayload);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
                                                
            if (entity != null) 
            {
                String location = response.getHeaders(LOCATION_RESULT_URL_KEY).length>0?response.getHeaders(LOCATION_RESULT_URL_KEY)[0].getValue() : "";
                String key = response.getHeaders(LOCATION_RESULT_URL_KEY).length>0?response.getHeaders(LOCATION_RESULT_ACCESS_KEY)[0].getValue() : "";            	
                result = new VideoResponse(location, key, EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
		return result;
	}
	
	public static VideoResponse get(VideoResponse pVideoResponse, String pMSKey)
	{
		
		HttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder(pVideoResponse.getVideoResponseURL());

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", pMSKey);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
                                                
            if (entity != null) 
            {
                pVideoResponse.setContent(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
		return pVideoResponse;
	}
	
}
