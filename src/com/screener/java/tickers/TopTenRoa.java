package com.screener.java.tickers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TopTenRoa {

    private List<String> tickersList;

    public TopTenRoa() {
        Document firstScreen = null;

        try {
            firstScreen = Jsoup.connect("https://finviz.com/screener.ashx?v=161&f=fa_pe_profitable,fa_roa_pos,sh_price_o10&ft=4&o=-roa").get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements tickerElementsInFirstTab = firstScreen.select(".screener-link-primary");

        tickersList = new ArrayList<String>(Arrays.asList(tickerElementsInFirstTab.text().split(" ")));

    }

    public String[] tickers() {

        String[] tickerArray = new String[10];
        return tickerArray = tickersList.toArray(tickerArray);
    }

    public static void main(String[] args) {
        printPositiveComapniesList();
    }

    // Print tickers
    private static void printPositiveComapniesList() {

        TopTenRoa highRoaLowPEScreenResult = new TopTenRoa();
        String[] highRoaLowPEScreenResultTickers = highRoaLowPEScreenResult.tickers();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"");

        for (int i = 0; i < 10; i++) {
            stringBuffer.append(highRoaLowPEScreenResultTickers[i] + "\",\"");
        }
        stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        stringBuffer.append("};");
        System.out.println(stringBuffer.toString());

    }
}
