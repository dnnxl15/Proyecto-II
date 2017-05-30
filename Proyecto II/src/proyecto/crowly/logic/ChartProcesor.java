package proyecto.crowly.logic;

import java.util.ArrayList;

import proyecto.crowly.chart.*;
import proyecto.crowly.chart.ChartManagerFactory;
import proyecto.crowly.library.GraphyType;

public class ChartProcesor 
{
	private ChartManagerFactory FactoryChart;
	private ArrayList<ChartManager> Charts;
	
	public ChartProcesor()
	{
		FactoryChart = ChartManagerFactory.getInstance();
		Charts = new ArrayList<ChartManager>();
	}
	
	public ArrayList<ChartManager> getCharts()
	{
		return Charts;
	}
	
	public void createChart(ArrayList<VideoContein> pListOfVideoContein) //create the chart
	{
		for (GraphyType Chart : GraphyType.values()) //analyze each Chart
		{
			ChartManager ChartBar = FactoryChart.createChart(Chart);
			ChartBar.generateGraphy(pListOfVideoContein);		
			Charts.add(ChartBar);
		}
	}
}
