//this is how package name should be
package screener;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import model.CharastericsName;

public class Screener {
    public static void main(String[] args) throws IOException {

        String[] finvizValuesTickers = {"JHG", "TECK", "AVX"};
        String[] highRoaLowPeTickers = {"BPT", "ESIO", "CORT", "EXEL", "MSB", "GPP", "GBL", "FTSI", "CRT"};
        String[] growthTickers = {"CORT", "MU", "NVDA", "SEDG", "TAL", "WB", "FB", "SGH"};

        /**
         * Change following to run various screens.
         * 
         */
        System.out.println();
        System.out.println("finvizValuesTickers");
        populateSpreadSheetFromFinviz(finvizValuesTickers, finvizValuesArray(), excludedTickers());
        printNumberOfHoldings(finvizValuesTickers);
        AreFinvizalueCompaniesStillInScreen.getResult();

        System.out.println();
        System.out.println("GrowthTickers");
        System.out.println("price, espGrowthQtrOverQtr, epsGrowthThisYear, returnOnEquity, salesGrowthQtrOverQtr");
        populateSpreadSheet(growthTickers, growthValuesArray(), excludedTickers(), "growthTickers");
        printNumberOfHoldings(growthTickers);
        AreGrowthCompaniesStillInScreen.getResult();

        System.out.println();
        System.out.println("highRoaLowPeTickers");
        populateSpreadSheet(highRoaLowPeTickers, highRoaLowPeValuesArray(), excludedTickers(), "highRoaLowPeTickers");
        printNumberOfHoldings(highRoaLowPeTickers);
        AreHighRoaLowCompaniesStillInScreen.getResult();

    }

    private static void printNumberOfHoldings(String[] highRoaLowPeTickers) {
        System.out.println("# of holdings: " + highRoaLowPeTickers.length);
    }

