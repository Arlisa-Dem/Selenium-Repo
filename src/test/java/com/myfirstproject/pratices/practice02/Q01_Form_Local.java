package com.myfirstproject.pratices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Q01_Form_Local extends TestBase {

    @Test
    public void test() throws InterruptedException {


//        Given go to file:///C:/Users/TechProEd/Desktop/Html-Css%20Batch132-133/index.html
        driver.get("/C:/Users/49163/OneDrive/Desktop/Html-Css Batch132-133.zip");



//        Click on "Click Here For Regisration Form"
        String window1Handle = driver.getWindowHandle();
        driver.findElement(By.partialLinkText("tion Form")).click();

//        Enter username: John
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("a");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

//        Enter password: John.123
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("a");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

//        Fill the form
        //Rest is homework...

//        Click Confirm



    }
}
