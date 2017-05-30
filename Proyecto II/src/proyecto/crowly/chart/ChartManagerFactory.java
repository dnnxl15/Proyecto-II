package proyecto.crowly.chart;

import proyecto.crowly.interfaces.*;
import proyecto.crowly.library.GraphyType;

public class ChartManagerFactory implements IChartFactory
{
	private static ChartManagerFactory Instance; //create the instance

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
	public ChartManager createChart(GraphyType pType) //create the chart
	{
		if(pType == GraphyType.BAR)
		{
			BarChart chartBar = new BarChart();
			return chartBar;
		}
		else if(pType == GraphyType.LINE)
		{
			LineChart lineChart = new LineChart();
			return lineChart;
		}
		else
		{
			ScartterChart scartterChart = new ScartterChart();
			return scartterChart;
		}
	}
}	