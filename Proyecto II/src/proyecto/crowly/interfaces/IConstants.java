package proyecto.crowly.interfaces;

public interface IConstants 
{
	public final String POST_BODY = "{ \"url\":\"@@URL@@\" }";
	
	public final String MCS_URL = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&frameSamplingValue=1"; //errores
	
	public final String[] LISTA_VIDEOS = 
	{
			"http://gdurl.com/9KHx",
			"https://www.dropbox.com/s/nhc9xsxlnsn0bv8/WIN_20170503_15_26_09_Pro.mp4?dl=0" // Videos pruebas
	};
	
	public final String LOCATION_RESULT_URL_KEY = "Operation-Location";
	public final String LOCATION_RESULT_ACCESS_KEY = "apim-request-id";
	public final String CAMBIO_LINEA = "\n";
	
	public final int ESPERA_ENTRE_LLAMADAS = 60000; // Tiempo de espera
	
	public final String MCS_IDKEY = "799dca11f3ca4e67b75c9aa34848823b"; // Clave de microsoft cambiar
	
	
	
	
	public final String GOOGLE_CHROME = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe "; // Aplication direction.
		
	public final String TIME_HEADER = "Time";
	
	public final String PEOPLE_HEADER = "People";
	
	public final String IDENTIFIER = "@@DATA@@";
	
	public final String[] LIST_OF_FILES_CHARTS = 
	{
			"bar.html",
			"scatter.html",
			"line.html"
	};
	
	public final String[] LIST_OF_HEADERS_CHARTS = 
	{
			"C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/BarChartHeader.txt",
			"C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/LineChartHeader.txt",
			"C:/Users/dnnxl/OneDrive/Documentos/Proyecto Crowly/Documents/ScatterChartHeader.txt"
	};
}
