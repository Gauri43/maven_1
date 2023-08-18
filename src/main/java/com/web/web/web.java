package com.web.web;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class web {
    public static void main(String[] args) {
        try {
            // Connect to the website and retrieve the HTML
            Document document = Jsoup.connect("https://example.com").get();
            // Save all content data into a file
            String filePath = "website_content.txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            // Traverse through all elements and extract the text content
            extractTextContent(document, writer);
            writer.close();

            System.out.println("Website content saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractTextContent(Element element, BufferedWriter writer) throws IOException {
        // Write the text content of the current element to the file
        writer.write(element.text());
        writer.newLine();
        // Recursively traverse through child elements
        for (Element child : element.children()) {
            extractTextContent(child, writer);
        }
    }
}