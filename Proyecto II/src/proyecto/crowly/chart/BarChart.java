package proyecto.crowly.chart;

import proyecto.crowly.interfaces.IConstants;
import proyecto.crowly.library.GraphyType;
import proyecto.crowly.logic.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BarChart extends ChartManager implements IConstants
{	
	@Override
	public void generateGraphy(ArrayList<VideoContein> pListOfVideoContein) //create the graphic of the type Bar
	{
		ArrayList<ArrayList> ContentInfo =  createGraphy(pListOfVideoContein);
		String content = objectReader.readFile(LIST_OF_HEADERS_CHARTS[BAR_CHART]);
		String pContentNew = ContentInfo.toString();
		content = content.replace(IDENTIFIER,pContentNew);
		try 
		{
			objectReader.writeFile(content, LIST_OF_FILES_CHARTS[BAR_CHART]);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		this.file = LIST_OF_FILES_CHARTS[BAR_CHART];
	}
	
	@Override
	public GraphyType getType()
	{
		return GraphyType.BAR;
	}
}
