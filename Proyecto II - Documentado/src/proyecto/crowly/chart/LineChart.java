package proyecto.crowly.chart;

import java.io.IOException;
import java.util.ArrayList;
import proyecto.crowly.interfaces.IConstants;
import proyecto.crowly.library.GraphyType;
import proyecto.crowly.logic.TextReader;
import proyecto.crowly.logic.VideoContein;

public class LineChart extends ChartManager
{
	@Override
	public void generateGraphy(ArrayList<VideoContein> pListOfVideoContein) //Creates the Line type of Graphic
	{
		ArrayList<ArrayList> ContentInfo =  createGraphy(pListOfVideoContein);
		String content = objectReader.readFile(LIST_OF_HEADERS_CHARTS[LINE_CHART]);
		String pContentNew = ContentInfo.toString();
		content = content.replace(IDENTIFIER,pContentNew);
		try 
		{
			objectReader.writeFile(content, LIST_OF_FILES_CHARTS[LINE_CHART]);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		this.file = LIST_OF_FILES_CHARTS[LINE_CHART];
	}
	
	@Override
	public GraphyType getType()
	{
		return GraphyType.LINE;
	}
}