package screener;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class GrowthScreener {

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

            if (string.contains("NA")) {
                continue;
            }

            quoteFromOneLineAtATime = string.split(" ");

            double price = Double.parseDouble(quoteFromOneLineAtATime[2]);
            // price", "espGrowthQtrOverQtr", "epsGrowthThisYear",
            // "returnOnEquity", "salesGrowthQtrOverQtr
            double espGrowthQtrOverQtr = Double.parseDouble(quoteFromOneLineAtATime[3]);
            double epsGrowthThisYear = Double.parseDouble(quoteFromOneLineAtATime[4].replace(",", ""));
            double returnOnEquity = Double.parseDouble(quoteFromOneLineAtATime[5]);
            double salesGrowthQtrOverQtr = Double.parseDouble(quoteFromOneLineAtATime[6]);

            // replace condition inside () with true, if want to see result
            // for every ticker from text file
            if (espGrowthQtrOverQtr > 25 && epsGrowthThisYear > 20 && returnOnEquity > 17 && salesGrowthQtrOverQtr > 25 && price > 10) {
                double moreThanRequiredEspGrowthQtrOverQtr = (espGrowthQtrOverQtr - 25) / 25;
                double moreThanRequiredEpsGrowthThisYear = (epsGrowthThisYear - 20) / 20;
                double moreThanRequiredReturnOnEquity = (returnOnEquity - 17) / 17;
                double moreThanRequiredSalesGrowthQtrOverQtr = (salesGrowthQtrOverQtr - 25) / 25;

                double minMoreThanRequired = Math
                        .min(moreThanRequiredEspGrowthQtrOverQtr,
                             Math.min(moreThanRequiredEpsGrowthThisYear, Math.min(moreThanRequiredReturnOnEquity, moreThanRequiredSalesGrowthQtrOverQtr)));

                minMoreThanRequired = minMoreThanRequired * 100;
                minPercentileAndQuote.put(string, minMoreThanRequired);
            }
        }
        ScreenResult screenResult = new ScreenResult();
        screenResult.sortedQuotes(minPercentileAndQuote, true, false);
    }
}
