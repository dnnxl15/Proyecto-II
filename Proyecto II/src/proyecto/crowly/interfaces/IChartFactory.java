package proyecto.crowly.interfaces;

import proyecto.crowly.chart.ChartManager;
import proyecto.crowly.library.*;

public interface IChartFactory 
{
	public ChartManager createChart(GraphyType pType);
}