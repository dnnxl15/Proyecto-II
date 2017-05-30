package proyecto.crowly.logic;

import java.util.ArrayList;

import proyecto.crowly.chart.ChartManager;
import proyecto.crowly.library.GraphyType;

public class Logic 
{
	private ArrayList<ChartManager> Charts; //arraylist of the charts type
	
	public void process() //process the videos
	{
		// Analyze the videos
		VideoProcesor ProcesorVideo = new VideoProcesor();
		ProcesorVideo.analyzeVideos();
		ArrayList<Body> Bodys = ProcesorVideo.getBodys();
		
		// Analyze the bodies
		BodyProcesor ProcesorBody = new BodyProcesor();
		ProcesorBody.analyzeBodys(Bodys);
		ProcesorBody.generateVideoContein();
		ArrayList<VideoContein> ListOfVideoContein = ProcesorBody.getListOfVideoContein();
	
		// Create the Charts
		ChartProcesor ProcesorChart = new ChartProcesor();
		ProcesorChart.createChart(ListOfVideoContein);
		Charts = ProcesorChart.getCharts();
	}

	public ChartManager getChart(GraphyType pType) //here is get the chart
	{
		for(int i = 0; i<Charts.size(); i++)
		{
			ChartManager Chart = Charts.get(i);
			if(pType == Chart.getType())
			{
				return Chart;
			}
		}
		return null;
	}
}
