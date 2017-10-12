package screener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class BetterThanIndustryAverageScreener {

    public static void main(String[] args) {
        getScreenResult();
    }

    public static void getScreenResult() {
        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/destinationFile.txt");
        Map<String, Double> tickerAndTotalPercentileMap = new HashMap<>();

        try {
            List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");

            for (String string : quoteListsFromFile) {
                System.out.println(string);
                if (string.contains("-")) {
                    continue;
                }

                if (string.contains("null")) {
                    continue;
                }

                String[] quoteFromOneLineAtATime = string.split(" ");

                double price = Double.parseDouble(quoteFromOneLineAtATime[2]);

                // Valuation
                // 1
                double pePercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[3]);
                // 2
                double priceToCashFlowPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[4]);
                // 3
                double priceToSalesPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[5]);
                // 4
                double priceToBookPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[6]);

                // Profit Margins
                // 1
                double grossMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[7]);
                // 2
                double EbitdMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[8]);
                // 3
                double operationMargingPercentile = Double.parseDouble(quoteFromOneLineAtATime[9]);
                // 4
                double pretaxMargingPercentile = Double.parseDouble(quoteFromOneLineAtATime[10]);

                double returnOnAssetsPercentile = Double.parseDouble(quoteFromOneLineAtATime[4]);
                double returnOnAsset = Double.parseDouble(quoteFromOneLineAtATime[5]);

                // pePercentileReverse > 50 && returnOnAsset > 25 &&

                if (price > 10 && pePercentileReverse > 50 && priceToCashFlowPercentileReverse > 50 && priceToSalesPercentileReverse > 50) {
                    double percentileTotal = ((pePercentileReverse + priceToCashFlowPercentileReverse + priceToSalesPercentileReverse
                            + priceToBookPercentileReverse) / 4)
                            + ((grossMarginPercentile + EbitdMarginPercentile + operationMargingPercentile + pretaxMargingPercentile) / 4);
                    System.out.println(quoteFromOneLineAtATime[0] + ": " + percentileTotal);

                    // Putting ticker and percentile total in map
                    tickerAndTotalPercentileMap.put(quoteFromOneLineAtATime[0], percentileTotal);

                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Set<Entry<String, Double>> set = tickerAndTotalPercentileMap.entrySet();
        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {

                // Ascending order
                // return (o1.getValue()).compareTo(o2.getValue());

                // Descending order
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Double> entry : list) {
            System.out.println(entry.getKey() + " ==== " + entry.getValue());
        }
    }

}
