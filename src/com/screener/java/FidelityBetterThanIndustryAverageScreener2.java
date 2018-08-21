package com.screener.java;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class FidelityBetterThanIndustryAverageScreener2 {

    public static void main(String[] args) {
        getScreenResult();
    }

    static Map<String, Double> tickerAndTotalPercentileMap = new HashMap<>();

    public static void getScreenResult() {
        // Gets eligible tickers from this file
        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/fidelityBetterThanIndustryAverageValuesArray.txt");

        try {
            List<String> quoteListsFromFile = FileUtils.readLines(destinationFile, "UTF-8");

            System.out.println("\nChecking fidelityBetterThanIndustryAverageValuesArray...");

            for (String string : quoteListsFromFile) {
                // if (string.contains("-")) {
                // System.out.println();
                // System.out.println("At least one of this ticker's
                // charaxcteristc had - in it\n" + string);
                // String stringWithDashReplacedByZero = string.replace("-",
                // "0");
                // string = stringWithDashReplacedByZero;
                // System.out.println();
                // }

                if (string.contains("null")) {
                    continue;
                }

                String[] quoteFromOneLineAtATime = string.split(" ");
                double grossMarginPercentile = 0;
                double ebitdMarginPercentile = 0;
                double operationMarginQtrPercentile = 0;
                double operationMargingPercentile = 0;
                double grossMarginQtrPercentile = 0;
                double longTermDebtToEquityLastQtrPercentileReverse = 0;
                double longTermDebtToEquityTtmPercentileReverse = 0;
                double longTermDebtToAssetsLastQtrPercentileReverse = 0;
                double longTermDebtToAssetsTtmPercentileReverse = 0;
                double debtToEquityQtrPercentileReverse = 0;
                double debtToEquityTtmPercentileReverse = 0;

          //      double price = Double.parseDouble(quoteFromOneLineAtATime[2]);

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
                if (quoteFromOneLineAtATime[7].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    grossMarginQtrPercentile = fidelityBetterThanIndustryAveragePurchasedData.getGrossMarginQtrPercentile();
                } else {
                    grossMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[7]);
                }
                
//                grossMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[7]);
                // 1
                
                if (quoteFromOneLineAtATime[8].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    grossMarginPercentile = fidelityBetterThanIndustryAveragePurchasedData.getGrossMarginPercentile();
                } else {
                    grossMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[8]);
                }
                
//                grossMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[8]);
                // 2
                if (quoteFromOneLineAtATime[9].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    ebitdMarginPercentile = fidelityBetterThanIndustryAveragePurchasedData.getEbitdMarginPercentile();
                } else {
                    ebitdMarginPercentile = Double.parseDouble(quoteFromOneLineAtATime[9]);
                }
                // +
                double profitMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[10]);
                // +
                
                
                if (quoteFromOneLineAtATime[11].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    operationMarginQtrPercentile = fidelityBetterThanIndustryAveragePurchasedData.getOperationMarginQtrPercentile();
                } else {
                    operationMarginQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[11]);
                }
                
                // 3
                
                if (quoteFromOneLineAtATime[12].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    operationMargingPercentile = fidelityBetterThanIndustryAveragePurchasedData.getOperationMargingPercentile();
                } else {
                    operationMargingPercentile = Double.parseDouble(quoteFromOneLineAtATime[12]);
                }
                
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
           //     double returnOnSalesLastQtrPercentile = Double.parseDouble(quoteFromOneLineAtATime[22]);
                // 2
