package proyecto.crowly.interfaces;

import java.util.HashMap;
import java.util.Map;

import proyecto.crowly.library.GraphyType;

public interface IConstants 
{
	public final String POST_BODY = "{ \"url\":\"@@URL@@\" }";
	
	public final String MCS_URL =  "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&frameSamplingValue=11"; //errores
	
	public final String[] LIST_OF_VIDEOS = 
	{
        "http://gdurl.com/nLO2", 
        "http://gdurl.com/UvHBr",	
        "http://gdurl.com/AIJp",	
        "http://gdurl.com/SSUP",	
        "http://gdurl.com/J4gF",	
        "http://gdurl.com/A45C",	
        "http://gdurl.com/WnOq",
        "http://gdurl.com/5tFZ",	
        "http://gdurl.com/nMFG"
	};
	
	public final Map<String, String> LIST_OF_HOURS_OF_THE_VIDEOS = new HashMap<String , String>(){
	{
		put("http://gdurl.com/nLO2","07:06:24");  
	    put("http://gdurl.com/UvHBr","07:12:14");	
		put("http://gdurl.com/AIJp","07:18:31");	
		put("http://gdurl.com/SSUP","12:42:51");	
		put("http://gdurl.com/J4gF","12:49:02");	
		put("http://gdurl.com/A45C","12:56:15");	
		put("http://gdurl.com/WnOq","20:08:07");
		put("http://gdurl.com/5tFZ","20:14:17");	
		put("http://gdurl.com/nMFG","20:21:37");
	}};
	
	
	public final String LOCATION_RESULT_URL_KEY = "Operation-Location";
	public final String LOCATION_RESULT_ACCESS_KEY = "apim-request-id";
	public final String CAMBIO_LINEA = "\n";
	
	public final int WAIT_BETWEEN_CALLS = 60000; // 
	
	public final String MCS_IDKEY = "e343f297a4244ad38c9d610e3146952f";//"f358e8ac97824d428aadfdc4a7bf6427";//"66c44f5d-34f2-48f6-89cc-1415d5f3452a";// "799dca11f3ca4e67b75c9aa34848823b"; // Clave de microsoft cambiar"http://gdurl.com/5oZW/download"
	
	
	
	
	// https://westus.api.cognitive.microsoft.com/video/v1.0/operations/0aa652fa-7f1e-42df-87f2-a81425a5c5bf
	
	
	
	public final String CONTENT_TYPE = "Content-Type";
	
	public final String JSON_APPLICATION = "application/json";
	
	public final String SUBSCRIPTION_KEY = "Ocp-Apim-Subscription-Key";
	
	public final String GOOGLE_CHROME = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe "; // Aplication direction.
		
	public final String TIME_HEADER = "'Time'";
	
	public final String PEOPLE_HEADER = "'People'";
	
	public final String IDENTIFIER = "@@DATA@@";
	
	public final String[] LIST_OF_FILES_CHARTS = 
	{
			"Crowly-Bar-GUID.html",
			"Crowly-Scatter-GUID.html",
			"Crowly-Line-GUID.html"
	};
	
	public final String[] LIST_OF_HEADERS_CHARTS = 
	{
			"C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/BarChartHeader.txt",
			"C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/LineChartHeader.txt",
			"C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/ScatterChartHeader.txt"
	};
	

	
	public final String FRAGMENTS = "fragments";
	
	public final String EVENT = "events";
	
	public final String LOCATION = "locations";
	
	public final String AXIS_X = "x";
	
	public final String AXIS_Y = "y";
	
	public final String PROCESSING_RESULT ="processingResult";

	public final int BAR_CHART = 0;
	
	public final int LINE_CHART = 1;
	
	public final int SCATTER_CHART = 2;
	
	public final String SINGLE_QUOTE = "'";
}

