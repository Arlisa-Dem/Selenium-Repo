package com.myfirstproject.pratices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q03_Alert extends TestBase {

   /*
Given
    Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
When
    Click "CLICK ME" of JavaScript Alert
And
    Get the Alert text
Then
    Verify that message is "I am an alert box!"
When
    Accept Alert
 */

    @Test
    public void test(){


        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

//        Click "CLICK ME" of JavaScript Alert
        driver.findElement(By.id("button1")).click();

//        Get the Alert text
        String alertText = driver.switchTo().alert().getText();

//        Verify that message is "I am an alert box!"
        assertEquals("I am an alert box!", alertText);

//        Accept Alert
        driver.switchTo().alert().accept();
    }
}
