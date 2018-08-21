package com.screener.java;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class AreGrowthCompaniesStillInScreen {

    public static void main(String[] args) throws IOException {
        getResult();
    }

    public static void getResult() throws IOException {
        System.out.println();
        System.out.println("Checking Growth...");
        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/fidelityGrowthTickers.txt");

        List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");

        String[] quoteFromOneLineAtATime = null;

        for (String string : quoteListsFromFile) {

            if (string.contains("null")) {
                continue;
            }

            quoteFromOneLineAtATime = string.split(" ");
            double returnOnEquity = 0;
            double epsGrowthTtm = 0;

            String ticker = quoteFromOneLineAtATime[0];
            //double price = Double.parseDouble(quoteFromOneLineAtATime[2]);
            double espGrowthQtrOverQtr = Double.parseDouble(quoteFromOneLineAtATime[3]);
            if (quoteFromOneLineAtATime[4].contains("--")) {
                System.out.println("epsGrowthTtm for " + ticker + " is --");
            } else {
                epsGrowthTtm = Double.parseDouble(quoteFromOneLineAtATime[4]);
            }
            if (quoteFromOneLineAtATime[5].contains("-")) {
                System.out.println("returnOnEquity for " + ticker + " is -");
            } else {
                returnOnEquity = Double.parseDouble(quoteFromOneLineAtATime[5]);
            }
            double revenueGrowthLastQrtrvsSameQrtrPriorYear = Double.parseDouble(quoteFromOneLineAtATime[6]);
            double revenueGrowthTtm = Double.parseDouble(quoteFromOneLineAtATime[7]);

            StillInClassUtility.checkMin("espGrowthQtrOverQtr", espGrowthQtrOverQtr, 20, ticker);
            StillInClassUtility.checkMin("epsGrowthTtm", epsGrowthTtm, 25, ticker);
            StillInClassUtility.checkMin("returnOnEquity", returnOnEquity, 17, ticker);
            StillInClassUtility.checkMin("revenueGrowthLastQrtrvsSameQrtrPriorYear", revenueGrowthLastQrtrvsSameQrtrPriorYear, 25, ticker);
            StillInClassUtility.checkMin("revenueGrowthTtm", revenueGrowthTtm, 20, ticker);

        }

    }
}
