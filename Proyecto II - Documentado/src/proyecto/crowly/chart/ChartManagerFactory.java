package proyecto.crowly.chart;

import proyecto.crowly.interfaces.*;
import proyecto.crowly.library.GraphyType;

public class ChartManagerFactory implements IChartFactory
{
	private static ChartManagerFactory Instance; //get the instance

	private ChartManagerFactory()
	{
	}
	
	public synchronized static ChartManagerFactory getInstance() //get the instance
	{
		if (Instance==null)
		{
			Instance = new ChartManagerFactory();
		}
		
		return Instance;
	}
	
	@Override
	public ChartManager createChart(GraphyType pType) //creates the chart
	{
		if(pType == GraphyType.BAR) //if equals to BAR
		{
			BarChart chartBar = new BarChart();
			return chartBar;
		}
		else if(pType == GraphyType.LINE) //if equals to LINE
		{
			LineChart lineChart = new LineChart();
			return lineChart;
		}
		else
		{
			ScartterChart scartterChart = new ScartterChart(); //if equals to SCARTTER
			return scartterChart;
		}
	}
}