package screener;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class ReutersBetterThanIndustryAverageScreener {

    public static void main(String[] args) {
        getScreenResult();
    }

    static Map<String, Double> tickerAndTotalPercentileMap = new HashMap<>();

    public static void getScreenResult() {
        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/fidelityBetterThanIndustryAverageScreener.txt");

        try {
            List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");

            System.out.println("\nChecking fidelityBetterThanIndustryAverageValuesArray...");

            for (String string : quoteListsFromFile) {
                if (string.contains("-")) {
                    System.out.println();
                    System.out.println("At least one of this ticker's charaxcteristc had - in it\n" + string);
                    String stringWithDashReplacedByZero = string.replace("-", "0");
                    string = stringWithDashReplacedByZero;
                    System.out.println();
                }

                if (string.contains("null")) {
                    continue;
                }

                String[] quoteFromOneLineAtATime = string.split(" ");

                String ticker = quoteFromOneLineAtATime[0];
                String date = quoteFromOneLineAtATime[1];
                double price = Double.parseDouble(quoteFromOneLineAtATime[2]);

                double peDifferenceFromIndustryInPercent = Double.parseDouble(quoteFromOneLineAtATime[3]);
                double priceToSalePercentReverse = Double.parseDouble(quoteFromOneLineAtATime[4]);
                double priceToBookPercentReverse = Double.parseDouble(quoteFromOneLineAtATime[5]);
                double priceToCashFLowPercentReverse = Double.parseDouble(quoteFromOneLineAtATime[6]);

                double salesGrowthQtrPercent = Double.parseDouble(quoteFromOneLineAtATime[7]);
                double salesGrowthYearPercent = Double.parseDouble(quoteFromOneLineAtATime[8]);
                double epsGrowthQtrPercent = Double.parseDouble(quoteFromOneLineAtATime[9]);
                double epsGrowthYearPercent = Double.parseDouble(quoteFromOneLineAtATime[10]);

                double quickRatioPercent = Double.parseDouble(quoteFromOneLineAtATime[11]);
                double currentRatioPercent = Double.parseDouble(quoteFromOneLineAtATime[12]);
                double longTermDebtToEquityPercentReverse = Double.parseDouble(quoteFromOneLineAtATime[13]);
                double totalDebtToEquityPercentReverse = Double.parseDouble(quoteFromOneLineAtATime[14]);
                double interestCoveragePercent = Double.parseDouble(quoteFromOneLineAtATime[15]);

                double grossMarginPercent = Double.parseDouble(quoteFromOneLineAtATime[16]);
                double ebitaMarginPercent = Double.parseDouble(quoteFromOneLineAtATime[17]);
                double operatingMarginPercent = Double.parseDouble(quoteFromOneLineAtATime[18]);
                double preTaxMarginPercent = Double.parseDouble(quoteFromOneLineAtATime[19]);
                double netMarginPercent = Double.parseDouble(quoteFromOneLineAtATime[20]);

                double returnOnAssetsDifferenceFromIndustryInPercent = Double.parseDouble(quoteFromOneLineAtATime[6]);
                double returnOnInvestmentPercent = Double.parseDouble(quoteFromOneLineAtATime[6]);
                double returnOnEquityPercent = Double.parseDouble(quoteFromOneLineAtATime[6]);

                if (peDifferenceFromIndustryInPercent > 0 && priceToSalePercentReverse > 0 && priceToBookPercentReverse > 0 && priceToCashFLowPercentReverse > 0
                        && salesGrowthQtrPercent > 0 && salesGrowthYearPercent > 0 && epsGrowthQtrPercent > 0 && epsGrowthYearPercent > 0

                        && quickRatioPercent > 0 && currentRatioPercent > 0 && longTermDebtToEquityPercentReverse > 0 && totalDebtToEquityPercentReverse > 0
                        && interestCoveragePercent > 0

                        && grossMarginPercent > 0 && ebitaMarginPercent > 0 && operatingMarginPercent > 0 && preTaxMarginPercent > 0 && netMarginPercent > 0
                        && returnOnAssetsDifferenceFromIndustryInPercent > 0 && returnOnInvestmentPercent > 0 && returnOnEquityPercent > 0

                ) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("**").append(ticker)

                            .append(" ").append(date).append(" ").append(price).append(" ").append(peDifferenceFromIndustryInPercent).append(" ")
                            .append(priceToSalePercentReverse).append(" ").append(priceToBookPercentReverse).append(" ").append(priceToCashFLowPercentReverse)
                            .append(" ").append(salesGrowthQtrPercent).append(" ").append(salesGrowthYearPercent).append(" ").append(epsGrowthQtrPercent)
                            .append(" ").append(epsGrowthYearPercent).append(" ").append(quickRatioPercent).append(" ").append(currentRatioPercent).append(" ")
                            .append(longTermDebtToEquityPercentReverse).append(" ").append(totalDebtToEquityPercentReverse).append(" ")
                            .append(interestCoveragePercent).append(" ").append(grossMarginPercent).append(" ").append(ebitaMarginPercent).append(" ")
                            .append(operatingMarginPercent).append(" ").append(preTaxMarginPercent).append(" ").append(netMarginPercent).append(" ")
                            .append(returnOnAssetsDifferenceFromIndustryInPercent).append(" ").append(returnOnInvestmentPercent).append(" ")
                            .append(returnOnEquityPercent);
                    System.out.println(stringBuilder.toString());
                }

            }

        } catch (

        IOException e) {
            e.printStackTrace();
        }

    }

}
