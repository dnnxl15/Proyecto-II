package proyecto.crowly.logic;

import java.util.ArrayList;

import proyecto.crowly.interfaces.*;

public class VideoProcesor implements IConstants
{
	private MSClient MsClient;
	private ArrayList<Body> EveryBody;
	
	public VideoProcesor()
	{
		MsClient = new MSClient();
	}
	
	public void analizarVideos()
	{
		try 
		{
			for(String urlVideo : LISTA_VIDEOS) {
				MsClient.procesarVideo(urlVideo);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}
			
			Thread.sleep(60000);
			
			for(VideoResponse video : MsClient.getVideosPendientes()) {
				MsClient.procesarRespuestaVideo(video);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}
			
			EveryBody = MsClient.getCuerpos();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		VideoProcesor proc = new VideoProcesor();
		proc.analizarVideos();
	}
}
