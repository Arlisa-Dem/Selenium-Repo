package com.myfirstproject.pratices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q04_HoverOver extends TestBase {
  /*
Given
     Go to https://www.gmibank.com/
When
     Hover over "Premium" Deposit Package
And
     Click on "Book Now"
Then
     Verify url contains "services"
 */

    @Test
    public void test() throws InterruptedException {


        driver.get("https://www.gmibank.com/");

        WebElement premium = driver.findElement(By.xpath("//h4[.='Premium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(premium).perform();
        Thread.sleep(3000);


        //        Click on "Book Now"
        driver.findElement(By.xpath("(//a[.='Book Now'])[2]")).click();


        //        Verify url contains "services"
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("services"));
}
}
