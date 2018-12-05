package screener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import model.CharastericsName;

public class FinvizIndustryPeMap {

    Finviz finviz = new Finviz();

    private final Map<String, String> map;

    private Document doc = null;

    public FinvizIndustryPeMap(String tickerSymbol) {
        map = new HashMap<>();
        try {
            doc = Jsoup.connect("https://finviz.com/groups.ashx?g=industry&v=120&o=pe").get();

            Elements industryNameSelector = doc.select(".body-table a.tab-link");

            buildMap(industryNameSelector);
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

    private void buildMap(Elements elements) {

        map.put("industry", finviz.getIndustry(elements));
    }

}
