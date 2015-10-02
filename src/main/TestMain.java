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
		if (args.length != 1) {
			throw new IllegalArgumentException("Please input the city name to search");
		}
		String cityName = args[0];
		String baseAPI = "http://api.goeuro.com/api/v2/position/suggest/en/";
		String fullAPICall = baseAPI + cityName;

		System.out.println("Querying GoEuro API");
		JSONArray json = JsonReader.getData(fullAPICall);

		System.out.println("Building .csv");
		CreateCsv.makeCsv(json, cityName);

		System.out.println("Finished");
	}
}
