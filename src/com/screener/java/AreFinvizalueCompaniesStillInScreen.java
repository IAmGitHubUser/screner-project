package com.screener.java;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * screen for HighRoaLowPeScreener.
 * 
 * @author hpatel
 *
 */
public class AreFinvizalueCompaniesStillInScreen {

    public static void main(String[] args) {
        getResult();
    }

    public static void getResult() {
        System.out.println();
        System.out.println("Checking Finiz Value...");
        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/populateSpreadSheetFromFinvizFile.txt");

        try {
            List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");

            for (String string : quoteListsFromFile) {

                if (string.contains("null")) {
                    continue;
                }

                String[] quoteFromOneLineAtATime = string.split(" ");

                /**
                 * finvizValues = {"price", "marketCap", "pb",
                 * "epsGrowthLastFiveYears", "dividendYield",
                 * "netProfitMargin", "pe", "returnOnAsset",
                 * "longTermDebtToEquity", "salesGrowthLastFiveYears",
                 * "returnOnEquity", "debtToEquity", "epsGrowthTtm",
                 * "espGrowthQtrOverQtr", "returnOnInvestment", "grossMargin",
                 * "salesGrowthQtrOverQtr", "currentRatio"};
                 */
              
                String ticker = quoteFromOneLineAtATime[0];
                double marketCap = Double.parseDouble(quoteFromOneLineAtATime[3]);
                double priceToBook = Double.parseDouble(quoteFromOneLineAtATime[4]);
                double epsGrowthLastFiveYears = Double.parseDouble(quoteFromOneLineAtATime[5]);
                double dividendYield = Double.parseDouble(quoteFromOneLineAtATime[6]);
                double netProfitMargin = Double.parseDouble(quoteFromOneLineAtATime[7]);
                double pe = Double.parseDouble(quoteFromOneLineAtATime[8]);
                double returnOnAsset = Double.parseDouble(quoteFromOneLineAtATime[9]);
                double longTermDebtToEquity = Double.parseDouble(quoteFromOneLineAtATime[10]);
                double salesGrowthLastFiveYears = Double.parseDouble(quoteFromOneLineAtATime[11]);
                double returnOnEquity = Double.parseDouble(quoteFromOneLineAtATime[12]);
                double debtToEquity = Double.parseDouble(quoteFromOneLineAtATime[13]);
                double epsGrowthTtm = Double.parseDouble(quoteFromOneLineAtATime[14]);
                double espGrowthQtrOverQtr = Double.parseDouble(quoteFromOneLineAtATime[15]);
                double returnOnInvestment = Double.parseDouble(quoteFromOneLineAtATime[16]);
                double grossMargin = Double.parseDouble(quoteFromOneLineAtATime[17]);
                double salesGrowthQtrOverQtr = Double.parseDouble(quoteFromOneLineAtATime[18]);
                double currentRatio = Double.parseDouble(quoteFromOneLineAtATime[19]);

                StillInClassUtility.checkMin("marketCap", marketCap, 2, ticker);
                StillInClassUtility.checkMax("priceToBook", priceToBook, 2, ticker);
                StillInClassUtility.checkMin("epsGrowthLastFiveYears", epsGrowthLastFiveYears, 5, ticker);
                StillInClassUtility.checkMin("dividendYield", dividendYield, 0, ticker);
                StillInClassUtility.checkMin("netProfitMargin", netProfitMargin, 0, ticker);
                StillInClassUtility.checkMax("pe", pe, 15, ticker);
                StillInClassUtility.checkMin("returnOnAsset", returnOnAsset, 0, ticker);
                StillInClassUtility.checkMax("longTermDebtToEquity", longTermDebtToEquity, 1, ticker);
                StillInClassUtility.checkMin("salesGrowthLastFiveYears", salesGrowthLastFiveYears, 0, ticker);
                StillInClassUtility.checkMin("returnOnEquity", returnOnEquity, 0, ticker);
                StillInClassUtility.checkMax("debtToEquity", debtToEquity, 1, ticker);
                StillInClassUtility.checkMin("epsGrowthTtm", epsGrowthTtm, 0, ticker);
                StillInClassUtility.checkMin("espGrowthQtrOverQtr", espGrowthQtrOverQtr, 0, ticker);
                StillInClassUtility.checkMin("returnOnInvestment", returnOnInvestment, 0, ticker);
                StillInClassUtility.checkMin("grossMargin", grossMargin, 0, ticker);
                StillInClassUtility.checkMin("salesGrowthQtrOverQtr", salesGrowthQtrOverQtr, 0, ticker);
                StillInClassUtility.checkMin("currentRatio", currentRatio, 2, ticker);
             
                

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
