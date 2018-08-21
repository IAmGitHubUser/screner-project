package com.screener.java;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class FidelityGrowthScreener {

    public static void main(String[] args) throws IOException {
        getScreenResult();
    }

    public static void getScreenResult() throws IOException {

        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/fidelityGrowthTickersScreener.txt");

        Map<String, Double> minPercentileAndQuote = new HashMap<>();

        List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");

        String[] quoteFromOneLineAtATime = null;

        for (String string : quoteListsFromFile) {
            // System.out.println(string);
            if (string.contains("-")) {
                continue;
            }

            if (string.contains("null")) {
                continue;
            }

            quoteFromOneLineAtATime = string.split(" ");

            double price = Double.parseDouble(quoteFromOneLineAtATime[2]);

            double espGrowthQtrOverQtr = Double.parseDouble(quoteFromOneLineAtATime[3]);
            double epsGrowthTtm = Double.parseDouble(quoteFromOneLineAtATime[4]);
            double returnOnEquity = Double.parseDouble(quoteFromOneLineAtATime[5]);
            double revenueGrowthLastQrtrvsSameQrtrPriorYear = Double.parseDouble(quoteFromOneLineAtATime[6]);
            double revenueGrowthTtm = Double.parseDouble(quoteFromOneLineAtATime[7]);

            // replace condition inside () with true, if want to see result
            // for every ticker from text file
            if (espGrowthQtrOverQtr > 20 && epsGrowthTtm > 25 && returnOnEquity > 17 && revenueGrowthLastQrtrvsSameQrtrPriorYear > 25 && revenueGrowthTtm > 20
                    && price > 10) {
                double moreThanRequiredEspGrowthQtrOverQtr = (espGrowthQtrOverQtr - 20) / 20;
                double moreThanRequiredEpsGrowthTtm = (epsGrowthTtm - 25) / 25;
                double moreThanRequiredReturnOnEquity = (returnOnEquity - 17) / 17;
                double moreThanRequiredRevenueGrowthLastQrtrvsSameQrtrPriorYear = (revenueGrowthLastQrtrvsSameQrtrPriorYear - 25) / 25;
                double moreThanRequiredRevenueGrowthTtm = (revenueGrowthTtm - 20) / 20;

                double minMoreThanRequired = Math
                        .min(moreThanRequiredEspGrowthQtrOverQtr,
                             Math.min(moreThanRequiredEpsGrowthTtm,
                                      Math.min(moreThanRequiredReturnOnEquity,
                                               Math.min(moreThanRequiredRevenueGrowthLastQrtrvsSameQrtrPriorYear, moreThanRequiredRevenueGrowthTtm))));

                minMoreThanRequired = minMoreThanRequired * 100;
                minPercentileAndQuote.put(string, minMoreThanRequired);
            }
        }
        ScreenResult screenResult = new ScreenResult();
        screenResult.sortedQuotes(minPercentileAndQuote, true, false);
    }
}