//                double returnOnSalesTtmPercentile = Double.parseDouble(quoteFromOneLineAtATime[23]);
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

                if (quoteFromOneLineAtATime[30].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    longTermDebtToEquityLastQtrPercentileReverse = fidelityBetterThanIndustryAveragePurchasedData
                            .getLongTermDebtToEquityLastQtrPercentileReverse();
                } else {
                    longTermDebtToEquityLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[30]);
                }

                // longTermDebtToEquityLastQtrPercentileReverse =
                // getValue(quoteFromOneLineAtATime);

                // 2
                if (quoteFromOneLineAtATime[31].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    longTermDebtToEquityTtmPercentileReverse = fidelityBetterThanIndustryAveragePurchasedData.getLongTermDebtToEquityTtmPercentileReverse();
                } else {
                    longTermDebtToEquityTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[31]);
                }

                // 3
                if (quoteFromOneLineAtATime[32].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    longTermDebtToAssetsLastQtrPercentileReverse = fidelityBetterThanIndustryAveragePurchasedData
                            .getLongTermDebtToAssetsLastQtrPercentileReverse();
                } else {
                    longTermDebtToAssetsLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[32]);
                }

                // 4
                if (quoteFromOneLineAtATime[33].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    longTermDebtToAssetsTtmPercentileReverse = fidelityBetterThanIndustryAveragePurchasedData.getLongTermDebtToAssetsTtmPercentileReverse();
                } else {
                    longTermDebtToAssetsTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[33]);
                }
                // 5
                double longTermDebtToCapitalLastQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[34]);
                // 6
                double longTermDebtToCapitalTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[35]);
                // 7
                if (quoteFromOneLineAtATime[36].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    debtToEquityQtrPercentileReverse = fidelityBetterThanIndustryAveragePurchasedData.getDebtToEquityQtrPercentileReverse();
                } else {
                    debtToEquityQtrPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[36]);
                }
                // 8
                if (quoteFromOneLineAtATime[37].contains("-")) {
                    FidelityBetterThanIndustryAveragePurchasedData fidelityBetterThanIndustryAveragePurchasedData = new FidelityBetterThanIndustryAveragePurchasedData(quoteFromOneLineAtATime[0]);
                    debtToEquityTtmPercentileReverse = fidelityBetterThanIndustryAveragePurchasedData.getDebtToEquityTtmPercentileReverse();
                } else {
                    debtToEquityTtmPercentileReverse = Double.parseDouble(quoteFromOneLineAtATime[37]);
                }
                // 9
                double currentRatioPercentile = Double.parseDouble(quoteFromOneLineAtATime[38]);

                {

                    double valuation = (pePercentileReverse + priceToCashFlowPercentileReverse + priceToSalesPercentileReverse + priceToBookPercentileReverse)
                            / 4;
                    double profitMargin = (grossMarginQtrPercentile + grossMarginPercentile + ebitdMarginPercentile + operationMargingPercentile
                            + pretaxMargingPercentile + operationMarginQtrPercentile + profitMarginQtrPercentile) / 7;
                    double growth = (revenueGrowthLastQtrPercentile + revenueGrowthTtmPercentile + revenueGrowthLastFiveYearsPercentile
                            + epsGrowthLastQtrPercentile + epsGrowthTtmPercentile + epsGrowthLastFiveYearsPercentile + bookValueGrowthLastFiveYearsPercentile
                            + cashFlowGrowthLastFiveYearsPercentile) / 8;
                    double returns = (returnOnEquityLastQtrPercentile + returnOnEquityPercentile + returnOnAssetsLastQtrPercentile + returnOnAssetsPercentile
                            + returnOnInvestmentLastQtrPercentile + returnOnInvestmentTtmPercentile) / 6;
                    double debts = (longTermDebtToEquityLastQtrPercentileReverse + longTermDebtToEquityTtmPercentileReverse
                            + longTermDebtToAssetsLastQtrPercentileReverse + longTermDebtToAssetsTtmPercentileReverse
                            + longTermDebtToCapitalLastQtrPercentileReverse + longTermDebtToCapitalTtmPercentileReverse + debtToEquityQtrPercentileReverse
                            + debtToEquityTtmPercentileReverse + currentRatioPercentile) / 9;

                    double percentileTotal = valuation + profitMargin + growth + returns + debts;

                    // System.out.print("\"" + quoteFromOneLineAtATime[0] +
                    // "\",");

                    // Putting ticker and percentile total in map
                    tickerAndTotalPercentileMap.put(string, percentileTotal);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ScreenResult screenResult = new ScreenResult();
        screenResult.sortedQuotes(tickerAndTotalPercentileMap, true, true);

    }

}
