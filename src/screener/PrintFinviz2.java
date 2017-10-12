package screener;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PrintFinviz2 {

    Finviz finviz = new Finviz();

    Fidelity fidelity = new Fidelity();

    private final Map<String, String> map;

    private Document doc = null;

    private Document docFidelity = null;

    public PrintFinviz2(String tickerSymbol) {
        map = new HashMap<>();
        try {
            doc = Jsoup.connect("https://finviz.com/quote.ashx?t=" + tickerSymbol).get();
            docFidelity = Jsoup.connect("https://eresearch.fidelity.com/eresearch/evaluate/fundamentals/keyStatistics.jhtml?stockspage=keyStatistics&symbols="
                    + tickerSymbol).get();
            Elements bChildrerOfTd = doc.select("td > b");

            Elements percentileElement = docFidelity.select("td.right");
            Elements tickerElement = docFidelity.select("td.lft-rt-border");
            // System.out.println(tickerElement);
            // System.out.println(percentileElement);
            buildMap(bChildrerOfTd, percentileElement, tickerElement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return map.get(key);
    }

    private void buildMap(Elements elements, Elements percentileElement, Elements tickerElement) {

        map.put("currentRatio", finviz.getCharacteristic(elements, 50, false));
        map.put("epsGrowthLastFiveYears", finviz.getCharacteristic(elements, 39, true));
        map.put("epsGrowthThisYear", finviz.getCharacteristic(elements, 21, true));
        map.put("epsGrowthTtm", Fidelity.getTickerElements(tickerElement, 13));
        map.put("espGrowthQtrOverQtr", finviz.getCharacteristic(elements, 57, true));
        map.put("debtToCapital", Fidelity.getTickerElements(tickerElement, 47));
        // map.put("debtToCapitalPercentileReverse",
        // Fidelity.getPercentileElement(percentileElement, 141, true));
        map.put("debtToEquity", finviz.getCharacteristic(elements, 56, false));
        map.put("dividendYield", finviz.getCharacteristic(elements, 43, true));
        map.put("EbitdMarginPercentile", Fidelity.getPercentileElement(percentileElement, 84, false));
        map.put("grossMargin", finviz.getCharacteristic(elements, 46, true));
        map.put("grossMarginPercentile", Fidelity.getPercentileElement(percentileElement, 81, false));
        map.put("longTermDebtToEquity", finviz.getCharacteristic(elements, 62, false));
        map.put("marketCap", finviz.getCharacteristic(elements, 7, true));
        map.put("netProfitMargin", finviz.getCharacteristic(elements, 58, true));
        map.put("operationMargingPercentile", Fidelity.getPercentileElement(percentileElement, 93, false));
        map.put("pb", finviz.getCharacteristic(elements, 26, false));
        map.put("pe", finviz.getCharacteristic(elements, 2, false));
        map.put("pePercentileReverse", Fidelity.getPercentileElement(percentileElement, 6, true));
        map.put("peg", finviz.getCharacteristic(elements, 14, false));
        map.put("pretaxMargingPercentile", Fidelity.getPercentileElement(percentileElement, 99, false));
        map.put("price", finviz.getCharacteristic(elements, 66, false));
        map.put("priceToBook", Fidelity.getTickerElements(tickerElement, 10));
        map.put("priceToBookPercentileReverse", Fidelity.getPercentileElement(percentileElement, 30, true));
        map.put("priceToCashFlow", Fidelity.getTickerElements(tickerElement, 7));
        map.put("priceToCashFlowPercentileReverse", Fidelity.getPercentileElement(percentileElement, 21, true));
        map.put("priceToSales", Fidelity.getTickerElements(tickerElement, 9));
        map.put("priceToSalesPercentileReverse", Fidelity.getPercentileElement(percentileElement, 27, true));
        map.put("returnOnAsset", finviz.getCharacteristic(elements, 28, true));
        map.put("returnOnAssetFromfidelity", Fidelity.getTickerElements(tickerElement, 39));
        map.put("returnOnAssetsPercentile", Fidelity.getPercentileElement(percentileElement, 117, false));
        map.put("returnOnEquity", finviz.getCharacteristic(elements, 34, true));
        map.put("returnOnEquityPercentile", Fidelity.getPercentileElement(percentileElement, 111, false));
        map.put("returnOnInvestment", finviz.getCharacteristic(elements, 40, true));
        map.put("RevenueGrowthLastQrtrvsSameQrtrPriorYear", Fidelity.getTickerElements(tickerElement, 17));
        map.put("RevenueGrowthTtm", Fidelity.getTickerElements(tickerElement, 18));
        map.put("salesGrowthLastFiveYears", finviz.getCharacteristic(elements, 45, true));
        map.put("salesGrowthQtrOverQtr", finviz.getCharacteristic(elements, 51, true));
        // System.out.println(map);

    }

}
