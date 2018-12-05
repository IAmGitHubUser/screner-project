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
public class AreHighRoaLowCompaniesStillInScreen {

    public static void main(String[] args) {
        getResult();
    }

    public static void getResult() {
        System.out.println();
        System.out.println("Checking High ROA, Low PE...");
        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/highRoaLowPeTickers.txt");

        try {
            List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");

            for (String string : quoteListsFromFile) {

                if (string.contains("null")) {
                    continue;
                }

                String[] quoteFromOneLineAtATime = string.split(" ");

                String ticker = quoteFromOneLineAtATime[0];
                double peDifferenceFromIndustryInPercent = Double.parseDouble(quoteFromOneLineAtATime[2]);
                double returnOnAssetsDifferenceFromIndustryInPercent = Double.parseDouble(quoteFromOneLineAtATime[4]);

                if (quoteFromOneLineAtATime[5].contentEquals("-")) {
                    System.out.println(ticker + " 's returnOnAsset is -");
                } else {
                    double returnOnAsset = Double.parseDouble(quoteFromOneLineAtATime[5]);
                    StillInClassUtility.checkMin("returnOnAsset", returnOnAsset, 25, ticker);
                }

                StillInClassUtility.checkMin("peDifferenceFromIndustryInPercent", peDifferenceFromIndustryInPercent, 0, ticker);
                StillInClassUtility.checkMin("returnOnAssetsDifferenceFromIndustryInPercent", returnOnAssetsDifferenceFromIndustryInPercent, 0, ticker);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
