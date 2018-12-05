package screener;

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
public class HighRoaLowPeScreener {

    public static void main(String[] args) {
        getScreenResult();
    }

    public static void getScreenResult() {
        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/highRoaLowPeValuesScreener.txt");

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

                String ticker = quoteFromOneLineAtATime[0];
                String date = quoteFromOneLineAtATime[1];
                double price = Double.parseDouble(quoteFromOneLineAtATime[6]);

                double peDifferenceFromIndustryInPercent = Double.parseDouble(quoteFromOneLineAtATime[2]);
                double pe = Double.parseDouble(quoteFromOneLineAtATime[3]);
                double returnOnAssetsDifferenceFromIndustryInPercent = Double.parseDouble(quoteFromOneLineAtATime[4]);
                double returnOnAsset = Double.parseDouble(quoteFromOneLineAtATime[5]);

                if (peDifferenceFromIndustryInPercent > 0 && returnOnAsset > 25 && price > 10 && returnOnAssetsDifferenceFromIndustryInPercent > 0) {

                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ticker).append(" ").append(date).append(" ").append(peDifferenceFromIndustryInPercent).append(" ").append(pe)
                            .append(" ").append(returnOnAssetsDifferenceFromIndustryInPercent).append(" ").append(returnOnAsset).append(" ").append(price);
                    System.out.println(stringBuilder.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
