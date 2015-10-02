package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Takes the JSOn array, extracts the required data and creates a csv with this
 * data.
 * 
 */
public class CreateCsv {
	static void makeCsv(JSONArray array, String cityName) throws FileNotFoundException, UnsupportedEncodingException {
		String fileName = "GoEuro" + cityName + "Info.csv";
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		writer.println("_id,name,type,latitude,longitude");
		for (int n = 0; n < array.length(); n++) {
			String line = "";
			JSONObject object = array.getJSONObject(n);
			JSONObject geo = object.getJSONObject("geo_position");
			line = line + object.get("_id") + ",";
			line = line + object.get("name") + ",";
			line = line + object.get("type") + ",";
			line = line + geo.get("latitude") + ",";
			line = line + geo.get("longitude");
			writer.println(line);
		}
		writer.close();
	}
}
