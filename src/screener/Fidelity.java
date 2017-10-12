package screener;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Fidelity {

    public static String getPercentileElement(Elements elements, int index, boolean reverse) {
        Element elementAtIndex = elements.get(index - 1);
        String characteristicWithUnit = elementAtIndex.text();

        if (characteristicWithUnit.contentEquals("--")) {
            return characteristicWithUnit;
        }

        String characteristic = characteristicWithUnit.substring(0, characteristicWithUnit.length() - 2);

        if (reverse == true) {
            int stringToIntPercentile = Integer.parseInt(characteristic);
            int reversePercentile = 100 - stringToIntPercentile;
            String stringReversePercentile = Integer.toString(reversePercentile);
            return stringReversePercentile;
        } else {
            return characteristic;
        }

    }

    public static String getTickerElements(Elements elements, int index) {
        Element elementAtIndex = elements.get(index - 1);
        String characteristicWithUnit = elementAtIndex.text();
        String characteristic;

        // To handle cases where value is like '0.78 10/04/2017' and we do not
        // need date we just need '0.78'
        if (characteristicWithUnit.contains(" ")) {
            int spaceIndexOfcharacteristicWithUnit = characteristicWithUnit.indexOf(" ");
            characteristicWithUnit = characteristicWithUnit.substring(0, spaceIndexOfcharacteristicWithUnit);
        }

        // To remove leading '+'
        char firstCharacter = characteristicWithUnit.charAt(0);
        if (firstCharacter == '+') {
            characteristicWithUnit = characteristicWithUnit.substring(1);
        }

        // to remove percentage in the end; this converts '7,363.32%' to
        // '7,363.32'
        if (characteristicWithUnit.contains("%")) {
            characteristic = characteristicWithUnit.substring(0, characteristicWithUnit.length() - 1);
        } else {

            characteristic = characteristicWithUnit.substring(0, characteristicWithUnit.length());
        }

        // To remove ,
        if (characteristic.contains(",")) {
            characteristic = characteristic.replace(",", "");
        }
        return characteristic;

    }

}
