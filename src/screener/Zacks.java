package screener;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Zacks {



    public static String getCharacteristic(Elements elements, int index) {
        Element elementAtIndex = elements.get(index);
        String characteristic = elementAtIndex.text();
        String characteristicWithoutUnit = characteristic.replace("%", "");
        return characteristicWithoutUnit;
    }

}
