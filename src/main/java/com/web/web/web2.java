package com.web.web;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class web2{
	
	try {
		Document doc = Jsoup.connect("https://www.datamato.com/about-us").get();

		// Extract desired information from the HTML using CSS selectors
		Elements elements = doc.select("div.my-class");

		// Create a JSON array to hold the extracted data
		JSONArray jsonArray = new JSONArray();

		// Loop through the elements and store data in JSON objects
		for (Element element : elements) {
		String title = element.select("h2").text();
		String description = element.select("p").text();

		// Create a JSON object to store each item's data
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("title", title);
		jsonObject.put("description", description);

		// Add the JSON object to the array
		jsonArray.put(jsonObject);
		}

		// Create a JSON file and write the data
		FileWriter fileWriter = new FileWriter("output.json");
		fileWriter.write(jsonArray.toString());
		fileWriter.close();

		System.out.println("Data successfully scraped and JSON file created!");
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

}
