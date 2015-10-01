package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * JSON reader. Code modified from Roland Illig's post on stack overflow:
 * http://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-
 * url-in-java#
 * 
 */
class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray jsonArray = new JSONArray(jsonText);
			return jsonArray;
		} finally {
			is.close();
		}
	}

	public static JSONArray getData(String call) throws IOException, JSONException {
		JSONArray jsonArray = readJsonFromUrl(call);
		return jsonArray;
	}
}
