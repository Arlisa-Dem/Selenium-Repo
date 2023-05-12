package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day09_Example extends TestBase {

    @Test
    public void test(){


//        Given go to file:///C:/Users/TechProEd/Desktop/Html-Css%20Batch132-133/index.html
        driver.get("file:///C:/Users/49163/OneDrive/Desktop/my-html-css/calculator.html");

        driver.switchTo().alert().sendKeys("5");
        driver.switchTo().alert().sendKeys("6");
        System.out.println(driver.switchTo().alert().getText());

//        Click on "Click Here For Regisration Form"
        //driver.findElement(By.partialLinkText("tion Form")).click();


//        Enter username: John
//        Enter password: John.123
//        Fill the form
//        Click Confirm



    }
}
