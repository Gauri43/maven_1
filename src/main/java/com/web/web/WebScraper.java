package com.web.web;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unused")
public class WebScraper{
	public static void main(String[] args) {
	try {
		// Connect to the opposite and retrieve HTML content
		Document document = Jsoup.connect("https://www.datamato.com/about-us").get();

		// Extract desired data using Jsoup selectors
		Elements elements = document.select("h1");

		// Create JSON array to store the extracted data
		JSONArray jsonArray = new JSONArray();

		for (Element element : elements) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("text", element.text());
		jsonArray.add(jsonObject);
		}

		// Write the JSON array to a file
		FileWriter fileWriter = new FileWriter("output.json");
		fileWriter.write(jsonArray.toJSONString());
		fileWriter.close();
		System.out.println("Web scraping completed successfully.");
		} catch (Exception e) {
		e.printStackTrace();
		}
}
}


