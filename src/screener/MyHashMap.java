package screener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import model.CharastericsName;

public class MyHashMap {

    Finviz finviz = new Finviz();

    private final Map<String, String> map;

    private Document doc = null;

    private Document docReuters = null;

    private Document docZacks = null;

    private Document docYahoo = null;

    public MyHashMap(String tickerSymbol) {
        map = new HashMap<>();
        try {
            doc = Jsoup.connect("https://finviz.com/quote.ashx?t=" + tickerSymbol).get();

            docReuters = Jsoup.connect("https://www.reuters.com/finance/stocks/financial-highlights/" + tickerSymbol).get();

            docZacks = Jsoup.connect("https://www.zacks.com/stock/quote/" + tickerSymbol + "/financial-overview").get();

            docYahoo = Jsoup.connect("https://finance.yahoo.com/quote/" + tickerSymbol + "/key-statistics").get();

            Elements bChildrerOfTd = doc.select("td > b");

            Elements financialHighlightsElements = docReuters.select("[cellpadding='1'][cellspacing='0'] td.data");

            Elements zachFinancialOveriewElements = docZacks.select("#financial_overview_details td");

            Elements yahooQtyRevYoyElement = docYahoo.select("[data-reactid='161']");
            
            Elements industryElement = doc.select("tbody .fullview-links[align='center'] .tab-link");

            buildMap(bChildrerOfTd, financialHighlightsElements, zachFinancialOveriewElements, yahooQtyRevYoyElement, industryElement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return map.get(key);
    }

    public String getValue(CharastericsName key) {
        return map.get(key);
    }

    private void buildMap(Elements elements, Elements financialHighlightsElements, Elements zachFinancialOveriewElements, Elements yahooQtyRevYoyElement, Elements industryElement) {

//        map.put("priceToSalePercentReverse", Reuters.getPercentileElement(financialHighlightsElements, 12, true));
//        map.put("priceToBookPercentReverse", Reuters.getPercentileElement(financialHighlightsElements, 15, true));
//        map.put("priceToCashFLowPercentReverse", Reuters.getPercentileElement(financialHighlightsElements, 21, true));
//        
//        map.put("salesGrowthQtrPercent", Reuters.getPercentileElement(financialHighlightsElements, 39, false));
//        map.put("salesGrowthYearPercent", Reuters.getPercentileElement(financialHighlightsElements, 42, false));
//        map.put("epsGrowthQtrPercent", Reuters.getPercentileElement(financialHighlightsElements, 48, false));
//        map.put("epsGrowthYearPercent", Reuters.getPercentileElement(financialHighlightsElements, 51, false));
//        map.put("quickRatioPercent", Reuters.getPercentileElement(financialHighlightsElements, 60, false));
//        map.put("currentRatioPercent", Reuters.getPercentileElement(financialHighlightsElements, 63, false));
//        map.put("longTermDebtToEquityPercentReverse", Reuters.getPercentileElement(financialHighlightsElements, 66, false));
//        map.put("totalDebtToEquityPercentReverse", Reuters.getPercentileElement(financialHighlightsElements, 69, false));
//        map.put("interestCoveragePercent", Reuters.getPercentileElement(financialHighlightsElements, 72, false));
//        map.put("grossMarginPercent", Reuters.getPercentileElement(financialHighlightsElements, 75, false));
//        map.put("ebitaMarginPercent", Reuters.getPercentileElement(financialHighlightsElements, 81, false));
//        map.put("operatingMarginPercent", Reuters.getPercentileElement(financialHighlightsElements, 87, false));
//        map.put("preTaxMarginPercent", Reuters.getPercentileElement(financialHighlightsElements, 96, false));
//        map.put("netMarginPercent", Reuters.getPercentileElement(financialHighlightsElements, 99, false));
//        map.put("returnOnInvestmentPercent", Reuters.getPercentileElement(financialHighlightsElements, 132, false));
//        map.put("returnOnEquityPercent", Reuters.getPercentileElement(financialHighlightsElements, 138, false));
//        

        map.put("epsVsPreviousYear", Zacks.getCharacteristic(zachFinancialOveriewElements, 7));

//        map.put("QtyRevenueGrowthYoy", Yahoo.getYahooQtyRevenueYoyElement(yahooQtyRevYoyElement));

        // index + 1 here
        map.put("currentRatio", finviz.getCharacteristic(elements, 50, false));
        map.put("epsGrowthLastFiveYears", finviz.getCharacteristic(elements, 39, true));
        map.put("epsGrowthThisYear", finviz.getCharacteristic(elements, 21, true));
        map.put("epsGrowthTtm", finviz.getCharacteristic(elements, 3, true));
        map.put("espGrowthQtrOverQtr", finviz.getCharacteristic(elements, 57, true));
        map.put("debtToEquity", finviz.getCharacteristic(elements, 56, false));
        map.put("dividendYield", finviz.getCharacteristic(elements, 43, true));
        map.put("grossMargin", finviz.getCharacteristic(elements, 46, true));
        map.put("longTermDebtToEquity", finviz.getCharacteristic(elements, 62, false));
        map.put("marketCap", finviz.getCharacteristic(elements, 7, true));
        map.put("netProfitMargin", finviz.getCharacteristic(elements, 58, true));
        map.put("pb", finviz.getCharacteristic(elements, 26, false));
        map.put("pe", finviz.getCharacteristic(elements, 2, false));
        map.put("peg", finviz.getCharacteristic(elements, 14, false));
        map.put("price", finviz.getCharacteristic(elements, 66, false));
        map.put("returnOnAsset", finviz.getCharacteristic(elements, 28, true));
        map.put("returnOnEquity", finviz.getCharacteristic(elements, 34, true));
        map.put("returnOnInvestment", finviz.getCharacteristic(elements, 40, true));
        map.put("salesGrowthLastFiveYears", finviz.getCharacteristic(elements, 45, true));
        map.put("salesGrowthQtrOverQtr", finviz.getCharacteristic(elements, 51, true));
        
        map.put("industry", finviz.getIndustry(industryElement));
        // System.out.println(map);
    }

}
