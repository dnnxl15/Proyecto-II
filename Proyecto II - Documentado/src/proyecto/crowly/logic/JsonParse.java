package proyecto.crowly.logic;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParse 
{
	
	public JSONObject parseJson(String pJson)
	{
		JSONParser Parser = new JSONParser(); //create a Parser of the Json type
        Object Object = null;
		try 
		{
			Object = Parser.parse(pJson);
		} 
		catch (ParseException e) 
		{
		}
        JSONObject JsonObject = (JSONObject) Object;
        return JsonObject;
	}
	
	public Object getObject(String pJson) //here is get the object of the Json
	{
		JSONParser Parser = new JSONParser();
        Object Object = null;
		try 
		{
			Object = Parser.parse(pJson);
		} 
		catch (ParseException e) 
		{
		}
        JSONObject JsonObject = (JSONObject) Object;
        return JsonObject;
	}
	
	public ArrayList<JSONObject> getValue(JSONObject pObjectJson, String pKey)
	{
		@SuppressWarnings("unchecked")
		ArrayList<JSONObject> JsonObject = (ArrayList<JSONObject>) pObjectJson.get(pKey);
		return JsonObject;
	}
}
