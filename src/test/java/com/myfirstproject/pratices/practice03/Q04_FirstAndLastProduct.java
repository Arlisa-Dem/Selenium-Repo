package com.myfirstproject.pratices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q04_FirstAndLastProduct extends TestBase {


    @Test
    public void firstAndLastProductTest(){

 /*
Given
  Go to  https://www.saucedemo.com/
When
  Enter the username  as "standard_user"
And
  Enter the password as "secret_sauce"
And
  Click on login button
And
  Order products by "Price (low to high)"
Then
  Assert that last product costs $49.99, first product costs $7.99
 */

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        //Order
        WebElement dropDown = driver.findElement(By.xpath("//select"));
        new Select(dropDown).selectByValue("lohi");

        //Assert
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        String lowestPrice = prices.get(0).getText();
        System.out.println("lowestPrice = " + lowestPrice);
        String highestPrice = prices.get(prices.size()-1).getText();
        System.out.println("highestPrice = " + highestPrice);

        assertEquals("$49.99",highestPrice);
        assertEquals("$7.99",lowestPrice);

    }
}
