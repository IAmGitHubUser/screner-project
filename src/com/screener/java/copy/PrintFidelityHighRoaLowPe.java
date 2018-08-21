package com.screener.java.copy;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PrintFidelityHighRoaLowPe {
    Fidelity fidelityCompareToIndustryScreener = new Fidelity();

    private void printHighRoaLowPeValues(Elements elementsTdRight, Elements elementsTdLftRtBorder) {

        LocalDateTime currentLocalTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatDateTime = currentLocalTime.format(formatter);

        String[] values = {formatDateTime, Fidelity.getPercentileElement(elementsTdRight, 6, true),
                           Fidelity.getTickerElements(elementsTdLftRtBorder, 39)};

        for (String string : values) {
            System.out.print(string + " ");
        }

    }

    private void printBetterThanIndustryValues(Elements elementsTdRight, Elements elementsTdLftRtBorder) {

        LocalDateTime currentLocalTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatDateTime = currentLocalTime.format(formatter);

        String[] values = {formatDateTime, Fidelity.getPercentileElement(elementsTdRight, 111, false),
                           Fidelity.getTickerElements(elementsTdLftRtBorder, 37), Fidelity.getPercentileElement(elementsTdRight, 81, false),
                           Fidelity.getTickerElements(elementsTdLftRtBorder, 27), Fidelity.getPercentileElement(elementsTdRight, 6, true),
                           Fidelity.getTickerElements(elementsTdLftRtBorder, 2), Fidelity.getPercentileElement(elementsTdRight, 141, true),
                           Fidelity.getTickerElements(elementsTdLftRtBorder, 47), Fidelity.getPercentileElement(elementsTdRight, 27, true),
                           Fidelity.getTickerElements(elementsTdLftRtBorder, 9), Fidelity.getPercentileElement(elementsTdRight, 21, true),
                           Fidelity.getTickerElements(elementsTdLftRtBorder, 7)};

        for (String string : values) {
            System.out.print(string + " ");
        }

    }

    public void printRoa(String tickerSymbol) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://eresearch.fidelity.com/eresearch/evaluate/fundamentals/keyStatistics.jhtml?stockspage=keyStatistics&symbols="
                    + tickerSymbol).get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements tdRight = doc.select("td.right");
        Elements tdLftRtBorder = doc.select("td.lft-rt-border");

//         System.out.println(tdRight);
//         System.out.println(tdLftRtBorder);

        PrintFidelityHighRoaLowPe print = new PrintFidelityHighRoaLowPe();

        System.out.print(tickerSymbol + " ");
        print.printHighRoaLowPeValues(tdRight, tdLftRtBorder);
//         print.printFinvizValue(bChildrerOfTd);
        System.out.println();
    }

    public void printBetterThanIndustry(String tickerSymbol) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://eresearch.fidelity.com/eresearch/evaluate/fundamentals/keyStatistics.jhtml?stockspage=keyStatistics&symbols="
                    + tickerSymbol).get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements tdRight = doc.select("td.right");
        Elements tdLftRtBorder = doc.select("td.lft-rt-border");

//         System.out.println(tdRight);
//         System.out.println(tdLftRtBorder);

        PrintFidelityHighRoaLowPe print = new PrintFidelityHighRoaLowPe();

        System.out.print(tickerSymbol + " ");
        print.printBetterThanIndustryValues(tdRight, tdLftRtBorder);
//         print.printFinvizValue(bChildrerOfTd);
        System.out.println();
    }

}
