package screener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import model.CharastericsName;

public class MyFinvizHashMap {

    Finviz finviz = new Finviz();

    private final Map<String, String> map;

    private Document doc = null;

    public MyFinvizHashMap(String tickerSymbol) {
        map = new HashMap<>();
        try {
            doc = Jsoup.connect("https://finviz.com/quote.ashx?t=" + tickerSymbol).get();

            Elements bChildrerOfTd = doc.select("td > b");
            Elements industryElement = doc.select("tbody .fullview-links[align='center'] .tab-link");
//            System.out.println(bChildrerOfTd);

            buildMap(bChildrerOfTd, industryElement);
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

    private void buildMap(Elements elements, Elements industryElement) {

        map.put("currentRatio", finviz.getCharacteristic(elements, 50, false));
        map.put("epsGrowthLastFiveYears", finviz.getCharacteristic(elements, 39, true));
        map.put("epsGrowthThisYear", finviz.getCharacteristic(elements, 21, true));
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
        // System.out.println(map);
        
        map.put("industry", finviz.getIndustry(industryElement));
        map.put("industry", finviz.getIndustry(elements));

    }

}
