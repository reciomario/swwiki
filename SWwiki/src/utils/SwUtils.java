package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import model.Film;
import model.ModelList;
import model.Person;
import model.Planet;
import model.Specie;
import model.Starship;
import model.Vehicle;

public class SwUtils {
	public static void main(String[] args) throws IOException {
		Specie vehi = new Specie();

		List<Specie> lista = vehi.getAll();
		for(Specie a : lista) {
			System.out.println(a.getName());
		}
	}

	public static String sender(String request) throws IOException {

		URL url = new URL(request);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("User-Agent", "swapi-Java-" + APIConstants.APPLICATION_NAME);

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		String msg = "";
		while ((output = br.readLine()) != null) {
			msg = msg + output;
		}
		conn.disconnect();

		return msg;
	}

}
