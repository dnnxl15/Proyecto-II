package proyecto.crowly.chart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import proyecto.crowly.interfaces.IConstants;
import proyecto.crowly.library.GraphyType;
import proyecto.crowly.logic.TextReader;
import proyecto.crowly.logic.VideoContein;

public class ScartterChart extends ChartManager
{
	@Override
	public void generateGraphy(ArrayList<VideoContein> pListOfVideoContein) //Creates the Scartter type of Graphic
	{
		ArrayList<ArrayList> ContentInfo =  createGraphy(pListOfVideoContein);
		String content = objectReader.readFile(IConstants.LIST_OF_HEADERS_CHARTS[SCATTER_CHART]);
		String pContentNew = ContentInfo.toString();
		content = content.replace(IConstants.IDENTIFIER,pContentNew);
		try 
		{
			objectReader.writeFile(content, IConstants.LIST_OF_FILES_CHARTS[SCATTER_CHART]);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		this.file = IConstants.LIST_OF_FILES_CHARTS[SCATTER_CHART];
	}
	
	@Override
	public GraphyType getType()
	{
		return GraphyType.SCARTTER;
	}
}