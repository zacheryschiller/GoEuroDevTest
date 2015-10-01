package main;

import java.io.IOException;
import org.json.JSONArray;

/**
 * Initial class that takes the city input and calls the other classes to get
 * JSON data and create the CSV.
 * 
 * @author Zack Schiller
 */
public class TestMain {
	public static void main(String[] args) throws IOException {
		String name = args[0];
		String baseAPI = "http://api.goeuro.com/api/v2/position/suggest/en/";
		String fullAPICall = baseAPI + name;
		System.out.println(fullAPICall);

		JSONArray json = JsonReader.getData(fullAPICall);
		CreateCsv.makeCsv(json);

	}
}
