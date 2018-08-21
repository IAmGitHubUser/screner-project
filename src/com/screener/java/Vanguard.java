package com.screener.java;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Vanguard {
    
    public static void main(String[] args) {
        Document firstScreen = null;
        try {
            firstScreen = Jsoup.connect("https://personal.vanguard.com/us/funds/snapshot?FundIntExt=INT&FundId=5533#tab=2").get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements tickerElementsInFirstTab = firstScreen.select("[tbodyid='portfolioForm:countryDiversificationDataTabletbody0']");
        
        for (Element element : tickerElementsInFirstTab) {
            System.out.println(element.html());
         }
    }

    
}
