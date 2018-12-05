package screener;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Reuters {

    public static String getPercentileElement(Elements elements, int index, boolean reverse) {
        Element elementAtIndex = elements.get(index);
        String companyCharacteristic = elementAtIndex.text();

        if (companyCharacteristic.contentEquals("--")) {
            return companyCharacteristic;
        }

        if (companyCharacteristic.contains(",")) {
            // Removes comma (,)
            companyCharacteristic = companyCharacteristic.replace(",", "");
        }

        double companyCharacteristicInt = Double.parseDouble(companyCharacteristic);

        Element elementAtNextIndex = elements.get(index + 1);
        String sectorCharacteristic = elementAtNextIndex.text();

        if (sectorCharacteristic.contentEquals("--")) {
            return sectorCharacteristic;
        }

        if (sectorCharacteristic.contains(",")) {
            // Removes comma (,)
            sectorCharacteristic = sectorCharacteristic.replace(",", "");
        }
        double sectorCharacteristicInt = Double.parseDouble(sectorCharacteristic);

        double percentageDifference = (companyCharacteristicInt - sectorCharacteristicInt) * 100 / sectorCharacteristicInt;

        if (sectorCharacteristicInt < 0) {
            percentageDifference = percentageDifference * -1;
        }

        if (reverse) {
            percentageDifference = -1 * percentageDifference;
        }

        return String.valueOf(percentageDifference);

    }

    public static String getRevenueAndEpsPercentileElement(Elements elements, int index) {
        Element elementAtIndex = elements.get(index);
        String companyCharacteristic = elementAtIndex.text();
        double companyCharacteristicInt = Double.parseDouble(companyCharacteristic);

        Element elementAtNextIndex = elements.get(index + 1);
        String sectorCharacteristic = elementAtNextIndex.text();
        double sectorCharacteristicInt = Double.parseDouble(sectorCharacteristic);

        double percentageDifference = (companyCharacteristicInt - sectorCharacteristicInt) * 100 / sectorCharacteristicInt;

        return String.valueOf(percentageDifference);

    }

    public static String getRevenueGrowthCompareToLastYear(Elements elements) {

        double last4QtrRevenue = Double.parseDouble(elements.get(0).text()) + Double.parseDouble(elements.get(2).text())
                + Double.parseDouble(elements.get(4).text()) + Double.parseDouble(elements.get(6).text());
        double last4QtrPreviousRevenue = Double.parseDouble(elements.get(8).text()) + Double.parseDouble(elements.get(10).text())
                + Double.parseDouble(elements.get(12).text()) + Double.parseDouble(elements.get(14).text());

        return String.valueOf(((last4QtrRevenue - last4QtrPreviousRevenue) * 100 / last4QtrPreviousRevenue));

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
