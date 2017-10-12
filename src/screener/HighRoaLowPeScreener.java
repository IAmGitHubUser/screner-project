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

public class HighRoaLowPeScreener {

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

                if (pePercentileReverse > 50 && returnOnAsset > 25 && price > 10) {
                    double pePercentileReversePlusReturnOnAssetsPercentile = pePercentileReverse + returnOnAssetsPercentile;
                    System.out.println(quoteFromOneLineAtATime[0] + ": " + pePercentileReversePlusReturnOnAssetsPercentile);

                    // Putting ticker and percentile total in map
                    tickerAndTotalPercentileMap.put(quoteFromOneLineAtATime[0], pePercentileReversePlusReturnOnAssetsPercentile);
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
