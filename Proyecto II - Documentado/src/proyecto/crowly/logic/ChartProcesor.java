package proyecto.crowly.logic;

import java.util.ArrayList;

import proyecto.crowly.chart.*;
import proyecto.crowly.chart.ChartManagerFactory;
import proyecto.crowly.library.GraphyType;

public class ChartProcesor 
{
	private ChartManagerFactory FactoryChart; //FactoryChart of the type ChartManagerFactory
	private ArrayList<ChartManager> Charts; //Charts is an ArrayList with ChartManager
	
	public ChartProcesor() //process the chart
	{
		FactoryChart = ChartManagerFactory.getInstance();
		Charts = new ArrayList<ChartManager>();
	}
	
	public ArrayList<ChartManager> getCharts()
	{
		return Charts;
	}
	
	public void createChart(ArrayList<VideoContein> pListOfVideoContein) //creates the chart
	{
		for (GraphyType Chart : GraphyType.values())
		{
			ChartManager ChartBar = FactoryChart.createChart(Chart);
			ChartBar.generateGraphy(pListOfVideoContein);		
			Charts.add(ChartBar);
		}
	}
}
