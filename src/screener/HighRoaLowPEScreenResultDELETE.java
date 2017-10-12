package screener;
//package screener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class HighRoaLowPEScreenResult {
//
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/hpatel/Drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://finviz.com/screener.ashx?v=111&f=fa_roa_o25&ft=4");
//        
//        List<String> higherThan25RoaTickerArray = new ArrayList<String>();
//        boolean hasNext = false;
//      
//        
//        int nextTabSize = driver.findElements(By.cssSelector(".tab-link b")).size();
//
//        
//        List<WebElement> elements = driver.findElements(By.className("screener-link-primary"));
//        do {
//            for (WebElement webElement : elements) {
//                String elementsToText = webElement.getText();
//                higherThan25RoaTickerArray.add(elementsToText);
//                if (driver.findElement(By.cssSelector(".tab-link b")).isDisplayed()) {
//                    
//                    JavascriptExecutor jse = (JavascriptExecutor)driver;
//                    jse.executeScript("scroll(0, 250)");
//                    
//                    driver.findElement(By.cssSelector("a.tab-link b")).click();
//                }
//            } 
//        } while (nextTabSize !=0);
//        System.out.println(higherThan25RoaTickerArray);
//    }
//}
