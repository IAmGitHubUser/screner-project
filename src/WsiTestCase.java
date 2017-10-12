import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sruthi
 *
 *This test case is written under the assumption that 
 *the Williams Sonoma website is up and running and is already tested. 
 *It shall be available for validation and the only test case validated here is to verify the "Save for later" scenario.
 *
 *The "Smeg Variable Temperature Kettle" is selected and added to cart. Then the "Save for later" button is clicked.
 *
 */
public class WsiTestCase
{
    
    static FirefoxDriver driver = null;
    static WebDriverWait wait = null;   

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
    System.setProperty("webdriver.gecko.driver", "/Users/hpatel/Downloads/geckodriver");
    driver= new FirefoxDriver();
    }

    @Before
    public void setUp() throws Exception {      

        //1.  Go to http://www.williams-sonoma.com/             
        driver.get("http://www.williams-sonoma.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,2);
        int isPresent = driver.findElements(By.className("stickyOverlayCloseButton")).size();       
                    
        if (isPresent > 0){             
        Actions action11 = new Actions(driver);
        WebElement test = driver.findElement(By.className("stickyOverlayCloseButton"));
        action11.moveToElement(test).click().build().perform();
        }
        
        //2.  Under Cookware, select Tea Kettles
        Actions action = new Actions(driver);
        WebElement cookware = driver.findElement(By.xpath(".//*[@id='topnav-container']/ul/li[1]/a"));
        action.moveToElement(cookware).perform();           
        
        driver.findElement(By.linkText("Tea Kettles")).click();
        wait = new WebDriverWait(driver,1);
        assertTrue(driver.getTitle().equals("Tea Kettles | Williams Sonoma"));
        
        
        //3.  Select any Tea Kettle     
        driver.findElement(By.linkText("Smeg Variable Temperature Kettle")).click();
        wait = new WebDriverWait(driver,5); 
        assertTrue(driver.getTitle().equals("Smeg Variable Temperature Kettle | Williams Sonoma"));             
        String text = driver.findElement(By.className("subset-attributes")).getText();
        if(text.contains("Select:")){
        Actions action1 = new Actions(driver);
        action1.moveToElement(driver.findElement(By.className("attributeValue"))).click().build().perform() ;
        }
        WebElement qty = driver.findElement(By.className("qty"));
        qty.clear();
        qty.sendKeys("1");  
        Actions action2 = new Actions(driver);
        action2.moveToElement(driver.findElement(By.className("qty"))).perform();
        
        
        //4.  Add to cart       
        driver.findElement(By.xpath(".//*[@id='pip']/main/div/div[5]/div[2]/div[2]/section/div/div/fieldset[1]/button")).click();   
        
        
        // 5.  Press the Checkout button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("anchor-btn-checkout")));
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.id("anchor-btn-checkout"))).click().build().perform();  
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout-page-header")));
        assertTrue(driver.getTitle().equals("Shopping Cart | Williams Sonoma"));        
      
    }
    @Test
    public void testSaveForLater() {
        //6.  On the shopping cart page, on that order line, click ëSave for laterí
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-table-row")));
            String productID = driver.findElement(By.className("cart-table-row-sku")).getText();            
            driver.findElement(By.cssSelector(".moveToSFL.save-for-later-link")).click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("save-for-later-message")));          
            assertTrue(driver.getTitle().equals("Empty Shopping Cart | Williams Sonoma"));
            driver.findElement(By.cssSelector(".save-for-later-message>a")).click();
            
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-table-row-title")) );     
            List<WebElement> element = driver.findElements(By.className("cart-table-row"));     
            for(WebElement ele:element)
            {
                assertTrue(ele.getText().contains(productID));
                assertTrue(driver.findElement(By.xpath(".//*[@id='cartForm']/div[2]/div/div[2]/div[3]/div[2]/div[2]")).getText().equals("1"));
            }
            driver.quit();
    }

}
