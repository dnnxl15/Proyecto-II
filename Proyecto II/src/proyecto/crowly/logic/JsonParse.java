package proyecto.crowly.logic;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParse 
{
	private JSONObject objectJson;
	private ArrayList<Body> cuerpos;
	
	public JsonParse(String pJson)
	{
		getObject(pJson);
	}
	
	public JsonParse()
	{
		
	}
	
	public Object getObject(String pJson)
	{
		JSONParser parser = new JSONParser();
        Object obj = null;
		try {
			obj = parser.parse(new FileReader(pJson));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject jsonObject = (JSONObject) obj;
        this.objectJson = jsonObject;
        System.out.println(jsonObject);
        return jsonObject;
	}
	
	public void setCurrentObject(String pName)
	{
		
	}
	
	// Función específica para procesar cuerpos, 
	// framents -> [] -> de segunda llave -> "events" -> [[{cuerpos x y area}]]
	
	public ArrayList<ArrayList<JSONObject>> getValue(String pKey) // funcion para framents
	{
		// Para sacar framento 
		ArrayList<JSONObject> jsonObject = (ArrayList<JSONObject>) this.objectJson.get(pKey); // Para acceder a Json de framents
		//String value = (String) this.objectJson.get(pKey);
		JSONObject jsonObject2 = jsonObject.get(1);
		ArrayList<ArrayList<JSONObject>> jsonObject3 = (ArrayList<ArrayList<JSONObject>>) jsonObject2.get("events"); // Eventos
		
		int i = 0;
		while(jsonObject3.size() >i)
		{
		//for (int i = 0; i<10; i++)
		//{
			JSONObject p = jsonObject3.get(i).get(0);
			System.out.println("-------------------");
			System.out.println(p);
			
			
			// {"regionId":0,"typeName":"motion","locations":[{"x":0.577406,"width":0.05,"y":0.455224,"height":0.540741}],"type":2}

			ArrayList<JSONObject> o = (ArrayList<JSONObject>) p.get("locations");
			System.out.println(x);
			System.out.println(o);
		
			
			// Lógica para crear el arraylist de cuerpos
			/*
			JSONObject y = o.get(i);
			int x = (int) y.get("x");
			int axisy = (int) y.get("y");
			int area1 = (int) y.get("width");

			int area2 = (int) y.get("height");
			int total = area1 * area2;
			Body nuevo = new Body(x,axisy,total);
			this.cuerpos.add(nuevo); // Agrega al arraylist del cuerpo.
			
			*/
			i++;
		//}
		}
		System.out.println(jsonObject3);
		return jsonObject3;
	}
	
	public static void main(String[] args)
	{
		JsonParse nuevo = new JsonParse("C:/Users/dnnxl/OneDrive/Documentos/Json/FormatoJson.json");
		nuevo.getValue("fragments");
	}
}
