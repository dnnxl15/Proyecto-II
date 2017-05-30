package proyecto.crowly.logic;


import proyecto.crowly.chart.ChartManager;
import proyecto.crowly.library.GraphyType;

public class Control 
{
	private Logic LogicControl; //the LogicControl of the Logic type
	
	public Control()
	{
		LogicControl = new Logic();
	}
	
	public void openBrowser(GraphyType pType) //open the browser
	{
		ChartManager chart = LogicControl.getChart(pType);
		chart.openBrowser();
	}
	
	public void prosecute() //execute it
	{
		LogicControl.process();
	}
}
