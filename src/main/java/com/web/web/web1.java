package com.web.web;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

 

public class web1 {
    public static void main(String[] args) {
        try {
            // Connect to the website and retrieve the HTML
            Document document = Jsoup.connect("https://www.datamato.com/about-us").get();

 

            // Extract specific elements from the HTML using CSS selectors
            Elements elements = document.select("h2"); // Select all <h1> elements
            for (Element element : elements) {
                System.out.println(element.text()); // Print the text content of each <h1> element
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}