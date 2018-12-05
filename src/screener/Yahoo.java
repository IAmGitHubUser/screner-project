package screener;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Yahoo {

    public static String getYahooQtyRevenueYoyElement(Elements elements) {
        Element elementAtIndex = elements.get(0);
        String characteristic = elementAtIndex.text();
        if (characteristic.contains("%")) {
            characteristic = characteristic.substring(0, characteristic.length() - 1);
        }
        return characteristic;

    }

}
