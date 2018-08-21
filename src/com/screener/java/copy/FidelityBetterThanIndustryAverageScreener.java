package com.screener.java.copy;

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

public class FidelityBetterThanIndustryAverageScreener {

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

                // +
                double grossMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[7]);
                // 1
                double grossMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[8]);
                // 2
                double ebitdMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[9]);
                // +
                double profitMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[10]);
                // +
                double operationMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[11]);
                // 3
                double operationMargingPercentile = Double.parseDouble(quoteFromOneLineAtATime[12]);
                // 4
                double pretaxMargingPercentile = Double.parseDouble(quoteFromOneLineAtATime[13]);

                // Growth
                // 1
                double revenueGrowthLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[14]);
                // 2
                double revenueGrowthTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[15]);
                // 3
                double revenueGrowthLastFiveYearsPercentile = Double.parseDouble(quoteFromOneLineAtATime[16]);

                // 4
                double epsGrowthLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[17]);
                // 5
                double epsGrowthTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[18]);
                // 6
                double epsGrowthLastFiveYearsPercentile = Double.parseDouble(quoteFromOneLineAtATime[19]);
                // 7
                double bookValueGrowthLastFiveYearsPercentile = Double.parseDouble(quoteFromOneLineAtATime[20]);
                // 8
                double cashFlowGrowthLastFiveYearsPercentile = Double.parseDouble(quoteFromOneLineAtATime[21]);

                // Returns
                // 1
                double returnOnSalesLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[22]);
                // 2
                double returnOnSalesTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[23]);
                // 3
                double returnOnEquityLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[24]);
                // 4
                double returnOnEquityPercentile = Double.parseDouble(quoteFromOneLineAtATime[25]);
                // 5
                double returnOnAssetsLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[26]);
                // 6
                double returnOnAssetsPercentile = Double.parseDouble(quoteFromOneLineAtATime[27]);
                // 7
                double returnOnInvestmentLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[28]);
                // 8
                double returnOnInvestmentTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[29]);

                // Debts
                // 1
                double longTermDebtToEquityLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[30]);
                // 2
                double longTermDebtToEquityTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[31]);
                // 3
                double longTermDebtToAssetsLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[32]);
                // 4
                double longTermDebtToAssetsTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[33]);
                // 5
                double longTermDebtToCapitalLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[34]);
                // 6
                double longTermDebtToCapitalTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[35]);
                // 7
                double debtToEquityQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[36]);
                // 8
                double debtToEquityTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[37]);
                // 9
                double currentRatioPercentile = Double.parseDouble(quoteFromOneLineAtATime[38]);

                if (price > 10 && pePercentileReverse > 50 && priceToCashFlowPercentileReverse > 50 && priceToSalesPercentileReverse > 50
                        && priceToBookPercentileReverse > 50 && operationMarginQtrPercentile > 50 && profitMarginQtrPercentile > 50
                        && grossMarginQtrPercentile > 50 && grossMarginPercentile > 50 && ebitdMarginPercentile > 50 && operationMargingPercentile > 50
                        && pretaxMargingPercentile > 50 && revenueGrowthLastQtrPercentile > 50 && revenueGrowthTtmPercentile > 50
                        && revenueGrowthLastFiveYearsPercentile > 50 && epsGrowthLastQtrPercentile > 50 && epsGrowthTtmPercentile > 50
                        && epsGrowthLastFiveYearsPercentile > 50 && bookValueGrowthLastFiveYearsPercentile > 50 && cashFlowGrowthLastFiveYearsPercentile > 50
                        && returnOnSalesLastQtrPercentile > 50 && returnOnSalesTtmPercentile > 50 && returnOnEquityLastQtrPercentile > 50
                        && returnOnEquityPercentile > 50 && returnOnAssetsLastQtrPercentile > 50 && returnOnAssetsPercentile > 50
                        && returnOnInvestmentLastQtrPercentile > 50 && returnOnInvestmentTtmPercentile > 50 && longTermDebtToEquityLastQtrPercentileReverse > 50
                        && longTermDebtToEquityTtmPercentileReverse > 50 && longTermDebtToAssetsLastQtrPercentileReverse > 50
                        && longTermDebtToAssetsTtmPercentileReverse > 50 && longTermDebtToCapitalLastQtrPercentileReverse > 50
                        && longTermDebtToCapitalTtmPercentileReverse > 50 && debtToEquityQtrPercentileReverse > 50 && debtToEquityTtmPercentileReverse > 50
                        && currentRatioPercentile > 50) {

                    double percentileTotal = ((pePercentileReverse + priceToCashFlowPercentileReverse + priceToSalesPercentileReverse
                            + priceToBookPercentileReverse) / 4)
                            + ((operationMarginQtrPercentile + profitMarginQtrPercentile + grossMarginQtrPercentile + grossMarginPercentile
                                    + ebitdMarginPercentile + operationMargingPercentile + pretaxMargingPercentile) / 7)
                            + ((revenueGrowthLastQtrPercentile + revenueGrowthTtmPercentile + revenueGrowthLastFiveYearsPercentile + epsGrowthLastQtrPercentile
                                    + epsGrowthTtmPercentile + epsGrowthLastFiveYearsPercentile + bookValueGrowthLastFiveYearsPercentile
                                    + cashFlowGrowthLastFiveYearsPercentile) / 8)
                            + ((returnOnSalesLastQtrPercentile + returnOnSalesTtmPercentile + returnOnEquityLastQtrPercentile + returnOnEquityPercentile
                                    + returnOnAssetsLastQtrPercentile + returnOnAssetsPercentile + returnOnInvestmentLastQtrPercentile
                                    + returnOnInvestmentTtmPercentile) / 8)
                            + ((longTermDebtToEquityLastQtrPercentileReverse + longTermDebtToEquityTtmPercentileReverse
                                    + longTermDebtToAssetsLastQtrPercentileReverse + longTermDebtToAssetsTtmPercentileReverse
                                    + longTermDebtToCapitalLastQtrPercentileReverse + longTermDebtToCapitalTtmPercentileReverse
                                    + debtToEquityQtrPercentileReverse + debtToEquityTtmPercentileReverse + currentRatioPercentile) / 9);

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
