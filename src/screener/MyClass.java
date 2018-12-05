package screener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class MyClass {

    public static void main(String[] args) throws IOException {
        geResult();
    }

    public static void geResult() throws IOException {
        // Read file
        File destinationFile = new File("fileName.txt");
        Map<String, Double> myMap = new HashMap<>();

        // try {
        List<String> myList = FileUtils.readLines(destinationFile, "UTF-8");

        double qualityOneTotal = 0;
        double qualityTwoTotal = 0;
        double qualityThreeTotal = 0;

        for (String string : myList) {
            // ignore this
            if (string.contains("-")) {
                continue;
            }

            // ignore this
            if (string.contains("null")) {
                continue;
            }

            // Each item is separated by space in text file
            String[] readOneLineAtATime = string.split(" ");

            double itemOne = Double.parseDouble(readOneLineAtATime[2]);

            double itemTwo = Double.parseDouble(readOneLineAtATime[3]);
            double itemThree = Double.parseDouble(readOneLineAtATime[4]);
            double itemFour = Double.parseDouble(readOneLineAtATime[5]);
            double itemFive = Double.parseDouble(readOneLineAtATime[6]);
            double itemSeven = Double.parseDouble(readOneLineAtATime[7]);

            if (itemTwo > 20 && itemThree > 25 && itemFour > 17 && itemFive > 25 && itemSeven > 20)

            {
                double qualityOne = (itemTwo + itemThree) / 2;
                double qualityTwo = (itemFive + itemSeven) / 2;

                // Iterating first time to get following values
                qualityOneTotal = qualityOneTotal + qualityOne;
                qualityTwoTotal = qualityTwoTotal + qualityTwo;
                qualityThreeTotal = qualityThreeTotal + itemFour;

            }
        }

        /**
         * I want to iterate through each item again, do some calculations and
         * put it in the map to do something with it. I am thinking about
         * doing this, but it feels clunky. How do I optimize it?
         * 
         */

        for (String string : myList) {
            // ignore this
            if (string.contains("-")) {
                continue;
            }

            // ignore this
            if (string.contains("null")) {
                continue;
            }

            // Each item is separated by space in text file
            String[] readOneLineAtATime = string.split(" ");

            double itemOne = Double.parseDouble(readOneLineAtATime[2]);

            double itemTwo = Double.parseDouble(readOneLineAtATime[3]);
            double itemThree = Double.parseDouble(readOneLineAtATime[4]);
            double itemFour = Double.parseDouble(readOneLineAtATime[5]);
            double itemFive = Double.parseDouble(readOneLineAtATime[6]);
            double itemSeven = Double.parseDouble(readOneLineAtATime[7]);

            if (itemTwo > 20 && itemThree > 25 && itemFour > 17 && itemFive > 25 && itemSeven > 20)

            {
                double qualityOne = (itemTwo + itemThree) / 2;
                double qualityTwo = (itemFive + itemSeven) / 2;

                // Iterating second time to get this result and putting it
                // in the map
                double result = 0;
                result = qualityOne / qualityOneTotal + qualityTwo / qualityTwoTotal + itemFour / qualityThreeTotal;

                myMap.put(readOneLineAtATime[0], result);
            }

        }

    }
}
