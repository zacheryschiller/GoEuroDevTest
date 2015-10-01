package main;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Takes the JSOn array, extracts the required data and creates a csv with this
 * data.
 * 
 */
public class CreateCsv {
	static void makeCsv(JSONArray array) {
		for (int n = 0; n < array.length(); n++) {
			JSONObject object = array.getJSONObject(n);
			System.out.println("_id " + object.get("_id"));
			System.out.println("name " + object.get("name"));
			System.out.println("type " + object.get("type"));
			// System.out.println("geo "+object.get("geo_position"));
			JSONObject geo = object.getJSONObject("geo_position");
			System.out.println("latitude " + geo.get("latitude"));
			System.out.println("longitude " + geo.get("longitude"));
		}
	}
}
