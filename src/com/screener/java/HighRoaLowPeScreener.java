package com.screener.java;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

/**
 * screen for HighRoaLowPeScreener.
 * 
 * @author hpatel
 *
 */
public class HighRoaLowPeScreener {

    public static void main(String[] args) {
        getScreenResult();
    }

    public static void getScreenResult() {
        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/highRoaLowPeValuesScreener.txt");
        Map<String, Double> minPercentileAndQuote = new HashMap<>();

        try {
            List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");

            for (String string : quoteListsFromFile) {
                // Prints entire line
                // System.out.println(string);
                if (string.contains("-")) {
                    continue;
                }

                if (string.contains("null")) {
                    continue;
                }

                /**
                 * firstQuote array is = {" ticker", " date"
                 * "pePercentileReverse", "pe", "returnOnAssetsPercentile",
                 * "returnOnAsset", "price"};
                 * 
                 */
                String[] quoteFromOneLineAtATime = string.split(" ");

                double pePercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[2]);
                double returnOnAssetsPercentile = Double.parseDouble(quoteFromOneLineAtATime[4]);
                double returnOnAsset = Double.parseDouble(quoteFromOneLineAtATime[5]);
                double price = Double.parseDouble(quoteFromOneLineAtATime[6]);

                if (pePercentileReverse > 60 && returnOnAsset > 25 && price > 10 && returnOnAssetsPercentile > 60) {
                    double minOfPePercentileReverseAndReturnOnAssetsPercentile = Math.min(pePercentileReverse, returnOnAssetsPercentile);

                    // putting quote and percentile
                    // minOfPePercentileReverseAndReturnOnAssetsPercentile in
                    // map
                    minPercentileAndQuote.put(string, minOfPePercentileReverseAndReturnOnAssetsPercentile);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ScreenResult screenResult = new ScreenResult();
        screenResult.sortedQuotes(minPercentileAndQuote, true, false);

    }

}
