package MyPractice;

import com.github.javafaker.Team;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Locator01 extends TestBase {

     /*
    Go to ebay page
    Click on electronics section
    Click on all the images with a Width of 225 and a Length of 225
    Print the page title of each page
    Close the page
     */
    @Test
    public void titlePageTest() throws InterruptedException {

        driver.get("https://www.eBay.com");

        driver.findElement(By.linkText("Electronics")).click();
        Thread.sleep(2000);

        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.className("b-visualnav__img b-visualnav__img__default"));

        Actions actions = new Actions(driver);

        //actions.doubleClick(source,225,225).perform();
    }

//-----------------------------

     /*
    Go to https://amazon.com
    Print all the options in the 'Departments' dropdown on the left side of the search box
    Search for each first five options and print titles
    */
}
