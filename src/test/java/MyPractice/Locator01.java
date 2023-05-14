package MyPractice;

import com.github.javafaker.Team;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

        WebElement bodyElement = driver.findElement(By.tagName("body"));
        for (WebElement img : bodyElement.findElements(By.tagName("img"))) {
            String width = img.getAttribute("width");
            String height = img.getAttribute("height");
            if (width.equals("225") && height.equals("225")) {
                // Print the page title
                System.out.println(driver.getTitle());

            }

        }
    }

    /*
   Go to https://amazon.com
   Print all the options in the 'Departments' dropdown on the left side of the search box
   Search for each first five options and print titles
   */
    @Test
    public void titleTest() throws InterruptedException {

        driver.get("https://www.amazon.com");

        Thread.sleep(2000);
        WebElement departmentsTest = driver.findElement(By.name("url"));
        List<WebElement> testOptions = departmentsTest.findElements(By.tagName("option"));
        for (WebElement option : testOptions) {
            System.out.println(option.getText());
        }

        // Search for each first five options and print titles
        for (int i = 1; i <= 5; i++) {


        }
    }
}