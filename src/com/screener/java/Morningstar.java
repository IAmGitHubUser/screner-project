package com.screener.java;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Morningstar {

    static String elementText;

    public Morningstar() {
        Document stockProfileScreen = null;
        try {
            stockProfileScreen = Jsoup.connect("http://beta.morningstar.com/stocks/xnas/aapl/quote.html").get();

        } catch (

        IOException e) {
            e.printStackTrace();
        }

        Elements element = stockProfileScreen.select(".dp-value.ng-binding");
        elementText = element.text();
        System.out.println(elementText);

    }

    private static void printInvestmentStyle() {
        Morningstar morningstar = new Morningstar();
        System.out.println(elementText);
    }
    
    public static void main(String[] args) {
        printInvestmentStyle();
    }

}
