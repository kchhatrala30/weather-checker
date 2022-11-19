/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapertest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.JTextArea;

/**
 *
 * @author minis_a
 */
public class City {
    private String name;
    
    public City(String name)
    {
        this.name = name;
    }
    
    public Document getCityInfo(String cityName)
    {
        String URL = "https://www.google.com/search?q=weather+" + cityName.replace(" ", "+");
        try
        {
            Document doc = Jsoup.connect(URL).get();
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public String atAGlance(Document doc)
    {
        String setter = "";
        Elements header = doc.select("#wob_wc > div.VQF4g > span");
        for (Element e : header.select("div"))
        {
            setter += e.text();
            setter += "\n";
        }
        return setter;
    }
    
    public int currentTemp(Document doc)
    {
        Elements currentTemp = doc.getElementsByClass("wob_t q8U8x");
        return Integer.parseInt(currentTemp.text());
    }
    
    public String highAndLow(Document doc)
    {
        String setter = "High & low:\n";
        Elements highLow = doc.select("#wob_dp > div.wob_df.wob_ds > div.wNE31c");
        for (Element e : highLow.select("[style=display:inline]"))
        {
            setter += e.text();
            setter += "\n";
        }
        return setter;
    }
    
    public String entireForecast(Document doc, JTextArea area)
    {
        String setter = "";
        setter += atAGlance(doc);
        setter += "\n";
        
        setter += "Current temperature: " + currentTemp(doc);
        setter += "\n\n";
        
        setter += highAndLow(doc);
        return setter;
    }
}