    public static void populateSpreadSheet(String[] tickers, CharastericsName[] values, String[] excludeThese, String spreadSheetName) {
        LocalDateTime currentLocalTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatDateTime = currentLocalTime.format(formatter);

        for (String string : excludeThese) {
            tickers = ArrayUtils.removeElement(tickers, string);
        }

        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/destinationFile.txt");

        // false - do not append, but overwrite
        try {
            FileUtils.writeStringToFile(destinationFile, "", "UTF-8", false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (String ticker : tickers) {
            MyHashMap printFinviz2 = new MyHashMap(ticker);
            System.out.print(ticker + " " + formatDateTime + " ");

            try {
                FileUtils.writeStringToFile(destinationFile, ticker + " " + formatDateTime + " ", "UTF-8", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (CharastericsName value : values) {
                System.out.print(printFinviz2.getValue(value) + " ");

                try {
                    FileUtils.writeStringToFile(destinationFile, printFinviz2.getValue(value) + " ", "UTF-8", true);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            System.out.println();

            try {
                FileUtils.writeStringToFile(destinationFile, "\n", "UTF-8", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void populateSpreadSheet(String[] tickers, String[] values, String[] excludeThese, String spreadSheetName) {
        LocalDateTime currentLocalTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatDateTime = currentLocalTime.format(formatter);

        for (String string : excludeThese) {
            tickers = ArrayUtils.removeElement(tickers, string);
        }

        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/" + spreadSheetName + ".txt");

        // false - do not append, but overwrite
        try {
            FileUtils.writeStringToFile(destinationFile, "", "UTF-8", false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (String ticker : tickers) {

            MyHashMap printFinviz2 = new MyHashMap(ticker);

            System.out.print(ticker + "," + formatDateTime + ",");

            try {
                FileUtils.writeStringToFile(destinationFile, ticker + " " + formatDateTime + " ", "UTF-8", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (String value : values) {
                System.out.print(printFinviz2.getValue(value) + ",");
                try {
                    FileUtils.writeStringToFile(destinationFile, printFinviz2.getValue(value) + " ", "UTF-8", true);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            System.out.println();

            try {
                FileUtils.writeStringToFile(destinationFile, "\n", "UTF-8", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void populateSpreadSheetFromFinviz(String[] tickers, String[] values, String[] excludeThese) {
        LocalDateTime currentLocalTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatDateTime = currentLocalTime.format(formatter);

        for (String string : excludeThese) {
            tickers = ArrayUtils.removeElement(tickers, string);
        }

        File destinationFile = new File("/Users/hpatel/Documents/Personal/Quotes/populateSpreadSheetFromFinvizFile.txt");

        // false - do not append, but overwrite
        try {
            FileUtils.writeStringToFile(destinationFile, "", "UTF-8", false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (String ticker : tickers) {

            MyFinvizHashMap printFinviz2 = new MyFinvizHashMap(ticker);

            System.out.print(ticker + " " + formatDateTime + " ");

            try {
                FileUtils.writeStringToFile(destinationFile, ticker + " " + formatDateTime + " ", "UTF-8", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (String value : values) {
                System.out.print(printFinviz2.getValue(value) + " ");
                try {
                    FileUtils.writeStringToFile(destinationFile, printFinviz2.getValue(value) + " ", "UTF-8", true);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            System.out.println();

            try {
                FileUtils.writeStringToFile(destinationFile, "\n", "UTF-8", true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static String[] fidelityBetterThanIndustryAverageValuesArray() {
        String[] fidelityBetterThanIndustryAverageValues = {"price", "pePercentileReverse", "priceToCashFlowPercentileReverse", "priceToSalesPercentileReverse",
                                                            "priceToBookPercentileReverse", "grossMarginQtrPercentile", "grossMarginPercentile",
                                                            "ebitdMarginPercentile", "profitMarginQtrPercentile", "operationMarginQtrPercentile",
                                                            "operationMargingPercentile", "pretaxMargingPercentile", "revenueGrowthLastQtrPercentile",
                                                            "revenueGrowthTtmPercentile", "revenueGrowthLastFiveYearsPercentile", "epsGrowthLastQtrPercentile",
                                                            "epsGrowthTtmPercentile", "epsGrowthLastFiveYearsPercentile",
                                                            "bookValueGrowthLastFiveYearsPercentile", "cashFlowGrowthLastFiveYearsPercentile",
                                                            "returnOnSalesLastQtrPercentile", "returnOnSalesTtmPercentile", "returnOnEquityLastQtrPercentile",
                                                            "returnOnEquityPercentile", "returnOnAssetsLastQtrPercentile", "returnOnAssetsPercentile",
                                                            "returnOnInvestmentLastQtrPercentile", "returnOnInvestmentTtmPercentile",
                                                            "longTermDebtToEquityLastQtrPercentileReverse", "longTermDebtToEquityTtmPercentileReverse",
                                                            "longTermDebtToAssetsLastQtrPercentileReverse", "longTermDebtToAssetsTtmPercentileReverse",
                                                            "longTermDebtToCapitalLastQtrPercentileReverse", "longTermDebtToCapitalTtmPercentileReverse",
                                                            "debtToEquityQtrPercentileReverse", "debtToEquityTtmPercentileReverse", "currentRatioPercentile"};
        return fidelityBetterThanIndustryAverageValues;
    }

    public static String[] betterThanIndustryAverageScottradeValuesArray() {
        String[] betterThanIndustryAverageValues = {"returnOnEquityPercentile", "returnOnEquity", "profitMarginQtrPercentile", "netProfitMargin",
                                                    "pePercentileReverse", "pe", "debtToCapitalPercentileReverse", "debtToCapital",
                                                    "priceToSalesPercentileReverse", "priceToSales", "priceToCashFlowPercentileReverse", "priceToCashFlow"};
        return betterThanIndustryAverageValues;
    }

    public static String[] fundamentalsValueArray() {
        String[] fundamentalValues = {"peg", "grossMarginPercentile", "grossMargin", "pePercentileReverse", "pe", "priceToSalesPercentileReverse",
                                      "priceToSales", "priceToBook", "priceToCashFlowPercentileReverse", "priceToCashFlow", "returnOnEquityPercentile",
                                      "returnOnEquity"};
        return fundamentalValues;
    }

    public static String[] finvizValuesArray() {
        String[] finvizValues = {"price", "marketCap", "pb", "epsGrowthLastFiveYears", "dividendYield", "netProfitMargin", "pe", "returnOnAsset",
                                 "longTermDebtToEquity", "salesGrowthLastFiveYears", "returnOnEquity", "debtToEquity", "epsGrowthThisYear",
                                 "espGrowthQtrOverQtr", "returnOnInvestment", "grossMargin", "salesGrowthQtrOverQtr", "currentRatio"};
        return finvizValues;
    }

    public static String[] growthValuesArray() {
        String[] growthValues = {"price", "espGrowthQtrOverQtr", "epsGrowthThisYear", "returnOnEquity", "salesGrowthQtrOverQtr"};
        return growthValues;
    }

    public static String[] highRoaLowPeValuesArray() {
        String[] highRoaLowPeValues = {"pe", "returnOnAsset", "price", "industry"};
        return highRoaLowPeValues;
    }

    public static String[] reutersBetterThanIndustryAverageValuesArray() {
        String[] reutersBetterThanIndustryAverageValues = {"price",

                                                           "peDifferenceFromIndustryInPercent", "priceToSalePercentReverse", "priceToBookPercentReverse",
                                                           "priceToCashFLowPercentReverse",

                                                           "salesGrowthQtrPercent", "salesGrowthYearPercent", "epsGrowthQtrPercent", "epsGrowthYearPercent",

                                                           "quickRatioPercent", "currentRatioPercent", "longTermDebtToEquityPercentReverse",
                                                           "totalDebtToEquityPercentReverse", "interestCoveragePercent",

                                                           "grossMarginPercent", "ebitaMarginPercent", "operatingMarginPercent", "preTaxMarginPercent",
                                                           "netMarginPercent",

                                                           "returnOnAssetsDifferenceFromIndustryInPercent", "returnOnInvestmentPercent",
                                                           "returnOnEquityPercent"};
        return reutersBetterThanIndustryAverageValues;
    }

    String[] hh = {"price", "peDifferenceFromIndustryInPercent", "priceToSalePercentReverse", "priceToBookPercentReverse", "priceToCashFLowPercentReverse",
                   "salesGrowthQtrPercent", "salesGrowthYearPercent", "epsGrowthQtrPercent", "epsGrowthYearPercent", "quickRatioPercent", "currentRatioPercent",
                   "longTermDebtToEquityPercentReverse", "totalDebtToEquityPercentReverse", "interestCoveragePercent", "grossMarginPercent",
                   "ebitaMarginPercent", "operatingMarginPercent", "preTaxMarginPercent", "netMarginPercent", "returnOnAssetsDifferenceFromIndustryInPercent",
                   "returnOnInvestmentPercent", "returnOnEquityPercent"};

    public static String[] excludedTickers() {
        // Excluded on Oct, 2018.
        String[] excludeThese = {"BWL-A", "LMRK"};
        return excludeThese;

    }

}
